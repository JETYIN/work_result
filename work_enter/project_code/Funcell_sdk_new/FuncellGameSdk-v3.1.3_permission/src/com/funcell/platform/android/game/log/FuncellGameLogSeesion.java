package com.funcell.platform.android.game.log;

import com.funcell.platform.android.game.proxy.session.FuncellSession;

public class FuncellGameLogSeesion {
	private static FuncellGameLogSeesion mInstance = null;
	public synchronized static FuncellGameLogSeesion getInstance() {
		if(mInstance == null){
			mInstance = new FuncellGameLogSeesion();
		}
		return mInstance;
	}
	
	private FuncellSession session;
	public FuncellSession getSession() {return session;}
	public void setSession(FuncellSession session) {this.session = session;}
	
	
}
