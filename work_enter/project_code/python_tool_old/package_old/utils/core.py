# -*- coding: utf-8 -*-
import file_operate
import operate
import error_operate
from config import ConfigParse
from taskManagerModule import taskManager
import thread
import threading
import platform
from time import sleep
import os
import time
import constant
from xml.etree import ElementTree as ET
from xml.dom import minidom
from xml.etree.ElementTree import SubElement
import modifyManifest
import sys
from distutils.tests.setuptools_build_ext import if_dl
import re
global splitDexFlag
splitDexFlag = False

def main(channel, dict):
    threading.currentThread().setName(channel)
    
    writeConfigToSdkConfigFile(channel, dict)
    
    dictTemp = ConfigParse.shareInstance().ConfigRead(channel)
    platformId = dictTemp.get('platformId')
    appVersion = dictTemp.get('appVersion')
    resVersion = dictTemp.get('resVersion')
    platformType = dictTemp.get('platformType')
    packageName = dictTemp.get('packageName')
    checkBox_isChecked = dict.get('checkBox_isChecked')
    checkBox_2_isChecked = dict.get('checkBox_2_isChecked')
    checkBox_4_isChecked = dict.get('checkBox_4_isChecked')
    checkBox_5_isChecked = dict.get('checkBox_5_isChecked')
    checkBox_voice_isChecked=dict.get('checkBox_voice_isChecked')
    
    comboBox_currentText = dict.get('comboBox_currentText')
    comboBox_3_currentText = dict.get('comboBox_3_currentText')
    comboBox_4_currentText = dict.get('comboBox_4_currentText')
    comboBox_6_currentText = dict.get('comboBox_6_currentText')
    comboBox_voice_currentText= dict.get('comboBox_voice_currentText')
    taskManager.shareInstance().notify(channel, 5)
    
    taskLock = taskManager.shareInstance().getLock()
    
    ret = execGameCommonInitializeScript(channel, platformId, appVersion, resVersion, platformType)
    if ret:
        return
    CreateTmpFolder(channel)
    source = ConfigParse.shareInstance().getApkPath()
#     source = dict.get('ApkPath')
    backupApk(source, channel)
    sourceDir = file_operate.getFullPath(constant.sdkRelatePath + channel)
    targetDir = file_operate.getFullPath(constant.tmpPath + '/' + channel)
    file_operate.copyFiles(sourceDir, targetDir)

    apkFile = targetDir + "/common.apk"
    deDir = targetDir + "/oldApkDir"
    operate.decompileApk_android(apkFile, deDir, taskLock)
    
    processStatistics(channel, checkBox_isChecked, comboBox_4_currentText)
    
    processAdvertising(channel, checkBox_2_isChecked, comboBox_6_currentText)
    
    processCrash(channel, checkBox_4_isChecked, comboBox_currentText) 

    processPush(channel, checkBox_5_isChecked, comboBox_3_currentText) 
    
    processMedia(channel,checkBox_voice_isChecked,comboBox_voice_currentText)

    oldApkDir = targetDir + "/oldApkDir"
    SmaliDir = oldApkDir + "/smali"
    dexFile1 = targetDir + "/classes.dex"
    ret = operate.dexTrans2Smali(dexFile1, SmaliDir, 3)
    
    dexFile2 = targetDir + "/classes2.dex"
    if os.path.exists(dexFile2):
        global splitDexFlag
        splitDexFlag = True
        ret = operate.dexTrans2Smali(dexFile2, SmaliDir, 3)
    if ret:
        return
#     dexFileApk = oldApkDir + "/classes.dex"
#     ret = operate.dexTrans2Smali(dexFileApk, SmaliDir, 3)
#     if ret:
#         return
    # copy res
    if os.path.exists(targetDir + "/ForRes"):
        operate.copyResToApk(targetDir + "/ForRes", oldApkDir + "/res")
    # copy funcellconfig.xml
    file_operate.copyFile(file_operate.getchannelFuncellConfigXmlPath(channel), oldApkDir + "/assets/funcellconfig.xml")
    # copy Assets
    armPath = targetDir + "/ForAssets/so/armeabi"
    armv7Path = targetDir + "/ForAssets/so/armeabi-v7a"
    if os.path.exists(armPath) and os.path.exists(armv7Path):
        operate.copyResToApk(armPath, armv7Path)
        
    if os.path.exists(targetDir + "/ForAssets"):
        operate.copyResToApk(targetDir + "/ForAssets", oldApkDir + "/assets")
    # copy extra
    
    if os.path.exists(targetDir + "/extra"):
        #-----------------六扇门配置-----------------------
        if os.path.exists(targetDir + "/extra/Assets/GameAssets/Resources/Config"):
            execOtherScript(targetDir)
        #----------------------------------------
