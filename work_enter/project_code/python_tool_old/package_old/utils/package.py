# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'C:\Python27\Lib\site-packages\PyQt4\package.ui'
#
# Created: Tue Sep 23 22:53:05 2014
#      by: PyQt4 UI code generator 4.11.2
#
# WARNING! All changes made in this file will be lost!

from PyQt4 import QtCore, QtGui
from xml.etree import ElementTree as ET
from xml.dom import minidom
import os
import sys
import file_operate
from config import ConfigParse
from PyQt4.Qt import QString, QSize
import apk_operate
import modifyManifest
from PyQt4.QtCore import *  
import codecs
import start

from dialog.Dialog_91 import Dialog91
from dialog.Dialog_uc import Dialoguc
from dialog.Dialog_360 import Dialog360
from dialog.Dialog_4399 import Dialog4399
from dialog.Dialog_baofeng import Dialogbaofeng
from dialog.Dialog_gfan import Dialoggfan
from dialog.Dialog_huawei import Dialoghuawei
from dialog.Dialog_553 import Dialog553
from dialog.Dialog_aiyouxi import Dialogaiyouxi
from dialog.Dialog_meizu import Dialogmeizu
from dialog.Dialog_mumayi import Dialogmumayi
from dialog.Dialog_sogou import Dialogsogou
from dialog.Dialog_oppo import Dialogoppo
from dialog.Dialog_youmi import Dialogyoumi
from dialog.Dialog_xiaomi import Dialogxiaomi
from dialog.Dialog_youku import Dialogyouku
from dialog.Dialog_dangle import Dialogdangle
from dialog.Dialog_lenovo import Dialoglenovo
from dialog.Dialog_duoku import Dialogduoku
from dialog.Dialog_vivo import Dialogvivo
from dialog.Dialog_wdj import Dialogwdj
from dialog.Dialog_xiaohuoban import Dialogxiaohuoban
from dialog.Dialog_ydmm import Dialogydmm
from dialog.Dialog_tstore import Dialogtstore
from dialog.Dialog_naver import Dialognaver
from dialog.Dialog_wanpu import Dialogwanpu
from dialog.Dialog_yingyongbao import Dialogyingyongbao
from dialog.Dialog_coco import Dialogcoco
from dialog.Dialog_funcell import Dialogfuncell_cps
from dialog.Dialog_funcell_reyun import Dialogfuncell_reyun
from dialog.Dialog_funcell_reyun_appsflyer import Dialogfuncell_reyun_appsflyer
from dialog.Dialog_funcell_japan import Dialogfuncell_japan
from dialog.Dialog_funcell_nocps import Dialogfuncell_nocps
from dialog.Dialog_kaiyou import Dialogkaiyou
from dialog.Dialog_linyou import Dialoglinyou
from dialog.Dialog_tw_joycell import Dialogtw_joycell
from dialog.Dialog_tw_joycell_google import Dialogtw_joycell_google
from dialog.Dialog_xcs import Dialogxcs
from dialog.Dialog_aipai import Dialogaipai
from dialog.Dialog_pptv import Dialogpptv
from dialog.Dialog_mz import Dialogmz
from dialog.Dialog_gionee import Dialoggionee
from dialog.Dialog_anzhi import Dialoganzhi
from dialog.Dialog_360np import Dialog360np
from dialog.Dialog_meizu37 import Dialogmeizu37
from dialog.Dialog_sina import Dialogsina
from dialog.Dialog_hmwan import Dialoghmwan
from dialog.Dialog_kupai import Dialogkupai
from dialog.Dialog_muzhiwan import Dialogmuzhiwan
from dialog.Dialog_efuntw import Dialogefuntw
from dialog.Dialog_paojiao import Dialogpaojiao
from dialog.Dialog_kuaiyong import Dialogkuaiyong
from dialog.Dialog_muzhiwan2 import Dialogmuzhiwan2
from dialog.Dialog_letv import Dialogletv
from dialog.Dialog_muzhiwan_yyh import Dialogmuzhiwan_yyh
from dialog.Dialog_pps import Dialogpps
from dialog.Dialog_youlong import Dialogyoulong
from dialog.Dialog_efuntw_google import Dialogefuntw_google
from dialog.Dialog_efuntw_asus import Dialogefuntw_asus
from dialog.Dialog_tw_zhiyou import Dialogtw_zhiyou
from dialog.Dialog_yijie import Dialogyijie
from dialog.Dialog_kuaifa import Dialogkuaifa
from dialog.Dialog_efuntw_google_01 import Dialogefuntw_google_01
from dialog.Dialog_yujia import Dialogyujia
from dialog.Dialog_xunlei import Dialogxunlei
from dialog.Dialog_anqu import Dialoganqu
from dialog.Dialog_xmw import Dialogxmw
from dialog.Dialog_zhongqingbao import Dialogzhongqingbao
from dialog.Dialog_dianhun import Dialogdianhun
from dialog.Dialog_nextmv_naver import Dialognextmv_naver
from dialog.Dialog_hg_google import Dialoggoogle
from dialog.Dialog_nextmv_google import Dialognextmv_google
from dialog.Dialog_liulian import Dialogliulian
from dialog.Dialog_nextmv_tstore import Dialognextmv_tstore
from dialog.Dialog_vstargame_xinma_en import Dialogvstargame_xinma_en
from dialog.Dialog_vstargame_xinma_ch import Dialogvstargame_xinma_ch
from dialog.Dialog_vstargame_taiguo import Dialogvstargame_taiguo
from dialog.Dialog_papa import Dialogpapa
from dialog.Dialog_icc import Dialogicc
from dialog.Dialog_funcell_en_google import Dialogfuncell_en
from dialog.Dialog_vstargame_zhengbao import Dialogvstargame_zhengbao
from dialog.Dialog_51wan import Dialog51wan
from dialog.Dialog_youxiduo import Dialogyouxiduo
from dialog.Dialog_tencent import Dialogtencent
from dialog.Dialog_funcell_kr_google import Dialograink_kr_bf_google
from dialog.Dialog_funcell_kr_tstore import Dialograink_kr_bf_onestore
from dialog.Dialog_yumo import Dialogyumo
from dialog.Dialog_lvan import Dialoglvan
from dialog.Dialog_appota_yuenan import Dialogyuenan_appota
from dialog.Dialog_appota_yuenan_pingtai import Dialogyuenan_appota_pingtai
from dialog.Dialog_vstargame_yuenan import Dialogvstargame_yuenan
from dialog.Dialog_efun_eluosi import Dialogefun_ru_google
from dialog.Dialog_pengyouwan import Dialogpengyouwan
from dialog.Dialog_miyu import Dialogmiyu
from dialog.Dialog_37wan import Dialog37wan
from dialog.Dialog_zhongshouyou import Dialogcmge
from dialog.Dialog_efunhk_google import Dialogefunhk_google
from dialog.Dialog_efunhk_asus import Dialogefunhk_asus
from dialog.Dialog_nextmv_cultrue import Dialognextmv_cultrue
from dialog.Dialog_xipiwan import Dialogxipiwan
from dialog.Dialog_vstargame_xinma_ch_pingtai import Dialogvstargame_xinma_ch_pingtai
from dialog.Dialog_vstargame_xinma_en_pingtai import Dialogvstargame_xinma_en_pingtai
from dialog.Dialog_bluepay_indo import Dialogindofun
from dialog.Dialog_bluepay_indo_pingtai import Dialogindofun_pingtai
from dialog.Dialog_msdk import Dialogmsdk
from dialog.Dialog_kaopu import Dialogkaopu
from dialog.Dialog_indofun_mol_pingtai import Dialogindofun_mol_pingtai
from dialog.Dialog_Raink_CGamex import DialogRaink_CGamex
from dialog.Dialog_appota_yuenan_ba import Dialogyuenan_appota_ba
from dialog.Dialog_xiao7 import Dialogxiao7
from dialog.Dialog_yeshen import Dialogyeshen
from dialog.Dialog_weien import Dialogweien
from dialog.Dialog_sy185 import Dialogsy185
from dialog.Dialog_moxian import Dialogmoxian
from dialog.Dialog_miyu import Dialogmiyu
from dialog.Dialog_fengqu import Dialogfengqu
from dialog.Dialog_kaopu_rehe import Dialogkaopu_rehe
from dialog.Dialog_uc_713 import Dialoguc_713
from dialog.Dialog_shuowan import  Dialogshuowan
from dialog.Dialog_yunding import Dialogyunding
from dialog.Dialog_duoyou import Dialogduoyou
from dialog.Dialog_qiqile import Dialogqiqile
from dialog.Dialog_guopan import Dialogguopan
from dialog.Dialog_yule import Dialogyule
from dialog.Dialog_yunding_en import Dialogyunding_en
from dialog.Dialog_uc_wdj import Dialoguc_wdj
from dialog.Dialog_xiantu import Dialogxiantu
from dialog.Dialog_yijiechouqing import Dialogyijiechouqing
from dialog.Dialog_yijiedianyi import Dialogyijiedianyi



