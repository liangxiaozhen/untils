package com.ganjiangps.wangdaibus.common.constant;

/**
 * @author gengfl
 * @version V1.0
 * @ClassName: Session_Constant
 * @Package com.ptpl.constant
 * @Description: TODO(存放session 作用域的常量值)
 * @date 2018年1月3日 上午11:22:35
 */
public class Session_Constant {


    /*=======================================用户注册和安全中心start=============================================*/
  /*短信发送记录的短信发送类型 注册,登录,忘记密码*/
    public static final String REGISTERMESSAGE = "注册短信";
    public static final String LOGINMESSAGE = "登录短信";
    public static final String FORGETPWDERMESSAGE = "忘记密码短信";
    public static final String BINDCARDERMESSAGE = "绑卡时短信";
    public static final String WITHDRAWALMESSAGE = "提现短信";
    public static final String UPDATEPHONEMESSAGE = "用户修改手机号短信";
    public static final String REDPACKETMESSAGE = "红包短信";
    public static final String CODEFORTX = "codeForTx";

    /**
     * 广告位购买验证码
     */
    public static final String ADBUYSMS = "ADSMSVERIFICATION";

    /**
     * 广告位购买电话号码
     */
    public static final String ADUSERPHONE = "ADUSERPHONE";

    /*防止表单提交Session  token 值*/
    public static final String FORMTOKEN = "formtoken";
    /*注册时生成的用户名 */
    public static final String USERNAME = "username";
    /**
     * 用户注册 获取短信验证码  session 值
     */
    public static final String MESSAGECODE = "messageCode";
    /**
     * 用户忘记密码 获取短信验证码  session 值
     */
    public static final String FTPMESSAGECODE = "ftpMessageCode";
    /**
     * 用户修改手机号码时 获取的短信验证码(原手机号验证码)
     */
    public static final String ALTERMOBILECODE = "alterMobileCode";
    /**
     * 用户修改手机号码时 手机号session(原手机号)
     */
    public static final String ALTERMOBILE = "alterMobile";
    /**
     * 用户修改手机号码时 获取的短信验证码(新手机号验证码)
     */
    public static final String NEWMOBILECODE = "newMobileCode";
    /**
     * 用户修改手机号码时 手机号session(新手机号)
     */
    public static final String NEWMOBILE = "newMobile";
    /**
     * 用户忘记密码 手机号  session 值
     */
    public static final String FTPPHONE = "ftpphone";
    /**
     * 用户修改密码 手机号验证码  session值
     */
    public static final String PASSWORDMOBILECODE = "passwordMobileCode";
    /**
     * 用户修改密码 手机号session值
     */
    public static final String PASSWORDMOBILE = "passwordMobile";
    
    /**
     * 用户绑卡时发送短信验证码
     */
    public static final String FASTMOBILECODE = "fastMobileCode";
    /**
     * 用户修改手机号码时 手机号session(原手机号)
     */
    public static final String FASTMOBILE = "fastMobile";
    
    
    /**
     * 用户手机号认证 验证码
     */
    public static final String REPOVEMOBILECODE = "repoveMobileCode";
    /**
     * 用户修改手机号码时 手机号session(新手机号)
     */
    public static final String REPOVEMOBILE = "repoveMobile";


    /**
     * 用户提现 获取短信验证码  session 值
     */
    public static final String USERWITHDRAWALSCODE = "userWithdrawalsCode";
    /**
     * 用户提现 获取手机号码  session 值
     */
    public static final String USERWITHDRAWALSMOBILE = "userWithdrawalsMobile";

    /**
     * 用户打赏---茶馆  获取短信验证码  session 值
     */
    public static final String REWARDTEACODE = "rewardTeaCode";
    /**
     * 用户打赏---茶馆  获取手机号码  session 值
     */
    public static final String REWARDTEAMOBILE = "rewardTeaMobile";
    /**
     * 用户打赏---资讯  获取短信验证码  session 值
     */
    public static final String REWARDARTICLECODE = "rewardArticleCode";
    /**
     * 用户打赏---资讯  获取手机号码  session 值
     */
    public static final String REWARDARTICLEMOBILE = "rewardArticleMobile";
    /**
     * 平台押金---退款  获取短信验证码  session 值
     */
    public static final String PDEPOSITCODE = "pDepositCode";
    /**
     * 平台押金---退款  获取手机号码  session 值
     */
    public static final String PDEPOSITMOBILE = "pDepositMobile";
    /**
     * 骗返押金---退款  获取短信验证码  session 值
     */
    public static final String CBDEPOSITCODE = "cbDepositCode";
    /**
     * 骗返押金---退款  获取手机号码  session 值
     */
    public static final String CDDEPOSITMOBILE = "cdDepositMobile";

