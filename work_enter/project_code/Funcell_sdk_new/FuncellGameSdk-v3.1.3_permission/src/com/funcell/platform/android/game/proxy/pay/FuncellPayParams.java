package com.funcell.platform.android.game.proxy.pay;

import java.math.BigDecimal;

import android.os.Bundle;

public class FuncellPayParams {
	private String mItemName; //��Ʒ���� ��60��ʯ
	private String mItemId; //��ƷID ��com.xx.item
	private int mItemCount;//��Ʒ���� ��60��ʯ����ӦΪ60
	private String mItemDescription; //��Ʒ����
	public FuncellMoney mItemAmount; //��Ʒ�۸�
	private String mExtrasParams; //�Զ���͸������
	private String mItemType; //��Ʒ���� ��-��ʯ- Ԫ��..
	@Deprecated
	private String mPayCallbackUrl; //֧���ص���ַ
	@Deprecated
	private String mOrderId; //��Ϸ������
	private String mSdkOrderId;//ƽ̨������
	private Bundle mBundle; //���ֶ����ڱ���ƽ̨������Ϣ
	
	@Deprecated
	private IFuncellPayCallBack mCallBack;
	private String mPayType; //��ֵ����
	private String mMultPay;//����֧����ʶ,���ֶο�������һ�������棬�������֧����ʽ��������磺Google֧����ʽ������֧����ʽ��
	private FuncellRoleInfo mRoleInfo; //�û���ɫ��Ϣ
	private String mCurrency; //��ǰ����-RMB USD...
	
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
