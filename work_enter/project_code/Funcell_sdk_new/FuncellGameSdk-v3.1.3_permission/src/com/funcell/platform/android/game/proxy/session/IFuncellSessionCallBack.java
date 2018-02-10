package com.funcell.platform.android.game.proxy.session;

public abstract interface IFuncellSessionCallBack {
	
	/**
	 * 登录成功
	 * @param session
	 */
	public abstract void onLoginSuccess(FuncellSession session);
	
	/**
	 * 登录取消
	 */
	public abstract void onLoginCancel();
	
	/**
	 * 登录失败
	 * @param paramString
	 */
	public abstract void onLoginFailed(String paramString);

	/**
	 * 帐号退出
	 */
	public abstract void onLogout();
	
	/**
	 * 切换帐号回调(使用回调信息进行登录验证)
	 * 部分渠道在切换帐号回调中，可能是以登录成功回调来 回调给SDK
	 * 因此当接到该回调信息时候，需要先通知游戏退回登录主界面进行当前角色切换
	 * @param session
	 */
	public abstract void onSwitchAccount(FuncellSession session);
}
