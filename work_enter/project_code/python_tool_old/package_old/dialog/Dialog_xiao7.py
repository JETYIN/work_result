# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_xiao7.ui'
#
# Created by: PyQt4 UI code generator 4.11.4
#
# WARNING! All changes made in this file will be lost!

from PyQt4 import QtCore, QtGui
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

class Ui_Dialog_xiao7(object):
    def setupUi(self, Dialog_xiao7):
        Dialog_xiao7.setObjectName(_fromUtf8("Dialog_xiao7"))
        Dialog_xiao7.resize(640, 397)
        self.groupBox = QtGui.QGroupBox(Dialog_xiao7)
        self.groupBox.setGeometry(QtCore.QRect(30, 20, 581, 111))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_1 = QtGui.QLabel(self.groupBox)
        self.label_1.setGeometry(QtCore.QRect(20, 30, 54, 12))
        self.label_1.setObjectName(_fromUtf8("label_1"))
        self.appKey = QtGui.QLineEdit(self.groupBox)
        self.appKey.setGeometry(QtCore.QRect(90, 20, 431, 20))
        self.appKey.setObjectName(_fromUtf8("appKey"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(20, 60, 54, 12))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.payId = QtGui.QLineEdit(self.groupBox)
        self.payId.setGeometry(QtCore.QRect(90, 50, 431, 20))
        self.payId.setObjectName(_fromUtf8("payId"))
        self.groupBox_2 = QtGui.QGroupBox(Dialog_xiao7)
        self.groupBox_2.setGeometry(QtCore.QRect(30, 150, 581, 131))
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
        self.pushButton = QtGui.QPushButton(Dialog_xiao7)
        self.pushButton.setGeometry(QtCore.QRect(270, 350, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.label_13 = QtGui.QLabel(Dialog_xiao7)
        self.label_13.setGeometry(QtCore.QRect(30, 310, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.packageName = QtGui.QLineEdit(Dialog_xiao7)
        self.packageName.setGeometry(QtCore.QRect(70, 310, 541, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))

        self.retranslateUi(Dialog_xiao7)
        QtCore.QMetaObject.connectSlotsByName(Dialog_xiao7)
        
        self.pushButton.clicked.connect(self.onOkClicked)
        self.initDialog()
        
    def initDialog(self):
        try:
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
          
            if channel.get("resVersion") != None:
                self.resVersion.setText(channel.get("resVersion"))
            else:
                self.resVersion.setText("")
            
            self.appKey.setText(channel.get("appKey"))
            self.payId.setText(channel.get("payId"))
                
            
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
            channel.set("resVersion", unicode(self.resVersion.text()))
            
            channel.set("appKey", unicode(self.appKey.text()))
            channel.set("payId", unicode(self.payId.text()))
            
            
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

    def retranslateUi(self, Dialog_xiao7):
        Dialog_xiao7.setWindowTitle(_translate("Dialog_xiao7", "Dialog", None))
        self.groupBox.setTitle(_translate("Dialog_xiao7", "渠道参数", None))
        self.label_1.setText(_translate("Dialog_xiao7", "appKey", None))
        self.label_2.setText(_translate("Dialog_xiao7", "payId", None))
        self.groupBox_2.setTitle(_translate("Dialog_xiao7", "平台信息", None))
        self.label_7.setText(_translate("Dialog_xiao7", "gameId", None))
        self.label_8.setText(_translate("Dialog_xiao7", "appVersion", None))
        self.label_9.setText(_translate("Dialog_xiao7", "datacenter", None))
        self.label_10.setText(_translate("Dialog_xiao7", "platformType", None))
        self.label_11.setText(_translate("Dialog_xiao7", "resVersion", None))
        self.label_12.setText(_translate("Dialog_xiao7", "platformId", None))
        self.pushButton.setText(_translate("Dialog_xiao7", "确定", None))
        self.label_13.setText(_translate("Dialog_xiao7", "包名", None))

class Dialogxiao7(QDialog,Ui_Dialog_xiao7):
    def __init__(self,parent=None):  
        super(Dialogxiao7,self).__init__(parent)  
        self.setupUi(self)