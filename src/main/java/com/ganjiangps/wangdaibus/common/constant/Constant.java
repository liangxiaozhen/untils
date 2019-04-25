package com.ganjiangps.wangdaibus.common.constant;

public class Constant {
	public static final int NUM = 1;// 用户后台默认查询NUM天前到今天的交易,如果要默认查询1天前到今天的交易，请将NUM设置为1
	// 域名
	public static final String HTTP_SERVER = "http://www.ganjiangps.com";
	public static final String HTTPS_SERVER = "https://www.ganjiangps.com";

	public static final int BILLNO_ERROR = -1;// 订单号错误(重复或有特殊字符)
	public static final int PAYMENT_FAILURE = 0;// 付款失败

	public static final int PAY_DECIMAL_LENGTH_2 = 2;// 精确到小数点后2位
	public static final int PAY_DECIMAL_LENGTH_4 = 4;// 精确到小数点后4位
	public static final String PAY_STATIC_FORMAT_VALUE = "100";
	public static final String PAY_RETURN_FORMAT_ZERO_12 = "000000000000"; // 12个0
	/*
	 * 页面后缀
	 */
	public static final String VIEW_LIST = "_List";
	public static final String VIEW_INSERT = "_Insert";
	public static final String VIEW_UPDATE = "_Update";
	public static final String VIEW_DELETE = "_Delete";
	public static final String VIEW_DETAIL = "_Detail";
}
