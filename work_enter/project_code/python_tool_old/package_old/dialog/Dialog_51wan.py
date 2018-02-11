# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_51wan.ui'
#
# Created by: PyQt4 UI code generator 4.11.4
#
# WARNING! All changes made in this file will be lost!

from PyQt4.QtGui import *  
from PyQt4.QtCore import *  
from PyQt4 import QtCore, QtGui
from xml.etree import ElementTree as ET
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

class Ui_Dialog(object):
    def setupUi(self, Dialog):
        Dialog.setObjectName(_fromUtf8("Dialog"))
        Dialog.resize(446, 534)
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(190, 497, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog)
        self.groupBox.setGeometry(QtCore.QRect(30, 30, 401, 201))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.WXAPPID = QtGui.QLabel(self.groupBox)
        self.WXAPPID.setGeometry(QtCore.QRect(20, 60, 91, 16))
        self.WXAPPID.setObjectName(_fromUtf8("WXAPPID"))
        self.WXMCHID = QtGui.QLabel(self.groupBox)
        self.WXMCHID.setGeometry(QtCore.QRect(20, 140, 54, 12))
        self.WXMCHID.setObjectName(_fromUtf8("WXMCHID"))
        self.WXAPPSECRETLe = QtGui.QLineEdit(self.groupBox)
        self.WXAPPSECRETLe.setGeometry(QtCore.QRect(130, 100, 181, 20))
        self.WXAPPSECRETLe.setObjectName(_fromUtf8("WXAPPSECRETLe"))
        self.WXAPPIDLe = QtGui.QLineEdit(self.groupBox)
        self.WXAPPIDLe.setGeometry(QtCore.QRect(130, 60, 181, 20))
        self.WXAPPIDLe.setObjectName(_fromUtf8("WXAPPIDLe"))
        self.WXMCHIDLe = QtGui.QLineEdit(self.groupBox)
        self.WXMCHIDLe.setGeometry(QtCore.QRect(130, 140, 181, 20))
        self.WXMCHIDLe.setObjectName(_fromUtf8("WXMCHIDLe"))
        self.WXAPPSECRET = QtGui.QLabel(self.groupBox)
        self.WXAPPSECRET.setGeometry(QtCore.QRect(20, 100, 54, 12))
        self.WXAPPSECRET.setObjectName(_fromUtf8("WXAPPSECRET"))
        self.appId = QtGui.QLabel(self.groupBox)
        self.appId.setGeometry(QtCore.QRect(20, 30, 91, 16))
        self.appId.setObjectName(_fromUtf8("appId"))
        self.appIdLe = QtGui.QLineEdit(self.groupBox)
        self.appIdLe.setGeometry(QtCore.QRect(130, 30, 181, 20))
        self.appIdLe.setObjectName(_fromUtf8("appIdLe"))
        self.label_13 = QtGui.QLabel(Dialog)
        self.label_13.setGeometry(QtCore.QRect(10, 460, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.package_2 = QtGui.QLineEdit(Dialog)
        self.package_2.setGeometry(QtCore.QRect(50, 456, 361, 20))
        self.package_2.setObjectName(_fromUtf8("package_2"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 310, 421, 121))
        self.groupBox_4.setObjectName(_fromUtf8("groupBox_4"))
        self.label_9 = QtGui.QLabel(self.groupBox_4)
        self.label_9.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_9.setObjectName(_fromUtf8("label_9"))
        self.gameId = QtGui.QLineEdit(self.groupBox_4)
        self.gameId.setGeometry(QtCore.QRect(80, 28, 113, 20))
        self.gameId.setObjectName(_fromUtf8("gameId"))
        self.label_10 = QtGui.QLabel(self.groupBox_4)
        self.label_10.setGeometry(QtCore.QRect(220, 28, 61, 16))
        self.label_10.setObjectName(_fromUtf8("label_10"))
        self.platformId = QtGui.QLineEdit(self.groupBox_4)
        self.platformId.setGeometry(QtCore.QRect(300, 28, 113, 20))
        self.platformId.setObjectName(_fromUtf8("platformId"))
        self.label_11 = QtGui.QLabel(self.groupBox_4)
        self.label_11.setGeometry(QtCore.QRect(10, 60, 61, 16))
        self.label_11.setObjectName(_fromUtf8("label_11"))
        self.appVersion = QtGui.QLineEdit(self.groupBox_4)
        self.appVersion.setGeometry(QtCore.QRect(80, 59, 113, 20))
        self.appVersion.setObjectName(_fromUtf8("appVersion"))
        self.label_12 = QtGui.QLabel(self.groupBox_4)
        self.label_12.setGeometry(QtCore.QRect(220, 58, 81, 20))
        self.label_12.setObjectName(_fromUtf8("label_12"))
        self.platformType = QtGui.QLineEdit(self.groupBox_4)
        self.platformType.setGeometry(QtCore.QRect(300, 59, 113, 20))
        self.platformType.setObjectName(_fromUtf8("platformType"))
        self.label_14 = QtGui.QLabel(self.groupBox_4)
        self.label_14.setGeometry(QtCore.QRect(10, 90, 61, 16))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.datacenter = QtGui.QLineEdit(self.groupBox_4)
        self.datacenter.setGeometry(QtCore.QRect(80, 90, 113, 20))
        self.datacenter.setObjectName(_fromUtf8("datacenter"))
        self.label_15 = QtGui.QLabel(self.groupBox_4)
        self.label_15.setGeometry(QtCore.QRect(221, 90, 61, 16))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.resVersion = QtGui.QLineEdit(self.groupBox_4)
        self.resVersion.setGeometry(QtCore.QRect(300, 89, 113, 20))
        self.resVersion.setObjectName(_fromUtf8("resVersion"))

        self.retranslateUi(Dialog)
        self.pushButton.clicked.connect(self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog)
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
            self.package_2.setText(app.get("packageName"))
            
            channel = root.find("channel")
            self.appIdLe.setText(channel.get("appId"))
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
            app.set("packageName", unicode(self.package_2.text()))
            
            channel = root.find("channel")
            channel.set("appId", unicode(self.appIdLe.text()))
            channel.set("resVersion", unicode(self.resVersion.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1   
        
        self.close()
    
    
    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog_360", None))
        self.pushButton.setText(_translate("Dialog", "确定", None))
        self.groupBox.setTitle(_translate("Dialog", "渠道信息", None))
        self.WXAPPID.setText(_translate("Dialog", "WXAPPID", None))
        self.WXMCHID.setText(_translate("Dialog", "WXMCHID", None))
        self.WXAPPSECRET.setText(_translate("Dialog", "WXAPPSECRET", None))
        self.appId.setText(_translate("Dialog", "appId", None))
        self.label_13.setText(_translate("Dialog", "包名", None))
        self.groupBox_4.setTitle(_translate("Dialog", "平台信息", None))
        self.label_9.setText(_translate("Dialog", "gameId", None))
        self.label_10.setText(_translate("Dialog", "platformId", None))
        self.label_11.setText(_translate("Dialog", "appVersion", None))
        self.label_12.setText(_translate("Dialog", "platformType", None))
        self.label_14.setText(_translate("Dialog", "datacenter", None))
        self.label_15.setText(_translate("Dialog", "resVersion", None))

class Dialog51wan(QDialog,Ui_Dialog):  
    def __init__(self,parent=None):  
        super(Dialog51wan,self).__init__(parent)  
        self.setupUi(self)