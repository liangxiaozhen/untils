package com.ganjiangps.wangdaibus.common.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class BankUtil {
	
	
	public static String getBankCode(String cardno){
		
		String str = "https://ccdcapi.alipay.com/validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo="+cardno+"&cardBinCheck=true";
		Map<String,String> HttpClHashMap = new HashMap<>();
		String result = "";
		try {
			result = doPost(HttpClHashMap, str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static Map<String,String> getBankMap(String cardno){
		Map<String,String> map = new  HashMap<String,String>();
		String result = getBankCode(cardno);
		System.out.println(result);
	    JSONObject json = JSONObject.fromObject(result);  
	    System.out.println("json数据： " + json);  
	    //{"bank":"SPABANK","validated":true,"cardType":"CC","key":"1513825506624-3771-11.145.199.40-1813522140","messages":[],"stat":"ok"}
	    String bank = json.get("bank").toString();  
	    String cardType = json.get("cardType").toString();  
	    map.put("bank", bank);
	    map.put("cardType", cardType);
	    return map;
	}
	
	public static void main(String[] args) {
		Map<String,String> map = getBankMap("6217566100027798725");
		String bankcode = map.get("bank"); //获取到银行简称  比如ICBC 
		
		//根据ICBC  获取 银行编码 比如1001
		String bankNum = BankUtil.BANK_MAP_CODE.get(bankcode);
		System.out.println(bankNum);
	}
		 // 如果关注性能问题可以考虑使用HttpClientConnectionManager
	   	public static String doPost(Map<String, String> params,String httpUrl) throws ClientProtocolException, IOException{
	   		String result = null;
	   		HttpPost httpPost = new HttpPost(httpUrl);
	   		CloseableHttpClient httpclient = HttpClients.createDefault();
	   		if (params != null)
	   		{
	   			UrlEncodedFormEntity formEntiry = HttpClientHandler.buildUrlEncodedFormEntity(params);
	   			httpPost.setEntity(formEntiry);
	   			CloseableHttpResponse response = httpclient.execute(httpPost);
	   			try
	   			{
	   				HttpEntity entity = response.getEntity();
	   				if (response.getStatusLine().getReasonPhrase().equals("OK") && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
	   					result = EntityUtils.toString(entity, "UTF-8");
	   				    EntityUtils.consume(entity);
	   			} finally
	   			{
	   				response.close();
	   			}
	   		}
	   		return result;
	   	}
	public static Map<String, String> BANK_MAP;
	static
	{
		BANK_MAP = new HashMap<String, String>();
		BANK_MAP.put("SRCB", "深圳农村商业银行");
		BANK_MAP.put("BGB", "广西北部湾银行");
		BANK_MAP.put("SHRCB", "上海农村商业银行");
		BANK_MAP.put("BJBANK", "北京银行");
		BANK_MAP.put("WHCCB", "威海市商业银行");
		BANK_MAP.put("BOZK", "周口银行");
		BANK_MAP.put("KORLABANK", "库尔勒市商业银行");
		BANK_MAP.put("SPABANK", "平安银行");
		BANK_MAP.put("SDEB", "顺德农商银行");
		BANK_MAP.put("HURCB", "湖北省农村信用社");
		BANK_MAP.put("WRCB", "无锡农村商业银行");
		BANK_MAP.put("BOCY", "朝阳银行");
		BANK_MAP.put("CZBANK", "浙商银行");
		BANK_MAP.put("HDBANK", "邯郸银行");
		BANK_MAP.put("BOC", "中国银行");
		BANK_MAP.put("BOD", "东莞银行");
		BANK_MAP.put("CCB", "中国建设银行");
		BANK_MAP.put("ZYCBANK", "遵义市商业银行");
		BANK_MAP.put("SXCB", "绍兴银行");
		BANK_MAP.put("GZRCU", "贵州省农村信用社");
		BANK_MAP.put("ZJKCCB", "张家口市商业银行");
		BANK_MAP.put("BOJZ", "锦州银行");
		BANK_MAP.put("BOP", "平顶山银行");
		BANK_MAP.put("HKB", "汉口银行");
		BANK_MAP.put("SPDB", "上海浦东发展银行");
		BANK_MAP.put("NXRCU", "宁夏黄河农村商业银行");
		BANK_MAP.put("NYNB", "广东南粤银行");
		BANK_MAP.put("GRCB", "广州农商银行");
		BANK_MAP.put("BOSZ", "苏州银行");
		BANK_MAP.put("HZCB", "杭州银行");
		BANK_MAP.put("HSBK", "衡水银行");
		BANK_MAP.put("HBC", "湖北银行");
		BANK_MAP.put("JXBANK", "嘉兴银行");
		BANK_MAP.put("HRXJB", "华融湘江银行");
		BANK_MAP.put("BODD", "丹东银行");
		BANK_MAP.put("AYCB", "安阳银行");
		BANK_MAP.put("EGBANK", "恒丰银行");
		BANK_MAP.put("CDB", "国家开发银行");
		BANK_MAP.put("TCRCB", "江苏太仓农村商业银行");
		BANK_MAP.put("NJCB", "南京银行");
		BANK_MAP.put("ZZBANK", "郑州银行");
		BANK_MAP.put("DYCB", "德阳商业银行");
		BANK_MAP.put("YBCCB", "宜宾市商业银行");
		BANK_MAP.put("SCRCU", "四川省农村信用");
		BANK_MAP.put("KLB", "昆仑银行");
		BANK_MAP.put("LSBANK", "莱商银行");
		BANK_MAP.put("YDRCB", "尧都农商行");
		BANK_MAP.put("CCQTGB", "重庆三峡银行");
		BANK_MAP.put("FDB", "富滇银行");
		BANK_MAP.put("JSRCU", "江苏省农村信用联合社");
		BANK_MAP.put("JNBANK", "济宁银行");
		BANK_MAP.put("CMB", "招商银行");
		BANK_MAP.put("JINCHB", "晋城银行JCBANK");
		BANK_MAP.put("FXCB", "阜新银行");
		BANK_MAP.put("WHRCB", "武汉农村商业银行");
		BANK_MAP.put("HBYCBANK", "湖北银行宜昌分行");
		BANK_MAP.put("TZCB", "台州银行");
		BANK_MAP.put("TACCB", "泰安市商业银行");
		BANK_MAP.put("XCYH", "许昌银行");
		BANK_MAP.put("CEB", "中国光大银行");
		BANK_MAP.put("NXBANK", "宁夏银行");
		BANK_MAP.put("HSBANK", "徽商银行");
		BANK_MAP.put("JJBANK", "九江银行");
		BANK_MAP.put("NHQS", "农信银清算中心");
		BANK_MAP.put("MTBANK", "浙江民泰商业银行");
		BANK_MAP.put("LANGFB", "廊坊银行");
		BANK_MAP.put("ASCB", "鞍山银行");
		BANK_MAP.put("KSRB", "昆山农村商业银行");
		BANK_MAP.put("YXCCB", "玉溪市商业银行");
		BANK_MAP.put("DLB", "大连银行");
		BANK_MAP.put("DRCBCL", "东莞农村商业银行");
		BANK_MAP.put("GCB", "广州银行");
		BANK_MAP.put("NBBANK", "宁波银行");
		BANK_MAP.put("BOYK", "营口银行");
		BANK_MAP.put("SXRCCU", "陕西信合");
		BANK_MAP.put("GLBANK", "桂林银行");
		BANK_MAP.put("BOQH", "青海银行");
		BANK_MAP.put("CDRCB", "成都农商银行");
		BANK_MAP.put("QDCCB", "青岛银行");
		BANK_MAP.put("HKBEA", "东亚银行");
		BANK_MAP.put("HBHSBANK", "湖北银行黄石分行");
		BANK_MAP.put("WZCB", "温州银行");
		BANK_MAP.put("TRCB", "天津农商银行");
		BANK_MAP.put("QLBANK", "齐鲁银行");
		BANK_MAP.put("GDRCC", "广东省农村信用社联合社");
		BANK_MAP.put("ZJTLCB", "浙江泰隆商业银行");
		BANK_MAP.put("GZB", "赣州银行");
		BANK_MAP.put("GYCB", "贵阳市商业银行");
		BANK_MAP.put("CQBANK", "重庆银行");
		BANK_MAP.put("DAQINGB", "龙江银行");
		BANK_MAP.put("CGNB", "南充市商业银行");
		BANK_MAP.put("SCCB", "三门峡银行");
		BANK_MAP.put("CSRCB", "常熟农村商业银行");
		BANK_MAP.put("SHBANK", "上海银行");
		BANK_MAP.put("JLBANK", "吉林银行");
		BANK_MAP.put("CZRCB", "常州农村信用联社");
		BANK_MAP.put("BANKWF", "潍坊银行");
		BANK_MAP.put("ZRCBANK", "张家港农村商业银行");
		BANK_MAP.put("FJHXBC", "福建海峡银行");
		BANK_MAP.put("ZJNX", "浙江省农村信用社联合社");
		BANK_MAP.put("LZYH", "兰州银行");
		BANK_MAP.put("JSB", "晋商银行");
		BANK_MAP.put("BOHAIB", "渤海银行");
		BANK_MAP.put("CZCB", "浙江稠州商业银行");
		BANK_MAP.put("YQCCB", "阳泉银行");
		BANK_MAP.put("SJBANK", "盛京银行");
		BANK_MAP.put("XABANK", "西安银行");
		BANK_MAP.put("BSB", "包商银行");
		BANK_MAP.put("JSBANK", "江苏银行");
		BANK_MAP.put("FSCB", "抚顺银行");
		BANK_MAP.put("HNRCU", "河南省农村信用");
		BANK_MAP.put("COMM", "交通银行");
		BANK_MAP.put("XTB", "邢台银行");
		BANK_MAP.put("CITIC", "中信银行");
		BANK_MAP.put("HXBANK", "华夏银行");
		BANK_MAP.put("HNRCC", "湖南省农村信用社");
		BANK_MAP.put("DYCCB", "东营市商业银行");
		BANK_MAP.put("ORBANK", "鄂尔多斯银行");
		BANK_MAP.put("BJRCB", "北京农村商业银行");
		BANK_MAP.put("XYBANK", "信阳银行");
		BANK_MAP.put("ZGCCB", "自贡市商业银行");
		BANK_MAP.put("CDCB", "成都银行");
		BANK_MAP.put("HANABANK", "韩亚银行");
		BANK_MAP.put("CMBC", "中国民生银行");
		BANK_MAP.put("LYBANK", "洛阳银行");
		BANK_MAP.put("GDB", "广东发展银行");
		BANK_MAP.put("ZBCB", "齐商银行");
		BANK_MAP.put("CBKF", "开封市商业银行");
		BANK_MAP.put("H3CB", "内蒙古银行");
		BANK_MAP.put("CIB", "兴业银行");
		BANK_MAP.put("CRCBANK", "重庆农村商业银行");
		BANK_MAP.put("SZSBK", "石嘴山银行");
		BANK_MAP.put("DZBANK", "德州银行");
		BANK_MAP.put("SRBANK", "上饶银行");
		BANK_MAP.put("LSCCB", "乐山市商业银行");
		BANK_MAP.put("JXRCU", "江西省农村信用");
		BANK_MAP.put("ICBC", "中国工商银行");
		BANK_MAP.put("JZBANK", "晋中市商业银行");
		BANK_MAP.put("HZCCB", "湖州市商业银行");
		BANK_MAP.put("NHB", "南海农村信用联社");
		BANK_MAP.put("XXBANK", "新乡银行");
		BANK_MAP.put("JRCB", "江苏江阴农村商业银行");
		BANK_MAP.put("YNRCC", "云南省农村信用社");
		BANK_MAP.put("ABC", "中国农业银行");
		BANK_MAP.put("GXRCU", "广西省农村信用");
		BANK_MAP.put("PSBC", "中国邮政储蓄银行");
		BANK_MAP.put("BZMD", "驻马店银行");
		BANK_MAP.put("ARCU", "安徽省农村信用社");
		BANK_MAP.put("GSRCU", "甘肃省农村信用");
		BANK_MAP.put("LYCB", "辽阳市商业银行");
		BANK_MAP.put("JLRCU", "吉林农信");
		BANK_MAP.put("URMQCCB", "乌鲁木齐市商业银行");
		BANK_MAP.put("XLBANK", "中山小榄村镇银行");
		BANK_MAP.put("CSCB", "长沙银行");
		BANK_MAP.put("JHBANK", "金华银行");
		BANK_MAP.put("BHB", "河北银行");
		BANK_MAP.put("NBYZ", "鄞州银行");
		BANK_MAP.put("LSBC", "临商银行");
		BANK_MAP.put("BOCD", "承德银行");
		BANK_MAP.put("SDRCU", "山东农信");
		BANK_MAP.put("NCB", "南昌银行");
		BANK_MAP.put("TCCB", "天津银行");
		BANK_MAP.put("WJRCB", "吴江农商银行");
		BANK_MAP.put("CBBQS", "城市商业银行资金清算中心");
		BANK_MAP.put("HBRCU", "河北省农村信用社");
		}
	
	public static Map<String, String> BANK_MAP_SQ;
		static
		{
			BANK_MAP_SQ = new HashMap<String, String>();
			BANK_MAP_SQ.put("1001","中国工商银行");
			BANK_MAP_SQ.put("1002","中国农业银行");
			BANK_MAP_SQ.put("1003","中国银行");
			BANK_MAP_SQ.put("1004","中国建设银行");
			BANK_MAP_SQ.put("1005","交通银行");
			BANK_MAP_SQ.put("1006","中信银行");
			BANK_MAP_SQ.put("1007","中国光大银行");
			BANK_MAP_SQ.put("1008","华夏银行");
			BANK_MAP_SQ.put("1009","中国民生银行");
			BANK_MAP_SQ.put("1010","广发银行");
			BANK_MAP_SQ.put("1011","平安银行");
			BANK_MAP_SQ.put("1012","招商银行");
			BANK_MAP_SQ.put("1013","兴业银行");
			BANK_MAP_SQ.put("1014","上海浦东发展银行");
			BANK_MAP_SQ.put("1015","北京银行");
			BANK_MAP_SQ.put("1016","天津银行");
			BANK_MAP_SQ.put("1017","河北银行");
			BANK_MAP_SQ.put("1018","邯郸市商业银行");
			BANK_MAP_SQ.put("1019","邢台银行");
			BANK_MAP_SQ.put("1020","张家口商业银行");
			BANK_MAP_SQ.put("1021","承德银行");
			BANK_MAP_SQ.put("1022","沧州银行");
			BANK_MAP_SQ.put("1023","廊坊银行");
			BANK_MAP_SQ.put("1024","衡水银行");
			BANK_MAP_SQ.put("1025","晋商银行");
			BANK_MAP_SQ.put("1026","阳泉市商业银行");
			BANK_MAP_SQ.put("1027","晋城市商业银行");
			BANK_MAP_SQ.put("1028","内蒙古银行");
			BANK_MAP_SQ.put("1029","包商银行");
			BANK_MAP_SQ.put("1030","鄂尔多斯银行");
			BANK_MAP_SQ.put("1031","大连银行");
			BANK_MAP_SQ.put("1032","鞍山市商业银行");
			BANK_MAP_SQ.put("1033","锦州银行");
			BANK_MAP_SQ.put("1034","葫芦岛银行");
			BANK_MAP_SQ.put("1035","营口银行");
			BANK_MAP_SQ.put("1036","阜新银行");
			BANK_MAP_SQ.put("1037","吉林银行");
			BANK_MAP_SQ.put("1038","哈尔滨银行");
			BANK_MAP_SQ.put("1039","龙江银行");
			BANK_MAP_SQ.put("1040","上海银行");
			BANK_MAP_SQ.put("1041","南京银行");
			BANK_MAP_SQ.put("1042","江苏银行");
			BANK_MAP_SQ.put("1043","苏州银行");
			BANK_MAP_SQ.put("1044","江苏长江商业银行");
			BANK_MAP_SQ.put("1045","杭州银行");
			BANK_MAP_SQ.put("1046","宁波银行");
			BANK_MAP_SQ.put("1047","温州银行");
			BANK_MAP_SQ.put("1048","嘉兴银行");
			BANK_MAP_SQ.put("1049","湖州银行");
			BANK_MAP_SQ.put("1050","绍兴银行");
			BANK_MAP_SQ.put("1051","浙江稠州商业银行");
			BANK_MAP_SQ.put("1052","台州银行");
			BANK_MAP_SQ.put("1053","浙江泰隆商业银行");
			BANK_MAP_SQ.put("1054","浙江民泰商业银行");
			BANK_MAP_SQ.put("1055","福建海峡银行");
			BANK_MAP_SQ.put("1056","厦门银行");
			BANK_MAP_SQ.put("1057","南昌银行");
			BANK_MAP_SQ.put("1058","赣州银行");
			BANK_MAP_SQ.put("1059","上饶银行");
			BANK_MAP_SQ.put("1060","齐鲁银行");
			BANK_MAP_SQ.put("1061","青岛银行");
			BANK_MAP_SQ.put("1062","齐商银行");
			BANK_MAP_SQ.put("1063","东营市商业银行");
			BANK_MAP_SQ.put("1064","烟台银行");
			BANK_MAP_SQ.put("1065","潍坊银行");
			BANK_MAP_SQ.put("1066","济宁银行");
			BANK_MAP_SQ.put("1067","泰安市商业银行");
			BANK_MAP_SQ.put("1068","莱商银行");
			BANK_MAP_SQ.put("1069","威海市商业银行");
			BANK_MAP_SQ.put("1070","德州银行");
			BANK_MAP_SQ.put("1071","临商银行");
			BANK_MAP_SQ.put("1072","日照银行");
			BANK_MAP_SQ.put("1073","郑州银行");
			BANK_MAP_SQ.put("1074","开封市商业银行");
			BANK_MAP_SQ.put("1075","洛阳银行");
			BANK_MAP_SQ.put("1076","安阳银行");
			BANK_MAP_SQ.put("1077","许昌银行");
			BANK_MAP_SQ.put("1078","漯河市商业银行");
			BANK_MAP_SQ.put("1079","商丘市商业银行");
			BANK_MAP_SQ.put("1080","驻马店银行");
			BANK_MAP_SQ.put("1081","南阳银行");
			BANK_MAP_SQ.put("1082","汉口银行");
			BANK_MAP_SQ.put("1083","湖北银行");
			BANK_MAP_SQ.put("1084","华融湘江银行");
			BANK_MAP_SQ.put("1085","长沙银行");
			BANK_MAP_SQ.put("1086","广州银行");
			BANK_MAP_SQ.put("1087","珠海华润银行");
			BANK_MAP_SQ.put("1088","广东华兴银行");
			BANK_MAP_SQ.put("1089","广东南粤银行");
			BANK_MAP_SQ.put("1090","东莞银行");
			BANK_MAP_SQ.put("1091","广西北部湾银行");
			BANK_MAP_SQ.put("1092","柳州银行");
			BANK_MAP_SQ.put("1093","桂林银行");
			BANK_MAP_SQ.put("1094","成都银行");
			BANK_MAP_SQ.put("1095","重庆银行");
			BANK_MAP_SQ.put("1096","自贡市商业银行");
			BANK_MAP_SQ.put("1097","攀枝花市商业银行");
			BANK_MAP_SQ.put("1098","德阳银行");
			BANK_MAP_SQ.put("1099","绵阳市商业银行");
			BANK_MAP_SQ.put("1100","贵阳银行");
			BANK_MAP_SQ.put("1101","富滇银行");
			BANK_MAP_SQ.put("1102","长安银行");
			BANK_MAP_SQ.put("1103","兰州银行");
			BANK_MAP_SQ.put("1104","青海银行");
			BANK_MAP_SQ.put("1105","宁夏银行");
			BANK_MAP_SQ.put("1106","乌鲁木齐市商业银行");
			BANK_MAP_SQ.put("1107","昆仑银行");
			BANK_MAP_SQ.put("1108","新疆汇和银行");
			BANK_MAP_SQ.put("1109","江苏江阴农村商业银行");
			BANK_MAP_SQ.put("1110","昆山农村商业银行");
			BANK_MAP_SQ.put("1111","吴江农村商业银行");
			BANK_MAP_SQ.put("1112","常熟农村商业银行");
			BANK_MAP_SQ.put("1113","张家港农村商业银行");
			BANK_MAP_SQ.put("1114","广州农村商业银行");
			BANK_MAP_SQ.put("1115","顺德农村商业银行");
			BANK_MAP_SQ.put("1116","海口联合农村商业银行");
			BANK_MAP_SQ.put("1117","重庆农村商业银行");
			BANK_MAP_SQ.put("1118","恒丰银行");
			BANK_MAP_SQ.put("1119","浙商银行");
			BANK_MAP_SQ.put("1120","天津农商银行");
			BANK_MAP_SQ.put("1121","渤海银行");
			BANK_MAP_SQ.put("1122","徽商银行");
			BANK_MAP_SQ.put("1123","上海农商银行");
			BANK_MAP_SQ.put("1124","北京农村商业银行");
			BANK_MAP_SQ.put("1125","吉林农村信用社");
			BANK_MAP_SQ.put("1126","江苏省农村信用社联合社");
			BANK_MAP_SQ.put("1127","浙江省农村信用社");
			BANK_MAP_SQ.put("1128","鄞州银行");
			BANK_MAP_SQ.put("1129","安徽省农村信用社联合社");
			BANK_MAP_SQ.put("1130","福建省农村信用社");
			BANK_MAP_SQ.put("1131","山东省农联社");
			BANK_MAP_SQ.put("1132","湖北农信");
			BANK_MAP_SQ.put("1133","深圳农商行");
			BANK_MAP_SQ.put("1134","东莞农村商业银行");
			BANK_MAP_SQ.put("1135","广西农村信用社");
			BANK_MAP_SQ.put("1136","海南省农村信用社");
			BANK_MAP_SQ.put("1137","四川省农村信用社联合社");
			BANK_MAP_SQ.put("1138","云南省农村信用社");
			BANK_MAP_SQ.put("1139","陕西省农村信用社");
			BANK_MAP_SQ.put("1140","黄河农村商业银行");
			BANK_MAP_SQ.put("1141","中国邮政储蓄银行");
			BANK_MAP_SQ.put("1142","东亚银行");
			BANK_MAP_SQ.put("1143","外换银行");
			BANK_MAP_SQ.put("1144","友利银行");
			BANK_MAP_SQ.put("1145","新韩银行中国");
			BANK_MAP_SQ.put("1146","企业银行");
			BANK_MAP_SQ.put("1147","韩亚银行");
		}
		
		public static Map<String, String> BANK_MAP_CODE;
		static
		{
			BANK_MAP_CODE = new HashMap<String, String>();
			BANK_MAP_CODE.put("ICBC","1001");//中国工商银行
			BANK_MAP_CODE.put("ABC","1002");//中国农业
			BANK_MAP_CODE.put("BOC","1003");//中国银行
			BANK_MAP_CODE.put("CCB","1004");//中国建设银行
			BANK_MAP_CODE.put("COMM","1005");//交通
			BANK_MAP_CODE.put("CITIC","1006");//中信银行
			BANK_MAP_CODE.put("CEB","1007");//中国光大
			BANK_MAP_CODE.put("HXBANK","1008");//华夏
			BANK_MAP_CODE.put("CMBC","1009");//中国民生
			BANK_MAP_CODE.put("GDB","1010");//广发
			BANK_MAP_CODE.put("SPABANK","1011");//平安银行
			BANK_MAP_CODE.put("CMB","1012");//招商
			BANK_MAP_CODE.put("CIB","1013");//兴业
			BANK_MAP_CODE.put("SPDB","1014");//上海浦东发展银行
			BANK_MAP_CODE.put("BJBANK","1015");//北京银行
			BANK_MAP_CODE.put("TCCB","1016");//天津银行
			BANK_MAP_CODE.put("BHB","1017");//河北银行
			BANK_MAP_CODE.put("HDBANK","1018");//邯郸市商业银行
			BANK_MAP_CODE.put("XTB","1019");//邢台银行
			BANK_MAP_CODE.put("ZJKCCB","1020");//张家口商业银行
			BANK_MAP_CODE.put("BOCD","1021");//承德银行
			
			//BANK_MAP_CODE.put("","1022");//沧州银行
			
			BANK_MAP_CODE.put("LANGFB","1023");//廊坊银行
			BANK_MAP_CODE.put("HSBK","1024");//衡水银行
			BANK_MAP_CODE.put("JSB","1025");//晋商银行
			BANK_MAP_CODE.put("YQCCB","1026");//阳泉市商业银行
			BANK_MAP_CODE.put("JINCHB","1027");//晋城市商业银行
			BANK_MAP_CODE.put("H3CB","1028");//内蒙古银行
			BANK_MAP_CODE.put("BSB","1029");//包商银行
			BANK_MAP_CODE.put("ORBANK","1030");//鄂尔多斯银行
			BANK_MAP_CODE.put("DLB","1031");//大连银行
			BANK_MAP_CODE.put("ASCB","1032");//鞍山银行
			BANK_MAP_CODE.put("BOJZ","1033");//锦州银行
			
			//BANK_MAP_CODE.put("","1034");//葫芦岛银行
			
			BANK_MAP_CODE.put("BOYK","1035");//营口银行
			BANK_MAP_CODE.put("FXCB","1036");//阜新银行
			BANK_MAP_CODE.put("JLBANK","1037");//吉林银行
			BANK_MAP_CODE.put("HRBANK","1038");//哈尔滨银行
			BANK_MAP_CODE.put("DAQINGB","1039");//龙江银行
			BANK_MAP_CODE.put("SHBANK","1040");//上海银行
			BANK_MAP_CODE.put("NJCB","1041");//南京银行
			BANK_MAP_CODE.put("JSBANK","1042");//江苏银行
			BANK_MAP_CODE.put("BOSZ","1043");//苏州银行
			
			//BANK_MAP_CODE.put("","1044");//江苏长江商业银行
			
			BANK_MAP_CODE.put("HZCB","1045");//杭州银行
			BANK_MAP_CODE.put("NBBANK","1046");//宁波银行
			BANK_MAP_CODE.put("WZCB","1047");//温州银行
			BANK_MAP_CODE.put("JXBANK","1048");//嘉兴银行
			BANK_MAP_CODE.put("HZCCB","1049");//湖州银行
			BANK_MAP_CODE.put("SXCB","1050");//绍兴银行
			BANK_MAP_CODE.put("CZCB","1051");//浙江稠州商业银行
			BANK_MAP_CODE.put("TZCB","1052");//台州银行
			BANK_MAP_CODE.put("MTBANK","1054");//浙江民泰商业银行
			BANK_MAP_CODE.put("FJHXBC","1055");//福建海峡银行
			
			//BANK_MAP_CODE.put("","1056");//厦门银行
			
			BANK_MAP_CODE.put("NCB","1057");//南昌银行
			BANK_MAP_CODE.put("GZB","1058");//赣州银行
			BANK_MAP_CODE.put("SRBANK","1059");//上饶银行
			BANK_MAP_CODE.put("QLBANK","1060");//齐鲁银行
			BANK_MAP_CODE.put("QDCCB","1061");//青岛银行
			BANK_MAP_CODE.put("ZBCB","1062");//齐商银行
			BANK_MAP_CODE.put("DYCCB","1063");//东营市商业银行
			
			//BANK_MAP_CODE.put("","1064");//烟台银行
			
			BANK_MAP_CODE.put("BANKWF","1065");//潍坊银行
			BANK_MAP_CODE.put("JNBANK","1066");//济宁银行
			BANK_MAP_CODE.put("TACCB","1067");//泰安市商业银行
			BANK_MAP_CODE.put("LSBANK","1068");//莱商银行
			BANK_MAP_CODE.put("WHCCB","1069");//威海市商业银行
			BANK_MAP_CODE.put("DZBANK","1070");//德州银行
			BANK_MAP_CODE.put("LSBC","1071");//临商银行
			
			//BANK_MAP_CODE.put("","1072");//日照银行
			
			BANK_MAP_CODE.put("ZZBANK","1073");//郑州银行
			BANK_MAP_CODE.put("CBKF","1074");//开封市商业银行
			BANK_MAP_CODE.put("LYBANK","1075");//洛阳银行
			BANK_MAP_CODE.put("AYCB","1076");//安阳银行
			BANK_MAP_CODE.put("XCYH","1077");//许昌银行
			
			//BANK_MAP_CODE.put("1078","漯河市商业银行");
			//BANK_MAP_CODE.put("1079","商丘市商业银行");
			
			BANK_MAP_CODE.put("BZMD","1080");//驻马店银行
			
			//BANK_MAP_CODE.put("","1081");//南阳银行
			//BANK_MAP_CODE.put("","1082");//汉口银行
			
			BANK_MAP_CODE.put("HBC","1083");//湖北银行
			BANK_MAP_CODE.put("HRXJB","1084");//华融湘江银行
			BANK_MAP_CODE.put("CSCB","1085");//长沙银行
			BANK_MAP_CODE.put("GCB","1086");//广州银行
			
			//BANK_MAP_CODE.put("1087","珠海华润银行");
			//BANK_MAP_CODE.put("1088","广东华兴银行");
			
			BANK_MAP_CODE.put("NYNB","1089");//广东南粤银行
			BANK_MAP_CODE.put("DGCB","1090");//东莞银行
			BANK_MAP_CODE.put("BGB","1091");//广西北部湾
			
			//BANK_MAP_CODE.put("1092","柳州银行");
			
			BANK_MAP_CODE.put("GLBANK","1093");//桂林银行
			BANK_MAP_CODE.put("CDCB","1094");//成都银行
			BANK_MAP_CODE.put("CQBANK","1095");//重庆银行
			BANK_MAP_CODE.put("ZGCCB","1096");//自贡市商业银行
			
			//BANK_MAP_CODE.put("1097","攀枝花市商业银行");
			
			BANK_MAP_CODE.put("DYCB","1098");//德阳银行
			
			//BANK_MAP_CODE.put("1099","绵阳市商业银行");
			
			BANK_MAP_CODE.put("GYB","1100");//贵阳银行
			BANK_MAP_CODE.put("FDB","1101");//富滇银行
			
			//BANK_MAP_CODE.put("1102","长安银行");
			
			BANK_MAP_CODE.put("LZYH","1103");//兰州银行
			BANK_MAP_CODE.put("BOQH","1104");//青海银行
			BANK_MAP_CODE.put("NXBANK","1105");//宁夏银行
			BANK_MAP_CODE.put("URMQCCB","1106");//乌鲁木齐市商业银行
			
			//BANK_MAP_CODE.put("1107","昆仑银行");
			//BANK_MAP_CODE.put("1108","新疆汇和银行");
			
			BANK_MAP_CODE.put("JRCB","1109");//江苏江阴农村商业银行
			BANK_MAP_CODE.put("KSRB","1110");//昆山农村商业银行
			BANK_MAP_CODE.put("WJRCB","1111");//吴江农村商业银行
			BANK_MAP_CODE.put("CSRCB","1112");//常熟农村商业银行
			BANK_MAP_CODE.put("ZRCBANK","1113");//张家港农村商业银行
			
			//BANK_MAP_CODE.put("1114","广州农村商业银行");
			
			BANK_MAP_CODE.put("SDEB","1115");//顺德农村商业银行

			//BANK_MAP_CODE.put("1116","海口联合农村商业银行");
			
			BANK_MAP_CODE.put("CRCBANK","1117");//重庆农村商业银行
			BANK_MAP_CODE.put("EGBANK","1118");//恒丰银行
			BANK_MAP_CODE.put("CZBANK","1119");//浙商银行
			BANK_MAP_CODE.put("TRCB","1120");//天津农商银行
			BANK_MAP_CODE.put("BOHAIB","1121");//渤海银行
			BANK_MAP_CODE.put("HSBANK","1122");//徽商银行
			BANK_MAP_CODE.put("SHRCB","1123");//上海农商银行
			BANK_MAP_CODE.put("BJRCB","1124");//北京农村商业银行
			BANK_MAP_CODE.put("JLRCU","1125");//吉林农村信用社
			BANK_MAP_CODE.put("JSRCU","1126");//江苏省农村信用社联合社
			BANK_MAP_CODE.put("ZJNX","1127");//浙江省农村信用社
			BANK_MAP_CODE.put("NBYZ","1128");//鄞州银行
			BANK_MAP_CODE.put("ARCU","1129");//安徽省农村信用社联合社
			
			//BANK_MAP_CODE.put("1130","福建省农村信用社");
			
			BANK_MAP_CODE.put("SDRCU","1131");//山东省农联社
			BANK_MAP_CODE.put("HURCB","1132");//湖北农信
			BANK_MAP_CODE.put("SRCB","1133");//深圳农商行
			BANK_MAP_CODE.put("DGCU","1134");//东莞农村商业银行
			BANK_MAP_CODE.put("GXRCU","1135");//广西农村信用社
			
			//BANK_MAP_CODE.put("1136","海南省农村信用社");
			
			BANK_MAP_CODE.put("SCRCU","1137");//四川省农村信用社联合社
			BANK_MAP_CODE.put("YNRCC","1138");//云南省农村信用社
			BANK_MAP_CODE.put("SXRCCU","1139");//陕西省农村信用社
			
			//BANK_MAP_CODE.put("1140","黄河农村商业银行");
			
			BANK_MAP_CODE.put("PSBC","1141");//中国邮政储蓄银行
			BANK_MAP_CODE.put("HKBEA","1142");//东亚银行
			
			//BANK_MAP_CODE.put("1143","外换银行");
			//BANK_MAP_CODE.put("1144","友利银行");
			//BANK_MAP_CODE.put("1145","新韩银行中国");
			//BANK_MAP_CODE.put("1146","企业银行");
			
			BANK_MAP_CODE.put("HANABANK","1147");//韩亚银行
		}	

}
