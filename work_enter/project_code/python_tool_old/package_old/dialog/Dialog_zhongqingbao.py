# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'E:\ericwork\pyqtdemo\Dialog_zhongqingbao.ui'
#
# Created by: PyQt4 UI code generator 4.11.4
#
# WARNING! All changes made in this file will be lost!

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
        Dialog.resize(527, 537)
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(190, 497, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog)
        self.groupBox.setGeometry(QtCore.QRect(10, 10, 481, 291))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
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
        self.remark = QtGui.QLineEdit(self.groupBox)
        self.remark.setGeometry(QtCore.QRect(140, 168, 181, 20))
        self.remark.setObjectName(_fromUtf8("remark"))
        self.secretKey = QtGui.QLineEdit(self.groupBox)
        self.secretKey.setGeometry(QtCore.QRect(140, 132, 181, 20))
        self.secretKey.setObjectName(_fromUtf8("secretKey"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(30, 22, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.areaId = QtGui.QLineEdit(self.groupBox)
        self.areaId.setGeometry(QtCore.QRect(140, 198, 181, 20))
        self.areaId.setObjectName(_fromUtf8("areaId"))
        self.label_8 = QtGui.QLabel(self.groupBox)
        self.label_8.setGeometry(QtCore.QRect(30, 256, 121, 20))
        self.label_8.setObjectName(_fromUtf8("label_8"))
        self.ZQGameId = QtGui.QLineEdit(self.groupBox)
        self.ZQGameId.setGeometry(QtCore.QRect(140, 22, 181, 20))
        self.ZQGameId.setObjectName(_fromUtf8("ZQGameId"))
        self.channelId = QtGui.QLineEdit(self.groupBox)
        self.channelId.setGeometry(QtCore.QRect(140, 228, 181, 20))
        self.channelId.setObjectName(_fromUtf8("channelId"))
        self.label_5 = QtGui.QLabel(self.groupBox)
        self.label_5.setGeometry(QtCore.QRect(30, 168, 54, 12))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.label_7 = QtGui.QLabel(self.groupBox)
        self.label_7.setGeometry(QtCore.QRect(30, 230, 71, 16))
        self.label_7.setObjectName(_fromUtf8("label_7"))
        self.screenOrientation = QtGui.QLineEdit(self.groupBox)
        self.screenOrientation.setGeometry(QtCore.QRect(140, 258, 181, 20))
        self.screenOrientation.setObjectName(_fromUtf8("screenOrientation"))
        self.advert = QtGui.QLineEdit(self.groupBox)
        self.advert.setGeometry(QtCore.QRect(140, 50, 181, 20))
        self.advert.setObjectName(_fromUtf8("advert"))
        self.gameMark = QtGui.QLineEdit(self.groupBox)
        self.gameMark.setGeometry(QtCore.QRect(140, 90, 181, 20))
        self.gameMark.setObjectName(_fromUtf8("gameMark"))
        self.label_16 = QtGui.QLabel(self.groupBox)
        self.label_16.setGeometry(QtCore.QRect(330, 260, 141, 16))
        self.label_16.setObjectName(_fromUtf8("label_16"))
        self.label_17 = QtGui.QLabel(self.groupBox)
        self.label_17.setGeometry(QtCore.QRect(330, 170, 141, 16))
        self.label_17.setObjectName(_fromUtf8("label_17"))
        self.label_18 = QtGui.QLabel(self.groupBox)
        self.label_18.setGeometry(QtCore.QRect(320, 50, 161, 21))
        self.label_18.setObjectName(_fromUtf8("label_18"))
        self.label_13 = QtGui.QLabel(Dialog)
        self.label_13.setGeometry(QtCore.QRect(10, 460, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.packageName = QtGui.QLineEdit(Dialog)
        self.packageName.setGeometry(QtCore.QRect(50, 456, 431, 21))
        self.packageName.setObjectName(_fromUtf8("packageName"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 310, 481, 121))
        self.groupBox_4.setObjectName(_fromUtf8("groupBox_4"))
        self.label_9 = QtGui.QLabel(self.groupBox_4)
        self.label_9.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_9.setObjectName(_fromUtf8("label_9"))
        self.gameId = QtGui.QLineEdit(self.groupBox_4)
        self.gameId.setGeometry(QtCore.QRect(80, 28, 113, 20))
        self.gameId.setObjectName(_fromUtf8("gameId"))
        self.label_10 = QtGui.QLabel(self.groupBox_4)
        self.label_10.setGeometry(QtCore.QRect(220, 28, 61, 16))
        self.label_10.setObjectName(_fromUtf8("label_10"))
        self.platformId = QtGui.QLineEdit(self.groupBox_4)
        self.platformId.setGeometry(QtCore.QRect(300, 28, 113, 20))
        self.platformId.setObjectName(_fromUtf8("platformId"))
        self.label_11 = QtGui.QLabel(self.groupBox_4)
        self.label_11.setGeometry(QtCore.QRect(10, 60, 61, 16))
        self.label_11.setObjectName(_fromUtf8("label_11"))
        self.appVersion = QtGui.QLineEdit(self.groupBox_4)
        self.appVersion.setGeometry(QtCore.QRect(80, 59, 113, 20))
        self.appVersion.setObjectName(_fromUtf8("appVersion"))
        self.label_12 = QtGui.QLabel(self.groupBox_4)
        self.label_12.setGeometry(QtCore.QRect(220, 58, 81, 20))
        self.label_12.setObjectName(_fromUtf8("label_12"))
        self.platformType = QtGui.QLineEdit(self.groupBox_4)
        self.platformType.setGeometry(QtCore.QRect(300, 59, 113, 20))
        self.platformType.setObjectName(_fromUtf8("platformType"))
        self.label_14 = QtGui.QLabel(self.groupBox_4)
        self.label_14.setGeometry(QtCore.QRect(10, 90, 61, 16))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.datacenter = QtGui.QLineEdit(self.groupBox_4)
        self.datacenter.setGeometry(QtCore.QRect(80, 90, 113, 20))
        self.datacenter.setObjectName(_fromUtf8("datacenter"))
        self.label_15 = QtGui.QLabel(self.groupBox_4)
        self.label_15.setGeometry(QtCore.QRect(221, 90, 61, 16))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.resVersion = QtGui.QLineEdit(self.groupBox_4)
        self.resVersion.setGeometry(QtCore.QRect(300, 89, 113, 20))
        self.resVersion.setObjectName(_fromUtf8("resVersion"))

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
            self.advert.setText(channel.get("advert"))
            self.areaId.setText(channel.get("areaId"))
            self.channelId.setText(channel.get("channelId"))
            self.gameMark.setText(channel.get("gameMark"))
            self.ZQGameId.setText(channel.get("ZQGameId"))
            self.secretKey.setText(channel.get("secretKey"))
            self.screenOrientation.setText(channel.get("screenOrientation"))
            self.remark.setText(channel.get("remark"))
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
            channel.set("advert", unicode(self.advert.text()))
            channel.set("areaId", unicode(self.areaId.text()))
            channel.set("channelId", unicode(self.channelId.text()))
            channel.set("gameMark", unicode(self.gameMark.text()))
            channel.set("ZQGameId", unicode(self.ZQGameId.text()))
            channel.set("secretKey", unicode(self.secretKey.text()))
            channel.set("screenOrientation", unicode(self.screenOrientation.text())) 
            channel.set("remark", unicode(self.remark.text())) 
          
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

        
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()

    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog_360", None))
        self.pushButton.setText(_translate("Dialog", "确定", None))
        self.groupBox.setTitle(_translate("Dialog", "渠道信息", None))
        self.label_2.setText(_translate("Dialog", "advert", None))
        self.label_3.setText(_translate("Dialog", "gameMark", None))
        self.label_4.setText(_translate("Dialog", "secretKey", None))
        self.label_6.setText(_translate("Dialog", "areaId", None))
        self.label.setText(_translate("Dialog", "ZQGameId", None))
        self.label_8.setText(_translate("Dialog", "screenOrientation", None))
        self.label_5.setText(_translate("Dialog", "remark", None))
        self.label_7.setText(_translate("Dialog", "channelId", None))
        self.label_16.setText(_translate("Dialog", "横屏：2 竖屏：1", None))
        self.label_17.setText(_translate("Dialog", "预留，填“0”", None))
        self.label_18.setText(_translate("Dialog", "游戏广告码.如无,请传\"\"", None))
        self.label_13.setText(_translate("Dialog", "包名", None))
        self.groupBox_4.setTitle(_translate("Dialog", "平台信息", None))
        self.label_9.setText(_translate("Dialog", "gameId", None))
        self.label_10.setText(_translate("Dialog", "platformId", None))
        self.label_11.setText(_translate("Dialog", "appVersion", None))
        self.label_12.setText(_translate("Dialog", "platformType", None))
        self.label_14.setText(_translate("Dialog", "datacenter", None))
        self.label_15.setText(_translate("Dialog", "resVersion", None))



class Dialogzhongqingbao(QtGui.QDialog,Ui_Dialog):
    def __init__(self, parent=None):
        super(Dialogzhongqingbao,self).__init__(parent)  
        self.setupUi(self)