import threading
import constant
from utils.constant import outDir
from PyQt4.Qt import QDesktopServices
from time import sleep
import platform
import error_operate
from __builtin__ import str

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
        Dialog.resize(902, 831)
        self.packBtn = QtGui.QPushButton(Dialog)
        self.packBtn.setGeometry(QtCore.QRect(500, 780, 75, 23))
        self.packBtn.setObjectName(_fromUtf8("packBtn"))
        self.groupBox = QtGui.QGroupBox(Dialog)
        self.groupBox.setGeometry(QtCore.QRect(420, 80, 411, 131))
        self.groupBox.setObjectName(_fromUtf8("groupBox"))
        self.label_2 = QtGui.QLabel(self.groupBox)
        self.label_2.setGeometry(QtCore.QRect(10, 20, 71, 16))
        self.label_2.setObjectName(_fromUtf8("label_2"))
        self.selectKeystore = QtGui.QPushButton(self.groupBox)
        self.selectKeystore.setGeometry(QtCore.QRect(360, 20, 41, 23))
        self.selectKeystore.setObjectName(_fromUtf8("selectKeystore"))
        self.lineEdit = QtGui.QLineEdit(self.groupBox)
        self.lineEdit.setGeometry(QtCore.QRect(90, 20, 251, 20))
        self.lineEdit.setReadOnly(True)
        self.lineEdit.setObjectName(_fromUtf8("lineEdit"))
        self.label_3 = QtGui.QLabel(self.groupBox)
        self.label_3.setGeometry(QtCore.QRect(10, 50, 81, 16))
        self.label_3.setObjectName(_fromUtf8("label_3"))
        self.lineEdit_10 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_10.setGeometry(QtCore.QRect(90, 47, 251, 20))
        self.lineEdit_10.setEchoMode(QtGui.QLineEdit.Password)
        self.lineEdit_10.setObjectName(_fromUtf8("lineEdit_10"))
        self.lineEdit_11 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_11.setGeometry(QtCore.QRect(90, 72, 251, 20))
        self.lineEdit_11.setObjectName(_fromUtf8("lineEdit_11"))
        self.label_12 = QtGui.QLabel(self.groupBox)
        self.label_12.setGeometry(QtCore.QRect(10, 75, 41, 16))
        self.label_12.setObjectName(_fromUtf8("label_12"))
        self.label_13 = QtGui.QLabel(self.groupBox)
        self.label_13.setGeometry(QtCore.QRect(10, 100, 54, 12))
        self.label_13.setObjectName(_fromUtf8("label_13"))
        self.lineEdit_12 = QtGui.QLineEdit(self.groupBox)
        self.lineEdit_12.setGeometry(QtCore.QRect(90, 96, 251, 20))
        self.lineEdit_12.setEchoMode(QtGui.QLineEdit.Password)
        self.lineEdit_12.setObjectName(_fromUtf8("lineEdit_12"))
        self.groupBox_2 = QtGui.QGroupBox(Dialog)
        self.groupBox_2.setGeometry(QtCore.QRect(420, 10, 411, 61))
        self.groupBox_2.setObjectName(_fromUtf8("groupBox_2"))
        self.lineEdit_2 = QtGui.QLineEdit(self.groupBox_2)
        self.lineEdit_2.setGeometry(QtCore.QRect(60, 30, 281, 20))
        self.lineEdit_2.setReadOnly(True)
        self.lineEdit_2.setObjectName(_fromUtf8("lineEdit_2"))
        self.label_4 = QtGui.QLabel(self.groupBox_2)
        self.label_4.setGeometry(QtCore.QRect(10, 30, 54, 12))
        self.label_4.setObjectName(_fromUtf8("label_4"))
        self.selectApk = QtGui.QPushButton(self.groupBox_2)
        self.selectApk.setGeometry(QtCore.QRect(360, 30, 31, 23))
        self.selectApk.setObjectName(_fromUtf8("selectApk"))
        self.openfile = QtGui.QPushButton(Dialog)
        self.openfile.setGeometry(QtCore.QRect(644, 780, 81, 23))
        self.openfile.setObjectName(_fromUtf8("openfile"))
        self.groupBox_5 = QtGui.QGroupBox(Dialog)
        self.groupBox_5.setGeometry(QtCore.QRect(420, 230, 421, 80))
        self.groupBox_5.setObjectName(_fromUtf8("groupBox_5"))
        self.checkBox = QtGui.QCheckBox(self.groupBox_5)
        self.checkBox.setGeometry(QtCore.QRect(270, 20, 71, 16))
        self.checkBox.setChecked(True)
        self.checkBox.setObjectName(_fromUtf8("checkBox"))
        self.label_14 = QtGui.QLabel(self.groupBox_5)
        self.label_14.setGeometry(QtCore.QRect(20, 50, 54, 12))
        self.label_14.setObjectName(_fromUtf8("label_14"))
        self.lineEdit_13 = QtGui.QLineEdit(self.groupBox_5)
        self.lineEdit_13.setGeometry(QtCore.QRect(70, 48, 281, 20))
        self.lineEdit_13.setObjectName(_fromUtf8("lineEdit_13"))
        self.comboBox_2 = QtGui.QComboBox(self.groupBox_5)
        self.comboBox_2.setGeometry(QtCore.QRect(160, 20, 81, 22))
        self.comboBox_2.setObjectName(_fromUtf8("comboBox_2"))
        self.comboBox_2.addItem(_fromUtf8(""))
        self.comboBox_2.addItem(_fromUtf8(""))
        self.comboBox_2.addItem(_fromUtf8(""))
        self.comboBox_2.addItem(_fromUtf8(""))
        self.comboBox_2.addItem(_fromUtf8(""))
        self.comboBox_4 = QtGui.QComboBox(self.groupBox_5)
        self.comboBox_4.setGeometry(QtCore.QRect(20, 20, 121, 22))
        self.comboBox_4.setObjectName(_fromUtf8("comboBox_4"))
        self.comboBox_4.addItem(_fromUtf8(""))
