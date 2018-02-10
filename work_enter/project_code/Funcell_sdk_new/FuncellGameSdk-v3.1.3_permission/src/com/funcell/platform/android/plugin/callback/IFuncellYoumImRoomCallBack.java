package com.funcell.platform.android.plugin.callback;

import com.funcell.platform.android.annotation.FuncellNotProguard;

@FuncellNotProguard
public interface IFuncellYoumImRoomCallBack {

	// 游密
	// 加入房间成功返回房间号
	void FCIMJoinRoomCallBack(String roomId);

	// 退出房间
	void FCIMExitRoomCallBack(String roomId);

	//登录成功回调
	void FCIMLoginSucCallBack();
}
