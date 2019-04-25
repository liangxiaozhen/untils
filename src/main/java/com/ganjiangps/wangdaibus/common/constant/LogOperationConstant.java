package com.ganjiangps.wangdaibus.common.constant;

import java.util.HashMap;
import java.util.Map;

public class LogOperationConstant {
	
	//状态
	public static final String STATUS_SECUSS ="1"; //成功
	public static final String STATUS_FAIL ="0"; //失败
	
	//业务类型
	public static final Integer BIZTYPE_ADD =1; //添加
	public static final Integer BIZTYPE_UPDATE =2; //修改
	public static final Integer BIZTYPE_DELETE =3; //删除
	public static final Integer BIZTYPE_SELECT =4; //查询
	public static final Integer BIZTYPE_OTHER =5; //其他
	
	
	
	public static final Map<Integer,String> BIZTYPEMAP=new HashMap<Integer,String>(){{
        put(BIZTYPE_ADD,"添加");
        put(BIZTYPE_UPDATE,"修改");
        put(BIZTYPE_DELETE,"删除");
        put(BIZTYPE_SELECT,"查询");
        put(BIZTYPE_OTHER,"其他");
	}};

	
	//用户类型
	public static final String USERTYPE_ADMIN ="1"; //管理员
	public static final String USERTYPE_AVERAGEUSER ="2"; //普通用户

}
