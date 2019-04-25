package com.ganjiangps.wangdaibus.common.constant;

/**
 *
* @ClassName: Redis_Constat
* @Description: TODO(缓存key 存放类)
* @author cjm
* @date 2018年4月18日 上午9:49:54
*
*    特别注意：
*      因为redis key相同会覆盖原值，一定要防止key重复
*
 */
public class Redis_Constat {

	//APP
	public static final String USER = "user_";//用户基本信息     key= USER + userid
	public static final String USERCENTER = "usercenter_";//用户安全信息 USERCENTER + userid
	public static final String USER_SSM_CODE = "user_ssm_code";//用户短信验证码key  USER_SSM_CODE + 手机号
	public static final String USER_MOBILE = "user_mobile";//用户手机短信验证码手机号 key  USER_MOBILE + 手机号
	public static final String UPDATE_MOBILE_CODE = "user_mobile_code";//修改手机号的时候发送的验证码 key  user_mobile_code+userid   值存验证码
	public static final String BIND_CARD_CODE = "bind_card_code";//绑卡时的时候发送的验证码 key  bind_card_code+userid   值存验证码
	public static final String CHEAK_MOBILE = "cheak_mobile";//修改手机号的时候发送的验证码 key  cheak_mobile+userid  值存:校验通过就存success 校验失败就存fail

	//h5
	public static final String USERHTML = "user_h";//用户基本信息     key= USER + userid
	public static final String USERCENTERHTML = "usercenter_h";//用户安全信息 USERCENTER + userid
	public static final String USER_SSM_CODE_HTML = "user_ssm_code_h";//用户短信验证码key  USER_SSM_CODE + 手机号
	public static final String USER_MOBILE_HTML = "user_mobile_h";//用户手机短信验证码手机号 key  USER_MOBILE + 手机号
	public static final String USER_MOBILE_UDP_HTML = "user_mobile_udp_h";//用户修改密码短信验证码手机号 key  USER_MOBILE + 手机号
	public static final String USER_MOBILE_UDPC_HTML = "user_mobile_udpc_h";//用户修改密码短信验证码 key  USER_SSM_CODE + 手机号
	public static final String USER_MOBILE_WJMM_HTML = "user_mobile_wjmm_h"; //忘记密码  手机号
	public static final String USER_MOBILE_WJMMC_HTML = "user_mobile_wjmmc_h"; //忘记密码 验证码

	public static final String USER_MOBILE_ZFBC_HTML = "user_mobile_zfbc_h"; //主副号绑定验证码
	public static final String USER_MOBILE_ZFBS_HTML = "user_mobile_zfbs_h"; //主副号绑定手机号

	public static final String USER_MOBILE_OLDC_HTML = "user_mobile_oldc_h"; //修改手机号验证码(原手机)
	public static final String USER_MOBILE_OLD_HTML = "user_mobile_old_h"; //原手机号
	public static final String USER_MOBILE_NEWC_HTML = "user_mobile_newc_h"; //修改手机号验证码(新手机)
	public static final String USER_MOBILE_NEW_HTML = "user_mobile_new_h"; //新手机号

	public static final String USER_MOBILE_BINDC_HTML = "user_mobile_bindc_h"; //绑卡验证码
	public static final String USER_MOBILE_BIND_HTML = "user_mobile_bind_h"; //绑卡手机号

	public static final String USER_MOBILE_SSRC_HTML = "user_mobile_ssrc_h"; //手机号认证 验证码
	public static final String USER_MOBILE_SSR_HTML = "user_mobile_ssr_h"; //手机号认证  手机号

	/*public static final String USER_MOBILE_DSFS_HTML = "user_mobile_dsfs_h"; //QQ注册并绑定手机号
	public static final String USER_MOBILE_DSFY_HTML = "user_mobile_dsf_h"; //QQ注册并绑定验证码

	public static final String USER_MOBILE_WXBS_HTML = "user_mobile_wxbs_h"; //微信 注册并绑定手机号
	public static final String USER_MOBILE_WXBY_HTML = "user_mobile_wxby_h"; //微信注册并绑定验证码*/

	public static final String CB_DEPOSIT_CODE_HTML = "cb_deposit_code_h"; //押金退款  验证码
	public static final String CB_DEPOSIT_MOBILE_HTML = "cb_deposit_mobile_h"; //押金退款  手机号

	public static final String PLATFORM_CLAIM_MOBILE_H = "platform_claim_mobile_h"; // 平台认领 手机号
	public static final String PLATFORM_CLAIM_CODE_H = "platform_claim_code_h";     // 平台认领 验证码
	public static final String PLATFORM_APPLY_MOBILE_H = "platform_apply_mobile_h"; // 平台收录 手机号
	public static final String PLATFORM_APPLY_CODE_H = "platform_apply_code_h";     // 平台收录 验证码
	public static final String PLATFORM_APPLY_INFO_H = "platform_apply_info_h";     // 平台收录 平台基本信息
	public static final String PLATFORM_APPLY_BACKLIST_H = "platform_apply_backList_h"; // 平台收录 背景
	public static final String PLATFORM_APPLY_BUSINESSLIST_H = "platform_apply_businessList_h"; // 平台收录 业务
	public static final String PLATFORM_APPLY_FINANCINGlIST_H = "platform_apply_financingList_h"; // 平台收录 融资
	public static final String PLATFORM_APPLY_EXECUTIVESLIST_H = "platform_apply_executivesList_h"; // 平台收录 高管

	public static final String HB_PRE_FORUM_THREAD_HTML = "hb_pre_forum_thread_h"; //红包帖 存放保存的帖子信息

	public static final String HB_BUSACC_CODE_HTML = "hb_busacc_code_h"; //红包帖 巴士余额发帖验证码
	public static final String HB_BUSACC_MOBILE_HTML = "hb_busacc_mobile_h"; //红包帖 巴士余额发帖验证码


	//小蜜蜂
 	public static final String VISITORSTODECLARECODE = "VisitorsToDeclare_Code"; //游客申报验证码
	public static final String VISITORSTODECLAREMOBILE = "VisitorsToDeclare_Mobile"; //游客申报手机
	public static final String DECLAREQUERYCODE = "DeclareQuery_Code"; //申报记录验证码
	public static final String DECLAREQUERYMOBILE = "DeclareQuery_Mobile"; //申报记录手机号

}
