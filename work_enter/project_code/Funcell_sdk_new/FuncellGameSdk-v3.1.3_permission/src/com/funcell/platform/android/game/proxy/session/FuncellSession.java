package com.funcell.platform.android.game.proxy.session;

public class FuncellSession {
	private String mChannelCode; //渠道标识 
	private String mUserID; //平台用户ID
	private String mUsername;//平台用户名
	private String mToken; //平台token
	private String mProductCode; //游戏标识
	private String mChannelUserId; //渠道用户ID
	private String mChannelUserName; //渠道用户名
	private boolean mChangeAccountFlag  = false; //是否进行退出操作标志（部分渠道在浮标切换帐号时，给的回调为登录成功的回调，所以，需要通知CP接入先进行当前角色退回主界面，重新使用新的参数）
	private String mJson; //登录后，服务器返回的原数据
	
	public String getmJson() {
		return mJson;
	}
	public void setmJson(String mJson) {
		this.mJson = mJson;
	}
	public boolean getmChangeAccountFlag() {
		return mChangeAccountFlag;
	}

	public void setmChangeAccountFlag(boolean mChangeAccountFlag) {
		this.mChangeAccountFlag = mChangeAccountFlag;
	}

	public String getmChannelCode() {
		return mChannelCode;
	}

	public void setmChannelCode(String mChannelCode) {
		this.mChannelCode = mChannelCode;
	}

	public String getmUserID() {
		return mUserID;
	}

	public void setmUserID(String mUserID) {
		this.mUserID = mUserID;
	}

	public String getmUsername() {
		return mUsername;
	}

	public void setmUsername(String mUsername) {
		this.mUsername = mUsername;
	}

	public String getmToken() {
		return mToken;
	}

	public void setmToken(String mToken) {
		this.mToken = mToken;
	}

	public String getmProductCode() {
		return mProductCode;
	}

	public void setmProductCode(String mProductCode) {
		this.mProductCode = mProductCode;
	}

	public String getmChannelUserId() {
		return mChannelUserId;
	}

	public void setmChannelUserId(String mChannelUserId) {
		this.mChannelUserId = mChannelUserId;
	}

	public String getmChannelUserName() {
		return mChannelUserName;
	}

	public void setmChannelUserName(String mChannelUserName) {
		this.mChannelUserName = mChannelUserName;
	}

	public FuncellSession() {
		mChannelCode = "";
		mUserID = "";
		mUsername = "";
		mToken = "";
		mChannelUserId = "";
		mChannelUserName = "";
		mProductCode = "";
		mChangeAccountFlag = false;
		mJson = "";
	}
	
	public FuncellSession(String channelCode,String userId,String userName,String token,String channelUserId,String channelUserName,String productCode,String json, boolean... ChangeAccountFlag){
		mChannelCode = channelCode;
		mUserID = userId;
		mUsername = userName;
		mToken = token;
		mChannelUserId = channelUserId;
		mChannelUserName = channelUserName;
		mProductCode = productCode;
		mJson = json;
		if(ChangeAccountFlag.length > 0){
			mChangeAccountFlag = ChangeAccountFlag[0];
		}
	}
}
