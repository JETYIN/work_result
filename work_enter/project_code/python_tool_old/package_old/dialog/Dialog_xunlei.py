# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'F:\android_pack_talkingdata\ui\Dialog_xunlei.ui'
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

class Ui_Dialog(object):
    def setupUi(self, Dialog):
        Dialog.setObjectName(_fromUtf8("Dialog"))
        Dialog.resize(468, 499)
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(210, 454, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.label_13 = QtGui.QLabel(Dialog)
        self.label_13.setGeometry(QtCore.QRect(30, 414, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.packageName = QtGui.QLineEdit(Dialog)
        self.packageName.setGeometry(QtCore.QRect(70, 410, 361, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog)
        self.groupBox_4.setGeometry(QtCore.QRect(30, 260, 421, 131))
        self.groupBox_4.setObjectName(_fromUtf8("groupBox_4"))
        self.label_7 = QtGui.QLabel(self.groupBox_4)
        self.label_7.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_7.setObjectName(_fromUtf8("label_7"))
        self.gameId = QtGui.QLineEdit(self.groupBox_4)
        self.gameId.setGeometry(QtCore.QRect(80, 28, 113, 20))
        self.gameId.setObjectName(_fromUtf8("gameId"))
        self.label_8 = QtGui.QLabel(self.groupBox_4)
        self.label_8.setGeometry(QtCore.QRect(220, 28, 61, 16))
        self.label_8.setObjectName(_fromUtf8("label_8"))
        self.platformId = QtGui.QLineEdit(self.groupBox_4)
        self.platformId.setGeometry(QtCore.QRect(300, 28, 113, 20))
        self.platformId.setObjectName(_fromUtf8("platformId"))
        self.label_9 = QtGui.QLabel(self.groupBox_4)
        self.label_9.setGeometry(QtCore.QRect(10, 60, 61, 16))
        self.label_9.setObjectName(_fromUtf8("label_9"))
        self.appVersion = QtGui.QLineEdit(self.groupBox_4)
        self.appVersion.setGeometry(QtCore.QRect(80, 59, 113, 20))
        self.appVersion.setObjectName(_fromUtf8("appVersion"))
        self.label_10 = QtGui.QLabel(self.groupBox_4)
        self.label_10.setGeometry(QtCore.QRect(220, 58, 81, 20))
        self.label_10.setObjectName(_fromUtf8("label_10"))
        self.platformType = QtGui.QLineEdit(self.groupBox_4)
        self.platformType.setGeometry(QtCore.QRect(300, 59, 113, 20))
        self.platformType.setObjectName(_fromUtf8("platformType"))
        self.label_11 = QtGui.QLabel(self.groupBox_4)
        self.label_11.setGeometry(QtCore.QRect(10, 90, 61, 16))
        self.label_11.setObjectName(_fromUtf8("label_11"))
        self.datacenter = QtGui.QLineEdit(self.groupBox_4)
        self.datacenter.setGeometry(QtCore.QRect(80, 90, 113, 20))
        self.datacenter.setObjectName(_fromUtf8("datacenter"))
        self.label_12 = QtGui.QLabel(self.groupBox_4)
        self.label_12.setGeometry(QtCore.QRect(221, 90, 61, 16))
        self.label_12.setObjectName(_fromUtf8("label_12"))
        self.resVersion = QtGui.QLineEdit(self.groupBox_4)
        self.resVersion.setGeometry(QtCore.QRect(300, 89, 113, 20))
        self.resVersion.setObjectName(_fromUtf8("resVersion"))
        self.groupBox = QtGui.QGroupBox(Dialog)
        self.groupBox.setGeometry(QtCore.QRect(30, 20, 421, 221))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(20, 82, 54, 12))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.appKey = QtGui.QLineEdit(self.groupBox)
        self.appKey.setGeometry(QtCore.QRect(110, 48, 231, 20))
        self.appKey.setObjectName(_fromUtf8("appKey"))
        self.niuxGameId = QtGui.QLineEdit(self.groupBox)
        self.niuxGameId.setGeometry(QtCore.QRect(110, 17, 231, 20))
        self.niuxGameId.setObjectName(_fromUtf8("niuxGameId"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(20, 22, 71, 16))
        self.label.setObjectName(_fromUtf8("label"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(20, 52, 54, 12))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.gameName = QtGui.QLineEdit(self.groupBox)
        self.gameName.setGeometry(QtCore.QRect(110, 78, 231, 20))
        self.gameName.setObjectName(_fromUtf8("gameName"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(20, 110, 81, 16))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.exchangeRate = QtGui.QLineEdit(self.groupBox)
        self.exchangeRate.setGeometry(QtCore.QRect(110, 110, 231, 20))
        self.exchangeRate.setObjectName(_fromUtf8("exchangeRate"))
        self.label_14 = QtGui.QLabel(self.groupBox)
        self.label_14.setGeometry(QtCore.QRect(20, 150, 81, 16))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.exchangeUnit = QtGui.QLineEdit(self.groupBox)
        self.exchangeUnit.setGeometry(QtCore.QRect(110, 140, 231, 20))
        self.exchangeUnit.setObjectName(_fromUtf8("exchangeUnit"))
        self.label_15 = QtGui.QLabel(self.groupBox)
        self.label_15.setGeometry(QtCore.QRect(20, 180, 91, 20))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.channelId = QtGui.QLineEdit(self.groupBox)
        self.channelId.setGeometry(QtCore.QRect(110, 180, 231, 20))
        self.channelId.setObjectName(_fromUtf8("channelId"))

        self.retranslateUi(Dialog)
        QtCore.QMetaObject.connectSlotsByName(Dialog)
        
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), Dialog.onOkClicked)
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
            self.niuxGameId.setText(channel.get("niuxGameId"))
            self.channelId.setText(channel.get("channelId"))
            self.exchangeRate.setText(channel.get("exchangeRate"))
            self.exchangeUnit.setText(channel.get("exchangeUnit"))
            self.gameName.setText(channel.get("gameName"))
            self.appKey.setText(channel.get("appKey"))
           
            if channel.get("resVersion") != None:
                self.resVersion.setText(channel.get("resVersion"))
            else:
                self.resVersion.setText("")
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
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
            channel.set("gameId", unicode(self.gameId.text()))
            channel.set("niuxGameId", unicode(self.niuxGameId.text()))
            channel.set("channelId", unicode(self.channelId.text()))
            channel.set("exchangeRate", unicode(self.exchangeRate.text()))
            channel.set("exchangeUnit", unicode(self.exchangeUnit.text()))
            channel.set("appKey", unicode(self.appKey.text()))
            channel.set("resVersion", unicode(self.resVersion.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1 
        
        self.close()

    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog", None))
        self.pushButton.setText(_translate("Dialog", "确定", None))
        self.label_13.setText(_translate("Dialog", "包名", None))
        self.groupBox_4.setTitle(_translate("Dialog", "平台信息", None))
        self.label_7.setText(_translate("Dialog", "gameId", None))
        self.label_8.setText(_translate("Dialog", "platformId", None))
        self.label_9.setText(_translate("Dialog", "appVersion", None))
        self.label_10.setText(_translate("Dialog", "platformType", None))
        self.label_11.setText(_translate("Dialog", "datacenter", None))
        self.label_12.setText(_translate("Dialog", "resVersion", None))
        self.groupBox.setTitle(_translate("Dialog", "渠道信息", None))
        self.label_3.setText(_translate("Dialog", "gameName", None))
        self.label.setText(_translate("Dialog", "niuxGameId", None))
        self.label_2.setText(_translate("Dialog", "appKey", None))
        self.label_6.setText(_translate("Dialog", "exchangeRate", None))
        self.label_14.setText(_translate("Dialog", "exchangeUnit", None))
        self.label_15.setText(_translate("Dialog", "channelId", None))
class Dialogxunlei(QDialog,Ui_Dialog):  
    def __init__(self,parent=None):  
        super(Dialogxunlei,self).__init__(parent)  
        self.setupUi(self)

