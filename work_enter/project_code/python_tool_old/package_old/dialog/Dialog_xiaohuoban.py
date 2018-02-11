# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_xiaohuoban.ui'
#
# Created: Tue Jan 27 17:04:06 2015
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
        Dialog.resize(347, 224)
        self.label = QtGui.QLabel(Dialog)
        self.label.setGeometry(QtCore.QRect(30, 30, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.label_2 = QtGui.QLabel(Dialog)
        self.label_2.setGeometry(QtCore.QRect(30, 60, 54, 12))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.line = QtGui.QFrame(Dialog)
        self.line.setGeometry(QtCore.QRect(30, 80, 281, 16))
        self.line.setFrameShape(QtGui.QFrame.HLine)
        self.line.setFrameShadow(QtGui.QFrame.Sunken)
        self.line.setObjectName(_fromUtf8("line"))
        self.label_3 = QtGui.QLabel(Dialog)
        self.label_3.setGeometry(QtCore.QRect(30, 110, 71, 16))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.label_4 = QtGui.QLabel(Dialog)
        self.label_4.setGeometry(QtCore.QRect(30, 140, 81, 16))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.lineEdit = QtGui.QLineEdit(Dialog)
        self.lineEdit.setGeometry(QtCore.QRect(100, 27, 201, 20))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.lineEdit_2 = QtGui.QLineEdit(Dialog)
        self.lineEdit_2.setGeometry(QtCore.QRect(100, 57, 201, 20))
        self.lineEdit_2.setObjectName(_fromUtf8("lineEdit_2"))
        self.lineEdit_3 = QtGui.QLineEdit(Dialog)
        self.lineEdit_3.setGeometry(QtCore.QRect(110, 107, 201, 20))
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.lineEdit_4 = QtGui.QLineEdit(Dialog)
        self.lineEdit_4.setGeometry(QtCore.QRect(110, 138, 201, 20))
        self.lineEdit_4.setObjectName(_fromUtf8("lineEdit_4"))
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(140, 180, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))

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
            self.lineEdit.setText(channel.get("clientId"))
            self.lineEdit_2.setText(channel.get("channelId"))
            
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
                if child.attrib[key] == "UMENG_APPKEY":
                    self.lineEdit_3.setText(child.attrib[value])
                elif child.attrib[key] == "UMENG_CHANNEL":
                    self.lineEdit_4.setText(child.attrib[value])
        
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
            channel.set("clientId", unicode(self.lineEdit.text()))
            channel.set("channelId", unicode(self.lineEdit_2.text()))

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
                if child.attrib[key] == "UMENG_APPKEY":
                    child.set(value, unicode(self.lineEdit_3.text()))
                elif child.attrib[key] == "UMENG_CHANNEL":
                    child.set(value, unicode(self.lineEdit_4.text()))
                
            configTree.write(file_operate.getForManifestXmlPath(), "utf-8")
                    
        except Exception,e:
            print e
            print "Error: cannot parse file: config.xml."
            return -1
        self.close()

    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog_xiaohuoban", None))
        self.label.setText(_translate("Dialog", "clientId", None))
        self.label_2.setText(_translate("Dialog", "channelId", None))
        self.label_3.setText(_translate("Dialog", "UMENG_APPKEY", None))
        self.label_4.setText(_translate("Dialog", "UMENG_CHANNEL", None))
        self.pushButton.setText(_translate("Dialog", "确定", None))
class Dialogxiaohuoban(QDialog,Ui_Dialog):  
    def __init__(self,parent=None):  
        super(Dialogxiaohuoban,self).__init__(parent)  
        self.setupUi(self)

