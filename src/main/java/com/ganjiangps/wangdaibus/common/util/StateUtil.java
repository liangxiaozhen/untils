package com.ganjiangps.wangdaibus.common.util;


public class StateUtil {
	
	//平台运营状态
	public static String getoperatingstatus(int no){
		String status = null;
		switch (no) {
			case 1:	status = "正常";	break;
			case 2:	status = "失联";	break;
			case 3:	status = "清盘";	break;
			case 4:	status = "高风险";break;
			case 5:	status = "有争议";break;
			case 6:	status = "逾期";	break;
			default:break;
		}
		return status;
	}
	
	
	
	
	
}
