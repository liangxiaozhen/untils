package com.ganjiangps.wangdaibus.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONObject;

import net.sf.json.JSONException;

public class AddressUtils {
	public static String getAddrName(String ip){
        String address = "";
		try {
			if(StringUtil.isEmpty(ip)){
				return "";
			}
			//这里调用百度的ip定位api服务 详见 http://api.map.baidu.com/lbsapi/cloud/ip-location-api.htm
			JSONObject json = readJsonFromUrl("http://api.map.baidu.com/location/ip?ak=iTrwV0ddxeFT6QUziPQh2wgGofxmWkmg&ip="+ip);
			System.out.println(json.toString());
			JSONObject content=json.getJSONObject("content");              //获取json对象里的content对象
			JSONObject addr_detail=content.getJSONObject("address_detail");//从content对象里获取address_detail
			String city = addr_detail.get("city").toString();//获取市名，可以根据具体需求更改，如果需要获取省份的名字，可以把“city”改成“province”...
			String sheng = addr_detail.get("province").toString();//获取市名，可以根据具体需求更改，如果需要获取省份的名字，可以把“city”改成“province”...
			address = sheng+city;
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (org.json.JSONException e) {
			e.printStackTrace();
		}                
        return address;
    }
	
	public static JSONObject readJsonFromUrl(String url){
        InputStream is = null;
        JSONObject json = null;
        try {
			try {
				is = new URL(url).openStream();
				BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				String jsonText = readAll(rd);
				json = new JSONObject(jsonText);
			} catch (IOException | org.json.JSONException e) {
				e.printStackTrace();
			}
        } finally {
            //关闭输入流
            try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        return json;
	}
	
  private static String readAll(Reader rd){
       StringBuilder sb = new StringBuilder();
       int cp;
       try {
		while ((cp = rd.read()) != -1) {
		       sb.append((char) cp);
		   }
		} catch (IOException e) {
			e.printStackTrace();
		}
       return sb.toString();
   }
    
 
 public static void main(String[] args) throws IOException, JSONException, org.json.JSONException {
     System.out.println(getAddrName("60.6.228.34"));
 }


}
