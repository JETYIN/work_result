# -*- coding: utf-8 -*-
import threading

class taskManager(object):
    """
    1.\xe7\xba\xbf\xe7\xa8\x8b\xe7\xae\xa1\xe7\x90\x86 线程管理
    2.\xe7\xba\xbf\xe7\xa8\x8b\xe4\xbb\xbb\xe5\x8a\xa1\xe5\xae\x89\xe6\x8e\x92 线程任务安排
    3.\xe4\xbb\xbb\xe5\x8a\xa1\xe8\xbf\x9b\xe5\xba\xa6\xe5\x8f\x8d\xe9\xa6\x88\xe6\x9f\xa5\xe8\xaf\xa2 任务进度反馈查询
    """
    __instance = None
    __Lock = threading.Lock()
    __TaskLock = threading.Lock()
    __taskCompletion = {}
    __taskLog = []

    def __init__(self):
        pass

    @staticmethod
    def shareInstance():
        taskManager.__Lock.acquire()
        if taskManager.__instance == None:
            taskManager.__instance = object.__new__(taskManager)
            object.__init__(taskManager.__instance)
        taskManager.__Lock.release()
        return taskManager.__instance

    def notify(self, platformname, percent):
        self.__taskCompletion[platformname] = percent

    def log(self, platformname, log):
        self.__taskLog[platformname].append(log)

    def getCompletionDict(self):
        return self.__taskCompletion

    def getLog(self, platformname):
        return self.__taskLog[platformname]

    def clearRecord(self):
        self.__taskCompletion.clear()

    def missionComplete(self):
        keys = self.__taskCompletion.keys()
        for key in keys:
            self.__taskCompletion[key] = -1

    def getLock(self):
        return self.__TaskLock