#         operate.copyResToApk(targetDir+"/extra", oldApkDir+"/assets")
        file_operate.copyFiles(targetDir + "/extra", oldApkDir + "/assets")
    
    # copy libs
    if os.path.exists(targetDir + "/ForLibs"):
        if os.path.exists(oldApkDir + "/lib/armeabi") and os.path.exists(targetDir + "/ForLibs/armeabi"):
            operate.copyResToApk(targetDir + "/ForLibs/armeabi", oldApkDir + "/lib/armeabi")
        if os.path.exists(oldApkDir + "/lib/armeabi-v7a") and os.path.exists(targetDir + "/ForLibs/armeabi-v7a"):
            operate.copyResToApk(targetDir + "/ForLibs/armeabi-v7a", oldApkDir + "/lib/armeabi-v7a")
        if os.path.exists(oldApkDir + "/lib/x86") and os.path.exists(targetDir + "/ForLibs/x86"):
            operate.copyResToApk(targetDir + "/ForLibs/x86", oldApkDir + "/lib/x86")
        if os.path.exists(oldApkDir + "/lib/mips") and os.path.exists(targetDir + "/ForLibs/mips"):
            operate.copyResToApk(targetDir + "/ForLibs/mips", oldApkDir + "/lib/mips")
    
    # �ϲ�AndroidManifest.xml
    manifestFile = oldApkDir + "/AndroidManifest.xml"
    ET.register_namespace('android', constant.androidNS)
    targetTree = ET.parse(manifestFile)
    targetRoot = targetTree.getroot()
    
    haveChanged = modifyManifest.doModify(manifestFile, targetDir + "/ForManifest.xml", targetRoot)
    if haveChanged:
        targetTree.write(manifestFile, 'UTF-8')
    
    
    newPackagename = operate.renameApkPackage(SmaliDir, manifestFile, packageName)
    
    print channel , oldApkDir
    operate.addSplashScreen(channel, targetDir);
    
    ret = execGameCommongameSdkScript(channel, oldApkDir)
    if ret:
        return
    
    # statisticsScript
    statisticsScriptPath = targetDir + "/statisticsScript.pyc"
    if os.path.exists(statisticsScriptPath):
        sys.path.append(targetDir)
        import statisticsScript
        statisticsScript.Script(oldApkDir, newPackagename)
        del sys.modules['statisticsScript']
        sys.path.remove(targetDir)
    
    # advertisingScript
    advertisingScriptPath = targetDir + "/advertisingScript.pyc"
    if os.path.exists(advertisingScriptPath):
        sys.path.append(targetDir)
        import advertisingScript
        advertisingScript.Script(oldApkDir, newPackagename)
        del sys.modules['advertisingScript']
        sys.path.remove(targetDir)
    
    # pushScript
    pushScriptPath = targetDir + "/pushScript.pyc"
    if os.path.exists(pushScriptPath):
        sys.path.append(targetDir)
        import pushScript
        ret = pushScript.script(oldApkDir, newPackagename)
        del sys.modules['pushScript']
        lsPath = []
        for item in sys.path:
            if str(item) == str(targetDir):
                continue
            lsPath.append(item)
        sys.path = lsPath
    
    # sdk����ű�
    scriptPath = targetDir + "/script.pyc"
    if os.path.exists(scriptPath):
        sys.path.append(targetDir)
        import script
        ret = script.script(oldApkDir, newPackagename)
        del sys.modules['script']
        lsPath = []
        for item in sys.path:
            if str(item) == str(targetDir):
                continue
            lsPath.append(item)
        sys.path = lsPath
    
    ret = operate.pushIconIntoApk('', oldApkDir, channel)
    
    operate.modifyGameName(channel, oldApkDir)
    
    ret = operate.produceNewRFile(channel, newPackagename, oldApkDir)
    if ret:
        return
    
    # smali to dex
