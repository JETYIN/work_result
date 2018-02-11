# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_ydmm.ui'
#
# Created: Wed Jan 28 10:51:25 2015
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

class Ui_Dialog(object):
    def setupUi(self, Dialog):
        Dialog.setObjectName(_fromUtf8("Dialog"))
        Dialog.resize(335, 249)
        self.label = QtGui.QLabel(Dialog)
        self.label.setGeometry(QtCore.QRect(30, 30, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.label_2 = QtGui.QLabel(Dialog)
        self.label_2.setGeometry(QtCore.QRect(30, 70, 54, 12))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.label_3 = QtGui.QLabel(Dialog)
        self.label_3.setGeometry(QtCore.QRect(30, 110, 54, 12))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.label_4 = QtGui.QLabel(Dialog)
        self.label_4.setGeometry(QtCore.QRect(30, 150, 91, 16))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(130, 200, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.lineEdit = QtGui.QLineEdit(Dialog)
        self.lineEdit.setGeometry(QtCore.QRect(110, 30, 191, 20))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.lineEdit_2 = QtGui.QLineEdit(Dialog)
        self.lineEdit_2.setGeometry(QtCore.QRect(110, 70, 191, 20))
        self.lineEdit_2.setObjectName(_fromUtf8("lineEdit_2"))
        self.lineEdit_3 = QtGui.QLineEdit(Dialog)
        self.lineEdit_3.setGeometry(QtCore.QRect(110, 110, 191, 20))
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.lineEdit_4 = QtGui.QLineEdit(Dialog)
        self.lineEdit_4.setGeometry(QtCore.QRect(110, 150, 191, 20))
        self.lineEdit_4.setObjectName(_fromUtf8("lineEdit_4"))

        self.retranslateUi(Dialog)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog)
        
        self.initDialog()

    def initDialog(self):
        config = ET.parse(file_operate.getConfigXmlPath())
        root = config.getroot()

        #渠道信息
        channel = root.find("channel")
        self.lineEdit.setText(channel.get("appId"))
        self.lineEdit_2.setText(channel.get("appKey"))
        self.lineEdit_3.setText(channel.get("iconName"))
        self.lineEdit_4.setText(channel.get("userCenterUrl"))
        
    def onOkClicked(self):
        try:
            #print os.path.abspath('.')
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
            channel.set("appId", unicode(self.lineEdit.text()))
            channel.set("appKey", unicode(self.lineEdit_2.text())) 
            channel.set("iconName", unicode(self.lineEdit_3.text())) 
            channel.set("userCenterUrl", unicode(self.lineEdit_4.text())) 

            config.write(file_operate.getConfigXmlPath(), "utf-8")
        
        except Exception,e:
            print e
            print "Error: cannot parse file: config.xml."
            return -1
        self.close()

    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog_ydmm", None))
        self.label.setText(_translate("Dialog", "appId", None))
        self.label_2.setText(_translate("Dialog", "appKey", None))
        self.label_3.setText(_translate("Dialog", "iconName", None))
        self.label_4.setText(_translate("Dialog", "userCenterUrl", None))
        self.pushButton.setText(_translate("Dialog", "确定", None))

class Dialogydmm(QDialog,Ui_Dialog):  
    def __init__(self,parent=None):  
        super(Dialogydmm,self).__init__(parent)  
        self.setupUi(self)

