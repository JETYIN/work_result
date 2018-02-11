# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'FuncellSdkToolsUpdateUI.ui'
#
# Created by: PyQt4 UI code generator 4.11.4
#
# WARNING! All changes made in this file will be lost!

from PyQt4 import QtCore, QtGui
from PyQt4.QtGui import QDialog
from PyQt4.QtCore import Qt

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

class Ui_Form(object):
    def setupUi(self, Form):
        Form.setObjectName(_fromUtf8("Form"))
        Form.resize(498, 197)
        Form.setStyleSheet(_fromUtf8("QPushButton[objectName=\"pushButton\"]{\n"
"background-color: rgb(0, 170, 255);\n"
"color: rgb(255, 255, 255);\n"
"}\n"
"QPushButton[objectName=\"pushButton_2\"]{\n"
"background-color: rgb(0, 165, 0);\n"
"color: rgb(255, 255, 255);\n"
"}\n"
"QWidget[objectName=\"Form\"]{\n"
"background-image: url(:/images/funcell_bg.png);\n"
"}\n"
"\n"
"\n"
""))
        self.label = QtGui.QLabel(Form)
        self.label.setGeometry(QtCore.QRect(190, 20, 111, 20))
        self.label.setObjectName(_fromUtf8("label"))
        self.pushButton = QtGui.QPushButton(Form)
        self.pushButton.setGeometry(QtCore.QRect(130, 140, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.pushButton_2 = QtGui.QPushButton(Form)
        self.pushButton_2.setGeometry(QtCore.QRect(280, 140, 75, 23))
        self.pushButton_2.setObjectName(_fromUtf8("pushButton_2"))
        self.pushButton.clicked.connect(self.btn_Ok)
        self.pushButton_2.clicked.connect(self.btn_Cancel)

        self.retranslateUi(Form)
        QtCore.QMetaObject.connectSlotsByName(Form)

    def retranslateUi(self, Form):
        Form.setWindowTitle(_translate("Form", "Form", None))
        self.label.setText(_translate("Form", "<html><head/><body><p><span style=\" font-size:12pt; font-weight:600; color:#ff0000;\">应用更新提示</span></p></body></html>", None))
        self.pushButton.setText(_translate("Form", "确定", None))
        self.pushButton_2.setText(_translate("Form", "取消", None))
    
    def btn_Ok(self):
        self.accept()
        
    def btn_Cancel(self):
        self.close()
    
    def mousePressEvent(self, event):
    
        if (event.button() == Qt.LeftButton):
          
            self.startPos = event.globalPos() - self.frameGeometry().topLeft()
          
        elif (event.button() == Qt.MiddleButton):
            self.closeWindowAnimation()
        elif(event.button() == Qt.RightButton):
            self.shakeWindow()
    
    
    def mouseMoveEvent(self, event):
        if (event.buttons() == Qt.LeftButton):
            self.endPos = event.globalPos() - self.startPos
            self.move(self.endPos)
    
import res
    
    
class FuncellSdkToolUpdateUI(QDialog,Ui_Form):  
    def __init__(self,parent=None):  
        super(FuncellSdkToolUpdateUI,self).__init__(parent)  
        self.setWindowFlags(Qt.FramelessWindowHint | Qt.SubWindow)
        self.setupUi(self)
