package com.funcell.platform.android.plugin.callback;

import com.funcell.platform.android.annotation.FuncellNotProguard;

@FuncellNotProguard
public interface IFuncellYoumVoiceCallBack {
	/** ����voice���ظ���Ϸ���������ݻص� **/

	/** ����ż�ʧ�� **/

	public void FCVoiceChatRoomCallBack();

	/**
	 * �ص���ӦӲ��״̬��Ϣ eventType 0:��˷�״̬ status 0:�� 1:�� eventType 1:������״̬ status 0:��
	 * 1:�� eventType 2:�û���������˷� status 0:�� 1:�� eventType 3:�û������������� status 0:��
	 * 1:�� eventType 4:�û���ȡ������/���� status 0:ȡ������ 1:����
	 * **/
	public void FCVoiceSTCallBack(int eventType, String userId, int status);

	// ��ȡ�����Ա�б�-ֱ�ӷ��س�ԱID����
	public void FCVoiceTalkRoomMemberCallBack(String[] memberList);

	// �������ֲ��Ÿ�֪��Ϸ��
	public void FCVoiceBgMusucOverCallBack();

}
