package com.funcell.platform.android.plugin.share;

public enum FuncellShareChannelType {
	facebook("facebook"),sharesdk("sharesdk"),wechat("wechat");

	private final String name;
	private FuncellShareChannelType(String str) {
		name = str;
	}
	public boolean equalsName(String otherName) {
		return otherName == null ? false : name.equals(otherName);
	}
	public String toString() {
		return this.name;
	}
}
