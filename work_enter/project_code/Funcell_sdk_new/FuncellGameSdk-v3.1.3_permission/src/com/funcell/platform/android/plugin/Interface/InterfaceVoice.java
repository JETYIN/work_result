package com.funcell.platform.android.plugin.Interface;

import android.app.Activity;

import com.funcell.platform.android.plugin.callback.IFuncellYoumImMessageCallBack;
import com.funcell.platform.android.plugin.callback.IFuncellYoumImRoomCallBack;
import com.funcell.platform.android.plugin.callback.IFuncellYoumVoiceCallBack;
import com.funcell.platform.android.plugin.crash.FuncellCrashChannelType;
import com.funcell.platform.android.plugin.youmvoice.FuncellYoumVoiceChannelType;

public interface InterfaceVoice {
	public static final int PluginType = 1;

	/** ���뷿�� **/
	public void fCVoiceJoinTalkRoom(int type, String roomID, String userID,
			boolean needUserList, boolean needMic, boolean needSpeake,
			boolean autoSendStatus);

	/** ���뷿�����ط��� **/
	public void fCVoiceJoinTalkRoom(int type, String roomID, String uerID);

	/** �뿪���� **/
	public void fCVoiceLeaveTalkRoom();

	/** ��˷翪�� **/
	public void fCVoiceSetMicrophone(boolean flag);

	/** ���������� **/
	public void fCVoiceSetSpeaker(boolean flag);

	/** ��ͣͨ�� **/
	public void fCVoiceSetPauseVoice();

	/** �ָ�ͨ�� **/
	public void fCVoiceResumeVoice();

	/** ����ֱ������ **/
	public void fCVoiceSetLiveVol(int vol);

	/** ���ű������� **/
	public void fCVoicePlayBgMusic(String path, boolean repat, int mode);

	/** ���ñ����������� **/
	public void fCVoiceSetBackMusicVol(int vol);

	/** �رձ������� **/
	public void fCVoiceStopBgMusic();

	/** ������˷�������·����������� **/
	public void fCVoiceSetMicBypassToSpeaker(boolean flag);

	/** �����û��Ƿ�ʹ���ƶ��� **/
	public void fCVoiceSetUserNet(boolean flag);

	/** ����ֱ�������ӳ� **/
	public void fCVoiceSetVolDelay(int delay);

	/** ����������ͨ�� **/
	public void fCVoiceSetOtherShield(String userID, boolean flag);

	/** ����������˷� **/
	public void fCVoiceSetOtherMicrophone(String userID, boolean flag);

	/** �������������� **/
	public void fCVoiceSetOtherSpeaker(String userID, boolean flag);

	/** �°��˳� **/
	public void fCVoiceExit();

	public void registerfCVoiceListener(IFuncellYoumVoiceCallBack voiceCallBack);

	/** ------------------- **/
	/** ��ǰ�汾 **/
	public String getSDKVersion();

	/** ����汾 **/
	public String getPluginVersion();

	/** channel **/
	public String getVoiceChannel();

	/** ������չ **/

	public abstract Object callFunction(Activity ctx,
			FuncellYoumVoiceChannelType type, String FunctionName,
			Object... params);

	/** -----------------IM���� **/

	/** ��¼IM���� **/
	public void fcIMLogin();

	/** ע�� **/
	public void fcIMLogout();

	public void fcIMLogin(String userId, String passWord);

	/** ���뷿�� **/
	public void fcIMJoinRoom(String roomId);

	/** �뿪���� **/

	public void fcIMLeaveRoom(String roomId);

	/** �����ı���Ϣ revId������id��type Ⱥ���죬�������� **/
	public void fcIMSendTxtMessage(String revId, int type, String content);

	/** ��ʼ¼�� **/
	public void fcIMStartRecord(String revId, int type);

	/** ȡ��¼�� **/
	public void fcIMCancelRecord();

	/** ֹͣ¼�������� **/
	public void fcIMStopRecordSend();

	/** �����Լ����͵����� **/
	public void fcIMPlayAudioVoice(String path);

	/** �������� **/
	public void fcIMDoloadVoice(long recMesId, String path);
	/**��Ϸ��ͣ**/
	public void fcIMGamePause();
	
	/**��Ϸ����**/
	public void fcIMGameResume();
	

	public void registerfCImMessageListener(IFuncellYoumImMessageCallBack call);

	public void registerfCImRoomListener(IFuncellYoumImRoomCallBack call);

}
