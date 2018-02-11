# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'test.ui'
#
# Created by: PyQt4 UI code generator 4.11.4
#
# WARNING! All changes made in this file will be lost!

from PyQt4 import QtCore, QtGui
from PyQt4.QtGui import QDialog
from test.test_mutants import Parent

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

class Ui_Dialog_test(object):
    def setupUi(self, Dialog_test):
        Dialog_test.setObjectName(_fromUtf8("Dialog_test"))
        Dialog_test.resize(781, 532)
        self.label = QtGui.QLabel(Dialog_test)
        self.label.setGeometry(QtCore.QRect(110, 90, 54, 12))
        self.label.setObjectName(_fromUtf8("label"))
        self.lineEdit = QtGui.QLineEdit(Dialog_test)
        self.lineEdit.setGeometry(QtCore.QRect(210, 90, 113, 20))
        self.lineEdit.setText(_fromUtf8(""))
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.pushButl = QtGui.QPushButton(Dialog_test)
        self.pushButl.setGeometry(QtCore.QRect(190, 160, 75, 23))
        self.pushButl.setObjectName(_fromUtf8("pushButl"))

        self.retranslateUi(Dialog_test)
        #将点击事件与自己关联
        QtCore.QMetaObject.connectSlotsByName(Dialog_test)
 

    def retranslateUi(self, Dialog_test):
        Dialog_test.setWindowTitle(_translate("Dialog_test", "dialog", None))
        self.label.setText(_translate("Dialog_test", "123", None))
        self.pushButl.setText(_translate("Dialog_test", "lkjjjl", None))
        
        #onclick事件需要自己编写

class Dialogtestpy(QDialog,Ui_Dialog_test):
    def _init_(self,Parent=None):
        super(Dialogtestpy,self).__init__(Parent)
        self.setupUi(self)
