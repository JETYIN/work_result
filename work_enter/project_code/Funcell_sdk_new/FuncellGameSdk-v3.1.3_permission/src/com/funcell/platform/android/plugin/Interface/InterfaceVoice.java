package com.funcell.platform.android.plugin.Interface;

import android.app.Activity;

import com.funcell.platform.android.plugin.callback.IFuncellYoumImMessageCallBack;
import com.funcell.platform.android.plugin.callback.IFuncellYoumImRoomCallBack;
import com.funcell.platform.android.plugin.callback.IFuncellYoumVoiceCallBack;
import com.funcell.platform.android.plugin.crash.FuncellCrashChannelType;
import com.funcell.platform.android.plugin.youmvoice.FuncellYoumVoiceChannelType;

public interface InterfaceVoice {
	public static final int PluginType = 1;

	/** 加入房间 **/
	public void fCVoiceJoinTalkRoom(int type, String roomID, String userID,
			boolean needUserList, boolean needMic, boolean needSpeake,
			boolean autoSendStatus);

	/** 加入房间重载方法 **/
	public void fCVoiceJoinTalkRoom(int type, String roomID, String uerID);

	/** 离开房间 **/
	public void fCVoiceLeaveTalkRoom();

	/** 麦克风开关 **/
	public void fCVoiceSetMicrophone(boolean flag);

	/** 扬声器开关 **/
	public void fCVoiceSetSpeaker(boolean flag);

	/** 暂停通话 **/
	public void fCVoiceSetPauseVoice();

	/** 恢复通话 **/
	public void fCVoiceResumeVoice();

	/** 设置直播音量 **/
	public void fCVoiceSetLiveVol(int vol);

	/** 播放背景音乐 **/
	public void fCVoicePlayBgMusic(String path, boolean repat, int mode);

	/** 设置背景音乐音量 **/
	public void fCVoiceSetBackMusicVol(int vol);

	/** 关闭背景音乐 **/
	public void fCVoiceStopBgMusic();

	/** 设置麦克风声音旁路到扬声器输出 **/
	public void fCVoiceSetMicBypassToSpeaker(boolean flag);

	/** 设置用户是否使用移动网 **/
	public void fCVoiceSetUserNet(boolean flag);

	/** 设置直播声音延迟 **/
	public void fCVoiceSetVolDelay(int delay);

	/** 屏蔽其他人通话 **/
	public void fCVoiceSetOtherShield(String userID, boolean flag);

	/** 控制他人麦克风 **/
	public void fCVoiceSetOtherMicrophone(String userID, boolean flag);

	/** 控制他人扬声器 **/
	public void fCVoiceSetOtherSpeaker(String userID, boolean flag);

	/** 新版退出 **/
	public void fCVoiceExit();

	public void registerfCVoiceListener(IFuncellYoumVoiceCallBack voiceCallBack);

	/** ------------------- **/
	/** 当前版本 **/
	public String getSDKVersion();

	/** 插件版本 **/
	public String getPluginVersion();

	/** channel **/
	public String getVoiceChannel();

	/** 用于扩展 **/

	public abstract Object callFunction(Activity ctx,
			FuncellYoumVoiceChannelType type, String FunctionName,
			Object... params);

	/** -----------------IM部分 **/

	/** 登录IM房间 **/
	public void fcIMLogin();

	/** 注销 **/
	public void fcIMLogout();

	public void fcIMLogin(String userId, String passWord);

	/** 加入房间 **/
	public void fcIMJoinRoom(String roomId);

	/** 离开房间 **/

	public void fcIMLeaveRoom(String roomId);

	/** 发送文本信息 revId接受者id，type 群聊天，单人聊天 **/
	public void fcIMSendTxtMessage(String revId, int type, String content);

	/** 开始录音 **/
	public void fcIMStartRecord(String revId, int type);

	/** 取消录音 **/
	public void fcIMCancelRecord();

	/** 停止录音并发送 **/
	public void fcIMStopRecordSend();

	/** 播放自己发送的语音 **/
	public void fcIMPlayAudioVoice(String path);

	/** 下载语音 **/
	public void fcIMDoloadVoice(long recMesId, String path);
	/**游戏暂停**/
	public void fcIMGamePause();
	
	/**游戏重连**/
	public void fcIMGameResume();
	

	public void registerfCImMessageListener(IFuncellYoumImMessageCallBack call);

	public void registerfCImRoomListener(IFuncellYoumImRoomCallBack call);

}
