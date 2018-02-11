# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_gionee.ui'
#
# Created: Fri Jul 24 16:59:53 2015
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

class Ui_Dialog_gionee(object):
    def setupUi(self, Dialog_gionee):
        Dialog_gionee.setObjectName(_fromUtf8("Dialog_gionee"))
        Dialog_gionee.resize(452, 327)
        self.pushButton = QtGui.QPushButton(Dialog_gionee)
        self.pushButton.setGeometry(QtCore.QRect(180, 290, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog_gionee)
        self.groupBox.setGeometry(QtCore.QRect(10, 20, 421, 61))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(10, 30, 51, 16))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.lineEdit_3 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_3.setGeometry(QtCore.QRect(60, 30, 331, 20))
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog_gionee)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 100, 421, 121))
        self.groupBox_4.setObjectName(_fromUtf8("groupBox_4"))
        self.label_7 = QtGui.QLabel(self.groupBox_4)
        self.label_7.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_7.setObjectName(_fromUtf8("label_7"))
        self.lineEdit_5 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_5.setGeometry(QtCore.QRect(80, 28, 113, 20))
        self.lineEdit_5.setObjectName(_fromUtf8("lineEdit_5"))
        self.label_8 = QtGui.QLabel(self.groupBox_4)
        self.label_8.setGeometry(QtCore.QRect(220, 28, 61, 16))
        self.label_8.setObjectName(_fromUtf8("label_8"))
        self.lineEdit_6 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_6.setGeometry(QtCore.QRect(300, 28, 113, 20))
        self.lineEdit_6.setObjectName(_fromUtf8("lineEdit_6"))
        self.label_9 = QtGui.QLabel(self.groupBox_4)
        self.label_9.setGeometry(QtCore.QRect(10, 60, 61, 16))
        self.label_9.setObjectName(_fromUtf8("label_9"))
        self.lineEdit_7 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_7.setGeometry(QtCore.QRect(80, 59, 113, 20))
        self.lineEdit_7.setObjectName(_fromUtf8("lineEdit_7"))
        self.label_10 = QtGui.QLabel(self.groupBox_4)
        self.label_10.setGeometry(QtCore.QRect(220, 58, 81, 20))
        self.label_10.setObjectName(_fromUtf8("label_10"))
        self.lineEdit_8 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_8.setGeometry(QtCore.QRect(300, 59, 113, 20))
        self.lineEdit_8.setObjectName(_fromUtf8("lineEdit_8"))
        self.label_11 = QtGui.QLabel(self.groupBox_4)
        self.label_11.setGeometry(QtCore.QRect(10, 90, 61, 16))
        self.label_11.setObjectName(_fromUtf8("label_11"))
        self.lineEdit_9 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_9.setGeometry(QtCore.QRect(80, 90, 113, 20))
        self.lineEdit_9.setObjectName(_fromUtf8("lineEdit_9"))
        self.label_12 = QtGui.QLabel(self.groupBox_4)
        self.label_12.setGeometry(QtCore.QRect(221, 90, 61, 16))
        self.label_12.setObjectName(_fromUtf8("label_12"))
        self.lineEdit_10 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_10.setGeometry(QtCore.QRect(300, 89, 113, 20))
        self.lineEdit_10.setObjectName(_fromUtf8("lineEdit_10"))
        self.lineEdit_11 = QtGui.QLineEdit(Dialog_gionee)
        self.lineEdit_11.setGeometry(QtCore.QRect(50, 250, 361, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))
        self.label_13 = QtGui.QLabel(Dialog_gionee)
        self.label_13.setGeometry(QtCore.QRect(10, 250, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))

        self.retranslateUi(Dialog_gionee)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), Dialog_gionee.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_gionee)
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
            self.lineEdit_5.setText(platform.get("gameId"))
            self.lineEdit_6.setText(platform.get("platformId"))
            self.lineEdit_7.setText(platform.get("appVersion"))
            self.lineEdit_8.setText(platform.get("platformType"))
            self.lineEdit_9.setText(platform.get("datacenter"))
            
            app = root.find("app")
            self.lineEdit_11.setText(app.get("packageName"))
            
            channel = root.find("channel")
            if channel.get("resVersion") != None:
                self.lineEdit_10.setText(channel.get("resVersion"))
            else:
                self.lineEdit_10.setText("")
            self.lineEdit_3.setText(channel.get("apiKey"))
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
            platform.set("gameId", unicode(self.lineEdit_5.text()))
            platform.set("platformId", unicode(self.lineEdit_6.text()))
            platform.set("appVersion", unicode(self.lineEdit_7.text()))
            platform.set("platformType", unicode(self.lineEdit_8.text()))
            platform.set("datacenter", unicode(self.lineEdit_9.text()))
            
            app = root.find("app")
            app.set("packageName", unicode(self.lineEdit_11.text()))
            
            channel = root.find("channel")
            channel.set("resVersion", unicode(self.lineEdit_10.text()))
            channel.set("apiKey", unicode(self.lineEdit_3.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()
        
    def retranslateUi(self, Dialog_gionee):
        Dialog_gionee.setWindowTitle(_translate("Dialog_gionee", "Config_gionee", None))
        self.pushButton.setText(_translate("Dialog_gionee", "确定", None))
        self.groupBox.setTitle(_translate("Dialog_gionee", "渠道信息", None))
        self.label_5.setText(_translate("Dialog_gionee", "ApiKey", None))
        self.groupBox_4.setTitle(_translate("Dialog_gionee", "平台信息", None))
        self.label_7.setText(_translate("Dialog_gionee", "gameId", None))
        self.label_8.setText(_translate("Dialog_gionee", "platformId", None))
        self.label_9.setText(_translate("Dialog_gionee", "appVersion", None))
        self.label_10.setText(_translate("Dialog_gionee", "platformType", None))
        self.label_11.setText(_translate("Dialog_gionee", "datacenter", None))
        self.label_12.setText(_translate("Dialog_gionee", "resVersion", None))
        self.label_13.setText(_translate("Dialog_gionee", "包名", None))

class Dialoggionee(QDialog,Ui_Dialog_gionee):  
    def __init__(self,parent=None):  
        super(Dialoggionee,self).__init__(parent)  
        self.setupUi(self)