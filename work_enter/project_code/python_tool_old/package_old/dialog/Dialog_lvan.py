# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_lvan.ui'
#
# Created by: PyQt4 UI code generator 4.11.4
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
        Dialog.resize(440, 398)
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(180, 360, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog)
        self.groupBox.setGeometry(QtCore.QRect(10, 10, 361, 151))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.channel = QtGui.QLineEdit(self.groupBox)
        self.channel.setGeometry(QtCore.QRect(90, 120, 261, 20))
        self.channel.setObjectName(_fromUtf8("channel"))
        self.appKey = QtGui.QLineEdit(self.groupBox)
        self.appKey.setGeometry(QtCore.QRect(90, 50, 261, 20))
        self.appKey.setObjectName(_fromUtf8("appKey"))
        self.appId = QtGui.QLineEdit(self.groupBox)
        self.appId.setGeometry(QtCore.QRect(90, 20, 261, 20))
        self.appId.setObjectName(_fromUtf8("appId"))
        self.WWS_CHANNELt = QtGui.QLabel(self.groupBox)
        self.WWS_CHANNELt.setGeometry(QtCore.QRect(10, 120, 71, 20))
        self.WWS_CHANNELt.setObjectName(_fromUtf8("WWS_CHANNELt"))
        self.appIdt = QtGui.QLabel(self.groupBox)
        self.appIdt.setGeometry(QtCore.QRect(10, 25, 54, 12))
        self.appIdt.setObjectName(_fromUtf8("appIdt"))
        self.appKeyt = QtGui.QLabel(self.groupBox)
        self.appKeyt.setGeometry(QtCore.QRect(10, 55, 54, 12))
        self.appKeyt.setObjectName(_fromUtf8("appKeyt"))
        self.privateKey = QtGui.QLineEdit(self.groupBox)
        self.privateKey.setGeometry(QtCore.QRect(90, 85, 261, 20))
        self.privateKey.setObjectName(_fromUtf8("privateKey"))
        self.pri = QtGui.QLabel(self.groupBox)
        self.pri.setGeometry(QtCore.QRect(10, 90, 71, 16))
        self.pri.setObjectName(_fromUtf8("pri"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 170, 421, 121))
        self.groupBox_4.setObjectName(_fromUtf8("groupBox_4"))
        self.label_9 = QtGui.QLabel(self.groupBox_4)
        self.label_9.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_9.setObjectName(_fromUtf8("label_9"))
        self.gameId = QtGui.QLineEdit(self.groupBox_4)
        self.gameId.setGeometry(QtCore.QRect(80, 28, 113, 20))
        self.gameId.setObjectName(_fromUtf8("gameId"))
        self.label_10 = QtGui.QLabel(self.groupBox_4)
        self.label_10.setGeometry(QtCore.QRect(220, 28, 61, 16))
        self.label_10.setObjectName(_fromUtf8("label_10"))
        self.platformId = QtGui.QLineEdit(self.groupBox_4)
        self.platformId.setGeometry(QtCore.QRect(300, 28, 113, 20))
        self.platformId.setObjectName(_fromUtf8("platformId"))
        self.label_11 = QtGui.QLabel(self.groupBox_4)
        self.label_11.setGeometry(QtCore.QRect(10, 60, 61, 16))
        self.label_11.setObjectName(_fromUtf8("label_11"))
        self.appVersion = QtGui.QLineEdit(self.groupBox_4)
        self.appVersion.setGeometry(QtCore.QRect(80, 59, 113, 20))
        self.appVersion.setObjectName(_fromUtf8("appVersion"))
        self.label_12 = QtGui.QLabel(self.groupBox_4)
        self.label_12.setGeometry(QtCore.QRect(220, 58, 81, 20))
        self.label_12.setObjectName(_fromUtf8("label_12"))
        self.platformType = QtGui.QLineEdit(self.groupBox_4)
        self.platformType.setGeometry(QtCore.QRect(300, 59, 113, 20))
        self.platformType.setObjectName(_fromUtf8("platformType"))
        self.label_14 = QtGui.QLabel(self.groupBox_4)
        self.label_14.setGeometry(QtCore.QRect(10, 90, 61, 16))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.datacenter = QtGui.QLineEdit(self.groupBox_4)
        self.datacenter.setGeometry(QtCore.QRect(80, 90, 113, 20))
        self.datacenter.setObjectName(_fromUtf8("datacenter"))
        self.label_15 = QtGui.QLabel(self.groupBox_4)
        self.label_15.setGeometry(QtCore.QRect(221, 90, 61, 16))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.resVersion = QtGui.QLineEdit(self.groupBox_4)
        self.resVersion.setGeometry(QtCore.QRect(300, 89, 113, 20))
        self.resVersion.setObjectName(_fromUtf8("resVersion"))
        self.label_13 = QtGui.QLabel(Dialog)
        self.label_13.setGeometry(QtCore.QRect(10, 314, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.package_2 = QtGui.QLineEdit(Dialog)
        self.package_2.setGeometry(QtCore.QRect(50, 310, 361, 20))
        self.package_2.setObjectName(_fromUtf8("package_2"))

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
            self.appId.setText(channel.get("appId"))
            self.appKey.setText(channel.get("appKey"))
            self.privateKey.setText(channel.get("privateKey"))
            self.channel.setText(channel.get("channel"))
            
            if channel.get("resVersion") != None:
                self.resVersion.setText(channel.get("resVersion"))
            else:
                self.resVersion.setText("")

            #平台信息
            platform = root.find("platform")
            self.gameId.setText(platform.get("gameId"))
            self.platformId.setText(platform.get("platformId"))
            self.appVersion.setText(platform.get("appVersion"))
            self.platformType.setText(platform.get("platformType"))
            self.datacenter.setText(platform.get("datacenter"))
            app = root.find("app")
            self.package_2.setText(app.get("packageName"))
            
            #read form ForManifest.xml
            ET.register_namespace('android', constant.androidNS)
            configTree = ET.parse(file_operate.getForManifestXmlPath())
            configRoot = configTree.getroot()
            key = '{' + constant.androidNS + '}name'
            value = '{' + constant.androidNS + '}value'
            applicationCfg = configRoot.find("applicationCfg")
            if applicationCfg is None:
                return
#             metaConfigList = applicationCfg.findall("meta-data")
            
#             for child in metaConfigList:
#                 if child.attrib[key] == "WWS_CHANNEL":
#                     self.lineEdit_3.setText(child.attrib[value])
                
               
        
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
            channel.set("appId", unicode(self.appId.text()))
            channel.set("appKey", unicode(self.appKey.text())) 
            channel.set("privateKey",unicode(self.privateKey.text()))
            channel.set("channel",unicode(self.channel.text()))
            
            channel.set("resVersion", unicode(self.resVersion.text()))
            
            #平台信息
            platform = root.find("platform")
            platform.set("gameId", unicode(self.gameId.text()))
            platform.set("platformId", unicode(self.platformId.text()))
            platform.set("appVersion", unicode(self.appVersion.text()))
            platform.set("platformType", unicode(self.platformType.text()))
            platform.set("datacenter", unicode(self.datacenter.text()))
            
            app = root.find("app")
            app.set("packageName", unicode(self.package_2.text()))
            
            
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
                if child.attrib[key] == "LVANSDK_APPID":
                    child.set(value, unicode(self.appId.text()))
                if child.attrib[key] == "LVANSDK_APPKEY":
                    child.set(value, unicode(self.appKey.text()))   
                if child.attrib[key] == "LVANSDK_PRIVATEKEY":
                    child.set(value, unicode(self.privateKey.text()))
                if child.attrib[key] == "LVANSDK_CHANNEL":
                    child.set(value, unicode(self.channel.text()))
                    
            configTree.write(file_operate.getForManifestXmlPath(), "utf-8")
                    
        
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()
    
    

    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog_funcell", None))
        self.pushButton.setText(_translate("Dialog", "确定", None))
        self.groupBox.setTitle(_translate("Dialog", "渠道信息", None))
        self.WWS_CHANNELt.setText(_translate("Dialog", "LV_CHANNEL", None))
        self.appIdt.setText(_translate("Dialog", "appId", None))
        self.appKeyt.setText(_translate("Dialog", "appKey", None))
        self.pri.setText(_translate("Dialog", "privatekey", None))
        self.groupBox_4.setTitle(_translate("Dialog", "平台信息", None))
        self.label_9.setText(_translate("Dialog", "gameId", None))
        self.label_10.setText(_translate("Dialog", "platformId", None))
        self.label_11.setText(_translate("Dialog", "appVersion", None))
        self.label_12.setText(_translate("Dialog", "platformType", None))
        self.label_14.setText(_translate("Dialog", "datacenter", None))
        self.label_15.setText(_translate("Dialog", "resVersion", None))
        self.label_13.setText(_translate("Dialog", "包名", None))

class Dialoglvan(QDialog,Ui_Dialog):
    def __init__(self,parent=None):  
        super(Dialoglvan,self).__init__(parent)  
        self.setupUi(self)