#     classesDexFile = oldApkDir + "/classes.dex"
#     ret = operate.smaliTrans2dex(SmaliDir, classesDexFile)
#     if ret:
#         return 
    #         if os.path.exists(SmaliDir):
    #             file_operate.delete_file_folder(SmaliDir)
    
    if splitDexFlag == True:
        print '+++++++++++++++++++++++++++++++++++++'
#         operate.splitDex(targetDir, oldApkDir)
        operate.splitDex_old(targetDir, oldApkDir)
        print '+++++++++++++++++++++++++++++++++++++'
        

    operate.rewriteYml(oldApkDir)    
    tempApkName = file_operate.getFullPath(constant.outDir) + "/apk_"+channel+"_unsigned.apk"
    ret = operate.recompileApk(oldApkDir, tempApkName)
    if ret:
        return
    keystoreFile = ConfigParse.shareInstance().getKeystoreFile()
    storepassword = ConfigParse.shareInstance().getKeystorePassword()
    alias = ConfigParse.shareInstance().getKeystoreAlias()
    aliasPasswd = ConfigParse.shareInstance().getKeystoreAliasPassword()
    # def signApk(apkFile, keyStore, storepassword, keyalias, aliaspassword):
    ret = operate.signApk(tempApkName, keystoreFile, storepassword, alias, aliasPasswd)
    print "sign"
    print ret
    if ret:
        return
    
    apkName = file_operate.getFullPath(constant.outDir) + "/apk_" + channel + ".apk" 
    ret = operate.alignAPK(tempApkName, apkName, file_operate.getFullPath(constant.outDir))
    
    ret = execGameCommonFinalizeScript(channel, platformId, appVersion, resVersion, checkBox_isChecked, checkBox_4_isChecked, checkBox_5_isChecked)
    if ret:
        print 'execGameCommonFinalizeScript error:'
        return
    taskManager.shareInstance().notify(channel, 100)
    print "----------------------------%s pack complete!------------------------" % channel


def CreateTmpFolder(channel):
        tmp = file_operate.getFullPath(constant.tmpPath)
        if not os.path.exists(tmp):
            os.makedirs(tmp)
        tmp_channel = file_operate.getFullPath(constant.tmpPath + '/' + channel)
        if os.path.exists(tmp_channel):
            file_operate.delete_file_folder(tmp_channel)
        if not os.path.exists(tmp_channel):
            os.makedirs(tmp_channel)


def backupApk(source, channel):
    outputDir = constant.tmpPath
    backupName = '%s/%s/common.apk' % (outputDir, channel)
    backupName = file_operate.getFullPath(backupName)
    print "backupname" + backupName
    
    if os.path.exists(backupName):
        os.remove(backupName)
    
    print "source " + source
    file_operate.copyFile(source, backupName)

def writeConfigToSdkConfigFile(channel, dictTemp):
    try:
        # write talkingdata to funcellconfig.xml
        checkBox_isChecked = dictTemp.get('checkBox_isChecked')
        checkBox_2_isChecked = dictTemp.get('checkBox_2_isChecked')
        checkBox_4_isChecked = dictTemp.get('checkBox_4_isChecked')
        checkBox_5_isChecked = dictTemp.get('checkBox_5_isChecked')
        comboBox_3_currentText = dictTemp.get('comboBox_3_currentText')
        lineEdit_13_text = dictTemp.get('lineEdit_13_text')
        lineEdit_16_text = dictTemp.get('lineEdit_16_text')
        lineEdit_17_text = dictTemp.get('lineEdit_17_text')
        advertising_appid = dictTemp.get('advertising_appid')
        pushAppKey_text = dictTemp.get('pushAppKey_text')
        pushAppSecret_text = dictTemp.get('pushAppSecret_text')
        
        checkBox_voice_isChecked=dictTemp.get('checkBox_voice_isChecked')
        mediaAppkey_text=dictTemp.get('mediaAppkey_text')
        voiceSecrectKey_text=dictTemp.get('voiceSecrectKey_text')
        
        config = ET.parse(file_operate.getchannelFuncellConfigXmlPath(channel))
        root = config.getroot()
        talkingdata = root.find("talkingdata")
        if checkBox_isChecked:
            talkingdata.set("status", "enable")
        else:
            talkingdata.set("status", "disable")
        talkingdata.set("appId", unicode(lineEdit_13_text))
        
        crash = root.find("crash")
        if checkBox_4_isChecked:
            crash.set("status", "enable")
        else:
            crash.set("status", "disable")
        crash.set("appId", unicode(lineEdit_16_text))
        
        media=root.find("media")
        if checkBox_voice_isChecked:
            media.set("status","enable")
        else:
            media.set("status","disable")
        media.set("appKey",unicode(mediaAppkey_text))
        media.set("appSecret",unicode(voiceSecrectKey_text))
            
        push = root.find("push")
        if checkBox_5_isChecked:
            push.set("status", "enable")
        else:
            push.set("status", "disable")
        push.set("appId", unicode(lineEdit_17_text))
        push.set("appKey", '')
        push.set("appSecret", '')
        if comboBox_3_currentText == u'个推':
            push.set("appKey", unicode(pushAppKey_text))
            push.set("appSecret", unicode(pushAppSecret_text))
        
        advertising = root.find("advertising")
        if advertising == None:
            if checkBox_2_isChecked:
                advertisingNode = SubElement(root, 'advertising')
                advertisingNode.set('appId', unicode(advertising_appid))
                advertisingNode.set('status', 'enable')
        else:
            advertising.set("appId", unicode(advertising_appid))
            if checkBox_2_isChecked:
                advertising.set('status', 'enable')
            else:
                advertising.set('status', 'disable')
                
        config.write(file_operate.getchannelFuncellConfigXmlPath(channel), "utf-8")
    
    except Exception, e:
        print e
        print "Error: cannot parse file: funcellconfig.xml."
        return -1

