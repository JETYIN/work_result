package com.haowan.funcell.common.sdk.api;


public enum ThirdOperType {
	/**
	 * 用户中心
	 */
	USER_CENTER(1),
	/**
	 * 论坛
	 */
	BBS(2),
	/**
	 * 反馈页面
	 * 
	 */
	FEED_BACK(3),
	/**
	 * 统计
	 */
	COUNT(4),
	/**
	 * 创建角色
	 */
	CREATE_ROLE(5),
	/**
	 * 进入游戏
	 */
	INTO_GAME(6),
	/**
	 * 等级变化
	 */
	LEVEL_CHANGE(7),
	/**
	 * 其他
	 */
	OTHER(8);
	// 成员变量
	private int index;

	// 构造方法
	private ThirdOperType(int index) {
		this.index = index;
	}


	// get set 方法

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return this.index + "";
	}

	public static void main(String[] args) {
		System.err.println(ThirdOperType.USER_CENTER);
	}
}