#         self.comboBox_4.addItem(_fromUtf8(""))
#         self.comboBox_4.addItem(_fromUtf8(""))
        self.groupBox_6 = QtGui.QGroupBox(Dialog)
        self.groupBox_6.setGeometry(QtCore.QRect(20, 10, 391, 671))
        self.groupBox_6.setObjectName(_fromUtf8("groupBox_6"))
        self.listWidget = QtGui.QListWidget(self.groupBox_6)
        self.listWidget.setGeometry(QtCore.QRect(10, 60, 371, 591))
        self.listWidget.setObjectName(_fromUtf8("listWidget"))
        self.pushButton_2 = QtGui.QPushButton(self.groupBox_6)
        self.pushButton_2.setGeometry(QtCore.QRect(10, 30, 75, 23))
        self.pushButton_2.setObjectName(_fromUtf8("pushButton_2"))
        self.pushButton_3 = QtGui.QPushButton(self.groupBox_6)
        self.pushButton_3.setGeometry(QtCore.QRect(100, 30, 75, 23))
        self.pushButton_3.setObjectName(_fromUtf8("pushButton_3"))
        self.label = QtGui.QLabel(self.groupBox_6)
        self.label.setGeometry(QtCore.QRect(190, 30, 161, 20))
        self.label.setStyleSheet(_fromUtf8(""))
        self.label.setObjectName(_fromUtf8("label"))
        self.groupBox_8 = QtGui.QGroupBox(Dialog)
        self.groupBox_8.setGeometry(QtCore.QRect(420, 340, 421, 80))
        self.groupBox_8.setObjectName(_fromUtf8("groupBox_8"))
        self.checkBox_4 = QtGui.QCheckBox(self.groupBox_8)
        self.checkBox_4.setGeometry(QtCore.QRect(130, 20, 71, 16))
        self.checkBox_4.setChecked(True)
        self.checkBox_4.setObjectName(_fromUtf8("checkBox_4"))
        self.label_18 = QtGui.QLabel(self.groupBox_8)
        self.label_18.setGeometry(QtCore.QRect(20, 50, 54, 12))
        self.label_18.setObjectName(_fromUtf8("label_18"))
        self.lineEdit_16 = QtGui.QLineEdit(self.groupBox_8)
        self.lineEdit_16.setGeometry(QtCore.QRect(70, 48, 281, 20))
        self.lineEdit_16.setObjectName(_fromUtf8("lineEdit_16"))
        self.comboBox = QtGui.QComboBox(self.groupBox_8)
        self.comboBox.setGeometry(QtCore.QRect(20, 20, 81, 22))
        self.comboBox.setObjectName(_fromUtf8("comboBox"))
        self.comboBox.addItem(_fromUtf8(""))
        self.comboBox.addItem(_fromUtf8(""))
        self.groupBox_9 = QtGui.QGroupBox(Dialog)
        self.groupBox_9.setGeometry(QtCore.QRect(420, 440, 421, 150))
        self.groupBox_9.setObjectName(_fromUtf8("groupBox_9"))
        self.checkBox_5 = QtGui.QCheckBox(self.groupBox_9)
        self.checkBox_5.setGeometry(QtCore.QRect(130, 20, 71, 16))
        self.checkBox_5.setChecked(True)
        self.checkBox_5.setObjectName(_fromUtf8("checkBox_5"))
        self.label_19 = QtGui.QLabel(self.groupBox_9)
        self.label_19.setGeometry(QtCore.QRect(20, 50, 54, 12))
        self.label_19.setObjectName(_fromUtf8("label_19"))
        self.lineEdit_17 = QtGui.QLineEdit(self.groupBox_9)
        self.lineEdit_17.setGeometry(QtCore.QRect(90, 48, 281, 20))
        self.lineEdit_17.setObjectName(_fromUtf8("lineEdit_17"))
        self.comboBox_3 = QtGui.QComboBox(self.groupBox_9)
        self.comboBox_3.setGeometry(QtCore.QRect(20, 20, 81, 22))
        self.comboBox_3.setObjectName(_fromUtf8("comboBox_3"))
        self.comboBox_3.addItem(_fromUtf8(""))
        self.comboBox_3.addItem(_fromUtf8(""))
        self.comboBox_3.addItem(_fromUtf8(""))
        self.comboBox_3.addItem(_fromUtf8(""))
        self.label_5 = QtGui.QLabel(self.groupBox_9)
        self.label_5.setGeometry(QtCore.QRect(20, 90, 54, 12))
        self.label_5.setObjectName(_fromUtf8("label_5"))
        self.label_6 = QtGui.QLabel(self.groupBox_9)
        self.label_6.setGeometry(QtCore.QRect(20, 120, 61, 16))
        self.label_6.setObjectName(_fromUtf8("label_6"))
        self.pushAppKey = QtGui.QLineEdit(self.groupBox_9)
        self.pushAppKey.setGeometry(QtCore.QRect(90, 80, 281, 20))
        self.pushAppKey.setObjectName(_fromUtf8("pushAppKey"))
        self.pushAppSecret = QtGui.QLineEdit(self.groupBox_9)
        self.pushAppSecret.setGeometry(QtCore.QRect(90, 120, 281, 20))
        self.pushAppSecret.setObjectName(_fromUtf8("pushAppSecret"))
        self.groupBox_7 = QtGui.QGroupBox(Dialog)
        self.groupBox_7.setGeometry(QtCore.QRect(420, 600, 421, 80))
        self.groupBox_7.setObjectName(_fromUtf8("groupBox_7"))
        self.checkBox_2 = QtGui.QCheckBox(self.groupBox_7)
        self.checkBox_2.setGeometry(QtCore.QRect(270, 20, 71, 16))
        self.checkBox_2.setChecked(True)
        self.checkBox_2.setObjectName(_fromUtf8("checkBox_2"))
        self.advertising_label = QtGui.QLabel(self.groupBox_7)
        self.advertising_label.setGeometry(QtCore.QRect(20, 50, 54, 12))
        self.advertising_label.setObjectName(_fromUtf8("advertising_label"))
        self.advertising_appid = QtGui.QLineEdit(self.groupBox_7)
        self.advertising_appid.setGeometry(QtCore.QRect(70, 48, 281, 20))
        self.advertising_appid.setObjectName(_fromUtf8("advertising_appid"))
        self.comboBox_5 = QtGui.QComboBox(self.groupBox_7)
        self.comboBox_5.setGeometry(QtCore.QRect(160, 20, 81, 22))
        self.comboBox_5.setObjectName(_fromUtf8("comboBox_5"))
        self.comboBox_5.addItem(_fromUtf8(""))
        self.comboBox_5.addItem(_fromUtf8(""))
        self.comboBox_5.addItem(_fromUtf8(""))
        self.comboBox_5.addItem(_fromUtf8(""))
        self.comboBox_5.addItem(_fromUtf8(""))
        self.comboBox_6 = QtGui.QComboBox(self.groupBox_7)
        self.comboBox_6.setGeometry(QtCore.QRect(20, 20, 121, 22))
        self.comboBox_6.setObjectName(_fromUtf8("comboBox_6"))
        self.comboBox_6.addItem(_fromUtf8(""))
        self.comboBox_6.addItem(_fromUtf8(""))
        self.comboBox_6.addItem(_fromUtf8(""))
        self.groupBox_3 = QtGui.QGroupBox(Dialog)
        self.groupBox_3.setGeometry(QtCore.QRect(20, 700, 381, 111))
        self.groupBox_3.setObjectName(_fromUtf8("groupBox_3"))
        self.label_7 = QtGui.QLabel(self.groupBox_3)
        self.label_7.setGeometry(QtCore.QRect(20, 50, 61, 16))
        self.label_7.setObjectName(_fromUtf8("label_7"))
        self.label_8 = QtGui.QLabel(self.groupBox_3)
        self.label_8.setGeometry(QtCore.QRect(20, 80, 61, 16))
        self.label_8.setObjectName(_fromUtf8("label_8"))
        self.voiceAppKey = QtGui.QLineEdit(self.groupBox_3)
        self.voiceAppKey.setGeometry(QtCore.QRect(100, 50, 251, 20))
        self.voiceAppKey.setObjectName(_fromUtf8("voiceAppKey"))
        self.voiceSecrectKey = QtGui.QLineEdit(self.groupBox_3)
        self.voiceSecrectKey.setGeometry(QtCore.QRect(100, 80, 251, 20))
        self.voiceSecrectKey.setObjectName(_fromUtf8("voiceSecrectKey"))
        self.checkBox_voice = QtGui.QCheckBox(self.groupBox_3)
        self.checkBox_voice.setGeometry(QtCore.QRect(120, 20, 71, 16))
        self.checkBox_voice.setChecked(True)
        self.checkBox_voice.setObjectName(_fromUtf8("checkBox_voice"))
        self.comboBox_voice = QtGui.QComboBox(self.groupBox_3)
        self.comboBox_voice.setGeometry(QtCore.QRect(20, 20, 81, 22))
        self.comboBox_voice.setObjectName(_fromUtf8("comboBox_voice"))
        self.comboBox_voice.addItem(_fromUtf8(""))
        
        self.retranslateUi(Dialog)
        QtCore.QObject.connect(self.selectKeystore, QtCore.SIGNAL(_fromUtf8("clicked()")), self.selectKeystoreClicked)
        QtCore.QObject.connect(self.selectApk, QtCore.SIGNAL(_fromUtf8("clicked()")), self.selectApkClicked)
        QtCore.QObject.connect(self.packBtn, QtCore.SIGNAL(_fromUtf8("clicked()")), self.packBtnClicked)
        QtCore.QObject.connect(self.openfile, QtCore.SIGNAL(_fromUtf8("clicked()")), self.openfilefolder)
        QtCore.QObject.connect(self.pushButton_2, QtCore.SIGNAL(_fromUtf8("clicked()")), self.selectAll)
        QtCore.QObject.connect(self.pushButton_3, QtCore.SIGNAL(_fromUtf8("clicked()")), self.deSelectAll)
       
        QtCore.QObject.connect(self.checkBox, QtCore.SIGNAL(_fromUtf8("clicked()")), self.checkBoxClicked)
        QtCore.QObject.connect(self.checkBox_4, QtCore.SIGNAL(_fromUtf8("clicked()")), self.checkBox_4Clicked)
        QtCore.QObject.connect(self.checkBox_5, QtCore.SIGNAL(_fromUtf8("clicked()")), self.checkBox_5Clicked)
       
        QtCore.QObject.connect(self.listWidget, QtCore.SIGNAL(_fromUtf8("itemDoubleClicked(QListWidgetItem*)")), self.configChannelClicked)
        QtGui.QWidget.connect(self.comboBox, QtCore.SIGNAL('activated(int)'), self.comboBoxChange)
        QtGui.QWidget.connect(self.comboBox_2, QtCore.SIGNAL('activated(int)'), self.comboBox_2Change)
        QtGui.QWidget.connect(self.comboBox_3, QtCore.SIGNAL('activated(int)'), self.comboBox_3Change)
        QtGui.QWidget.connect(self.comboBox_5, QtCore.SIGNAL('activated(int)'), self.comboBox_5Change)
        QtCore.QMetaObject.connectSlotsByName(Dialog)
        
        
        self.dicDialogSize = {"91":QSize(456, 371),
               "uc[V3.5.3.1]":QSize(445, 430),
               "360[V1.2.2]":QSize(446, 534),
               "4399[V2.6.0.4]":QSize(441, 284),
               "baofeng[V1.2]":QSize(622, 440),
               "gfan[V4.2]":QSize(443, 344),
               "huawei[V1.6.3.53]":QSize(442, 432),
               "aiyouxi[V4.0.6]":QSize(441, 284),
               "mumayi[V3.1_code_16]":QSize(645, 386),
               "sogou[V1.4.30]":QSize(444, 459),
               "oppo[V1.7.4]":QSize(443, 467),
               "google":QSize(645, 413),
               "youmi[V3.53]":QSize(444, 388),
               "xiaomi[V4.4.33]":QSize(441, 323),
               "youku[V2.2]":QSize(441, 398),
               "dangle[V4.2]":QSize(448, 434),
               "lenovo[V2.4.2.3]":QSize(454, 393),
               "duoku[V3.5.2]":QSize(447, 484),
               "vivo[V3.1.3- V2.5.5]":QSize(442, 368),
               "wdj[V4.0.4]":QSize(444, 338),
               "xiaohuoban":QSize(347, 224),
               "ydmm[V3.1.3]":QSize(335, 249),
               "tstore":QSize(379, 240),
               "wanpu[V1.3.0]":QSize(443, 337),
               "coco":QSize(441, 351),
               "funcell_cps":QSize(440, 361),
               "funcell_reyun":QSize(440, 361),
               "funcell_reyun_appsflyer":QSize(440, 361),
               "funcell_japan":QSize(440, 361),
               "funcell_nocps":QSize(440, 361),
               "kaiyou":QSize(447, 419),
               "kupai[V1.3.3]":QSize(640, 466),
               "linyou[V1.3.2]":QSize(465, 314),
               "tw_joycell":QSize(440, 361),
               "tw_joycell_google":QSize(447, 494),
               "tw_zhiyou":QSize(643, 416),
               "xcs":QSize(540, 388),
               "aipai[V2.0]":QSize(452, 403),
               "pptv[V4.2.04.150624]":QSize(452, 403),
               "mz[V2.2]":QSize(445, 338),
               "meizu37[V2.1.2]":QSize(645, 410),
               "gionee[V3.0.7.i]":QSize(452, 327),
               "anzhi[V3.5.1]":QSize(447, 392),
               "360np[V1.0.8]":QSize(446, 534),
               "sina[V1.2.3_123]":QSize(645, 325),
               "hmwan[V1.1.5]":QSize(645, 325),
               "muzhiwan[V3.1.1]":QSize(640, 349),
               "efuntw_google[V1.0.1]":QSize(625, 469),
               "efuntw_asus[V1.0.1]":QSize(625, 469),
               "paojiao[V3.2.1]":QSize(624, 396),
               "kuaiyong[V2.2.1]":QSize(645, 390),
               "muzhiwan2[V2.0.3]":QSize(645, 315),
               "letv[V1.1.0]":QSize(645, 385),
               "muzhiwan_yyh[V6.1.0]":QSize(645, 396),
               "pps[V3.8.0]":QSize(621, 365),
               "youlong[V1.5]":QSize(645, 334),
               "yijie[V2.0]":QSize(645, 334),
               "kuaifa[V2.0.3]":QSize(645, 334),
               "yujia[V1.0]":QSize(645, 334),
               "xunlei[V2.1.0]":QSize(468, 499),
               "anqu[V2.0]":QSize(441, 465),
               "xmw[V2.2.6]":QSize(645, 334),
               "zhongqingbao[V1.0.0]":QSize(527, 537),
               "dianhun[V1.2.2]":QSize(645, 413),
               "nextmv_naver[V1.0.0]":QSize(645, 529),
               "nextmv_google[V1.0.0]":QSize(645, 529),
               "nextmv_tstore[V1.0.0]":QSize(645, 529),
               "nextmv_cultrue[V1.0.0]":QSize(645, 529),
               "liulian[V1.0.0]":QSize(645, 513),
               "vstargame_xinma_ch[V3.5.1]":QSize(645, 403),
               "vstargame_xinma_en[V3.5.1]":QSize(645, 403),
               "vstargame_zhengbao[V3.5.1]":QSize(645, 403),
               "vstargame_taiguo[V3.5.2]":QSize(645, 403),
               "papa[V1.0]":QSize(645, 448),
               "icc[V1.0]":QSize(645, 286),
               "funcell_en":QSize(447, 494),
               "51wan[V1.0]":QSize(446, 534),
               "youxiduo[V1.2.5]":QSize(447, 419),
               "tencent[V1.1.1]":QSize(618, 491),
               "raink_kr_bf_google[V1.0]":QSize(645, 529),
               "raink_kr_bf_onestore[V1.0]":QSize(645, 529),
               "yumo[V1.0]":QSize(440, 361),
               "lvan[V1.0]":QSize(440, 398),
               "yuenan_appota[V1.0]":QSize(645, 529),
               "yuenan_appota_pingtai[V1.0]":QSize(645, 529),
               "vstargame_yuenan[V3.5.4]":QSize(645, 403),
               "efun_ru_google[V1.0]":QSize(645, 472),
               "pengyouwan[V2.2.4]":QSize(447, 419),
               "37wan[V3.0.0]":QSize(447, 419),
               "cmge[V2.2.2]":QSize(447, 419),
               "efunhk_google[V1.0.1]":QSize(625, 469),
               "efunhk_asus[V1.0.1]":QSize(625, 469),
               "xipiwan[V1.0.0]":QSize(447, 419),
               "vstargame_xinma_ch_pingtai[V3.5.1]":QSize(645, 403),
               "vstargame_xinma_en_pingtai[V3.5.1]":QSize(645, 403),
               "indofun[3.8.0]":QSize(645, 529),
               "indofun_pingtai[3.8.0]":QSize(645, 529),
               "msdk[v2.14.5a]":QSize(460, 549),
               "kaopu[v7.1.7]":QSize(447, 419),
               "kaopu_rehe[v6.4.7]":QSize(447, 419),
               "indofun_mol_pingtai[V1.2.2]":QSize(645, 766),
               "yunding[V1.0.0.9]":QSize(645, 766),
               "yunding_en[V1.0.0.9]":QSize(645, 766),
               "Raink_CGamex[V1.0.6]":QSize(440, 361),
               "yuenan_appota_ba[V1.0]":QSize(645, 529),
               "xiao7[V1.6.0]":QSize(640, 397),
               "yeshen[V3.0.0]":QSize(640, 397),
               "sy185[V3.0]":QSize(440, 361),
               "weien[V1.3.9]":QSize(640, 397),
               "moxian[V2.5.0]":QSize(640, 397),
               "miyu[V1.0.0]":QSize(640, 397),
               "fengqu[V2.2.7]":QSize(640, 397),
               "uc_713[V7.1.3]":QSize(445, 430),
               "uc_wdj[V6.0.7.3]":QSize(445, 483),
               "shuowan[V1.4.0]":QSize(445, 430),
               "duoyou[V2.8.0]":QSize(445, 430),
               "qiqile[V1.1.8]":QSize(445, 430),
               "guopan[V3.1.0]":QSize(445, 430),
               "yule[V2.9.0]":QSize(445, 430),
               "xiantu[V2.2.2]":QSize(445, 430),
               "yijiechouqing[V2.7.0]":QSize(445, 430),
               "yijiedianyi[V2.7.0]":QSize(445, 430)
                           }
        self.initDialog()
    
    def checkBoxClicked(self):
        if self.checkBox.isChecked():
            self.lineEdit_13.setEnabled(True)
        else:
            self.lineEdit_13.setEnabled(False)
    def checkBox_4Clicked(self):
        if self.checkBox_4.isChecked():
            self.lineEdit_16.setEnabled(True)
        else:
            self.lineEdit_16.setEnabled(False)
    def checkBox_5Clicked(self):
        if self.checkBox_5.isChecked():
            self.lineEdit_17.setEnabled(True)
            self.pushAppKey.setEnabled(False)
            self.pushAppSecret.setEnabled(False)
            if self.comboBox_3.currentText() == u'个推':
                self.pushAppKey.setEnabled(True)
                self.pushAppSecret.setEnabled(True)
        else:
            self.lineEdit_17.setEnabled(False)
            self.pushAppKey.setEnabled(False)
            self.pushAppSecret.setEnabled(False)
    
    def comboBox_2Change(self):
        commonConfig = minidom.parse(file_operate.getCommonXmlPath())
        rootNode = commonConfig.documentElement
        talkingdataList = rootNode.getElementsByTagName('talkingdata')
        for talkingdataNode in talkingdataList:
            itemList = talkingdataNode.getElementsByTagName('item')
            for item in itemList:
                if item.getAttribute('area') == unicode(self.comboBox_2.currentText()):
                    self.lineEdit_13.setText(item.getAttribute('appId'))
    
    def comboBox_5Change(self):
        commonConfig = minidom.parse(file_operate.getCommonXmlPath())
        rootNode = commonConfig.documentElement
        talkingdataList = rootNode.getElementsByTagName('advertising')
        for talkingdataNode in talkingdataList:
            itemList = talkingdataNode.getElementsByTagName('item')
            for item in itemList:
                if item.getAttribute('area') == unicode(self.comboBox_5.currentText()):
                    self.advertising_appid.setText(item.getAttribute('appId'))
    
    def comboBoxChange(self):
        commonConfig = minidom.parse(file_operate.getCommonXmlPath())
        rootNode = commonConfig.documentElement
        crashList = rootNode.getElementsByTagName('crash')
        for crashNode in crashList:
            itemList = crashNode.getElementsByTagName('item')
            for item in itemList:
                if item.getAttribute('type') == self.comboBox.currentText():
                    self.lineEdit_16.setText(item.getAttribute('appId'))
                    
    def comboBox_3Change(self):
        commonConfig = minidom.parse(file_operate.getCommonXmlPath())
        rootNode = commonConfig.documentElement
        pushList = rootNode.getElementsByTagName('push')
        for pushNode in pushList:
            itemList = pushNode.getElementsByTagName('item')
            for item in itemList:
                if item.getAttribute('type') == unicode(self.comboBox_3.currentText()):
                    self.lineEdit_17.setText(item.getAttribute('appId'))
                    self.pushAppKey.setText('')
                    self.pushAppSecret.setText('')
                    self.lineEdit_17.setEnabled(True)
                    self.pushAppKey.setEnabled(False)
                    self.pushAppSecret.setEnabled(False)
                    if item.getAttribute('type') == u'个推':
                        self.pushAppKey.setEnabled(True)
                        self.pushAppSecret.setEnabled(True)
                        self.pushAppKey.setText(item.getAttribute('appKey'))
                        self.pushAppSecret.setText(item.getAttribute('appSecret'))
                    if not self.checkBox_5.isChecked():
                        self.lineEdit_17.setEnabled(False)
                        self.pushAppKey.setEnabled(False)
                        self.pushAppSecret.setEnabled(False) 
    
    def initDialog(self):
        try:
            # print os.path.abspath('.')
            config = ET.parse(file_operate.getCommonXmlPath())
            root = config.getroot()
            apk = root.find("apk")
            self.lineEdit_2.setText(apk.get("path"))
            keyStore = root.find("keystore")
            self.lineEdit.setText(keyStore.get("path"))
            self.lineEdit_10.setText(keyStore.get("password"))
            self.lineEdit_11.setText(keyStore.get("alias"))
            self.lineEdit_12.setText(keyStore.get("aliaspassword"))
            
            # talkingdata
            commonConfig = minidom.parse(file_operate.getCommonXmlPath())
            rootNode = commonConfig.documentElement
            talkingdataList = rootNode.getElementsByTagName('talkingdata')
            for talkingdataNode in talkingdataList:
                itemList = talkingdataNode.getElementsByTagName('item')
                for item in itemList:
                    if item.getAttribute('area') == self.comboBox_2.currentText():
                        self.lineEdit_13.setText(item.getAttribute("appId"))
            
            talkingdata = root.find("talkingdata")
            status = talkingdata.get("status")
            self.checkBox.setChecked(True) if status == "enable" else self.checkBox.setChecked(False)
            self.lineEdit_13.setText(talkingdata.get("appId"))
            
           
            
            # Crash
            commonConfig = minidom.parse(file_operate.getCommonXmlPath())
            rootNode = commonConfig.documentElement
            crashList = rootNode.getElementsByTagName('crash')
            for crashNode in crashList:
                itemList = crashNode.getElementsByTagName('item')
                for item in itemList:
                    if item.getAttribute('type') == self.comboBox.currentText():
                        self.lineEdit_16.setText(item.getAttribute('appId'))
                    
            crash = root.find("crash")
            status = crash.get("status")
            self.checkBox_4.setChecked(True) if status == "enable" else self.checkBox_4.setChecked(False)
            
            # Push
            
            push = root.find("push")
            status = push.get("status")
            self.checkBox_5.setChecked(True) if status == "enable" else self.checkBox_5.setChecked(False)
            commonConfig = minidom.parse(file_operate.getCommonXmlPath())
            rootNode = commonConfig.documentElement
            pushList = rootNode.getElementsByTagName('push')
            for pushNode in pushList:
               
                self.comboBox_3.setCurrentIndex(self.comboBox_3.findText(unicode(pushNode.getAttribute('type'))))
                itemList = pushNode.getElementsByTagName('item')
                for item in itemList:
                    if item.getAttribute('type') == unicode(self.comboBox_3.currentText()):
                        self.lineEdit_17.setText(item.getAttribute('appId'))
                        self.pushAppKey.setText('')
                        self.pushAppSecret.setText('')
                        self.lineEdit_17.setEnabled(True)
                        self.pushAppKey.setEnabled(False)
                        self.pushAppSecret.setEnabled(False)
                        if item.getAttribute('type') == u'个推':
                            self.pushAppKey.setEnabled(True)
                            self.pushAppSecret.setEnabled(True)
                            self.pushAppKey.setText(item.getAttribute('appKey'))
                            self.pushAppSecret.setText(item.getAttribute('appSecret'))
                        if not self.checkBox_5.isChecked():
                            
                            self.lineEdit_17.setEnabled(False)
                            self.pushAppKey.setEnabled(False)
                            self.pushAppSecret.setEnabled(False)
            
            # advertising
            advertising = root.find("advertising")
            status = advertising.get("status")
            self.checkBox_2.setChecked(True) if status == "enable" else self.checkBox_2.setChecked(False)
            self.advertising_appid.setText(advertising.get("appId"))
            commonConfig = minidom.parse(file_operate.getCommonXmlPath())
            rootNode = commonConfig.documentElement
            advertisingList = rootNode.getElementsByTagName('advertising')
            for advertisingNode in advertisingList:
                itemList = advertisingNode.getElementsByTagName('item')
                for item in itemList:
                    if item.getAttribute('area') == unicode(self.comboBox_5.currentText()):
                        self.advertising_appid.setText(item.getAttribute("appId"))
            
            
            
            # init channellist
            channel = root.find("channel")
            channelName = channel.get("name")
            channelList = channelName.split(',')
            for value in self.dicDialogSize.keys():
                item = QtGui.QListWidgetItem(value)
                item.setFlags(QtCore.Qt.ItemIsEnabled | QtCore.Qt.ItemIsUserCheckable)
                if value in channelList:
                    item.setCheckState(QtCore.Qt.Checked)
                else:
                    item.setCheckState(QtCore.Qt.Unchecked)
                self.listWidget.addItem(item)
                
            # media
            commonConfig = minidom.parse(file_operate.getCommonXmlPath())
            rootNode = commonConfig.documentElement
            mediaList = rootNode.getElementsByTagName("media")
            for mediaNode in mediaList:
                self.voiceAppKey.setText(mediaNode.getAttribute("appKey"))
                self.voiceSecrectKey.setText(mediaNode.getAttribute("appSecret"))
                voiceStatus = mediaNode.getAttribute("status")
                self.checkBox_voice.setChecked(True) if voiceStatus == "enable"else self.checkBox_voice.setChecked(False)
               
            
        
        except Exception, e:
            print e
            print "Error: cannot parse file: commonconfig.xml2."
            return -1
        
    def selectAll(self):
        for i in range(self.listWidget.count()):
            self.listWidget.item(i).setCheckState(QtCore.Qt.Checked)
            
    def deSelectAll(self):
        for i in range(self.listWidget.count()):
            self.listWidget.item(i).setCheckState(QtCore.Qt.Unchecked)
            
    def openfilefolder(self):
        QDesktopServices.openUrl(QUrl(file_operate.getFullPath(constant.outDir), QUrl.TolerantMode))

    
    def configChannelClicked(self, item):
