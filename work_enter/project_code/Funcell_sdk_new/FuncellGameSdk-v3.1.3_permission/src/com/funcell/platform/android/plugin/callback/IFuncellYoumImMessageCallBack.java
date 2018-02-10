package com.funcell.platform.android.plugin.callback;

import com.funcell.platform.android.annotation.FuncellNotProguard;

@FuncellNotProguard
public interface IFuncellYoumImMessageCallBack {
	// ������Ϣ���ͳɹ�

	void FCIMMessageTxtCallBack(long requestId);

	// ������Ϣ״̬
	void FCIMMessageAudioCallBack(long requestId, String extxt, String recPath,
			int time);

	// ����������Ϣ
	void FCIMReciveTxtMesCallBack(String message);

	// ����������Ϣ
	void FCIMReciveAudioMesCallBack(long requestId, int time, String text);

	// ��Ϣ���سɹ�
	void FCIMDownloadAudioCallBack(String path);

}
