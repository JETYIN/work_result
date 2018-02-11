#Embedded file name: initialize.py
import xml.dom.minidom
import re, os, sys
versionInfoUrlTw = 'http://ft.download.8888play.com/ft/Config/%s/RemoteVersion.xml'
versionInfoUrl = 'http://fantasychronicles.download.553.com/android/%s/RemoteVersion.xml'
versionInfoUrlJaPan = 'http://japan-hxbns-download-cdn.funcell123.com/Config/Android/RemoteVersion.xml'
versionInfoUrlKorea = 'http://korea-hxbns-download.funcell123.com/Config/%s/RemoteVersion.xml'
versionInfoUrlvstargame_xinma_en = 'http://cdn.hxbns.sagatw.com/Config/Android/RemoteVersion.xml'
versionInfoUrlvstargame_zhengbao = 'http://cdn.hxbns.sagatw.com/Config/Android/Android99/RemoteVersion.xml'
versionInfoUrlvstargame_taiguo = 'http://cdn.hxbns.siamgirl.in.th/Config/Android/RemoteVersion.xml'
versionInfoUrlfuncell_en = 'http://hxbns-abroad-download.raink.com.cn/Config/Android/RemoteVersion.xml'
versionInfoUrlvstargame_yuenan = 'http://cdn.hxbnsvn.sagatw.com/Config/Android/RemoteVersion.xml'
versionInfoUrlefun_ru_google = 'http://hxbnsru.download.vsplay.com/hxbns/Config/Android/Google/RemoteVersion.xml'
serverListURL = 'http://serverlist.funcell123.com/serverlist'
serverListURLJapan = 'http://japan.hxbns.serverlist.funcell123.com'
serverListURLKorea = 'http://korea.hxbns.serverlist.funcell123.com'
serverListURLvstargame = 'http://xmt.hxbns.serverlist.funcell123.com'
versionInfoUrlCGamex='http://fantasychronicles.download.553.com/Sifu/Andriod/Cyou/RemoteVersion.xml'
versionInfoUrlMoxian='http://fantasychronicles.download.553.com/Sifu/Andriod/moxian/RemoteVersion.xml'
versionInfoUrlUc = "http://fantasychronicles.download.553.com/Sifu/Andriod/uc_713/RemoteVersion.xml"

platformRPath = '../../finalsdk/'
configTemplatePath = 'LocalVersionTemplate.xml'
local_base_res_version = '1'
developer = 'False'
hasCopy = 'False'
enableDownload = 'True'
platforms = {'553': {'fgi': '18022',
         'platformid': '553'},
 'uc': {'fgi': '18060',
        'platformid': 'uc'},
 '360': {'fgi': '18071',
         'platformid': '360'},
 'xiaomi': {'fgi': '18072',
            'platformid': 'xiaomi'}}

def initialize(platfromId, channelName, platformType, appVersion, resVersion):
    folder = platformRPath + channelName + '/extra'
    xmlPath = folder + '/LocalVersion.xml'
    print xmlPath
    loadXmlTemplate()
    setXml(xmlPath, folder, platfromId, channelName, platformType, appVersion, resVersion)


def loadXmlTemplate():
    global enableDownload
    global developer
    global local_base_res_version
    dom = xml.dom.minidom.parse(configTemplatePath)
    root = dom.documentElement
    local_base_res_versionNode = root.getElementsByTagName('local_base_res_version')
    local_base_res_version = local_base_res_versionNode[0].firstChild.data
    developerNode = root.getElementsByTagName('developer')
    developer = developerNode[0].firstChild.data
    enableDownloadNode = root.getElementsByTagName('enableDownload')
    enableDownload = enableDownloadNode[0].firstChild.data
    print local_base_res_version
    print developer
    print enableDownload


def setXml(xmlPath, folderPath, fgi, channelName, platform_fid, appVersion, resVersion):
    xmldoc = xml.dom.minidom.getDOMImplementation()
    dom = xmldoc.createDocument(None, 'local_info', None)
    root = dom.documentElement
    if local_base_res_version == '99' and (platform_fid == 'muzhiwan' or platform_fid == 'muzhiwan2' or platform_fid == 'muzhiwan_yyh'):
        platform_fid = platform_fid + '_hd'
    if 'efun_google_tw' == platform_fid or 'efun_asus_tw' == platform_fid:
        remoteUrl = versionInfoUrlTw % platform_fid
    elif 'funcell_japan' == channelName:
        remoteUrl = versionInfoUrlJaPan
    elif 'nextmv_naver' == channelName:
        remoteUrl = 'http://korea-hxbns-download.funcell123.com/Config/Nextmv/RemoteVersion.xml'
    elif 'nextmv_google' == channelName or 'nextmv_tstore' == channelName:
        remoteUrl = versionInfoUrlKorea % platform_fid
    elif 'vstargame_xinma_en' == channelName:
        remoteUrl = versionInfoUrlvstargame_xinma_en
    elif 'vstargame_zhengbao' == channelName:
        remoteUrl = versionInfoUrlvstargame_zhengbao
    elif 'vstargame_taiguo' == channelName:
        remoteUrl = versionInfoUrlvstargame_taiguo
    elif 'vstargame_yuenan' == channelName:
        remoteUrl = versionInfoUrlvstargame_yuenan
    elif 'funcell_en' == channelName:
        remoteUrl = versionInfoUrlfuncell_en
    elif 'efun_ru_google' == channelName:
        remoteUrl = versionInfoUrlefun_ru_google
    elif 'Raink_CGamex'==channelName:
        remoteUrl=versionInfoUrlCGamex
    elif 'moxian'==channelName:
    	remoteUrl=versionInfoUrlMoxian
    elif 'uc_713'==channelName:
    	remoteUrl=versionInfoUrlUc
    else:
        remoteUrl = versionInfoUrl % (platform_fid+'1')
    if 'funcell_japan' == channelName:
        createElement(dom, root, 'serverListURL', serverListURLJapan)
    elif 'nextmv_naver' == channelName or 'nextmv_google' == channelName or 'nextmv_tstore' == channelName:
        createElement(dom, root, 'serverListURL', serverListURLKorea)
    elif 'vstargame' == channelName:
        createElement(dom, root, 'serverListURL', serverListURLvstargame)
    else:
        createElement(dom, root, 'serverListURL', serverListURL)
    createElement(dom, root, 'VersionInfoURL', remoteUrl)
    createElement(dom, root, 'local_patch_res_version', resVersion)
    createElement(dom, root, 'local_app_version', appVersion)
    createElement(dom, root, 'platform_fid', platform_fid)
    print local_base_res_version
    createElement(dom, root, 'local_base_res_version', local_base_res_version)
    createElement(dom, root, 'fgi', fgi)
    print developer
    createElement(dom, root, 'developer', developer)
    createElement(dom, root, 'hasCopy', hasCopy)
    print enableDownload
    createElement(dom, root, 'enableDownload', enableDownload)
    print folderPath
    folderExist = os.path.exists(folderPath)
    if folderExist == False:
        os.makedirs(folderPath)
    f = open(xmlPath, 'w')
    dom.writexml(f, addindent=' ', newl='\n', encoding='utf-8')
    f.close()


def createElement(dom, root, nodename, nodetext):
    childNode = dom.createElement(nodename)
    childText = dom.createTextNode(nodetext)
    childNode.appendChild(childText)
    root.appendChild(childNode)
