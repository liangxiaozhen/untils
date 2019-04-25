package com.ganjiangps.wangdaibus.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
  * 收支记录常量类
  * @author :liuqh
  * @date :2017/12/29 14:11
  */
public class UserInExRecord_Constant {
    /**
     *
     */
	//1.充值
    public static final int RECHARGE=1;
	
	//2.提现
    public static final int WITHDRAWALS=2;

    //3.推荐注册
    public static final int RECOMMENDEDREGISTRATION=3;

    //4.红包领取
    public static final int PREDENVELOPE=4;

    //5.红包帖充值
    public static final int REDPACKETRECHARGE=5;

    //6.红包支出
    public static final int REDPACKETFORUM=6;

    //7.充值手续费
    public static final int RECHARGEFEE=7;

    //8.提现手续费
    public static final int WITHDRAWALSFEE=8;

    //9.预约扣款
    public static final int PREORDERFEE=9;

    //11.手扣余额
    public static final int BUCKLEAMOUNT=11;

    //14.手动充值
    public static final int MANUALRECHARGE=14;

    //15.押金退款
    public static final int DEPOSITREFUND=15;

    //16.打赏
    public static final int REWARD=16;

    //17.广告购买
    public static final int ADBUSPLAY=17;

    //18 申报清算
    public static final int LIQUIDATIONRECORD=18;
    
    public static Map<Integer,String> TYPEMAP=new HashMap<>();

    static {
        TYPEMAP.put(RECOMMENDEDREGISTRATION,"推荐注册");
        TYPEMAP.put(PREDENVELOPE,"红包领取");
        TYPEMAP.put(REDPACKETRECHARGE,"红包帖充值");
        TYPEMAP.put(REDPACKETFORUM,"红包支出");
        TYPEMAP.put(WITHDRAWALS,"提现");
        TYPEMAP.put(RECHARGE,"充值");
        TYPEMAP.put(RECHARGEFEE,"充值手续费");
        TYPEMAP.put(WITHDRAWALSFEE,"提现手续费");
        TYPEMAP.put(PREORDERFEE,"预约扣款");
        TYPEMAP.put(BUCKLEAMOUNT,"手动扣款");
        TYPEMAP.put(MANUALRECHARGE,"余额手充");
        TYPEMAP.put(DEPOSITREFUND,"押金退款");
        TYPEMAP.put(REWARD,"打赏");
        TYPEMAP.put(ADBUSPLAY,"广告购买");
        TYPEMAP.put(LIQUIDATIONRECORD,"申报清算");
    }

}
