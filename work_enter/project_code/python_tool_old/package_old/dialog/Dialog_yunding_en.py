# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'G:\svnwork\Libs1\ReleaseSDK\android_pack_talkingdata\ui\Dialog_yunding.ui'
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

class Ui_Dialog_yunding_en(object):
    def setupUi(self, Dialog_yunding_en):
        Dialog_yunding_en.setObjectName(_fromUtf8("Dialog_yunding"))
        Dialog_yunding_en.resize(645, 766)
        self.groupBox = QtGui.QGroupBox(Dialog_yunding_en)
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
        self.label_3.setGeometry(QtCore.QRect(10, 80, 101, 20))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.facebookId = QtGui.QLineEdit(self.groupBox)
        self.facebookId.setGeometry(QtCore.QRect(140, 80, 291, 20))
        self.facebookId.setObjectName(_fromUtf8("facebookId"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(10, 110, 101, 20))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.kochavaAppGuid = QtGui.QLineEdit(self.groupBox)
        self.kochavaAppGuid.setGeometry(QtCore.QRect(140, 110, 291, 20))
        self.kochavaAppGuid.setObjectName(_fromUtf8("kochavaAppGuid"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(10, 140, 101, 20))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.gpPayPublicKey = QtGui.QLineEdit(self.groupBox)
        self.gpPayPublicKey.setGeometry(QtCore.QRect(140, 140, 291, 20))
        self.gpPayPublicKey.setObjectName(_fromUtf8("gpPayPublicKey"))
        self.label_14 = QtGui.QLabel(self.groupBox)
        self.label_14.setGeometry(QtCore.QRect(10, 170, 101, 20))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.screenOrientation = QtGui.QLineEdit(self.groupBox)
        self.screenOrientation.setGeometry(QtCore.QRect(140, 170, 41, 20))
        self.screenOrientation.setObjectName(_fromUtf8("screenOrientation"))
        self.label_15 = QtGui.QLabel(self.groupBox)
        self.label_15.setGeometry(QtCore.QRect(10, 200, 111, 20))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.payGrade = QtGui.QLineEdit(self.groupBox)
        self.payGrade.setGeometry(QtCore.QRect(140, 200, 41, 20))
        self.payGrade.setObjectName(_fromUtf8("payGrade"))
        self.payGrade.setEnabled(False);
        self.label_16 = QtGui.QLabel(self.groupBox)
        self.label_16.setGeometry(QtCore.QRect(20, 240, 101, 16))
        self.label_16.setObjectName(_fromUtf8("label_16"))
        self.language = QtGui.QLineEdit(self.groupBox)
        self.language.setGeometry(QtCore.QRect(140, 240, 41, 20))
        self.language.setObjectName(_fromUtf8("language"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(190, 170, 371, 16))
        self.label.setObjectName(_fromUtf8("label"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(190, 200, 371, 16))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.label_17 = QtGui.QLabel(self.groupBox)
        self.label_17.setGeometry(QtCore.QRect(190, 240, 391, 16))
        self.label_17.setObjectName(_fromUtf8("label_17"))
        self.groupBox_2 = QtGui.QGroupBox(Dialog_yunding_en)
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
        self.pushButton = QtGui.QPushButton(Dialog_yunding_en)
        self.pushButton.setGeometry(QtCore.QRect(270, 720, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.packageName = QtGui.QLineEdit(Dialog_yunding_en)
        self.packageName.setGeometry(QtCore.QRect(60, 690, 541, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.label_13 = QtGui.QLabel(Dialog_yunding_en)
        self.label_13.setGeometry(QtCore.QRect(20, 690, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))

        self.retranslateUi(Dialog_yunding_en)
        QtCore.QMetaObject.connectSlotsByName(Dialog_yunding_en)
        
        
        self.pushButton.clicked.connect(self.onOkClicked)
        
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
            self.screenOrientation.setText(channel.get("screenOrientation"))
            self.facebookId.setText(channel.get("facebookId"))
            self.kochavaAppGuid.setText(channel.get("kochavaAppGuid"))
            self.gpPayPublicKey.setText(channel.get("gpPayPublicKey"))
            self.language.setText(channel.get("language"))
            self.payGrade.setText(channel.get("payGrade"))
            

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
            
#             doc = minidom.parse(file_operate.getForManifestXmlPath())
            
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
            channel.set("kochavaAppGuid", unicode(self.kochavaAppGuid.text()))
            channel.set("facebookId", unicode(self.facebookId.text()))
            channel.set("screenOrientation", unicode(self.screenOrientation.text()))
            channel.set("gpPayPublicKey", unicode(self.gpPayPublicKey.text()))
            channel.set("language", unicode(self.language.text()))
            channel.set("payGrade", unicode(self.payGrade.text()))
            channel.set("resVersion", unicode(self.resVersion.text()))
            
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1   
        
        
        self.close()

    def retranslateUi(self, Dialog_yunding):
        Dialog_yunding.setWindowTitle(_translate("Dialog_yunding", "Dialog_yunding", None))
        self.groupBox.setTitle(_translate("Dialog_yunding", "渠道参数", None))
        self.label_1.setText(_translate("Dialog_yunding", "appId", None))
        self.label_2.setText(_translate("Dialog_yunding", "appKey", None))
        self.label_3.setText(_translate("Dialog_yunding", "facebook_app_id", None))
        self.label_5.setText(_translate("Dialog_yunding", "kochavaAppGuid", None))
        self.label_6.setText(_translate("Dialog_yunding", "base64PublicKey", None))
        self.label_14.setText(_translate("Dialog_yunding", "screenOrientation", None))
        self.label_15.setText(_translate("Dialog_yunding", "payGrade(支付渠道)", None))
        self.label_16.setText(_translate("Dialog_yunding", "language", None))
        self.label.setText(_translate("Dialog_yunding", "横屏=1   竖屏=2  旋转横屏=3  旋转竖屏=4", None))
        self.label_4.setText(_translate("Dialog_yunding", "空--所有  1--googlepay  11--不包含googlepay", None))
        self.label_17.setText(_translate("Dialog_yunding", "5=英语|7=韩文|8=中文繁体|9=中文简体|10=印尼语|11=泰语|12=越南语", None))
        self.groupBox_2.setTitle(_translate("Dialog_yunding", "平台信息", None))
        self.label_7.setText(_translate("Dialog_yunding", "gameId", None))
        self.label_8.setText(_translate("Dialog_yunding", "appVersion", None))
        self.label_9.setText(_translate("Dialog_yunding", "datacenter", None))
        self.label_10.setText(_translate("Dialog_yunding", "platformType", None))
        self.label_11.setText(_translate("Dialog_yunding", "resVersion", None))
        self.label_12.setText(_translate("Dialog_yunding", "platformId", None))
        self.pushButton.setText(_translate("Dialog_yunding", "确定", None))
        self.label_13.setText(_translate("Dialog_yunding", "包名", None))

class Dialogyunding_en(QDialog,Ui_Dialog_yunding_en):  
    def __init__(self,parent=None):  
        super(Dialogyunding_en,self).__init__(parent)  
        self.setupUi(self)
