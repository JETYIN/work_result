# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'F:\funcellsdk\ReleaseSDK\android_pack_talkingdata\ui\Dialog_efuntw_google.ui'
#
# Created by: PyQt4 UI code generator 4.11.4
#
# WARNING! All changes made in this file will be lost!
from PyQt4 import QtCore, QtGui
from xml.etree import ElementTree as ET
from utils import file_operate
from utils.config import ConfigParse
from utils import file_operate, constant
from PyQt4.QtGui import QDialog

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

class Ui_Dialog_efuntw_google(object):
    def setupUi(self, Dialog_efuntw_google):
        Dialog_efuntw_google.setObjectName(_fromUtf8("Dialog_efuntw_google"))
        Dialog_efuntw_google.resize(625, 469)
        self.packageName = QtGui.QLineEdit(Dialog_efuntw_google)
        self.packageName.setGeometry(QtCore.QRect(60, 230, 541, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.pushButton = QtGui.QPushButton(Dialog_efuntw_google)
        self.pushButton.setGeometry(QtCore.QRect(260, 270, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog_efuntw_google)
        self.groupBox.setGeometry(QtCore.QRect(20, 10, 581, 61))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_1 = QtGui.QLabel(self.groupBox)
        self.label_1.setGeometry(QtCore.QRect(10, 20, 61, 20))
        self.label_1.setObjectName(_fromUtf8("label_1"))
        self.gameName = QtGui.QLineEdit(self.groupBox)
        self.gameName.setGeometry(QtCore.QRect(130, 20, 291, 20))
        self.gameName.setObjectName(_fromUtf8("gameName"))
        self.groupBox_2 = QtGui.QGroupBox(Dialog_efuntw_google)
        self.groupBox_2.setGeometry(QtCore.QRect(20, 90, 581, 121))
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
        self.label_13 = QtGui.QLabel(Dialog_efuntw_google)
        self.label_13.setGeometry(QtCore.QRect(20, 230, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))

        self.retranslateUi(Dialog_efuntw_google)
        QtCore.QMetaObject.connectSlotsByName(Dialog_efuntw_google)
        
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), Dialog_efuntw_google.onOkClicked)
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
            self.gameName.setText(channel.get("gameName"))
#             self.channelType.setText(channel.get("channelType"))
           
            if channel.get("resVersion") != None:
                self.resVersion.setText(channel.get("resVersion"))
            else:
                self.resVersion.setText("")
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1  
        
#         try:
#             efunGameConfig=ET.parse(file_operate.getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName()+"/ForRes/values/efunGameConfig.xml"))
#             
#             efunGameConfigRoot = efunGameConfig.getroot()
# 
#             for efunGameConfigNode in efunGameConfigRoot:
#                 if efunGameConfigNode.attrib['name']=="efunGameCode" :
#                     self.efunGameCode.setText(efunGameConfigNode.text)
#                     
#                 if efunGameConfigNode.attrib['name']=="efunGameShortName" :
#                     self.efunGameShortName.setText(efunGameConfigNode.text)
#                     
#                 if efunGameConfigNode.attrib['name']=="efunAppKey" :
#                     self.efunAppKey.setText(efunGameConfigNode.text)
#                     
#                 if efunGameConfigNode.attrib['name']=="efunAnnouncementCode" :
#                     self.efunAnnouncementCode.setText(efunGameConfigNode.text)
#             
#         except Exception,e:
#             print e
#             print "Error: cannot parse file: efunGameConfig.xml."
#             return -1
        
        return
    
    def onOkClicked(self):
        try:
            #write metadata to ForManifest
            ET.register_namespace('android', constant.androidNS)
            
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
            channel.set("gameName", unicode(self.gameName.text()))
#             channel.set("channelType", unicode(self.channelType.text()))
            channel.set("resVersion", unicode(self.resVersion.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1 
        
#         try:
#             efunGameConfig=ET.parse(file_operate.getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName()+"/ForRes/values/efunGameConfig.xml"))
#             efunGameConfigRoot = efunGameConfig.getroot()
#             
#             for efunGameConfigNode in efunGameConfigRoot:
#                 if efunGameConfigNode.attrib['name']=="efunGameCode" :
#                     efunGameConfigNode.text=unicode(self.efunGameCode.text())
#                     
#                 if efunGameConfigNode.attrib['name']=="efunGameShortName" :
#                     efunGameConfigNode.text=unicode(self.efunGameShortName.text())
#                     
#                 if efunGameConfigNode.attrib['name']=="efunAppKey" :
#                     efunGameConfigNode.text=unicode(self.efunAppKey.text())
#                     
#                 if efunGameConfigNode.attrib['name']=="efunAnnouncementCode" :
#                     efunGameConfigNode.text=unicode(self.efunAnnouncementCode.text())
#             
#             efunGameConfig.write(file_operate.getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName() + "/ForRes/values/efunGameConfig.xml"), "utf-8")
#         except Exception,e:
#             print e
#             print "Error: cannot parse file: efunGameConfig.xml."
#             return -1
        
        self.close()

    def retranslateUi(self, Dialog_efuntw_google):
        Dialog_efuntw_google.setWindowTitle(_translate("Dialog_efuntw_google", "Dialog", None))
        self.pushButton.setText(_translate("Dialog_efuntw_google", "确定", None))
        self.groupBox.setTitle(_translate("Dialog_efuntw_google", "渠道参数", None))
        self.label_1.setText(_translate("Dialog_efuntw_google", "gameName", None))
        self.groupBox_2.setTitle(_translate("Dialog_efuntw_google", "平台信息", None))
        self.label_7.setText(_translate("Dialog_efuntw_google", "gameId", None))
        self.label_8.setText(_translate("Dialog_efuntw_google", "appVersion", None))
        self.label_9.setText(_translate("Dialog_efuntw_google", "datacenter", None))
        self.label_10.setText(_translate("Dialog_efuntw_google", "platformType", None))
        self.label_11.setText(_translate("Dialog_efuntw_google", "resVersion", None))
        self.label_12.setText(_translate("Dialog_efuntw_google", "platformId", None))
        self.label_13.setText(_translate("Dialog_efuntw_google", "包名", None))
        

class Dialogefuntw_google(QDialog,Ui_Dialog_efuntw_google):  
    def __init__(self,parent=None):  
        super(Dialogefuntw_google,self).__init__(parent)  
        self.setupUi(self)

