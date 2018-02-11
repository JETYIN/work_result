# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'G:\svnwork\Libs1\ReleaseSDK\android_pack_talkingdata\ui\Dialog_uc_wdj.ui'
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

class Ui_Dialog_uc_wdj(object):
    def setupUi(self, Dialog_uc_wdj):
        Dialog_uc_wdj.setObjectName(_fromUtf8("Dialog_uc_wdj"))
        Dialog_uc_wdj.resize(445, 483)
        self.pushButton = QtGui.QPushButton(Dialog_uc_wdj)
        self.pushButton.setGeometry(QtCore.QRect(190, 430, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog_uc_wdj)
        self.groupBox.setGeometry(QtCore.QRect(10, 10, 421, 231))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.lineEdit_5 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_5.setGeometry(QtCore.QRect(90, 140, 251, 20))
        self.lineEdit_5.setObjectName(_fromUtf8("lineEdit_5"))
        self.lineEdit_4 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_4.setGeometry(QtCore.QRect(90, 114, 251, 20))
        self.lineEdit_4.setObjectName(_fromUtf8("lineEdit_4"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(20, 84, 54, 12))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(20, 114, 54, 12))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.lineEdit = QtGui.QLineEdit(self.groupBox)
        self.lineEdit.setGeometry(QtCore.QRect(90, 24, 251, 20))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.lineEdit_2 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_2.setGeometry(QtCore.QRect(90, 54, 251, 20))
        self.lineEdit_2.setObjectName(_fromUtf8("lineEdit_2"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(20, 144, 54, 12))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.lineEdit_3 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_3.setGeometry(QtCore.QRect(90, 84, 251, 20))
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(20, 24, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(20, 54, 54, 12))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(20, 170, 54, 16))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.wdjAppKey = QtGui.QLineEdit(self.groupBox)
        self.wdjAppKey.setGeometry(QtCore.QRect(90, 170, 251, 20))
        self.wdjAppKey.setObjectName(_fromUtf8("wdjAppKey"))
        self.label_13 = QtGui.QLabel(Dialog_uc_wdj)
        self.label_13.setGeometry(QtCore.QRect(10, 390, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.lineEdit_11 = QtGui.QLineEdit(Dialog_uc_wdj)
        self.lineEdit_11.setGeometry(QtCore.QRect(50, 386, 361, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog_uc_wdj)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 250, 421, 121))
        self.groupBox_4.setObjectName(_fromUtf8("groupBox_4"))
        self.label_7 = QtGui.QLabel(self.groupBox_4)
        self.label_7.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_7.setObjectName(_fromUtf8("label_7"))
        self.lineEdit_6 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_6.setGeometry(QtCore.QRect(80, 28, 113, 20))
        self.lineEdit_6.setObjectName(_fromUtf8("lineEdit_6"))
        self.label_8 = QtGui.QLabel(self.groupBox_4)
        self.label_8.setGeometry(QtCore.QRect(220, 28, 61, 16))
        self.label_8.setObjectName(_fromUtf8("label_8"))
        self.lineEdit_7 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_7.setGeometry(QtCore.QRect(300, 28, 113, 20))
        self.lineEdit_7.setObjectName(_fromUtf8("lineEdit_7"))
        self.label_9 = QtGui.QLabel(self.groupBox_4)
        self.label_9.setGeometry(QtCore.QRect(10, 60, 61, 16))
        self.label_9.setObjectName(_fromUtf8("label_9"))
        self.lineEdit_8 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_8.setGeometry(QtCore.QRect(80, 59, 113, 20))
        self.lineEdit_8.setObjectName(_fromUtf8("lineEdit_8"))
        self.label_10 = QtGui.QLabel(self.groupBox_4)
        self.label_10.setGeometry(QtCore.QRect(220, 58, 81, 20))
        self.label_10.setObjectName(_fromUtf8("label_10"))
        self.lineEdit_9 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_9.setGeometry(QtCore.QRect(300, 59, 113, 20))
        self.lineEdit_9.setObjectName(_fromUtf8("lineEdit_9"))
        self.label_11 = QtGui.QLabel(self.groupBox_4)
        self.label_11.setGeometry(QtCore.QRect(10, 90, 61, 16))
        self.label_11.setObjectName(_fromUtf8("label_11"))
        self.lineEdit_10 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_10.setGeometry(QtCore.QRect(80, 90, 113, 20))
        self.lineEdit_10.setObjectName(_fromUtf8("lineEdit_10"))
        self.label_12 = QtGui.QLabel(self.groupBox_4)
        self.label_12.setGeometry(QtCore.QRect(221, 90, 61, 16))
        self.label_12.setObjectName(_fromUtf8("label_12"))
        self.lineEdit_12 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_12.setGeometry(QtCore.QRect(300, 89, 113, 20))
        self.lineEdit_12.setObjectName(_fromUtf8("lineEdit_12"))

        self.retranslateUi(Dialog_uc_wdj)
        QtCore.QMetaObject.connectSlotsByName(Dialog_uc_wdj)
        
        self.pushButton.clicked.connect(self.onOkClicked)
        self.initDialog()
         
    def initDialog(self):
        config = ET.parse(file_operate.getConfigXmlPath())
        root = config.getroot()

            #渠道信息
        channel = root.find("channel")
        self.lineEdit.setText(channel.get("cpId"))
        self.lineEdit_2.setText(channel.get("gameId"))
        self.lineEdit_3.setText(channel.get("serverId"))
        self.lineEdit_4.setText(channel.get("gameName"))
        self.lineEdit_5.setText(channel.get("apiKey"))
        self.wdjAppKey.setText(channel.get("wdjAppKey"))
        
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
            
    def onOkClicked(self):
        try:
            #print os.path.abspath('.')
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
            channel.set("cpId", unicode(self.lineEdit.text()))
            channel.set("gameId", unicode(self.lineEdit_2.text())) 
            channel.set("serverId", unicode(self.lineEdit_3.text())) 
            channel.set("gameName", unicode(self.lineEdit_4.text())) 
            channel.set("apiKey", unicode(self.lineEdit_5.text())) 
            channel.set("resVersion", unicode(self.lineEdit_12.text()))
            channel.set("wdjAppKey", unicode(self.wdjAppKey.text()))
            
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
            
            
            #write metadata to ForManifest
            ET.register_namespace('android', constant.androidNS)
            configTree = ET.parse(file_operate.getForManifestXmlPath())
            configRoot = configTree.getroot()
            key = '{' + constant.androidNS + '}name'
            value = '{' + constant.androidNS + '}value'
            scheme = '{' + constant.androidNS + '}scheme'
            applicationCfg = configRoot.find("applicationCfg")
            if applicationCfg is None:
                return
            activityList = applicationCfg.findall("activity")
            
            for activityNode in activityList:
                if activityNode.attrib[key] == "com.wandoujia.oakenshield.activity.OakenshieldActivity":
                    intentFilterList=activityNode.findall("intent-filter")
                    for intentFilterNode in intentFilterList:
                        dataNode = intentFilterNode.find("data")
                        if not dataNode is None: 
                            dataNode.set(scheme, "Wandoujia-PaySdk-"+unicode(self.wdjAppKey.text()))
                            
            configTree.write(file_operate.getForManifestXmlPath(), "utf-8")
        
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()

    def retranslateUi(self, Dialog_uc_wdj):
        Dialog_uc_wdj.setWindowTitle(_translate("Dialog_uc_wdj", "Config_uc", None))
        self.pushButton.setText(_translate("Dialog_uc_wdj", "确定", None))
        self.groupBox.setTitle(_translate("Dialog_uc_wdj", "渠道信息", None))
        self.label_3.setText(_translate("Dialog_uc_wdj", "serverId", None))
        self.label_4.setText(_translate("Dialog_uc_wdj", "gameName", None))
        self.label_5.setText(_translate("Dialog_uc_wdj", "apiKey", None))
        self.label.setText(_translate("Dialog_uc_wdj", "cpId", None))
        self.label_2.setText(_translate("Dialog_uc_wdj", "gameId", None))
        self.label_6.setText(_translate("Dialog_uc_wdj", "wdjAppKey", None))
        self.label_13.setText(_translate("Dialog_uc_wdj", "包名", None))
        self.groupBox_4.setTitle(_translate("Dialog_uc_wdj", "平台信息", None))
        self.label_7.setText(_translate("Dialog_uc_wdj", "gameId", None))
        self.label_8.setText(_translate("Dialog_uc_wdj", "platformId", None))
        self.label_9.setText(_translate("Dialog_uc_wdj", "appVersion", None))
        self.label_10.setText(_translate("Dialog_uc_wdj", "platformType", None))
        self.label_11.setText(_translate("Dialog_uc_wdj", "datacenter", None))
        self.label_12.setText(_translate("Dialog_uc_wdj", "resVersion", None))

class Dialoguc_wdj(QDialog,Ui_Dialog_uc_wdj):  
    def __init__(self,parent=None):  
        super(Dialoguc_wdj,self).__init__(parent)  
        self.setupUi(self)