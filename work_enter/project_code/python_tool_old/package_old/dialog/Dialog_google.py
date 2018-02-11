# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_google.ui'
#
# Created: Sun Jan 25 21:45:42 2015
#      by: PyQt4 UI code generator 4.11.3
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
        Dialog.resize(379, 240)
        self.label = QtGui.QLabel(Dialog)
        self.label.setGeometry(QtCore.QRect(23, 20, 81, 20))
        self.label.setObjectName(_fromUtf8("label"))
        self.label_2 = QtGui.QLabel(Dialog)
        self.label_2.setGeometry(QtCore.QRect(23, 50, 71, 16))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.label_3 = QtGui.QLabel(Dialog)
        self.label_3.setGeometry(QtCore.QRect(20, 95, 101, 16))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.label_4 = QtGui.QLabel(Dialog)
        self.label_4.setGeometry(QtCore.QRect(20, 121, 54, 12))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.label_5 = QtGui.QLabel(Dialog)
        self.label_5.setGeometry(QtCore.QRect(20, 145, 101, 16))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.label_6 = QtGui.QLabel(Dialog)
        self.label_6.setGeometry(QtCore.QRect(20, 175, 91, 16))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.label_7 = QtGui.QLabel(Dialog)
        self.label_7.setGeometry(QtCore.QRect(260, 23, 54, 12))
        self.label_7.setObjectName(_fromUtf8("label_7"))
        self.label_8 = QtGui.QLabel(Dialog)
        self.label_8.setGeometry(QtCore.QRect(260, 48, 71, 16))
        self.label_8.setObjectName(_fromUtf8("label_8"))
        self.line = QtGui.QFrame(Dialog)
        self.line.setGeometry(QtCore.QRect(20, 70, 341, 16))
        self.line.setFrameShape(QtGui.QFrame.HLine)
        self.line.setFrameShadow(QtGui.QFrame.Sunken)
        self.line.setObjectName(_fromUtf8("line"))
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(150, 208, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.lineEdit = QtGui.QLineEdit(Dialog)
        self.lineEdit.setGeometry(QtCore.QRect(90, 20, 161, 20))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.lineEdit_2 = QtGui.QLineEdit(Dialog)
        self.lineEdit_2.setGeometry(QtCore.QRect(90, 50, 161, 20))
        self.lineEdit_2.setObjectName(_fromUtf8("lineEdit_2"))
        self.lineEdit_3 = QtGui.QLineEdit(Dialog)
        self.lineEdit_3.setGeometry(QtCore.QRect(120, 92, 161, 20))
        self.lineEdit_3.setObjectName(_fromUtf8("lineEdit_3"))
        self.lineEdit_4 = QtGui.QLineEdit(Dialog)
        self.lineEdit_4.setGeometry(QtCore.QRect(120, 119, 161, 20))
        self.lineEdit_4.setObjectName(_fromUtf8("lineEdit_4"))
        self.lineEdit_5 = QtGui.QLineEdit(Dialog)
        self.lineEdit_5.setGeometry(QtCore.QRect(120, 145, 161, 20))
        self.lineEdit_5.setObjectName(_fromUtf8("lineEdit_5"))
        self.lineEdit_6 = QtGui.QLineEdit(Dialog)
        self.lineEdit_6.setGeometry(QtCore.QRect(120, 174, 161, 20))
        self.lineEdit_6.setObjectName(_fromUtf8("lineEdit_6"))

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
            self.lineEdit.setText(channel.get("privateKey"))
            self.lineEdit_2.setText(channel.get("funcellKey"))
            
            
            valuesFolder = constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName()+"/ForRes/values/"
            #read ForRes/values/strings.xml
            stringsXml = valuesFolder + "strings.xml"
            configTree = ET.parse(file_operate.getFullPath(stringsXml))
            configRoot = configTree.getroot()
            stringList = configRoot.findall("string")
            finedapiKey = False
            finedgcmKey = False
            findedKakaoKey = False
            finedKakaoScheme = False
            for stringItem in stringList:
                if (stringItem.attrib["name"] == "nextmv_api_key"):
                    print stringItem.text
                    self.lineEdit_3.setText(stringItem.text)
                    finedapiKey = True
                elif (stringItem.attrib["name"] == "gcm_key"):
                    print stringItem.text
                    self.lineEdit_4.setText(stringItem.text)
                    finedgcmKey = True
                elif (stringItem.attrib["name"] == "kakao_app_key"):
                    self.lineEdit_5.setText(stringItem.text)
                    findedKakaoKey = True
                elif (stringItem.attrib["name"] == "kakao_scheme"):
                    self.lineEdit_6.setText(stringItem.text)
                    finedKakaoScheme = True
                
                if finedapiKey and finedgcmKey and findedKakaoKey and finedKakaoScheme:
                    break         
        
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
            channel.set("privateKey", unicode(self.lineEdit.text()))
            channel.set("funcellKey", unicode(self.lineEdit_2.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
            
            
            valuesFolder = constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName()+"/ForRes/values/"
            #write ForRes/values/strings.xml
            stringsXml = valuesFolder + "strings.xml"
            configTree = ET.parse(file_operate.getFullPath(stringsXml))
            configRoot = configTree.getroot()
            stringList = configRoot.findall("string")
            finedapiKey = False
            finedgcmKey = False
            findedKakaoKey = False
            finedKakaoScheme = False
            for stringItem in stringList:
                if (stringItem.attrib["name"] == "nextmv_api_key"):
                    stringItem.text = unicode(self.lineEdit_3.text())
                    finedapiKey = True
                elif (stringItem.attrib["name"] == "gcm_key"):
                    stringItem.text = unicode(self.lineEdit_4.text())
                    finedgcmKey = True
                elif (stringItem.attrib["name"] == "kakao_app_key"):
                    stringItem.text = unicode(self.lineEdit_5.text())
                    findedKakaoKey = True
                elif (stringItem.attrib["name"] == "kakao_scheme"):
                    stringItem.text = unicode(self.lineEdit_6.text())
                    finedKakaoScheme = True
                
                if finedapiKey and finedgcmKey and findedKakaoKey and finedKakaoScheme:
                    break
            configTree.write(stringsXml, "utf-8")
        
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
        self.close()

    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog_google", None))
        self.label.setText(_translate("Dialog", "privateKey", None))
        self.label_2.setText(_translate("Dialog", "funcellKey", None))
        self.label_3.setText(_translate("Dialog", "nextmv_api_key", None))
        self.label_4.setText(_translate("Dialog", "gcm_key", None))
        self.label_5.setText(_translate("Dialog", "kakao_app_key", None))
        self.label_6.setText(_translate("Dialog", "kakao_scheme", None))
        self.label_7.setText(_translate("Dialog", "googleKey", None))
        self.label_8.setText(_translate("Dialog", "平台验证key", None))
        self.pushButton.setText(_translate("Dialog", "确定", None))
        
class Dialoggoogle(QDialog,Ui_Dialog):  
    def __init__(self,parent=None):  
        super(Dialoggoogle,self).__init__(parent)  
        self.setupUi(self)

