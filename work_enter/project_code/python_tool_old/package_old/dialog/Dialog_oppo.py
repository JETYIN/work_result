# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_oppo.ui'
#
# Created: Sun Jan 25 17:14:06 2015
#      by: PyQt4 UI code generator 4.11.3
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

class Ui_Dialog(object):
    def setupUi(self, Dialog):
        Dialog.setObjectName(_fromUtf8("Dialog"))
        Dialog.resize(443, 467)
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(190, 430, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog)
        self.groupBox.setGeometry(QtCore.QRect(10, 20, 381, 211))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.comboBox_2 = QtGui.QComboBox(self.groupBox)
        self.comboBox_2.setGeometry(QtCore.QRect(130, 140, 211, 22))
        self.comboBox_2.setObjectName(_fromUtf8("comboBox_2"))
        self.comboBox_2.addItem(_fromUtf8(""))
        self.comboBox_2.addItem(_fromUtf8(""))
        self.lineEdit_4 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_4.setGeometry(QtCore.QRect(130, 80, 211, 20))
        self.lineEdit_4.setObjectName(_fromUtf8("lineEdit_4"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(20, 55, 54, 12))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.lineEdit_3 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_3.setGeometry(QtCore.QRect(130, 50, 211, 20))
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(20, 115, 111, 16))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.lineEdit_2 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_2.setGeometry(QtCore.QRect(130, 20, 211, 20))
        self.lineEdit_2.setObjectName(_fromUtf8("lineEdit_2"))
        self.comboBox = QtGui.QComboBox(self.groupBox)
        self.comboBox.setGeometry(QtCore.QRect(130, 111, 211, 22))
        self.comboBox.setObjectName(_fromUtf8("comboBox"))
        self.comboBox.addItem(_fromUtf8(""))
        self.comboBox.addItem(_fromUtf8(""))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(20, 25, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(20, 145, 81, 16))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(20, 85, 54, 12))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.lineEdit = QtGui.QLineEdit(self.groupBox)
        self.lineEdit.setGeometry(QtCore.QRect(190, 175, 151, 20))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(20, 178, 171, 16))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.label_13 = QtGui.QLabel(Dialog)
        self.label_13.setGeometry(QtCore.QRect(10, 390, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.lineEdit_11 = QtGui.QLineEdit(Dialog)
        self.lineEdit_11.setGeometry(QtCore.QRect(50, 386, 361, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 240, 421, 121))
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

        self.retranslateUi(Dialog)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog)
        
        self.initDialog()
        
    def initDialog(self):
        try:
            #print os.path.abspath('.')
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
            self.lineEdit_2.setText(channel.get("gameId"))
            self.lineEdit_3.setText(channel.get("appKey"))
            self.lineEdit_4.setText(channel.get("appSecret"))
            
            orienIndex = self.comboBox.findText(channel.get("isOrientationPort"))
            if  orienIndex == -1:
                self.comboBox.setCurrentIndex(0)
            else:
                self.comboBox.setCurrentIndex(orienIndex)
            
            orienIndex = self.comboBox.findText(channel.get("isDebugModel"))
            if  orienIndex == -1:
                self.comboBox.setCurrentIndex(0)
            else:
                self.comboBox.setCurrentIndex(orienIndex)
                
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
            
            #read form ForManifest.xml
            ET.register_namespace('android', constant.androidNS)
            configTree = ET.parse(file_operate.getForManifestXmlPath())
            configRoot = configTree.getroot()
            key = '{' + constant.androidNS + '}name'
            value = '{' + constant.androidNS + '}value'
            applicationCfg = configRoot.find("applicationCfg")
            if applicationCfg is None:
                return
            metaConfigList = applicationCfg.findall("meta-data")
            
            for child in metaConfigList:
                if child.attrib[key] == "CHINA_UNICOM_MOBILE_CHANNEL":
                    self.lineEdit.setText(child.attrib[value])
        
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
            channel.set("gameId", unicode(self.lineEdit_2.text()))
            channel.set("appKey", unicode(self.lineEdit_3.text()))
            channel.set("appSecret", unicode(self.lineEdit_4.text()))
            channel.set("isOrientationPort", unicode(self.comboBox.currentText()))
            channel.set("isDebugModel", unicode(self.comboBox_2.currentText())) 
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
            
            #write metadata to ForManifest
            ET.register_namespace('android', constant.androidNS)
            configTree = ET.parse(file_operate.getForManifestXmlPath())
            configRoot = configTree.getroot()
            key = '{' + constant.androidNS + '}name'
            value = '{' + constant.androidNS + '}value'
            applicationCfg = configRoot.find("applicationCfg")
            if applicationCfg is None:
                return
            metaConfigList = applicationCfg.findall("meta-data")
            
            for child in metaConfigList:
                if child.attrib[key] == "CHINA_UNICOM_MOBILE_CHANNEL":
                    child.set(value, unicode(self.lineEdit.text()))
                
            configTree.write(file_operate.getForManifestXmlPath(), "utf-8")
                    
        
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()

    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog_oppo", None))
        self.pushButton.setText(_translate("Dialog", "确定", None))
        self.groupBox.setTitle(_translate("Dialog", "渠道信息", None))
        self.comboBox_2.setItemText(0, _translate("Dialog", "false", None))
        self.comboBox_2.setItemText(1, _translate("Dialog", "true", None))
        self.label_2.setText(_translate("Dialog", "appKey", None))
        self.label_4.setText(_translate("Dialog", "isOrientationPort", None))
        self.comboBox.setItemText(0, _translate("Dialog", "false", None))
        self.comboBox.setItemText(1, _translate("Dialog", "true", None))
        self.label.setText(_translate("Dialog", "gameId", None))
        self.label_5.setText(_translate("Dialog", "isDebugModel", None))
        self.label_3.setText(_translate("Dialog", "appSecret", None))
        self.label_6.setText(_translate("Dialog", "CHINA_UNICOM_MOBILE_CHANNEL", None))
        self.label_13.setText(_translate("Dialog", "包名", None))
        self.groupBox_4.setTitle(_translate("Dialog", "平台信息", None))
        self.label_7.setText(_translate("Dialog", "gameId", None))
        self.label_8.setText(_translate("Dialog", "platformId", None))
        self.label_9.setText(_translate("Dialog", "appVersion", None))
        self.label_10.setText(_translate("Dialog", "platformType", None))
        self.label_11.setText(_translate("Dialog", "datacenter", None))
        self.label_12.setText(_translate("Dialog", "resVersion", None))
		
class Dialogoppo(QDialog,Ui_Dialog):  
    def __init__(self,parent=None):  
        super(Dialogoppo,self).__init__(parent)  
        self.setupUi(self)

