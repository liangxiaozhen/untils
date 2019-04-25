package com.ganjiangps.wangdaibus.common.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

/**
 * 阿里 实名 、银行4要素认证
 * @author Administrator
 *
 */
public class RealNameAlicloudApi {
	
	public static void main(String[] args) {
		Map<String, String> bodys = new HashMap<String, String>();
	    bodys.put("ReturnBankInfo", "YES");
	    bodys.put("cardNo", "6228480129939041478");
	    bodys.put("idNo", "429001198708220420");
	    bodys.put("name", "张凡");
	    bodys.put("phoneNo", "18588445031");
	    
		//RealNameAlicloudApi.realNameAuthResult4(bodys);
		RealNameAlicloudApi.realNameAuth(bodys);
	}
	
	
	//银行4要素认证
	public static Map<String, String> realNameAuthResult4(Map<String, String> bodys){
		String result = "";
		String host = "https://yunyidata.market.alicloudapi.com";
	    String path = "/bankAuthenticate4";
	    String method = "POST";
	    String appcode = "3fa72a89fc164fe5a6272d0bf45b0e6a";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    //根据API的要求，定义相对应的Content-Type
	    headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
	    Map<String, String> querys = new HashMap<String, String>();
	    
	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpAliApiUtils.doPost(host, path, method, headers, querys, bodys);
	    	//获取response的body
	    	result = EntityUtils.toString(response.getEntity());
//	    	result = "{\"name\": \"张三\",\"cardNo\": \"6225756663322156\",\"idNo\": \"34042158962596321\",\"phoneNo\": \"13699995555\",\"respMessage\": \"结果匹配\",\"respCode\": \"0000\",\"bankName\": \"招商银行\",\"bankKind\": \"招商银行信用卡\",\"bankType\": \"信用卡\",\"bankCode\": \"CMB\"}";
	    	querys = JsonUtil.parseStringMap(result);
	    	System.out.println("querys==============================="+querys);
	    	/** 
	    	    respCode 	respMessage
	    	    0000	   	 结果匹配	
		    	0001		开户名不能为空	
		    	0002		银行卡号格式错误
		    	0003		身份证号格式错误
		    	0004		手机号不能为空
		    	0005		手机号格式错误
		    	0006		银行卡号不能为空
		    	0007		身份证号不能为空
		    	0008		信息不匹配
	    	*/
	    	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return querys;
	}
	
	//实名认证
	public static Map<String, String> realNameAuth(Map<String, String> bodys){
		String result = "";
		String host = "https://idenauthen.market.alicloudapi.com";
	    String path = "/idenAuthentication";
	    String method = "POST";
	    String appcode = "3fa72a89fc164fe5a6272d0bf45b0e6a";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    //根据API的要求，定义相对应的Content-Type
	    headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
	    Map<String, String> querys = new HashMap<String, String>();


	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpAliApiUtils.doPost(host, path, method, headers, querys, bodys);
	    	//获取response的body
	    	result = EntityUtils.toString(response.getEntity());
	    	querys = JsonUtil.parseStringMap(result);
	    	System.out.println("querys==============================="+querys);
	    	/**
	    	  respCode 	respMessage 
	    	    0000	身份证信息匹配
				0001	开户名不能为空
				0002	开户名不能包含特殊字符
				0003	身份证号不能为空
				0004	身份证号格式错误
				0007	无此身份证号码
				0008	身份证信息不匹配
	    	 * 
	    	 */
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return querys;
	}
	
}
