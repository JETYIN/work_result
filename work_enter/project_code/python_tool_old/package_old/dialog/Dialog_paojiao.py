# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_paojiao.ui'
#
# Created: Fri Aug 21 19:01:59 2015
#      by: PyQt4 UI code generator 4.11.3
#
# WARNING! All changes made in this file will be lost!

from PyQt4.QtGui import *  
from PyQt4.QtCore import *  
from PyQt4 import QtCore, QtGui
from xml.etree import ElementTree as ET
from utils import file_operate
from utils.config import ConfigParse
from utils import file_operate, constant

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

class Ui_Dialog_paojiao(object):
    def setupUi(self, Dialog):
        Dialog.setObjectName(_fromUtf8("Dialog"))
        Dialog.resize(629, 381)
        self.label_13 = QtGui.QLabel(Dialog)
        self.label_13.setGeometry(QtCore.QRect(20, 300, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.groupBox_2 = QtGui.QGroupBox(Dialog)
        self.groupBox_2.setGeometry(QtCore.QRect(20, 150, 581, 121))
        self.groupBox_2.setObjectName(_fromUtf8("groupBox_2"))
        self.label_17 = QtGui.QLabel(self.groupBox_2)
        self.label_17.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_17.setObjectName(_fromUtf8("label_17"))
        self.label_18 = QtGui.QLabel(self.groupBox_2)
        self.label_18.setGeometry(QtCore.QRect(10, 60, 71, 16))
        self.label_18.setObjectName(_fromUtf8("label_18"))
        self.label_19 = QtGui.QLabel(self.groupBox_2)
        self.label_19.setGeometry(QtCore.QRect(10, 90, 71, 16))
        self.label_19.setObjectName(_fromUtf8("label_19"))
        self.label_20 = QtGui.QLabel(self.groupBox_2)
        self.label_20.setGeometry(QtCore.QRect(290, 60, 81, 16))
        self.label_20.setObjectName(_fromUtf8("label_20"))
        self.label_21 = QtGui.QLabel(self.groupBox_2)
        self.label_21.setGeometry(QtCore.QRect(290, 90, 71, 16))
        self.label_21.setObjectName(_fromUtf8("label_21"))
        self.label_22 = QtGui.QLabel(self.groupBox_2)
        self.label_22.setGeometry(QtCore.QRect(290, 30, 61, 16))
        self.label_22.setObjectName(_fromUtf8("label_22"))
        self.gameId = QtGui.QLineEdit(self.groupBox_2)
        self.gameId.setGeometry(QtCore.QRect(80, 20, 181, 20))
        self.gameId.setObjectName(_fromUtf8("gameId"))
        self.appVersion = QtGui.QLineEdit(self.groupBox_2)
        self.appVersion.setGeometry(QtCore.QRect(80, 50, 181, 20))
        self.appVersion.setObjectName(_fromUtf8("appVersion"))
        self.datacenter = QtGui.QLineEdit(self.groupBox_2)
        self.datacenter.setGeometry(QtCore.QRect(80, 80, 181, 20))
        self.datacenter.setObjectName(_fromUtf8("datacenter_2"))
        self.resVersion = QtGui.QLineEdit(self.groupBox_2)
        self.resVersion.setGeometry(QtCore.QRect(370, 80, 161, 20))
        self.resVersion.setObjectName(_fromUtf8("resVersion"))
        self.platformId = QtGui.QLineEdit(self.groupBox_2)
        self.platformId.setGeometry(QtCore.QRect(370, 20, 161, 20))
        self.platformId.setObjectName(_fromUtf8("platformId"))
        self.platformType = QtGui.QLineEdit(self.groupBox_2)
        self.platformType.setGeometry(QtCore.QRect(370, 50, 161, 20))
        self.platformType.setObjectName(_fromUtf8("platformType"))
        self.packageName = QtGui.QLineEdit(Dialog)
        self.packageName.setGeometry(QtCore.QRect(60, 300, 541, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(260, 340, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog)
        self.groupBox.setGeometry(QtCore.QRect(20, 20, 581, 121))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_23 = QtGui.QLabel(self.groupBox)
        self.label_23.setGeometry(QtCore.QRect(10, 20, 61, 20))
        self.label_23.setObjectName(_fromUtf8("label_23"))
        self.appId = QtGui.QLineEdit(self.groupBox)
        self.appId.setGeometry(QtCore.QRect(130, 20, 291, 20))
        self.appId.setObjectName(_fromUtf8("appId"))
        self.label_24 = QtGui.QLabel(self.groupBox)
        self.label_24.setGeometry(QtCore.QRect(10, 50, 81, 20))
        self.label_24.setObjectName(_fromUtf8("label_24"))
        self.appKey = QtGui.QLineEdit(self.groupBox)
        self.appKey.setGeometry(QtCore.QRect(130, 50, 291, 20))
        self.appKey.setObjectName(_fromUtf8("appKey"))
        self.label_29 = QtGui.QLabel(self.groupBox)
        self.label_29.setGeometry(QtCore.QRect(10, 80, 81, 20))
        self.label_29.setObjectName(_fromUtf8("label_29"))
        self.JPUSH_APPKEY = QtGui.QLineEdit(self.groupBox)
        self.JPUSH_APPKEY.setGeometry(QtCore.QRect(130, 80, 291, 20))
        self.JPUSH_APPKEY.setObjectName(_fromUtf8("JPUSH_APPKEY"))

        self.retranslateUi(Dialog)
        QtCore.QMetaObject.connectSlotsByName(Dialog)
        
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), Dialog.onOkClicked)
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
            self.appId.setText(channel.get("appId"))
            self.appKey.setText(channel.get("appKey"))
           
            if channel.get("resVersion") != None:
                self.resVersion.setText(channel.get("resVersion"))
            else:
                self.resVersion.setText("")
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        
#         try:
#             #read form ForManifest.xml
#             ET.register_namespace('android', constant.androidNS)
#             configTree = ET.parse(file_operate.getForManifestXmlPath())
#             configRoot = configTree.getroot()
#             key = '{' + constant.androidNS + '}name'
#             value = '{' + constant.androidNS + '}value'
#             applicationCfg = configRoot.find("applicationCfg")
#             if applicationCfg is None:
#                 return
#             metaConfigList = applicationCfg.findall("meta-data")
#             
#             for child in metaConfigList:
#                 if child.attrib[key] == "JPUSH_APPKEY":
#                     self.JPUSH_APPKEY.setText(child.attrib[value])
#                 
#         except Exception,e:
#             print e
#             print "Error: cannot parse file: ForManifest.xml."
#             return -1 
        
        return
    
    def onOkClicked(self):
        try:
            #write metadata to ForManifest
            ET.register_namespace('android', constant.androidNS)
            
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
            channel.set("appId", unicode(self.appId.text()))
            channel.set("appKey", unicode(self.appKey.text()))
            channel.set("resVersion", unicode(self.resVersion.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1 
#         try:
#             #read form ForManifest.xml
#             ET.register_namespace('android', constant.androidNS)
#             configTree = ET.parse(file_operate.getForManifestXmlPath())
#             configRoot = configTree.getroot()
#             key = '{' + constant.androidNS + '}name'
#             value = '{' + constant.androidNS + '}value'
#             applicationCfg = configRoot.find("applicationCfg")
#             if applicationCfg is None:
#                 return
#             metaConfigList = applicationCfg.findall("meta-data")
#             
#             for child in metaConfigList:
#                 if child.attrib[key] == "JPUSH_APPKEY":
#                    child.set(value, unicode(self.JPUSH_APPKEY.text()))
#             
#             receiverList=applicationCfg.findall('receiver')
#             for receiver in receiverList:
#                 if receiver.attrib[key]=='cn.jpush.android.service.PushReceiver':
#                     intentFilterList=receiver.findall('intent-filter')
#                     for intentFilter in intentFilterList:
#                         priorityKey='{' + constant.androidNS + '}priority'
#                         if intentFilter.attrib[priorityKey]=='1000':
#                             categoryList=intentFilter.findall('category')
#                             for category in categoryList:
#                                 category.attrib[key]=unicode(self.packageName.text())
#                         break
#                 if receiver.attrib[key]=='com.paojiao.sdk.jpush.SDKBroadcastReceiver':
#                     intentFilterList=receiver.findall('intent-filter')
#                     for intentFilter in intentFilterList:
#                         categoryList=intentFilter.findall('category')
#                         for category in categoryList:
#                             category.attrib[key]=unicode(self.packageName.text())
#              
#             activityList=applicationCfg.findall('activity') 
#             for activity in activityList:
#                 if activity.attrib[key]=='cn.jpush.android.ui.PushActivity':
#                     intentFilterList=activity.findall('intent-filter')
#                     for intentFilter in intentFilterList:
#                         categoryList=intentFilter.findall('category')
#                         for category in categoryList:
#                             if category.attrib[key]!='android.intent.category.DEFAULT':
#                                 category.attrib[key]=unicode(self.packageName.text())
#                                
#             permissionCfg=configRoot.find('permissionCfg')
#             permissionList=permissionCfg.findall('permission')
#             for permission in permissionList:
#                 if permission.attrib[key].endswith('permission.JPUSH_MESSAGE'):
#                     permission.attrib[key]=unicode(self.packageName.text())+'permission.JPUSH_MESSAGE'
#             usesPermissionList=permissionCfg.findall('uses-permission')
#             for usesPermission in usesPermissionList:
#                 if usesPermission.attrib[key].endswith('permission.JPUSH_MESSAGE'):
#                     usesPermission.attrib[key]=unicode(self.packageName.text())+'permission.JPUSH_MESSAGE'
#             
#             configTree.write(file_operate.getForManifestXmlPath(), "utf-8")   
#         except Exception,e:
#             print e
#             print "Error: cannot parse file: ForManifest.xml."
#             return -1 
        
        self.close()

    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog", None))
        self.label_13.setText(_translate("Dialog", "包名", None))
        self.groupBox_2.setTitle(_translate("Dialog", "平台信息", None))
        self.label_17.setText(_translate("Dialog", "gameId", None))
        self.label_18.setText(_translate("Dialog", "appVersion", None))
        self.label_19.setText(_translate("Dialog", "datacenter", None))
        self.label_20.setText(_translate("Dialog", "platformType", None))
        self.label_21.setText(_translate("Dialog", "resVersion", None))
        self.label_22.setText(_translate("Dialog", "platformId", None))
        self.pushButton.setText(_translate("Dialog", "确定", None))
        self.groupBox.setTitle(_translate("Dialog", "渠道参数", None))
        self.label_23.setText(_translate("Dialog", "appId", None))
        self.label_24.setText(_translate("Dialog", "appKey", None))
        self.label_29.setText(_translate("Dialog", "JPUSH_APPKEY", None))
        
        
        
class Dialogpaojiao(QDialog,Ui_Dialog_paojiao):  
    def __init__(self,parent=None):  
        super(Dialogpaojiao,self).__init__(parent)  
        self.setupUi(self)

