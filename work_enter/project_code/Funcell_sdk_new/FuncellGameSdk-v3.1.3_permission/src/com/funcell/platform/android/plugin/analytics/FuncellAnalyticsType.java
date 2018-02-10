package com.funcell.platform.android.plugin.analytics;

public enum FuncellAnalyticsType {
	appsflyer("appsflyer"),facebook("facebook"),mat("mat"),google("google"),twitter("twitter"),tune("tune"),reyun("reyun"),ats("ats");

	private final String name;
	private FuncellAnalyticsType(String str) {
		name = str;
	}
	public boolean equalsName(String otherName) {
		return otherName == null ? false : name.equals(otherName);
	}
	public String toString() {
		return this.name;
	}
}
