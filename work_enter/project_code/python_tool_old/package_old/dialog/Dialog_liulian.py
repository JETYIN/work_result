# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_liulian.ui'
#
# Created: Wed Dec 23 15:48:29 2015
#      by: PyQt4 UI code generator 4.11.2
#
# WARNING! All changes made in this file will be lost!

from PyQt4.QtGui import *  
from PyQt4.QtCore import *  
from PyQt4 import QtCore, QtGui
from xml.etree import ElementTree as ET
from utils import file_operate, constant
from utils.config import ConfigParse
from xml.etree.ElementTree import SubElement
from xml.dom import minidom
import codecs
import re


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

class Ui_Dialog_liulian(object):
    def setupUi(self, Dialog_liulian):
        Dialog_liulian.setObjectName(_fromUtf8("Dialog_liulian"))
        Dialog_liulian.resize(645, 513)
        self.groupBox = QtGui.QGroupBox(Dialog_liulian)
        self.groupBox.setGeometry(QtCore.QRect(20, 30, 581, 251))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_1 = QtGui.QLabel(self.groupBox)
        self.label_1.setGeometry(QtCore.QRect(10, 20, 101, 20))
        self.label_1.setObjectName(_fromUtf8("label_1"))
        self.appid = QtGui.QLineEdit(self.groupBox)
        self.appid.setGeometry(QtCore.QRect(140, 20, 291, 20))
        self.appid.setObjectName(_fromUtf8("appid"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(10, 50, 91, 20))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.appkey = QtGui.QLineEdit(self.groupBox)
        self.appkey.setGeometry(QtCore.QRect(140, 50, 291, 20))
        self.appkey.setObjectName(_fromUtf8("appkey"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(10, 80, 101, 20))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.privatekey = QtGui.QLineEdit(self.groupBox)
        self.privatekey.setGeometry(QtCore.QRect(140, 80, 291, 20))
        self.privatekey.setObjectName(_fromUtf8("privatekey"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(10, 120, 101, 20))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.platform = QtGui.QLineEdit(self.groupBox)
        self.platform.setGeometry(QtCore.QRect(140, 120, 131, 20))
        self.platform.setObjectName(_fromUtf8("platform"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(280, 120, 101, 20))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.qqAppId = QtGui.QLineEdit(self.groupBox)
        self.qqAppId.setGeometry(QtCore.QRect(340, 120, 131, 20))
        self.qqAppId.setObjectName(_fromUtf8("qqAppId"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(10, 150, 101, 20))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.qqAppKey = QtGui.QLineEdit(self.groupBox)
        self.qqAppKey.setGeometry(QtCore.QRect(140, 150, 131, 20))
        self.qqAppKey.setObjectName(_fromUtf8("qqAppKey"))
        self.label_14 = QtGui.QLabel(self.groupBox)
        self.label_14.setGeometry(QtCore.QRect(430, 80, 151, 20))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.label_15 = QtGui.QLabel(self.groupBox)
        self.label_15.setGeometry(QtCore.QRect(280, 150, 101, 20))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.wxAppId = QtGui.QLineEdit(self.groupBox)
        self.wxAppId.setGeometry(QtCore.QRect(340, 150, 131, 20))
        self.wxAppId.setObjectName(_fromUtf8("wxAppId"))
        self.label_16 = QtGui.QLabel(self.groupBox)
        self.label_16.setGeometry(QtCore.QRect(10, 180, 101, 20))
        self.label_16.setObjectName(_fromUtf8("label_16"))
        self.msdkKey = QtGui.QLineEdit(self.groupBox)
        self.msdkKey.setGeometry(QtCore.QRect(140, 180, 131, 20))
        self.msdkKey.setObjectName(_fromUtf8("msdkKey"))
        self.label_17 = QtGui.QLabel(self.groupBox)
        self.label_17.setGeometry(QtCore.QRect(280, 180, 101, 20))
        self.label_17.setObjectName(_fromUtf8("label_17"))
        self.offerId = QtGui.QLineEdit(self.groupBox)
        self.offerId.setGeometry(QtCore.QRect(340, 180, 131, 20))
        self.offerId.setObjectName(_fromUtf8("offerId"))
        self.label_18 = QtGui.QLabel(self.groupBox)
        self.label_18.setGeometry(QtCore.QRect(10, 210, 101, 20))
        self.label_18.setObjectName(_fromUtf8("label_18"))
        self.paykey = QtGui.QLineEdit(self.groupBox)
        self.paykey.setGeometry(QtCore.QRect(140, 210, 331, 20))
        self.paykey.setObjectName(_fromUtf8("paykey"))
        self.groupBox_2 = QtGui.QGroupBox(Dialog_liulian)
        self.groupBox_2.setGeometry(QtCore.QRect(20, 290, 581, 121))
        self.groupBox_2.setObjectName(_fromUtf8("groupBox_2"))
        self.label_7 = QtGui.QLabel(self.groupBox_2)
        self.label_7.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_7.setObjectName(_fromUtf8("label_7"))
        self.label_8 = QtGui.QLabel(self.groupBox_2)
        self.label_8.setGeometry(QtCore.QRect(10, 60, 71, 16))
        self.label_8.setObjectName(_fromUtf8("label_8"))
        self.label_9 = QtGui.QLabel(self.groupBox_2)
        self.label_9.setGeometry(QtCore.QRect(10, 90, 71, 16))
        self.label_9.setObjectName(_fromUtf8("label_9"))
        self.label_10 = QtGui.QLabel(self.groupBox_2)
        self.label_10.setGeometry(QtCore.QRect(290, 60, 81, 16))
        self.label_10.setObjectName(_fromUtf8("label_10"))
        self.label_11 = QtGui.QLabel(self.groupBox_2)
        self.label_11.setGeometry(QtCore.QRect(290, 90, 71, 16))
        self.label_11.setObjectName(_fromUtf8("label_11"))
        self.label_12 = QtGui.QLabel(self.groupBox_2)
        self.label_12.setGeometry(QtCore.QRect(290, 30, 61, 16))
        self.label_12.setObjectName(_fromUtf8("label_12"))
        self.gameId = QtGui.QLineEdit(self.groupBox_2)
        self.gameId.setGeometry(QtCore.QRect(80, 20, 181, 20))
        self.gameId.setObjectName(_fromUtf8("gameId"))
        self.appVersion = QtGui.QLineEdit(self.groupBox_2)
        self.appVersion.setGeometry(QtCore.QRect(80, 50, 181, 20))
        self.appVersion.setObjectName(_fromUtf8("appVersion"))
        self.datacenter = QtGui.QLineEdit(self.groupBox_2)
        self.datacenter.setGeometry(QtCore.QRect(80, 80, 181, 20))
        self.datacenter.setObjectName(_fromUtf8("datacenter"))
        self.resVersion = QtGui.QLineEdit(self.groupBox_2)
        self.resVersion.setGeometry(QtCore.QRect(370, 80, 161, 20))
        self.resVersion.setObjectName(_fromUtf8("resVersion"))
        self.platformId = QtGui.QLineEdit(self.groupBox_2)
        self.platformId.setGeometry(QtCore.QRect(370, 20, 161, 20))
        self.platformId.setObjectName(_fromUtf8("platformId"))
        self.platformType = QtGui.QLineEdit(self.groupBox_2)
        self.platformType.setGeometry(QtCore.QRect(370, 50, 161, 20))
        self.platformType.setObjectName(_fromUtf8("platformType"))
        self.pushButton = QtGui.QPushButton(Dialog_liulian)
        self.pushButton.setGeometry(QtCore.QRect(270, 470, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.packageName = QtGui.QLineEdit(Dialog_liulian)
        self.packageName.setGeometry(QtCore.QRect(50, 440, 541, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.label_13 = QtGui.QLabel(Dialog_liulian)
        self.label_13.setGeometry(QtCore.QRect(20, 440, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))

        self.retranslateUi(Dialog_liulian)
        self.pushButton.clicked.connect(self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_liulian)
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
            self.gameId.setText(platform.get("gameId"))
            self.platformId.setText(platform.get("platformId"))
            self.appVersion.setText(platform.get("appVersion"))
            self.platformType.setText(platform.get("platformType"))
            self.datacenter.setText(platform.get("datacenter"))
            
            app = root.find("app")
            self.packageName.setText(app.get("packageName"))
            
            channel = root.find("channel")
            self.appid.setText(channel.get("appid"))
            self.appkey.setText(channel.get("appkey"))
            self.privatekey.setText(channel.get("privatekey"))
            self.platform.setText(channel.get("platform"))
            self.qqAppId.setText(channel.get("qqAppId"))
            self.qqAppKey.setText(channel.get("qqAppKey"))
            self.wxAppId.setText(channel.get("wxAppId"))
            self.msdkKey.setText(channel.get("msdkKey"))
            self.offerId.setText(channel.get("offerId"))
            self.paykey.setText(channel.get("paykey"))
            if channel.get("resVersion") != None:
                self.resVersion.setText(channel.get("resVersion"))
            else:
                self.resVersion.setText("")
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
                if child.attrib[key] == "6LOPENSDK_CHANNEL":
                    child.set(value, unicode(self.platform.text()))
            
            configTree.write(file_operate.getForManifestXmlPath(), "utf-8")
            
            #渠道信息
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()
            
            #平台信息
            platform = root.find("platform")
            platform.set("gameId", unicode(self.gameId.text()))
            platform.set("platformId", unicode(self.platformId.text()))
            platform.set("appVersion", unicode(self.appVersion.text()))
            platform.set("platformType", unicode(self.platformType.text()))
            platform.set("datacenter", unicode(self.datacenter.text()))
            
            app = root.find("app")
            app.set("packageName", unicode(self.packageName.text()))
            
            channel = root.find("channel")
            channel.set("appid", unicode(self.appid.text()))
            channel.set("appkey", unicode(self.appkey.text()))
            channel.set("privatekey", unicode(self.privatekey.text()))
            channel.set("platform", unicode(self.platform.text()))
            channel.set("qqAppId", unicode(self.qqAppId.text()))
            channel.set("qqAppKey", unicode(self.qqAppKey.text()))
            channel.set("wxAppId", unicode(self.wxAppId.text()))
            channel.set("msdkKey", unicode(self.msdkKey.text()))
            channel.set("offerId", unicode(self.offerId.text()))
            channel.set("paykey", unicode(self.paykey.text()))
            channel.set("resVersion", unicode(self.resVersion.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
            doc = minidom.parse(file_operate.getForManifestXmlPath())
            rootNode = doc.documentElement
            applicationList = rootNode.getElementsByTagName('applicationCfg')
            for applicationNode in applicationList:
                activityList = applicationNode.getElementsByTagName('activity')
                pattern  = re.compile(".+\.wxapi\.WXEntryActivity$")
                patternAuthActivity = re.compile("com.tencent.tauth.AuthActivity")
                for activityNode in activityList:
                    if pattern.match(activityNode.getAttribute('android:name')):
                        activityNode.setAttribute('android:name',unicode(self.packageName.text())+'.wxapi.WXEntryActivity')
                        activityNode.setAttribute('android:taskAffinity',unicode(self.packageName.text()) + '.diff')
                        intentfilterList = activityNode.getElementsByTagName('intent-filter')
                        for intentfilterNode in intentfilterList:
                            dataList = intentfilterNode.getElementsByTagName('data')
                            for dataNode in dataList:
                                dataNode.setAttribute('android:scheme', unicode(self.wxAppId.text()))
                    elif patternAuthActivity.match(activityNode.getAttribute('android:name')):
                        intentfilterList = activityNode.getElementsByTagName('intent-filter')
                        for intentfilterNode in intentfilterList:
                            dataList = intentfilterNode.getElementsByTagName('data')
                            for dataNode in dataList:
                                dataNode.setAttribute('android:scheme', 'tencent'+ unicode(self.qqAppId.text()))
            
            f = codecs.open(file_operate.getForManifestXmlPath(), 'w', 'utf-8')
            doc.writexml(f, encoding='utf-8')
            f.close()
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1   
        
        self.close()
    
    def retranslateUi(self, Dialog_liulian):
        Dialog_liulian.setWindowTitle(_translate("Dialog_liulian", "Dialog_liulian", None))
        self.groupBox.setTitle(_translate("Dialog_liulian", "渠道参数", None))
        self.label_1.setText(_translate("Dialog_liulian", "appid", None))
        self.label_2.setText(_translate("Dialog_liulian", "appkey", None))
        self.label_3.setText(_translate("Dialog_liulian", "privatekey", None))
        self.label_4.setText(_translate("Dialog_liulian", "platform", None))
        self.label_5.setText(_translate("Dialog_liulian", "qqAppId", None))
        self.label_6.setText(_translate("Dialog_liulian", "qqAppKey", None))
        self.label_14.setText(_translate("Dialog_liulian", "appid#appkey执行MD5的32位小写", None))
        self.label_15.setText(_translate("Dialog_liulian", "wxAppId", None))
        self.label_16.setText(_translate("Dialog_liulian", "msdkKey", None))
        self.label_17.setText(_translate("Dialog_liulian", "offerId", None))
        self.label_18.setText(_translate("Dialog_liulian", "paykey", None))
        self.groupBox_2.setTitle(_translate("Dialog_liulian", "平台信息", None))
        self.label_7.setText(_translate("Dialog_liulian", "gameId", None))
        self.label_8.setText(_translate("Dialog_liulian", "appVersion", None))
        self.label_9.setText(_translate("Dialog_liulian", "datacenter", None))
        self.label_10.setText(_translate("Dialog_liulian", "platformType", None))
        self.label_11.setText(_translate("Dialog_liulian", "resVersion", None))
        self.label_12.setText(_translate("Dialog_liulian", "platformId", None))
        self.pushButton.setText(_translate("Dialog_liulian", "确定", None))
        self.label_13.setText(_translate("Dialog_liulian", "包名", None))

class Dialogliulian(QDialog,Ui_Dialog_liulian):
    def __init__(self,parent=None):  
        super(Dialogliulian,self).__init__(parent)  
        self.setupUi(self)
