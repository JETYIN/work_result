package com.funcell.platform.android.game.proxy.session;

public class FuncellSession {
	private String mChannelCode; //������ʶ 
	private String mUserID; //ƽ̨�û�ID
	private String mUsername;//ƽ̨�û���
	private String mToken; //ƽ̨token
	private String mProductCode; //��Ϸ��ʶ
	private String mChannelUserId; //�����û�ID
	private String mChannelUserName; //�����û���
	private boolean mChangeAccountFlag  = false; //�Ƿ�����˳�������־�����������ڸ����л��ʺ�ʱ�����Ļص�Ϊ��¼�ɹ��Ļص������ԣ���Ҫ֪ͨCP�����Ƚ��е�ǰ��ɫ�˻������棬����ʹ���µĲ�����
	private String mJson; //��¼�󣬷��������ص�ԭ����
	
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
