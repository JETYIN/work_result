# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_gfan.ui'
#
# Created: Sat Jan 24 08:52:16 2015
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

class Ui_Dialog_gfan(object):
    def setupUi(self, Dialog):
        Dialog.setObjectName(_fromUtf8("Dialog"))
        Dialog.resize(443, 344)
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(190, 304, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog)
        self.groupBox.setGeometry(QtCore.QRect(10, 10, 401, 91))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.lineEdit_2 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_2.setGeometry(QtCore.QRect(80, 58, 301, 20))
        self.lineEdit_2.setObjectName(_fromUtf8("lineEdit_2"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(20, 27, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(20, 61, 54, 12))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.lineEdit = QtGui.QLineEdit(self.groupBox)
        self.lineEdit.setGeometry(QtCore.QRect(80, 24, 301, 20))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.label_18 = QtGui.QLabel(Dialog)
        self.label_18.setGeometry(QtCore.QRect(10, 260, 54, 12))
        self.label_18.setObjectName(_fromUtf8("label_18"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog)
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
        self.lineEdit_11 = QtGui.QLineEdit(Dialog)
        self.lineEdit_11.setGeometry(QtCore.QRect(50, 256, 361, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))

        self.retranslateUi(Dialog)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog)
        
        self.initDialog()
    
    def initDialog(self):
        try:
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
                if child.attrib[key] == "gfan_pay_appkey":
                    self.lineEdit_2.setText(child.attrib[value])
                elif child.attrib[key] == "gfan_cpid":
                    self.lineEdit.setText(child.attrib[value])
                    
                    
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()
    
            #渠道信息
            channel = root.find("channel")
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
        
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        
        return

    def onOkClicked(self):
        try:
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
                if child.attrib[key] == "gfan_pay_appkey":
                    child.set(value, unicode(self.lineEdit_2.text()))
                elif child.attrib[key] == "gfan_cpid":
                    child.set(value, unicode(self.lineEdit.text()))
               
            configTree.write(file_operate.getForManifestXmlPath(), "utf-8")
            
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
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
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()
   
    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog", None))
        self.pushButton.setText(_translate("Dialog", "确定", None))
        self.groupBox.setTitle(_translate("Dialog", "渠道信息", None))
        self.label.setText(_translate("Dialog", "cpId", None))
        self.label_2.setText(_translate("Dialog", "appKey", None))
        self.label_18.setText(_translate("Dialog", "包名", None))
        self.groupBox_4.setTitle(_translate("Dialog", "平台信息", None))
        self.label_12.setText(_translate("Dialog", "gameId", None))
        self.label_13.setText(_translate("Dialog", "platformId", None))
        self.label_14.setText(_translate("Dialog", "appVersion", None))
        self.label_15.setText(_translate("Dialog", "platformType", None))
        self.label_16.setText(_translate("Dialog", "datacenter", None))
        self.label_17.setText(_translate("Dialog", "resVersion", None))
		
class Dialoggfan(QDialog,Ui_Dialog_gfan):  
    def __init__(self,parent=None):  
        super(Dialoggfan,self).__init__(parent)  
        self.setupUi(self)

