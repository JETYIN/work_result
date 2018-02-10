package com.funcell.platform.android.game.proxy;

/**
 * 该接口用于调用cocos2d中的GLThread
 * @author Administrator
 *
 */
public abstract interface FuncellGLThreadRunner {
	
	public abstract void runOnGLThread(Runnable paramRunnable);
}