    /**
     * 红包帖  获取短信验证码  session 值
     */
    public static final String REDPACKETCODE = "redpacketCode";
    /**
     * 红包帖  获取手机号码  session 值
     */
    public static final String REDPACKETMOBILE = "redpacketMobile";
    
    /**
     * 主副号绑定 验证码
     */
    public static final String ZFBINDBILECODE = "zfbindMobileCode";
    /**
     * 主副号绑定手机号
     */
    public static final String ZFBINDBILE = "zfbindMobile";
    
    
    /**
     * 用户注册 手机号  session 值
     */
    public static final String REGISTERPHONE = "registerphone";
    
    /**
     * 用户修改手机原手机的短信验证码的session 值
     */
    public static final String OLDCODE = "oldcode";
    /**
     * 用户修改手机原手机的短信验证码的session 值
     */
    public static final String NEWCODE = "newcode";
    /**
     * 用户中心修改手机号原手机获取短信验证码  session 值
     */
    public static final String MSGFORMERPHONE = "msgformerphone";
    /**
     * 用户注册存在session中的手机号值的 session 值
     */
    public static final String PHONE = "bindPhone";
    /**
     * 用户个人中心修改原手机的 session 值
     */
    public static final String FORMERPHONE = "formerphone";
    /**
     * 用户个人中心修改原手机的 session 值
     */
    public static final String NEWPHONE = "newphone";
    /**
     * 用户注册 获取短信验证码生成的时间 session 值
     */
    public static final String MESSAGECODETIME = "messagecodetime";
    /**
     * 用户修改手机号原手机获取短信验证码生成的时间 session 值
     */
    public static final String MSGTIMEFORMERPHONE = "msgtimeformerphone";
    /**
     * 用户修改手机号现手机获取短信验证码生成的时间 session 值
     */
    public static final String MSGTIMENEWPHONE = "msgtimenewphone";
    /**
     * 用户登录   用户基本信息的session 值
     */
    public static final String USERACCOUNTINFO = "userAccountInfo";
    
    /**
     * 用户h5发送邮箱验证码生成的时间 session 值
     */
    public static final String EMAILCODEMILLS = "emailcodeemills";
    /**
     * 用户app发送邮箱验证码生成的时间 session 值
     */
    public static final String APPEMAILCODEMILLS = "appemailcodeemills";
    /**
     * 用户pc端发送邮箱验证码生成的时间 session 值
     */
    public static final String PCEMAILCODEMILLS = "pcemailcodeemills";
    /**
     * 用户登录   用户安全信息的session 值
     */
    public static final String USERACCOUNTSAFEINFO = "userAccountSafeInfo";

    /**
     * 用户注册 安全中心 获取短信验证码修改Md5key生成的时间 session 值
     */
    public static final String MESSAGEMD5KEYCODETIMEUPDATE = "messageMD5keyCodeTimeUpdate";
    /**
     * 用户安全中心 手机生成的验证码的session 值
     */
    public static final String MESSAGECODELOGIN = "messageCodeLogin";

    /**
     * 商户安全中心   发送短信验证码（修改手机号---新手机）    新手机获取短信验证码生成的时间的 session 值
     */
    public static final String MESSAGECODETIMENEWPHONE = "messageCodeTimeNewPhone";
    /**
     * 商户安全中心   发送短信验证码（修改手机号---新手机）    新手机号的 session 值
     */
    public static final String BINDNEWPHONE = "bindNewPhone";
    /**
     * 代理商后台 安全中心 修改MD5key  短信验证码 session 值
     */
    public static final String MESSAGEMD5KEYCODEUPDATE = "messageMD5keyCodeUpdate";

    /**
     * 商户后台 安全中心 修改登录密码时 短信验证码的session 值
     */
    public static final String BINDPHONEUPDATE = "bindPhoneUpdate";
    
    /**
     * 用户第三方注册绑定 手机号  session 值
     */
    public static final String BINDREGISTERPHONE = "bindregisterphone";
    /**
     * 用户第三方注册绑定 手机验证码  session 值
     */
    public static final String BINDREGISTERPHONECODE = "bindregisterphonecode";
    /**
     * 微信 绑定session值
     */
    public static final String WEIXINCODE = "weixinCode";
    /**
     * 微信 绑定session值
     */
    public static final String WEIXINPHONE = "weixinPhone";


	/*=======================================用户注册和安全中心end=============================================*/


    /**
     * 系统管理用户 session 值
     */
    public static final String ADMINUSER = "adminuser";

    /**
     * 普通用户 基本信息session 值
     */
    public static final String USER = "user";

    /**
     * 用户安全信息 session 值
     */
    public static final String USERSECURITYINFO = "usersecurityinfo";


    /**
     * 普通用户 短信 验证码 session 值
     */
    public static final String USER_TELEPHONE_CODE = "user_telephone_code";

