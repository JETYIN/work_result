package com.funcell.platform.android.plugin.callback;

import com.funcell.platform.android.annotation.FuncellNotProguard;

@FuncellNotProguard
public interface IFuncellYoumImRoomCallBack {

	// ����
	// ���뷿��ɹ����ط����
	void FCIMJoinRoomCallBack(String roomId);

	// �˳�����
	void FCIMExitRoomCallBack(String roomId);

	//��¼�ɹ��ص�
	void FCIMLoginSucCallBack();
}
