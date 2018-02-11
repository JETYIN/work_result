# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_mz.ui'
#
# Created: Wed Jul 15 10:01:39 2015
#      by: PyQt4 UI code generator 4.11.2
#
# WARNING! All changes made in this file will be lost!

from PyQt4 import QtCore, QtGui
from xml.etree import ElementTree as ET
from utils import file_operate, constant
from PyQt4.QtGui import *  
from PyQt4.QtCore import *  

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

class Ui_Dialog_mz(object):
    def setupUi(self, Dialog_mz):
        Dialog_mz.setObjectName(_fromUtf8("Dialog_mz"))
        Dialog_mz.resize(445, 338)
        self.pushButton = QtGui.QPushButton(Dialog_mz)
        self.pushButton.setGeometry(QtCore.QRect(180, 300, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog_mz)
        self.groupBox.setGeometry(QtCore.QRect(10, 10, 421, 91))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.lineEdit_2 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_2.setGeometry(QtCore.QRect(50, 50, 141, 21))
        self.lineEdit_2.setObjectName(_fromUtf8("lineEdit_2"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(10, 20, 31, 16))
        self.label.setObjectName(_fromUtf8("label"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(10, 50, 41, 16))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.lineEdit = QtGui.QLineEdit(self.groupBox)
        self.lineEdit.setGeometry(QtCore.QRect(50, 20, 141, 21))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(200, 20, 61, 20))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.lineEdit_3 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_3.setGeometry(QtCore.QRect(270, 20, 141, 21))
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.lineEdit_4 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_4.setGeometry(QtCore.QRect(270, 50, 141, 21))
        self.lineEdit_4.setObjectName(_fromUtf8("lineEdit_4"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(200, 50, 41, 20))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.label_18 = QtGui.QLabel(Dialog_mz)
        self.label_18.setGeometry(QtCore.QRect(10, 260, 54, 12))
        self.label_18.setObjectName(_fromUtf8("label_18"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog_mz)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 110, 421, 121))
        self.groupBox_4.setObjectName(_fromUtf8("groupBox_4"))
        self.label_12 = QtGui.QLabel(self.groupBox_4)
        self.label_12.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_12.setObjectName(_fromUtf8("label_12"))
        self.lineEdit_6 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_6.setGeometry(QtCore.QRect(80, 28, 113, 20))
        self.lineEdit_6.setObjectName(_fromUtf8("lineEdit_6"))
        self.label_13 = QtGui.QLabel(self.groupBox_4)
        self.label_13.setGeometry(QtCore.QRect(220, 28, 61, 16))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.lineEdit_7 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_7.setGeometry(QtCore.QRect(300, 28, 113, 20))
        self.lineEdit_7.setObjectName(_fromUtf8("lineEdit_7"))
        self.label_14 = QtGui.QLabel(self.groupBox_4)
        self.label_14.setGeometry(QtCore.QRect(10, 60, 61, 16))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.lineEdit_8 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_8.setGeometry(QtCore.QRect(80, 59, 113, 20))
        self.lineEdit_8.setObjectName(_fromUtf8("lineEdit_8"))
        self.label_15 = QtGui.QLabel(self.groupBox_4)
        self.label_15.setGeometry(QtCore.QRect(220, 58, 81, 20))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.lineEdit_9 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_9.setGeometry(QtCore.QRect(300, 59, 113, 20))
        self.lineEdit_9.setObjectName(_fromUtf8("lineEdit_9"))
        self.label_16 = QtGui.QLabel(self.groupBox_4)
        self.label_16.setGeometry(QtCore.QRect(10, 90, 61, 16))
        self.label_16.setObjectName(_fromUtf8("label_16"))
        self.lineEdit_10 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_10.setGeometry(QtCore.QRect(80, 90, 113, 20))
        self.lineEdit_10.setObjectName(_fromUtf8("lineEdit_10"))
        self.label_17 = QtGui.QLabel(self.groupBox_4)
        self.label_17.setGeometry(QtCore.QRect(221, 90, 61, 16))
        self.label_17.setObjectName(_fromUtf8("label_17"))
        self.lineEdit_12 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_12.setGeometry(QtCore.QRect(300, 89, 113, 20))
        self.lineEdit_12.setObjectName(_fromUtf8("lineEdit_12"))
        self.lineEdit_11 = QtGui.QLineEdit(Dialog_mz)
        self.lineEdit_11.setGeometry(QtCore.QRect(50, 256, 361, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))

        self.retranslateUi(Dialog_mz)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), Dialog_mz.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_mz)
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
            self.lineEdit_6.setText(platform.get("gameId"))
            self.lineEdit_7.setText(platform.get("platformId"))
            self.lineEdit_8.setText(platform.get("appVersion"))
            self.lineEdit_9.setText(platform.get("platformType"))
            self.lineEdit_10.setText(platform.get("datacenter"))
            
            app = root.find("app")
            self.lineEdit_11.setText(app.get("packageName"))
            
            channel = root.find("channel")
            self.lineEdit.setText(channel.get("appId"))
            self.lineEdit_3.setText(channel.get("appSecret"))
            self.lineEdit_2.setText(channel.get("appKey"))
            self.lineEdit_4.setText(channel.get("version"))
            if channel.get("resVersion") != None:
                self.lineEdit_12.setText(channel.get("resVersion"))
            else:
                self.lineEdit_12.setText("")
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
            platform.set("gameId", unicode(self.lineEdit_6.text()))
            platform.set("platformId", unicode(self.lineEdit_7.text()))
            platform.set("appVersion", unicode(self.lineEdit_8.text()))
            platform.set("platformType", unicode(self.lineEdit_9.text()))
            platform.set("datacenter", unicode(self.lineEdit_10.text()))
            
            app = root.find("app")
            app.set("packageName", unicode(self.lineEdit_11.text()))
            
            channel = root.find("channel")
            channel.set("appId", unicode(self.lineEdit.text()))
            channel.set("appSecret", unicode(self.lineEdit_3.text()))
            channel.set("appKey", unicode(self.lineEdit_2.text()))
            channel.set("version", unicode(self.lineEdit_4.text()))
            channel.set("resVersion", unicode(self.lineEdit_12.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()
    
    def retranslateUi(self, Dialog_mz):
        Dialog_mz.setWindowTitle(_translate("Dialog_mz", "Dialog_mz", None))
        self.pushButton.setText(_translate("Dialog_mz", "确定", None))
        self.groupBox.setTitle(_translate("Dialog_mz", "渠道信息", None))
        self.label.setText(_translate("Dialog_mz", "appId", None))
        self.label_2.setText(_translate("Dialog_mz", "appKey", None))
        self.label_3.setText(_translate("Dialog_mz", "appsecret", None))
        self.label_4.setText(_translate("Dialog_mz", "version", None))
        self.label_18.setText(_translate("Dialog_mz", "包名", None))
        self.groupBox_4.setTitle(_translate("Dialog_mz", "平台信息", None))
        self.label_12.setText(_translate("Dialog_mz", "gameId", None))
        self.label_13.setText(_translate("Dialog_mz", "platformId", None))
        self.label_14.setText(_translate("Dialog_mz", "appVersion", None))
        self.label_15.setText(_translate("Dialog_mz", "platformType", None))
        self.label_16.setText(_translate("Dialog_mz", "datacenter", None))
        self.label_17.setText(_translate("Dialog_mz", "resVersion", None))

class Dialogmz(QDialog,Ui_Dialog_mz):  
    def __init__(self,parent=None):  
        super(Dialogmz,self).__init__(parent)  
        self.setupUi(self)