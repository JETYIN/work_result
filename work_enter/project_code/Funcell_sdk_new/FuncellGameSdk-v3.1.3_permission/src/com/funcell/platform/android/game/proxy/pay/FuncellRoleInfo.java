package com.funcell.platform.android.game.proxy.pay;

public class FuncellRoleInfo {
	private String RoleName;// ��ɫ����
	private String RoleId;// ��ɫID
	private String RoleLevel;// ��ɫ�ȼ�
	private String ServerName;// ����������
	private String ServerId;// ������ID
	private String VipLevel;// VIP�ȼ�
	private String GameGoldBalance;// ��Ϸ��ҽ�����
	private String GameUnionName;// ��������
	
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
