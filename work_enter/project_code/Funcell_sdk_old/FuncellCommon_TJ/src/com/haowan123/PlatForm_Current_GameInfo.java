package com.haowan123;

public class PlatForm_Current_GameInfo {

	String m_areaID;
	String m_areaName;
	String m_roleID;
	String m_roleName;
	long m_roleCreatTime;
	String m_gameUnionName;
	int m_roleLevel;
	int m_gameGoldBalance; // 游戏金币余额
	String m_profession; // 角色职业
	int m_rolePower; // 角色战斗力
	int m_roleGold; // 角色钻石、元宝数量
	long m_roleLevelupTime;// 角色升级时间

	int m_vip;// vip等级

	PlatForm_Current_GameInfo() {
		m_areaName = "";
		m_areaID = "";
		m_roleID = "";
		m_roleName = "";
		m_roleCreatTime = -1;
		m_roleLevel = -1;
		m_gameUnionName = "";
		m_gameGoldBalance = -1;
		m_profession = "";
		m_rolePower = -1;
		m_roleGold = -1;
		m_roleLevelupTime = -1;
		m_vip = -1;

	}
}