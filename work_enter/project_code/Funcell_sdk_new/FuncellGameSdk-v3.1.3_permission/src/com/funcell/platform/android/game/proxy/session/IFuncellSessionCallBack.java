package com.funcell.platform.android.game.proxy.session;

public abstract interface IFuncellSessionCallBack {
	
	/**
	 * ��¼�ɹ�
	 * @param session
	 */
	public abstract void onLoginSuccess(FuncellSession session);
	
	/**
	 * ��¼ȡ��
	 */
	public abstract void onLoginCancel();
	
	/**
	 * ��¼ʧ��
	 * @param paramString
	 */
	public abstract void onLoginFailed(String paramString);

	/**
	 * �ʺ��˳�
	 */
	public abstract void onLogout();
	
	/**
	 * �л��ʺŻص�(ʹ�ûص���Ϣ���е�¼��֤)
	 * �����������л��ʺŻص��У��������Ե�¼�ɹ��ص��� �ص���SDK
	 * ��˵��ӵ��ûص���Ϣʱ����Ҫ��֪ͨ��Ϸ�˻ص�¼��������е�ǰ��ɫ�л�
	 * @param session
	 */
	public abstract void onSwitchAccount(FuncellSession session);
}