#         def __init__(self,parent=None):
#         super(TestDialog,self).__init__(parent)  
#         self.setupUi(self) 
        print 'item:', item.text()
        channel = item.text().split('[')[0]
        ConfigParse.shareInstance().setChannelName(unicode(channel))
        print channel
        dialog = globals()[unicode("Dialog" + channel)]()
        dialog.setFixedSize(self.dicDialogSize[unicode(item.text())])
        dialog.exec_()

    def selectKeystoreClicked(self):
        s = QtGui.QFileDialog.getOpenFileName(self, u"选择证书文件", "/", "*")  
        if s.length() > 0:
            self.lineEdit.setText(unicode(s)) 


    def selectApkClicked(self):
        s = QtGui.QFileDialog.getOpenFileName(self, "Open file dialog", "/", "apk files(*.apk)")  
        if s.length() > 0:
            self.lineEdit_2.setText(unicode(s))
        
    def reCreateTmpFolder(self):
        tmp = file_operate.getFullPath(constant.tmpPath)
        if os.path.exists(tmp):
            file_operate.delete_file_folder(tmp)
        if not os.path.exists(tmp):
            os.makedirs(tmp)
    
    def packChannel(self, channelName):
        # 渠道打包前调用游戏特有的脚本，脚本名为initialize, 支持bat, exe, pyc
        ConfigParse.shareInstance().setChannelName(channelName)
        
        self.writeConfigToSdkConfigFile()
        ConfigParse.shareInstance().projectConfigRead()
        
        ret = self.execGameCommonInitializeScript()
        if ret:
            return
        
        # 渠道打包前调用游戏针对渠道特有的脚本，脚本名为initialize, 支持bat, exe, pyc
        ret = self.execGameSdkInitializeScript()
        if ret:
            return

        self.reCreateTmpFolder()
        source = ConfigParse.shareInstance().getApkPath()
        file_operate.backupApk(source)
        
        sourceDir = file_operate.getFullPath(constant.sdkRelatePath + ConfigParse.shareInstance().getChannelName())
        print "-----------" + source
        targetDir = file_operate.getFullPath(constant.tmpPath)
        file_operate.copyFiles(sourceDir, targetDir)
        
        apkFile = targetDir + "/common.apk"
        deDir = targetDir + "/oldApkDir"
        apk_operate.decompileApk(apkFile, deDir)
        # 在tmp目录里面进行talkingdata资源的合并最合理
        self.processTalkingData()  # 将talkingdata的资源与sdk资源整合，包括xml, jar，dex以及libs
        
        self.processCrash()  # Crash的资源与sdk资源整合，包括xml, jar，dex以及libs
        
        self.processPush()  # Crash的资源与sdk资源整合，包括xml, jar，dex以及libs
        # if os.path.exists(targetDir + '/ForRes/drawable-xxxhdpi'):
            # if file_operate.getTargetSdkVersion(deDir) < 18:
                # file_operate.delete_file_folder(targetDir + '/ForRes/drawable-xxxhdpi')
        # 合并classes.dex
        oldApkDir = targetDir + "/oldApkDir"
        SmaliDir = oldApkDir + "/smali"
        dexFile = targetDir + "/classes.dex"
        ret = apk_operate.dexTrans2Smali(dexFile, SmaliDir, 3)
        if ret:
            return
        dexFileApk = oldApkDir + "/classes.dex"
        ret = apk_operate.dexTrans2Smali(dexFileApk, SmaliDir, 3)
        if ret:
            return
        
        # copy资源和funcellconfig.xml
        # copy res
        if os.path.exists(targetDir + "/ForRes"):
            apk_operate.copyResToApk(targetDir + "/ForRes", oldApkDir + "/res")
        # copy funcellconfig.xml
        file_operate.copyFile(file_operate.getConfigXmlPath(), oldApkDir + "/assets/funcellconfig.xml")
        # copy Assets
        armPath = targetDir + "/ForAssets/so/armeabi"
        armv7Path = targetDir + "/ForAssets/so/armeabi-v7a"
        
        if os.path.exists(armPath) and os.path.exists(armv7Path):
            apk_operate.copyResToApk(armPath, armv7Path)
            
        if os.path.exists(targetDir + "/ForAssets"):
            apk_operate.copyResToApk(targetDir + "/ForAssets", oldApkDir + "/assets")
        # copy extra
        
        
        
        if os.path.exists(targetDir + "/extra"):
            #-----------------六扇门的特殊脚本-----------------------
            if os.path.exists(targetDir + "/extra/Assets/GameAssets/Resources/Config"):
                self.execOtherScript(targetDir)
                pass
            #----------------------------------------
            apk_operate.copyResToApk(targetDir + "/extra", oldApkDir + "/assets")
        
        # copy libs
