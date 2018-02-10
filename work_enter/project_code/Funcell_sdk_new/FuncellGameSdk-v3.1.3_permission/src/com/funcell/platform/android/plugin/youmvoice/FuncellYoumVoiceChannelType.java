package com.funcell.platform.android.plugin.youmvoice;

import com.funcell.platform.android.annotation.FuncellNotProguard;

@FuncellNotProguard
public enum FuncellYoumVoiceChannelType {
	voice("voice");

	private final String name;
	private FuncellYoumVoiceChannelType(String str) {
		name = str;
	}
	public boolean equalsName(String otherName) {
		return otherName == null ? false : name.equals(otherName);
	}
	public String toString() {
		return this.name;
	}
}
