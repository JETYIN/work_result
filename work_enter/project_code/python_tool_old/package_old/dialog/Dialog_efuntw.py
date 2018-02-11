# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_efuntw.ui'
#
# Created: Mon Aug 17 16:46:24 2015
#      by: PyQt4 UI code generator 4.11.3
#
# WARNING! All changes made in this file will be lost!

from PyQt4.QtGui import *  
from PyQt4.QtCore import *  
from PyQt4 import QtCore, QtGui
from xml.etree import ElementTree as ET
from utils import file_operate
from utils.config import ConfigParse
from utils import file_operate, constant

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

class Ui_Dialog_efuntw(object):
    def setupUi(self, Dialog_efuntw):
        Dialog_efuntw.setObjectName(_fromUtf8("Dialog_efuntw"))
        Dialog_efuntw.resize(624, 481)
        self.groupBox_2 = QtGui.QGroupBox(Dialog_efuntw)
        self.groupBox_2.setGeometry(QtCore.QRect(20, 260, 581, 121))
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
        self.groupBox = QtGui.QGroupBox(Dialog_efuntw)
        self.groupBox.setGeometry(QtCore.QRect(20, 20, 581, 211))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_1 = QtGui.QLabel(self.groupBox)
        self.label_1.setGeometry(QtCore.QRect(10, 20, 61, 20))
        self.label_1.setObjectName(_fromUtf8("label_1"))
        self.gameName = QtGui.QLineEdit(self.groupBox)
        self.gameName.setGeometry(QtCore.QRect(130, 20, 291, 20))
        self.gameName.setObjectName(_fromUtf8("gameName"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(10, 50, 81, 20))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.channelType = QtGui.QLineEdit(self.groupBox)
        self.channelType.setGeometry(QtCore.QRect(130, 50, 291, 20))
        self.channelType.setObjectName(_fromUtf8("channelType"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(10, 110, 111, 20))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.efunGameShortName = QtGui.QLineEdit(self.groupBox)
        self.efunGameShortName.setGeometry(QtCore.QRect(130, 110, 291, 20))
        self.efunGameShortName.setObjectName(_fromUtf8("efunGameShortName"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(430, 112, 131, 20))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(10, 140, 111, 20))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.efunAppKey = QtGui.QLineEdit(self.groupBox)
        self.efunAppKey.setGeometry(QtCore.QRect(130, 140, 291, 20))
        self.efunAppKey.setObjectName(_fromUtf8("efunAppKey"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(430, 140, 151, 16))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(10, 80, 81, 20))
        self.label.setObjectName(_fromUtf8("label"))
        self.efunGameCode = QtGui.QLineEdit(self.groupBox)
        self.efunGameCode.setGeometry(QtCore.QRect(130, 80, 291, 20))
        self.efunGameCode.setObjectName(_fromUtf8("efunGameCode"))
        self.label_14 = QtGui.QLabel(self.groupBox)
        self.label_14.setGeometry(QtCore.QRect(430, 80, 91, 16))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.label_15 = QtGui.QLabel(self.groupBox)
        self.label_15.setGeometry(QtCore.QRect(430, 50, 181, 16))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.label_16 = QtGui.QLabel(self.groupBox)
        self.label_16.setGeometry(QtCore.QRect(10, 170, 131, 16))
        self.label_16.setObjectName(_fromUtf8("label_16"))
        self.efunAnnouncementCode = QtGui.QLineEdit(self.groupBox)
        self.efunAnnouncementCode.setGeometry(QtCore.QRect(130, 170, 291, 20))
        self.efunAnnouncementCode.setObjectName(_fromUtf8("efunAnnouncementCode"))
        self.label_13 = QtGui.QLabel(Dialog_efuntw)
        self.label_13.setGeometry(QtCore.QRect(20, 400, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.packageName = QtGui.QLineEdit(Dialog_efuntw)
        self.packageName.setGeometry(QtCore.QRect(60, 400, 541, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.pushButton = QtGui.QPushButton(Dialog_efuntw)
        self.pushButton.setGeometry(QtCore.QRect(260, 440, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))

        self.retranslateUi(Dialog_efuntw)
        QtCore.QMetaObject.connectSlotsByName(Dialog_efuntw)
        
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), Dialog_efuntw.onOkClicked)
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
            self.channelType.setText(channel.get("channelType"))
           
            if channel.get("resVersion") != None:
                self.resVersion.setText(channel.get("resVersion"))
            else:
                self.resVersion.setText("")
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1  
        
        try:
            efunGameConfig=ET.parse(file_operate.getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName()+"/ForRes/values/efunGameConfig.xml"))
             
            efunGameConfigRoot = efunGameConfig.getroot()
 
            for efunGameConfigNode in efunGameConfigRoot:
                if efunGameConfigNode.attrib['name']=="efunGameCode" :
                    self.efunGameCode.setText(efunGameConfigNode.text)
                     
                if efunGameConfigNode.attrib['name']=="efunGameShortName" :
                    self.efunGameShortName.setText(efunGameConfigNode.text)
                     
                if efunGameConfigNode.attrib['name']=="efunAppKey" :
                    self.efunAppKey.setText(efunGameConfigNode.text)
                     
                if efunGameConfigNode.attrib['name']=="efunAnnouncementCode" :
                    self.efunAnnouncementCode.setText(efunGameConfigNode.text)
             
        except Exception,e:
            print e
            print "Error: cannot parse file: efunGameConfig.xml."
            return -1
        
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
            channel.set("channelType", unicode(self.channelType.text()))
            channel.set("resVersion", unicode(self.resVersion.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1 
        
        try:
            efunGameConfig=ET.parse(file_operate.getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName()+"/ForRes/values/efunGameConfig.xml"))
            efunGameConfigRoot = efunGameConfig.getroot()
             
            for efunGameConfigNode in efunGameConfigRoot:
                if efunGameConfigNode.attrib['name']=="efunGameCode" :
                    efunGameConfigNode.text=unicode(self.efunGameCode.text())
                     
                if efunGameConfigNode.attrib['name']=="efunGameShortName" :
                    efunGameConfigNode.text=unicode(self.efunGameShortName.text())
                     
                if efunGameConfigNode.attrib['name']=="efunAppKey" :
                    efunGameConfigNode.text=unicode(self.efunAppKey.text())
                     
                if efunGameConfigNode.attrib['name']=="efunAnnouncementCode" :
                    efunGameConfigNode.text=unicode(self.efunAnnouncementCode.text())
             
            efunGameConfig.write(file_operate.getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName() + "/ForRes/values/efunGameConfig.xml"), "utf-8")
        except Exception,e:
            print e
            print "Error: cannot parse file: efunGameConfig.xml."
            return -1
        
        self.close()

    def retranslateUi(self, Dialog_efuntw):
        Dialog_efuntw.setWindowTitle(_translate("Dialog_efuntw", "Dialog", None))
        self.groupBox_2.setTitle(_translate("Dialog_efuntw", "平台信息", None))
        self.label_7.setText(_translate("Dialog_efuntw", "gameId", None))
        self.label_8.setText(_translate("Dialog_efuntw", "appVersion", None))
        self.label_9.setText(_translate("Dialog_efuntw", "datacenter", None))
        self.label_10.setText(_translate("Dialog_efuntw", "platformType", None))
        self.label_11.setText(_translate("Dialog_efuntw", "resVersion", None))
        self.label_12.setText(_translate("Dialog_efuntw", "platformId", None))
        self.groupBox.setTitle(_translate("Dialog_efuntw", "渠道参数", None))
        self.label_1.setText(_translate("Dialog_efuntw", "gameName", None))
        self.label_2.setText(_translate("Dialog_efuntw", "channelType", None))
        self.label_3.setText(_translate("Dialog_efuntw", "efunGameShortName", None))
        self.label_4.setText(_translate("Dialog_efuntw", "efun游戏编简称", None))
        self.label_5.setText(_translate("Dialog_efuntw", "efunAppKey", None))
        self.label_6.setText(_translate("Dialog_efuntw", "efun密匙", None))
        self.label.setText(_translate("Dialog_efuntw", "efunGameCode", None))
        self.label_14.setText(_translate("Dialog_efuntw", "efun游戏编码", None))
        self.label_15.setText(_translate("Dialog_efuntw", "渠道类型：google|asus", None))
        self.label_16.setText(_translate("Dialog_efuntw", "efunAnnouncementCode", None))
        self.label_13.setText(_translate("Dialog_efuntw", "包名", None))
        self.pushButton.setText(_translate("Dialog_efuntw", "确定", None))
        

class Dialogefuntw(QDialog,Ui_Dialog_efuntw):  
    def __init__(self,parent=None):  
        super(Dialogefuntw,self).__init__(parent)  
        self.setupUi(self)

