# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_guopan.ui'
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

class Ui_Dialog_guopan(object):
    def setupUi(self, Dialog_guopan):
        Dialog_guopan.setObjectName(_fromUtf8("Dialog_guopan"))
        Dialog_guopan.resize(447, 419)
        self.pushButton = QtGui.QPushButton(Dialog_guopan)
        self.pushButton.setGeometry(QtCore.QRect(180, 380, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog_guopan)
        self.groupBox.setEnabled(True)
        self.groupBox.setGeometry(QtCore.QRect(20, 20, 381, 171))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(30, 80, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.appKey = QtGui.QLineEdit(self.groupBox)
        self.appKey.setEnabled(False)
        self.appKey.setGeometry(QtCore.QRect(90, 80, 191, 20))
        self.appKey.setObjectName(_fromUtf8("appKey"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(30, 50, 54, 12))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.appId = QtGui.QLineEdit(self.groupBox)
        self.appId.setEnabled(False)
        self.appId.setGeometry(QtCore.QRect(90, 40, 191, 20))
        self.appId.setObjectName(_fromUtf8("appId"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(30, 120, 54, 12))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.rate = QtGui.QLineEdit(self.groupBox)
        self.rate.setEnabled(True)
        self.rate.setGeometry(QtCore.QRect(90, 120, 61, 20))
        self.rate.setObjectName(_fromUtf8("rate"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(170, 120, 171, 21))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.label_13 = QtGui.QLabel(Dialog_guopan)
        self.label_13.setGeometry(QtCore.QRect(10, 340, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.packageName = QtGui.QLineEdit(Dialog_guopan)
        self.packageName.setGeometry(QtCore.QRect(50, 336, 361, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog_guopan)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 190, 421, 121))
        self.groupBox_4.setObjectName(_fromUtf8("groupBox_4"))
        self.label_7 = QtGui.QLabel(self.groupBox_4)
        self.label_7.setGeometry(QtCore.QRect(20, 30, 54, 12))
        self.label_7.setObjectName(_fromUtf8("label_7"))
        self.gameId = QtGui.QLineEdit(self.groupBox_4)
        self.gameId.setGeometry(QtCore.QRect(80, 28, 113, 20))
        self.gameId.setObjectName(_fromUtf8("gameId"))
        self.label_8 = QtGui.QLabel(self.groupBox_4)
        self.label_8.setGeometry(QtCore.QRect(220, 28, 61, 16))
        self.label_8.setObjectName(_fromUtf8("label_8"))
        self.platformId = QtGui.QLineEdit(self.groupBox_4)
        self.platformId.setGeometry(QtCore.QRect(300, 28, 113, 20))
        self.platformId.setObjectName(_fromUtf8("platformId"))
        self.label_9 = QtGui.QLabel(self.groupBox_4)
        self.label_9.setGeometry(QtCore.QRect(10, 60, 61, 16))
        self.label_9.setObjectName(_fromUtf8("label_9"))
        self.appVersion = QtGui.QLineEdit(self.groupBox_4)
        self.appVersion.setGeometry(QtCore.QRect(80, 59, 113, 20))
        self.appVersion.setObjectName(_fromUtf8("appVersion"))
        self.label_10 = QtGui.QLabel(self.groupBox_4)
        self.label_10.setGeometry(QtCore.QRect(220, 58, 81, 20))
        self.label_10.setObjectName(_fromUtf8("label_10"))
        self.platformType = QtGui.QLineEdit(self.groupBox_4)
        self.platformType.setGeometry(QtCore.QRect(300, 59, 113, 20))
        self.platformType.setObjectName(_fromUtf8("platformType"))
        self.label_11 = QtGui.QLabel(self.groupBox_4)
        self.label_11.setGeometry(QtCore.QRect(10, 90, 61, 16))
        self.label_11.setObjectName(_fromUtf8("label_11"))
        self.datacenter = QtGui.QLineEdit(self.groupBox_4)
        self.datacenter.setGeometry(QtCore.QRect(80, 90, 113, 20))
        self.datacenter.setObjectName(_fromUtf8("datacenter"))
        self.label_12 = QtGui.QLabel(self.groupBox_4)
        self.label_12.setGeometry(QtCore.QRect(221, 90, 61, 16))
        self.label_12.setObjectName(_fromUtf8("label_12"))
        self.resVersion = QtGui.QLineEdit(self.groupBox_4)
        self.resVersion.setGeometry(QtCore.QRect(300, 89, 113, 20))
        self.resVersion.setObjectName(_fromUtf8("resVersion"))

        self.retranslateUi(Dialog_guopan)
        self.pushButton.clicked.connect(self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_guopan)
        self.initDialog()

    def retranslateUi(self, Dialog_guopan):
        Dialog_guopan.setWindowTitle(_translate("Dialog_guopan", "Dialog", None))
        self.pushButton.setText(_translate("Dialog_guopan", "确定", None))
        self.groupBox.setTitle(_translate("Dialog_guopan", "渠道信息", None))
        self.label.setText(_translate("Dialog_guopan", "appKey", None))
        self.label_2.setText(_translate("Dialog_guopan", "appId", None))
        self.label_3.setText(_translate("Dialog_guopan", "rate", None))
        self.label_4.setText(_translate("Dialog_guopan", "人民币-虚拟货币兑换比例1：10", None))
        self.label_13.setText(_translate("Dialog_guopan", "包名", None))
        self.groupBox_4.setTitle(_translate("Dialog_guopan", "平台信息", None))
        self.label_7.setText(_translate("Dialog_guopan", "gameId", None))
        self.label_8.setText(_translate("Dialog_guopan", "platformId", None))
        self.label_9.setText(_translate("Dialog_guopan", "appVersion", None))
        self.label_10.setText(_translate("Dialog_guopan", "platformType", None))
        self.label_11.setText(_translate("Dialog_guopan", "datacenter", None))
        self.label_12.setText(_translate("Dialog_guopan", "resVersion", None))

    def initDialog(self):
        try:
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            # 渠道信息
            channel = root.find("channel")
          
            if channel.get("resVersion") != None:
                self.resVersion.setText(channel.get("resVersion"))
            else:
                self.resVersion.setText("")
            
            self.appId.setText(channel.get("appId"))
            self.appKey.setText(channel.get("appKey"))
            self.rate.setText(channel.get("rate"))
            # 平台信息
            platform = root.find("platform")
            self.gameId.setText(platform.get("gameId"))
            self.platformId.setText(platform.get("platformId"))
            self.appVersion.setText(platform.get("appVersion"))
            self.platformType.setText(platform.get("platformType"))
            self.datacenter.setText(platform.get("datacenter"))
            
            app = root.find("app")
            self.packageName.setText(app.get("packageName"))
        except Exception, e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        return
    
    def onOkClicked(self):
        try:
            # print os.path.abspath('.')
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            # 渠道信息
            channel = root.find("channel")
            channel.set("resVersion", unicode(self.resVersion.text()))
            channel.set("rate", unicode(self.rate.text()))
            # 平台信息
            platform = root.find("platform")
            platform.set("gameId", unicode(self.gameId.text()))
            platform.set("platformId", unicode(self.platformId.text()))
            platform.set("appVersion", unicode(self.appVersion.text()))
            platform.set("platformType", unicode(self.platformType.text()))
            platform.set("datacenter", unicode(self.datacenter.text()))
            
            app = root.find("app")
            app.set("packageName", unicode(self.packageName.text()))

            config.write(file_operate.getConfigXmlPath(), "utf-8")
        except Exception, e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()
        
class Dialogguopan(QDialog, Ui_Dialog_guopan):
    def __init__(self, parent=None):  
        super(Dialogguopan, self).__init__(parent)  
        self.setupUi(self)