def execGameCommonInitializeScript(channelName, platformId, appVersion, resVersion, platformType):
    if (os.path.exists(file_operate.getGameCommonScriptPath())):
        
        gameCommonInitScriptBat = file_operate.getGameCommonScriptPath() + "/initialize.bat"
        if (os.path.exists(gameCommonInitScriptBat)):
            cmd = '"%s" "%s" "%s" "%s" "%s"' % (gameCommonInitScriptBat, platformId, channelName, appVersion, resVersion)
            ret = file_operate.execFormatCmd(cmd)
            if ret:
                print "execute initialize.bat error"
                return 1
        gameCommonInitScriptExe = file_operate.getGameCommonScriptPath() + "/initialize.exe"
        if (os.path.exists(gameCommonInitScriptExe)):
            cmd = '"%s" "%s" "%s" "%s" "%s"' % (gameCommonInitScriptExe, platformId, channelName, appVersion, resVersion)
            ret = file_operate.execFormatCmd(cmd)
            if ret:
                print "execute initialize.exe error"
                return 1
        gameCommonInitScriptPyc = file_operate.getGameCommonScriptPath() + "/initialize.pyc"
        if os.path.exists(gameCommonInitScriptPyc):
            sys.path.append(file_operate.getGameCommonScriptPath())
            import initialize
            ret = initialize.initialize(platformId, channelName, platformType, appVersion, resVersion)

def processStatistics(channel, checkBox_isChecked, comboBox_4_currentText):
    if not checkBox_isChecked:
        return
    
    statisticsPath = file_operate.getStatisticsPath()
    thirdStatisticsName = comboBox_4_currentText
    thirdStatisticsPath = statisticsPath + '/' + str(thirdStatisticsName)
    print "..........", thirdStatisticsPath
    file_operate.copyFiles(thirdStatisticsPath + "/jar", constant.tmpPath + '/' + channel + "/jar")
    if platform.system() == 'Windows':
        dxTool = file_operate.getToolPath('dx.bat')
    else:
        dxTool = file_operate.getToolPath('dx')
