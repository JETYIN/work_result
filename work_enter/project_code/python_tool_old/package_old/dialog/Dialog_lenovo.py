# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_lenovo.ui'
#
# Created: Tue Jan 27 11:29:24 2015
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

class Ui_Dialog(object):
    def setupUi(self, Dialog):
        Dialog.setObjectName(_fromUtf8("Dialog"))
        Dialog.resize(454, 393)
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(190, 358, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog)
        self.groupBox.setGeometry(QtCore.QRect(10, 10, 341, 151))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.lineEdit_4 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_4.setGeometry(QtCore.QRect(100, 110, 191, 20))
        self.lineEdit_4.setObjectName(_fromUtf8("lineEdit_4"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(20, 80, 54, 12))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.lineEdit_2 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_2.setGeometry(QtCore.QRect(100, 50, 191, 20))
        self.lineEdit_2.setObjectName(_fromUtf8("lineEdit_2"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(20, 50, 54, 12))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(20, 112, 101, 16))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(20, 20, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.lineEdit = QtGui.QLineEdit(self.groupBox)
        self.lineEdit.setGeometry(QtCore.QRect(100, 20, 191, 20))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.lineEdit_3 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_3.setGeometry(QtCore.QRect(100, 80, 191, 20))
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.label_13 = QtGui.QLabel(Dialog)
        self.label_13.setGeometry(QtCore.QRect(10, 324, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.lineEdit_11 = QtGui.QLineEdit(Dialog)
        self.lineEdit_11.setGeometry(QtCore.QRect(50, 320, 361, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 174, 421, 121))
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
            self.lineEdit.setText(channel.get("appId"))
            self.lineEdit_2.setText(channel.get("appKey"))
            self.lineEdit_3.setText(channel.get("waresId"))
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
                if child.attrib[key] == "com.baidu.lbsapi.API_KEY":
                    self.lineEdit_4.setText(child.attrib[value])
                
        
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
            channel.set("waresId", unicode(self.lineEdit_3.text()))
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
                if child.attrib[key] == "com.baidu.lbsapi.API_KEY":
                    child.set(value, unicode(self.lineEdit_4.text()))
                elif child.attrib[key] == "lenovo.open.appid":
                    child.set(value, unicode(self.lineEdit.text()))
                    
            receiverList = applicationCfg.findall("receiver")
            for child in receiverList:
                if child.attrib[key] == "com.lenovo.lsf.gamesdk.receiver.GameSdkReceiver":
                    intentfilterNode = child.find("intent-filter")
                    if not intentfilterNode is None:
                        actionList = intentfilterNode.findall("action")
                        for actionNode in actionList:
                            if actionNode.attrib[key] != "com.lenovo.lsf.gamesdk.receiver.GameSdkReceiver":
                                actionNode.set(key, unicode(self.lineEdit.text()))
                
            configTree.write(file_operate.getForManifestXmlPath(), "utf-8")
                    
        
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()

    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog_lenovo", None))
        self.pushButton.setText(_translate("Dialog", "确定", None))
        self.groupBox.setTitle(_translate("Dialog", "渠道信息", None))
        self.label_3.setText(_translate("Dialog", "waresId", None))
        self.label_2.setText(_translate("Dialog", "appKey", None))
        self.label_4.setText(_translate("Dialog", "API_KEY", None))
        self.label.setText(_translate("Dialog", "appId", None))
        self.label_13.setText(_translate("Dialog", "包名", None))
        self.groupBox_4.setTitle(_translate("Dialog", "平台信息", None))
        self.label_7.setText(_translate("Dialog", "gameId", None))
        self.label_8.setText(_translate("Dialog", "platformId", None))
        self.label_9.setText(_translate("Dialog", "appVersion", None))
        self.label_10.setText(_translate("Dialog", "platformType", None))
        self.label_11.setText(_translate("Dialog", "datacenter", None))
        self.label_12.setText(_translate("Dialog", "resVersion", None))
		
class Dialoglenovo(QDialog,Ui_Dialog):  
    def __init__(self,parent=None):  
        super(Dialoglenovo,self).__init__(parent)  
        self.setupUi(self)

