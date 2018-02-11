# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_appota_yuenan.ui'
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

class Ui_Dialog_appota_yuenan(object):
    def setupUi(self, Dialog_appota_yuenan):
        Dialog_appota_yuenan.setObjectName(_fromUtf8("Dialog_appota_yuenan"))
        Dialog_appota_yuenan.resize(645, 529)
        self.groupBox = QtGui.QGroupBox(Dialog_appota_yuenan)
        self.groupBox.setGeometry(QtCore.QRect(20, 30, 581, 271))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_1 = QtGui.QLabel(self.groupBox)
        self.label_1.setGeometry(QtCore.QRect(10, 20, 121, 20))
        self.label_1.setObjectName(_fromUtf8("label_1"))
        self.twitter_consumer_key = QtGui.QLineEdit(self.groupBox)
        self.twitter_consumer_key.setGeometry(QtCore.QRect(190, 20, 291, 20))
        self.twitter_consumer_key.setObjectName(_fromUtf8("twitter_consumer_key"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(10, 50, 151, 20))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.twitter_consumer_secret = QtGui.QLineEdit(self.groupBox)
        self.twitter_consumer_secret.setGeometry(QtCore.QRect(190, 50, 291, 20))
        self.twitter_consumer_secret.setObjectName(_fromUtf8("twitter_consumer_secret"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(10, 80, 101, 20))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.facebook_app_id = QtGui.QLineEdit(self.groupBox)
        self.facebook_app_id.setGeometry(QtCore.QRect(190, 80, 291, 20))
        self.facebook_app_id.setObjectName(_fromUtf8("facebook_app_id"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(10, 120, 121, 20))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.appsflyer_dev_key = QtGui.QLineEdit(self.groupBox)
        self.appsflyer_dev_key.setGeometry(QtCore.QRect(190, 120, 291, 20))
        self.appsflyer_dev_key.setObjectName(_fromUtf8("appsflyer_dev_key"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(10, 150, 101, 20))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.gmo_apiKey = QtGui.QLineEdit(self.groupBox)
        self.gmo_apiKey.setGeometry(QtCore.QRect(190, 150, 291, 20))
        self.gmo_apiKey.setObjectName(_fromUtf8("gmo_apiKey"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(10, 180, 101, 20))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.gmo_clientId = QtGui.QLineEdit(self.groupBox)
        self.gmo_clientId.setGeometry(QtCore.QRect(190, 180, 291, 20))
        self.gmo_clientId.setObjectName(_fromUtf8("gmo_clientId"))
        self.label_14 = QtGui.QLabel(self.groupBox)
        self.label_14.setGeometry(QtCore.QRect(10, 210, 131, 20))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.crashlytics_ApiKey = QtGui.QLineEdit(self.groupBox)
        self.crashlytics_ApiKey.setGeometry(QtCore.QRect(190, 210, 291, 20))
        self.crashlytics_ApiKey.setObjectName(_fromUtf8("crashlytics_ApiKey"))
        self.label_15 = QtGui.QLabel(self.groupBox)
        self.label_15.setGeometry(QtCore.QRect(10, 240, 131, 20))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.FacebookAppLinkUrl = QtGui.QLineEdit(self.groupBox)
        self.FacebookAppLinkUrl.setGeometry(QtCore.QRect(190, 240, 291, 20))
        self.FacebookAppLinkUrl.setObjectName(_fromUtf8("FacebookAppLinkUrl"))
        self.groupBox_2 = QtGui.QGroupBox(Dialog_appota_yuenan)
        self.groupBox_2.setGeometry(QtCore.QRect(20, 320, 581, 121))
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
        self.pushButton = QtGui.QPushButton(Dialog_appota_yuenan)
        self.pushButton.setGeometry(QtCore.QRect(270, 490, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.packageName = QtGui.QLineEdit(Dialog_appota_yuenan)
        self.packageName.setGeometry(QtCore.QRect(50, 460, 541, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.label_13 = QtGui.QLabel(Dialog_appota_yuenan)
        self.label_13.setGeometry(QtCore.QRect(10, 460, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))

        self.retranslateUi(Dialog_appota_yuenan)
        self.pushButton.clicked.connect(self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_appota_yuenan)
        self.initDialog()
    
    def initDialog(self):
        try:
            #print os.path.abspath('.')
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
            self.twitter_consumer_key.setText(channel.get("twitter_consumer_key"))
            self.twitter_consumer_secret.setText(channel.get("twitter_consumer_secret"))
            self.facebook_app_id.setText(channel.get("facebook_app_id"))
            self.appsflyer_dev_key.setText(channel.get("appsflyer_dev_key"))
            self.gmo_apiKey.setText(channel.get("gmo_apiKey"))
            self.gmo_clientId.setText(channel.get("gmo_clientId"))
            self.crashlytics_ApiKey.setText(channel.get("crashlytics_ApiKey"))
            self.FacebookAppLinkUrl.setText(channel.get("FacebookAppLinkUrl"))
            
            if channel.get("resVersion") != None:
                self.resVersion.setText(channel.get("resVersion"))
            else:
                self.resVersion.setText("")

            #平台信息
            platform = root.find("platform")
            self.gameId.setText(platform.get("gameId"))
            self.platformId.setText(platform.get("platformId"))
            self.appVersion.setText(platform.get("appVersion"))
            self.platformType.setText(platform.get("platformType"))
            self.datacenter.setText(platform.get("datacenter"))
            
            app = root.find("app")
            
            self.packageName.setText(app.get("packageName"))
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        
        return
    
    
    def onOkClicked(self):
        try:
            #print os.path.abspath('.')
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
            channel.set("twitter_consumer_key", unicode(self.twitter_consumer_key.text()))
            channel.set("twitter_consumer_secret", unicode(self.twitter_consumer_secret.text())) 
            channel.set("facebook_app_id", unicode(self.facebook_app_id.text())) 
            channel.set("appsflyer_dev_key", unicode(self.appsflyer_dev_key.text())) 
            channel.set("gmo_apiKey", unicode(self.gmo_apiKey.text())) 
            channel.set("gmo_clientId", unicode(self.gmo_clientId.text())) 
            channel.set("crashlytics_ApiKey", unicode(self.crashlytics_ApiKey.text())) 
            channel.set("FacebookAppLinkUrl", unicode(self.FacebookAppLinkUrl.text())) 
            channel.set("resVersion", unicode(self.resVersion.text()))
            
            #平台信息
            platform = root.find("platform")
            platform.set("gameId", unicode(self.gameId.text()))
            platform.set("platformId", unicode(self.platformId.text()))
            platform.set("appVersion", unicode(self.appVersion.text()))
            platform.set("platformType", unicode(self.platformType.text()))
            platform.set("datacenter", unicode(self.datacenter.text()))

            app = root.find("app")
            app.set("packageName", unicode(self.packageName.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
            #write metadata to ForManifest
            ET.register_namespace('android', constant.androidNS)
            configTree = ET.parse(file_operate.getForManifestXmlPath())
            configRoot = configTree.getroot()
            key = '{' + constant.androidNS + '}name'
            value = '{' + constant.androidNS + '}value'
            applicationCfg = configRoot.find("applicationCfg")
            if applicationCfg is None:
                return
            metaConfigList = applicationCfg.findall("meta-data")
            
            for child in metaConfigList:
                if child.attrib[key] == "FacebookAppLinkUrl":
                    child.set(value, unicode(self.FacebookAppLinkUrl.text()))
                elif child.attrib[key] == "com.gmo.appsflyerKey":
                    child.set(value, unicode(self.appsflyer_dev_key.text()))
                 
            configTree.write(file_operate.getForManifestXmlPath(), "utf-8")
            
            
            doc = minidom.parse(file_operate.getForManifestXmlPath())
            rootNode = doc.documentElement
            applicationList = rootNode.getElementsByTagName('applicationCfg')
            for applicationNode in applicationList:
                receiverList = applicationNode.getElementsByTagName('receiver')
                for receiverNode in receiverList:
                    if receiverNode.getAttribute('android:name') == 'com.gmo.gamesdk.v4.network.GCMBroadcastReceiver':
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
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        
        try:
            funcellStringConfig = ET.parse(file_operate.getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName()+"/ForRes/values/strings.xml"))
            funcellStringConfigRoot = funcellStringConfig.getroot()
             
            for funcellStringConfigNode in funcellStringConfigRoot:
                if funcellStringConfigNode.attrib['name']=="twitter_consumer_key" :
                    funcellStringConfigNode.text=unicode(self.twitter_consumer_key.text())
                elif funcellStringConfigNode.attrib['name']=="twitter_consumer_secret" :
                    funcellStringConfigNode.text=unicode(self.twitter_consumer_secret.text())
                elif funcellStringConfigNode.attrib['name']=="facebook_app_id" :
                    funcellStringConfigNode.text=unicode(self.facebook_app_id.text())
            funcellStringConfig.write(file_operate.getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName() + "/ForRes/values/strings.xml"), "utf-8")
        except Exception,e:
            print e
            print "Error: cannot parse file: efunGameConfig.xml."
            return -1
        
        self.close()
    
    
    def retranslateUi(self, Dialog_appota_yuenan):
        Dialog_appota_yuenan.setWindowTitle(_translate("Dialog_appota_yuenan", "Dialog_appota_yuenan", None))
        self.groupBox.setTitle(_translate("Dialog_appota_yuenan", "渠道参数", None))
        self.label_1.setText(_translate("Dialog_appota_yuenan", "twitter_consumer_key", None))
        self.label_2.setText(_translate("Dialog_appota_yuenan", "twitter_consumer_secret", None))
        self.label_3.setText(_translate("Dialog_appota_yuenan", "facebook_app_id", None))
        self.label_4.setText(_translate("Dialog_appota_yuenan", "appsflyer_dev_key", None))
        self.label_5.setText(_translate("Dialog_appota_yuenan", "gmo_apiKey", None))
        self.label_6.setText(_translate("Dialog_appota_yuenan", "gmo_clientId", None))
        self.label_14.setText(_translate("Dialog_appota_yuenan", "crashlytics_ApiKey", None))
        self.label_15.setText(_translate("Dialog_appota_yuenan", "FacebookAppLinkUrl", None))
        self.groupBox_2.setTitle(_translate("Dialog_appota_yuenan", "平台信息", None))
        self.label_7.setText(_translate("Dialog_appota_yuenan", "gameId", None))
        self.label_8.setText(_translate("Dialog_appota_yuenan", "appVersion", None))
        self.label_9.setText(_translate("Dialog_appota_yuenan", "datacenter", None))
        self.label_10.setText(_translate("Dialog_appota_yuenan", "platformType", None))
        self.label_11.setText(_translate("Dialog_appota_yuenan", "resVersion", None))
        self.label_12.setText(_translate("Dialog_appota_yuenan", "platformId", None))
        self.pushButton.setText(_translate("Dialog_appota_yuenan", "确定", None))
        self.label_13.setText(_translate("Dialog_appota_yuenan", "包名", None))

class Dialogyuenan_appota_pingtai(QDialog,Ui_Dialog_appota_yuenan):
    def __init__(self,parent=None):  
        super(Dialogyuenan_appota_pingtai,self).__init__(parent)  
        self.setupUi(self)
