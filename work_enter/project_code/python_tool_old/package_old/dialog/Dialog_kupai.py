# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_kupai.ui'
#
# Created: Wed Aug 05 14:19:08 2015
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

class Ui_Dialog_kupai(object):
    def setupUi(self, Dialog_kupai):
        Dialog_kupai.setObjectName(_fromUtf8("Dialog_kupai"))
        Dialog_kupai.resize(640, 466)
        self.groupBox = QtGui.QGroupBox(Dialog_kupai)
        self.groupBox.setGeometry(QtCore.QRect(30, 20, 581, 181))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_1 = QtGui.QLabel(self.groupBox)
        self.label_1.setGeometry(QtCore.QRect(20, 30, 54, 12))
        self.label_1.setObjectName(_fromUtf8("label_1"))
        self.appId = QtGui.QLineEdit(self.groupBox)
        self.appId.setGeometry(QtCore.QRect(90, 20, 291, 20))
        self.appId.setObjectName(_fromUtf8("appId"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(20, 60, 54, 12))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.appKey = QtGui.QLineEdit(self.groupBox)
        self.appKey.setGeometry(QtCore.QRect(90, 50, 291, 20))
        self.appKey.setObjectName(_fromUtf8("appKey"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(20, 120, 54, 12))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.waresid = QtGui.QLineEdit(self.groupBox)
        self.waresid.setGeometry(QtCore.QRect(90, 110, 291, 20))
        self.waresid.setObjectName(_fromUtf8("waresid"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(390, 112, 131, 20))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(20, 140, 61, 20))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.screenType = QtGui.QLineEdit(self.groupBox)
        self.screenType.setGeometry(QtCore.QRect(90, 140, 291, 20))
        self.screenType.setObjectName(_fromUtf8("screenType"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(390, 140, 151, 16))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(20, 90, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.payKey = QtGui.QLineEdit(self.groupBox)
        self.payKey.setGeometry(QtCore.QRect(90, 80, 291, 20))
        self.payKey.setObjectName(_fromUtf8("payKey"))
        self.label_14 = QtGui.QLabel(self.groupBox)
        self.label_14.setGeometry(QtCore.QRect(390, 90, 91, 16))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.groupBox_2 = QtGui.QGroupBox(Dialog_kupai)
        self.groupBox_2.setGeometry(QtCore.QRect(30, 220, 581, 121))
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
        self.pushButton = QtGui.QPushButton(Dialog_kupai)
        self.pushButton.setGeometry(QtCore.QRect(270, 410, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.label_13 = QtGui.QLabel(Dialog_kupai)
        self.label_13.setGeometry(QtCore.QRect(30, 370, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.packageName = QtGui.QLineEdit(Dialog_kupai)
        self.packageName.setGeometry(QtCore.QRect(70, 370, 541, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))

        self.retranslateUi(Dialog_kupai)
        QtCore.QMetaObject.connectSlotsByName(Dialog_kupai)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), Dialog_kupai.onOkClicked)
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
            self.payKey.setText(channel.get("payKey"))
            self.waresid.setText(channel.get("waresid"))
            self.screenType.setText(channel.get("screenType"))
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
            channel.set("appId", unicode(self.appId.text()))
            channel.set("appKey", unicode(self.appKey.text()))
            channel.set("payKey", unicode(self.payKey.text()))
            channel.set("waresid", unicode(self.waresid.text()))
            channel.set("screenType", unicode(self.screenType.text()))
            channel.set("resVersion", unicode(self.resVersion.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1 
        
        self.close()
        
    
    
    

    def retranslateUi(self, Dialog_kupai):
        Dialog_kupai.setWindowTitle(_translate("Dialog_kupai", "Dialog", None))
        self.groupBox.setTitle(_translate("Dialog_kupai", "渠道参数", None))
        self.label_1.setText(_translate("Dialog_kupai", "appId", None))
        self.label_2.setText(_translate("Dialog_kupai", "appKey", None))
        self.label_3.setText(_translate("Dialog_kupai", "waresid", None))
        self.label_4.setText(_translate("Dialog_kupai", "商品编号", None))
        self.label_5.setText(_translate("Dialog_kupai", "screenType", None))
        self.label_6.setText(_translate("Dialog_kupai", "横屏=0  竖屏=1", None))
        self.label.setText(_translate("Dialog_kupai", "payKey", None))
        self.label_14.setText(_translate("Dialog_kupai", "应用密匙-支付", None))
        self.groupBox_2.setTitle(_translate("Dialog_kupai", "平台信息", None))
        self.label_7.setText(_translate("Dialog_kupai", "gameId", None))
        self.label_8.setText(_translate("Dialog_kupai", "appVersion", None))
        self.label_9.setText(_translate("Dialog_kupai", "datacenter", None))
        self.label_10.setText(_translate("Dialog_kupai", "platformType", None))
        self.label_11.setText(_translate("Dialog_kupai", "resVersion", None))
        self.label_12.setText(_translate("Dialog_kupai", "platformId", None))
        self.pushButton.setText(_translate("Dialog_kupai", "确定", None))
        self.label_13.setText(_translate("Dialog_kupai", "包名", None))

class Dialogkupai(QDialog,Ui_Dialog_kupai):  
    def __init__(self,parent=None):  
        super(Dialogkupai,self).__init__(parent)  
        self.setupUi(self)
