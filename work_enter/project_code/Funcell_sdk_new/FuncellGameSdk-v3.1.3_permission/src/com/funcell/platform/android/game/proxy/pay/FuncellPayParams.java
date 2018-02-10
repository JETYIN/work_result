package com.funcell.platform.android.game.proxy.pay;

import java.math.BigDecimal;

import android.os.Bundle;

public class FuncellPayParams {
	private String mItemName; //商品名称 ：60钻石
	private String mItemId; //商品ID ：com.xx.item
	private int mItemCount;//商品数量 ：60钻石，对应为60
	private String mItemDescription; //商品描述
	public FuncellMoney mItemAmount; //商品价格
	private String mExtrasParams; //自定义透传参数
	private String mItemType; //商品类型 ：-钻石- 元宝..
	@Deprecated
	private String mPayCallbackUrl; //支付回调地址
	@Deprecated
	private String mOrderId; //游戏订单号
	private String mSdkOrderId;//平台订单号
	private Bundle mBundle; //该字段用于保存平台订单信息
	
	@Deprecated
	private IFuncellPayCallBack mCallBack;
	private String mPayType; //充值类型
	private String mMultPay;//渠道支付标识,该字段可能用于一个包里面，包含多个支付方式的情况，如：Google支付方式，三方支付方式等
	private FuncellRoleInfo mRoleInfo; //用户角色信息
	private String mCurrency; //当前币种-RMB USD...
	
	public FuncellPayParams(){
		mItemName = "";
		mItemId = "";
		mItemCount = 0;
		mItemDescription = "";
		mExtrasParams = "";
		mItemType = "";
		mPayCallbackUrl = "";
		mOrderId = "";
		mItemAmount = FuncellMoney.createFromMoney(new BigDecimal("0"));
		mPayType = "cash";
		mMultPay = "";
		mBundle = new Bundle();
		mRoleInfo = new FuncellRoleInfo();
		mCurrency = "RMB";
	}
	
	/*public FuncellPayParams(String itemName,String itemId,int itemCount,String Description,int itemAmount,String itemType,String extras){
		this(itemName,itemId,itemCount,Description,itemAmount,itemType,null,null,extras);
	}
	
	public FuncellPayParams(String itemName,String itemId,int itemCount,String Description,int itemAmount,String itemType,String payCallbackUrl,String orderId,String extras){
		mItemName = itemName;
		mItemId = itemId;
		mItemCount = itemCount;
		mItemDescription = Description;
		mExtrasParams = extras;
		mItemType = itemType;
		mPayCallbackUrl = payCallbackUrl;
		mOrderId = orderId;
		mItemAmount = FuncellMoney.createFromRmbFen(new BigDecimal(itemAmount));
	}*/
	
	public String getmItemName() {
		return mItemName;
	}
	public void setmItemName(String mItemName) {
		this.mItemName = mItemName;
	}
	public String getmItemId() {
		return mItemId;
	}
	public void setmItemId(String mItemId) {
		this.mItemId = mItemId;
	}
	public int getmItemCount() {
		return mItemCount;
	}
	public void setmItemCount(int mItemCount) {
		this.mItemCount = mItemCount;
	}
	public String getmItemDescription() {
		return mItemDescription;
	}
	public void setmItemDescription(String mItemDescription) {
		this.mItemDescription = mItemDescription;
	}
	public FuncellMoney getmItemAmount() {
		return mItemAmount;
	}
	public void setmItemAmount(String mItemAmount) {
		this.mItemAmount = FuncellMoney.createFromMoney(new BigDecimal(mItemAmount));
	}
	public String getmExtrasParams() {
		return mExtrasParams;
	}
	public void setmExtrasParams(String mExtrasParams) {
		this.mExtrasParams = mExtrasParams;
	}
	public String getmItemType() {
		return mItemType;
	}
	public void setmItemType(String mItemType) {
		this.mItemType = mItemType;
	}
	public String getmPayCallbackUrl() {
		return mPayCallbackUrl;
	}
	public void setmPayCallbackUrl(String mPayCallbackUrl) {
		this.mPayCallbackUrl = mPayCallbackUrl;
	}
	public String getmOrderId() {
		return mOrderId;
	}
	public void setmOrderId(String mOrderId) {
		this.mOrderId = mOrderId;
	}
	public FuncellRoleInfo getmRoleInfo() {
		return mRoleInfo;
	}
	public void setmRoleInfo(FuncellRoleInfo mRoleInfo) {
		this.mRoleInfo = mRoleInfo;
	}
	public String getmPayType() {
		return mPayType;
	}
	public void setmPayType(String mPayType) {
		this.mPayType = mPayType;
	}
	public String getmMultPay() {
		return mMultPay;
	}
	public void setmMultPay(String mMultPay) {
		this.mMultPay = mMultPay;
	}
	public String getmSdkOrderId() {
		return mSdkOrderId;
	}
	public void setmSdkOrderId(String mSdkOrderId) {
		this.mSdkOrderId = mSdkOrderId;
	}
	public Bundle getmBundle() {
		return mBundle;
	}
	public void setmBundle(Bundle mBundle) {
		this.mBundle = mBundle;
	}
	public String getmCurrency() {
		return mCurrency;
	}
	public void setmCurrency(String mCurrency) {
		this.mCurrency = mCurrency;
	}
}
