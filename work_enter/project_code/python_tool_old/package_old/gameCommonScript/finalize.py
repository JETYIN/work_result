#Embedded file name: finalize.py
import os.path
import time
import sys
import re
from xml.etree import ElementTree as ET

def finalize(platformId, channelName, appVersion, resVersion, talkingdata_enable, crash_enable, push_enable):
    renameApk(channelName, appVersion, resVersion, talkingdata_enable, crash_enable, push_enable)


def renameApk(channelName, appVersion, resVersion, talkingdata_enable, crash_enable, push_enable):
    apkPath = getApkPath()
    apkName = os.path.basename(apkPath)
    newApkName = apkName.replace('basepackage', channelName)
    versionIndexStart = newApkName.find('_v')
    versionIndexEnd = newApkName.find('_', versionIndexStart + 1, -1)
    str_content = 'av' + appVersion + '_rv' + resVersion
    str_content = str_content + '_talkingdata' if str(talkingdata_enable) == 'True' else str_content
    str_content = str_content + '_crash' if str(crash_enable) == 'True' else str_content
    str_content = str_content + '_push' if str(push_enable) == 'True' else str_content
    newApkName = '%s%s%s' % (newApkName[:versionIndexStart + 1], str_content, newApkName[versionIndexEnd:])
    index = newApkName.rfind('aligned.apk')
    print newApkName
    if index != -1:
        timeIndexEnd = newApkName.rfind('_')
        tmp = newApkName[:timeIndexEnd - 1]
        timeIndexStart = tmp.rfind('_')
    else:
        timeIndexStart = newApkName.rfind('_')
        timeIndexEnd = newApkName.rfind('.')
    print '%d  %d' % (timeIndexStart, timeIndexEnd)
    strTime = time.strftime('%Y%m%d%H%M%S', time.localtime(time.time()))
    newApkName = '%s%s%s' % (newApkName[:timeIndexStart + 1], strTime, newApkName[timeIndexEnd:])
    os.rename(os.path.join(getFullPath('outapk'), 'apk_' + channelName + '.apk'), os.path.join(getFullPath('outapk'), newApkName))


def getApkPath():
    config = ET.parse(getFullPath('commonconfig.xml'))
    root = config.getroot()
    apk = root.find('apk')
    return apk.get('path')


def getFullPath(filename):
    if os.path.isabs(filename):
        return filename
    dirname = sys.path[0]
    filename = os.path.join(dirname, filename)
    filename = filename.replace('\\', '/')
    filename = re.sub('/+', '/', filename)
    print filename
    return filename


def test():
    str = 'abcstrjdsdfas'
    print str.find('str')
    print str.rfind('str')
