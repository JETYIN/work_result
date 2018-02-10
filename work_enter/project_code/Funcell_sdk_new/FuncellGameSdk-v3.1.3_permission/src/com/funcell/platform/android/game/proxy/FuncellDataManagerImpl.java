package com.funcell.platform.android.game.proxy;

import android.app.Activity;
import android.util.Log;

import com.funcell.platform.android.game.proxy.data.FuncellDataTypes;
import com.funcell.platform.android.game.proxy.data.IFuncellDataManager;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;

/**
 * 
 * @author Administrator
 *
 */
public class FuncellDataManagerImpl implements IFuncellDataManager{
	private String TAG = getClass().getName().toString();
	private static FuncellDataManagerImpl mInstance;
	
	public static FuncellDataManagerImpl getInstance() {
		if (mInstance == null) {
			synchronized (FuncellDataManagerImpl.class) {
				if (mInstance == null) {
					mInstance = new FuncellDataManagerImpl();
				}
			}
		}
		return mInstance;
	}
	
	private void CreatRoleEvent(Activity ctx,ParamsContainer paramParamsContainer){
		Log.e(TAG, "---------->调用渠道的创建角色事件<----------");
	}
	
	private void LoginEvent(Activity ctx,ParamsContainer paramParamsContainer){
		Log.e(TAG, "---------->调用渠道的登录游戏事件,可在登录游戏并选择了服务器后调用<----------");
	}
	
	private void RoleLevelUpEvent(Activity ctx,ParamsContainer paramParamsContainer){
		Log.e(TAG, "---------->调用渠道的角色升级事件<----------");
	}
	
	private void Server_RoleEvent(Activity ctx,ParamsContainer paramParamsContainer){
		Log.e(TAG, "---------->调用渠道的上传角色信息和服务器信息事件,可在进入游戏主场景时调用<----------");
	}
	
	@Override
	public void setDatas(Activity ctx, FuncellDataTypes paramDataTypes,ParamsContainer paramParamsContainer) {
		if(FuncellDataTypes.DATA_CREATE_ROLE == paramDataTypes){
			CreatRoleEvent(ctx, paramParamsContainer);
		}else if(FuncellDataTypes.DATA_LOGIN == paramDataTypes){
			LoginEvent(ctx, paramParamsContainer);
		}else if(FuncellDataTypes.DATA_ROLE_LEVELUP == paramDataTypes){
			RoleLevelUpEvent(ctx, paramParamsContainer);
		}else if(FuncellDataTypes.DATA_SERVER_ROLE_INFO == paramDataTypes){
			Server_RoleEvent(ctx, paramParamsContainer);
		}
	}
}
