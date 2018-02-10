package com.funcell.platform.android.plugin.crash;

public enum FuncellCrashChannelType {
	bugly("bugly"),testin("testin");

	private final String name;
	private FuncellCrashChannelType(String str) {
		name = str;
	}
	public boolean equalsName(String otherName) {
		return otherName == null ? false : name.equals(otherName);
	}
	public String toString() {
		return this.name;
	}
}
