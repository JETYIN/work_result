package com.funcell.platform.android.plugin.wrapper;

import java.lang.reflect.Method;
import java.util.Vector;

import android.app.Activity;
import android.util.Log;

import com.funcell.platform.android.game.proxy.FuncellStatActivityStub;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.plugin.FuncellPluginHelper;
import com.funcell.platform.android.plugin.FuncellPluginType;
import com.funcell.platform.android.plugin.Interface.InterfaceVoice;
import com.funcell.platform.android.plugin.callback.IFuncellYoumImMessageCallBack;
import com.funcell.platform.android.plugin.callback.IFuncellYoumImRoomCallBack;
import com.funcell.platform.android.plugin.callback.IFuncellYoumVoiceCallBack;
import com.funcell.platform.android.plugin.crash.FuncellCrashChannelType;
import com.funcell.platform.android.plugin.youmvoice.FuncellYoumVoiceChannelType;

public class VoiceWrapper extends FuncellStatActivityStub implements
		InterfaceVoice {

	public static VoiceWrapper instance;
	private String TAG = getClass().getSimpleName();

	public static VoiceWrapper getInstance() {
		if (null == instance) {
			synchronized (VoiceWrapper.class) {
				if (null == instance) {
					instance = new VoiceWrapper();
				}

			}
		}
		return instance;

	}

	public void initSDK(Activity context) {
		Log.e(TAG, "******游密语音实例化中initSdk");

	}

	/**
	 * 获取实例 
	 * 
	 * @param className
	 * @return
	 */
	private Object getPluginInstance(String className) {
		Class localClass = null;
		try {
			localClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		try {
			Method getInstance_Method = localClass.getMethod("getInstance");
			Object Instance = getInstance_Method.invoke(null);
			return Instance;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object callFunction(Activity ctx, FuncellYoumVoiceChannelType type,String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getVoiceChannel_callMethod = localClass.getMethod("getVoiceChannel");
					String voiceChannel = (String) getVoiceChannel_callMethod.invoke(instance);
					if (type.toString().equalsIgnoreCase(voiceChannel)) {
						Method callMethod = localClass.getMethod("callFunction", new Class[] { Activity.class,FuncellCrashChannelType.class,String.class, Object[].class });
						return callMethod.invoke(instance, ctx, type,FunctionName, params);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param ctx
	 * @param type
	 * @param FunctionName
	 * @param params
	 * @return
	 */
	public Object callFunction(Activity ctx, String type,String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		String _ret = null;
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getVoiceChannel_callMethod = localClass.getMethod("getVoiceChannel");
					String voiceChannel = (String) getVoiceChannel_callMethod.invoke(instance);
					if (type.equalsIgnoreCase(voiceChannel)) {
						Method callMethod = localClass.getMethod("callFunction", new Class[] { Activity.class,String.class,String.class, Object[].class });
						return callMethod.invoke(instance, ctx, type,FunctionName, params);
					}
				}catch(NoSuchMethodException noSuchMethodException){
					_ret = "This callFunction({ Activity.class,String.class, String.class,Object[].class }) is not found in an instance,please check the "+type +" plugin version!";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return _ret;
	}


	@Override
	public Object callFunction(Activity ctx, String FunctionName,Object... params) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.CrashPlugins);
		ParamsContainer paramsContainer = new ParamsContainer();
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getVoiceChannel_callMethod = localClass.getMethod("getVoiceChannel");
					String voiceChannel = (String) getVoiceChannel_callMethod.invoke(instance);
					Method callMethod = localClass.getMethod("callFunction",new Class[] { Activity.class, String.class,Object[].class });
					Object result = callMethod.invoke(instance, ctx,FunctionName, params);
					Log.e(TAG, "callFunction result:" + result);
					paramsContainer.put(voiceChannel, result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return paramsContainer;
	}

	/** 进入房间 **/
	@Override
	public void fCVoiceJoinTalkRoom(int type, String roomID, String userID,
			boolean needUserList, boolean needMic, boolean needSpeake,
			boolean autoSendStatus) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper
				.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod(
							"fCVoiceJoinTalkRoom",
							new Class[] { int.class, String.class,
									String.class, boolean.class, boolean.class,
									boolean.class, boolean.class });
					callMethod.invoke(instance, type, roomID, userID,
							needUserList, needMic, needSpeake, autoSendStatus);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void fCVoiceJoinTalkRoom(int type, String roomID, String userID) {
		// TODO Auto-generated method stub

	}

	/** 退出房间 **/
	@Override
	public void fCVoiceLeaveTalkRoom() {
		// TODO Auto-generated method stub

		invokeFCVoice("fCVoiceLeaveTalkRoom");
	}

	/** 是否打开关闭硬件 **/
	private void setFCVoiceSetHandWSwitch(String methodName, boolean flag) {

		Vector<String> plugins = FuncellPluginHelper
				.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod(methodName,
							new Class[] { boolean.class });
					callMethod.invoke(instance, flag);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/** 调节硬件 **/
	private void switchFCVoiceVol(String methodName, int vol) {
		Vector<String> plugins = FuncellPluginHelper
				.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod(methodName,
							new Class[] { int.class });
					callMethod.invoke(instance, vol);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/** 直接调用 **/
	private void invokeFCVoice(String methodName) {

		Vector<String> plugins = FuncellPluginHelper
				.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod(methodName);
					callMethod.invoke(instance);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/** 控制他人权限 **/

	private void controlFCVoicePermisson(String methodName, String userID,
			boolean flag) {
		Vector<String> plugins = FuncellPluginHelper
				.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod(methodName,
							new Class[] { String.class, boolean.class });
					callMethod.invoke(instance, userID, flag);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void fCVoiceSetMicrophone(boolean flag) {
		// TODO Auto-generated method stub
		setFCVoiceSetHandWSwitch("fCVoiceSetMicrophone", flag);
	}

	@Override
	public void fCVoiceSetSpeaker(boolean flag) {
		// TODO Auto-generated method stub
		setFCVoiceSetHandWSwitch("fCVoiceSetSpeaker", flag);

	}

	@Override
	public void fCVoiceSetPauseVoice() {
		// TODO Auto-generated method stub
		invokeFCVoice("fCVoiceSetPauseVoice");
	}

	@Override
	public void fCVoiceResumeVoice() {
		// TODO Auto-generated method stub
		invokeFCVoice("fCVoiceResumeVoice");
	}

	@Override
	public void fCVoiceSetLiveVol(int vol) {
		// TODO Auto-generated method stub
		switchFCVoiceVol("fCVoiceSetLiveVol", vol);
	}

	@Override
	public void fCVoicePlayBgMusic(String path, boolean repat, int mode) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper
				.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod(
							"fCVoicePlayBgMusic", new Class[] { String.class,
									boolean.class, int.class });
					callMethod.invoke(instance, path, repat, mode);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void fCVoiceSetBackMusicVol(int vol) {
		// TODO Auto-generated method stub
		switchFCVoiceVol("fCVoiceSetBackMusicVol", vol);
	}

	@Override
	public void fCVoiceStopBgMusic() {
		// TODO Auto-generated method stub
		invokeFCVoice("fCVoiceStopBgMusic");
	}

	@Override
	public void fCVoiceSetMicBypassToSpeaker(boolean flag) {
		// TODO Auto-generated method stub
		setFCVoiceSetHandWSwitch("fCVoiceSetMicBypassToSpeaker", flag);
	}

	@Override
	public void fCVoiceSetUserNet(boolean flag) {
		// TODO Auto-generated method stub
		setFCVoiceSetHandWSwitch("fCVoiceSetUserNet", flag);
	}

	@Override
	public void fCVoiceSetVolDelay(int delay) {
		// TODO Auto-generated method stub
		switchFCVoiceVol("fCVoiceSetVolDelay", delay);
	}

	@Override
	public void fCVoiceSetOtherShield(String userID, boolean flag) {
		// TODO Auto-generated method stub
		controlFCVoicePermisson("fCVoiceSetOtherShield", userID, flag);
	}

	@Override
	public void fCVoiceSetOtherMicrophone(String userID, boolean flag) {
		// TODO Auto-generated method stub
		controlFCVoicePermisson("fCVoiceSetOtherMicrophone", userID, flag);
	}

	@Override
	public void fCVoiceSetOtherSpeaker(String userID, boolean flag) {
		// TODO Auto-generated method stub
		controlFCVoicePermisson("fCVoiceSetOtherSpeaker", userID, flag);
	}

	@Override
	public void fCVoiceExit() {
		// TODO Auto-generated method stub
		invokeFCVoice("fCVoiceExit");
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

	/** ------------------------IM----------------------- **/

	/** String **/
	private void setFCIMRoomType(String methodName, String roomeId) {

		Vector<String> plugins = FuncellPluginHelper
				.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod(methodName,
							new Class[] { String.class });
					callMethod.invoke(instance, roomeId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void fcIMLogin() {
		// TODO Auto-generated method stub
		invokeFCVoice("fcIMLogin");

	}

	@Override
	public void fcIMJoinRoom(String roomId) {
		// TODO Auto-generated method stub
		setFCIMRoomType("fcIMJoinRoom", roomId);
	}

	@Override
	public void fcIMLeaveRoom(String roomId) {
		// TODO Auto-generated method stub
		setFCIMRoomType("fcIMLeaveRoom", roomId);
	}

	@Override
	public void fcIMSendTxtMessage(String revId, int type, String content) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper
				.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod(
							"fcIMSendTxtMessage", new Class[] { String.class,
									int.class, String.class });
					callMethod.invoke(instance, revId, type, content);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void fcIMStartRecord(String revId, int type) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper
				.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod("fcIMStartRecord",
							new Class[] { String.class, int.class });
					callMethod.invoke(instance, revId, type);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void fcIMCancelRecord() {
		// TODO Auto-generated method stub
		invokeFCVoice("fcIMCancelRecord");
	}

	@Override
	public void fcIMStopRecordSend() {
		// TODO Auto-generated method stub
		invokeFCVoice("fcIMStopRecordSend");
	}

	@Override
	public void fcIMPlayAudioVoice(String path) {
		// TODO Auto-generated method stub
		setFCIMRoomType("fcIMPlayAudioVoice", path);
	}

	@Override
	public void fcIMDoloadVoice(long recMesId, String path) {
		// TODO Auto-generated method stub

		Vector<String> plugins = FuncellPluginHelper
				.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod("fcIMDoloadVoice",
							new Class[] { long.class, String.class });
					callMethod.invoke(instance, recMesId, path);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void registerfCVoiceListener(IFuncellYoumVoiceCallBack voiceCallBack) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper
				.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod(
							"registerfCVoiceListener",
							new Class[] { IFuncellYoumVoiceCallBack.class });
					callMethod.invoke(instance, voiceCallBack);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void registerfCImMessageListener(IFuncellYoumImMessageCallBack call) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper
				.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass
							.getMethod(
									"registerfCImMessageListener",
									new Class[] { IFuncellYoumImMessageCallBack.class });
					callMethod.invoke(instance, call);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void registerfCImRoomListener(IFuncellYoumImRoomCallBack call) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper
				.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod(
							"registerfCImRoomListener",
							new Class[] { IFuncellYoumImRoomCallBack.class });
					callMethod.invoke(instance, call);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void fcIMLogin(String userId, String passWord) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper
				.getSupportPlugins(FuncellPluginType.YoumVoicePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if (instance != null) {
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod("fcIMLogin",
							new Class[] { String.class, String.class });
					callMethod.invoke(instance, userId, passWord);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void fcIMLogout() {
		// TODO Auto-generated method stub
		invokeFCVoice("fcIMLogout");
	}

	@Override
	public void fcIMGamePause() {
		// TODO Auto-generated method stub
		invokeFCVoice("fcIMGamePause");
	}

	@Override
	public void fcIMGameResume() {
		// TODO Auto-generated method stub
		invokeFCVoice("fcIMGameResume");
	}

}
