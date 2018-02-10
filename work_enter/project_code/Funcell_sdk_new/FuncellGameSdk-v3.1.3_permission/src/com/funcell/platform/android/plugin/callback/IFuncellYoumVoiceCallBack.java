package com.funcell.platform.android.plugin.callback;

import com.funcell.platform.android.annotation.FuncellNotProguard;

@FuncellNotProguard
public interface IFuncellYoumVoiceCallBack {
	/** 游密voice返回给游戏的渠道数据回调 **/

	/** 进入放假失败 **/

	public void FCVoiceChatRoomCallBack();

	/**
	 * 回调对应硬件状态信息 eventType 0:麦克风状态 status 0:开 1:关 eventType 1:扬声器状态 status 0:开
	 * 1:关 eventType 2:用户被开关麦克风 status 0:开 1:关 eventType 3:用户被开关扬声器 status 0:开
	 * 1:关 eventType 4:用户被取消屏蔽/屏蔽 status 0:取消屏蔽 1:屏蔽
	 * **/
	public void FCVoiceSTCallBack(int eventType, String userId, int status);

	// 获取房间成员列表-直接返回成员ID数组
	public void FCVoiceTalkRoomMemberCallBack(String[] memberList);

	// 背景音乐播放告知游戏：
	public void FCVoiceBgMusucOverCallBack();

}