    /**
     * 安全中心  开户短信验证码session 值
     */
    public static final String SECURITYCENTEROPENANACCOUNTSENDSSM = "securitycenteropenanaccountsendssm";

    /**
     * 安全中心  开户 参数验证通过 session 值
     */
    public static final String SECURITYCENTEROPENANACCOUNTCODE = "securitycenteropenanaccountcode";

    /**
     * 安全中心  重置登录密码短信验证码session 值
     */
    public static final String SECURITYCENTERLOGINPASSWORDSENDSSM = "securitycenterloginpasswordsendssm";

    /**
     * 安全中心 手机号码验证/修改  短信验证码 session 值（根据原邮箱修改手机号  邮箱验证码session ）
     */
    public static final String SECURITYCENTERPHONESENDSSM = "securitycenterphonesendssm";

    /**
     * 安全中心 手机号码修改  新手机短信验证码 session 值
     */
    public static final String SECURITYCENTERNEWPHONESENDSSM = "securitycenternewphonesendssm";

    /**
     * 安全中心 手机号码验证/修改  手机号码 session 值
     */
    public static final String SECURITYCENTERPHONE = "securitycenterphone";

    /**
     * 安全中心 设置 密保问题  短信验证码session 值
     */
    public static final String SECURITYCENTERQUESTIONSM = "securitycenterquestionssm";

    /**
     * 安全中心 设置 /修改 密保问题  短信验证码成功后保存的session 值
     */
    public static final String SECURITYCENTERQUESTIONCHECKSUCCESS = "securitycenterquestionchecksuccess";


    /**
     * 安全中心 修改邮箱账号  验证原邮箱成功后保存，新邮箱发送绑定链接需要验证此值
     */
    public static final String EMAILSUCCESSCODE = "emailsuccesscode";


    /**
     * 通过手机找回密码   保存code的session
     */
    public static String PHONERETRIEVEPASSWORD = "phone_retrieve_password";

    /**
     * 通过手机找回密码  保存手机号码的session
     */
    public static String MOBILEPHONESECURITY = "mobile_phone_security";

    /**
     * 安全中心 普通用户 更改手机号码  新手机号码短信验证码 session 值
     */
    public static final String USER_NEW_TELEPHONE_CODE = "user_new_telephone_code";

    /**
     * 安全中心 普通用户 重置邮箱  邮箱验证码 session 值
     */
    public static final String USER_REGISTER_EMAIL_CODE = "user_register_email_code";

    /**
     * 安全中心 普通用户 重置邮箱  邮箱30位随机码 session 值
     */
    public static final String USER_EMAILCODE_EMAIL_CODE = "user_emailcode_email_code";

    /**
     * 第三方登录 微博绑定session值
     */
    public static final String USER_WEIBO_USER_CODE = "user_weibo_user_code";

    /**
     * 第三方登录 微博绑定 新用户注册 手机验证码session值
     */
    public static final String USER_WEIBO_PHONE_CODE = "user_weibo_phone_code";

    /**
     * 第三方登录 微博绑定 新用户注册 邮箱验证证码session值
     */
    public static final String USER_WEIBO_EMAIL_CODE = "user_weibo_email_code";

    /**
     * 第三方登录 QQ绑定session值
     */
    public static final String USER_QQ_USER_CODE = "user_qq_user_code";
    /**
     * 第三方登录 QQ唯一标识绑定session值
     */
    public static final String USER_QQ_USER_UNIONID = "user_qq_user_unionid";

    /**
     * 第三方登录 QQ绑定 新用户注册 手机验证码session值
     */
    public static final String USER_QQ_PHONE_CODE = "user_qq_phone_code";

    /**
     * 第三方登录 QQ绑定 新用户注册 邮箱验证证码session值
     */
    public static final String USER_QQ_EMAIL_CODE = "user_qq_email_code";

    /**
     * 邮件补发 方法
     */
    public static final String REPEAT_EMAIL = "repeatemail";

    /**
     * 提前还款 借款人还款计划 选择的借款人还款计划 期数ID
     */
    public static final String AHEADREPAY_DIVMENTS = "aheadrepay_divments";

    /**
     * 提前还款 借款人选择部分提前还款  选择的部分投资人的投标订单号
     */
    public static final String AHEADPARTREPAY_INACCOUNTID_UTORDERNO = "aheadpartrepay_inaccountid_utorderno";

    /**
     * 提前还款 借款人该次还款总金额
     */
    public static final String AHEADREPAYMENT_RAMOUNTCOUNT = "aheadrepayment_ramountcount";

    /**
     * 提前还款选择的期数id
     */
    public static final String AHEADPARTREPAYMENT_DIVMENTS = "aheadpartrepayment_divments";

    /**
     * 提前还款选择的期数id
     */
    public static final String AHEADALLREPAYMENT_DIVMENTS = "aheadallrepayment_divments";

