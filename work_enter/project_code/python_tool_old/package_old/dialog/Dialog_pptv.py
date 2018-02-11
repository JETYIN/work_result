# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_pptv.ui'
#
# Created: Wed Jul 08 19:09:55 2015
#      by: PyQt4 UI code generator 4.11.3
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

class Ui_Dialog_pptv(object):
    def setupUi(self, Dialog_pptv):
        Dialog_pptv.setObjectName(_fromUtf8("Dialog_pptv"))
        Dialog_pptv.resize(452, 403)
        self.pushButton = QtGui.QPushButton(Dialog_pptv)
        self.pushButton.setGeometry(QtCore.QRect(170, 370, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog_pptv)
        self.groupBox.setGeometry(QtCore.QRect(10, 20, 411, 161))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.lineEdit_4 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_4.setGeometry(QtCore.QRect(60, 60, 121, 16))
        self.lineEdit_4.setObjectName(_fromUtf8("lineEdit_4"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(10, 30, 31, 16))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(0, 60, 54, 12))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.lineEdit_3 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_3.setGeometry(QtCore.QRect(60, 30, 121, 16))
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(0, 90, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.lineEdit = QtGui.QLineEdit(self.groupBox)
        self.lineEdit.setGeometry(QtCore.QRect(60, 90, 121, 16))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(10, 120, 31, 16))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.lineEdit_2 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_2.setGeometry(QtCore.QRect(60, 120, 121, 16))
        self.lineEdit_2.setObjectName(_fromUtf8("lineEdit_2"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(200, 30, 71, 16))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.lineEdit_12 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_12.setGeometry(QtCore.QRect(280, 30, 121, 16))
        self.lineEdit_12.setObjectName(_fromUtf8("lineEdit_12"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(200, 60, 81, 16))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.lineEdit_13 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_13.setGeometry(QtCore.QRect(280, 60, 121, 16))
        self.lineEdit_13.setObjectName(_fromUtf8("lineEdit_13"))
        self.label_14 = QtGui.QLabel(self.groupBox)
        self.label_14.setGeometry(QtCore.QRect(200, 90, 71, 20))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.lineEdit_14 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_14.setGeometry(QtCore.QRect(280, 90, 121, 16))
        self.lineEdit_14.setObjectName(_fromUtf8("lineEdit_14"))
        self.label_15 = QtGui.QLabel(self.groupBox)
        self.label_15.setGeometry(QtCore.QRect(200, 120, 71, 16))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.lineEdit_15 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_15.setGeometry(QtCore.QRect(280, 120, 121, 16))
        self.lineEdit_15.setObjectName(_fromUtf8("lineEdit_15"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog_pptv)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 200, 421, 121))
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
        self.lineEdit_11 = QtGui.QLineEdit(Dialog_pptv)
        self.lineEdit_11.setGeometry(QtCore.QRect(50, 340, 361, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))
        self.label_13 = QtGui.QLabel(Dialog_pptv)
        self.label_13.setGeometry(QtCore.QRect(10, 340, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))

        self.retranslateUi(Dialog_pptv)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), Dialog_pptv.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_pptv)
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
            self.lineEdit_3.setText(channel.get("gid"))
            self.lineEdit_4.setText(channel.get("checkUpdate"))
            self.lineEdit.setText(channel.get("UMENG_APPKEY"))
            self.lineEdit_2.setText(channel.get("cid"))
            self.lineEdit_12.setText(channel.get("useUMeng"))
            self.lineEdit_13.setText(channel.get("app_secret"))
            self.lineEdit_14.setText(channel.get("UMENG_CHANNEL"))
            self.lineEdit_15.setText(channel.get("ccid"))
            if channel.get("resVersion") != None:
                self.lineEdit_10.setText(channel.get("resVersion"))
            else:
                self.lineEdit_10.setText("")
            
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
                if child.attrib[key] == "UMENG_APPKEY":
                    child.set(value, unicode(self.lineEdit.text()))
                elif child.attrib[key] == "UMENG_CHANNEL":
                    child.set(value, unicode(self.lineEdit_14.text()))
                elif child.attrib[key] == "PptvVasSdk_CID":
                    child.set(value, unicode(self.lineEdit_2.text()))
                elif child.attrib[key] == "PptvVasSdk_CCID":
                    child.set(value, unicode(self.lineEdit_15.text()))
            
            configTree.write(file_operate.getForManifestXmlPath(), "utf-8")
            
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
            channel.set("gid", unicode(self.lineEdit_3.text()))
            channel.set("checkUpdate", unicode(self.lineEdit_4.text()))
            channel.set("UMENG_APPKEY", unicode(self.lineEdit.text()))
            channel.set("cid", unicode(self.lineEdit_2.text()))
            channel.set("useUMeng", unicode(self.lineEdit_12.text()))
            channel.set("app_secret", unicode(self.lineEdit_13.text()))
            channel.set("UMENG_CHANNEL", unicode(self.lineEdit_14.text()))
            channel.set("ccid", unicode(self.lineEdit_15.text()))
            channel.set("resVersion", unicode(self.lineEdit_10.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()
    
    def retranslateUi(self, Dialog_pptv):
        Dialog_pptv.setWindowTitle(_translate("Dialog_pptv", "Config_pptv", None))
        self.pushButton.setText(_translate("Dialog_pptv", "确定", None))
        self.groupBox.setTitle(_translate("Dialog_pptv", "渠道信息", None))
        self.label_5.setText(_translate("Dialog_pptv", "gid", None))
        self.label_6.setText(_translate("Dialog_pptv", "checkUpdate", None))
        self.label.setText(_translate("Dialog_pptv", "UMENG_APPKEY", None))
        self.label_2.setText(_translate("Dialog_pptv", "cid", None))
        self.label_3.setText(_translate("Dialog_pptv", "useUMeng", None))
        self.label_4.setText(_translate("Dialog_pptv", "app_secret", None))
        self.label_14.setText(_translate("Dialog_pptv", "UMENG_CHANNEL", None))
        self.label_15.setText(_translate("Dialog_pptv", "ccid", None))
        self.groupBox_4.setTitle(_translate("Dialog_pptv", "平台信息", None))
        self.label_7.setText(_translate("Dialog_pptv", "gameId", None))
        self.label_8.setText(_translate("Dialog_pptv", "platformId", None))
        self.label_9.setText(_translate("Dialog_pptv", "appVersion", None))
        self.label_10.setText(_translate("Dialog_pptv", "platformType", None))
        self.label_11.setText(_translate("Dialog_pptv", "datacenter", None))
        self.label_12.setText(_translate("Dialog_pptv", "resVersion", None))
        self.label_13.setText(_translate("Dialog_pptv", "包名", None))

class Dialogpptv(QDialog,Ui_Dialog_pptv):  
    def __init__(self,parent=None):  
        super(Dialogpptv,self).__init__(parent)  
        self.setupUi(self)