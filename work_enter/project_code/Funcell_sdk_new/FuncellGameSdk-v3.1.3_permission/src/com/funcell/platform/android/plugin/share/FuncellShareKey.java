package com.funcell.platform.android.plugin.share;

/**
 * 
 * @author Administrator
 *
 */
public enum FuncellShareKey {
	title("title"),subtitle("subtitle"),description("description"),imageurl("imageurl"),contenturl("contenturl"),likeurl("likeurl"),image("image"),imagepath("imagepath");
	
	
	private final String name;
	private FuncellShareKey(String str) {
		name = str;
	}
	public boolean equalsName(String otherName) {
		return otherName == null ? false : name.equals(otherName);
	}
	public String toString() {
		return this.name;
	}
}
