package com.ganjiangps.wangdaibus.common.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Dom4jForXMLUtils {
	//DOM4j解析XML   
    public static HashMap<String,String> parse(String protocolXML) {   
        try {
        	HashMap<String,String> hashMap = new HashMap<String,String>();

            Document doc=(Document)DocumentHelper.parseText(protocolXML);   
            Element books = doc.getRootElement();   
//            System.out.println("根节点"+books.getName());   
//            Iterator users_subElements = books.elementIterator("name");//指定获取那个元素   
            
            Iterator  Elements = books.elementIterator();    
            while(Elements.hasNext()){   
               Element user = (Element)Elements.next();
//             System.out.println("节点"+user.getName()+"\ttext="+user.getText());   
               if(user.getName()!=null && !"".equals(user.getName())){
            	   hashMap.put(user.getName(), user.getText());
               }    
//               List subElements = user.elements("username");//指定获取那个元素 
               List  subElements = user.elements(); 
//	           System.out.println("size=="+subElements.size());

	           for( int i=0;i<subElements.size();i++){   
	             Element ele = (Element)subElements.get(i); 
	             if(ele.getName()!=null && !"".equals(ele.getName())){
	            	 hashMap.put(ele.getName(), ele.getText()); 
	             }
	             List subElemts1 = ele.elements();
	             for( int j=0;j<subElemts1.size();j++){
	            	 Element ele1 = (Element)subElemts1.get(j); 
	            	 if(ele1.getName()!=null && !"".equals(ele1.getName())){
	            		 hashMap.put(ele1.getName(), ele1.getText());
	            	 }
	            	 List subElemts2 = ele1.elements();
	            	 for( int k=0;k<subElemts2.size();k++){
	            		 Element ele2 = (Element)subElemts2.get(k); 
	            		 if(ele2.getName()!=null && !"".equals(ele2.getName())){
	            			 hashMap.put(ele2.getName(), ele2.getText());
	            		 }
//	            		 System.out.println(ele2.getName()+"= "+ele2.getText()+" ");
	            	 }
//	            	 System.out.println(ele1.getName()+"= "+ele1.getText()+" ");
	             }
//	             System.out.println("--"+ele.getName()+"---"+"="+"---"+ele.getText()+"--- ");
	                
	           }   
               //System.out.println();   
           } 
           return hashMap;
        } catch (Exception e) {   
            e.printStackTrace();   
        }
		return null;           
    }   

    
  //DOM4j解析XML   
    public static List<HashMap<String,String>> parse1(String protocolXML) {   
        try {
        	List<HashMap<String,String>> hasMap = new ArrayList<>();
             Document doc=(Document)DocumentHelper.parseText(protocolXML);   
            Element books = doc.getRootElement();   
//            System.out.println("根节点"+books.getName());   
//            Iterator users_subElements = books.elementIterator("name");//指定获取那个元素   
            
            Iterator  Elements = books.elementIterator();    
            while(Elements.hasNext()){ 
                HashMap<String,String> hashMap = new HashMap<String,String>();
               Element user = (Element)Elements.next();
//             System.out.println("节点"+user.getName()+"\ttext="+user.getText());   
               if(user.getName()!=null && !"".equals(user.getName())){
            	   hashMap.put(user.getName(), user.getText());
               }    
//               List subElements = user.elements("username");//指定获取那个元素 
               List  subElements = user.elements(); 
//	           System.out.println("size=="+subElements.size());

	           for( int i=0;i<subElements.size();i++){   
	             Element ele = (Element)subElements.get(i); 
	             if(ele.getName()!=null && !"".equals(ele.getName())){
	            	 hashMap.put(ele.getName(), ele.getText()); 
	             }
	             List subElemts1 = ele.elements();
	             for( int j=0;j<subElemts1.size();j++){
	            	 Element ele1 = (Element)subElemts1.get(j); 
	            	 if(ele1.getName()!=null && !"".equals(ele1.getName())){
	            		 hashMap.put(ele1.getName(), ele1.getText());
	            	 }
	            	 List subElemts2 = ele1.elements();
	            	 for( int k=0;k<subElemts2.size();k++){
	            		 Element ele2 = (Element)subElemts2.get(k); 
	            		 if(ele2.getName()!=null && !"".equals(ele2.getName())){
	            			 hashMap.put(ele2.getName(), ele2.getText());
	            		 }
//	            		 System.out.println(ele2.getName()+"= "+ele2.getText()+" ");
	            	 }
//	            	 System.out.println(ele1.getName()+"= "+ele1.getText()+" ");
	             }
//	             System.out.println("--"+ele.getName()+"---"+"="+"---"+ele.getText()+"--- ");
	                
	           }   
               //System.out.println();  
	           hasMap.add(hashMap);
           } 
           return hasMap;
        } catch (Exception e) {   
            e.printStackTrace();   
        }
		return null;           
    }


	//DOM4j解析XML---充值勾兑
	public static HashMap<String,String> parseRechargeBlend(String protocolXML) {
		try {
			HashMap<String,String> hashMap = new HashMap<String,String>();

			Document doc=(Document)DocumentHelper.parseText(protocolXML);
			Element books = doc.getRootElement();
//            System.out.println("根节点"+books.getName());
//            Iterator users_subElements = books.elementIterator("name");//指定获取那个元素

			Iterator  Elements = books.elementIterator();
			while(Elements.hasNext()){
				Element user = (Element)Elements.next();
//              System.out.println("节点"+user.getName()+"\ttext="+user.getText());

				//attributeValue---获取一个元素的属性
				//查询结果---1、查询成功 2、商户号不存在 3、MD5验证不正确 4、日期格式不正确
				String ResultCode = user.attributeValue("ResultCode");
				if(user.getName()!=null && !"".equals(user.getName()) && ResultCode!=null && !"".equals(ResultCode)){
					hashMap.put("ResultCode", ResultCode);
				}
				//查询结果信息
				String message = user.attributeValue("message");
				if(user.getName()!=null && !"".equals(user.getName()) && message!=null && !"".equals(message)){
					hashMap.put("message", message);
				}
				//订单状态---0、失败 1、成功 2、待处理 3	、取消 4、结果未返回
				String State = user.attributeValue("State");
				if(user.getName()!=null && !"".equals(user.getName()) && State!=null && !"".equals(State)){
					hashMap.put("State", State);
				}
				//充值金额
				String amount = user.attributeValue("amount");
				if(user.getName()!=null && !"".equals(user.getName()) && amount!=null && !"".equals(amount)){
					hashMap.put("amount", amount);
				}

				//List subElements = user.elements("username");//指定获取那个元素
				List  subElements = user.elements();
//	           System.out.println("size=="+subElements.size());

				for( int i=0;i<subElements.size();i++){
					Element ele = (Element)subElements.get(i);
					//查询结果---1、查询成功 2、商户号不存在 3、MD5验证不正确 4、日期格式不正确
					String ResultCode2 = ele.attributeValue("ResultCode");
					if(ele.getName()!=null && !"".equals(ele.getName()) && ResultCode2!=null && !"".equals(ResultCode2)){
						hashMap.put("ResultCode", ResultCode2);
					}
					//查询结果信息
					String message2 = ele.attributeValue("message");
					if(ele.getName()!=null && !"".equals(ele.getName()) && message2!=null && !"".equals(message2)){
						hashMap.put("message", message2);
					}
					//订单状态---0、失败 1、成功 2、待处理 3	、取消 4、结果未返回
					String State2 = ele.attributeValue("State");
					if(ele.getName()!=null && !"".equals(ele.getName()) && State2!=null && !"".equals(State2)){
						hashMap.put("State", State2);
					}
					//充值金额
					String amount2 = ele.attributeValue("amount");
					if(ele.getName()!=null && !"".equals(ele.getName()) && amount2!=null && !"".equals(amount2)){
						hashMap.put("amount", amount2);
					}

					List subElemts1 = ele.elements();
					for( int j=0;j<subElemts1.size();j++){
						Element ele1 = (Element)subElemts1.get(j);
						//查询结果---1、查询成功 2、商户号不存在 3、MD5验证不正确 4、日期格式不正确
						String ResultCode3 = ele1.attributeValue("ResultCode");
						if(ele1.getName()!=null && !"".equals(ele1.getName()) && ResultCode3!=null && !"".equals(ResultCode3)){
							hashMap.put("ResultCode", ResultCode3);
						}
						//查询结果信息
						String message3 = ele1.attributeValue("message");
						if(ele1.getName()!=null && !"".equals(ele1.getName()) && message3!=null && !"".equals(message3)){
							hashMap.put("message", message3);
						}
						//订单状态---0、失败 1、成功 2、待处理 3	、取消 4、结果未返回
						String State3 = ele1.attributeValue("State");
						if(ele1.getName()!=null && !"".equals(ele1.getName()) && State3!=null && !"".equals(State3)){
							hashMap.put("State", State3);
						}
						//充值金额
						String amount3 = ele1.attributeValue("amount");
						if(ele1.getName()!=null && !"".equals(ele1.getName()) && amount3!=null && !"".equals(amount3)){
							hashMap.put("amount", amount3);
						}
					}
				}
			}
			return hashMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public static void main(String[] args) {
		Dom4jForXMLUtils xml = new Dom4jForXMLUtils();
		//String tranDataStr = "<?xml  version=\"1.0\" encoding=\"GBK\" standalone=\"no\" ?><B2CRes><interfaceName>ICBC_PERBANK_B2C</interfaceName><interfaceVersion>1.0.0.3</interfaceVersion><orderInfo><orderDate>20070725105014</orderDate><orderid>20070725105014-2134062548</orderid><amount>20</amount><curType>001</curType><merID>0200EC20000875</merID><merAcct>0200020409015029130</merAcct></orderInfo><custom><verifyJoinFlag>0</verifyJoinFlag><JoinFlag></JoinFlag><UserNum></UserNum></custom><bank><TranSerialNo></TranSerialNo><notifyDate>20070725110400</notifyDate><tranStat>1</tranStat><comment>交易成功！</comment></bank></B2CRes>";
		String tranDataStr = "<?xml version=\"1.0\" encoding=\"utf-8\"?><Epay95><MerInfo MerNo=\"168885\" BillNo=\"C20180330203135919624\" message=\"查询成功\" ResultCode=\"1\" OrderNUM=\"1\"><OrderInfo BillNo=\"C20180330203135919624\" OrderNo=\"168885183302031373030188\" bankOrderNo=\"4200000055201803308661018932\" amount=\"0.02\" Date=\"2018-03-30 20:31:37.0\" State=\"1\" IsSettlement=\"1\" MD5ResultInfo=\"662A8EC6EB37CF7758741A9094C54A4D\" remark=\"交易成功\"/></MerInfo></Epay95>";
		xml.parseRechargeBlend(tranDataStr);
		HashMap<String,String> map = xml.parseRechargeBlend(tranDataStr);
		System.out.println(map);
		System.out.println(map.get("ResultCode"));
		System.out.println(map.get("State"));
	}

}
