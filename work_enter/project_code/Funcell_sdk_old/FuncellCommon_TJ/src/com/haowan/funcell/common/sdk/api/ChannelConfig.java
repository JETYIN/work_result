package com.haowan.funcell.common.sdk.api;

/**
 * 初始化渠道配置bean
 * 
 * @author id4lin
 * 
 */
public class ChannelConfig {
	/**
	 * 游戏ID
	 */
	private Integer productId;

	/**
	 * 渠道ID
	 */
	private Integer fgi;
	/**
	 * 游戏版本
	 */
	private String appVersion;
	/**
	 * 渠道标识
	 */
	private String platform_type;
	/**
	 * 数据中心节点
	 */
	private String node;

	/**
	 * 
	 * @param productId
	 *            [游戏ID]
	 * @param fgi
	 *            [渠道ID]
	 * @param appVersion
	 *            [游戏版本]
	 * @param platform_type
	 *            [渠道标识]
	 * @param node
	 *            [数据中心节点]
	 */
	public ChannelConfig(Integer productId, Integer fgi, String appVersion,
			String platform_type, String node) {
		super();
		this.productId = productId;
		this.fgi = fgi;
		this.appVersion = appVersion;
		this.platform_type = platform_type;
		this.node = node;
	}

	public Integer getProductId() {
		return productId;
	}

	public Integer getFgi() {
		return fgi;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public String getPlatform_type() {
		return platform_type;
	}

	public String getNode() {
		return node;
	}

}
