# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_nextmv_tstore.ui'
#
# Created: Fri Jan 08 15:10:05 2016
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

class Ui_Dialog_nextmv_tstore(object):
    def setupUi(self, Dialog_nextmv_tstore):
        Dialog_nextmv_tstore.setObjectName(_fromUtf8("Dialog_nextmv_tstore"))
        Dialog_nextmv_tstore.resize(645, 529)
        self.groupBox = QtGui.QGroupBox(Dialog_nextmv_tstore)
        self.groupBox.setGeometry(QtCore.QRect(20, 30, 581, 271))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_1 = QtGui.QLabel(self.groupBox)
        self.label_1.setGeometry(QtCore.QRect(10, 20, 101, 20))
        self.label_1.setObjectName(_fromUtf8("label_1"))
        self.facebook_app_id = QtGui.QLineEdit(self.groupBox)
        self.facebook_app_id.setGeometry(QtCore.QRect(140, 20, 291, 20))
        self.facebook_app_id.setObjectName(_fromUtf8("facebook_app_id"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(10, 50, 91, 20))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.nextmv_api_key = QtGui.QLineEdit(self.groupBox)
        self.nextmv_api_key.setGeometry(QtCore.QRect(140, 50, 291, 20))
        self.nextmv_api_key.setObjectName(_fromUtf8("nextmv_api_key"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(10, 80, 101, 20))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.igaworks_app_key = QtGui.QLineEdit(self.groupBox)
        self.igaworks_app_key.setGeometry(QtCore.QRect(140, 80, 291, 20))
        self.igaworks_app_key.setObjectName(_fromUtf8("igaworks_app_key"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(10, 120, 101, 20))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.igaworks_hash_key = QtGui.QLineEdit(self.groupBox)
        self.igaworks_hash_key.setGeometry(QtCore.QRect(140, 120, 291, 20))
        self.igaworks_hash_key.setObjectName(_fromUtf8("igaworks_hash_key"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(10, 150, 101, 20))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.funcellKey = QtGui.QLineEdit(self.groupBox)
        self.funcellKey.setGeometry(QtCore.QRect(140, 150, 291, 20))
        self.funcellKey.setObjectName(_fromUtf8("funcellKey"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(10, 180, 101, 20))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.appId = QtGui.QLineEdit(self.groupBox)
        self.appId.setGeometry(QtCore.QRect(140, 180, 291, 20))
        self.appId.setObjectName(_fromUtf8("appId"))
        self.label_14 = QtGui.QLabel(self.groupBox)
        self.label_14.setGeometry(QtCore.QRect(10, 210, 101, 20))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.naver_client_id = QtGui.QLineEdit(self.groupBox)
        self.naver_client_id.setGeometry(QtCore.QRect(140, 210, 291, 20))
        self.naver_client_id.setObjectName(_fromUtf8("naver_client_id"))
        self.label_15 = QtGui.QLabel(self.groupBox)
        self.label_15.setGeometry(QtCore.QRect(10, 240, 121, 20))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.naver_client_secret = QtGui.QLineEdit(self.groupBox)
        self.naver_client_secret.setGeometry(QtCore.QRect(140, 240, 291, 20))
        self.naver_client_secret.setObjectName(_fromUtf8("naver_client_secret"))
        self.groupBox_2 = QtGui.QGroupBox(Dialog_nextmv_tstore)
        self.groupBox_2.setGeometry(QtCore.QRect(20, 320, 581, 121))
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
        self.pushButton = QtGui.QPushButton(Dialog_nextmv_tstore)
        self.pushButton.setGeometry(QtCore.QRect(270, 490, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.packageName = QtGui.QLineEdit(Dialog_nextmv_tstore)
        self.packageName.setGeometry(QtCore.QRect(50, 460, 541, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.label_13 = QtGui.QLabel(Dialog_nextmv_tstore)
        self.label_13.setGeometry(QtCore.QRect(10, 460, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))

        self.retranslateUi(Dialog_nextmv_tstore)
        self.pushButton.clicked.connect(self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_nextmv_tstore)
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
            self.facebook_app_id.setText(channel.get("facebook_app_id"))
            self.nextmv_api_key.setText(channel.get("nextmv_api_key"))
            self.igaworks_app_key.setText(channel.get("igaworks_app_key"))
            self.igaworks_hash_key.setText(channel.get("igaworks_hash_key"))
            self.funcellKey.setText(channel.get("funcellKey"))
            self.appId.setText(channel.get("appId"))
            self.naver_client_id.setText(channel.get("naver_client_id"))
            self.naver_client_secret.setText(channel.get("naver_client_secret"))
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
            
            doc = minidom.parse(file_operate.getForManifestXmlPath())
            rootNode = doc.documentElement
            applicationList = rootNode.getElementsByTagName('applicationCfg')
            for applicationNode in applicationList:
                receiverList = applicationNode.getElementsByTagName('receiver')
                for receiverNode in receiverList:
                    if receiverNode.getAttribute('android:name') == 'com.nextmv.platform.android.GcmBroadcastReceiver':
                        intentfilterList = receiverNode.getElementsByTagName('intent-filter')
                        for intentfilterNode in intentfilterList:
                            categoryList = intentfilterNode.getElementsByTagName('category')
                            for categoryNode in categoryList:
                                categoryNode.setAttribute('android:name', unicode(self.packageName.text()))
            
            permissionList = rootNode.getElementsByTagName('permissionCfg')
            for permissionNode in permissionList:
                pattern  = re.compile(".+\.permission\.C2D_MESSAGE")
                uses_permissionList = permissionNode.getElementsByTagName('uses-permission')
                for uses_permissionNode in uses_permissionList:
                    if pattern.match(uses_permissionNode.getAttribute('android:name')):
                        uses_permissionNode.setAttribute('android:name',unicode(self.packageName.text())+'.permission.C2D_MESSAGE')
                
                permissionlist = permissionNode.getElementsByTagName('permission')
                for permissionnode in permissionlist:
                    if pattern.match(permissionnode.getAttribute('android:name')):
                        permissionnode.setAttribute('android:name',unicode(self.packageName.text())+'.permission.C2D_MESSAGE')
                    
            f = codecs.open(file_operate.getForManifestXmlPath(), 'w', 'utf-8')
            doc.writexml(f, encoding='utf-8')
            f.close()
            
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
            channel.set("facebook_app_id", unicode(self.facebook_app_id.text()))
            channel.set("nextmv_api_key", unicode(self.nextmv_api_key.text()))
            channel.set("igaworks_app_key", unicode(self.igaworks_app_key.text()))
            channel.set("igaworks_hash_key", unicode(self.igaworks_hash_key.text()))
            channel.set("funcellKey", unicode(self.funcellKey.text()))
            channel.set("appId", unicode(self.appId.text()))
            channel.set("naver_client_id", unicode(self.naver_client_id.text()))
            channel.set("naver_client_secret", unicode(self.naver_client_secret.text()))
            channel.set("resVersion", unicode(self.resVersion.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1   
        
        try:
            nextmvStringConfig = ET.parse(file_operate.getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName()+"/ForRes/values/strings.xml"))
            nextmvStringConfigRoot = nextmvStringConfig.getroot()
             
            for nextmvStringConfigNode in nextmvStringConfigRoot:
                if nextmvStringConfigNode.attrib['name']=="nextmv_api_key" :
                    nextmvStringConfigNode.text=unicode(self.nextmv_api_key.text())
                elif nextmvStringConfigNode.attrib['name']=="facebook_app_id" :
                    nextmvStringConfigNode.text=unicode(self.facebook_app_id.text())
                elif nextmvStringConfigNode.attrib['name']=="naver_client_id" :
                    nextmvStringConfigNode.text=unicode(self.naver_client_id.text())
                elif nextmvStringConfigNode.attrib['name']=="naver_client_secret" :
                    nextmvStringConfigNode.text=unicode(self.naver_client_secret.text())
                elif nextmvStringConfigNode.attrib['name']=="igaworks_app_key" :
                    nextmvStringConfigNode.text=unicode(self.igaworks_app_key.text())
                elif nextmvStringConfigNode.attrib['name']=="igaworks_hash_key" :
                    nextmvStringConfigNode.text=unicode(self.igaworks_hash_key.text())
            nextmvStringConfig.write(file_operate.getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName() + "/ForRes/values/strings.xml"), "utf-8")
        except Exception,e:
            print e
            print "Error: cannot parse file: efunGameConfig.xml."
            return -1
        
        self.close()
    
    
    def retranslateUi(self, Dialog_nextmv_tstore):
        Dialog_nextmv_tstore.setWindowTitle(_translate("Dialog_nextmv_tstore", "Dialog_nextmv_tstore", None))
        self.groupBox.setTitle(_translate("Dialog_nextmv_tstore", "渠道参数", None))
        self.label_1.setText(_translate("Dialog_nextmv_tstore", "facebook_app_id", None))
        self.label_2.setText(_translate("Dialog_nextmv_tstore", "nextmv_api_key", None))
        self.label_3.setText(_translate("Dialog_nextmv_tstore", "igaworks_app_key", None))
        self.label_4.setText(_translate("Dialog_nextmv_tstore", "igaworks_hash_key", None))
        self.label_5.setText(_translate("Dialog_nextmv_tstore", "funcellKey", None))
        self.label_6.setText(_translate("Dialog_nextmv_tstore", "appId", None))
        self.label_14.setText(_translate("Dialog_nextmv_tstore", "naver_client_id", None))
        self.label_15.setText(_translate("Dialog_nextmv_tstore", "naver_client_secret", None))
        self.groupBox_2.setTitle(_translate("Dialog_nextmv_tstore", "平台信息", None))
        self.label_7.setText(_translate("Dialog_nextmv_tstore", "gameId", None))
        self.label_8.setText(_translate("Dialog_nextmv_tstore", "appVersion", None))
        self.label_9.setText(_translate("Dialog_nextmv_tstore", "datacenter", None))
        self.label_10.setText(_translate("Dialog_nextmv_tstore", "platformType", None))
        self.label_11.setText(_translate("Dialog_nextmv_tstore", "resVersion", None))
        self.label_12.setText(_translate("Dialog_nextmv_tstore", "platformId", None))
        self.pushButton.setText(_translate("Dialog_nextmv_tstore", "确定", None))
        self.label_13.setText(_translate("Dialog_nextmv_tstore", "包名", None))

class Dialognextmv_tstore(QDialog,Ui_Dialog_nextmv_tstore):  
    def __init__(self,parent=None):  
        super(Dialognextmv_tstore,self).__init__(parent)  
        self.setupUi(self)
