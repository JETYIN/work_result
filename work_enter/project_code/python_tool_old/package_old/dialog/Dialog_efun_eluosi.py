# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_efun_eluosi.ui'
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

class Ui_Dialog_efun_ru(object):
    def setupUi(self, Dialog_efun_ru):
        Dialog_efun_ru.setObjectName(_fromUtf8("Dialog_efun_ru"))
        Dialog_efun_ru.resize(645, 472)
        self.groupBox = QtGui.QGroupBox(Dialog_efun_ru)
        self.groupBox.setGeometry(QtCore.QRect(20, 30, 581, 161))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_1 = QtGui.QLabel(self.groupBox)
        self.label_1.setGeometry(QtCore.QRect(10, 20, 121, 20))
        self.label_1.setObjectName(_fromUtf8("label_1"))
        self.ShareLinkUrl = QtGui.QLineEdit(self.groupBox)
        self.ShareLinkUrl.setGeometry(QtCore.QRect(190, 20, 291, 20))
        self.ShareLinkUrl.setObjectName(_fromUtf8("ShareLinkUrl"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(10, 50, 151, 20))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.ShareDescrition = QtGui.QLineEdit(self.groupBox)
        self.ShareDescrition.setGeometry(QtCore.QRect(190, 50, 291, 20))
        self.ShareDescrition.setObjectName(_fromUtf8("ShareDescrition"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(10, 80, 101, 20))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.SharePcictureUrl = QtGui.QLineEdit(self.groupBox)
        self.SharePcictureUrl.setGeometry(QtCore.QRect(190, 80, 291, 20))
        self.SharePcictureUrl.setObjectName(_fromUtf8("SharePcictureUrl"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(10, 120, 121, 20))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.ShareCaption = QtGui.QLineEdit(self.groupBox)
        self.ShareCaption.setGeometry(QtCore.QRect(190, 120, 291, 20))
        self.ShareCaption.setObjectName(_fromUtf8("ShareCaption"))
        self.groupBox_2 = QtGui.QGroupBox(Dialog_efun_ru)
        self.groupBox_2.setGeometry(QtCore.QRect(20, 220, 581, 121))
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
        self.pushButton = QtGui.QPushButton(Dialog_efun_ru)
        self.pushButton.setGeometry(QtCore.QRect(270, 430, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.packageName = QtGui.QLineEdit(Dialog_efun_ru)
        self.packageName.setGeometry(QtCore.QRect(60, 380, 541, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.label_13 = QtGui.QLabel(Dialog_efun_ru)
        self.label_13.setGeometry(QtCore.QRect(20, 380, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))

        self.retranslateUi(Dialog_efun_ru)
        self.pushButton.clicked.connect(self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_efun_ru)
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
            self.ShareLinkUrl.setText(channel.get("ShareLinkUrl"))
            self.ShareDescrition.setText(channel.get("ShareDescrition"))
            self.SharePcictureUrl.setText(channel.get("SharePcictureUrl"))
            self.ShareCaption.setText(channel.get("ShareCaption"))
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
            channel.set("ShareLinkUrl", unicode(self.ShareLinkUrl.text()))
            channel.set("ShareDescrition", unicode(self.ShareDescrition.text()))
            channel.set("SharePcictureUrl", unicode(self.SharePcictureUrl.text()))
            channel.set("ShareCaption", unicode(self.ShareCaption.text()))
            channel.set("resVersion", unicode(self.resVersion.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1 
        
        self.close()
    
    
    def retranslateUi(self, Dialog_efun_ru):
        Dialog_efun_ru.setWindowTitle(_translate("Dialog_efun_ru", "Dialog_efun_ru", None))
        self.groupBox.setTitle(_translate("Dialog_efun_ru", "渠道参数", None))
        self.label_1.setText(_translate("Dialog_efun_ru", "ShareLinkUrl", None))
        self.label_2.setText(_translate("Dialog_efun_ru", "ShareDescrition", None))
        self.label_3.setText(_translate("Dialog_efun_ru", "SharePcictureUrl", None))
        self.label_4.setText(_translate("Dialog_efun_ru", "ShareCaption", None))
        self.groupBox_2.setTitle(_translate("Dialog_efun_ru", "平台信息", None))
        self.label_7.setText(_translate("Dialog_efun_ru", "gameId", None))
        self.label_8.setText(_translate("Dialog_efun_ru", "appVersion", None))
        self.label_9.setText(_translate("Dialog_efun_ru", "datacenter", None))
        self.label_10.setText(_translate("Dialog_efun_ru", "platformType", None))
        self.label_11.setText(_translate("Dialog_efun_ru", "resVersion", None))
        self.label_12.setText(_translate("Dialog_efun_ru", "platformId", None))
        self.pushButton.setText(_translate("Dialog_efun_ru", "确定", None))
        self.label_13.setText(_translate("Dialog_efun_ru", "包名", None))

class Dialogefun_ru_google(QDialog,Ui_Dialog_efun_ru):  
    def __init__(self,parent=None):  
        super(Dialogefun_ru_google,self).__init__(parent)  
        self.setupUi(self)