#         armLibPath = targetDir+"/ForLibs/armeabi"
#         armv7LibPath = targetDir+"/ForLibs/armeabi-v7a"
#         if os.path.exists(armLibPath) and os.path.exists(armv7LibPath):
#             apk_operate.copyResToApk(armLibPath, armv7LibPath)
#         if os.path.exists(targetDir+"/ForLibs"):
#             apk_operate.copyResToApk(targetDir+"/ForLibs", oldApkDir+"/lib")
#         if os.path.exists(oldApkDir+"/lib/armeabi") and os.path.exists(oldApkDir+"/lib/armeabi-v7a"):
#             apk_operate.copyResToApk(oldApkDir+"/lib/armeabi", oldApkDir+"/lib/armeabi-v7a")
        
        if os.path.exists(targetDir + "/ForLibs"):
            if os.path.exists(oldApkDir + "/lib/armeabi") and os.path.exists(targetDir + "/ForLibs/armeabi"):
                apk_operate.copyResToApk(targetDir + "/ForLibs/armeabi", oldApkDir + "/lib/armeabi")
            if os.path.exists(oldApkDir + "/lib/armeabi-v7a") and os.path.exists(targetDir + "/ForLibs/armeabi-v7a"):
                apk_operate.copyResToApk(targetDir + "/ForLibs/armeabi-v7a", oldApkDir + "/lib/armeabi-v7a")
            if os.path.exists(oldApkDir + "/lib/x86") and os.path.exists(targetDir + "/ForLibs/x86"):
                apk_operate.copyResToApk(targetDir + "/ForLibs/x86", oldApkDir + "/lib/x86")
            if os.path.exists(oldApkDir + "/lib/mips") and os.path.exists(targetDir + "/ForLibs/mips"):
                apk_operate.copyResToApk(targetDir + "/ForLibs/mips", oldApkDir + "/lib/mips")
        
        # 合并AndroidManifest.xml
        manifestFile = oldApkDir + "/AndroidManifest.xml"
        ET.register_namespace('android', constant.androidNS)
        targetTree = ET.parse(manifestFile)
        targetRoot = targetTree.getroot()
 
        haveChanged = modifyManifest.doModify(manifestFile, targetDir + "/ForManifest.xml", targetRoot)
        if haveChanged:
            targetTree.write(manifestFile, 'UTF-8')
        
        
        newPackagename = apk_operate.renameApkPackage(SmaliDir, manifestFile, ConfigParse.shareInstance().getPackageName())

        # 添加闪屏
        print channelName , oldApkDir
        apk_operate.addSplashScreen(channelName, targetDir);
        
        # gamescript,针对游戏的脚本，某些android5.0系统修改权限
        ret = self.execGameCommongameSdkScript(oldApkDir)
        if ret:
            return
        
        # pushScript
        pushScriptPath = targetDir + "/pushScript.pyc"
        if os.path.exists(pushScriptPath):
            sys.path.append(targetDir)
            import pushScript
            reload(pushScript)
            ret = pushScript.script(oldApkDir, newPackagename)
        
        # sdk额外脚本
        scriptPath = targetDir + "/script.pyc"
        if os.path.exists(scriptPath):
            sys.path.append(targetDir)
            import script
            reload(script)
            ret = script.script(oldApkDir, newPackagename)
        
        ret = apk_operate.pushIconIntoApk('', oldApkDir)
        
        apk_operate.modifyGameName('', oldApkDir)  # 处理游戏版本，游戏名称，等功能
        
        ret = apk_operate.produceNewRFile(newPackagename, oldApkDir)
        if ret:
            return

        # smali to dex
        classesDexFile = oldApkDir + "/classes.dex"
        ret = apk_operate.smaliTrans2dex(SmaliDir, classesDexFile)
        if ret:
            return 
#         if os.path.exists(SmaliDir):
#             file_operate.delete_file_folder(SmaliDir)
        
        tempApkName = file_operate.getFullPath(constant.outDir) + "/apk_" + ConfigParse.shareInstance().getChannelName() + "_unsigned.apk"
        ret = apk_operate.recompileApk(oldApkDir, tempApkName)
        if ret:
            return
        keystoreFile = ConfigParse.shareInstance().getKeystoreFile()
        storepassword = ConfigParse.shareInstance().getKeystorePassword()
        alias = ConfigParse.shareInstance().getKeystoreAlias()
        aliasPasswd = ConfigParse.shareInstance().getKeystoreAliasPassword()
        # def signApk(apkFile, keyStore, storepassword, keyalias, aliaspassword):
        ret = apk_operate.signApk(tempApkName, keystoreFile, storepassword, alias, aliasPasswd)
        print "sign"
        print ret
        if ret:
            return
        
        apkName = file_operate.getFullPath(constant.outDir) + "/apk_" + ConfigParse.shareInstance().getChannelName() + ".apk" 
        ret = apk_operate.alignAPK(tempApkName, apkName, file_operate.getFullPath(constant.outDir))
        
        # 渠道打包后调用游戏针对渠道特有的脚本，脚本名为finalize, 支持bat, exe, pyc
        ret = self.execGameSdkFinalizeScript()
        if ret:
            return
        
        # 渠道打包后调用游戏特有的脚本，脚本名为finalize, 支持bat, exe, pyc
        ret = self.execGameCommonFinalizeScript()
        if ret:
            return
        
        print "----------------------------%s pack complete!------------------------" % channelName
        
        
    def packBtnClicked(self):
        
        self.writeConfigToCommonConfigFile()
        
