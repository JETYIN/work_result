# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Dialog_yuenan.ui'
#
# Created by: PyQt4 UI code generator 4.11.4
#
# WARNING! All changes made in this file will be lost!

from PyQt4 import QtCore, QtGui

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
        Dialog.resize(446, 534)
        self.pushButton = QtGui.QPushButton(Dialog)
        self.pushButton.setGeometry(QtCore.QRect(190, 497, 75, 23))
        self.pushButton.setObjectName(_fromUtf8("pushButton"))
        self.groupBox = QtGui.QGroupBox(Dialog)
        self.groupBox.setGeometry(QtCore.QRect(30, 30, 401, 201))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.WXAPPID = QtGui.QLabel(self.groupBox)
        self.WXAPPID.setGeometry(QtCore.QRect(20, 60, 91, 16))
        self.WXAPPID.setObjectName(_fromUtf8("WXAPPID"))
        self.WXMCHID = QtGui.QLabel(self.groupBox)
        self.WXMCHID.setGeometry(QtCore.QRect(20, 140, 61, 16))
        self.WXMCHID.setObjectName(_fromUtf8("WXMCHID"))
        self.publicKey = QtGui.QLineEdit(self.groupBox)
        self.publicKey.setGeometry(QtCore.QRect(130, 100, 181, 20))
        self.publicKey.setObjectName(_fromUtf8("publicKey"))
        self.appName = QtGui.QLineEdit(self.groupBox)
        self.appName.setGeometry(QtCore.QRect(130, 60, 181, 20))
        self.appName.setObjectName(_fromUtf8("appName"))
        self.privateKey = QtGui.QLineEdit(self.groupBox)
        self.privateKey.setGeometry(QtCore.QRect(130, 140, 181, 20))
        self.privateKey.setObjectName(_fromUtf8("privateKey"))
        self.WXAPPSECRET = QtGui.QLabel(self.groupBox)
        self.WXAPPSECRET.setGeometry(QtCore.QRect(20, 100, 54, 12))
        self.WXAPPSECRET.setObjectName(_fromUtf8("WXAPPSECRET"))
        self.appId = QtGui.QLabel(self.groupBox)
        self.appId.setGeometry(QtCore.QRect(20, 30, 91, 16))
        self.appId.setObjectName(_fromUtf8("appId"))
        self.appIdLe = QtGui.QLineEdit(self.groupBox)
        self.appIdLe.setGeometry(QtCore.QRect(130, 30, 181, 20))
        self.appIdLe.setObjectName(_fromUtf8("appIdLe"))
        self.label_13 = QtGui.QLabel(Dialog)
        self.label_13.setGeometry(QtCore.QRect(10, 460, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.package_2 = QtGui.QLineEdit(Dialog)
        self.package_2.setGeometry(QtCore.QRect(50, 456, 361, 20))
        self.package_2.setObjectName(_fromUtf8("package_2"))
        self.groupBox_4 = QtGui.QGroupBox(Dialog)
        self.groupBox_4.setGeometry(QtCore.QRect(10, 310, 421, 121))
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
        QtCore.QMetaObject.connectSlotsByName(Dialog)

    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog_360", None))
        self.pushButton.setText(_translate("Dialog", "确定", None))
        self.groupBox.setTitle(_translate("Dialog", "渠道信息", None))
        self.WXAPPID.setText(_translate("Dialog", "appName", None))
        self.WXMCHID.setText(_translate("Dialog", "privateKey", None))
        self.WXAPPSECRET.setText(_translate("Dialog", "publickey", None))
        self.appId.setText(_translate("Dialog", "appId", None))
        self.label_13.setText(_translate("Dialog", "包名", None))
        self.groupBox_4.setTitle(_translate("Dialog", "平台信息", None))
        self.label_9.setText(_translate("Dialog", "gameId", None))
        self.label_10.setText(_translate("Dialog", "platformId", None))
        self.label_11.setText(_translate("Dialog", "appVersion", None))
        self.label_12.setText(_translate("Dialog", "platformType", None))
        self.label_14.setText(_translate("Dialog", "datacenter", None))
        self.label_15.setText(_translate("Dialog", "resVersion", None))

