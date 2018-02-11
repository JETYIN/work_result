# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_aiyouxi.ui'
#
# Created: Fri Jul 31 13:00:48 2015
#      by: PyQt4 UI code generator 4.11.2
#
# WARNING! All changes made in this file will be lost!

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

class Ui_Dialog_aiyouxi(object):
    def setupUi(self, Dialog_aiyouxi):
        Dialog_aiyouxi.setObjectName(_fromUtf8("Dialog_aiyouxi"))
        Dialog_aiyouxi.resize(441, 284)
        self.pushButton = QtGui.QPushButton(Dialog_aiyouxi)
        self.pushButton.setGeometry(QtCore.QRect(170, 250, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog_aiyouxi)
        self.groupBox.setGeometry(QtCore.QRect(10, 10, 421, 61))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(12, 27, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.lineEdit = QtGui.QLineEdit(self.groupBox)
        self.lineEdit.setGeometry(QtCore.QRect(60, 20, 311, 20))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog_aiyouxi)
        self.groupBox_4.setGeometry(QtCore.QRect(0, 80, 421, 121))
        self.groupBox_4.setObjectName(_fromUtf8("groupBox_4"))
        self.label_7 = QtGui.QLabel(self.groupBox_4)
        self.label_7.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_7.setObjectName(_fromUtf8("label_7"))
        self.lineEdit_6 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_6.setGeometry(QtCore.QRect(80, 28, 113, 20))
        self.lineEdit_6.setObjectName(_fromUtf8("lineEdit_6"))
        self.label_8 = QtGui.QLabel(self.groupBox_4)
        self.label_8.setGeometry(QtCore.QRect(220, 28, 61, 16))
        self.label_8.setObjectName(_fromUtf8("label_8"))
        self.lineEdit_7 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_7.setGeometry(QtCore.QRect(300, 28, 113, 20))
        self.lineEdit_7.setObjectName(_fromUtf8("lineEdit_7"))
        self.label_9 = QtGui.QLabel(self.groupBox_4)
        self.label_9.setGeometry(QtCore.QRect(10, 60, 61, 16))
        self.label_9.setObjectName(_fromUtf8("label_9"))
        self.lineEdit_8 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_8.setGeometry(QtCore.QRect(80, 59, 113, 20))
        self.lineEdit_8.setObjectName(_fromUtf8("lineEdit_8"))
        self.label_10 = QtGui.QLabel(self.groupBox_4)
        self.label_10.setGeometry(QtCore.QRect(220, 58, 81, 20))
        self.label_10.setObjectName(_fromUtf8("label_10"))
        self.lineEdit_9 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_9.setGeometry(QtCore.QRect(300, 59, 113, 20))
        self.lineEdit_9.setObjectName(_fromUtf8("lineEdit_9"))
        self.label_11 = QtGui.QLabel(self.groupBox_4)
        self.label_11.setGeometry(QtCore.QRect(10, 90, 61, 16))
        self.label_11.setObjectName(_fromUtf8("label_11"))
        self.lineEdit_10 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_10.setGeometry(QtCore.QRect(80, 90, 113, 20))
        self.lineEdit_10.setObjectName(_fromUtf8("lineEdit_10"))
        self.label_12 = QtGui.QLabel(self.groupBox_4)
        self.label_12.setGeometry(QtCore.QRect(221, 90, 61, 16))
        self.label_12.setObjectName(_fromUtf8("label_12"))
        self.lineEdit_12 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_12.setGeometry(QtCore.QRect(300, 89, 113, 20))
        self.lineEdit_12.setObjectName(_fromUtf8("lineEdit_12"))
        self.lineEdit_11 = QtGui.QLineEdit(Dialog_aiyouxi)
        self.lineEdit_11.setGeometry(QtCore.QRect(40, 220, 361, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))
        self.label_13 = QtGui.QLabel(Dialog_aiyouxi)
        self.label_13.setGeometry(QtCore.QRect(10, 220, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))

        self.retranslateUi(Dialog_aiyouxi)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_aiyouxi)
        self.initDialog()
    
    def initDialog(self):
        config = ET.parse(file_operate.getConfigXmlPath())
        root = config.getroot()

        #渠道信息
        channel = root.find("channel")
        self.lineEdit.setText(channel.get("clientId"))
        if channel.get("resVersion") != None:
            self.lineEdit_12.setText(channel.get("resVersion"))
        else:
            self.lineEdit_12.setText("")
        
        #平台信息
        platform = root.find("platform")
        self.lineEdit_6.setText(platform.get("gameId"))
        self.lineEdit_7.setText(platform.get("platformId"))
        self.lineEdit_8.setText(platform.get("appVersion"))
        self.lineEdit_9.setText(platform.get("platformType"))
        self.lineEdit_10.setText(platform.get("datacenter"))
        app = root.find("app")
        self.lineEdit_11.setText(app.get("packageName"))
    
    def onOkClicked(self):
        try:
            #print os.path.abspath('.')
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
            channel.set("clientId", unicode(self.lineEdit.text()))
            channel.set("resVersion", unicode(self.lineEdit_12.text()))
            
            #平台信息
            platform = root.find("platform")
            platform.set("gameId", unicode(self.lineEdit_6.text()))
            platform.set("platformId", unicode(self.lineEdit_7.text()))
            platform.set("appVersion", unicode(self.lineEdit_8.text()))
            platform.set("platformType", unicode(self.lineEdit_9.text()))
            platform.set("datacenter", unicode(self.lineEdit_10.text()))
            
            app = root.find("app")
            app.set("packageName", unicode(self.lineEdit_11.text()))

            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
        except Exception,e:
            print e
            print "Error: cannot parse file: config.xml."
            return -1
        self.close()
    
    def retranslateUi(self, Dialog_aiyouxi):
        Dialog_aiyouxi.setWindowTitle(_translate("Dialog_aiyouxi", "Dialog_aiyouxi", None))
        self.pushButton.setText(_translate("Dialog_aiyouxi", "确定", None))
        self.groupBox.setTitle(_translate("Dialog_aiyouxi", "渠道信息", None))
        self.label.setText(_translate("Dialog_aiyouxi", "clientid", None))
        self.groupBox_4.setTitle(_translate("Dialog_aiyouxi", "平台信息", None))
        self.label_7.setText(_translate("Dialog_aiyouxi", "gameId", None))
        self.label_8.setText(_translate("Dialog_aiyouxi", "platformId", None))
        self.label_9.setText(_translate("Dialog_aiyouxi", "appVersion", None))
        self.label_10.setText(_translate("Dialog_aiyouxi", "platformType", None))
        self.label_11.setText(_translate("Dialog_aiyouxi", "datacenter", None))
        self.label_12.setText(_translate("Dialog_aiyouxi", "resVersion", None))
        self.label_13.setText(_translate("Dialog_aiyouxi", "包名", None))
        
class Dialogaiyouxi(QDialog,Ui_Dialog_aiyouxi):  
    def __init__(self,parent=None):  
        super(Dialogaiyouxi,self).__init__(parent)  
        self.setupUi(self)