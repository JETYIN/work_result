package com.funcell.platform.android.game.proxy;

/**
 * �ýӿ����ڵ���cocos2d�е�GLThread
 * @author Administrator
 *
 */
public abstract interface FuncellGLThreadRunner {
	
	public abstract void runOnGLThread(Runnable paramRunnable);
}
