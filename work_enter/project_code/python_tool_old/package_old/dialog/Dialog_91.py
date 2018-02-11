# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_91.ui'
#
# Created: Mon Oct 13 15:46:50 2014
#      by: PyQt4 UI code generator 4.11.2
#
# WARNING! All changes made in this file will be lost!
from PyQt4.QtGui import *  
from PyQt4.QtCore import *  
from PyQt4 import QtCore, QtGui
from xml.etree import ElementTree as ET
from utils import file_operate
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
        
class Ui_Dialog_91(object):
    def setupUi(self, Dialog_91):
        Dialog_91.setObjectName(_fromUtf8("Dialog_91"))
        Dialog_91.resize(456, 371)
        self.pushButton = QtGui.QPushButton(Dialog_91)
        self.pushButton.setGeometry(QtCore.QRect(190, 330, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog_91)
        self.groupBox.setGeometry(QtCore.QRect(20, 20, 331, 101))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.lineEdit_4 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_4.setGeometry(QtCore.QRect(60, 70, 261, 20))
        self.lineEdit_4.setEchoMode(QtGui.QLineEdit.Password)
        self.lineEdit_4.setObjectName(_fromUtf8("lineEdit_4"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(10, 30, 31, 16))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(10, 70, 54, 12))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.lineEdit_3 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_3.setGeometry(QtCore.QRect(60, 30, 261, 20))
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog_91)
        self.groupBox_4.setGeometry(QtCore.QRect(20, 140, 421, 121))
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
        self.lineEdit_11 = QtGui.QLineEdit(Dialog_91)
        self.lineEdit_11.setGeometry(QtCore.QRect(60, 286, 361, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))
        self.label_13 = QtGui.QLabel(Dialog_91)
        self.label_13.setGeometry(QtCore.QRect(20, 290, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))

        self.retranslateUi(Dialog_91)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_91)
        
        self.initDialog()

    def initDialog(self):
        config = ET.parse(file_operate.getConfigXmlPath())
        root = config.getroot()

        #渠道信息
        channel = root.find("channel")
        self.lineEdit_3.setText(channel.get("appId"))
        self.lineEdit_4.setText(channel.get("appKey"))
        
        if channel.get("resVersion") != None:
            self.lineEdit_10.setText(channel.get("resVersion"))
        else:
            self.lineEdit_10.setText("")
        
        #平台信息
        platform = root.find("platform")
        self.lineEdit_5.setText(platform.get("gameId"))
        self.lineEdit_6.setText(platform.get("platformId"))
        self.lineEdit_7.setText(platform.get("appVersion"))
        self.lineEdit_8.setText(platform.get("platformType"))
        self.lineEdit_9.setText(platform.get("datacenter"))
        app = root.find("app")
        self.lineEdit_11.setText(app.get("packageName"))
        
        
        
    def onOkClicked(self):
        try:
            #print os.path.abspath('.')
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
            channel.set("appId", unicode(self.lineEdit_3.text()))
            channel.set("appKey", unicode(self.lineEdit_4.text())) 
            channel.set("resVersion", unicode(self.lineEdit_10.text()))
            
            #平台信息
            platform = root.find("platform")
            platform.set("gameId", unicode(self.lineEdit_5.text()))
            platform.set("platformId", unicode(self.lineEdit_6.text()))
            platform.set("appVersion", unicode(self.lineEdit_7.text()))
            platform.set("platformType", unicode(self.lineEdit_8.text()))
            platform.set("datacenter", unicode(self.lineEdit_9.text()))
            
            app = root.find("app")
            app.set("packageName", unicode(self.lineEdit_11.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
        
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()
        
    def retranslateUi(self, Dialog_91):
        Dialog_91.setWindowTitle(_translate("Dialog_91", "Config_91", None))
        self.pushButton.setText(_translate("Dialog_91", "确定", None))
        self.groupBox.setTitle(_translate("Dialog_91", "渠道信息", None))
        self.label_5.setText(_translate("Dialog_91", "AppId", None))
        self.label_6.setText(_translate("Dialog_91", "AppKey", None))
        self.groupBox_4.setTitle(_translate("Dialog_91", "平台信息", None))
        self.label_7.setText(_translate("Dialog_91", "gameId", None))
        self.label_8.setText(_translate("Dialog_91", "platformId", None))
        self.label_9.setText(_translate("Dialog_91", "appVersion", None))
        self.label_10.setText(_translate("Dialog_91", "platformType", None))
        self.label_11.setText(_translate("Dialog_91", "datacenter", None))
        self.label_12.setText(_translate("Dialog_91", "resVersion", None))
        self.label_13.setText(_translate("Dialog_91", "包名", None))
		
class Dialog91(QDialog,Ui_Dialog_91):  
    def __init__(self,parent=None):  
        super(Dialog91,self).__init__(parent)  
        self.setupUi(self)

