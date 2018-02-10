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
		Log.e(TAG, "---------->���������Ĵ�����ɫ�¼�<----------");
	}
	
	private void LoginEvent(Activity ctx,ParamsContainer paramParamsContainer){
		Log.e(TAG, "---------->���������ĵ�¼��Ϸ�¼�,���ڵ�¼��Ϸ��ѡ���˷����������<----------");
	}
	
	private void RoleLevelUpEvent(Activity ctx,ParamsContainer paramParamsContainer){
		Log.e(TAG, "---------->���������Ľ�ɫ�����¼�<----------");
	}
	
	private void Server_RoleEvent(Activity ctx,ParamsContainer paramParamsContainer){
		Log.e(TAG, "---------->�����������ϴ���ɫ��Ϣ�ͷ�������Ϣ�¼�,���ڽ�����Ϸ������ʱ����<----------");
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