#         for i in range(self.listWidget.count()):
#             item = self.listWidget.item(i)
#             if item.checkState() == QtCore.Qt.Checked:
#                 channel = item.text().split('[')[0]
#                 self.packChannel(unicode(channel))
#         
#         self.openfilefolder()
        
        # 以下方式采用多线程模式
        arrayList = []
        for i in range(self.listWidget.count()):
            item = self.listWidget.item(i)
            if item.checkState() == QtCore.Qt.Checked:
                channel = item.text().split('[')[0]
                arrayList.append(unicode(channel))
        dictTemp = self.GetUiConfig()
        start.start(arrayList, dictTemp)
    
    def GetUiConfig(self):
        dictTemp = {}
        dictTemp['checkBox_isChecked'] = self.checkBox.isChecked()
        dictTemp['checkBox_2_isChecked'] = self.checkBox_2.isChecked()
        dictTemp['checkBox_4_isChecked'] = self.checkBox_4.isChecked()
        dictTemp['checkBox_5_isChecked'] = self.checkBox_5.isChecked()
        dictTemp['comboBox_currentText'] = self.comboBox.currentText()
        dictTemp['comboBox_3_currentText'] = self.comboBox_3.currentText()
        dictTemp['comboBox_4_currentText'] = self.comboBox_4.currentText()
        dictTemp['comboBox_6_currentText'] = self.comboBox_6.currentText()
        dictTemp['lineEdit_13_text'] = self.lineEdit_13.text()
        dictTemp['lineEdit_16_text'] = self.lineEdit_16.text()
        dictTemp['lineEdit_17_text'] = self.lineEdit_17.text()
        dictTemp['advertising_appid'] = self.advertising_appid.text()
        dictTemp['pushAppKey_text'] = self.pushAppKey.text()
        dictTemp['pushAppSecret_text'] = self.pushAppSecret.text()
        
        dictTemp['checkBox_voice_isChecked'] = self.checkBox_voice.isChecked()
        dictTemp['comboBox_voice_currentText'] = self.comboBox_voice.currentText()
        dictTemp['mediaAppkey_text'] = self.voiceAppKey.text()
        dictTemp['voiceSecrectKey_text'] = self.voiceSecrectKey.text()
        
        return dictTemp
    
    def processTalkingData(self):
        
        if not self.checkBox.isChecked():
            return
        
       
        talkingdataPath = file_operate.getTalkingDataPath()
        file_operate.copyFiles(talkingdataPath + "/jar", constant.tmpPath + "/jar")
        
        # os.remove(constant.tmpPath+"/classes.dex") #要生成新的classes.dex需要移除之前的classes.dex
        if platform.system() == 'Windows':
            dxTool = file_operate.getToolPath('dx.bat')
        else:
            dxTool = file_operate.getToolPath('dx')
        cmd = '"%s" --dex --output="%s" "%s"' % (dxTool, file_operate.getFullPath(constant.tmpPath + "/classes.dex"), file_operate.getFullPath(constant.tmpPath + "/jar"))  # 合并jar
        print "cmd" + cmd
        ret = file_operate.execFormatCmd(cmd)
        if ret:
            error_operate.error(104)
            return
        
        # 合并ForManifest.xml
        manifestFile = file_operate.getFullPath(constant.tmpPath + "/ForManifest.xml")
        ET.register_namespace('android', constant.androidNS)
        targetTree = ET.parse(manifestFile)
        targetRoot = targetTree.getroot()
 
        haveChanged = modifyManifest.doModifyForManifest(manifestFile, talkingdataPath + "/ForManifest.xml", targetRoot)
        if haveChanged:
            targetTree.write(manifestFile, 'UTF-8')
            
    def processCrash(self):
        if not self.checkBox_4.isChecked():
            return
        crashPath = file_operate.getCrashPath()
        thirdCrashName = self.comboBox.currentText()
        thirdCrashPath = crashPath + '/' + str(thirdCrashName)
        print "..........", thirdCrashPath
        file_operate.copyFiles(thirdCrashPath + "/jar", constant.tmpPath + "/jar")
        if platform.system() == 'Windows':
            dxTool = file_operate.getToolPath('dx.bat')
        else:
            dxTool = file_operate.getToolPath('dx')
        cmd = '"%s" --dex --output="%s" "%s"' % (dxTool, file_operate.getFullPath(constant.tmpPath + "/classes.dex"), file_operate.getFullPath(constant.tmpPath + "/jar"))  # 合并jar
        print "cmd" + cmd
        ret = file_operate.execFormatCmd(cmd)
        if ret:
            error_operate.error(104)
            return
        
        # copy libs
        targetDir = file_operate.getFullPath(constant.tmpPath)
        oldApkDir = targetDir + "/oldApkDir"
        
        if os.path.exists(thirdCrashPath + "/ForLibs"):
            if os.path.exists(oldApkDir + "/lib/armeabi") and os.path.exists(thirdCrashPath + "/ForLibs/armeabi"):
                apk_operate.copyResToApk(thirdCrashPath + "/ForLibs/armeabi", oldApkDir + "/lib/armeabi")
            if os.path.exists(oldApkDir + "/lib/armeabi-v7a") and os.path.exists(thirdCrashPath + "/ForLibs/armeabi-v7a"):
                apk_operate.copyResToApk(thirdCrashPath + "/ForLibs/armeabi-v7a", oldApkDir + "/lib/armeabi-v7a")
            if os.path.exists(oldApkDir + "/lib/x86") and os.path.exists(thirdCrashPath + "/ForLibs/x86"):
                apk_operate.copyResToApk(thirdCrashPath + "/ForLibs/x86", oldApkDir + "/lib/x86")
        
        # 合并ForManifest.xml
        manifestFile = file_operate.getFullPath(constant.tmpPath + "/ForManifest.xml")
        ET.register_namespace('android', constant.androidNS)
        targetTree = ET.parse(manifestFile)
        targetRoot = targetTree.getroot()
 
        haveChanged = modifyManifest.doModifyForManifest(manifestFile, thirdCrashPath + "/ForManifest.xml", targetRoot)
        if haveChanged:
            targetTree.write(manifestFile, 'UTF-8')
    
    def processPush(self):
        if not self.checkBox_5.isChecked():
            return
        pushPath = file_operate.getPushPath()
        thirdPushName = unicode(self.comboBox_3.currentText())
        thirdPushPath = pushPath + '/' + thirdPushName
        file_operate.copyFiles(thirdPushPath + "/jar", constant.tmpPath + "/jar")
        if platform.system() == 'Windows':
            dxTool = file_operate.getToolPath('dx.bat')
        else:
            dxTool = file_operate.getToolPath('dx')
        cmd = '"%s" --dex --output="%s" "%s"' % (dxTool, file_operate.getFullPath(constant.tmpPath + "/classes.dex"), file_operate.getFullPath(constant.tmpPath + "/jar"))  # 合并jar
        ret = file_operate.execFormatCmd(cmd)
        if ret:
            error_operate.error(104)
            return
        
        # copy libs
        targetDir = file_operate.getFullPath(constant.tmpPath)
        oldApkDir = targetDir + "/oldApkDir"
        if os.path.exists(thirdPushPath + "/ForLibs"):
            if os.path.exists(oldApkDir + "/lib/armeabi") and os.path.exists(thirdPushPath + "/ForLibs/armeabi"):
                apk_operate.copyResToApk(thirdPushPath + "/ForLibs/armeabi", oldApkDir + "/lib/armeabi")
            if os.path.exists(oldApkDir + "/lib/armeabi-v7a") and os.path.exists(thirdPushPath + "/ForLibs/armeabi-v7a"):
                apk_operate.copyResToApk(thirdPushPath + "/ForLibs/armeabi-v7a", oldApkDir + "/lib/armeabi-v7a")
            if os.path.exists(oldApkDir + "/lib/x86") and os.path.exists(thirdPushPath + "/ForLibs/x86"):
                apk_operate.copyResToApk(thirdPushPath + "/ForLibs/x86", oldApkDir + "/lib/x86")
        
        # copy res
        if os.path.exists(thirdPushPath + "/ForRes"):
            apk_operate.copyResToApk(thirdPushPath + "/ForRes", oldApkDir + "/res")
            
        # copy pushScript
        file_operate.copyFile(thirdPushPath + "/pushScript.pyc", targetDir + "/pushScript.pyc")
        
        # 合并ForManifest.xml
        manifestFile = file_operate.getFullPath(constant.tmpPath + "/ForManifest.xml")
        ET.register_namespace('android', constant.androidNS)
        targetTree = ET.parse(manifestFile)
        targetRoot = targetTree.getroot()
 
        haveChanged = modifyManifest.doModifyForManifest(manifestFile, thirdPushPath + "/ForManifest.xml", targetRoot)
        if haveChanged:
            targetTree.write(manifestFile, 'UTF-8')
            
            
    # 语音 
    def processMedia(self):
        if not self.checkBox_voice.isChecked():
            return
        mediaPath = file_operate.getPushPath()
        thirdMediaName = unicode(self.comboBox_voice.currentText())
        thirdMediaPath = mediaPath + '/' + thirdMediaName
        file_operate.copyFiles(thirdMediaPath + "/jar", constant.tmpPath + "/jar")
        if platform.system() == 'Windows':
            dxTool = file_operate.getToolPath('dx.bat')
        else:
            dxTool = file_operate.getToolPath('dx')
        cmd = '"%s" --dex --output="%s" "%s"' % (dxTool, file_operate.getFullPath(constant.tmpPath + "/classes.dex"), file_operate.getFullPath(constant.tmpPath + "/jar"))  # 合并jar
        ret = file_operate.execFormatCmd(cmd)
        if ret:
            error_operate.error(104)
            return
        # copy libs
        targetDir = file_operate.getFullPath(constant.tmpPath)
        oldApkDir = targetDir + "/oldApkDir"
        if os.path.exists(thirdMediaPath + "/ForLibs"):
            if os.path.exists(oldApkDir + "/lib/armeabi") and os.path.exists(thirdMediaPath + "/ForLibs/armeabi"):
                apk_operate.copyResToApk(thirdMediaPath + "/ForLibs/armeabi", oldApkDir + "/lib/armeabi")
            if os.path.exists(oldApkDir + "/lib/armeabi-v7a") and os.path.exists(thirdMediaPath + "/ForLibs/armeabi-v7a"):
                apk_operate.copyResToApk(thirdMediaPath + "/ForLibs/armeabi-v7a", oldApkDir + "/lib/armeabi-v7a")
            if os.path.exists(oldApkDir + "/lib/x86") and os.path.exists(thirdMediaPath + "/ForLibs/x86"):
                apk_operate.copyResToApk(thirdMediaPath + "/ForLibs/x86", oldApkDir + "/lib/x86")
        
        # copy res
        if os.path.exists(thirdMediaPath + "/ForRes"):
            apk_operate.copyResToApk(thirdMediaPath + "/ForRes", oldApkDir + "/res")
            
        # copy pushScript
        file_operate.copyFile(thirdMediaPath + "/pushScript.pyc", targetDir + "/pushScript.pyc")
        
        # 合并ForManifest.xml
        manifestFile = file_operate.getFullPath(constant.tmpPath + "/ForManifest.xml")
        ET.register_namespace('android', constant.androidNS)
        targetTree = ET.parse(manifestFile)
        targetRoot = targetTree.getroot() 
        
        haveChanged = modifyManifest.doModifyForManifest(manifestFile, thirdMediaPath + "/ForManifest.xml", targetRoot)
        if haveChanged:
            targetTree.write(manifestFile, 'UTF-8')   
            
        
    def execOtherScript(self, oldApkDir):
        if (os.path.exists(file_operate.getGameCommonScriptPath())):
            otherScriptPyc = file_operate.getGameCommonScriptPath() + "/otherScript.pyc"
            if os.path.exists(otherScriptPyc):
                sys.path.append(file_operate.getGameCommonScriptPath())
                import otherScript
                reload(otherScript)
                ret = otherScript.otherScript(oldApkDir)
        
    def execGameSdkInitializeScript(self):
        if (os.path.exists(file_operate.getGameSdkScriptPath())):
            channelName = ConfigParse.shareInstance().getChannelName()
            platformId = ConfigParse.shareInstance().getPlatformId()
            appVersion = ConfigParse.shareInstance().getAppVersion()
            resVersion = ConfigParse.shareInstance().getResVersion()
            
            gameSdkInitScriptBat = file_operate.getGameSdkScriptPath() + "/initialize.bat"
            if (os.path.exists(gameSdkInitScriptBat)):
                cmd = '"%s" "%s" "%s" "%s" "%s"' % (gameSdkInitScriptBat, platformId, channelName, appVersion, resVersion)
                ret = file_operate.execFormatCmd(cmd)
                if ret:
                    print "execute sdk initialize.bat error"
                    return 1
            gameSdkInitScriptExe = file_operate.getGameSdkScriptPath() + "/initialize.exe"
            if (os.path.exists(gameSdkInitScriptExe)):
                cmd = '"%s" "%s" "%s" "%s" "%s"' % (gameSdkInitScriptExe, platformId, channelName, appVersion, resVersion)
                ret = file_operate.execFormatCmd(cmd)
                if ret:
                    print "execute sdk initialize.exe error"
                    return 1
            gameSdkInitScriptPyc = file_operate.getGameSdkScriptPath() + "/initialize.pyc"
            if os.path.exists(gameSdkInitScriptPyc):
                sys.path.append(file_operate.getGameSdkScriptPath())
                import initialize
                ret = initialize.initialize(platformId, channelName, appVersion, resVersion)
                
    def execGameSdkFinalizeScript(self):
        if (os.path.exists(file_operate.getGameSdkScriptPath())):
            channelName = ConfigParse.shareInstance().getChannelName()
            platformId = ConfigParse.shareInstance().getPlatformId()
            appVersion = ConfigParse.shareInstance().getAppVersion()
            resVersion = ConfigParse.shareInstance().getResVersion()
            
            gameSdkFinalizeScriptBat = file_operate.getGameSdkScriptPath() + "/finalize.bat"
            if (os.path.exists(gameSdkFinalizeScriptBat)):
                cmd = '"%s" "%s" "%s" "%s" "%s"' % (gameSdkFinalizeScriptBat, platformId, channelName, appVersion, resVersion)
                ret = file_operate.execFormatCmd(cmd)
                if ret:
                    print "execute sdk finalize.bat error"
                    return 1
            gameSdkFinalizeScriptExe = file_operate.getGameSdkScriptPath() + "/finalize.exe"
            if (os.path.exists(gameSdkFinalizeScriptExe)):
                cmd = '"%s" "%s" "%s" "%s" "%s"' % (gameSdkFinalizeScriptExe, platformId, channelName, appVersion, resVersion)
                ret = file_operate.execFormatCmd(cmd)
                if ret:
                    print "execute sdk finalize.exe error"
                    return 1
            gameSdkFinalizeScriptPyc = file_operate.getGameSdkScriptPath() + "/finalize.pyc"
            if os.path.exists(gameSdkFinalizeScriptPyc):
                sys.path.append(file_operate.getGameSdkScriptPath())
                import finalize
                ret = finalize.finalize(platformId, channelName, appVersion, resVersion)
    
    def execGameCommongameSdkScript(self, oldApkDir):
        if (os.path.exists(file_operate.getGameCommonScriptPath())):
            channelName = ConfigParse.shareInstance().getChannelName()
            
            gameCommongameSdkScriptPyc = file_operate.getGameCommonScriptPath() + "/gameSdkScript.pyc"
            if os.path.exists(gameCommongameSdkScriptPyc):
                sys.path.append(file_operate.getGameCommonScriptPath())
                import gameSdkScript
                reload(gameSdkScript)
                ret = gameSdkScript.gameSdkScript(oldApkDir, channelName)
    
    def execGameCommonInitializeScript(self):
        if (os.path.exists(file_operate.getGameCommonScriptPath())):
            channelName = ConfigParse.shareInstance().getChannelName()
            platformId = ConfigParse.shareInstance().getPlatformId()
            appVersion = ConfigParse.shareInstance().getAppVersion()
            resVersion = ConfigParse.shareInstance().getResVersion()
            platformType = ConfigParse.shareInstance().getplatformType()
            
            gameCommonInitScriptBat = file_operate.getGameCommonScriptPath() + "/initialize.bat"
            if (os.path.exists(gameCommonInitScriptBat)):
                cmd = '"%s" "%s" "%s" "%s" "%s"' % (gameCommonInitScriptBat, platformId, channelName, appVersion, resVersion)
                ret = file_operate.execFormatCmd(cmd)
                if ret:
                    print "execute initialize.bat error"
                    return 1
            gameCommonInitScriptExe = file_operate.getGameCommonScriptPath() + "/initialize.exe"
            if (os.path.exists(gameCommonInitScriptExe)):
                cmd = '"%s" "%s" "%s" "%s" "%s"' % (gameCommonInitScriptExe, platformId, channelName, appVersion, resVersion)
                ret = file_operate.execFormatCmd(cmd)
                if ret:
                    print "execute initialize.exe error"
                    return 1
            gameCommonInitScriptPyc = file_operate.getGameCommonScriptPath() + "/initialize.pyc"
            if os.path.exists(gameCommonInitScriptPyc):
                sys.path.append(file_operate.getGameCommonScriptPath())
                import initialize
                ret = initialize.initialize(platformId, channelName, platformType, appVersion, resVersion)
    
    
    def execGameCommonFinalizeScript(self):
        if (os.path.exists(file_operate.getGameCommonScriptPath())):
            channelName = ConfigParse.shareInstance().getChannelName()
            platformId = ConfigParse.shareInstance().getPlatformId()
            appVersion = ConfigParse.shareInstance().getAppVersion()
            resVersion = ConfigParse.shareInstance().getResVersion()
            
            gameCommonFinalizeScriptBat = file_operate.getGameCommonScriptPath() + "/finalize.bat"
            if (os.path.exists(gameCommonFinalizeScriptBat)):
                cmd = '"%s" "%s" "%s" "%s" "%s"' % (gameCommonFinalizeScriptBat, platformId, channelName, appVersion, resVersion)
                ret = file_operate.execFormatCmd(cmd)
                if ret:
                    print "execute finalize.bat error"
                    return 1
            gameCommonFinalizeScriptExe = file_operate.getGameCommonScriptPath() + "/finalize.exe"
            if (os.path.exists(gameCommonFinalizeScriptExe)):
                cmd = '"%s" "%s" "%s" "%s" "%s"' % (gameCommonFinalizeScriptExe, platformId, channelName, appVersion, resVersion)
                ret = file_operate.execFormatCmd(cmd)
                if ret:
                    print "execute finalize.exe error"
                    return 1
            gameCommonFinalizeScriptPyc = file_operate.getGameCommonScriptPath() + "/finalize.pyc"
            if os.path.exists(gameCommonFinalizeScriptPyc):
                print "gameCommonFinalize" + file_operate.getGameCommonScriptPath() + "/finalize.pyc"
                sys.path.append(file_operate.getGameCommonScriptPath())
                import finalize
                ret = finalize.finalize(platformId, channelName, appVersion, resVersion, self.checkBox.isChecked(), self.checkBox_4.isChecked(), self.checkBox_5.isChecked())
        
    
    def writeConfigToCommonConfigFile(self):
        try:
            # print os.path.abspath('.')
            config = ET.parse(file_operate.getCommonXmlPath())
            root = config.getroot()
            apk = root.find("apk")
            apk.set("path", unicode(self.lineEdit_2.text()))
            keyStore = root.find("keystore")
            keyStore.set("path", unicode(self.lineEdit.text()))
            keyStore.set("password", unicode(self.lineEdit_10.text()))
            keyStore.set("alias", unicode(self.lineEdit_11.text()))
            keyStore.set("aliaspassword", unicode(self.lineEdit_12.text()))
              
            # 渠道名
            str = ""
            for i in range(self.listWidget.count()):
                item = self.listWidget.item(i)
                if item.checkState() == QtCore.Qt.Checked:
                    str = str + unicode(item.text()) + ","
            
            channel = root.find("channel")
            channel.set("name", str)
            
            # write talkingdata to commonconfig.xml   talkingdata写两份，一份用于界面，一份用于sdk
            talkingdata = root.find("talkingdata")
            if self.checkBox.isChecked():
                talkingdata.set("status", "enable")
            else:
                talkingdata.set("status", "disable")
            talkingdata.set("appId", unicode(self.lineEdit_13.text()))
            
            crash = root.find("crash")
            if self.checkBox_4.isChecked():
                crash.set("status", "enable")
            else:
                crash.set("status", "disable")
            crash.set("appId", unicode(self.lineEdit_16.text()))
            
            # erite media  to commomconfig.xml 
            media = root.find("media")
            if self.checkBox_voice.isChecked():
                media.set("status", "enable")
            else:
                media.set("status", "disable")
            media.set("appKey", unicode(self.voiceAppKey.text()))
            media.set("appSecret", unicode(self.voiceSecrectKey.text()))
            
            push = root.find("push")
            if self.checkBox_5.isChecked():
                push.set("status", "enable")
            else:
                push.set("status", "disable")
            push.set("appId", unicode(self.lineEdit_17.text()))
            push.set("type", unicode(self.comboBox_3.currentText()))
            
            
            advertising = root.find("advertising")
            if self.checkBox_2.isChecked():
                advertising.set("status", "enable")
            else:
                advertising.set("status", "disable")
            advertising.set("appId", unicode(self.advertising_appid.text()))
            
            config.write(file_operate.getCommonXmlPath(), "utf-8")
            
            commonConfig = minidom.parse(file_operate.getCommonXmlPath())
            rootNode = commonConfig.documentElement
            
            talkingdataList = rootNode.getElementsByTagName('talkingdata')
            for talkingdataNode in talkingdataList:
                itemList = talkingdataNode.getElementsByTagName('item')
                for item in itemList:
                    if item.getAttribute('area') == self.comboBox_2.currentText():
                        item.setAttribute('appId', self.lineEdit_13.text())
            
            crashList = rootNode.getElementsByTagName('crash')
            for crashNode in crashList:
                itemList = crashNode.getElementsByTagName('item')
                for item in itemList:
                    if item.getAttribute('type') == self.comboBox.currentText():
                        item.setAttribute('appId', self.lineEdit_16.text())
            
            pushList = rootNode.getElementsByTagName('push')
            for pushNode in pushList:
                itemList = pushNode.getElementsByTagName('item')
                for item in itemList:
                    if item.getAttribute('type') == unicode(self.comboBox_3.currentText()):
                        item.setAttribute('appId', self.lineEdit_17.text())
                        if self.comboBox_3.currentText() == u'个推':
                            item.setAttribute("appKey", unicode(self.pushAppKey.text()))
                            item.setAttribute("appSecret", unicode(self.pushAppSecret.text()))
            
            advertisingList = rootNode.getElementsByTagName('advertising')
            for advertisingNode in advertisingList:
                itemList = advertisingNode.getElementsByTagName('item')
                for item in itemList:
                    if item.getAttribute('area') == unicode(self.comboBox_5.currentText()):
                        item.setAttribute('appId', self.advertising_appid.text())
                        
            
            f = codecs.open(file_operate.getCommonXmlPath(), 'w', 'utf-8')
            commonConfig.writexml(f, encoding='utf-8')
            f.close()
            
        except Exception, e:
            print e
            print "Error: cannot parse file: commonconfig.xml1."
            return -1
    
    
    
    def writeConfigToSdkConfigFile(self):
        try:         
            # write talkingdata to funcellconfig.xml
            config = ET.parse(file_operate.getConfigXmlPath())
            root = config.getroot()
            talkingdata = root.find("talkingdata")
            if self.checkBox.isChecked():
                talkingdata.set("status", "enable")
            else:
                talkingdata.set("status", "disable")
            talkingdata.set("appId", unicode(self.lineEdit_13.text()))
            
            crash = root.find("crash")
            if self.checkBox_4.isChecked():
                crash.set("status", "enable")
            else:
                crash.set("status", "disable")
            crash.set("appId", unicode(self.lineEdit_16.text()))
            
            push = root.find("push")
            if self.checkBox_5.isChecked():
                push.set("status", "enable")
            else:
                push.set("status", "disable")
            push.set("appId", unicode(self.lineEdit_17.text()))
            push.set("appKey", '')
            push.set("appSecret", '')
            if self.comboBox_3.currentText() == u'个推':
                push.set("appKey", unicode(self.pushAppKey.text()))
                push.set("appSecret", unicode(self.pushAppSecret.text()))
            
            config.write(file_operate.getConfigXmlPath(), "utf-8")
   
        except Exception, e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
    
    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(_translate("Dialog", "Dialog", None))
        self.packBtn.setText(_translate("Dialog", "打包", None))
        self.groupBox.setTitle(_translate("Dialog", "签名", None))
        self.label_2.setText(_translate("Dialog", "keystore文件", None))
        self.selectKeystore.setText(_translate("Dialog", "...", None))
        self.label_3.setText(_translate("Dialog", "keystore密码", None))
        self.label_12.setText(_translate("Dialog", "alias", None))
        self.label_13.setText(_translate("Dialog", "alias密码", None))
        self.groupBox_2.setTitle(_translate("Dialog", "Apk", None))
        self.label_4.setText(_translate("Dialog", "apk文件", None))
        self.selectApk.setText(_translate("Dialog", "...", None))
        self.openfile.setText(_translate("Dialog", "文件所在目录", None))
        self.groupBox_5.setTitle(_translate("Dialog", "数据统计平台", None))
        self.checkBox.setText(_translate("Dialog", "Enable", None))
        self.label_14.setText(_translate("Dialog", "appId", None))
        self.comboBox_2.setItemText(0, _translate("Dialog", "国内", None))
        self.comboBox_2.setItemText(1, _translate("Dialog", "台湾", None))
        self.comboBox_2.setItemText(2, _translate("Dialog", "日本", None))
        self.comboBox_2.setItemText(3, _translate("Dialog", "韩国", None))
        self.comboBox_2.setItemText(4, _translate("Dialog", "其他", None))
