# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_yijiedianyi.ui'
#
# Created: Thu Dec 07 15:37:16 2017
#      by: PyQt4 UI code generator 4.10.3
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

class Ui_Dialog_yijiedianyi(object):
    def setupUi(self, Dialog_yijiedianyi):
        Dialog_yijiedianyi.setObjectName(_fromUtf8("Dialog_yijiedianyi"))
        Dialog_yijiedianyi.resize(447, 419)
        self.pushButton = QtGui.QPushButton(Dialog_yijiedianyi)
        self.pushButton.setGeometry(QtCore.QRect(180, 380, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog_yijiedianyi)
        self.groupBox.setEnabled(True)
        self.groupBox.setGeometry(QtCore.QRect(20, 20, 381, 171))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(30, 80, 54, 12))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.appId = QtGui.QLineEdit(self.groupBox)
        self.appId.setEnabled(False)
        self.appId.setGeometry(QtCore.QRect(100, 80, 191, 20))
        self.appId.setObjectName(_fromUtf8("appId"))
        self.label_13 = QtGui.QLabel(Dialog_yijiedianyi)
        self.label_13.setGeometry(QtCore.QRect(10, 340, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.packageName = QtGui.QLineEdit(Dialog_yijiedianyi)
        self.packageName.setGeometry(QtCore.QRect(50, 336, 361, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog_yijiedianyi)
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

        self.retranslateUi(Dialog_yijiedianyi)
        QtCore.QMetaObject.connectSlotsByName(Dialog_yijiedianyi)
        self.pushButton.clicked.connect(self.onOkClicked)
        self.initDialog()

    def retranslateUi(self, Dialog_yijiedianyi):
        Dialog_yijiedianyi.setWindowTitle(_translate("Dialog_yijiedianyi", "Dialog", None))
        self.pushButton.setText(_translate("Dialog_yijiedianyi", "确定", None))
        self.groupBox.setTitle(_translate("Dialog_yijiedianyi", "渠道信息", None))
        self.label_2.setText(_translate("Dialog_yijiedianyi", "appId", None))
        self.label_13.setText(_translate("Dialog_yijiedianyi", "包名", None))
        self.groupBox_4.setTitle(_translate("Dialog_yijiedianyi", "平台信息", None))
        self.label_7.setText(_translate("Dialog_yijiedianyi", "gameId", None))
        self.label_8.setText(_translate("Dialog_yijiedianyi", "platformId", None))
        self.label_9.setText(_translate("Dialog_yijiedianyi", "appVersion", None))
        self.label_10.setText(_translate("Dialog_yijiedianyi", "platformType", None))
        self.label_11.setText(_translate("Dialog_yijiedianyi", "datacenter", None))
        self.label_12.setText(_translate("Dialog_yijiedianyi", "resVersion", None))

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

class Dialogyijiedianyi(QDialog, Ui_Dialog_yijiedianyi):
    def __init__(self, parent=None):  
        super(Dialogyijiedianyi, self).__init__(parent)  
        self.setupUi(self)