# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'F:\svnwork\Libs1\ReleaseSDK\android_pack_talkingdata\ui\Dialog_Raink_CGamex.ui'
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

class Ui_Dialog_CGamex(object):
    def setupUi(self, Dialog_CGamex):
        Dialog_CGamex.setObjectName(_fromUtf8("Dialog_CGamex"))
        Dialog_CGamex.resize(440, 361)
        self.pushButton = QtGui.QPushButton(Dialog_CGamex)
        self.pushButton.setGeometry(QtCore.QRect(180, 320, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog_CGamex)
        self.groupBox.setGeometry(QtCore.QRect(10, 10, 361, 111))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.appKey = QtGui.QLineEdit(self.groupBox)
        self.appKey.setGeometry(QtCore.QRect(90, 50, 261, 20))
        self.appKey.setObjectName(_fromUtf8("appKey"))
        self.appId = QtGui.QLineEdit(self.groupBox)
        self.appId.setGeometry(QtCore.QRect(90, 20, 261, 20))
        self.appId.setObjectName(_fromUtf8("appId"))
        self.appIdLabel = QtGui.QLabel(self.groupBox)
        self.appIdLabel.setGeometry(QtCore.QRect(10, 25, 54, 12))
        self.appIdLabel.setObjectName(_fromUtf8("appIdLabel"))
        self.appKeyLabel = QtGui.QLabel(self.groupBox)
        self.appKeyLabel.setGeometry(QtCore.QRect(10, 55, 54, 12))
        self.appKeyLabel.setObjectName(_fromUtf8("appKeyLabel"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog_CGamex)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 124, 421, 121))
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
        self.label_13 = QtGui.QLabel(Dialog_CGamex)
        self.label_13.setGeometry(QtCore.QRect(10, 274, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.packageName = QtGui.QLineEdit(Dialog_CGamex)
        self.packageName.setGeometry(QtCore.QRect(50, 270, 361, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))

        self.retranslateUi(Dialog_CGamex)
        QtCore.QMetaObject.connectSlotsByName(Dialog_CGamex)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), self.onOkClicked)
        
        self.initDialog()
    
    def initDialog(self):
        try:
            #print os.path.abspath('.')
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
            self.appId.setText(channel.get("appId"))
            self.appKey.setText(channel.get("appKey"))
            
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
            channel.set("appId", unicode(self.appId.text()))
            channel.set("appKey", unicode(self.appKey.text())) 
            
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

           
                    
        
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()

    def retranslateUi(self, Dialog_CGamex):
        Dialog_CGamex.setWindowTitle(_translate("Dialog_CGamex", "Dialog_funcell", None))
        self.pushButton.setText(_translate("Dialog_CGamex", "确定", None))
        self.groupBox.setTitle(_translate("Dialog_CGamex", "渠道信息", None))
        self.appIdLabel.setText(_translate("Dialog_CGamex", "appId", None))
        self.appKeyLabel.setText(_translate("Dialog_CGamex", "appKey", None))
        self.groupBox_4.setTitle(_translate("Dialog_CGamex", "平台信息", None))
        self.label_9.setText(_translate("Dialog_CGamex", "gameId", None))
        self.label_10.setText(_translate("Dialog_CGamex", "platformId", None))
        self.label_11.setText(_translate("Dialog_CGamex", "appVersion", None))
        self.label_12.setText(_translate("Dialog_CGamex", "platformType", None))
        self.label_14.setText(_translate("Dialog_CGamex", "datacenter", None))
        self.label_15.setText(_translate("Dialog_CGamex", "resVersion", None))
        self.label_13.setText(_translate("Dialog_CGamex", "包名", None))

class DialogRaink_CGamex(QDialog,Ui_Dialog_CGamex):  
    def __init__(self,parent=None):  
        super(DialogRaink_CGamex,self).__init__(parent)  
        self.setupUi(self)