package com.funcell.platform.android.game.proxy.pay;

public class FuncellRoleInfo {
	private String RoleName;// 角色名称
	private String RoleId;// 角色ID
	private String RoleLevel;// 角色等级
	private String ServerName;// 服务器名称
	private String ServerId;// 服务器ID
	private String VipLevel;// VIP等级
	private String GameGoldBalance;// 游戏玩家金币余额
	private String GameUnionName;// 公会名字
	
	public String getRoleName() {return RoleName;}
	public void setRoleName(String roleName) {RoleName = roleName;}

	public String getRoleId() {return RoleId;}
	public void setRoleId(String roleId) {RoleId = roleId;}

	public String getRoleLevel() {return RoleLevel;}
	public void setRoleLevel(String roleLevel) {RoleLevel = roleLevel;}

	public String getServerName() {return ServerName;}
	public void setServerName(String serverName) {ServerName = serverName;}

	public String getServerId() {return ServerId;}
	public void setServerId(String serverId) {ServerId = serverId;}

	public String getVipLevel() {return VipLevel;}
	public void setVipLevel(String vipLevel) {VipLevel = vipLevel;}

	public String getGameGoldBalance() {return GameGoldBalance;}
	public void setGameGoldBalance(String gameGoldBalance) {GameGoldBalance = gameGoldBalance;}

	public String getGameUnionName() {return GameUnionName;}
	public void setGameUnionName(String gameUnionName) {GameUnionName = gameUnionName;}
	
	public FuncellRoleInfo(){
		RoleName = "";
		RoleId = "";
		RoleLevel = "";
		ServerName = "";
		ServerId = "";
		VipLevel="";
		GameGoldBalance="";
		GameUnionName = "";
	}
}
