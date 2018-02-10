package com.funcell.platform.android;

import com.funcell.platform.android.game.proxy.FuncellActivityStubImpl;
import com.funcell.platform.android.game.proxy.FuncellChargerImpl;
import com.funcell.platform.android.game.proxy.FuncellDataManagerImpl;
import com.funcell.platform.android.game.proxy.FuncellExitManagerImpl;
import com.funcell.platform.android.game.proxy.FuncellSessionManagerImpl;
import com.funcell.platform.android.game.proxy.IFuncellActivityStub;
import com.funcell.platform.android.game.proxy.IGameSdkProxy;
import com.funcell.platform.android.game.proxy.data.IFuncellDataManager;
import com.funcell.platform.android.game.proxy.exit.IFuncellExitManager;
import com.funcell.platform.android.game.proxy.pay.IFuncellChargerManager;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionManager;

/**
 * ����Ϊ�ṩ���ⲿ���õĽӿ�  Java/Unity��Ϸ�ӿ�
 * @author Administrator
 *
 */
public class FuncellGameSdkProxy extends FuncellCommanGameSdkProxy {
	
	private static FuncellGameSdkProxy mInstance = null;

	FuncellGameSdkProxy(IFuncellActivityStub stub,IFuncellSessionManager sessionManager,IFuncellChargerManager chargerManager,IFuncellExitManager exitManager,IFuncellDataManager DataManager) {
		super(stub, sessionManager, chargerManager, exitManager,DataManager);
	}

	public static IGameSdkProxy getInstance() {
		if (mInstance == null) {
			synchronized (FuncellGameSdkProxy.class) {
				if (mInstance == null) {
					FuncellActivityStubImpl stub = FuncellActivityStubImpl.getInstance();
					FuncellSessionManagerImpl sessionManager = FuncellSessionManagerImpl.getInstance();
					FuncellExitManagerImpl exitManager = FuncellExitManagerImpl.getInstance();
					FuncellChargerImpl chargerManager = FuncellChargerImpl.getInstance();
					FuncellDataManagerImpl dataManager = FuncellDataManagerImpl.getInstance();
					mInstance = new FuncellGameSdkProxy(stub,sessionManager,chargerManager,exitManager,dataManager);
				}
			}
		}
		return mInstance;
	}
}
