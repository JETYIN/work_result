# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'F:\funcell\android_pack\ui\Dialog_funcell.ui'
#
# Created: Wed Apr 01 17:29:28 2015
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
        Dialog.resize(440, 361)
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(180, 320, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog)
        self.groupBox.setGeometry(QtCore.QRect(10, 10, 361, 111))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.lineEdit_3 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_3.setGeometry(QtCore.QRect(90, 80, 261, 20))
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.lineEdit_2 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_2.setGeometry(QtCore.QRect(90, 50, 261, 20))
        self.lineEdit_2.setObjectName(_fromUtf8("lineEdit_2"))
        self.lineEdit = QtGui.QLineEdit(self.groupBox)
        self.lineEdit.setGeometry(QtCore.QRect(90, 20, 261, 20))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.WWS_CHANNEL = QtGui.QLabel(self.groupBox)
        self.WWS_CHANNEL.setGeometry(QtCore.QRect(10, 80, 71, 20))
        self.WWS_CHANNEL.setObjectName(_fromUtf8("WWS_CHANNEL"))
        self.appId = QtGui.QLabel(self.groupBox)
        self.appId.setGeometry(QtCore.QRect(10, 25, 54, 12))
        self.appId.setObjectName(_fromUtf8("appId"))
        self.appKey = QtGui.QLabel(self.groupBox)
        self.appKey.setGeometry(QtCore.QRect(10, 55, 54, 12))
        self.appKey.setObjectName(_fromUtf8("appKey"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 124, 421, 121))
        self.groupBox_4.setObjectName(_fromUtf8("groupBox_4"))
        self.label_9 = QtGui.QLabel(self.groupBox_4)
        self.label_9.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_9.setObjectName(_fromUtf8("label_9"))
        self.lineEdit_9 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_9.setGeometry(QtCore.QRect(80, 28, 113, 20))
        self.lineEdit_9.setObjectName(_fromUtf8("lineEdit_9"))
        self.label_10 = QtGui.QLabel(self.groupBox_4)
        self.label_10.setGeometry(QtCore.QRect(220, 28, 61, 16))
        self.label_10.setObjectName(_fromUtf8("label_10"))
        self.lineEdit_10 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_10.setGeometry(QtCore.QRect(300, 28, 113, 20))
        self.lineEdit_10.setObjectName(_fromUtf8("lineEdit_10"))
        self.label_11 = QtGui.QLabel(self.groupBox_4)
        self.label_11.setGeometry(QtCore.QRect(10, 60, 61, 16))
        self.label_11.setObjectName(_fromUtf8("label_11"))
        self.lineEdit_12 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_12.setGeometry(QtCore.QRect(80, 59, 113, 20))
        self.lineEdit_12.setObjectName(_fromUtf8("lineEdit_12"))
        self.label_12 = QtGui.QLabel(self.groupBox_4)
        self.label_12.setGeometry(QtCore.QRect(220, 58, 81, 20))
        self.label_12.setObjectName(_fromUtf8("label_12"))
        self.lineEdit_13 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_13.setGeometry(QtCore.QRect(300, 59, 113, 20))
        self.lineEdit_13.setObjectName(_fromUtf8("lineEdit_13"))
        self.label_14 = QtGui.QLabel(self.groupBox_4)
        self.label_14.setGeometry(QtCore.QRect(10, 90, 61, 16))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.lineEdit_14 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_14.setGeometry(QtCore.QRect(80, 90, 113, 20))
        self.lineEdit_14.setObjectName(_fromUtf8("lineEdit_14"))
        self.label_15 = QtGui.QLabel(self.groupBox_4)
        self.label_15.setGeometry(QtCore.QRect(221, 90, 61, 16))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.lineEdit_15 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_15.setGeometry(QtCore.QRect(300, 89, 113, 20))
        self.lineEdit_15.setObjectName(_fromUtf8("lineEdit_15"))
        self.label_13 = QtGui.QLabel(Dialog)
        self.label_13.setGeometry(QtCore.QRect(10, 274, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.lineEdit_11 = QtGui.QLineEdit(Dialog)
        self.lineEdit_11.setGeometry(QtCore.QRect(50, 270, 361, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))

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
            self.lineEdit.setText(channel.get("appId"))
            self.lineEdit_2.setText(channel.get("appKey"))
            
            if channel.get("resVersion") != None:
                self.lineEdit_15.setText(channel.get("resVersion"))
            else:
                self.lineEdit_15.setText("")

            #平台信息
            platform = root.find("platform")
            self.lineEdit_9.setText(platform.get("gameId"))
            self.lineEdit_10.setText(platform.get("platformId"))
            self.lineEdit_12.setText(platform.get("appVersion"))
            self.lineEdit_13.setText(platform.get("platformType"))
            self.lineEdit_14.setText(platform.get("datacenter"))
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
                if child.attrib[key] == "WWS_CHANNEL":
                    self.lineEdit_3.setText(child.attrib[value])
                
               
        
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
            channel.set("appId", unicode(self.lineEdit.text()))
            channel.set("appKey", unicode(self.lineEdit_2.text())) 
            
            channel.set("resVersion", unicode(self.lineEdit_15.text()))
            
            #平台信息
            platform = root.find("platform")
            platform.set("gameId", unicode(self.lineEdit_9.text()))
            platform.set("platformId", unicode(self.lineEdit_10.text()))
            platform.set("appVersion", unicode(self.lineEdit_12.text()))
            platform.set("platformType", unicode(self.lineEdit_13.text()))
            platform.set("datacenter", unicode(self.lineEdit_14.text()))
            
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
                if child.attrib[key] == "WWS_CHANNEL":
                    child.set(value, unicode(self.lineEdit_3.text()))
                 
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
        self.WWS_CHANNEL.setText(_translate("Dialog", "WWS_CHANNEL", None))
        self.appId.setText(_translate("Dialog", "appId", None))
        self.appKey.setText(_translate("Dialog", "appKey", None))
        self.groupBox_4.setTitle(_translate("Dialog", "平台信息", None))
        self.label_9.setText(_translate("Dialog", "gameId", None))
        self.label_10.setText(_translate("Dialog", "platformId", None))
        self.label_11.setText(_translate("Dialog", "appVersion", None))
        self.label_12.setText(_translate("Dialog", "platformType", None))
        self.label_14.setText(_translate("Dialog", "datacenter", None))
        self.label_15.setText(_translate("Dialog", "resVersion", None))
        self.label_13.setText(_translate("Dialog", "包名", None))
		
class Dialogfuncell_japan(QDialog,Ui_Dialog):
    def __init__(self,parent=None):  
        super(Dialogfuncell_japan,self).__init__(parent)  
        self.setupUi(self)

