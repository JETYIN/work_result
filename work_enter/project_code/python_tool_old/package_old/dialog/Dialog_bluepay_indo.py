# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_funcell_kr_google.ui'
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

class Ui_Dialog_funcell_google(object):
    def setupUi(self, Dialog_funcell_google):
        Dialog_funcell_google.setObjectName(_fromUtf8("Dialog_funcell_google"))
        Dialog_funcell_google.resize(645, 529)
        self.groupBox = QtGui.QGroupBox(Dialog_funcell_google)
        self.groupBox.setGeometry(QtCore.QRect(20, 30, 581, 271))
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
        self.groupBox_2 = QtGui.QGroupBox(Dialog_funcell_google)
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
        self.pushButton = QtGui.QPushButton(Dialog_funcell_google)
        self.pushButton.setGeometry(QtCore.QRect(270, 490, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.packageName = QtGui.QLineEdit(Dialog_funcell_google)
        self.packageName.setGeometry(QtCore.QRect(50, 460, 541, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.label_13 = QtGui.QLabel(Dialog_funcell_google)
        self.label_13.setGeometry(QtCore.QRect(10, 460, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))

        self.retranslateUi(Dialog_funcell_google)
        self.pushButton.clicked.connect(self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_funcell_google)
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
            channel.set("funcellKey", unicode(self.funcellKey_2.text()))
            channel.set("facebook_app_id", unicode(self.facebook_app_id.text()))
            channel.set("googleGameAppId", unicode(self.googleGameAppId.text()))
            channel.set("base64PublicKey", unicode(self.base64PublicKey.text()))
            channel.set("resVersion", unicode(self.resVersion.text()))
            
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
            funcellStringConfig.write(file_operate.getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName() + "/ForRes/values/fun_strings.xml"), "utf-8")
        except Exception,e:
            print e
            print "Error: cannot parse file: efunGameConfig.xml."
            return -1
        
        self.close()
    
    def retranslateUi(self, Dialog_funcell_google):
        Dialog_funcell_google.setWindowTitle(_translate("Dialog_funcell_google", "Dialog_bluepay_indo", None))
        self.groupBox.setTitle(_translate("Dialog_funcell_google", "渠道参数", None))
        self.label_1.setText(_translate("Dialog_funcell_google", "appId", None))
        self.label_2.setText(_translate("Dialog_funcell_google", "appKey", None))
        self.label_3.setText(_translate("Dialog_funcell_google", "facebook_app_id", None))
        self.label_4.setText(_translate("Dialog_funcell_google", "funcellKey", None))
        self.label_5.setText(_translate("Dialog_funcell_google", "googleGameAppId", None))
        self.label_6.setText(_translate("Dialog_funcell_google", "base64PublicKey", None))
        self.label_14.setText(_translate("Dialog_funcell_google", "igaworks_app_key", None))
        self.label_15.setText(_translate("Dialog_funcell_google", "igaworks_hash_key", None))
        self.groupBox_2.setTitle(_translate("Dialog_funcell_google", "平台信息", None))
        self.label_7.setText(_translate("Dialog_funcell_google", "gameId", None))
        self.label_8.setText(_translate("Dialog_funcell_google", "appVersion", None))
        self.label_9.setText(_translate("Dialog_funcell_google", "datacenter", None))
        self.label_10.setText(_translate("Dialog_funcell_google", "platformType", None))
        self.label_11.setText(_translate("Dialog_funcell_google", "resVersion", None))
        self.label_12.setText(_translate("Dialog_funcell_google", "platformId", None))
        self.pushButton.setText(_translate("Dialog_funcell_google", "确定", None))
        self.label_13.setText(_translate("Dialog_funcell_google", "包名", None))

class Dialogindofun(QDialog,Ui_Dialog_funcell_google):  
    def __init__(self,parent=None):  
        super(Dialogindofun,self).__init__(parent)  
        self.setupUi(self)
