# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'F:\svnwork\Libs1\ReleaseSDK\android_pack_talkingdata\ui\Dialog_indofun_mol_pingtai.ui'
#
# Created by: PyQt4 UI code generator 4.11.4
#
# WARNING! All changes made in this file will be lost!

from PyQt4.QtGui import *  
from PyQt4.QtCore import *  
from PyQt4 import QtCore, QtGui
from xml.etree import ElementTree as ET
from utils import file_operate, constant
from utils.config import ConfigParse
from xml.etree.ElementTree import SubElement
from xml.dom import minidom
import codecs
import re

try:
    _fromUtf8 = QtCore.QString.fromUtf8
except AttributeError:
    def _fromUtf8(s):
        return s

try:
    _encoding = QtGui.QApplication.UnicodeUTF8
    def _translate(context, text, disambig):
        return QtGui.QApplication.translate(context, text, disambig, _encoding)
except AttributeError:
    def _translate(context, text, disambig):
        return QtGui.QApplication.translate(context, text, disambig)

class Ui_Dialog_indofun_mol_pingtai(object):
    def setupUi(self, Dialog_indofun_mol_pingtai):
        Dialog_indofun_mol_pingtai.setObjectName(_fromUtf8("Dialog_indofun_mol_pingtai"))
        Dialog_indofun_mol_pingtai.resize(645, 766)
        self.groupBox = QtGui.QGroupBox(Dialog_indofun_mol_pingtai)
        self.groupBox.setGeometry(QtCore.QRect(20, 30, 581, 521))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_1 = QtGui.QLabel(self.groupBox)
        self.label_1.setGeometry(QtCore.QRect(10, 20, 101, 20))
        self.label_1.setObjectName(_fromUtf8("label_1"))
        self.appId = QtGui.QLineEdit(self.groupBox)
        self.appId.setGeometry(QtCore.QRect(140, 20, 291, 20))
        self.appId.setObjectName(_fromUtf8("appId"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(10, 50, 91, 20))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.appKey = QtGui.QLineEdit(self.groupBox)
        self.appKey.setGeometry(QtCore.QRect(140, 50, 291, 20))
        self.appKey.setObjectName(_fromUtf8("appKey"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(10, 120, 101, 20))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.facebook_app_id = QtGui.QLineEdit(self.groupBox)
        self.facebook_app_id.setGeometry(QtCore.QRect(140, 120, 291, 20))
        self.facebook_app_id.setObjectName(_fromUtf8("facebook_app_id"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(10, 80, 101, 20))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.funcellKey_2 = QtGui.QLineEdit(self.groupBox)
        self.funcellKey_2.setGeometry(QtCore.QRect(140, 80, 291, 20))
        self.funcellKey_2.setObjectName(_fromUtf8("funcellKey_2"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(10, 150, 101, 20))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.googleGameAppId = QtGui.QLineEdit(self.groupBox)
        self.googleGameAppId.setGeometry(QtCore.QRect(140, 150, 291, 20))
        self.googleGameAppId.setObjectName(_fromUtf8("googleGameAppId"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(10, 180, 101, 20))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.base64PublicKey = QtGui.QLineEdit(self.groupBox)
        self.base64PublicKey.setGeometry(QtCore.QRect(140, 180, 291, 20))
        self.base64PublicKey.setObjectName(_fromUtf8("base64PublicKey"))
        self.label_14 = QtGui.QLabel(self.groupBox)
        self.label_14.setGeometry(QtCore.QRect(10, 210, 101, 20))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.igaworks_app_key = QtGui.QLineEdit(self.groupBox)
        self.igaworks_app_key.setGeometry(QtCore.QRect(140, 210, 291, 20))
        self.igaworks_app_key.setObjectName(_fromUtf8("igaworks_app_key"))
        self.label_15 = QtGui.QLabel(self.groupBox)
        self.label_15.setGeometry(QtCore.QRect(10, 240, 101, 20))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.igaworks_hash_key = QtGui.QLineEdit(self.groupBox)
        self.igaworks_hash_key.setGeometry(QtCore.QRect(140, 240, 291, 20))
        self.igaworks_hash_key.setObjectName(_fromUtf8("igaworks_hash_key"))
        self.molTestMode = QtGui.QLabel(self.groupBox)
        self.molTestMode.setGeometry(QtCore.QRect(20, 280, 101, 16))
        self.molTestMode.setObjectName(_fromUtf8("molTestMode"))
        self.label_16 = QtGui.QLabel(self.groupBox)
        self.label_16.setGeometry(QtCore.QRect(20, 310, 101, 16))
        self.label_16.setObjectName(_fromUtf8("label_16"))
        self.label_17 = QtGui.QLabel(self.groupBox)
        self.label_17.setGeometry(QtCore.QRect(20, 340, 101, 16))
        self.label_17.setObjectName(_fromUtf8("label_17"))
        self.molTestModeRadio = QtGui.QRadioButton(self.groupBox)
        self.molTestModeRadio.setGeometry(QtCore.QRect(140, 280, 89, 16))
        self.molTestModeRadio.setObjectName(_fromUtf8("molTestModeRadio"))
        self.molReleaseModeRadio = QtGui.QRadioButton(self.groupBox)
        self.molReleaseModeRadio.setGeometry(QtCore.QRect(240, 280, 89, 16))
        self.molReleaseModeRadio.setObjectName(_fromUtf8("molReleaseModeRadio"))
        self.molSecretKeyEdit = QtGui.QLineEdit(self.groupBox)
        self.molSecretKeyEdit.setGeometry(QtCore.QRect(140, 310, 291, 20))
        self.molSecretKeyEdit.setObjectName(_fromUtf8("molSecretKeyEdit"))
        self.molApplicationCodeEdit = QtGui.QLineEdit(self.groupBox)
        self.molApplicationCodeEdit.setGeometry(QtCore.QRect(140, 340, 291, 20))
        self.molApplicationCodeEdit.setObjectName(_fromUtf8("molApplicationCodeEdit"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(20, 370, 171, 16))
        self.label.setFrameShape(QtGui.QFrame.NoFrame)
        self.label.setObjectName(_fromUtf8("label"))
        self.isValuePotion = QtGui.QCheckBox(self.groupBox)
        self.isValuePotion.setGeometry(QtCore.QRect(200, 370, 71, 16))
        self.isValuePotion.setObjectName(_fromUtf8("isValuePotion"))
        self.label_18 = QtGui.QLabel(self.groupBox)
        self.label_18.setGeometry(QtCore.QRect(20, 400, 101, 16))
        self.label_18.setObjectName(_fromUtf8("label_18"))
        self.label_19 = QtGui.QLabel(self.groupBox)
        self.label_19.setGeometry(QtCore.QRect(20, 430, 91, 16))
        self.label_19.setObjectName(_fromUtf8("label_19"))
        self.label_20 = QtGui.QLabel(self.groupBox)
        self.label_20.setGeometry(QtCore.QRect(20, 460, 111, 16))
        self.label_20.setObjectName(_fromUtf8("label_20"))
        self.valuePotionClientId = QtGui.QLineEdit(self.groupBox)
        self.valuePotionClientId.setGeometry(QtCore.QRect(140, 400, 291, 20))
        self.valuePotionClientId.setObjectName(_fromUtf8("valuePotionClientId"))
        self.valuePotionSecretKey = QtGui.QLineEdit(self.groupBox)
        self.valuePotionSecretKey.setGeometry(QtCore.QRect(140, 430, 291, 20))
        self.valuePotionSecretKey.setObjectName(_fromUtf8("valuePotionSecretKey"))
        self.gcmProjectNumber = QtGui.QLineEdit(self.groupBox)
        self.gcmProjectNumber.setGeometry(QtCore.QRect(140, 460, 291, 20))
        self.gcmProjectNumber.setObjectName(_fromUtf8("gcmProjectNumber"))
        self.groupBox_2 = QtGui.QGroupBox(Dialog_indofun_mol_pingtai)
        self.groupBox_2.setGeometry(QtCore.QRect(20, 560, 581, 121))
        self.groupBox_2.setObjectName(_fromUtf8("groupBox_2"))
        self.label_7 = QtGui.QLabel(self.groupBox_2)
        self.label_7.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_7.setObjectName(_fromUtf8("label_7"))
        self.label_8 = QtGui.QLabel(self.groupBox_2)
        self.label_8.setGeometry(QtCore.QRect(10, 60, 71, 16))
        self.label_8.setObjectName(_fromUtf8("label_8"))
        self.label_9 = QtGui.QLabel(self.groupBox_2)
        self.label_9.setGeometry(QtCore.QRect(10, 90, 71, 16))
        self.label_9.setObjectName(_fromUtf8("label_9"))
        self.label_10 = QtGui.QLabel(self.groupBox_2)
        self.label_10.setGeometry(QtCore.QRect(290, 60, 81, 16))
        self.label_10.setObjectName(_fromUtf8("label_10"))
        self.label_11 = QtGui.QLabel(self.groupBox_2)
        self.label_11.setGeometry(QtCore.QRect(290, 90, 71, 16))
        self.label_11.setObjectName(_fromUtf8("label_11"))
        self.label_12 = QtGui.QLabel(self.groupBox_2)
        self.label_12.setGeometry(QtCore.QRect(290, 30, 61, 16))
        self.label_12.setObjectName(_fromUtf8("label_12"))
        self.gameId = QtGui.QLineEdit(self.groupBox_2)
        self.gameId.setGeometry(QtCore.QRect(80, 20, 181, 20))
        self.gameId.setObjectName(_fromUtf8("gameId"))
        self.appVersion = QtGui.QLineEdit(self.groupBox_2)
        self.appVersion.setGeometry(QtCore.QRect(80, 50, 181, 20))
        self.appVersion.setObjectName(_fromUtf8("appVersion"))
        self.datacenter = QtGui.QLineEdit(self.groupBox_2)
        self.datacenter.setGeometry(QtCore.QRect(80, 80, 181, 20))
        self.datacenter.setObjectName(_fromUtf8("datacenter"))
        self.resVersion = QtGui.QLineEdit(self.groupBox_2)
        self.resVersion.setGeometry(QtCore.QRect(370, 80, 161, 20))
        self.resVersion.setObjectName(_fromUtf8("resVersion"))
        self.platformId = QtGui.QLineEdit(self.groupBox_2)
        self.platformId.setGeometry(QtCore.QRect(370, 20, 161, 20))
        self.platformId.setObjectName(_fromUtf8("platformId"))
        self.platformType = QtGui.QLineEdit(self.groupBox_2)
        self.platformType.setGeometry(QtCore.QRect(370, 50, 161, 20))
        self.platformType.setObjectName(_fromUtf8("platformType"))
        self.pushButton = QtGui.QPushButton(Dialog_indofun_mol_pingtai)
        self.pushButton.setGeometry(QtCore.QRect(270, 720, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.packageName = QtGui.QLineEdit(Dialog_indofun_mol_pingtai)
        self.packageName.setGeometry(QtCore.QRect(60, 690, 541, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.label_13 = QtGui.QLabel(Dialog_indofun_mol_pingtai)
        self.label_13.setGeometry(QtCore.QRect(20, 690, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))

        self.retranslateUi(Dialog_indofun_mol_pingtai)
        QtCore.QMetaObject.connectSlotsByName(Dialog_indofun_mol_pingtai)
        
        self.pushButton.clicked.connect(self.onOkClicked)
        
        self.isValuePotion.clicked.connect(self.onSelectClicked);
        
        self.initDialog()
    
    def initDialog(self):
        try:
            #read form ForManifest.xml
            ET.register_namespace('android', constant.androidNS)
            
            #渠道信息        
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()
            
            #平台信息
            platform = root.find("platform")
            self.gameId.setText(platform.get("gameId"))
            self.platformId.setText(platform.get("platformId"))
            self.appVersion.setText(platform.get("appVersion"))
            self.platformType.setText(platform.get("platformType"))
            self.datacenter.setText(platform.get("datacenter"))
            
            app = root.find("app")
            self.packageName.setText(app.get("packageName"))
            
            channel = root.find("channel")
            self.appId.setText(channel.get("appId"))
            self.appKey.setText(channel.get("appKey"))
            self.funcellKey_2.setText(channel.get("funcellKey"))
            self.facebook_app_id.setText(channel.get("facebook_app_id"))
            self.googleGameAppId.setText(channel.get("googleGameAppId"))
            self.base64PublicKey.setText(channel.get("base64PublicKey"))
            self.igaworks_app_key.setText(channel.get("igaworks_app_key"))
            self.igaworks_hash_key.setText(channel.get("igaworks_hash_key"))
            
            #molpay config
            if channel.get("molTestMode") =="true":
                self.molTestModeRadio.setChecked(True)
                self.molReleaseModeRadio.setChecked(False)
            else:
                self.molTestModeRadio.setChecked(False)
                self.molReleaseModeRadio.setChecked(True)
            
            self.molSecretKeyEdit.setText(channel.get("molSecretKey"))
            self.molApplicationCodeEdit.setText(channel.get("molApplicationCode"))
            
            #valuepotion 数据统计SDK
            if channel.get("isValuePotion") =="true":
                self.isValuePotion.setChecked(True)
            else:
                self.isValuePotion.setChecked(False)
            
            isValuePotionStart=self.isValuePotion.isChecked();
            self.valuePotionClientId.setEnabled(isValuePotionStart)
            self.valuePotionSecretKey.setEnabled(isValuePotionStart)
            self.gcmProjectNumber.setEnabled(isValuePotionStart)
            
            self.valuePotionClientId.setText(channel.get("valuePotionClientId"))
            self.valuePotionSecretKey.setText(channel.get("valuePotionSecretKey"))
            self.gcmProjectNumber.setText(channel.get("gcmProjectNumber"))

            if channel.get("resVersion") != None:
                self.resVersion.setText(channel.get("resVersion"))
            else:
                self.resVersion.setText("")
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1  
        
        return
    
    def onSelectClicked(self):
        isValuePotionStart=self.isValuePotion.isChecked();
            
        self.valuePotionClientId.setEnabled(isValuePotionStart)
        self.valuePotionSecretKey.setEnabled(isValuePotionStart)
        self.gcmProjectNumber.setEnabled(isValuePotionStart)
    
    def onOkClicked(self):
        try:
            #write metadata to ForManifest
            ET.register_namespace('android', constant.androidNS)
            
            doc = minidom.parse(file_operate.getForManifestXmlPath())
            rootNode = doc.documentElement
            applicationList = rootNode.getElementsByTagName('applicationCfg')
            for applicationNode in applicationList:
                receiverList = applicationNode.getElementsByTagName('receiver')
                for receiverNode in receiverList:
                    if receiverNode.getAttribute('android:name') == 'com.valuepotion.sdk.push.GcmBroadcastReceiver':
                        intentfilterList = receiverNode.getElementsByTagName('intent-filter')
                        for intentfilterNode in intentfilterList:
                            categoryList = intentfilterNode.getElementsByTagName('category')
                            for categoryNode in categoryList:
                                categoryNode.setAttribute('android:name', unicode(self.packageName.text()))
                    
            permissionList = rootNode.getElementsByTagName('permissionCfg')
            for permissionNode in permissionList:
                pattern  = re.compile(".+\.permission\.C2D_MESSAGE")
                uses_permissionList = permissionNode.getElementsByTagName('uses-permission')
                for uses_permissionNode in uses_permissionList:
                    if pattern.match(uses_permissionNode.getAttribute('android:name')):
                        uses_permissionNode.setAttribute('android:name',unicode(self.packageName.text())+'.permission.C2D_MESSAGE')
                
                permissionlist = permissionNode.getElementsByTagName('permission')
                for permissionnode in permissionlist:
                    if pattern.match(permissionnode.getAttribute('android:name')):
                        permissionnode.setAttribute('android:name',unicode(self.packageName.text())+'.permission.C2D_MESSAGE')
                    
            f = codecs.open(file_operate.getForManifestXmlPath(), 'w', 'utf-8')
            doc.writexml(f, encoding='utf-8')
            f.close()
            
            #渠道信息
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()
            
            #平台信息
            platform = root.find("platform")
            platform.set("gameId", unicode(self.gameId.text()))
            platform.set("platformId", unicode(self.platformId.text()))
            platform.set("appVersion", unicode(self.appVersion.text()))
            platform.set("platformType", unicode(self.platformType.text()))
            platform.set("datacenter", unicode(self.datacenter.text()))
            
            app = root.find("app")
            app.set("packageName", unicode(self.packageName.text()))
            
            channel = root.find("channel")
            channel.set("appId", unicode(self.appId.text()))
            channel.set("appKey", unicode(self.appKey.text()))
            channel.set("funcellKey", unicode(self.funcellKey_2.text()))
            channel.set("facebook_app_id", unicode(self.facebook_app_id.text()))
            channel.set("googleGameAppId", unicode(self.googleGameAppId.text()))
            channel.set("base64PublicKey", unicode(self.base64PublicKey.text()))
            channel.set("igaworks_app_key", unicode(self.igaworks_app_key.text()))
            channel.set("igaworks_hash_key", unicode(self.igaworks_hash_key.text()))
            channel.set("resVersion", unicode(self.resVersion.text()))
            
            if self.molTestModeRadio.isChecked():
                channel.set("molTestMode","true")
            
            if self.molReleaseModeRadio.isChecked():
                channel.set("molTestMode","false")
            
            channel.set("molSecretKey",unicode(self.molSecretKeyEdit.text()))
            channel.set("molApplicationCode",unicode(self.molApplicationCodeEdit.text()))
            
            #valuepotion 数据统计SDK
            if self.isValuePotion.isChecked():
                channel.set("isValuePotion","true")
            else:
                channel.set("isValuePotion","false")
            
            channel.set("valuePotionClientId",unicode(self.valuePotionClientId.text()))
            channel.set("valuePotionSecretKey",unicode(self.valuePotionSecretKey.text()))
            channel.set("gcmProjectNumber",unicode(self.gcmProjectNumber.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1   
        
        try:
            funcellStringConfig = ET.parse(file_operate.getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName()+"/ForRes/values/fun_strings.xml"))
            funcellStringConfigRoot = funcellStringConfig.getroot()
             
            for funcellStringConfigNode in funcellStringConfigRoot:
                if funcellStringConfigNode.attrib['name']=="googleGameAppId" :
                    funcellStringConfigNode.text=unicode(self.googleGameAppId.text())
                elif funcellStringConfigNode.attrib['name']=="facebook_app_id" :
                    funcellStringConfigNode.text=unicode(self.facebook_app_id.text())
                elif funcellStringConfigNode.attrib['name']=="WWS_CHANNEL":
                    funcellStringConfigNode.text=unicode(self.appId.text())
                elif funcellStringConfigNode.attrib['name']=="igaworks_app_key":
                    funcellStringConfigNode.text=unicode(self.igaworks_app_key.text())
                elif funcellStringConfigNode.attrib['name']=="igaworks_hash_key":
                    funcellStringConfigNode.text=unicode(self.igaworks_hash_key.text())
            funcellStringConfig.write(file_operate.getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName() + "/ForRes/values/fun_strings.xml"), "utf-8")
        except Exception,e:
            print e
            print "Error: cannot parse file: efunGameConfig.xml."
            return -1
        
        self.close()

    def retranslateUi(self, Dialog_indofun_mol_pingtai):
        Dialog_indofun_mol_pingtai.setWindowTitle(_translate("Dialog_indofun_mol_pingtai", "Dialog_funcell_google", None))
        self.groupBox.setTitle(_translate("Dialog_indofun_mol_pingtai", "渠道参数", None))
        self.label_1.setText(_translate("Dialog_indofun_mol_pingtai", "appId", None))
        self.label_2.setText(_translate("Dialog_indofun_mol_pingtai", "appKey", None))
        self.label_3.setText(_translate("Dialog_indofun_mol_pingtai", "facebook_app_id", None))
        self.label_4.setText(_translate("Dialog_indofun_mol_pingtai", "funcellKey", None))
        self.label_5.setText(_translate("Dialog_indofun_mol_pingtai", "googleGameAppId", None))
        self.label_6.setText(_translate("Dialog_indofun_mol_pingtai", "base64PublicKey", None))
        self.label_14.setText(_translate("Dialog_indofun_mol_pingtai", "igaworks_app_key", None))
        self.label_15.setText(_translate("Dialog_indofun_mol_pingtai", "igaworks_hash_key", None))
        self.molTestMode.setText(_translate("Dialog_indofun_mol_pingtai", "MOLPay运行模式", None))
        self.label_16.setText(_translate("Dialog_indofun_mol_pingtai", "molSecretKey", None))
        self.label_17.setText(_translate("Dialog_indofun_mol_pingtai", "molApplicationCode", None))
        self.molTestModeRadio.setText(_translate("Dialog_indofun_mol_pingtai", "测试模式", None))
        self.molReleaseModeRadio.setText(_translate("Dialog_indofun_mol_pingtai", "发布模式", None))
        self.label.setText(_translate("Dialog_indofun_mol_pingtai", "是否开启valuepotion数据统计", None))
        self.isValuePotion.setText(_translate("Dialog_indofun_mol_pingtai", "开启", None))
        self.label_18.setText(_translate("Dialog_indofun_mol_pingtai", "VP_client_id", None))
        self.label_19.setText(_translate("Dialog_indofun_mol_pingtai", "VP_secret_key", None))
        self.label_20.setText(_translate("Dialog_indofun_mol_pingtai", "GCM_project_number", None))
        self.groupBox_2.setTitle(_translate("Dialog_indofun_mol_pingtai", "平台信息", None))
        self.label_7.setText(_translate("Dialog_indofun_mol_pingtai", "gameId", None))
        self.label_8.setText(_translate("Dialog_indofun_mol_pingtai", "appVersion", None))
        self.label_9.setText(_translate("Dialog_indofun_mol_pingtai", "datacenter", None))
        self.label_10.setText(_translate("Dialog_indofun_mol_pingtai", "platformType", None))
        self.label_11.setText(_translate("Dialog_indofun_mol_pingtai", "resVersion", None))
        self.label_12.setText(_translate("Dialog_indofun_mol_pingtai", "platformId", None))
        self.pushButton.setText(_translate("Dialog_indofun_mol_pingtai", "确定", None))
        self.label_13.setText(_translate("Dialog_indofun_mol_pingtai", "包名", None))

class Dialogindofun_mol_pingtai(QDialog,Ui_Dialog_indofun_mol_pingtai):  
    def __init__(self,parent=None):  
        super(Dialogindofun_mol_pingtai,self).__init__(parent)  
        self.setupUi(self)