#     cmd = '"%s" --dex --output="%s" "%s"' % (dxTool, file_operate.getFullPath(constant.tmpPath+'/'+channel+"/classes.dex"), file_operate.getFullPath(constant.tmpPath+'/'+channel+"/jar")) #合并jar
    cmd = '"%s" --multi-dex --dex --output="%s" "%s"' % (dxTool, file_operate.getFullPath(constant.tmpPath + '/' + channel), file_operate.getFullPath(constant.tmpPath + '/' + channel + "/jar"))  # 合并jar
    print "cmd" + cmd
    ret = file_operate.execFormatCmd(cmd)
    if ret:
        error_operate.error(104)
        return
    
    # copy libs
    targetDir = file_operate.getFullPath(constant.tmpPath + '/' + channel)
    oldApkDir = targetDir + "/oldApkDir"
    if os.path.exists(statisticsPath + "/ForLibs"):
        if os.path.exists(oldApkDir + "/lib/armeabi") and os.path.exists(statisticsPath + "/ForLibs/armeabi"):
            operate.copyResToApk(statisticsPath + "/ForLibs/armeabi", oldApkDir + "/lib/armeabi")
        if os.path.exists(oldApkDir + "/lib/armeabi-v7a") and os.path.exists(statisticsPath + "/ForLibs/armeabi-v7a"):
            operate.copyResToApk(statisticsPath + "/ForLibs/armeabi-v7a", oldApkDir + "/lib/armeabi-v7a")
        if os.path.exists(oldApkDir + "/lib/x86") and os.path.exists(statisticsPath + "/ForLibs/x86"):
            operate.copyResToApk(statisticsPath + "/ForLibs/x86", oldApkDir + "/lib/x86")
    
    # copy res
    if os.path.exists(statisticsPath + "/ForRes"):
        operate.copyResToApk(statisticsPath + "/ForRes", oldApkDir + "/res")
    
    if (os.path.exists(thirdStatisticsPath + "/statisticsScript.pyc")):
        file_operate.copyFile(thirdStatisticsPath + "/statisticsScript.pyc", file_operate.getFullPath(constant.tmpPath + '/' + channel) + "/statisticsScript.pyc")
    
    # 合并ForManifest.xml
    manifestFile = file_operate.getFullPath(constant.tmpPath + '/' + channel + "/ForManifest.xml")
    ET.register_namespace('android', constant.androidNS)
    targetTree = ET.parse(manifestFile)
    targetRoot = targetTree.getroot()
    
    haveChanged = modifyManifest.doModifyForManifest(manifestFile, thirdStatisticsPath + "/ForManifest.xml", targetRoot)
    if haveChanged:
        targetTree.write(manifestFile, 'UTF-8')


def processAdvertising(channel, checkBox_2_isChecked, comboBox_6_currentText):
    if not checkBox_2_isChecked:
        return
    
    advertisingPath = file_operate.getAdvertisingPath()
    thirdAdvertisingName = comboBox_6_currentText
    thirdAdvertisingPath = advertisingPath + '/' + str(thirdAdvertisingName)
    print "..........", thirdAdvertisingPath
    file_operate.copyFiles(thirdAdvertisingPath + "/jar", constant.tmpPath + '/' + channel + "/jar")
    if platform.system() == 'Windows':
        dxTool = file_operate.getToolPath('dx.bat')
    else:
        dxTool = file_operate.getToolPath('dx')
#     cmd = '"%s" --dex --output="%s" "%s"' % (dxTool, file_operate.getFullPath(constant.tmpPath+'/'+channel+"/classes.dex"), file_operate.getFullPath(constant.tmpPath+'/'+channel+"/jar")) #合并jar
    cmd = '"%s" --multi-dex --dex --output="%s" "%s"' % (dxTool, file_operate.getFullPath(constant.tmpPath + '/' + channel), file_operate.getFullPath(constant.tmpPath + '/' + channel + "/jar"))  # 合并jar
    print "cmd" + cmd
    ret = file_operate.execFormatCmd(cmd)
    if ret:
        error_operate.error(104)
        return
    
    if (os.path.exists(thirdAdvertisingPath + "/advertisingScript.pyc")):
        file_operate.copyFile(thirdAdvertisingPath + "/advertisingScript.pyc", file_operate.getFullPath(constant.tmpPath + '/' + channel) + "/advertisingScript.pyc")
    
    # 合并ForManifest.xml
    manifestFile = file_operate.getFullPath(constant.tmpPath + '/' + channel + "/ForManifest.xml")
    ET.register_namespace('android', constant.androidNS)
    targetTree = ET.parse(manifestFile)
    targetRoot = targetTree.getroot()
    
    haveChanged = modifyManifest.doModifyForManifest(manifestFile, thirdAdvertisingPath + "/ForManifest.xml", targetRoot)
    if haveChanged:
        targetTree.write(manifestFile, 'UTF-8')

def processCrash(channel, checkBox_4_isChecked, comboBox_currentText):
    if not checkBox_4_isChecked:
        return
    crashPath = file_operate.getCrashPath()
    thirdCrashName = comboBox_currentText
    thirdCrashPath = crashPath + '/' + str(thirdCrashName)
    print "..........", thirdCrashPath
    file_operate.copyFiles(thirdCrashPath + "/jar", constant.tmpPath + '/' + channel + "/jar")
    if platform.system() == 'Windows':
        dxTool = file_operate.getToolPath('dx.bat')
    else:
        dxTool = file_operate.getToolPath('dx')
