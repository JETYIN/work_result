# -*- coding: utf-8 -*-

# self implementation generated from reading ui file 'packLog.ui'
#
# Created by: PyQt4 UI code generator 4.11.4
#
# WARNING! All changes made in this file will be lost!

from PyQt4.QtGui import *
from PyQt4.QtCore import *
from PyQt4 import *
import webbrowser
from MyChannelVersionLabel import MyChannelVersionLabel
import codecs
from utils import file_operate
from utils.config import ConfigParse
from scrollQLabel_channelItem import scrollTextLabel
from channelItem_pushButton import channelItem_pushButton

#自定义QWidget,用于布局显示
class MyChannelItem(QtGui.QWidget):
    def __init__(self,parent=None):
        super(MyChannelItem,self).__init__(parent)
        self.resize(572, 111)
        
        self.setStyleSheet(("QPushButton[objectName=\"pushButton\"],QPushButton[objectName=\"pushButton_2\"],QPushButton[objectName=\"pushButton_3\"],QPushButton[objectName=\"pushButton_4\"],QPushButton[objectName=\"pushButton_5\"]{\n"
"color: rgb(255, 0, 0);\n"
"border:0px;\n"
"}"))
        self.label = QtGui.QLabel(self)
        self.label.setGeometry(QtCore.QRect(30, 25, 60, 60))
        self.label.setObjectName(("label"))
        self.label_2 = QtGui.QLabel(self)
        self.label_2.setGeometry(QtCore.QRect(110, 60, 54, 12))
        self.label_2.setObjectName(("label_2"))
#         self.label_4 = QtGui.QLabel(self)
        self.label_4 = scrollTextLabel(self)
        self.label_4.setGeometry(QtCore.QRect(110, 20, 110, 12))
        self.label_4.setObjectName(("label_4"))
        self.label_5 = QtGui.QLabel(self)
        self.label_5.setGeometry(QtCore.QRect(110, 40, 54, 12))
        self.label_5.setObjectName(("label_5"))
        self.label_6 = QtGui.QLabel(self)
        self.label_6.setGeometry(QtCore.QRect(160, 40, 68, 12))
        self.label_6.setObjectName(("label_6"))
        self.line = QtGui.QFrame(self)
        self.line.setGeometry(QtCore.QRect(220, 10, 16, 91))
        self.line.setFrameShape(QtGui.QFrame.VLine)
        self.line.setFrameShadow(QtGui.QFrame.Sunken)
        self.line.setObjectName(("line"))
        self.label_9 = QtGui.QLabel(self)
        self.label_9.setGeometry(QtCore.QRect(260, 50, 31, 16))
        self.label_9.setObjectName(("label_9"))
        self.lineEdit = QtGui.QLineEdit(self)
        self.lineEdit.setGeometry(QtCore.QRect(310, 50, 181, 20))
        self.lineEdit.setObjectName(("lineEdit"))
        self.lineEdit.setReadOnly(True)
        self.lineEdit_2 = QtGui.QLineEdit(self)
        self.lineEdit_2.setGeometry(QtCore.QRect(310, 80, 181, 20))
        self.lineEdit_2.setObjectName(("lineEdit_2"))
        self.lineEdit_2.setReadOnly(True)
        self.label_10 = QtGui.QLabel(self)
        self.label_10.setGeometry(QtCore.QRect(260, 80, 31, 16))
        self.label_10.setObjectName(("label_10"))
        self.line_2 = QtGui.QFrame(self)
        self.line_2.setGeometry(QtCore.QRect(0, 0, 572, 1))
        self.line_2.setFrameShape(QtGui.QFrame.HLine)
        self.line_2.setFrameShadow(QtGui.QFrame.Sunken)
        self.line_2.setObjectName(("line_2"))
        self.line_3 = QtGui.QFrame(self)
        self.line_3.setGeometry(QtCore.QRect(0, 110, 572, 1))
        self.line_3.setFrameShape(QtGui.QFrame.HLine)
        self.line_3.setFrameShadow(QtGui.QFrame.Sunken)
        self.line_3.setObjectName(("line_3"))
