package com.funcell.platform.android.plugin.callback;

import com.funcell.platform.android.annotation.FuncellNotProguard;

@FuncellNotProguard
public interface IFuncellYoumImMessageCallBack {
	// 文字消息发送成功

	void FCIMMessageTxtCallBack(long requestId);

	// 语音消息状态
	void FCIMMessageAudioCallBack(long requestId, String extxt, String recPath,
			int time);

	// 接收文字消息
	void FCIMReciveTxtMesCallBack(String message);

	// 接收语音消息
	void FCIMReciveAudioMesCallBack(long requestId, int time, String text);

	// 消息下载成功
	void FCIMDownloadAudioCallBack(String path);

}