    /**
     * 逾期还款选择期数ID
     */
    public static final String OVERDUEREPAYMENT_DIVMENTS = "overduerepayment_divments";

    /**
     * 逾期还款总金额
     */
    public static final String OVERDUEREPAYMENT_COUNT = "overduerepayment_count";

    /**
     * 用户找回密码  用户安全信息
     */
    public static final String USERFINDPWDUSERSAFE = "userfindpwdusersafe";
    /**
     * 用户找回密码  用户基本信息
     */
    public static final String USERFINDPWDUSERBASE = "userfindpwduserbase";

    /**
     * AES 加密解密key
     */
    public static final String EMAILCODEKEY = "ed252e0d0b862d0888430d93175f862f";

    /**
     * 交易密码 短信验证码
     */
    public static final String TRADEPASSWORDPHONESSMCODE = "tradepasswordphonessmcode";

    /*response result 通用返回值*/
    public static final String RESULT = "result";
    /*response  resultCode 具体返回值*/
    public static final String RESULTCODE = "resultCode";
    /*response message 消息提示*/
    public static final String MESSAGE = "message";
    /*response  params_error*/
    public static final String PARAMSERROR = "params_error";
    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    public static final String LOGOUT = "logout";
    
    /**
     * H5用户绑卡时发送短信验证码
     */
    public static final String FASTMOBILECODEH5 = "fastMobileCodeh5";
    /**
     * H5用户修改手机号码时 手机号session(原手机号)
     */
    public static final String FASTMOBILEH5 = "fastMobileh5";

    /**
     * 用户登录   用户基本信息的session 值
     */
    public static final String USERACCOUNTINFO406 = "userAccountInfo406";
    /**
     * 用户安全信息 session 值
     */
    public static final String USERSECURITYINFO406 = "usersecurityinfo406";
    
    /**
     * 用户注册 获取短信验证码  session 值
     */
    public static final String MESSAGECODE406 = "messageCode406";
    /**
     * 用户注册 手机号  session 值
     */
    public static final String REGISTERPHONE406 = "registerphone406";
    /**
     * 绑卡手机号 验证码
     */
	public static final String BINDCARDCODE406 = "bindcardcode406";
	/**
	 * 绑卡手机号 
	 */
	public static final String BINDCARDPHONE406 = "bindcardphone406";
	/**
	 * 忘记密码 验证码
	 */
	public static final String FORGETPASSWORDCODE406 = "forgetpasswordcode406";
	/**
	 * 忘记密码手机号
	 */
	public static final String FORGETPASSWORDPHONE406 = "forgetpasswordphone406";
	   /**
     * 用户修改手机号码时 获取的短信验证码(原手机号验证码)
     */
    public static final String ALTERMOBILECODE406 = "alterMobileCode406";
    /**
     * 用户修改手机号码时 手机号session(原手机号)
     */
    public static final String ALTERMOBILE406 = "alterMobile406";
    /**
     * 用户修改手机号码时 获取的短信验证码(新手机号验证码)
     */
    public static final String NEWMOBILECODE406 = "newMobileCode406";
    /**
     * 用户修改手机号码时 手机号session(新手机号)
     */
    public static final String NEWMOBILE406 = "newMobile406";
    /**
     * 用户406端发送邮箱验证码生成的时间 session 值
     */
    public static final String EMAILCODEMILLS406 = "emailcodeemills406";
    /**
     * 用户修改密码 手机号验证码  session值
     */
    public static final String PASSWORDMOBILECODE406 = "passwordMobileCode406";
    /**
     * 用户修改密码 手机号session值
     */
    public static final String PASSWORDMOBILE406 = "passwordMobile406";
    /**
     * 用户手机号认证 验证码
     */
    public static final String REPOVEMOBILECODE406 = "repoveMobileCode406";
    /**
     * 用户修改手机号码时 手机号session(新手机号)
     */
    public static final String REPOVEMOBILE406 = "repoveMobile406";
    /**
     * 用户忘记密码 获取短信验证码  session 值
     */
    public static final String FTPMESSAGECODE406 = "ftpMessageCode406";
    /**
     * 用户忘记密码 手机号  session 值
     */
    public static final String FTPPHONE406 = "ftpphone406";
    /**
     * 用户绑卡时发送短信验证码
     */
    public static final String FASTMOBILECODE406 = "fastMobileCode406";
    /**
     * 用户绑卡手机号码时 手机号session(原手机号)
     */
    public static final String FASTMOBILE406 = "fastMobile406";

    /**
     * 用户提现 获取短信验证码  session 值
     */
    public static final String USERWITHDRAWALSCODE406 = "userWithdrawalsCode406";
    /**
     * 用户提现 获取手机号码  session 值
     */
    public static final String USERWITHDRAWALSMOBILE406 = "userWithdrawalsMobile406";
    
}