#         self.pushButton = QtGui.QPushButton(self)
        self.pushButton = channelItem_pushButton(self)
        self.pushButton.setGeometry(QtCore.QRect(165, 60, 49, 12))
        font = QtGui.QFont()
        font.setFamily(("Aharoni"))
        font.setBold(True)
        font.setUnderline(True)
        font.setWeight(75)
        self.pushButton.setFont(font)
        self.pushButton.setLayoutDirection(QtCore.Qt.LeftToRight)
        self.pushButton.setCursor(QtGui.QCursor(QtCore.Qt.PointingHandCursor))
        self.pushButton.setStyleSheet("QPushButton{text-align : left;}")
        self.pushButton.setObjectName(("pushButton"))
        self.pushButton_2 = QtGui.QPushButton(self)
        self.pushButton_2.setGeometry(QtCore.QRect(432, 17, 60, 21))
        self.pushButton_2.setCursor(QtGui.QCursor(QtCore.Qt.PointingHandCursor))
        font = QtGui.QFont()
        font.setFamily(("Aharoni"))
        font.setBold(True)
        font.setUnderline(True)
        font.setWeight(75)
        self.pushButton_2.setFont(font)
        self.pushButton_2.setLayoutDirection(QtCore.Qt.LeftToRight)
        self.pushButton_2.setStyleSheet((""))
        self.pushButton_2.setObjectName(("pushButton_2"))
        self.pushButton_2.setStyleSheet("QPushButton{text-align : right;}")
        self.pushButton_3 = QtGui.QPushButton(self)
        self.pushButton_3.setGeometry(QtCore.QRect(255, 17, 60, 21))
        self.pushButton_3.setCursor(QtGui.QCursor(QtCore.Qt.PointingHandCursor))
        font = QtGui.QFont()
        font.setFamily(("Aharoni"))
        font.setBold(True)
        font.setUnderline(True)
        font.setWeight(75)
        self.pushButton_3.setFont(font)
        self.pushButton_3.setLayoutDirection(QtCore.Qt.LeftToRight)
        self.pushButton_3.setStyleSheet((""))
        self.pushButton_3.setObjectName(("pushButton_3"))
        self.pushButton_4 = QtGui.QPushButton(self)
        self.pushButton_4.setGeometry(QtCore.QRect(165, 80, 41, 12))
        font = QtGui.QFont()
        font.setFamily(("Aharoni"))
        font.setBold(True)
        font.setUnderline(True)
        font.setWeight(75)
        self.pushButton_4.setFont(font)
        self.pushButton_4.setCursor(QtGui.QCursor(QtCore.Qt.PointingHandCursor))
        self.pushButton_4.setLayoutDirection(QtCore.Qt.LeftToRight)
        self.pushButton_4.setStyleSheet("QPushButton{text-align : left;}")
        self.pushButton_4.setObjectName(("pushButton_4"))
        self.label_3 = QtGui.QLabel(self)
        self.label_3.setGeometry(QtCore.QRect(110, 80, 54, 12))
        self.label_3.setObjectName(("label_3"))
        
        
        self.label.setText(u"游戏图片")
        self.label_2.setText(u"渠道版本:")
        self.label_4.setText(u"渠道名")
        self.label_5.setText( u"渠道号:")
        self.label_6.setText(u"渠道号")
        self.label_9.setText( u"包名")
        self.label_10.setText( u"签名")
        self.pushButton.setText( u"版本号")
        self.pushButton_2.setText( u"设置")
        self.pushButton_3.setText( u"闪屏预览")
        self.pushButton_4.setText(u"详情")
        self.label_3.setText(u"插件详情:")
        
        logDir = 'Log/'
        productcode = ConfigParse.shareInstance().getProductCode()
        logFile = codecs.open(logDir +productcode +'/SignFile.log', 'a+', 'utf-8')
        for line in logFile.readlines():
            line = line.rstrip("\r\n")  #此处需要去掉隐藏的\r\n，才能匹配
            idx = line.find('|Default')
            if idx > 0:
                Info = line.split('|')
                self.lineEdit_2.setText(file_operate.getFullPath(unicode(Info[0])))
                break
    
    
    

