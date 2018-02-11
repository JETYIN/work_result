# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_yingyongbao.ui'
#
# Created: Fri Jan 30 14:34:10 2015
#      by: PyQt4 UI code generator 4.11.2
#
# WARNING! All changes made in this file will be lost!

from PyQt4.QtGui import *  
from PyQt4.QtCore import *  
from PyQt4 import QtCore, QtGui
from xml.etree import ElementTree as ET
from utils import file_operate, constant
from utils.config import ConfigParse
from xml.dom import minidom
import codecs
import ConfigParser
from utils.file_operate import getFullPath

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
        Dialog.resize(460, 549)
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(190, 484, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog)
        self.groupBox.setGeometry(QtCore.QRect(10, 10, 421, 281))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.lineEdit_4 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_4.setGeometry(QtCore.QRect(110, 110, 231, 20))
        self.lineEdit_4.setObjectName(_fromUtf8("lineEdit_4"))
        self.comboBox = QtGui.QComboBox(self.groupBox)
        self.comboBox.setGeometry(QtCore.QRect(110, 140, 231, 22))
        self.comboBox.setObjectName(_fromUtf8("comboBox"))
        self.comboBox.addItem(_fromUtf8(""))
        self.comboBox.addItem(_fromUtf8(""))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(20, 82, 54, 12))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(20, 142, 61, 16))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.lineEdit_2 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_2.setGeometry(QtCore.QRect(110, 48, 231, 20))
        self.lineEdit_2.setObjectName(_fromUtf8("lineEdit_2"))
        self.lineEdit = QtGui.QLineEdit(self.groupBox)
        self.lineEdit.setGeometry(QtCore.QRect(110, 17, 231, 20))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.label_4 = QtGui.QLabel(self.groupBox)
        self.label_4.setGeometry(QtCore.QRect(20, 112, 54, 12))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(20, 22, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(20, 52, 54, 12))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.lineEdit_3 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_3.setGeometry(QtCore.QRect(110, 78, 231, 20))
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.label_6 = QtGui.QLabel(self.groupBox)
        self.label_6.setGeometry(QtCore.QRect(20, 180, 54, 12))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.msdkKey = QtGui.QLineEdit(self.groupBox)
        self.msdkKey.setGeometry(QtCore.QRect(110, 180, 231, 20))
        self.msdkKey.setObjectName(_fromUtf8("msdkKey"))
        self.label_14 = QtGui.QLabel(self.groupBox)
        self.label_14.setGeometry(QtCore.QRect(20, 220, 54, 12))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.TA_APPKEY = QtGui.QLineEdit(self.groupBox)
        self.TA_APPKEY.setGeometry(QtCore.QRect(110, 210, 231, 20))
        self.TA_APPKEY.setObjectName(_fromUtf8("TA_APPKEY"))
        self.label_15 = QtGui.QLabel(self.groupBox)
        self.label_15.setGeometry(QtCore.QRect(20, 250, 91, 20))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.InstallChannel = QtGui.QLineEdit(self.groupBox)
        self.InstallChannel.setGeometry(QtCore.QRect(110, 250, 231, 20))
        self.InstallChannel.setObjectName(_fromUtf8("InstallChannel"))
        self.label_13 = QtGui.QLabel(Dialog)
        self.label_13.setGeometry(QtCore.QRect(10, 444, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.lineEdit_11 = QtGui.QLineEdit(Dialog)
        self.lineEdit_11.setGeometry(QtCore.QRect(50, 440, 361, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 300, 421, 121))
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
            self.lineEdit_3.setText(channel.get("wxAppId"))
            self.lineEdit_4.setText(channel.get("wxAppKey"))
            self.msdkKey.setText(channel.get("msdkKey"))
            self.TA_APPKEY.setText(channel.get("TA_APPKEY"))
            self.InstallChannel.setText(channel.get("InstallChannel"))
            
            orienIndex = self.comboBox.findText(channel.get("isRelease"))
            if  orienIndex == -1:
                self.comboBox.setCurrentIndex(0)
            else:
                self.comboBox.setCurrentIndex(orienIndex)
                
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
            
        except Exception,e:
            print e
            print "Error: cannot parse file: config.xml."
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
            channel.set("wxAppId", unicode(self.lineEdit_3.text()))
            channel.set("wxAppKey", unicode(self.lineEdit_4.text())) 
            channel.set("isRelease", unicode(self.comboBox.currentText())) 
            channel.set("resVersion", unicode(self.lineEdit_10.text()))
            channel.set("msdkKey", unicode(self.msdkKey.text()))
            channel.set("TA_APPKEY", unicode(self.TA_APPKEY.text()))
            channel.set("InstallChannel", unicode(self.InstallChannel.text()))
            
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
            
            #write appid wxappid to ForManifest
            doc = minidom.parse(file_operate.getForManifestXmlPath())
            rootNode = doc.documentElement
            applicationList = rootNode.getElementsByTagName("applicationCfg")
            for applicationNode in applicationList:
                activityList = rootNode.getElementsByTagName('activity')
                for activityNode in activityList:
                    if activityNode.getAttribute('android:name') == 'com.tencent.tauth.AuthActivity':
                        dataList = activityNode.getElementsByTagName("data")
                        for dataNode in dataList:
                            dataNode.setAttribute('android:scheme', "tencent"+unicode(self.lineEdit.text()))
                metaConfigList = applicationNode.getElementsByTagName("meta-data")
                for child in metaConfigList:
                    if child.getAttribute('android:name') == "TA_APPKEY":
                        child.setAttribute('android:value', unicode(self.TA_APPKEY.text()))
                    if child.getAttribute('android:name') == "InstallChannel":
                        child.setAttribute('android:value', unicode(self.InstallChannel.text()))

            f = codecs.open(file_operate.getForManifestXmlPath(), 'w', 'utf-8')
            doc.writexml(f, encoding='utf-8')
            f.close()
            
            #modify assets msdkconfig.ini
            configiniPath = getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName()+"/ForAssets/msdkconfig.ini")
            msdk = codecs.open(configiniPath, 'w')
            configInfo = 'AMS_CENTER_URL=http://apps.game.qq.com/ams/ame/gac.php?returntype=html\n'
            configInfo += 'MSDK_URL='
            if self.comboBox.currentText() == "debug":
                msdkUrl = "http://msdktest.qq.com"
            else:
                msdkUrl = "http://msdk.qq.com"
            configInfo += msdkUrl
            configInfo += '\n'
            configInfo += 'BETA=false\n'
            #configInfo += 'needNotice=false\n'
            #configInfo += 'noticeTime=10\n'
            #configInfo += 'PUSH=true\n'
            #configInfo += 'SAVE_UPDATE=true\n'
            configInfo += 'localLog=3\n'
            configInfo += 'STAT_LOG=true\n'
            configInfo += 'WXTOKEN_REFRESH=true'
            msdk.write(configInfo)
            msdk.flush()
            msdk.close()

        except Exception,e:
            print e
            print "Error: cannot parse file: config.xml."
            return -1
        self.close()

    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog_yingyongbao", None))
        self.pushButton.setText(_translate("Dialog", "确定", None))
        self.groupBox.setTitle(_translate("Dialog", "渠道信息", None))
        self.comboBox.setItemText(0, _translate("Dialog", "release", None))
        self.comboBox.setItemText(1, _translate("Dialog", "debug", None))
        self.label_3.setText(_translate("Dialog", "wxAppId", None))
        self.label_5.setText(_translate("Dialog", "isRelease", None))
        self.label_4.setText(_translate("Dialog", "wxAppKey", None))
        self.label.setText(_translate("Dialog", "appId", None))
        self.label_2.setText(_translate("Dialog", "appKey", None))
        self.label_6.setText(_translate("Dialog", "msdkKey", None))
        self.label_14.setText(_translate("Dialog", "TA_APPKEY", None))
        self.label_15.setText(_translate("Dialog", "InstallChannel", None))
        self.label_13.setText(_translate("Dialog", "包名", None))
        self.groupBox_4.setTitle(_translate("Dialog", "平台信息", None))
        self.label_7.setText(_translate("Dialog", "gameId", None))
        self.label_8.setText(_translate("Dialog", "platformId", None))
        self.label_9.setText(_translate("Dialog", "appVersion", None))
        self.label_10.setText(_translate("Dialog", "platformType", None))
        self.label_11.setText(_translate("Dialog", "datacenter", None))
        self.label_12.setText(_translate("Dialog", "resVersion", None))
		
class Dialogyingyongbao(QDialog,Ui_Dialog):  
    def __init__(self,parent=None):  
        super(Dialogyingyongbao,self).__init__(parent)  
        self.setupUi(self)

