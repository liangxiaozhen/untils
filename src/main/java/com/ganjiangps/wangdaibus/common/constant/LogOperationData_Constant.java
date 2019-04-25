package com.ganjiangps.wangdaibus.common.constant;

import com.ganjiangps.wangdaibus.model.PlatformSafeguardingRights;

import java.util.HashMap;
import java.util.Map;

/**
 * 日志字段变化为汉字常量类
 * @author Administrator
 *
 */
public class LogOperationData_Constant {



	//最好是实体类名字第一个子母小写后的单词
//	public static final String FRPNTTYPE ="userSpreadRegister";
	/*public static final String USERSPREADPROXY ="userSpreadProxy";
	public static final String USERAGENCYSETTING ="userAgencySetting";
	public static final String USERACCOUNTINFO ="userAccountInfo"; */


	//推广设置
	public static final Map<String,String> FRONTTYPE=new HashMap<String,String>(){{
		put("id","id");
		put("typeName","类型名称");
		put("type","类型");
		put("typeRemark","类型备注");
		put("updateMan","操作人");
	}};


	/** =======================================资金管理 Start=========================================== */
	//打赏设置
	public static final Map<String,String> REWARDSET=new HashMap<String,String>(){{
		put("id","id");
		put("baseid","用户id");
		put("lowamount","最低打赏额");
		put("highamount","最高打赏额");
		put("onoff","打赏开关(0关,1开) ");
		put("remark","备注");
	}};

	//押金手充记录
	public static final Map<String,String> DEPOSITRECHARGERECORD=new HashMap<String,String>(){{
		put("id","id");
		put("baseid","充值对象用户id");
		put("pno","平台编号");
		put("dramount","押金手充金额");
		put("drno","押金手充流水号");
        put("type","业务类型(1骗返押金 2平台押金)");
        put("status","充值状态(1待审核 2手充成功 3手充失败)");
        put("auditstatus","审核状态(0未审核 1已审核)");
        put("auditremark","审核备注");
        put("auditid","审核人ID");
        put("addid","管理员操作ID");
		put("remark","手充备注");
	}};
	//骗返押金账户
	public static final Map<String,String> CHEATBACKDEPOSITACCOUNT=new HashMap<String,String>(){{
		put("id","id");
		put("baseid","用户id");
		put("type","押金类型(默认 1-骗返押金)");
		put("totalbalance","用户总金额");
		put("avlbalance","可用金额");
		put("freezebalance","冻结金额 ");
		put("remark","备注");
	}};
	//骗返押金收支
	public static final Map<String,String> CHEATBACKDEPOSITINEX=new HashMap<String,String>(){{
		put("id","id");
		put("baseid","用户ID");
		put("borderno","关联流水号");
		put("deposittype","押金类型(默认 1-骗返押金)");
		put("type","业务类型(1-缴纳 2退款 3手充)");
		put("depositamount","押金金额");
		put("totalbalance","用户总金额");
		put("avlbalance","可用金额");
		put("freezebalance","冻结金额 ");
		put("remark","备注");
	}};
	//平台押金账户
	public static final Map<String,String> PLATFORMDEPOSITACCOUNT=new HashMap<String,String>(){{
		put("id","id");
		put("pno","平台编号");
		put("type","押金类型(默认 1-平台押金)");
		put("totalbalance","用户总金额");
		put("avlbalance","可用金额");
		put("freezebalance","冻结金额 ");
		put("remark","备注");
	}};
	//平台押金收支
	public static final Map<String,String> PLATFORMDEPOSITINEX=new HashMap<String,String>(){{
		put("id","id");
		put("pno","平台编号");
		put("ptname","平台名称");
		put("borderno","关联流水号");
		put("deposittype","押金类型(默认 1-平台押金)");
		put("type","业务类型(1-缴纳 2退款 3手充)");
		put("depositamount","押金金额");
		put("totalbalance","用户总金额");
		put("avlbalance","可用金额");
		put("freezebalance","冻结金额 ");
		put("remark","备注");
	}};
	//押金退款记录
	public static final Map<String,String> DEPOSITREFUNDRECORD=new HashMap<String,String>(){{
		put("id","id");
		put("baseid","用户ID");
		put("pno","平台编号");
		put("drno","退款流水号");
		put("deposittype","押金类型(1骗返押金 2平台押金)");
		put("ptname","平台名称");
		put("refundamount","退款金额");
		put("status","退款状态(1待审核 2退款成功 3退款失败)");
		put("auditid","审核人ID");
		put("auditremark","审核备注");
	}};
	//押金冻结解冻
	public static final Map<String,String> DEPOSITFREEZETHAW=new HashMap<String,String>(){{
		put("id","id");
		put("baseid","用户ID");
		put("pno","平台编号");
		put("ftorderno","押金冻解流水号");
		put("orderno","关联流水号");
		put("deposittype","押金类型(1骗返押金 2平台押金)");
		put("ptname","平台名称");
		put("amount","冻解金额");
		put("depositstatus","退款状态(1待处理 2退款成功 3退款失败 )");
		put("totalbalance","用户押金总金额");
		put("avlbalance","用户押金可用余额");
		put("freebalance","用户押金冻结金额 ");
		put("status","状态(1冻结 2解冻)");
		put("addid","操作人ID");
		put("remark","备注");
	}};
	/** =======================================资金管理 end=========================================== */

