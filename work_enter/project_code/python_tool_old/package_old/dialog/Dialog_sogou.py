# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_sogou.ui'
#
# Created: Sun Jan 25 12:28:15 2015
#      by: PyQt4 UI code generator 4.11.3
#
# WARNING! All changes made in this file will be lost!

from PyQt4.QtGui import *  
from PyQt4.QtCore import *  
from PyQt4 import QtCore, QtGui
from xml.etree import ElementTree as ET
from utils import file_operate
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
        Dialog.resize(444, 459)
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(170, 420, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog)
        self.groupBox.setGeometry(QtCore.QRect(10, 10, 421, 211))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_11 = QtGui.QLabel(self.groupBox)
        self.label_11.setGeometry(QtCore.QRect(272, 173, 141, 16))
        self.label_11.setObjectName(_fromUtf8("label_11"))
        self.layoutWidget = QtGui.QWidget(self.groupBox)
        self.layoutWidget.setGeometry(QtCore.QRect(130, 21, 135, 178))
        self.layoutWidget.setObjectName(_fromUtf8("layoutWidget"))
        self.verticalLayout_2 = QtGui.QVBoxLayout(self.layoutWidget)
        self.verticalLayout_2.setMargin(0)
        self.verticalLayout_2.setObjectName(_fromUtf8("verticalLayout_2"))
        self.lineEdit = QtGui.QLineEdit(self.layoutWidget)
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.verticalLayout_2.addWidget(self.lineEdit)
        self.lineEdit_2 = QtGui.QLineEdit(self.layoutWidget)
        self.lineEdit_2.setObjectName(_fromUtf8("lineEdit_2"))
        self.verticalLayout_2.addWidget(self.lineEdit_2)
        self.lineEdit_3 = QtGui.QLineEdit(self.layoutWidget)
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.verticalLayout_2.addWidget(self.lineEdit_3)
        self.lineEdit_4 = QtGui.QLineEdit(self.layoutWidget)
        self.lineEdit_4.setObjectName(_fromUtf8("lineEdit_4"))
        self.verticalLayout_2.addWidget(self.lineEdit_4)
        self.lineEdit_5 = QtGui.QLineEdit(self.layoutWidget)
        self.lineEdit_5.setObjectName(_fromUtf8("lineEdit_5"))
        self.verticalLayout_2.addWidget(self.lineEdit_5)
        self.comboBox = QtGui.QComboBox(self.layoutWidget)
        self.comboBox.setObjectName(_fromUtf8("comboBox"))
        self.comboBox.addItem(_fromUtf8(""))
        self.comboBox.addItem(_fromUtf8(""))
        self.verticalLayout_2.addWidget(self.comboBox)
        self.comboBox_2 = QtGui.QComboBox(self.layoutWidget)
        self.comboBox_2.setObjectName(_fromUtf8("comboBox_2"))
        self.comboBox_2.addItem(_fromUtf8(""))
        self.comboBox_2.addItem(_fromUtf8(""))
        self.verticalLayout_2.addWidget(self.comboBox_2)
        self.label_10 = QtGui.QLabel(self.groupBox)
        self.label_10.setGeometry(QtCore.QRect(270, 148, 201, 20))
        self.label_10.setObjectName(_fromUtf8("label_10"))
        self.label_9 = QtGui.QLabel(self.groupBox)
        self.label_9.setGeometry(QtCore.QRect(272, 124, 141, 16))
        self.label_9.setObjectName(_fromUtf8("label_9"))
        self.layoutWidget1 = QtGui.QWidget(self.groupBox)
        self.layoutWidget1.setGeometry(QtCore.QRect(20, 21, 101, 171))
        self.layoutWidget1.setObjectName(_fromUtf8("layoutWidget1"))
        self.verticalLayout = QtGui.QVBoxLayout(self.layoutWidget1)
        self.verticalLayout.setMargin(0)
        self.verticalLayout.setObjectName(_fromUtf8("verticalLayout"))
        self.label = QtGui.QLabel(self.layoutWidget1)
        self.label.setObjectName(_fromUtf8("label"))
        self.verticalLayout.addWidget(self.label)
        self.label_2 = QtGui.QLabel(self.layoutWidget1)
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.verticalLayout.addWidget(self.label_2)
        self.label_3 = QtGui.QLabel(self.layoutWidget1)
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.verticalLayout.addWidget(self.label_3)
        self.label_4 = QtGui.QLabel(self.layoutWidget1)
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.verticalLayout.addWidget(self.label_4)
        self.label_5 = QtGui.QLabel(self.layoutWidget1)
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.verticalLayout.addWidget(self.label_5)
        self.label_6 = QtGui.QLabel(self.layoutWidget1)
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.verticalLayout.addWidget(self.label_6)
        self.label_7 = QtGui.QLabel(self.layoutWidget1)
        self.label_7.setObjectName(_fromUtf8("label_7"))
        self.verticalLayout.addWidget(self.label_7)
        self.label_8 = QtGui.QLabel(self.groupBox)
        self.label_8.setGeometry(QtCore.QRect(270, 90, 131, 30))
        self.label_8.setObjectName(_fromUtf8("label_8"))
        self.lineEdit_11 = QtGui.QLineEdit(Dialog)
        self.lineEdit_11.setGeometry(QtCore.QRect(50, 376, 361, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 230, 421, 121))
        self.groupBox_4.setObjectName(_fromUtf8("groupBox_4"))
        self.label_12 = QtGui.QLabel(self.groupBox_4)
        self.label_12.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_12.setObjectName(_fromUtf8("label_12"))
        self.lineEdit_6 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_6.setGeometry(QtCore.QRect(80, 28, 113, 20))
        self.lineEdit_6.setObjectName(_fromUtf8("lineEdit_6"))
        self.label_13 = QtGui.QLabel(self.groupBox_4)
        self.label_13.setGeometry(QtCore.QRect(220, 28, 61, 16))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.lineEdit_7 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_7.setGeometry(QtCore.QRect(300, 28, 113, 20))
        self.lineEdit_7.setObjectName(_fromUtf8("lineEdit_7"))
        self.label_14 = QtGui.QLabel(self.groupBox_4)
        self.label_14.setGeometry(QtCore.QRect(10, 60, 61, 16))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.lineEdit_8 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_8.setGeometry(QtCore.QRect(80, 59, 113, 20))
        self.lineEdit_8.setObjectName(_fromUtf8("lineEdit_8"))
        self.label_15 = QtGui.QLabel(self.groupBox_4)
        self.label_15.setGeometry(QtCore.QRect(220, 58, 81, 20))
        self.label_15.setObjectName(_fromUtf8("label_15"))
        self.lineEdit_9 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_9.setGeometry(QtCore.QRect(300, 59, 113, 20))
        self.lineEdit_9.setObjectName(_fromUtf8("lineEdit_9"))
        self.label_16 = QtGui.QLabel(self.groupBox_4)
        self.label_16.setGeometry(QtCore.QRect(10, 90, 61, 16))
        self.label_16.setObjectName(_fromUtf8("label_16"))
        self.lineEdit_10 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_10.setGeometry(QtCore.QRect(80, 90, 113, 20))
        self.lineEdit_10.setObjectName(_fromUtf8("lineEdit_10"))
        self.label_17 = QtGui.QLabel(self.groupBox_4)
        self.label_17.setGeometry(QtCore.QRect(221, 90, 61, 16))
        self.label_17.setObjectName(_fromUtf8("label_17"))
        self.lineEdit_12 = QtGui.QLineEdit(self.groupBox_4)
        self.lineEdit_12.setGeometry(QtCore.QRect(300, 89, 113, 20))
        self.lineEdit_12.setObjectName(_fromUtf8("lineEdit_12"))
        self.label_18 = QtGui.QLabel(Dialog)
        self.label_18.setGeometry(QtCore.QRect(10, 380, 54, 12))
        self.label_18.setObjectName(_fromUtf8("label_18"))

        self.retranslateUi(Dialog)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog)
        
        self.initDialog()

    def initDialog(self):
        config = ET.parse(file_operate.getConfigXmlPath())
        root = config.getroot()

        #渠道信息
        channel = root.find("channel")
        self.lineEdit.setText(channel.get("gId"))
        self.lineEdit_2.setText(channel.get("appKey"))
        self.lineEdit_3.setText(channel.get("gameName"))
        self.lineEdit_4.setText(channel.get("currency"))
        self.lineEdit_5.setText(channel.get("rate"))
        
        orienIndex = self.comboBox.findText(channel.get("isAmountEditable"))
        if  orienIndex == -1:
            self.comboBox.setCurrentIndex(0)
        else:
            self.comboBox.setCurrentIndex(orienIndex)
                
        orienIndex = self.comboBox_2.findText(channel.get("devMode"))
        if  orienIndex == -1:
            self.comboBox_2.setCurrentIndex(0)
        else:
            self.comboBox_2.setCurrentIndex(orienIndex)
            
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
            channel.set("gId", unicode(self.lineEdit.text()))
            channel.set("appKey", unicode(self.lineEdit_2.text())) 
            channel.set("gameName", unicode(self.lineEdit_3.text())) 
            channel.set("currency", unicode(self.lineEdit_4.text())) 
            channel.set("rate", unicode(self.lineEdit_5.text())) 
            channel.set("isAmountEditable", unicode(self.comboBox.currentText()))
            channel.set("devMode", unicode(self.comboBox_2.currentText()))
            
            channel.set("resVersion", unicode(self.lineEdit_12.text()))
            
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
        
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()

    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog_sogou", None))
        self.pushButton.setText(_translate("Dialog", "确定", None))
        self.groupBox.setTitle(_translate("Dialog", "渠道信息", None))
        self.label_11.setText(_translate("Dialog", "是否是开发模式", None))
        self.comboBox.setItemText(0, _translate("Dialog", "false", None))
        self.comboBox.setItemText(1, _translate("Dialog", "true", None))
        self.comboBox_2.setItemText(0, _translate("Dialog", "false", None))
        self.comboBox_2.setItemText(1, _translate("Dialog", "true", None))
        self.label_10.setText(_translate("Dialog", "设置充值金额是否可编辑", None))
        self.label_9.setText(_translate("Dialog", "游戏币-人民币兑换比例", None))
        self.label.setText(_translate("Dialog", "gId", None))
        self.label_2.setText(_translate("Dialog", "appKey", None))
        self.label_3.setText(_translate("Dialog", "gameName", None))
        self.label_4.setText(_translate("Dialog", "currency", None))
        self.label_5.setText(_translate("Dialog", "rate", None))
        self.label_6.setText(_translate("Dialog", "isAmountEditable", None))
        self.label_7.setText(_translate("Dialog", "devMode", None))
        self.label_8.setText(_translate("Dialog", "游戏币名称:例如元宝", None))
        self.groupBox_4.setTitle(_translate("Dialog", "平台信息", None))
        self.label_12.setText(_translate("Dialog", "gameId", None))
        self.label_13.setText(_translate("Dialog", "platformId", None))
        self.label_14.setText(_translate("Dialog", "appVersion", None))
        self.label_15.setText(_translate("Dialog", "platformType", None))
        self.label_16.setText(_translate("Dialog", "datacenter", None))
        self.label_17.setText(_translate("Dialog", "resVersion", None))
        self.label_18.setText(_translate("Dialog", "包名", None))
		
class Dialogsogou(QDialog,Ui_Dialog):  
    def __init__(self,parent=None):  
        super(Dialogsogou,self).__init__(parent)  
        self.setupUi(self)

