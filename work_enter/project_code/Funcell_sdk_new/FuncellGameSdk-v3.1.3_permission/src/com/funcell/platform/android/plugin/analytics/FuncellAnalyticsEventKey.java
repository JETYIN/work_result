package com.funcell.platform.android.plugin.analytics;

/**
 * 
 * @author Administrator
 *
 */
public enum FuncellAnalyticsEventKey {
	login("login"),
	purchase_open("purchase_open"),purchase_close("purchase_close"),purchase_cancle("purchase_cancle"),purchase_success("purchase_success"),purchase_revenue("purchase_revenue"),
	purchase_content_type("purchase_content_type"),purchase_content_id("purchase_content_id"),purchase_currency("purchase_currency"),purchase_order_id("purchase_order_id"),
	tutorial_completed("tutorial_completed"),
	level("level"),level_achieved("level_achieved"),level_score("level_score"),
	create_role("create_role");
	
	
	private final String name;
	private FuncellAnalyticsEventKey(String str) {
		name = str;
	}
	public boolean equalsName(String otherName) {
		return otherName == null ? false : name.equals(otherName);
	}
	public String toString() {
		return this.name;
	}
}
