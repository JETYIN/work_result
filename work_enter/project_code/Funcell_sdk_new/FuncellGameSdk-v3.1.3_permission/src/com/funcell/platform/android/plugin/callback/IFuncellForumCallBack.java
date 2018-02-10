package com.funcell.platform.android.plugin.callback;

import com.funcell.platform.android.annotation.FuncellNotProguard;

@FuncellNotProguard
public class IFuncellForumCallBack {
	public interface OnActivityStatusChangedListener<RESULT>{
		public abstract void onActivityChanged(RESULT result);
	}
	
}
