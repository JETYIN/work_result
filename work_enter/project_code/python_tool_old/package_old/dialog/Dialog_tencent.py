# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_tencent.ui'
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

class Ui_Dialog_tencent(object):
    def setupUi(self, Dialog_tencent):
        Dialog_tencent.setObjectName(_fromUtf8("Dialog_tencent"))
        Dialog_tencent.resize(618, 491)
        self.groupBox = QtGui.QGroupBox(Dialog_tencent)
        self.groupBox.setGeometry(QtCore.QRect(20, 30, 581, 201))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_1 = QtGui.QLabel(self.groupBox)
        self.label_1.setGeometry(QtCore.QRect(10, 20, 101, 20))
        self.label_1.setObjectName(_fromUtf8("label_1"))
        self.qqappid = QtGui.QLineEdit(self.groupBox)
        self.qqappid.setGeometry(QtCore.QRect(140, 20, 291, 20))
        self.qqappid.setObjectName(_fromUtf8("qqappid"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(10, 80, 91, 20))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.wxappid = QtGui.QLineEdit(self.groupBox)
        self.wxappid.setGeometry(QtCore.QRect(140, 80, 291, 20))
        self.wxappid.setObjectName(_fromUtf8("wxappid"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(10, 140, 101, 20))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.offerid = QtGui.QLineEdit(self.groupBox)
        self.offerid.setGeometry(QtCore.QRect(140, 140, 291, 20))
        self.offerid.setObjectName(_fromUtf8("offerid"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(10, 170, 61, 16))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.comboBox = QtGui.QComboBox(self.groupBox)
        self.comboBox.setGeometry(QtCore.QRect(140, 170, 231, 22))
        self.comboBox.setObjectName(_fromUtf8("comboBox"))
        self.comboBox.addItem(_fromUtf8(""))
        self.comboBox.addItem(_fromUtf8(""))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(10, 50, 101, 20))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.qqAppkey = QtGui.QLineEdit(self.groupBox)
        self.qqAppkey.setGeometry(QtCore.QRect(140, 50, 291, 20))
        self.qqAppkey.setObjectName(_fromUtf8("qqAppkey"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(10, 110, 101, 20))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.wxAppkey = QtGui.QLineEdit(self.groupBox)
        self.wxAppkey.setGeometry(QtCore.QRect(140, 110, 291, 20))
        self.wxAppkey.setObjectName(_fromUtf8("wxAppkey"))
        self.groupBox_2 = QtGui.QGroupBox(Dialog_tencent)
        self.groupBox_2.setGeometry(QtCore.QRect(20, 270, 581, 121))
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
        self.pushButton = QtGui.QPushButton(Dialog_tencent)
        self.pushButton.setGeometry(QtCore.QRect(260, 460, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.packageName = QtGui.QLineEdit(Dialog_tencent)
        self.packageName.setGeometry(QtCore.QRect(60, 420, 541, 20))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.label_13 = QtGui.QLabel(Dialog_tencent)
        self.label_13.setGeometry(QtCore.QRect(10, 420, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))

        self.retranslateUi(Dialog_tencent)
        self.pushButton.clicked.connect(self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_tencent)
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
            self.qqappid.setText(channel.get("qqAppId"))
            self.qqAppkey.setText(channel.get("appKey"))
            self.wxAppkey.setText(channel.get("wxAppKey"))
            self.offerid.setText(channel.get("offerId"))
            self.wxappid.setText(channel.get("wxAppId"))
            orienIndex = self.comboBox.findText(channel.get("isRelease"))
            if  orienIndex == -1:
                self.comboBox.setCurrentIndex(0)
            else:
                self.comboBox.setCurrentIndex(orienIndex)
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
            channel.set("qqAppId", unicode(self.qqappid.text()))
            channel.set("wxAppId", unicode(self.wxappid.text()))
            channel.set("appKey", unicode(self.qqAppkey.text()))
            channel.set("wxAppKey", unicode(self.wxAppkey.text()))
            channel.set("offerId", unicode(self.offerid.text()))
            channel.set("isRelease", unicode(self.comboBox.currentText())) 
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
                                dataNode.setAttribute('android:scheme', unicode(self.wxappid.text()))
                    elif patternAuthActivity.match(activityNode.getAttribute('android:name')):
                        intentfilterList = activityNode.getElementsByTagName('intent-filter')
                        for intentfilterNode in intentfilterList:
                            dataList = intentfilterNode.getElementsByTagName('data')
                            for dataNode in dataList:
                                dataNode.setAttribute('android:scheme', 'tencent'+ unicode(self.qqappid.text()))
            
            f = codecs.open(file_operate.getForManifestXmlPath(), 'w', 'utf-8')
            doc.writexml(f, encoding='utf-8')
            f.close()
            
            #modify assets ysdkconfig.ini
            configiniPath = file_operate.getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName()+"/ForAssets/ysdkconf.ini")
            ysdk = codecs.open(configiniPath, 'w')
            if self.comboBox.currentText() == "debug":
                ysdkUrl = "YSDK_URL=https://ysdktest.qq.com"
            else:
                ysdkUrl = "YSDK_URL=https://ysdk.qq.com"
            configInfo=""
            configInfo += ysdkUrl+'\n'
            configInfo += "QQ_APP_ID=%s"%self.qqappid.text()+'\n'
            configInfo += "WX_APP_ID=%s"%self.wxappid.text()+'\n'
            configInfo += "OFFER_ID=%s"%self.offerid.text()+'\n'
            ysdk.write(configInfo)
            ysdk.flush()
            ysdk.close()
            
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1   
        
        self.close()
    
    
    def retranslateUi(self, Dialog_tencent):
        Dialog_tencent.setWindowTitle(_translate("Dialog_tencent", "Dialog_tencent", None))
        self.groupBox.setTitle(_translate("Dialog_tencent", "渠道参数", None))
        self.label_1.setText(_translate("Dialog_tencent", "qqAppId", None))
        self.label_2.setText(_translate("Dialog_tencent", "wxAppId", None))
        self.label_3.setText(_translate("Dialog_tencent", "offer_id", None))
        self.label_5.setText(_translate("Dialog_tencent", "isRelease", None))
        self.comboBox.setItemText(0, _translate("Dialog_tencent", "release", None))
        self.comboBox.setItemText(1, _translate("Dialog_tencent", "debug", None))
        self.label_4.setText(_translate("Dialog_tencent", "qqAppkey", None))
        self.label_6.setText(_translate("Dialog_tencent", "wxAppkey", None))
        self.groupBox_2.setTitle(_translate("Dialog_tencent", "平台信息", None))
        self.label_7.setText(_translate("Dialog_tencent", "gameId", None))
        self.label_8.setText(_translate("Dialog_tencent", "appVersion", None))
        self.label_9.setText(_translate("Dialog_tencent", "datacenter", None))
        self.label_10.setText(_translate("Dialog_tencent", "platformType", None))
        self.label_11.setText(_translate("Dialog_tencent", "resVersion", None))
        self.label_12.setText(_translate("Dialog_tencent", "platformId", None))
        self.pushButton.setText(_translate("Dialog_tencent", "确定", None))
        self.label_13.setText(_translate("Dialog_tencent", "包名", None))


class Dialogtencent(QDialog,Ui_Dialog_tencent):  
    def __init__(self,parent=None):  
        super(Dialogtencent,self).__init__(parent)  
        self.setupUi(self)