#     cmd = '"%s" --dex --output="%s" "%s"' % (dxTool, file_operate.getFullPath(constant.tmpPath+'/'+channel+"/classes.dex"), file_operate.getFullPath(constant.tmpPath+'/'+channel+"/jar")) #合并jar
    cmd = '"%s" --multi-dex --dex --output="%s" "%s"' % (dxTool, file_operate.getFullPath(constant.tmpPath + '/' + channel), file_operate.getFullPath(constant.tmpPath + '/' + channel + "/jar"))  # 合并jar
    print "cmd" + cmd
    ret = file_operate.execFormatCmd(cmd)
    if ret:
        error_operate.error(104)
        return
    
    # copy libs
    targetDir = file_operate.getFullPath(constant.tmpPath + '/' + channel)
    oldApkDir = targetDir + "/oldApkDir"
    
    if os.path.exists(thirdCrashPath + "/ForLibs"):
        if os.path.exists(oldApkDir + "/lib/armeabi") and os.path.exists(thirdCrashPath + "/ForLibs/armeabi"):
            operate.copyResToApk(thirdCrashPath + "/ForLibs/armeabi", oldApkDir + "/lib/armeabi")
        if os.path.exists(oldApkDir + "/lib/armeabi-v7a") and os.path.exists(thirdCrashPath + "/ForLibs/armeabi-v7a"):
            operate.copyResToApk(thirdCrashPath + "/ForLibs/armeabi-v7a", oldApkDir + "/lib/armeabi-v7a")
        if os.path.exists(oldApkDir + "/lib/x86") and os.path.exists(thirdCrashPath + "/ForLibs/x86"):
            operate.copyResToApk(thirdCrashPath + "/ForLibs/x86", oldApkDir + "/lib/x86")
    
    # 合并ForManifest.xml
    manifestFile = file_operate.getFullPath(constant.tmpPath + '/' + channel + "/ForManifest.xml")
    ET.register_namespace('android', constant.androidNS)
    targetTree = ET.parse(manifestFile)
    targetRoot = targetTree.getroot()
    
    haveChanged = modifyManifest.doModifyForManifest(manifestFile, thirdCrashPath + "/ForManifest.xml", targetRoot)
    if haveChanged:
        targetTree.write(manifestFile, 'UTF-8')

def processPush(channel, checkBox_5_isChecked, comboBox_3_currentText):
    if not checkBox_5_isChecked:
        return
    pushPath = file_operate.getMediaPath()
    thirdPushName = unicode(comboBox_3_currentText)
    thirdPushPath = pushPath + '/' + thirdPushName
    file_operate.copyFiles(thirdPushPath + "/jar", constant.tmpPath + '/' + channel + "/jar")
    if platform.system() == 'Windows':
        dxTool = file_operate.getToolPath('dx.bat')
    else:
        dxTool = file_operate.getToolPath('dx')
#     cmd = '"%s" --dex --output="%s" "%s"' % (dxTool, file_operate.getFullPath(constant.tmpPath+'/'+channel+"/classes.dex"), file_operate.getFullPath(constant.tmpPath+'/'+channel+"/jar")) #合并jar
    cmd = '"%s" --multi-dex --dex --output="%s" "%s"' % (dxTool, file_operate.getFullPath(constant.tmpPath + '/' + channel), file_operate.getFullPath(constant.tmpPath + '/' + channel + "/jar"))  # 合并jar
    ret = file_operate.execFormatCmd(cmd)
    if ret:
        error_operate.error(104)
        return
    
    # copy libs
    targetDir = file_operate.getFullPath(constant.tmpPath + '/' + channel)
    oldApkDir = targetDir + "/oldApkDir"
    if os.path.exists(thirdPushPath + "/ForLibs"):
        if os.path.exists(oldApkDir + "/lib/armeabi") and os.path.exists(thirdPushPath + "/ForLibs/armeabi"):
            operate.copyResToApk(thirdPushPath + "/ForLibs/armeabi", oldApkDir + "/lib/armeabi")
        if os.path.exists(oldApkDir + "/lib/armeabi-v7a") and os.path.exists(thirdPushPath + "/ForLibs/armeabi-v7a"):
            operate.copyResToApk(thirdPushPath + "/ForLibs/armeabi-v7a", oldApkDir + "/lib/armeabi-v7a")
        if os.path.exists(oldApkDir + "/lib/x86") and os.path.exists(thirdPushPath + "/ForLibs/x86"):
            operate.copyResToApk(thirdPushPath + "/ForLibs/x86", oldApkDir + "/lib/x86")
    
    # copy res
    if os.path.exists(thirdPushPath + "/ForRes"):
        operate.copyResToApk(thirdPushPath + "/ForRes", oldApkDir + "/res")
        
    # copy pushScript
    file_operate.copyFile(thirdPushPath + "/pushScript.pyc", targetDir + "/pushScript.pyc")
    
    # 合并ForManifest.xml
    manifestFile = file_operate.getFullPath(constant.tmpPath + '/' + channel + "/ForManifest.xml")
    ET.register_namespace('android', constant.androidNS)
    targetTree = ET.parse(manifestFile)
    targetRoot = targetTree.getroot()
    
    haveChanged = modifyManifest.doModifyForManifest(manifestFile, thirdPushPath + "/ForManifest.xml", targetRoot)
    if haveChanged:
        targetTree.write(manifestFile, 'UTF-8')
        
