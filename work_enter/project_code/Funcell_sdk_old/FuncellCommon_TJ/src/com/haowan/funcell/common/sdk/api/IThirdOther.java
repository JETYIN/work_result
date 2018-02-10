package com.haowan.funcell.common.sdk.api;

public abstract class IThirdOther {
	/**
	 * efun facebook invitation
	 */
	public abstract void doFacebookInvitation();

	/**
	 * 查看google成就與排行榜使用, 請在google按鈕被點擊時呼叫此方法
	 */
	public void showGoogleGameCenterDialog() {

	}

	/**
	 * google排行榜上傳分數使用, score = 上傳分數, googleGameLeaderboardID =
	 * 排行榜ID(請與PM拿取對應ID) 請在適當時機呼叫該方法(EX:角色等級排行榜, 請在角色升級時呼叫, 並傳入等級與排行榜ID
	 * 
	 * @param score
	 * @param googleGameLeaderboardID
	 */
	public void submitGoogleGameLeaderBoardScore(long score,
			String googleGameLeaderboardID) {

	}

	/**
	 * google解鎖成就使用, achievementsID = 成就ID(請與PM拿取對應ID) 請在適當時機呼叫該方法(EX:角色等級解鎖成就,
	 * 請在角色升到對應等級時呼叫, 例如５,10,15,20,25級, 分別傳入對應的成就ID
	 * 
	 * @param achievementsID
	 */
	public void unlockGoogleGameAchievements(String achievementsID) {

	}

	/************************************************************************************************************
	 * 台湾--智游 统计
	 * 
	 ***********************************************************************************************************/

	/**
	 * 赠予虚拟币 【用途和用法】
	 * 遊戲中除了可通過充值來獲得虛擬幣外，可能會在任務獎勵、登錄獎勵、成就獎勵等環節免費發放給玩家虛擬幣，來培養他們使用虛擬幣的習慣
	 * 。開發者可通過此方法跟蹤全部免費贈予虛擬幣的數據。 在成功向玩家贈予虛擬幣時調用onReward方法來傳入相關數據。
	 * 只獲得過贈予虛擬幣的玩家不會被記為付費玩家。贈予的虛擬幣會計入到所有的虛擬幣產出中，也計入到留存虛擬幣中。
	 * 
	 * 
	 * 
	 * @param virtualCurrencyAmount
	 *            虛擬幣金額
	 * @param reason
	 *            贈送虛擬幣原因/類型
	 *            [贈送虛擬幣原因/類型。格式：32個字符內的中文、空格、英文、數字。不要帶有任何開發中的轉義字符，如斜槓
	 *            。注意：最多支持100種不同原因。]
	 */
	public void onReward(double virtualCurrencyAmount, String reason) {
		// 示例
		// 玩家在完成了新手引導後，成功獲得了免費贈送的5個鑽石：
		// GameXDDAgent.onReward(5, "新手獎勵");
	}

	/**
	 * 跟蹤遊戲消費點 記錄付費點 【用途和用法】 跟蹤遊戲中全部使用到虛擬幣的消費點，如購買虛擬道具、VIP服務、復活等 跟蹤某物品或服務的耗盡
	 * 在任意消費點發生時盡快調用onPurchase，在某個道具/服務被用掉（消失）時盡快調用onUse
	 * 消費點特指有價值的虛擬幣的消費過程，如果遊戲中存在普通遊戲金幣可購買的虛擬物品，不建議在此處統計。
	 * 
	 * 
	 * @param item
	 *            某個消費點的編號[某個消費點的編號,最多32個字符]
	 * @param itemNumber
	 *            消費數量
	 * @param priceInVirtualCurrency
	 *            虛擬幣單價 該方法在任意消費點發生時盡快調用
	 */
	public void onPurchase(String item, int itemNumber,
			double priceInVirtualCurrency) {

	}

	/**
	 * 跟蹤遊戲消費點 消耗物品或服务等
	 * 
	 * @param item
	 *            某個消費點的編號[某個消費點的編號,最多32個字符]
	 * @param itemNumber
	 *            消費數量 在某個道具/服務被用掉（消失）調用
	 */
	public void onUse(String item, int itemNumber) {

	}

	/**
	 * 任務,關卡或副本 接受/进入 【用途和用法】 跟蹤玩家任務/關卡/副本的情況。
	 * 同一個missionId如果在未結束前，重復進行了onBegin調用，則重新開始計時，上一次的調用被丟棄
	 * 如果多個不同的MissionID同時在進行（都調用了開始，但並未完成或失敗），他們都會同時進行計時，而不是只有一個計時其他暫停計時。
	 * 
	 * @param missionId
	 *            任務,關卡或副本的編號 [任務,關卡或副本的編號,最多32個字符,此處可填寫ID,別名,可在報表編輯]
	 */
	public void onBegin(String missionId) {

	}

	/**
	 * 任務,關卡或副本 完成
	 * 
	 * @param missionId
	 *            任務,關卡或副本的編號 [任務,關卡或副本的編號,最多32個字符,此處可填寫ID,別名,可在報表編輯]
	 */
	public void onCompleted(String missionId) {

	}

	/**
	 * 任務,關卡或副本 失败
	 * 
	 * @param missionId
	 *            任務,關卡或副本的編號 [任務,關卡或副本的編號,最多32個字符,此處可填寫ID,別名,可在報表編輯]
	 * @param cause
	 *            失敗原因 [失敗原因,最多16個字符,共支持100個原因]
	 */
	public void onFailed(String missionId, String cause) {

	}

	/**
	 * 自定義跟蹤事件 【用途和用法】 用於統計任何您期望去跟蹤的數據，如：點擊某功能按鈕、填寫某個輸入框、觸發了某個廣告等。
	 * 可以自行定義eventId，在遊戲中需要跟蹤的位置進行調用，注意eventId中僅限使用中英文字符、數字和下划線，不要加空格或其他的轉義字符。
	 * 除了可以統計某自定義eventId的觸發次數外
	 * ，還可以通過key-value參數來對當時觸發事件時的屬性進行描述。如定義eventId為玩家死亡事件
	 * ，可添加死亡時關卡、死亡時等級、死亡時攜帶金幣等屬性，通過key-value進行發送。 每款遊戲可定義最多10000個不同eventId。
	 * 注意:當前自定義統計可根據我方產品需要統計的點來進行定義,向我方獲取統計表
	 * eventId、JsonEventData的key和String類型的value，分別最多支持32個字符。
	 * 
	 * @param eventId
	 * @param eventData
	 */
	public void onEvent(String eventId, final String jsonEventData) {

	}

	/**
	 * Efun-新马----事件追踪（过完新手调用）
	 */
	public void efunTrackingFinshGuideEvent() {

	}

	/**
	 * 快用是否支持用户中心显示
	 */
	public boolean IsSupportUserCenter() {
		return true;
	}

	/**
	 * vstargame越南游戏CDN资源加载监控
	 */
	public void onGameResLoading(String resName, String resVersion,
			long totalSize, long currentSize, float speed) {

	}

	public void onShow() {

	}

	public String getMsdkData() {

		return null;
	}

	public void uploadMsdkLog(String log) {

	}

	public String doGetChildChannel() {
		return null;
	}

	// kaopu
	public String doGetOpenId() {
		return null;
	}

	public String doGetToken() {
		return null;
	}

	public String doGetNextChannel() {
		return null;
	}
	
	/**
	 * 判断是否是android平台
	 * @return
	 */
	public boolean getNowTypeIsAndroid(){
		return true;
	}
	
	public int getAddictionInfo(){
		return 0;
	}
}
