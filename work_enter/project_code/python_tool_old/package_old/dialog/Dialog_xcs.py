# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'F:\funcellsdk\ReleaseSDK\android_pack_talkingdata\packpythonprj\packpythonprj\dialog\Dialog_xcs.ui'
#
# Created: Fri Jun 05 11:41:39 2015
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
from dialog import Dialog_uc

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

class Ui_Dialog_xcs(object):
    def setupUi(self, Dialog_xcs):
        Dialog_xcs.setObjectName(_fromUtf8("Dialog_xcs"))
        Dialog_xcs.resize(540, 388)
        self.pushButton = QtGui.QPushButton(Dialog_xcs)
        self.pushButton.setGeometry(QtCore.QRect(210, 340, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog_xcs)
        self.groupBox.setGeometry(QtCore.QRect(50, 30, 441, 111))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label = QtGui.QLabel(self.groupBox)
        self.label.setGeometry(QtCore.QRect(20, 30, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(20, 60, 54, 12))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(20, 90, 54, 12))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.lineEdit = QtGui.QLineEdit(self.groupBox)
        self.lineEdit.setGeometry(QtCore.QRect(90, 20, 341, 20))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.lineEdit_2 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_2.setGeometry(QtCore.QRect(90, 50, 341, 20))
        self.lineEdit_2.setObjectName(_fromUtf8("lineEdit_2"))
        self.lineEdit_3 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_3.setGeometry(QtCore.QRect(90, 80, 341, 20))
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.groupBox_2 = QtGui.QGroupBox(Dialog_xcs)
        self.groupBox_2.setGeometry(QtCore.QRect(50, 160, 441, 121))
        self.groupBox_2.setObjectName(_fromUtf8("groupBox_2"))
        self.label_4 = QtGui.QLabel(self.groupBox_2)
        self.label_4.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.label_5 = QtGui.QLabel(self.groupBox_2)
        self.label_5.setGeometry(QtCore.QRect(10, 60, 71, 16))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.label_6 = QtGui.QLabel(self.groupBox_2)
        self.label_6.setGeometry(QtCore.QRect(10, 90, 71, 16))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.label_7 = QtGui.QLabel(self.groupBox_2)
        self.label_7.setGeometry(QtCore.QRect(220, 60, 81, 16))
        self.label_7.setObjectName(_fromUtf8("label_7"))
        self.label_8 = QtGui.QLabel(self.groupBox_2)
        self.label_8.setGeometry(QtCore.QRect(220, 90, 71, 16))
        self.label_8.setObjectName(_fromUtf8("label_8"))
        self.label_9 = QtGui.QLabel(self.groupBox_2)
        self.label_9.setGeometry(QtCore.QRect(220, 30, 61, 16))
        self.label_9.setObjectName(_fromUtf8("label_9"))
        self.lineEdit_4 = QtGui.QLineEdit(self.groupBox_2)
        self.lineEdit_4.setGeometry(QtCore.QRect(80, 20, 131, 20))
        self.lineEdit_4.setObjectName(_fromUtf8("lineEdit_4"))
        self.lineEdit_5 = QtGui.QLineEdit(self.groupBox_2)
        self.lineEdit_5.setGeometry(QtCore.QRect(80, 50, 131, 20))
        self.lineEdit_5.setObjectName(_fromUtf8("lineEdit_5"))
        self.lineEdit_6 = QtGui.QLineEdit(self.groupBox_2)
        self.lineEdit_6.setGeometry(QtCore.QRect(80, 80, 131, 20))
        self.lineEdit_6.setObjectName(_fromUtf8("lineEdit_6"))
        self.lineEdit_7 = QtGui.QLineEdit(self.groupBox_2)
        self.lineEdit_7.setGeometry(QtCore.QRect(300, 80, 131, 20))
        self.lineEdit_7.setObjectName(_fromUtf8("lineEdit_7"))
        self.lineEdit_8 = QtGui.QLineEdit(self.groupBox_2)
        self.lineEdit_8.setGeometry(QtCore.QRect(300, 20, 131, 20))
        self.lineEdit_8.setObjectName(_fromUtf8("lineEdit_8"))
        self.lineEdit_9 = QtGui.QLineEdit(self.groupBox_2)
        self.lineEdit_9.setGeometry(QtCore.QRect(300, 50, 131, 20))
        self.lineEdit_9.setObjectName(_fromUtf8("lineEdit_9"))
        self.label_10 = QtGui.QLabel(Dialog_xcs)
        self.label_10.setGeometry(QtCore.QRect(60, 310, 54, 12))
        self.label_10.setObjectName(_fromUtf8("label_10"))
        self.lineEdit_10 = QtGui.QLineEdit(Dialog_xcs)
        self.lineEdit_10.setGeometry(QtCore.QRect(100, 300, 361, 20))
        self.lineEdit_10.setObjectName(_fromUtf8("lineEdit_10"))

        
        self.retranslateUi(Dialog_xcs)
        QtCore.QObject.connect(self.pushButton, QtCore.SIGNAL(_fromUtf8("clicked()")), self.onOkClicked)
        QtCore.QMetaObject.connectSlotsByName(Dialog_xcs)
        self.initDialog()
    
    def initDialog(self):
        config = ET.parse(file_operate.getConfigXmlPath())
        root = config.getroot()

            #渠道信息
        channel = root.find("channel")
        self.lineEdit.setText(channel.get("appId"))
        self.lineEdit_2.setText(channel.get("appSecret"))
        self.lineEdit_3.setText(channel.get("gameName"))
        
        if channel.get("resVersion") != None:
            self.lineEdit_7.setText(channel.get("resVersion"))
        else:
            self.lineEdit_7.setText("")
        
        #平台信息
        platform = root.find("platform")
        self.lineEdit_4.setText(platform.get("gameId"))
        self.lineEdit_8.setText(platform.get("platformId"))
        self.lineEdit_5.setText(platform.get("appVersion"))
        self.lineEdit_9.setText(platform.get("platformType"))
        self.lineEdit_6.setText(platform.get("datacenter"))
        app = root.find("app")
        self.lineEdit_10.setText(app.get("packageName"))
            
    def onOkClicked(self):
        try:
            #print os.path.abspath('.')
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()

            #渠道信息
            channel = root.find("channel")
            channel.set("appId", unicode(self.lineEdit.text()))
            channel.set("appSecret", unicode(self.lineEdit_2.text())) 
            channel.set("gameName", unicode(self.lineEdit_3.text())) 
           
            channel.set("resVersion", unicode(self.lineEdit_7.text()))
            
            #平台信息
            platform = root.find("platform")
            platform.set("gameId", unicode(self.lineEdit_4.text()))
            platform.set("platformId", unicode(self.lineEdit_8.text()))
            platform.set("appVersion", unicode(self.lineEdit_5.text()))
            platform.set("platformType", unicode(self.lineEdit_9.text()))
            platform.set("datacenter", unicode(self.lineEdit_6.text()))
            
            app = root.find("app")
            app.set("packageName", unicode(self.lineEdit_10.text()))

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
            activityList = applicationCfg.findall("activity")
            
            for activity in activityList:
#                 print child.attrib[key]
                if activity.attrib[key] == "com.unionpay.upomp.bypay.activity.SplashActivity":
                    intentFilterList=activity.findall("intent-filter")
                    for intentFilter in intentFilterList:
                        actionList=intentFilter.findall("action")
                        for action in actionList:
                            action.attrib[key]=unicode(self.lineEdit_10.text())+"_juzi_303310048990001_2_0"
                   
            configTree.write(file_operate.getForManifestXmlPath(), "utf-8")
        
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()

    def retranslateUi(self, Dialog_xcs):
        Dialog_xcs.setWindowTitle(_translate("Dialog_xcs", "Dialog", None))
        self.pushButton.setText(_translate("Dialog_xcs", "确定", None))
        self.groupBox.setTitle(_translate("Dialog_xcs", "渠道信息", None))
        self.label.setText(_translate("Dialog_xcs", "appId", None))
        self.label_2.setText(_translate("Dialog_xcs", "appSecret", None))
        self.label_3.setText(_translate("Dialog_xcs", "gameName", None))
        self.groupBox_2.setTitle(_translate("Dialog_xcs", "平台信息", None))
        self.label_4.setText(_translate("Dialog_xcs", "gameId", None))
        self.label_5.setText(_translate("Dialog_xcs", "appVersion", None))
        self.label_6.setText(_translate("Dialog_xcs", "datacenter", None))
        self.label_7.setText(_translate("Dialog_xcs", "platformType", None))
        self.label_8.setText(_translate("Dialog_xcs", "resVersion", None))
        self.label_9.setText(_translate("Dialog_xcs", "platformId", None))
        self.label_10.setText(_translate("Dialog_xcs", "包名", None))


class Dialogxcs(QDialog,Ui_Dialog_xcs):  
    def __init__(self,parent=None):  
        super(Dialogxcs,self).__init__(parent)  
        self.setupUi(self)
