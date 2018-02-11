# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_360np.ui'
#
# Created: Thu Jul 30 16:18:53 2015
#      by: PyQt4 UI code generator 4.11.2
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

class Ui_Dialog_360np(object):
    def setupUi(self, Dialog_360np):
        Dialog_360np.setObjectName(_fromUtf8("Dialog_360np"))
        Dialog_360np.resize(446, 534)
        self.pushButton = QtGui.QPushButton(Dialog_360np)
        self.pushButton.setGeometry(QtCore.QRect(190, 497, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog_360np)
        self.groupBox.setGeometry(QtCore.QRect(10, 10, 351, 291))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.comboBox_2 = QtGui.QComboBox(self.groupBox)
        self.comboBox_2.setGeometry(QtCore.QRect(130, 92, 181, 22))
        self.comboBox_2.setObjectName(_fromUtf8("comboBox_2"))
        self.comboBox_2.addItem(_fromUtf8(""))
        self.comboBox_2.addItem(_fromUtf8(""))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(30, 52, 111, 20))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(30, 92, 131, 16))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(30, 132, 91, 16))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(30, 200, 54, 12))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.lineEdit_5 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_5.setGeometry(QtCore.QRect(130, 168, 181, 20))
        self.lineEdit_5.setObjectName(_fromUtf8("lineEdit_5"))
        self.lineEdit_4 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_4.setGeometry(QtCore.QRect(130, 132, 181, 20))
        self.lineEdit_4.setObjectName(_fromUtf8("lineEdit_4"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(30, 22, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.lineEdit_6 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_6.setGeometry(QtCore.QRect(130, 198, 181, 20))
        self.lineEdit_6.setObjectName(_fromUtf8("lineEdit_6"))
        self.label_8 = QtGui.QLabel(self.groupBox)
        self.label_8.setGeometry(QtCore.QRect(30, 256, 71, 20))
        self.label_8.setObjectName(_fromUtf8("label_8"))
        self.lineEdit = QtGui.QLineEdit(self.groupBox)
        self.lineEdit.setGeometry(QtCore.QRect(130, 22, 181, 20))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.lineEdit_7 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_7.setGeometry(QtCore.QRect(130, 228, 181, 20))
        self.lineEdit_7.setObjectName(_fromUtf8("lineEdit_7"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(30, 168, 54, 12))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.comboBox = QtGui.QComboBox(self.groupBox)
        self.comboBox.setGeometry(QtCore.QRect(130, 52, 181, 22))
        self.comboBox.setObjectName(_fromUtf8("comboBox"))
        self.comboBox.addItem(_fromUtf8(""))
        self.comboBox.addItem(_fromUtf8(""))
        self.label_7 = QtGui.QLabel(self.groupBox)
        self.label_7.setGeometry(QtCore.QRect(30, 230, 71, 16))
        self.label_7.setObjectName(_fromUtf8("label_7"))
        self.lineEdit_8 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_8.setGeometry(QtCore.QRect(130, 258, 181, 20))
        self.lineEdit_8.setObjectName(_fromUtf8("lineEdit_8"))
        self.label_13 = QtGui.QLabel(Dialog_360np)
        self.label_13.setGeometry(QtCore.QRect(10, 460, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.lineEdit_11 = QtGui.QLineEdit(Dialog_360np)
        self.lineEdit_11.setGeometry(QtCore.QRect(50, 456, 361, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog_360np)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 310, 421, 121))
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

        self.retranslateUi(Dialog_360np)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_360np)
        self.initDialog()
    
    def initDialog(self):
        try:
            #print os.path.abspath('.')
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
            self.lineEdit.setText(channel.get("gameName"))
            self.comboBox.setCurrentIndex(self.comboBox.findText(channel.get("isLandscape")))
            self.comboBox_2.setCurrentIndex(self.comboBox_2.findText(channel.get("isTransparent")))
            self.lineEdit_4.setText(channel.get("exchangeRate"))
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
                if child.attrib[key] == "QHOPENSDK_APPID":
                    self.lineEdit_5.setText(child.attrib[value])
                elif child.attrib[key] == "QHOPENSDK_APPKEY":
                    self.lineEdit_6.setText(child.attrib[value])
                elif child.attrib[key] == "QHOPENSDK_WEIXIN_APPID":
                    self.lineEdit_8.setText(child.attrib[value]) 
        
            #界面
            config = ET.parse(file_operate.getUIConfigXmlPath())
            root = config.getroot()
            channel = root.find("channel")
            self.lineEdit_7.setText(channel.get("appSecret"))
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
            channel.set("gameName", unicode(self.lineEdit.text()))
            channel.set("isLandscape", unicode(self.comboBox.currentText()))
            channel.set("isTransparent", unicode(self.comboBox_2.currentText()))
            channel.set("exchangeRate", unicode(self.lineEdit_4.text())) 
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
                if child.attrib[key] == "QHOPENSDK_APPID":
                    child.set(value, unicode(self.lineEdit_5.text()))
                elif child.attrib[key] == "QHOPENSDK_APPKEY":
                    child.set(value, unicode(self.lineEdit_6.text()))
                elif child.attrib[key] == "QHOPENSDK_PRIVATEKEY":
                    tmp = self.lineEdit_7.text() + "#" + self.lineEdit_6.text()
                    tmp = unicode(tmp.toUtf8()).lower()
                    child.set(value, self.myMd5(tmp).lower())
                elif child.attrib[key] == "QHOPENSDK_WEIXIN_APPID":
                    child.set(value, unicode(self.lineEdit_8.text()))   
            configTree.write(file_operate.getForManifestXmlPath(), "utf-8")
            
            #print os.path.abspath('.')
            config = ET.parse(file_operate.getUIConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
            channel.set("appSecret", unicode(self.lineEdit_7.text()))

            config.write(file_operate.getUIConfigXmlPath(), "utf-8")
        
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
    
    def retranslateUi(self, Dialog_360np):
        Dialog_360np.setWindowTitle(_translate("Dialog_360np", "Dialog_360np", None))
        self.pushButton.setText(_translate("Dialog_360np", "确定", None))
        self.groupBox.setTitle(_translate("Dialog_360np", "渠道信息", None))
        self.comboBox_2.setItemText(0, _translate("Dialog_360np", "true", None))
        self.comboBox_2.setItemText(1, _translate("Dialog_360np", "false", None))
        self.label_2.setText(_translate("Dialog_360np", "isLandscape", None))
        self.label_3.setText(_translate("Dialog_360np", "isTransparent", None))
        self.label_4.setText(_translate("Dialog_360np", "exchangeRate", None))
        self.label_6.setText(_translate("Dialog_360np", "appKey", None))
        self.label.setText(_translate("Dialog_360np", "gameName", None))
        self.label_8.setText(_translate("Dialog_360np", "weixinAppId", None))
        self.label_5.setText(_translate("Dialog_360np", "appId", None))
        self.comboBox.setItemText(0, _translate("Dialog_360np", "true", None))
        self.comboBox.setItemText(1, _translate("Dialog_360np", "false", None))
        self.label_7.setText(_translate("Dialog_360np", "appSecret", None))
        self.label_13.setText(_translate("Dialog_360np", "包名", None))
        self.groupBox_4.setTitle(_translate("Dialog_360np", "平台信息", None))
        self.label_9.setText(_translate("Dialog_360np", "gameId", None))
        self.label_10.setText(_translate("Dialog_360np", "platformId", None))
        self.label_11.setText(_translate("Dialog_360np", "appVersion", None))
        self.label_12.setText(_translate("Dialog_360np", "platformType", None))
        self.label_14.setText(_translate("Dialog_360np", "datacenter", None))
        self.label_15.setText(_translate("Dialog_360np", "resVersion", None))

class Dialog360np(QDialog,Ui_Dialog_360np):  
    def __init__(self,parent=None):  
        super(Dialog360np,self).__init__(parent)  
        self.setupUi(self)
