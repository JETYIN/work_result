package com.funcell.platform.android.permissions;

import android.content.Context;

public class FuncellPermissionsBuilder {
	private Context mContext;
    private FuncellPermissionsCallbacks mFuncellPermissionsCallbacks;
    private String mRationale4ReqPer;
    private String mRationale4NeverAskAgain;
    private int mPositiveBtn4ReqPer = -1;
    private int mNegativeBtn4ReqPer = -1;
    private int mPositiveBtn4NeverAskAgain = -1;
    private int mNegativeBtn4NeverAskAgain = -1;
    private int mRequestCode = -1;

    /*
     * Basics RequestCode
     * use lower 16 bits for requestCode (0-65535)
     */
    private int mAnalyticsBasicsRequestCode = 0xea60; //60000
    private int mCrashBasicsRequestCode = 0xeac4; //60100
    private int mHelpShiftBasicsRequestCode = 0xeb28;//60200
    private int mPushBasicsRequestCode = 0xeb8c;//60300
    private int mShareBasicsRequestCode = 0xebf0;//60400
    private int mVoiceBasicsRequestCode = 0xec54;//60500
    
    
	public int getmAnalyticsBasicsRequestCode() {return mAnalyticsBasicsRequestCode;}
	public FuncellPermissionsBuilder setmAnalyticsBasicsRequestCode(int mAnalyticsBasicsRequestCode) {this.mAnalyticsBasicsRequestCode = mAnalyticsBasicsRequestCode; return this;}

	public int getmCrashBasicsRequestCode() {return mCrashBasicsRequestCode;}
	public FuncellPermissionsBuilder setmCrashBasicsRequestCode(int mCrashBasicsRequestCode) {this.mCrashBasicsRequestCode = mCrashBasicsRequestCode; return this;}

	public int getmHelpShiftBasicsRequestCode() {return mHelpShiftBasicsRequestCode;}
	public FuncellPermissionsBuilder setmHelpShiftBasicsRequestCode(int mHelpShiftBasicsRequestCode) {this.mHelpShiftBasicsRequestCode = mHelpShiftBasicsRequestCode; return this;}

	public int getmPushBasicsRequestCode() {return mPushBasicsRequestCode;}
	public FuncellPermissionsBuilder setmPushBasicsRequestCode(int mPushBasicsRequestCode) {this.mPushBasicsRequestCode = mPushBasicsRequestCode; return this;}

	public int getmShareBasicsRequestCode() {return mShareBasicsRequestCode;}
	public FuncellPermissionsBuilder setmShareBasicsRequestCode(int mShareBasicsRequestCode) {this.mShareBasicsRequestCode = mShareBasicsRequestCode; return this;}
	
	public int getmVoiceBasicsRequestCode() {return mVoiceBasicsRequestCode;}
	public FuncellPermissionsBuilder setmVoiceBasicsRequestCode(int mVoiceBasicsRequestCode) {this.mVoiceBasicsRequestCode = mVoiceBasicsRequestCode; return this;}

    public FuncellPermissionsBuilder(Context context) {
        this.mContext = context;
    }

    public FuncellPermissionsBuilder onFuncellPermissionsCallbacks(FuncellPermissionsCallbacks funcellPermissionsCallbacks){
    	this.mFuncellPermissionsCallbacks = funcellPermissionsCallbacks;
    	return this;
    }
    
    public FuncellPermissionsBuilder rationale4ReqPer(String rationale4ReqPer) {
        this.mRationale4ReqPer = rationale4ReqPer;
        return this;
    }

    public FuncellPermissionsBuilder positiveBtn4ReqPer(int positiveBtn4ReqPer) {
        this.mPositiveBtn4ReqPer = positiveBtn4ReqPer;
        return this;
    }

    public FuncellPermissionsBuilder positiveBtn4NeverAskAgain(int positiveBtn4NeverAskAgain) {
        this.mPositiveBtn4NeverAskAgain = positiveBtn4NeverAskAgain;
        return this;
    }

    public FuncellPermissionsBuilder negativeBtn4ReqPer(int negativeBtn4ReqPer) {
        this.mNegativeBtn4ReqPer = negativeBtn4ReqPer;
        return this;
    }

    public FuncellPermissionsBuilder negativeBtn4NeverAskAgain(int negativeBtn4NeverAskAgain) {
        this.mNegativeBtn4NeverAskAgain = negativeBtn4NeverAskAgain;
        return this;
    }

    public FuncellPermissionsBuilder rationale4NeverAskAgain(String rationale4NeverAskAgain) {
        this.mRationale4NeverAskAgain = rationale4NeverAskAgain;
        return this;
    }

    public FuncellPermissionsBuilder requestCode(int requestCode) {
        this.mRequestCode = requestCode;
        return this;
    }

    public FuncellPermissionsManager build() {
        return new FuncellPermissionsManager(
                mContext,
                mFuncellPermissionsCallbacks,
                mRationale4ReqPer,
                mRationale4NeverAskAgain,
                mPositiveBtn4ReqPer,
                mNegativeBtn4ReqPer,
                mPositiveBtn4NeverAskAgain,
                mNegativeBtn4NeverAskAgain,
                mRequestCode
        );
    }
}