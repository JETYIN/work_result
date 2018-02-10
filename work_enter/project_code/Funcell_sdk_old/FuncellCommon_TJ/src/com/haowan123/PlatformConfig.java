package com.haowan123;

public class PlatformConfig {
	String func_ClientID; // 当前渠道分配的客户标识
	String func_auth_url; // 当前从数据中心获得的认证地址，及验证账号
	String func_even_node; // 当前数据中心的节点名字
	String func_pay_url; // 当前从数据中心获得的支付产品地址
	String func_access_token; // 当前平台获得的访问token
	String func_refresh_token; // 当前平台获得的刷新token
	String func_platform_name; // 当前渠道登录的账号名
	String func_pay_json; // 当前平台分配给当前游戏的产品列表ＪＳＯＮ字符串
	String chan_ext_data; // 当前渠道的访问ＴＯＫＥＮ
	String func_pay_callback; // 充值回调地址
	String func_platform_uid;
	String func_fed_id;
	String func_log_url;// 日志采集地址
	String func_data_center;//日志上传地址

	public PlatformConfig() {
		func_ClientID = "";
		func_auth_url = "";
		func_even_node = "";
		func_pay_url = "";
		func_access_token = "";
		func_refresh_token = "";
		func_platform_name = "";
		func_pay_json = "";
		chan_ext_data = "";
		func_pay_callback = "";
		func_platform_uid = "";
		func_fed_id = "";
		func_log_url = "";
	}

	public String getFunc_ClientID() {
		return func_ClientID;
	}

	public void setFunc_ClientID(String func_ClientID) {
		this.func_ClientID = func_ClientID;
	}

	public String getFunc_auth_url() {
		return func_auth_url;
	}

	public void setFunc_auth_url(String func_auth_url) {
		this.func_auth_url = func_auth_url;
	}

	public String getFunc_pay_url() {
		return func_pay_url;
	}

	public void setFunc_pay_url(String func_pay_url) {
		this.func_pay_url = func_pay_url;
	}

	public String getFunc_refresh_token() {
		return func_refresh_token;
	}

	public void setFunc_refresh_token(String func_refresh_token) {
		this.func_refresh_token = func_refresh_token;
	}

	public String getFunc_even_node() {
		return func_even_node;
	}

	public void setFunc_even_node(String func_even_node) {
		this.func_even_node = func_even_node;
	}

	public String getFunc_access_token() {
		return func_access_token;
	}

	public void setFunc_access_token(String func_access_token) {
		this.func_access_token = func_access_token;
	}

	public String getFunc_platform_name() {
		return func_platform_name;
	}

	public void setFunc_platform_name(String func_platform_name) {
		this.func_platform_name = func_platform_name;
	}

	public String getFunc_pay_json() {
		return func_pay_json;
	}

	public void setFunc_pay_json(String func_pay_json) {
		this.func_pay_json = func_pay_json;
	}

	public String getChan_ext_data() {
		return chan_ext_data;
	}

	public void setChan_ext_data(String chan_ext_data) {
		this.chan_ext_data = chan_ext_data;
	}

	public String getFunc_pay_callback() {
		return func_pay_callback;
	}

	public void setFunc_pay_callback(String func_pay_callback) {
		this.func_pay_callback = func_pay_callback;
	}

	public String getFunc_platform_uid() {
		return func_platform_uid;
	}

	public void setFunc_platform_uid(String func_platform_uid) {
		this.func_platform_uid = func_platform_uid;
	}

	public String getFunc_fed_id() {
		return func_fed_id;
	}

	public void setFunc_fed_id(String func_fed_id) {
		this.func_fed_id = func_fed_id;
	}

	public String getFunc_log_url() {
		return func_log_url;
	}

	public void setFunc_log_url(String func_log_url) {
		this.func_log_url = func_log_url;
	}
}