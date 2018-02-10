package com.funcell.platform.android.plugin.analytics;

public enum FuncellAnalyticsEventType {
	login("login"),
	purchase_open("purchase_open"),purchase_close("purchase_close"),purchase_cancle("purchase_cancle"),purchase_success("purchase_success"),
	tutorial_completed("tutorial_completed"),
	level_achieved("level_achieved"),
	create_role("create_role");
	

	private final String name;
	private FuncellAnalyticsEventType(String str) {
		name = str;
	}
	public boolean equalsName(String otherName) {
		return otherName == null ? false : name.equals(otherName);
	}
	public String toString() {
		return this.name;
	}
}
