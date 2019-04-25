package com.ganjiangps.wangdaibus.common.util;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
public class RealNameAuthenticationUtil {
	
	
	/**
	 * 获取凭证
	 * @param @return
	 * @return String
	 * @author jiangxueyou
	 */
	public static String getToken(){
		 String endpoint="http://opensdk.emay.cn:9080/HD_GetAccess_Token.asmx";  
		  
	        Call call;   
	        String res = "";  
	        Service service = new Service();  
	        try {  
	            call = (Call)service.createCall();  
	            call.setTargetEndpointAddress(new java.net.URL(endpoint));  
	            call.setOperationName(new QName("http://tempuri.org/","GetACCESS_TOKEN"));  
	            call.addParameter(new QName("http://tempuri.org/", "AppID"), org.apache.axis.encoding.XMLType.XSD_STRING,ParameterMode.IN);  
	            call.addParameter(new QName("http://tempuri.org/", "AppSecret"), org.apache.axis.encoding.XMLType.XSD_STRING,ParameterMode.IN);  
	            call.addParameter(new QName("http://tempuri.org/", "Key"), org.apache.axis.encoding.XMLType.XSD_STRING,ParameterMode.IN);  
	            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);  
	            call.setUseSOAPAction(true);  
	            call.setSOAPActionURI("http://tempuri.org/GetACCESS_TOKEN");  
	            String AppID="3AA798E0WC130W4D36WA97FW158CE0479B60";
	            String AppSecret="263FC300L3640L47F8L83D9L99F9335B39BB";
	            String Key="336564FEH860AH4277H928DHA7C244F8B523";
				res =(String)call.invoke(new Object[]{AppID,AppSecret,Key});  
	            System.err.println("==11=>"+res);  
	        } catch (ServiceException e) {  
	            e.printStackTrace();  
	        } catch (MalformedURLException e) {  
	            e.printStackTrace();  
	        } catch (RemoteException e) {  
	            e.printStackTrace();  
	        }catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        finally {  
	        }  
		
		
		
		return res;
		
	}
	
	/**
	 * 实名认证发送请求,返回结果
	 * @param @param name  真实姓名
	 * @param @param idcard 身份证号
	 * @param @param ACCESS_TOKEN 凭证
	 * @param @return
	 * @return String
	 * @author jiangxueyou
	 */
	public static String realNameAuth(String name,String idcard,String ACCESS_TOKEN){
		String endpoint="http://opensdk.emay.cn:9080/SF_YZ_API/SF_YH_Service.asmx";  
		  
        Call call;   
        String res = "";  
        Service service = new Service();  
        try {  
            call = (Call)service.createCall();  
            call.setTargetEndpointAddress(new java.net.URL(endpoint));  
            call.setOperationName(new QName("http://tempuri.org/","Get_EMW_GetIdcardRealName_RZ"));  
            call.addParameter(new QName("http://tempuri.org/", "name"), org.apache.axis.encoding.XMLType.XSD_STRING,ParameterMode.IN);  
            call.addParameter(new QName("http://tempuri.org/", "idcard"), org.apache.axis.encoding.XMLType.XSD_STRING,ParameterMode.IN);  
            call.addParameter(new QName("http://tempuri.org/", "ACCESS_TOKEN"), org.apache.axis.encoding.XMLType.XSD_STRING,ParameterMode.IN); 
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);  
            call.setUseSOAPAction(true);  
            call.setSOAPActionURI("http://tempuri.org/Get_EMW_GetIdcardRealName_RZ");  
			res =(String)call.invoke(new Object[]{name,idcard,ACCESS_TOKEN});  
			
            System.err.println("==11=>"+res); 
            
        } catch (ServiceException e) {  
            e.printStackTrace();  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (RemoteException e) {  
            e.printStackTrace();  
        }catch (Exception e) {  
            e.printStackTrace();  
        }  
        finally {  
        }
		return res;  
	}
	
	/**
	 * 银行四要素校验
	 * @param @param name  真实姓名
	 * @param @param idcard 身份证号
	 * @param @param cardNo 银行卡卡号
	 * @param @param phone  银行预留手机号码
	 * @param @param ACCESS_TOKEN  凭证
	 * @param @return
	 * @return String
	 * @author jiangxueyou
	 */
	
	public static String cardMatching(Map<String,String> map){
		String endpoint="http://opensdk.emay.cn:9080/SF_YZ_API/SFService.asmx";  
		String name = map.get("name");
		String idcard = map.get("idcard");
		String cardNo = map.get("cardNo");
		String phone = map.get("phone");
		String ACCESS_TOKEN = map.get("ACCESS_TOKEN");
		
        Call call;   
        String res = "";  
        Service service = new Service();  
        try {  
            call = (Call)service.createCall();  
            call.setTargetEndpointAddress(new java.net.URL(endpoint));  
            call.setOperationName(new QName("http://tempuri.org/","Get_EMW_GetBank_Card_Four_RZ"));  
            call.addParameter(new QName("http://tempuri.org/", "name"), org.apache.axis.encoding.XMLType.XSD_STRING,ParameterMode.IN);  
            call.addParameter(new QName("http://tempuri.org/", "idcard"), org.apache.axis.encoding.XMLType.XSD_STRING,ParameterMode.IN);  
            call.addParameter(new QName("http://tempuri.org/", "cardNo"), org.apache.axis.encoding.XMLType.XSD_STRING,ParameterMode.IN);  
            call.addParameter(new QName("http://tempuri.org/", "phone"), org.apache.axis.encoding.XMLType.XSD_STRING,ParameterMode.IN);  
            call.addParameter(new QName("http://tempuri.org/", "ACCESS_TOKEN"), org.apache.axis.encoding.XMLType.XSD_STRING,ParameterMode.IN); 
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);  
            call.setUseSOAPAction(true);  
            call.setSOAPActionURI("http://tempuri.org/Get_EMW_GetBank_Card_Four_RZ");  
			res =(String)call.invoke(new Object[]{name,idcard,cardNo,phone,ACCESS_TOKEN});  
			
            System.err.println("==11=>"+res); 
            
        } catch (ServiceException e) {  
            e.printStackTrace();  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (RemoteException e) {  
            e.printStackTrace();  
        }catch (Exception e) {  
            e.printStackTrace();  
        }  
        finally {  
        }  
        return res;
	}

}
