package com.haowan123.funcell.sdk.apiinterface;

public interface LoginCallBack {
	/**
	 * 
	 * @param token
	 * @param fid
	 * @param guest guest=0非游客，1游客，2未知，目前这个字段没有实际的作用，先不管
	 * @param adult adult=0或1，都表示已通过实名认证，如果为2则表示需要弹出实名认证webview
	 */
	public void loginSuccess(String token,String fid,String guest,String adult);

	public void loginFail(int errorCode,String errorMsg);
}
