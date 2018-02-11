# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'F:\android_pack_talkingdata\ui\Dialog_anqu.ui'
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
        Dialog.resize(441, 465)
        self.groupBox_4 = QtGui.QGroupBox(Dialog)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 190, 421, 141))
        self.groupBox_4.setObjectName(_fromUtf8("groupBox_4"))
        self.label_7 = QtGui.QLabel(self.groupBox_4)
        self.label_7.setGeometry(QtCore.QRect(10, 30, 54, 12))
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
        self.label_13 = QtGui.QLabel(Dialog)
        self.label_13.setGeometry(QtCore.QRect(10, 360, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.groupBox = QtGui.QGroupBox(Dialog)
        self.groupBox.setGeometry(QtCore.QRect(10, 10, 421, 171))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(20, 82, 91, 16))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.ANQUSDK_APPID = QtGui.QLineEdit(self.groupBox)
        self.ANQUSDK_APPID.setGeometry(QtCore.QRect(130, 48, 231, 20))
        self.ANQUSDK_APPID.setObjectName(_fromUtf8("ANQUSDK_APPID"))
        self.ANQUSDK_CPUIN = QtGui.QLineEdit(self.groupBox)
        self.ANQUSDK_CPUIN.setGeometry(QtCore.QRect(130, 17, 231, 20))
        self.ANQUSDK_CPUIN.setObjectName(_fromUtf8("ANQUSDK_CPUIN"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(20, 22, 91, 16))
        self.label.setObjectName(_fromUtf8("label"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(20, 52, 91, 16))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.ANQUSDK_APPKEY = QtGui.QLineEdit(self.groupBox)
        self.ANQUSDK_APPKEY.setGeometry(QtCore.QRect(130, 78, 231, 20))
        self.ANQUSDK_APPKEY.setObjectName(_fromUtf8("ANQUSDK_APPKEY"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(20, 110, 91, 16))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.ANQUSDK_CHANNEL = QtGui.QLineEdit(self.groupBox)
        self.ANQUSDK_CHANNEL.setGeometry(QtCore.QRect(130, 110, 231, 20))
        self.ANQUSDK_CHANNEL.setObjectName(_fromUtf8("ANQUSDK_CHANNEL"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(20, 140, 54, 12))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.appSecret = QtGui.QLineEdit(self.groupBox)
        self.appSecret.setGeometry(QtCore.QRect(130, 140, 231, 20))
        self.appSecret.setObjectName(_fromUtf8("appSecret"))
        self.packageName = QtGui.QLineEdit(Dialog)
        self.packageName.setGeometry(QtCore.QRect(50, 356, 361, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(190, 400, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))

        self.retranslateUi(Dialog)
        QtCore.QMetaObject.connectSlotsByName(Dialog)
        
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), self.onOkClicked)
        
        self.initDialog()
        
    def initDialog(self):
        try:
            #print os.path.abspath('.')
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
            self.appSecret.setText(channel.get("appSecret"))
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
            self.packageName.setText(app.get("packageName"))
            
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
                if child.attrib[key] == "ANQUSDK_CPUIN":
                    self.ANQUSDK_CPUIN.setText(child.attrib[value])
                elif child.attrib[key] == "ANQUSDK_APPID":
                    self.ANQUSDK_APPID.setText(child.attrib[value])
                elif child.attrib[key] == "ANQUSDK_APPKEY":
                    self.ANQUSDK_APPKEY.setText(child.attrib[value]) 
                elif child.attrib[key] == "ANQUSDK_CHANNEL":
                    self.ANQUSDK_CHANNEL.setText(child.attrib[value]) 
        
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
            channel.set("appSecret", unicode(self.appSecret.text()))
            channel.set("resVersion", unicode(self.resVersion.text()))

            #平台信息
            platform = root.find("platform")
            platform.set("gameId", unicode(self.gameId.text()))
            platform.set("platformId", unicode(self.platformId.text()))
            platform.set("appVersion", unicode(self.appVersion.text()))
            platform.set("platformType", unicode(self.platformType.text()))
            platform.set("datacenter", unicode(self.datacenter.text()))
            
            app = root.find("app")
            app.set("packageName", unicode(self.packageName.text()))

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
                if child.attrib[key] == "ANQUSDK_CPUIN":
                    child.set(value, unicode(self.ANQUSDK_CPUIN.text()))
                elif child.attrib[key] == "ANQUSDK_APPID":
                    child.set(value, unicode(self.ANQUSDK_APPID.text()))
                elif child.attrib[key] == "ANQUSDK_APPKEY":
                    child.set(value, unicode(self.ANQUSDK_APPKEY.text()))
                elif child.attrib[key] == "ANQUSDK_PRIVATEKEY":
                    tmp = self.appSecret.text() + "Anqu" + self.ANQUSDK_APPKEY.text()
                    tmp = unicode(tmp.toUtf8())
                    print 'myMd5 : '+tmp+' , '+self.myMd5(tmp).lower()
                    child.set(value, self.myMd5(tmp).lower())
                elif child.attrib[key] == "ANQUSDK_CHANNEL":
                    child.set(value, unicode(self.ANQUSDK_CHANNEL.text()))   
            configTree.write(file_operate.getForManifestXmlPath(), "utf-8")
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()
        
    def myMd5(self, password):
        try:
            import hashlib
            hash = hashlib.md5()
        except ImportError:
            # for Python << 2.5
            import md5
            hash = md5.new()
        hash.update(password)
        return  hash.hexdigest()

    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog", None))
        self.groupBox_4.setTitle(_translate("Dialog", "平台信息", None))
        self.label_7.setText(_translate("Dialog", "gameId", None))
        self.label_8.setText(_translate("Dialog", "platformId", None))
        self.label_9.setText(_translate("Dialog", "appVersion", None))
        self.label_10.setText(_translate("Dialog", "platformType", None))
        self.label_11.setText(_translate("Dialog", "datacenter", None))
        self.label_12.setText(_translate("Dialog", "resVersion", None))
        self.label_13.setText(_translate("Dialog", "包名", None))
        self.groupBox.setTitle(_translate("Dialog", "渠道信息", None))
        self.label_3.setText(_translate("Dialog", "ANQUSDK_APPKEY", None))
        self.label.setText(_translate("Dialog", "ANQUSDK_CPUIN", None))
        self.label_2.setText(_translate("Dialog", "ANQUSDK_APPID", None))
        self.label_6.setText(_translate("Dialog", "ANQUSDK_CHANNEL", None))
        self.label_4.setText(_translate("Dialog", "appSecret", None))
        self.pushButton.setText(_translate("Dialog", "确定", None))
class Dialoganqu(QDialog,Ui_Dialog):  
    def __init__(self,parent=None):  
        super(Dialoganqu,self).__init__(parent)  
        self.setupUi(self)

