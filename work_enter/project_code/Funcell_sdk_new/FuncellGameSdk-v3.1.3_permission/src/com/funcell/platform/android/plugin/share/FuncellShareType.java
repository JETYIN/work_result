package com.funcell.platform.android.plugin.share;

public enum FuncellShareType {
	text("text"),video("video"),photo("photo");

	private final String name;
	private FuncellShareType(String str) {
		name = str;
	}
	public boolean equalsName(String otherName) {
		return otherName == null ? false : name.equals(otherName);
	}
	public String toString() {
		return this.name;
	}
}