#语音
def processMedia(channel, checkBox_voice_isChecked, comboBox_voice_currentText):
    print"----------begin processMedia--------------"
    if not checkBox_voice_isChecked:
        return
    print"----------select path--------------"
    mediaPath = file_operate.getMediaPath()
    print "path= "+comboBox_voice_currentText
    thirdMediaName = unicode(comboBox_voice_currentText)
    thirdMediaPath = mediaPath + '/' + thirdMediaName
    print "thirdMediaPath= "+thirdMediaPath
    file_operate.copyFiles(thirdMediaPath + "/jar", constant.tmpPath + '/' + channel + "/jar")
    print"----------select windows--------------"
    if platform.system() == 'Windows':
        dxTool = file_operate.getToolPath('dx.bat')
    else:
        dxTool = file_operate.getToolPath('dx')
#     cmd = '"%s" --dex --output="%s" "%s"' % (dxTool, file_operate.getFullPath(constant.tmpPath+'/'+channel+"/classes.dex"), file_operate.getFullPath(constant.tmpPath+'/'+channel+"/jar")) #合并jar
    cmd = '"%s" --multi-dex --dex --output="%s" "%s"' % (dxTool, file_operate.getFullPath(constant.tmpPath + '/' + channel), file_operate.getFullPath(constant.tmpPath + '/' + channel + "/jar"))  # 合并jar
    ret = file_operate.execFormatCmd(cmd)
    if ret:
        error_operate.error(104)
        return
    print"-----------copy libs-------------"
    # copy libs
    targetDir = file_operate.getFullPath(constant.tmpPath + '/' + channel)
    oldApkDir = targetDir + "/oldApkDir"
    if os.path.exists(thirdMediaPath + "/ForLibs"):
        if os.path.exists(oldApkDir + "/lib/armeabi") and os.path.exists(thirdMediaPath + "/ForLibs/armeabi"):
            operate.copyResToApk(thirdMediaPath + "/ForLibs/armeabi", oldApkDir + "/lib/armeabi")
        if os.path.exists(oldApkDir + "/lib/armeabi-v7a") and os.path.exists(thirdMediaPath + "/ForLibs/armeabi-v7a"):
            operate.copyResToApk(thirdMediaPath + "/ForLibs/armeabi-v7a", oldApkDir + "/lib/armeabi-v7a")
        if os.path.exists(oldApkDir + "/lib/x86") and os.path.exists(thirdMediaPath + "/ForLibs/x86"):
            operate.copyResToApk(thirdMediaPath + "/ForLibs/x86", oldApkDir + "/lib/x86")
    print"-----------copy res-------------"
     # copy res
    if os.path.exists(thirdMediaPath + "/ForRes"):
        operate.copyResToApk(thirdMediaPath + "/ForRes", oldApkDir + "/res")
        
    print"-----------copy pushScript-------------"    
    # copy pushScript
    file_operate.copyFile(thirdMediaPath + "/pushScript.pyc", targetDir + "/pushScript.pyc")
    print"----------- ForManifest-------------" 
    # 合并ForManifest.xml
    manifestFile = file_operate.getFullPath(constant.tmpPath + '/' + channel + "/ForManifest.xml")
    ET.register_namespace('android', constant.androidNS)
    targetTree = ET.parse(manifestFile)
    targetRoot = targetTree.getroot()
    print"-----------write-------------" 
    haveChanged = modifyManifest.doModifyForManifest(manifestFile, thirdMediaPath + "/ForManifest.xml", targetRoot)
    if haveChanged:
        targetTree.write(manifestFile, 'UTF-8')
    print"-----------comeplete-------------"    