	//实名认证开关
	public static final Map<String,String> USERAUTHENTICATIONONOFF=new HashMap<String,String>(){{
		put("id","id");
		put("name","接口名称");
		put("type","认证类型(1实名，2银行卡4要素)");
		put("company","接口公司");
		put("isuse","是否使用(0关闭 1开启)");
		put("remark","备注");
	}};
	//用户账户
	public static final Map<String,String> USERACCOUNT=new HashMap<String,String>(){{
		put("id","id");
		put("baseid","用户ID");
		put("balance","用户总金额");
		put("avlBalance","可用总额");
		put("freezeBalance","冻结总额");
		put("remark","备注");
	}};
	//用户收支记录
	public static final Map<String,String> USERINEXRECORD=new HashMap<String,String>(){{
		put("id","id");
		put("baseid","用户ID");
		put("orderno","收支记录流水号");
		put("borderno","业务流水号");
		put("inamount","收入");
		put("outamount","支出");
		put("type","业务类型");
		put("description","资金来源");
		put("totalbalance","用户总金额");
		put("balance","可用总额");
		put("freebalance","冻结总额");
		put("judge1","判断条件1");
		put("judge2","判断条件2");
		put("judge3","判断条件3");
		put("judge4","判断条件4");
		put("remark","备注");
	}};

	/** =======================================充扣管理 Start=========================================== */
	//充扣记录
	public static final Map<String,String> DEDUCTIONSRECORD=new HashMap<String,String>(){{
		put("id","id");
		put("baseid","用户ID");
		put("dramount","充扣金额");
		put("drno","充扣流水号");
		put("type","业务类型(1预约扣款 2手动扣款 3手充成功 4手充失败)");
		put("balance","用户总金额");
		put("avlbalance","可用总额");
		put("freezebalance","冻结总额");
		put("addid","操作人ID");
		put("remark","充扣备注");
		put("auditid","审核人ID");
		put("auditremark","审核备注");

	}};
	//手充审核
	public static final Map<String,String> MANUALRECHARGEAUDIT=new HashMap<String,String>(){{
		put("id","id");
		put("baseid","用户ID");
		put("mramount","手充金额");
		put("mrno","手充流水号");
		put("addid","操作人ID");
		put("remark","手充备注");
	}};
	//用户账户冻结解冻
	public static final Map<String,String> USERACCOUNTFREEZETHAW=new HashMap<String,String>(){{
		put("id","id");
		put("baseid","用户ID");
		put("ftorderno","冻结解冻流水号");
		put("orderno","关联流水号");
		put("amount","金额");
		put("type","业务类型(1.提现 2.差错 3.产品预约 4手动冻结 5手动解冻)");
		put("description","资金来源（用途）");
		put("totalbalance","用户总金额");
		put("balance","可用总额");
		put("freebalance","冻结总额");
		put("status","状态(1冻结 2解冻)");
		put("remark","备注");
	}};
	/** =======================================充扣管理 end=========================================== */

	//用户基本信息
	public static final Map<String,String> PRECOMMONMEMBER=new HashMap<String,String>(){{
		put("uid","id");
		put("username","用户名");
		put("realname","真实姓名");
		put("email","邮箱");
		put("mobile","手机号");
		put("certno","身份证号码");
		put("remark","备注");
	}};
	//推广设置
	public static final Map<String,String> USERSPREADREGISTERDATA=new HashMap<String,String>(){{
		put("id","id");
		put("baseid","用户id");
		put("username","用户名");
		put("type","类型");
		put("validdate","有效期");
		put("recommentonoff","推广开关");
		put("addman","设置人");
		put("addtime","设置时间");
		put("remark","备注");
	}};

	//推广详情
	public static final Map<String,String> USERSPREADQUERYDATA=new HashMap<String,String>(){{
		put("id","id");
		put("recommendstatus","推荐状态");

	}};

