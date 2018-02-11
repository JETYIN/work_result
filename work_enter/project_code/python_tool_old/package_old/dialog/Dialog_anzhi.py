# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_anzhi.ui'
#
# Created: Mon Jul 27 16:30:33 2015
#      by: PyQt4 UI code generator 4.11.2
#
# WARNING! All changes made in this file will be lost!

from PyQt4.QtGui import *  
from PyQt4.QtCore import *  
from PyQt4 import QtCore, QtGui
from xml.etree import ElementTree as ET
from utils import file_operate, constant
from utils.config import ConfigParse
import utils.constant

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

class Ui_Dialog_anzhi(object):
    def setupUi(self, Dialog_anzhi):
        Dialog_anzhi.setObjectName(_fromUtf8("Dialog_anzhi"))
        Dialog_anzhi.resize(447, 392)
        self.pushButton = QtGui.QPushButton(Dialog_anzhi)
        self.pushButton.setGeometry(QtCore.QRect(180, 350, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog_anzhi)
        self.groupBox.setGeometry(QtCore.QRect(10, 10, 421, 161))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.lineEdit_3 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_3.setGeometry(QtCore.QRect(110, 88, 211, 20))
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.comboBox = QtGui.QComboBox(self.groupBox)
        self.comboBox.setGeometry(QtCore.QRect(110, 120, 211, 22))
        self.comboBox.setObjectName(_fromUtf8("comboBox"))
        self.comboBox.addItem(_fromUtf8(""))
        self.comboBox.addItem(_fromUtf8(""))
        self.comboBox.addItem(_fromUtf8(""))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(20, 30, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(20, 60, 54, 12))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(20, 90, 54, 12))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.lineEdit_2 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_2.setGeometry(QtCore.QRect(110, 56, 211, 20))
        self.lineEdit_2.setObjectName(_fromUtf8("lineEdit_2"))
        self.lineEdit = QtGui.QLineEdit(self.groupBox)
        self.lineEdit.setGeometry(QtCore.QRect(110, 28, 211, 20))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(10, 120, 81, 16))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.label_18 = QtGui.QLabel(Dialog_anzhi)
        self.label_18.setGeometry(QtCore.QRect(10, 320, 54, 12))
        self.label_18.setObjectName(_fromUtf8("label_18"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog_anzhi)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 180, 421, 121))
        self.groupBox_4.setObjectName(_fromUtf8("groupBox_4"))
        self.label_12 = QtGui.QLabel(self.groupBox_4)
        self.label_12.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_12.setObjectName(_fromUtf8("label_12"))
        self.lineEdit_7 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_7.setGeometry(QtCore.QRect(80, 28, 113, 20))
        self.lineEdit_7.setObjectName(_fromUtf8("lineEdit_7"))
        self.label_13 = QtGui.QLabel(self.groupBox_4)
        self.label_13.setGeometry(QtCore.QRect(220, 28, 61, 16))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.lineEdit_8 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_8.setGeometry(QtCore.QRect(300, 28, 113, 20))
        self.lineEdit_8.setObjectName(_fromUtf8("lineEdit_8"))
        self.label_14 = QtGui.QLabel(self.groupBox_4)
        self.label_14.setGeometry(QtCore.QRect(10, 60, 61, 16))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.lineEdit_9 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_9.setGeometry(QtCore.QRect(80, 59, 113, 20))
        self.lineEdit_9.setObjectName(_fromUtf8("lineEdit_9"))
        self.label_15 = QtGui.QLabel(self.groupBox_4)
        self.label_15.setGeometry(QtCore.QRect(220, 58, 81, 20))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.lineEdit_10 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_10.setGeometry(QtCore.QRect(300, 59, 113, 20))
        self.lineEdit_10.setObjectName(_fromUtf8("lineEdit_10"))
        self.label_16 = QtGui.QLabel(self.groupBox_4)
        self.label_16.setGeometry(QtCore.QRect(10, 90, 61, 16))
        self.label_16.setObjectName(_fromUtf8("label_16"))
        self.lineEdit_11 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_11.setGeometry(QtCore.QRect(80, 90, 113, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))
        self.label_17 = QtGui.QLabel(self.groupBox_4)
        self.label_17.setGeometry(QtCore.QRect(221, 90, 61, 16))
        self.label_17.setObjectName(_fromUtf8("label_17"))
        self.lineEdit_12 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_12.setGeometry(QtCore.QRect(300, 89, 113, 20))
        self.lineEdit_12.setObjectName(_fromUtf8("lineEdit_12"))
        self.lineEdit_13 = QtGui.QLineEdit(Dialog_anzhi)
        self.lineEdit_13.setGeometry(QtCore.QRect(60, 320, 361, 20))
        self.lineEdit_13.setObjectName(_fromUtf8("lineEdit_13"))

        self.retranslateUi(Dialog_anzhi)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_anzhi)
        self.initDialog()
    
    def initDialog(self):
        try:
            #print os.path.abspath('.')
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
            self.lineEdit.setText(channel.get("appKey"))
            self.lineEdit_2.setText(channel.get("appSecret"))
            self.lineEdit_3.setText(channel.get("gameName"))
            
            orienIndex = self.comboBox.findText(channel.get("orientation"))
            if  orienIndex == -1:
                self.comboBox.setCurrentIndex(0)
            else:
                self.comboBox.setCurrentIndex(orienIndex)
                
            if channel.get("resVersion") != None:
                self.lineEdit_12.setText(channel.get("resVersion"))
            else:
                self.lineEdit_12.setText("")
            
            #平台信息
            platform = root.find("platform")
            self.lineEdit_7.setText(platform.get("gameId"))
            self.lineEdit_8.setText(platform.get("platformId"))
            self.lineEdit_9.setText(platform.get("appVersion"))
            self.lineEdit_10.setText(platform.get("platformType"))
            self.lineEdit_11.setText(platform.get("datacenter"))
            app = root.find("app")
            self.lineEdit_13.setText(app.get("packageName"))
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
    
    def onOkClicked(self):
        try:
            #print os.path.abspath('.')
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
            channel.set("appKey", unicode(self.lineEdit.text()))
            channel.set("appSecret", unicode(self.lineEdit_2.text()))
            channel.set("gameName", unicode(self.lineEdit_3.text()))
            channel.set("orientation", unicode(self.comboBox.currentText())) 

            channel.set("resVersion", unicode(self.lineEdit_12.text()))
            
            #平台信息
            platform = root.find("platform")
            platform.set("gameId", unicode(self.lineEdit_7.text()))
            platform.set("platformId", unicode(self.lineEdit_8.text()))
            platform.set("appVersion", unicode(self.lineEdit_9.text()))
            platform.set("platformType", unicode(self.lineEdit_10.text()))
            platform.set("datacenter", unicode(self.lineEdit_11.text()))
            
            app = root.find("app")
            app.set("packageName", unicode(self.lineEdit_13.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")

        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()        
    
    def retranslateUi(self, Dialog_anzhi):
        Dialog_anzhi.setWindowTitle(_translate("Dialog_anzhi", "Dialog_anzhi", None))
        self.pushButton.setText(_translate("Dialog_anzhi", "确定", None))
        self.groupBox.setTitle(_translate("Dialog_anzhi", "渠道信息", None))
        self.comboBox.setItemText(0, _translate("Dialog_anzhi", "HORIZONTAL", None))
        self.comboBox.setItemText(1, _translate("Dialog_anzhi", "VERTICAL", None))
        self.comboBox.setItemText(2, _translate("Dialog_anzhi", "SENSOR", None))
        self.label.setText(_translate("Dialog_anzhi", "appKey", None))
        self.label_2.setText(_translate("Dialog_anzhi", "appSecret", None))
        self.label_3.setText(_translate("Dialog_anzhi", "gameName", None))
        self.label_6.setText(_translate("Dialog_anzhi", "orientation", None))
        self.label_18.setText(_translate("Dialog_anzhi", "包名", None))
        self.groupBox_4.setTitle(_translate("Dialog_anzhi", "平台信息", None))
        self.label_12.setText(_translate("Dialog_anzhi", "gameId", None))
        self.label_13.setText(_translate("Dialog_anzhi", "platformId", None))
        self.label_14.setText(_translate("Dialog_anzhi", "appVersion", None))
        self.label_15.setText(_translate("Dialog_anzhi", "platformType", None))
        self.label_16.setText(_translate("Dialog_anzhi", "datacenter", None))
        self.label_17.setText(_translate("Dialog_anzhi", "resVersion", None))

class Dialoganzhi(QDialog,Ui_Dialog_anzhi):  
    def __init__(self,parent=None):  
        super(Dialoganzhi,self).__init__(parent)  
        self.setupUi(self)