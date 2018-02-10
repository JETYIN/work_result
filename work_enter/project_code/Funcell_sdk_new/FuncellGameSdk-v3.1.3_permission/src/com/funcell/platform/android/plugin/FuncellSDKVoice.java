package com.funcell.platform.android.plugin;

import android.app.Activity;
import android.util.Log;

import com.funcell.platform.android.game.proxy.FuncellStatActivityStub;
import com.funcell.platform.android.plugin.Interface.InterfaceVoice;
import com.funcell.platform.android.plugin.callback.IFuncellYoumImMessageCallBack;
import com.funcell.platform.android.plugin.callback.IFuncellYoumImRoomCallBack;
import com.funcell.platform.android.plugin.callback.IFuncellYoumVoiceCallBack;
import com.funcell.platform.android.plugin.wrapper.VoiceWrapper;
import com.funcell.platform.android.plugin.youmvoice.FuncellYoumVoiceChannelType;

public class FuncellSDKVoice extends FuncellStatActivityStub implements
		InterfaceVoice {

	private String TAG = getClass().getSimpleName();
	private static FuncellSDKVoice instance;

	public static FuncellSDKVoice getInstance() {
		if (null == instance) {
			synchronized (FuncellSDKVoice.class) {
				instance = new FuncellSDKVoice();

			}
		}
		return instance;
	}

	public void initSdk(Activity context) {
		Log.e(TAG, "******游密语音实例化中initSdk");

	}

	@Override
	public Object callFunction(Activity ctx, FuncellYoumVoiceChannelType type,
			String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		return VoiceWrapper.getInstance().callFunction(ctx, type, FunctionName,params);
	}
	
	/**
	 * extend callFunction
	 * @param ctx
	 * @param VoiceChannelType
	 * @param FunctionName
	 * @param params
	 * @return
	 */
	public Object callFunction(Activity ctx, String VoiceChannelType,String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		return VoiceWrapper.getInstance().callFunction(ctx, VoiceChannelType, FunctionName,params);
	}
	
	@Override
	public Object callFunction(Activity ctx, String FunctionName,
			Object... params) {
		// TODO Auto-generated method stub
		return VoiceWrapper.getInstance().callFunction(ctx, FunctionName,
				params);
	}

	@Override
	public void fCVoiceJoinTalkRoom(int type, String roomID, String userID,
			boolean needUserList, boolean needMic, boolean needSpeake,
			boolean autoSendStatus) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceJoinTalkRoom(type, roomID, userID,needUserList, needMic, needSpeake, autoSendStatus);
	}

	@Override
	public void fCVoiceJoinTalkRoom(int type, String roomID, String uerID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fCVoiceLeaveTalkRoom() {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceLeaveTalkRoom();
	}

	@Override
	public void fCVoiceSetMicrophone(boolean flag) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceSetMicrophone(flag);
	}

	@Override
	public void fCVoiceSetSpeaker(boolean flag) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceSetSpeaker(flag);
	}

	@Override
	public void fCVoiceSetPauseVoice() {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceSetPauseVoice();
	}

	@Override
	public void fCVoiceResumeVoice() {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceResumeVoice();
	}

	@Override
	public void fCVoiceSetLiveVol(int vol) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceSetLiveVol(vol);
	}

	@Override
	public void fCVoicePlayBgMusic(String path, boolean repat, int mode) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoicePlayBgMusic(path, repat, mode);
	}

	@Override
	public void fCVoiceSetBackMusicVol(int vol) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceSetBackMusicVol(vol);
	}

	@Override
	public void fCVoiceStopBgMusic() {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceStopBgMusic();
	}

	@Override
	public void fCVoiceSetMicBypassToSpeaker(boolean flag) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceSetMicBypassToSpeaker(flag);
	}

	@Override
	public void fCVoiceSetUserNet(boolean flag) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceSetUserNet(flag);
	}

	@Override
	public void fCVoiceSetVolDelay(int delay) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceSetVolDelay(delay);
	}

	@Override
	public void fCVoiceSetOtherShield(String userID, boolean flag) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceSetOtherShield(userID, flag);
	}

	@Override
	public void fCVoiceSetOtherMicrophone(String userID, boolean flag) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceSetOtherMicrophone(userID, flag);
	}

	@Override
	public void fCVoiceSetOtherSpeaker(String userID, boolean flag) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceSetOtherSpeaker(userID, flag);
	}

	@Override
	public void fCVoiceExit() {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fCVoiceExit();
	}

	@Override
	public String getSDKVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPluginVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getVoiceChannel() {
		// TODO Auto-generated method stub
		return null;
	}

	/** -------------------IM--------------------- **/
	@Override
	public void fcIMLogin() {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fcIMLogin();
	}

	@Override
	public void fcIMJoinRoom(String roomId) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fcIMJoinRoom(roomId);
	}

	@Override
	public void fcIMLeaveRoom(String roomId) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fcIMLeaveRoom(roomId);
	}

	@Override
	public void fcIMSendTxtMessage(String revId, int type, String content) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fcIMSendTxtMessage(revId, type, content);
	}

	@Override
	public void fcIMStartRecord(String revId, int type) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fcIMStartRecord(revId, type);
	}

	@Override
	public void fcIMCancelRecord() {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fcIMCancelRecord();
	}

	@Override
	public void fcIMStopRecordSend() {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fcIMStopRecordSend();
	}

	@Override
	public void fcIMPlayAudioVoice(String path) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fcIMPlayAudioVoice(path);
	}

	@Override
	public void fcIMDoloadVoice(long recMesId, String path) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fcIMDoloadVoice(recMesId, path);
	}

	@Override
	public void registerfCVoiceListener(IFuncellYoumVoiceCallBack voiceCallBack) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().registerfCVoiceListener(voiceCallBack);
	}

	@Override
	public void registerfCImMessageListener(IFuncellYoumImMessageCallBack call) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().registerfCImMessageListener(call);
	}

	@Override
	public void registerfCImRoomListener(IFuncellYoumImRoomCallBack call) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().registerfCImRoomListener(call);
	}

	@Override
	public void fcIMLogin(String userId, String passWord) {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fcIMLogin(userId, passWord);
	}

	@Override
	public void fcIMLogout() {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fcIMLogout();
	}

	@Override
	public void fcIMGamePause() {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fcIMGamePause();
	}

	@Override
	public void fcIMGameResume() {
		// TODO Auto-generated method stub
		VoiceWrapper.getInstance().fcIMGameResume();
	}


}
