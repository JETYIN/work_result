# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_aipai.ui'
#
# Created: Mon Jul 06 17:50:01 2015
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

class Ui_Dialog_aipai(object):
    def setupUi(self, Dialog_aipai):
        Dialog_aipai.setObjectName(_fromUtf8("Dialog_aipai"))
        Dialog_aipai.resize(452, 403)
        self.pushButton = QtGui.QPushButton(Dialog_aipai)
        self.pushButton.setGeometry(QtCore.QRect(170, 370, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog_aipai)
        self.groupBox.setGeometry(QtCore.QRect(10, 20, 411, 161))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.lineEdit_4 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_4.setGeometry(QtCore.QRect(60, 60, 121, 16))
        self.lineEdit_4.setObjectName(_fromUtf8("lineEdit_4"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(10, 30, 31, 16))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(10, 60, 54, 12))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.lineEdit_3 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_3.setGeometry(QtCore.QRect(60, 30, 121, 16))
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(10, 90, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.lineEdit = QtGui.QLineEdit(self.groupBox)
        self.lineEdit.setGeometry(QtCore.QRect(60, 90, 121, 16))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(0, 120, 54, 12))
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
        self.label_14.setGeometry(QtCore.QRect(200, 90, 71, 16))
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
        self.groupBox_4 = QtGui.QGroupBox(Dialog_aipai)
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
        self.lineEdit_11 = QtGui.QLineEdit(Dialog_aipai)
        self.lineEdit_11.setGeometry(QtCore.QRect(50, 340, 361, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))
        self.label_13 = QtGui.QLabel(Dialog_aipai)
        self.label_13.setGeometry(QtCore.QRect(10, 340, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))

        self.retranslateUi(Dialog_aipai)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), Dialog_aipai.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_aipai)
        self.initDialog()

    def retranslateUi(self, Dialog_aipai):
        Dialog_aipai.setWindowTitle(_translate("Dialog_aipai", "Config_aipai", None))
        self.pushButton.setText(_translate("Dialog_aipai", "确定", None))
        self.groupBox.setTitle(_translate("Dialog_aipai", "渠道信息", None))
        self.label_5.setText(_translate("Dialog_aipai", "AppId", None))
        self.label_6.setText(_translate("Dialog_aipai", "Data_key", None))
        self.label.setText(_translate("Dialog_aipai", "channel", None))
        self.label_2.setText(_translate("Dialog_aipai", "secureKey", None))
        self.label_3.setText(_translate("Dialog_aipai", "aipai_gameid", None))
        self.label_4.setText(_translate("Dialog_aipai", "aipai_apk_channel", None))
        self.label_14.setText(_translate("Dialog_aipai", "aipai_sns", None))
        self.label_15.setText(_translate("Dialog_aipai", "game_activity", None))
        self.groupBox_4.setTitle(_translate("Dialog_aipai", "平台信息", None))
        self.label_7.setText(_translate("Dialog_aipai", "gameId", None))
        self.label_8.setText(_translate("Dialog_aipai", "platformId", None))
        self.label_9.setText(_translate("Dialog_aipai", "appVersion", None))
        self.label_10.setText(_translate("Dialog_aipai", "platformType", None))
        self.label_11.setText(_translate("Dialog_aipai", "datacenter", None))
        self.label_12.setText(_translate("Dialog_aipai", "resVersion", None))
        self.label_13.setText(_translate("Dialog_aipai", "包名", None))
        
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
                if child.attrib[key] == "app_id":
                    self.lineEdit_3.setText(child.attrib[value])
                elif child.attrib[key] == "data_key":
                    self.lineEdit_4.setText(child.attrib[value])
                elif child.attrib[key] == "channel":
                    self.lineEdit.setText(child.attrib[value])
            
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
            self.lineEdit_3.setText(channel.get("appId"))
            self.lineEdit_4.setText(channel.get("data_key"))
            self.lineEdit.setText(channel.get("channel"))
            self.lineEdit_2.setText(channel.get("secureKey"))
            self.lineEdit_12.setText(channel.get("aipai_gameid"))
            self.lineEdit_13.setText(channel.get("aipai_apk_channel"))
            self.lineEdit_14.setText(channel.get("aipai_sns"))
            self.lineEdit_15.setText(channel.get("game_activity"))
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
                if child.attrib[key] == "app_id":
                    child.set(value, unicode(self.lineEdit_3.text()))
                elif child.attrib[key] == "game_activity":
                    child.set(value, unicode(self.lineEdit_15.text()))
                elif child.attrib[key] == "data_key":
                    child.set(value, unicode(self.lineEdit_4.text()))
                elif child.attrib[key] == "channel":
                    child.set(value, unicode(self.lineEdit.text()))
                elif child.attrib[key] == "aipai.gameid":
                    child.set(value, unicode(self.lineEdit_12.text()))
                elif child.attrib[key] == "aipai.apk-channel":
                    child.set(value, unicode(self.lineEdit_13.text()))
                elif child.attrib[key] == "aipai.sns":
                    child.set(value, unicode(self.lineEdit_14.text()))
                elif child.attrib[key] == "aipai.game-activity":
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
            channel.set("appId", unicode(self.lineEdit_3.text()))
            channel.set("data_key", unicode(self.lineEdit_4.text()))
            channel.set("channel", unicode(self.lineEdit.text()))
            channel.set("secureKey", unicode(self.lineEdit_2.text()))
            channel.set("aipai_gameid", unicode(self.lineEdit_12.text()))
            channel.set("aipai_apk_channel", unicode(self.lineEdit_13.text()))
            channel.set("aipai_sns", unicode(self.lineEdit_14.text()))
            channel.set("game_activity", unicode(self.lineEdit_15.text()))
            channel.set("resVersion", unicode(self.lineEdit_10.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()
    
class Dialogaipai(QDialog,Ui_Dialog_aipai):  
    def __init__(self,parent=None):  
        super(Dialogaipai,self).__init__(parent)  
        self.setupUi(self)
