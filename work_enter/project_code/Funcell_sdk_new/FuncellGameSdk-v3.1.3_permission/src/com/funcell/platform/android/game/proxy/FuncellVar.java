package com.funcell.platform.android.game.proxy;

import com.funcell.platform.android.game.proxy.session.FuncellSession;

public class FuncellVar {
	public static boolean applicationInitCalled = false;
	public static boolean onCreateCalled = false;
	public static boolean onResumeCalled = false;
	public static FuncellSession user;
}