	//推广人
	public static final Map<String,String> USERSPREADPROXYDATA=new HashMap<String,String>(){{
		put("id","id");
		put("baseid","用户baseid");
		put("username","用户名");
		put("recommendnumber","推广人数");
	}};


	//提现设置
	public static final Map<String,String> USERWITHDRAWALSFEESETDATA=new HashMap<String,String>(){{
		put("id","id");
		put("baseid","用户ID");
		put("lowamount","单笔最低提现额");
		put("highamount","单笔最高提现额");
		put("feetype","收费方式(1定额 2百分比)");
		put("feerate","提现定额(百分比)");
		put("minfee","手续费最低");
		put("maxfee","手续费最高");
		put("onOff","是否开启(0关 1开)");
		put("remark","备注");
	}};

	/** 模块广告 */
	//模块广告修改操作
	public static final Map<String,String> ADUNIVERSAL=new HashMap<String,String>(){{
		put("id","id");
		put("current_page","所在页面");
		put("serial","广告序号");
		put("adplacement","广告所在位置");
		put("terminal","终端(1pc,2手机)）");
		put("adsize","图片尺寸");
		put("attributes","广告属性 1文字广告，2图片广告");
		put("image_address","广告图访问地址");
		put("adword","广告词");
		put("font_color","字体颜色");
		put("ad_link","广告图链接");
		put("effectiveness","广告信息有效性(0展示中，1已过期)");
		put("expire_date","到期时间");
		put("display_switch","展示开关");
		put("set_people","设置人IP");
		put("set_time","设置时间");
		put("remark","备注");
	}};

										// 平台
	// 平台信息
	public static final Map<String,String> PLATFORMINFO=new HashMap<String,String>(){{
		put("id","id");
		put("pname","平台名称");
		put("website","平台网址");
		put("logo1","logo详情页（大）");
		put("logo2","logo列表页（小）");
		put("recordname","运营公司");
		put("address","总部地址");
		put("profitmin","参考收益");
		put("customerphone","客服电话");
		put("qq","客服QQ");
		put("maintanceman","维护人姓名");
		put("maintanceposition","维护人职位");
		put("depositorytype","存管方式:1资金池 2支付公司存管 3银行存管");
		put("depositoryagency","存管机构");
		put("operatingstatus","运营状态:1正常 2跑路 3清盘 4高风险 5有争议 6延期兑付 7停业 8经侦介入 9提现困难");
		put("investidea","投资建议");
		put("sort","排序定位");
		put("riskmark","风险提示");
		put("productno","产品编号");
		put("remark","备注");
		put("thunderstormtime","爆雷时间");
		put("investimpress1","投资印象1");
		put("investimpress2","投资印象2");
		put("investimpress3","投资印象3");
		put("investimpress4","投资印象4");
		put("investimpress5","投资印象5");
		put("investimpress6","投资印象6");
		put("display","页面显示:0不显示 1显示");
		put("specialdesc","特殊说明");
		put("remark","备注");
	}};
	// 平台评价
	public static final Map<String,String> PLATFORMEVALUATE=new HashMap<String,String>(){{
		put("id","id");
		put("digest","是否精华:0否 1是");
		put("display","页面显示:0不显示 1显示 ");
		put("sort","排序定位");
		put("evaluationtime","评价时间");
		put("remark","管理员备注");
	}};
	// 平台负面
	public static final Map<String,String> PLATFORMBADINFO=new HashMap<String,String>(){{
		put("id","id");
		put("pno","平台编号");
		put("pname","平台名称");
		put("title","标题");
		put("badlink","链接");
		put("status","是否显示:0不显示 1显示");
		put("elitestatus","精华状态:0普通 1精华");
		put("clearstatus","澄清状态:0未澄清 1已澄清");
		put("remark","备注");
	}};
    // 工商信息
    public static final Map<String,String> PLATFORMBUSINESS=new HashMap<String,String>(){{
        put("id","id");
        put("pname","平台名称");
        put("legalperson","法人代表");
        put("regaddress","注册地址");
        put("capital","注册资本");
        put("paidcapital","实缴资本");
        put("companytype","公司类型");
        put("regauthority","登记机关");
        put("recorddomain","备案域名");
        put("recordname","备案单位名称");
        put("recordtime","备案日期");
        put("companyattribute","备案单位性质");
        put("managementstate","经营状态");
        put("opentime","开业时间");
        put("businesstimelimit","营业期限（开始时间）");
        put("businesstimelimitend","营业期限（结束时间）");
        put("approvaldate","核准日期");
        put("icpauth","ICP经营许可证");
        put("icp","ICP备案号");
        put("businessnumber","工商注册号");
        put("socialcreditcode","统一社会信用代码");
        put("licensenumber","营业执照号");
        put("organizationcode","组织机构代码");
        put("oldname","平台曾用名");
        put("operationscope","经营范围");
        put("remark","备注");
    }};
    // 平台维权
    public static final Map<String,String> PLATFORMSAFEGUARDINGRIGHTS=new HashMap<String,String>(){{
        put("id","id");
        put("pno","平台编号");
        put("pname","平台名称");
        put("lawer","维权律师");
        put("days","维权天数");
        put("number","维权人数");
        put("leader","带头人姓名");
        put("leaderusername","带头人用户名");
        put("mobile","带头人手机号");
        put("wechat","带头人微信");
        put("notice","维权公告");
        put("status","维权状态:1开启 2关闭");
        put("qq","维权QQ群1");
        put("qq2","维权QQ群2");
        put("qq3","维权QQ群3");
        put("progress","维权进展");
        put("leaderusername","带头人用户名");
        put("remark","备注");
    }};
    // 工商变更
    public static final Map<String,String> BUSINESSCHANGE=new HashMap<String,String>(){{
        put("id","id");
        put("pid","平台ID");
        put("changetype","变更类型");
        put("changetime","变更时间");
        put("aheadinfo","变更前信息");
        put("afterinfo","变更后信息");
    }};
    // 平台评级
    public static final Map<String,String> GRADESUMMARY=new HashMap<String,String>(){{
        put("id","id");
        put("pno","平台编号");
        put("pname","平台名称");
        put("pstatus","平台运营状态");
        put("organization","评级机构 1网贷之家 2网贷天眼 3网贷巴士 4融360 5逸飞");
        put("gradetime","评级时间");
        put("ranking","排名");
    }};

