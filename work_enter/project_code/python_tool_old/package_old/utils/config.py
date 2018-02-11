import threading
from xml.etree import ElementTree as ET
import re
import os
import file_operate
import sqlite3
import platform
import pdb

class ConfigParse(object):
    """The class can parse project config file of xml """

    def __init__(self):
        """disable the __init__ method"""
        pass
    
    
    __configParse = None
    __lock = threading.Lock()
    __SDKLs = {}
    _channelName = ''
       
    @staticmethod
    def shareInstance():
        ConfigParse.__lock.acquire()
        if not ConfigParse.__configParse:
            ConfigParse.__configParse = object.__new__(ConfigParse)
            object.__init__(ConfigParse.__configParse)
            #ConfigParse.__configParse.projectConfigRead()
        ConfigParse.__lock.release()
        return ConfigParse.__configParse
        
    def projectConfigRead(self):
        """Read funcellconfig.xml file and save to a dictionary"""
        try:
            configfile = file_operate.getCommonXmlPath()
            
            config = ET.parse(configfile)
            root = config.getroot()
            apk = root.find("apk")
            self._apkPath = apk.get("path")
            keystore = root.find("keystore")
            self._keystoreFile = keystore.get("path")
            self._keystorepassword = keystore.get("password")
            self._alias = keystore.get("alias")
            self._aliasPassword = keystore.get("aliaspassword")
            
            configfile = file_operate.getConfigXmlPath()
            config = ET.parse(configfile)
            root = config.getroot()
            app = root.find("app")
            self._packageName = app.get("packageName")
            platform = root.find("platform")
            self._appVersion = platform.get("appVersion")
            self._gameId = platform.get("gameId")
            self._platformId = platform.get("platformId")
            self._platformType = platform.get("platformType")
            channel = root.find("channel")
            self._resVersion = channel.get("resVersion")
        
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
    
    def ConfigRead(self,idchannel):
        """Read funcellconfig.xml file and save to a dictionary"""
        try:
            dictTemp = {}
            
            ConfigParse.__lock.acquire()
            configfile = file_operate.getCommonXmlPath()
            config = ET.parse(configfile)
            root = config.getroot()
            apk = root.find("apk")
            self._apkPath = apk.get("path")
            keystore = root.find("keystore")
            self._keystoreFile = keystore.get("path")
            self._keystorepassword = keystore.get("password")
            self._alias = keystore.get("alias")
            self._aliasPassword = keystore.get("aliaspassword")
            ConfigParse.__lock.release()
            
            configfile = file_operate.getchannelFuncellConfigXmlPath(idchannel)
            config = ET.parse(configfile)
            root = config.getroot()
            app = root.find("app")
            dictTemp['packageName'] = app.get("packageName")
            platform = root.find("platform")
            dictTemp['appVersion'] = platform.get("appVersion")
            dictTemp['gameId'] = platform.get("gameId")
            dictTemp['platformId'] = platform.get("platformId")
            dictTemp['platformType'] = platform.get("platformType")
            channel = root.find("channel")
            dictTemp['resVersion'] = channel.get("resVersion")
            
            return dictTemp
        except Exception,e:
            print e
            print "Error: cannot parse file: funcellconfig.xml."
            return -1
    
    def getApkPath(self):
        return self._apkPath
    
    def setChannelName(self, channelName):
        self._channelName = channelName
    
    def getChannelName(self):
        return self._channelName
    
    def getKeystoreFile(self):
        return self._keystoreFile
    
    def getPackageName(self):
        return self._packageName
    
    def getKeystorePassword(self):
        return self._keystorepassword
    
    def getKeystoreAlias(self):
        return self._alias
    
    def getKeystoreAliasPassword(self):
        return self._aliasPassword
    
    def getAppVersion(self):
        return self._appVersion
    
    def getGameId(self):
        return self._gameId
    
    def getPlatformId(self):
        return self._platformId
    
    def getplatformType(self):
        return self._platformType
    
    def getResVersion(self):
        return self._resVersion
    
    def initDatabase(self):
        """get the data from database."""
        dbPath = os.path.join(file_operate.getCurDir(), '/config/config.db')
        cx = sqlite3.connect(dbPath)
        cx.row_factory = sqlite3.Row
        self.readSDKLs(cx)
        cx.close()
    
    def readSDKLs(self, cx):
        """get the data about tpl_sdk from database"""
        self.__SDKLs.clear()
        c = cx.cursor()
        c.execute('select * from sdk')
        rows = c.fetchall()
        for r in rows:
            dictTemp = {}
            dictTemp['idSDK'] = r['idSDK']
            dictTemp['SDKName'] = r['SDKName']
            dictTemp['SDKShowName'] = r['SDKShowName']
            dictTemp['bHasIcon'] = r['bHasIcon']
            dictTemp['sdk_developer_url'] = r['sdk_developer_url']
            self.__SDKLs[dictTemp['idSDK']] = dictTemp

        c.close()
    