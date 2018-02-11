# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_muzhiwan_yyh.ui'
#
# Created: Thu Aug 27 16:32:18 2015
#      by: PyQt4 UI code generator 4.11.2
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

class Ui_Dialog_muzhiwan_yyh(object):
    def setupUi(self, Dialog_muzhiwan_yyh):
        Dialog_muzhiwan_yyh.setObjectName(_fromUtf8("Dialog_muzhiwan_yyh"))
        Dialog_muzhiwan_yyh.resize(645, 396)
        self.groupBox = QtGui.QGroupBox(Dialog_muzhiwan_yyh)
        self.groupBox.setGeometry(QtCore.QRect(20, 40, 581, 131))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_1 = QtGui.QLabel(self.groupBox)
        self.label_1.setGeometry(QtCore.QRect(20, 30, 54, 12))
        self.label_1.setObjectName(_fromUtf8("label_1"))
        self.loginId = QtGui.QLineEdit(self.groupBox)
        self.loginId.setGeometry(QtCore.QRect(90, 20, 181, 20))
        self.loginId.setObjectName(_fromUtf8("loginId"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(20, 60, 54, 12))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.appid = QtGui.QLineEdit(self.groupBox)
        self.appid.setGeometry(QtCore.QRect(90, 50, 181, 20))
        self.appid.setObjectName(_fromUtf8("appid"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(3, 90, 101, 20))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.waresid = QtGui.QLineEdit(self.groupBox)
        self.waresid.setGeometry(QtCore.QRect(100, 90, 181, 20))
        self.waresid.setObjectName(_fromUtf8("waresid"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(280, 20, 54, 12))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.loginkey = QtGui.QLineEdit(self.groupBox)
        self.loginkey.setGeometry(QtCore.QRect(340, 20, 181, 20))
        self.loginkey.setObjectName(_fromUtf8("loginkey"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(283, 50, 61, 20))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.appkey = QtGui.QLineEdit(self.groupBox)
        self.appkey.setGeometry(QtCore.QRect(340, 50, 181, 20))
        self.appkey.setObjectName(_fromUtf8("appkey"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(280, 90, 81, 20))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.orientation = QtGui.QLineEdit(self.groupBox)
        self.orientation.setGeometry(QtCore.QRect(350, 90, 181, 20))
        self.orientation.setObjectName(_fromUtf8("orientation"))
        self.label_14 = QtGui.QLabel(self.groupBox)
        self.label_14.setGeometry(QtCore.QRect(530, 90, 61, 20))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.groupBox_2 = QtGui.QGroupBox(Dialog_muzhiwan_yyh)
        self.groupBox_2.setGeometry(QtCore.QRect(20, 190, 581, 121))
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
        self.pushButton = QtGui.QPushButton(Dialog_muzhiwan_yyh)
        self.pushButton.setGeometry(QtCore.QRect(260, 360, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.packageName = QtGui.QLineEdit(Dialog_muzhiwan_yyh)
        self.packageName.setGeometry(QtCore.QRect(50, 330, 541, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.label_13 = QtGui.QLabel(Dialog_muzhiwan_yyh)
        self.label_13.setGeometry(QtCore.QRect(10, 330, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        
        self.retranslateUi(Dialog_muzhiwan_yyh)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), Dialog_muzhiwan_yyh.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_muzhiwan_yyh)
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
            self.loginId.setText(channel.get("loginid"))
            self.loginkey.setText(channel.get("loginkey"))
            self.appid.setText(channel.get("appid"))
            self.appkey.setText(channel.get("appkey"))
            self.waresid.setText(channel.get("waresid"))
            self.orientation.setText(channel.get("orientation"))
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
            channel.set("loginid", unicode(self.loginId.text()))
            channel.set("loginkey", unicode(self.loginkey.text()))
            channel.set("appid", unicode(self.appid.text()))
            channel.set("appkey", unicode(self.appkey.text()))
            channel.set("waresid", unicode(self.waresid.text()))
            channel.set("orientation", unicode(self.orientation.text()))
            channel.set("resVersion", unicode(self.resVersion.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1   
        
        self.close()
    
    def retranslateUi(self, Dialog_muzhiwan_yyh):
        Dialog_muzhiwan_yyh.setWindowTitle(_translate("Dialog_muzhiwan_yyh", "Dialog_muzhiwan_yyh", None))
        self.groupBox.setTitle(_translate("Dialog_muzhiwan_yyh", "渠道参数", None))
        self.label_1.setText(_translate("Dialog_muzhiwan_yyh", "loginId", None))
        self.label_2.setText(_translate("Dialog_muzhiwan_yyh", "appid", None))
        self.label_3.setText(_translate("Dialog_muzhiwan_yyh", "waresid(商品编号)", None))
        self.label_4.setText(_translate("Dialog_muzhiwan_yyh", "loginkey", None))
        self.label_5.setText(_translate("Dialog_muzhiwan_yyh", "appkey", None))
        self.label_6.setText(_translate("Dialog_muzhiwan_yyh", "orientation", None))
        self.label_14.setText(_translate("Dialog_muzhiwan_yyh", "0:横屏", None))
        self.groupBox_2.setTitle(_translate("Dialog_muzhiwan_yyh", "平台信息", None))
        self.label_7.setText(_translate("Dialog_muzhiwan_yyh", "gameId", None))
        self.label_8.setText(_translate("Dialog_muzhiwan_yyh", "appVersion", None))
        self.label_9.setText(_translate("Dialog_muzhiwan_yyh", "datacenter", None))
        self.label_10.setText(_translate("Dialog_muzhiwan_yyh", "platformType", None))
        self.label_11.setText(_translate("Dialog_muzhiwan_yyh", "resVersion", None))
        self.label_12.setText(_translate("Dialog_muzhiwan_yyh", "platformId", None))
        self.pushButton.setText(_translate("Dialog_muzhiwan_yyh", "确定", None))
        self.label_13.setText(_translate("Dialog_muzhiwan_yyh", "包名", None))

class Dialogmuzhiwan_yyh(QDialog,Ui_Dialog_muzhiwan_yyh):  
    def __init__(self,parent=None):  
        super(Dialogmuzhiwan_yyh,self).__init__(parent)  
        self.setupUi(self)