    // 用户禁止
	public static final Map<String,String> USERFORBID=new HashMap<String,String>(){{
		put("id","id");
		put("forbidtype","禁止类型 1.IP 2.用户名");
		put("typecontent","类型内容");
		put("forbidcontent","禁止内容 1.登录 2.发帖 3.回复 4.访问");
		put("forbiddaynum","禁止天数");
	}};




	//根据自己的相关业务类型添加map
	public static final Map<String,Map<String,String>> BUSINESSTYPE=new HashMap<String,Map<String,String>>(){{
        put("frontType",FRONTTYPE);

		put("rewardSet",REWARDSET);//打赏设置
        put("depositRechargeRecord",DEPOSITRECHARGERECORD);//押金手充
        put("cheatBackDepositAccount",CHEATBACKDEPOSITACCOUNT);//骗返押金账户
		put("cheatBackDepositInEx",CHEATBACKDEPOSITINEX);//骗返押金收支
        put("platformDepositAccount",PLATFORMDEPOSITACCOUNT);//平台押金账户
        put("platformDepositInEx",PLATFORMDEPOSITINEX);//平台押金收支
		put("depositFreezeThaw", DEPOSITFREEZETHAW);//押金冻结解冻
		put("depositRefundRecord", DEPOSITREFUNDRECORD);//押金退款记录

        put("userAuthenticationOnoff",USERAUTHENTICATIONONOFF);//实名认证开关
        put("userAccount",USERACCOUNT);//用户账户
        put("userInExRecord",USERINEXRECORD);//用户收支记录

        put("deductionsRecord",DEDUCTIONSRECORD);//充扣记录
        put("manualRechargeAudit",MANUALRECHARGEAUDIT);//手充审核
        put("userAccountFreezeThaw",USERACCOUNTFREEZETHAW);//用户账户冻结解冻
        put("preCommonMember",PRECOMMONMEMBER);//用户基本信息
        put("userSpreadRegister",USERSPREADREGISTERDATA);//用户推广设置
        put("userSpreadQuery",USERSPREADQUERYDATA);//用户推广详情
        put("userSpreadProxy",USERSPREADPROXYDATA);//用户推广人

        put("adUniversal",ADUNIVERSAL);//模块广告修改操作

		//提现设置
		put("userWithdrawalsFeeSet",USERWITHDRAWALSFEESETDATA);

		put("platformInfo",PLATFORMINFO);    // 平台信息
		put("platformEvaluate",PLATFORMEVALUATE); // 平台评价
		put("platformBadInfo",PLATFORMBADINFO); // 平台负面
        put("platformBusinessRegistration",PLATFORMBADINFO); // 平台工商
        put("PlatformBusinessChangeRecord",BUSINESSCHANGE); // 工商变更
        put("platformGradeSummary",GRADESUMMARY); // 平台评级
		put("userForbid",USERFORBID);    // 用户禁止
	}};

}