def execGameCommongameSdkScript(channelName, oldApkDir):
    if (os.path.exists(file_operate.getGameCommonScriptPath())):
#         pattern  = re.compile(".+gameSdkScript.pyc$")
#         parentDir = file_operate.getGameCommonScriptPath()
#         for parent, dirnames, filenames in os.walk(parentDir):
#             for filename in filenames:
#                 if pattern.match(filename):
#                     gameCommongameSdkScriptPyc = file_operate.getGameCommonScriptPath() + "/" + filename
#                     if os.path.exists(gameCommongameSdkScriptPyc):
#                         basename = os.path.basename(filename)
#                         exttuple = os.path.splitext(basename)
#                         gameSdkScript = exttuple[0]
#                         print 'gameSdkScript:%s'%gameSdkScript
#                         sys.path.append(file_operate.getGameCommonScriptPath())
#                         print '11111111111111'
#                         import gameSdkScript
#                         print '222222222222'
#                         ret = gameSdkScript.gameSdkScript(oldApkDir,channelName)
#                         print '3333333333333'
#                         del sys.modules[gameSdkScript]
#                         sys.path.remove(file_operate.getGameCommonScriptPath())
        
        gameCommongameSdkScriptPyc = file_operate.getGameCommonScriptPath() + "/gameSdkScript.pyc"
         
        if os.path.exists(gameCommongameSdkScriptPyc):
            sys.path.append(file_operate.getGameCommonScriptPath())
            import gameSdkScript
            ret = gameSdkScript.gameSdkScript(oldApkDir, channelName)
            del sys.modules['gameSdkScript']
            sys.path.remove(file_operate.getGameCommonScriptPath())

def execGameCommonFinalizeScript(channelName, platformId, appVersion, resVersion, checkBox_isChecked, checkBox_4_isChecked, checkBox_5_isChecked):
    if (os.path.exists(file_operate.getGameCommonScriptPath())):
        
        gameCommonFinalizeScriptBat = file_operate.getGameCommonScriptPath() + "/finalize.bat"
        if (os.path.exists(gameCommonFinalizeScriptBat)):
            cmd = '"%s" "%s" "%s" "%s" "%s"' % (gameCommonFinalizeScriptBat, platformId, channelName, appVersion, resVersion)
            ret = file_operate.execFormatCmd(cmd)
            if ret:
                print "execute finalize.bat error"
                return 1
        gameCommonFinalizeScriptExe = file_operate.getGameCommonScriptPath() + "/finalize.exe"
        if (os.path.exists(gameCommonFinalizeScriptExe)):
            cmd = '"%s" "%s" "%s" "%s" "%s"' % (gameCommonFinalizeScriptExe, platformId, channelName, appVersion, resVersion)
            ret = file_operate.execFormatCmd(cmd)
            if ret:
                print "execute finalize.exe error"
                return 1
        gameCommonFinalizeScriptPyc = file_operate.getGameCommonScriptPath() + "/finalize.pyc"
        if os.path.exists(gameCommonFinalizeScriptPyc):
            print "gameCommonFinalize" + file_operate.getGameCommonScriptPath() + "/finalize.pyc"
            sys.path.append(file_operate.getGameCommonScriptPath())
            import finalize
            ret = finalize.finalize(platformId, channelName, appVersion, resVersion, checkBox_isChecked, checkBox_4_isChecked, checkBox_5_isChecked)
            
def execOtherScript(oldApkDir):
        if (os.path.exists(file_operate.getGameCommonScriptPath())):
            otherScriptPyc = file_operate.getGameCommonScriptPath() + "/otherScript.pyc"
            if os.path.exists(otherScriptPyc):
                sys.path.append(file_operate.getGameCommonScriptPath())
                import otherScript
                ret = otherScript.otherScript(oldApkDir)

def deleteWorkspace(channel):
    targetDir = file_operate.getFullPath(constant.tmpPath + '/' + channel)
    if os.path.exists(targetDir):
        file_operate.delete_file_folder(targetDir)