#         self.comboBox_4.setItemText(0, _translate("Dialog", "talkingdata", None))
#         self.comboBox_4.setItemText(0, _translate("Dialog", "talkingdata_for_google", None))
        self.comboBox_4.setItemText(0, _translate("Dialog", "reyun", None))
        self.groupBox_6.setTitle(_translate("Dialog", "渠道选择", None))
        self.listWidget.setSortingEnabled(True)
        self.pushButton_2.setText(_translate("Dialog", "全选", None))
        self.pushButton_3.setText(_translate("Dialog", "全取消", None))
        self.label.setText(_translate("Dialog", "(双击渠道进行参数配置)", None))
        self.groupBox_8.setTitle(_translate("Dialog", "崩溃统计平台", None))
        self.checkBox_4.setText(_translate("Dialog", "Enable", None))
        self.label_18.setText(_translate("Dialog", "appId", None))
        self.comboBox.setItemText(0, _translate("Dialog", "Bugly", None))
        self.comboBox.setItemText(1, _translate("Dialog", "Testing", None))
        self.groupBox_9.setTitle(_translate("Dialog", "推送平台", None))
        self.checkBox_5.setText(_translate("Dialog", "Enable", None))
        self.label_19.setText(_translate("Dialog", "appId", None))
        self.comboBox_3.setItemText(0, _translate("Dialog", "百度", None))
        self.comboBox_3.setItemText(1, _translate("Dialog", "个推", None))
        self.comboBox_3.setItemText(2, _translate("Dialog", "友盟", None))
        self.comboBox_3.setItemText(3, _translate("Dialog", "信鸽", None))
        self.label_5.setText(_translate("Dialog", "appKey", None))
        self.label_6.setText(_translate("Dialog", "appSecret", None))
        self.groupBox_7.setTitle(_translate("Dialog", "广告统计平台", None))
        self.checkBox_2.setText(_translate("Dialog", "Enable", None))
        self.advertising_label.setText(_translate("Dialog", "appId", None))
        self.comboBox_5.setItemText(0, _translate("Dialog", "国内", None))
        self.comboBox_5.setItemText(1, _translate("Dialog", "台湾", None))
        self.comboBox_5.setItemText(2, _translate("Dialog", "日本", None))
        self.comboBox_5.setItemText(3, _translate("Dialog", "韩国", None))
        self.comboBox_5.setItemText(4, _translate("Dialog", "其他", None))
        self.comboBox_6.setItemText(0, _translate("Dialog", "talkingdata", None))
        self.comboBox_6.setItemText(1, _translate("Dialog", "talkingdata_for_google", None))
        self.comboBox_6.setItemText(2, _translate("Dialog", "reyun", None))
        # 语音模块
        self.groupBox_3.setTitle(_translate("Dialog", "媒体平台", None))
        self.label_7.setText(_translate("Dialog", "appKey", None))
        self.label_8.setText(_translate("Dialog", "secrectKey", None))
        self.checkBox_voice.setText(_translate("Dialog", "Enable", None))
        self.comboBox_voice.setItemText(0, _translate("Dialog", "游密语音", None))
    
    
    def Getargv(self, argv):
        dictTemp = {}
        dictTemp['checkBox_isChecked'] = self.checkBox.isChecked()
        dictTemp['checkBox_4_isChecked'] = self.checkBox_4.isChecked()
        dictTemp['checkBox_5_isChecked'] = self.checkBox_5.isChecked()
        dictTemp['comboBox_currentText'] = self.comboBox.currentText()
        dictTemp['comboBox_3_currentText'] = self.comboBox_3.currentText()
        dictTemp['comboBox_4_currentText'] = self.comboBox_4.currentText()
        dictTemp['lineEdit_13_text'] = self.lineEdit_13.text()
        dictTemp['lineEdit_16_text'] = self.lineEdit_16.text()
        dictTemp['lineEdit_17_text'] = self.lineEdit_17.text()
        dictTemp['pushAppKey_text'] = self.pushAppKey.text()
        dictTemp['pushAppSecret_text'] = self.pushAppSecret.text()
        dictTemp['ApkPath'] = argv
        return dictTemp
    
    def pack(self, argv):
        arrayList = []
        for i in range(2, len(argv)):
            arrayList.append(str(argv[i]))
        sleep(2)
        dictTemp = self.Getargv(str(argv[1]))
        start.start(arrayList, dictTemp)
