import thread
import time
from packThreadManagerModule import packThreadManager
from taskManagerModule import taskManager
from config import ConfigParse
import os
import sys
import file_operate
from PyQt4.QtCore import *  
from PyQt4.Qt import QDesktopServices
import constant

def checkTaskThread(arrayList = None,dictTemp = None):
    while 1:
        time.sleep(5)
        result = packThreadManager.shareInstance().isRunning()
        if result == 0:
            break
        packThreadManager.shareInstance().startTask(0,arrayList,dictTemp)

    taskManager.shareInstance().missionComplete()
    openfilefolder()
    file_operate.printf('Mission Complete!')
    print "\n---------------------------------all pack complete!---------------------------------"
    thread.exit_thread()


def checkTaskThreadForIos():
    while 1:
        time.sleep(5)
        result = packThreadManager.shareInstance().isRunning()
        if result == 0:
            break
        packThreadManager.shareInstance().startTask(1)

    taskManager.shareInstance().missionComplete()
    file_operate.printf('Mission Complete!')
    thread.exit_thread()


def start(arrayList,dictTemp):
    reload(sys)
    sys.setdefaultencoding('utf8')
    taskManager.shareInstance().clearRecord()
    packThreadManager.shareInstance().clearRecord()
    packThreadManager.shareInstance().setCurWorkDir(os.getcwd())
    packThreadManager.shareInstance().startTask(0,arrayList,dictTemp)
    thread.start_new_thread(checkTaskThread, (arrayList,dictTemp))


def startIos():
    reload(sys)
    sys.setdefaultencoding('utf8')
    ConfigParse.shareInstance().readUserConfig(1)
    taskManager.shareInstance().clearRecord()
    packThreadManager.shareInstance().clearRecord()
    packThreadManager.shareInstance().setCurWorkDir(os.getcwd())
    source = ConfigParse.shareInstance().getSource()
    game = ConfigParse.shareInstance().getCurrentGame()
    versionName = ConfigParse.shareInstance().getVersionName()
    packThreadManager.shareInstance().startTask(1)
    thread.start_new_thread(checkTaskThreadForIos, ())


def getCompletionDict():
    return taskManager.shareInstance().getCompletionDict()


def stopAllTask():
    """Stop all of the tasks"""
    taskManager.shareInstance().clearRecord()
    packThreadManager.shareInstance().stopAllTask()

def openfilefolder():
        QDesktopServices.openUrl(QUrl(file_operate.getFullPath(constant.outDir), QUrl.TolerantMode))

