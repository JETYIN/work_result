package com.funcell.platform.android.game.log;


public enum FuncellGameLogType {
	auth("auth"),payment("payment"),serverlist("serverlist"),activation("activation"),notice("notice");
	
	private final String name;
	private FuncellGameLogType(String str) {
		name = str;
	}
	public boolean equalsName(String otherName) {
		return otherName == null ? false : name.equals(otherName);
	}
	public String toString() {
		return this.name;
	}
}
