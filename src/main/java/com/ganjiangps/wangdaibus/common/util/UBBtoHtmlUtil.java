package com.ganjiangps.wangdaibus.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;

/**
 * 
* @ClassName: UBBtoHtmlUtil 
* @Description: TODO(网贷巴士原论坛UBB转Html) 
* @author cjm
* @date 2018年5月11日 上午9:32:59 
*
 */
public class UBBtoHtmlUtil {
	
	//图片服务器域名地址
	public static final String IMAGESHOST = "http://image.wangdaibus.com/";
	//程序应用域名地址
	public static final String OLDIMAGESHOST = "http://www.wangdaibus.com/";
	//程序应用域名地址
	public static final String ALIOOSHOST = "https://wdbspub.oss-cn-shanghai.aliyuncs.com/";
		
	 
	public static void main(String[] args) {
 		UBBtoHtmlUtil getemtByContent = new UBBtoHtmlUtil();
 		String ss = "<p><span style='font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; color: rgb(0, 0, 0);'>近日，互金见闻独家获悉，“存管大户”江西银行向部分平台发出了《关于《资金存管业务支付结算服务合作协议《不予续约的函》。</span></p><p>[attach]83982[/attach]</p><p><span style='font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; color: rgb(0, 0, 0);'>在上述文件里，江西银行提到了此次到期不予续约的原因在于“鉴于我行业务调整”。</span></p><p><span style='font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; color: rgb(0, 0, 0);'>回顾江西银行存管之路，颇为曲折。<br/><br/></span></p><p><span style='font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; color: rgb(0, 0, 0);'>2018年11月9日，江西银行通过存管测评名单，也就是业内所说的银行存管“白名单”。<br/><br/></span></p><p><span style='font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; color: rgb(0, 0, 0);'>事实上，9月20日首批银行存管白名单便已公布，但是作为存管大户的江西银行并不在首批之中。当时曾引起业内担忧，也确实有个别江西银行存管P2P平台在此期间更换了存管银行。<br/><br/></span></p><p><span style='font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; color: rgb(0, 0, 0);'>据当时报道，江西银行未能首批加入存管银行白名单，原因是该行对接的网贷平台数量太多，对其测评要求更加审慎严格。<br/><br/></span></p><p><span style='color: rgb(0, 0, 0); font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;'>而对于此次江西银行业务调整，业内人士向互金见闻分析，虽然江西银行如今通过了存管白名单，但受累于品牌影响及业务能力等综合考量，不排除其主动收缩存管业务的可能。<br/><br/></span></p><p><span style='font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; color: rgb(0, 0, 0);'>据此前报道，去年5月底，江西银行存管业务最多时曾对接过101家P2P平台，在此次行业雷潮中，江西银行已踩雷银豆网、钱满仓、小猪理财等多家平台。<br/><br/></span></p><p><span style='font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; color: rgb(0, 0, 0);'>不少出借人曾抱怨，对于平台明显自融账户，存管银行存在“存而不管”的监管缺失。</span></p><p><span style='font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; color: rgb(0, 0, 0);'>而截至9月30日，江西银行官网披露其还对接81家网贷平台。<br/><br/></span></p><p><span style='font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; color: rgb(0, 0, 0);'>互金见闻观察这部分平台发现，其中不乏无法通过备案或已出现危机的问题平台。</span></p><p><span style='font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; color: rgb(0, 0, 0);'>另外，去年下半年以来，许多平台确实因江西银行影响出现提现延迟或失败的情况。<br/><img src='http://image.wangdaibus.com/group1/M00/04/89/rBMV6lwwpcyAOnPkAAE03sVk_Lg206.png' title='index (1).png' alt='index (1).png'/></span></p><p><span style='font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; color: rgb(0, 0, 0);'>除了江西银行，近日多个消息源报道，上饶银行向部分网贷平台发送了《关于终止《上饶银行网络借贷资金存管业务服务协议《的告知函》，同样也是在资金存管业务协议期满后不再延期。<br/><br/></span></p><p><span style='font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; color: rgb(0, 0, 0);'>另外，朋友圈还传出浙商银行要退出存管银行的消息，但目前该消息并未得到银行方面确认。<br/><img src='http://image.wangdaibus.com/group1/M00/04/89/rBMV6lwwpdyATxCIAAJfGybtZkU602.png' title='index (2).png' alt='index (2).png'/></span></p><p><span style='font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; color: rgb(0, 0, 0);'>截至1月4日，经中国互联网金融协会官网公示，目前已有43家银行通过银行存管“白名单”，而上述上饶银行和浙商银行均通过了银行存管白名单，分别对接78家和54家P2P平台。<br/><br/></span></p><p><span style='font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; color: rgb(0, 0, 0);'>值得注意的是，12月26日，浙商银行曾在中国互金协会官网“资金存管”栏目披露存管数据，对接网贷平台54家中只有一家上线全量业务。但目前该栏目里已找不到浙商银行数据。<br/><br/></span></p><p><span style='color: rgb(0, 0, 0); font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;'>不知浙商银行是否会因对接平台多数未全量业务上线而受到影响。</span></p><p><br/></p>";

 		Map<String,String> lists = getemtByContent.getImgSrcList(ss);
 		System.out.println(JSON.toJSONString(lists));
 		Map<String,UBBtoHtmlUtilBean> lists2 = getemtByContent.getImgSrcBean(ss);
 		System.out.println(JSON.toJSONString(lists));
	}
	
	/**
	 * 
	* @Title: UBBtoHtml 
	* @Description: TODO(UBBtoHtml) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String UBBtoHtml(String text){
 		if(isEmpty(text)){
			throw new IllegalArgumentException("'text' 不能为空");
		}
		
//		text = text.replaceAll("\\\n","<br>"); 
		text = text.replaceAll("\\[hr]","<hr>");
 		text = text.replaceAll("\\[img]http(.+?)\\[/img]","<img src='http$1'>");
		text = text.replaceAll("\\[img](.+?)\\[/img]","$1");
		//处理img 宽高
		text = UBBtoHtmlByImgWidthAndHeight(text);
 		//处理table
 		text = UBBtoHtmlByTable(text);
		//处理tr 
 		text = UBBtoHtmlByTr(text);
		//处理td
 		text = UBBtoHtmlByTd(text);
		//处理[align=center]sds[/align]
 		text = UBBtoHtmlByAlign(text);
		//处理color
 		text = UBBtoHtmlByColor(text);
 		//处理Font
  		text = UBBtoHtmlByFont(text);
  		//处理h标签
  		text = UBBtoHtmlByH1(text);
  		text = UBBtoHtmlByH2(text);
  		text = UBBtoHtmlByH3(text);
  		text = UBBtoHtmlByH4(text);
  		text = UBBtoHtmlByH5(text);
  		text = UBBtoHtmlByH6(text);
    	//处理i标签
   		text = UBBtoHtmlByI(text);
  		//处理Url
  		text = UBBtoHtmlByUrl(text);
  		//处理b标签
  		text = UBBtoHtmlByB(text);
  		//处理u标签
  		text = UBBtoHtmlByU(text);
  		//处理size 标签
  		text = UBBtoHtmlBySize(text);
    	//解析backfround
   		text = UBBtoHtmlByBackGround(text);
   		//解析p标签
   		text = UBBtoHtmlByP(text);
  		//解析float标签
   		text = UBBtoHtmlByFloat(text);
   		//解析list
   		text = UBBtoHtmlByList(text);
   		return text;
	}
	
	//获取[attach]4562[/attach] 4562值
	public List<String>  getAttachAidByContent(String content){
 		if(isEmpty(content)){
			throw new IllegalArgumentException("'content' 不能为空");
		}
		
 		List<String> attachs = new ArrayList<>();
 		//[attach]10358[/attach][attach]10359[/attach]
		Pattern p = Pattern.compile("(\\[attach](.*?)\\[/attach])");
		Matcher m = p.matcher(content);
		boolean fal = m.find();
		if(fal){
 			while(fal){
 				Pattern p2 = Pattern.compile("(\\d+)");
				Matcher m2 = p2.matcher(m.group());
				if(m2.find()){
					attachs.add(m2.group());
				}
				fal = m.find();
			}
		}
 		return attachs;
	}
	
	//获取<emt>33</emt> 33值
	public List<String>  getemtByContent(String content){
 		if(isEmpty(content)){
			throw new IllegalArgumentException("'content' 不能为空");
		}
		
 		List<String> attachs = new ArrayList<>();
 		//[emt]33[/emt][emt]33[/emt][emt]33[/emt][emt]33[/emt][emt]33[/emt]
		Pattern p = Pattern.compile("(\\[emt](.*?)\\[/emt])");
		Matcher m = p.matcher(content);
		boolean fal = m.find();
		if(fal){
 			while(fal){
 				Pattern p2 = Pattern.compile("(\\d+)");
				Matcher m2 = p2.matcher(m.group());
				if(m2.find()){
					attachs.add(m2.group());
				}
				fal = m.find();
			}
		}
 		return attachs;
	}
	
	//获取img src的表情值
	public  Map<String,String> getImgEmtList(String content) {
		Map<String,String> list = new HashMap<>();
		// 目前img标签标示有3种表达式
		// <img alt="" src="1.jpg"/> <img alt="" src="1.jpg"></img> <img alt=""
		// src="1.jpg">
		// 开始匹配content中的<img />标签
		Pattern p_img = Pattern.compile("<(img|IMG)(.*?)(/>|></img>|>)");
		Matcher m_img = p_img.matcher(content);
		boolean result_img = m_img.find();
		if (result_img) {
			while (result_img) {
				// 获取到匹配的<img />标签中的内容
				String str_img = m_img.group(2);
				// 开始匹配<img />标签中的src
				Pattern p_src = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");
				Matcher m_src = p_src.matcher(str_img);
				if (m_src.find()) {
					String str_src = m_src.group(3);
 					if(StringUtil.isNotEmpty(str_src) && str_src.contains(IMAGESHOST) && str_src.contains("static/images/face/")){
  						Pattern p2 = Pattern.compile("(\\d+)");
 						Matcher m2 = p2.matcher(str_src);
 						if(m2.find()){
   							list.put(m_img.group(), m2.group());
 						}
					}else if(StringUtil.isNotEmpty(str_src) && str_src.contains(OLDIMAGESHOST) && str_src.contains("static/images/face/")){
  						Pattern p2 = Pattern.compile("(\\d+)");
 						Matcher m2 = p2.matcher(str_src);
 						if(m2.find()){
   							list.put(m_img.group(), m2.group());
  						}
 					}
				}
				// 匹配content中是否存在下一个<img />标签，有则继续以上步骤匹配<img />标签中的src
				result_img = m_img.find();
			}
		}
		return list;
	}
	
	//获取img src的值
	public  Map<String,String> getImgSrcList(String content) {
		Map<String,String> list = new HashMap<>();
		// 目前img标签标示有3种表达式
		// <img alt="" src="1.jpg"/> <img alt="" src="1.jpg"></img> <img alt=""
		// src="1.jpg">
		// 开始匹配content中的<img />标签
		Pattern p_img = Pattern.compile("<(img|IMG)(.*?)(/>|></img>|>)");
		Matcher m_img = p_img.matcher(content);
		boolean result_img = m_img.find();
		if (result_img) {
			while (result_img) {
				// 获取到匹配的<img />标签中的内容
				String str_img = m_img.group(2);
				// 开始匹配<img />标签中的src
				Pattern p_src = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");
				Matcher m_src = p_src.matcher(str_img);
				if (m_src.find()) {
					String str_src = m_src.group(3);
					System.out.println("key:===="+m_img.group());
 					if(StringUtil.isNotEmpty(str_src) && str_src.contains(IMAGESHOST)){
 						String subSrc = str_src.substring(IMAGESHOST.length());
  						list.put(m_img.group(), subSrc);
					}else if(StringUtil.isNotEmpty(str_src) && str_src.contains(OLDIMAGESHOST)){
						String subSrc = str_src.substring(OLDIMAGESHOST.length());
  						list.put(m_img.group(), subSrc);
					}else if(StringUtil.isNotEmpty(str_src) && str_src.contains(ALIOOSHOST)){
						String subSrc = str_src.substring(ALIOOSHOST.length());
  						list.put(m_img.group(), subSrc);
					}
 				}
				// 匹配content中是否存在下一个<img />标签，有则继续以上步骤匹配<img />标签中的src
				result_img = m_img.find();
			}
		}
		return list;
	}
	 
	//获取img src的值
	public  Map<String,UBBtoHtmlUtilBean> getImgSrcBean(String content) {
		Map<String,UBBtoHtmlUtilBean> list = new HashMap<>();
		// 目前img标签标示有3种表达式
		// <img alt="" src="1.jpg"/> <img alt="" src="1.jpg"></img> <img alt=""
		// src="1.jpg">
		// 开始匹配content中的<img />标签
		Pattern p_img = Pattern.compile("<(img|IMG)(.*?)(/>|></img>|>)");
		Matcher m_img = p_img.matcher(content);
		boolean result_img = m_img.find();
		if (result_img) {
			while (result_img) {
				// 获取到匹配的<img />标签中的内容
				String str_img = m_img.group(2);
 				// 开始匹配<img />标签中的src
				Pattern p_src = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");
				Matcher m_src = p_src.matcher(str_img);
				if (m_src.find()) {
					String str_src = m_src.group(3);
  					if(StringUtil.isNotEmpty(str_src) && str_src.contains(UBBtoHtmlUtil.IMAGESHOST)){//匹配新图片地址
  						UBBtoHtmlUtilBean bean = new UBBtoHtmlUtilBean();
 						Pattern pwidth_src = Pattern.compile("(?<style>style\\s*=\\s*\"[^\"]+\")");
 						Matcher mwidth_src = pwidth_src.matcher(str_img);
 						if(mwidth_src.find()){
  							String styleStr = mwidth_src.group("style");
  							String widthVal = process(styleStr);
  							bean.setImgwidth(Integer.valueOf(widthVal));
 						}
 						String subSrc = str_src.substring(UBBtoHtmlUtil.IMAGESHOST.length());
 						bean.setImgsrc(subSrc);
  						list.put(m_img.group(), bean);
					}else if(StringUtil.isNotEmpty(str_src) && str_src.contains(UBBtoHtmlUtil.OLDIMAGESHOST)){//匹配旧域名地址
 						UBBtoHtmlUtilBean bean = new UBBtoHtmlUtilBean();
 						Pattern pwidth_src = Pattern.compile("(?<style>style\\s*=\\s*\"[^\"]+\")");
 						Matcher mwidth_src = pwidth_src.matcher(str_img);
 						if(mwidth_src.find()){
  							String styleStr = mwidth_src.group("style");
  							String widthVal = process(styleStr);
  							bean.setImgwidth(Integer.valueOf(widthVal));
 						}
						String subSrc = str_src.substring(UBBtoHtmlUtil.OLDIMAGESHOST.length());
						bean.setImgsrc(subSrc);
						list.put(m_img.group(), bean);
					}else if(StringUtil.isNotEmpty(str_src) && str_src.contains(UBBtoHtmlUtil.ALIOOSHOST)){//匹配阿里oos地址
 						UBBtoHtmlUtilBean bean = new UBBtoHtmlUtilBean();
 						Pattern pwidth_src = Pattern.compile("(?<style>style\\s*=\\s*\"[^\"]+\")");
 						Matcher mwidth_src = pwidth_src.matcher(str_img);
 						if(mwidth_src.find()){
  							String styleStr = mwidth_src.group("style");
  							String widthVal = process(styleStr);
  							bean.setImgwidth(Integer.valueOf(widthVal));
 						}
						String subSrc = str_src.substring(UBBtoHtmlUtil.ALIOOSHOST.length());
						bean.setImgsrc(subSrc);
						list.put(m_img.group(), bean);
					}
				}
				// 匹配content中是否存在下一个<img />标签，有则继续以上步骤匹配<img />标签中的src
				result_img = m_img.find();
			}
		}
		
		//提取video
		Pattern p_video = Pattern.compile("<(video|VIDEO)(.*?)(/>|></video>|</VIDEO>)");
		Matcher m_video = p_video.matcher(content);
 		while (m_video.find()) {
			// 获取到匹配的<video />标签中的内容
			String str_video = m_video.group(2);
			// 开始匹配<video />标签中的src
			Pattern p_src = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");
			Matcher m_src = p_src.matcher(str_video);
			while (m_src.find()) {
				String str_src = m_src.group(3);
 				if(StringUtil.isNotEmpty(str_src) && str_src.contains(UBBtoHtmlUtil.IMAGESHOST)){
 					UBBtoHtmlUtilBean bean = new UBBtoHtmlUtilBean();
					String subSrc = str_src.substring(UBBtoHtmlUtil.IMAGESHOST.length());
					bean.setImgsrc(subSrc);
					list.put(m_video.group(), bean);
				}
			}
			// 匹配content中是否存在下一个<img />标签，有则继续以上步骤匹配<img />标签中的src
 		}
		
		return list;
	}
	
	private static String process(String style){
		//(style|STYLE)=(\"|\')(.*?)(\"|\')
		String res = "0";
        String regex_width = "(width|WIDTH):\\s*(?<width>\\d+([.]\\d+)?)px;";
        Pattern pattern = Pattern.compile(regex_width);
        Matcher matcher = pattern.matcher(style);
        if(matcher.find()){
        	res = matcher.group("width");
        	if(res.indexOf(".") != -1){
        		res = res.substring(0, res.indexOf("."));
        	}
            System.out.println("width:====="+res);
        }
         
        return res;
    }
	
	/**
	 * 
	* @Title: UBBtoHtmlByImgWidthAndHeight 
	* @Description: TODO(处理img 高宽) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByImgWidthAndHeight(String text){
		//[img=700,0] ==> <img width='700' border='0'>        [img=32,31] ==> <img width='32' height='31' border='0'>
		Pattern p = Pattern.compile("\\[img=(\\d+),(\\d+)]http(.+?)\\[/img]");
		Matcher m = p.matcher(text);
 		while(m.find()){
 			 String str = StringUtil.getRandomStr(6);
 			 System.out.println("====group(1)======"+m.group(1));
 			 System.out.println("====group(2)======"+m.group(2));
 			 System.out.println("====group(3)======"+m.group(3));
   			 if(Integer.valueOf(m.group(1)) > 0 && Integer.valueOf(m.group(2)) > 0){
 				text=text.replaceFirst("\\[img=(\\d+),(\\d+)]http(.+?)\\[/img]","<img id='aimg_"+str+"' class='zoom' width='"+m.group(1)+"' height='"+m.group(2)+"' border='0' src='http"+m.group(3)+"'>");
 			 }else if(Integer.valueOf(m.group(1)) > 0 && Integer.valueOf(m.group(2)) == 0){
  				text=text.replaceFirst("\\[img=(\\d+),(\\d+)]http(.+?)\\[/img]","<img id='aimg_"+str+"' class='zoom' width='"+m.group(1)+"' border='0' src='http"+m.group(3)+"'>");
  			 }else if(Integer.valueOf(m.group(1)) == 0 && Integer.valueOf(m.group(2)) > 0){
  				text=text.replaceFirst("\\[img=(\\d+),(\\d+)]http(.+?)\\[/img]","<img id='aimg_"+str+"' class='zoom' height='"+m.group(2)+"' border='0' src='http"+m.group(3)+"'>");
 			 }
 		}
 		
 		Pattern p1 = Pattern.compile("\\[img=(.+?),(.+?)](.+?)\\[/img]");
		Matcher m1 = p1.matcher(text);
 		while(m1.find()){
 			 System.out.println("====group(1)======"+m1.group(1));
 			 System.out.println("====group(2)======"+m1.group(2));
 			 System.out.println("====group(3)======"+m1.group(3));
 			 String str = m1.group(3);
 			text = text.replaceFirst("\\[img=(.+?),(.+?)](.+?)\\[/img]","$3");
  		}
 		
 		return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByTr 
	* @Description: TODO(处理tr) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByTr(String text){
		//text = text.replaceAll("\\[tr](.+?)\\[/tr]","<tr>$1</tr>");
		Pattern p1 = Pattern.compile("\\[/tr]");
		Matcher m1 = p1.matcher(text);
		while(m1.find()){
			text = text.replaceFirst("\\[/tr]","</tr>");
		}
		
		Pattern p2 = Pattern.compile("\\[tr]");
		Matcher m2 = p2.matcher(text);
		while(m2.find()){
			text = text.replaceFirst("\\[tr]","<tr>");
		}
		
		Pattern p3 = Pattern.compile("\\[tr=(.+?)]");
		Matcher m3 = p3.matcher(text);
 		while(m3.find()){
  			text = text.replaceFirst("\\[tr=(.+?)]","<tr style='background-color:"+m3.group(1)+"'>");
 		}
 		return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByTd 
	* @Description: TODO(处理td) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByTd(String text){
		//text = text.replaceAll("\\[td](.+?)\\[/td]","<td>$1</td>");
		Pattern p = Pattern.compile("\\[/td]");
		Matcher m = p.matcher(text);
 		while(m.find()){
 			text = text.replaceFirst("\\[/td]","</td>");
 		}
		
 		//[td=20]平台链接:[/td][td]https://hrdscf.com[/td]   [td=2,1]平台曝光[/td] [td=2,1,430]平台曝光[/td]
		Pattern p1 = Pattern.compile("\\[td=(.+?)]");
		Matcher m1 = p1.matcher(text);
  		while(m1.find()){
  			String group = m1.group();
 			String imgstr = group.substring("[td=".length(), group.length()-"]".length());
  			if(imgstr.contains(",")){
					String[] imgstrs = imgstr.split(",");
 					if(imgstrs.length > 2){
 						//[td=(1,2,43] 逻辑如果等于1 就不需要显示  0为colspan 1 为rowspan 2 为width
						if(Integer.valueOf(imgstrs[0]) > 1 && Integer.valueOf(imgstrs[1]) == 1){
							text = text.replaceFirst("\\[td=(.+?)]","<td colspan='"+imgstrs[0]+"' width='"+imgstrs[2]+"'>");
						}
						
						if(Integer.valueOf(imgstrs[0]) == 1 && Integer.valueOf(imgstrs[1]) > 1){
							text = text.replaceFirst("\\[td=(.+?)]","<td rowspan='"+imgstrs[1]+"' width='"+imgstrs[2]+"'>");
						}
						
						if(Integer.valueOf(imgstrs[0]) > 1 && Integer.valueOf(imgstrs[1]) > 1){
							text = text.replaceFirst("\\[td=(.+?)]","<td colspan='"+imgstrs[0]+"' rowspan='"+imgstrs[1]+"' width='"+imgstrs[2]+"'>");
						}
					}else{
						//[td=(2,1] 逻辑如果等于1 就不需要显示  0为colspan 1  为rowspan
						if(Integer.valueOf(imgstrs[0]) > 1 && Integer.valueOf(imgstrs[1]) == 1){
							text = text.replaceFirst("\\[td=(.+?)]","<td colspan='"+imgstrs[0]+"'>");
						}
						
						if(Integer.valueOf(imgstrs[0]) == 1 && Integer.valueOf(imgstrs[1]) > 1){
							text = text.replaceFirst("\\[td=(.+?)]","<td rowspan='"+imgstrs[1]+"'>");
						}
						
						if(Integer.valueOf(imgstrs[0]) > 1 && Integer.valueOf(imgstrs[1]) > 1){
							text = text.replaceFirst("\\[td=(.+?)]","<td colspan='"+imgstrs[0]+"' rowspan='"+imgstrs[1]+"'>");
						}
					}
			 }else{
				text = text.replaceFirst("\\[td=(.+?)]","<td width='"+imgstr+"'>");
			 }
  		}
 		
 		
 		Pattern p2 = Pattern.compile("\\[td]");
		Matcher m2 = p2.matcher(text);
 		while(m2.find()){
 			text = text.replaceFirst("\\[td]","<td>");
 		}
 		
 		return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByColor 
	* @Description: TODO(处理Color) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByColor(String text){
 		Pattern p = Pattern.compile("\\[/color]");
		Matcher m = p.matcher(text);
 		while(m.find()){
    		text = text.replaceFirst("\\[/color]","<font>");
 		}
 		
 		Pattern p3 = Pattern.compile("\\[color=(.+?)]");
		Matcher m3 = p3.matcher(text);
 		while(m3.find()){
       		text = text.replaceFirst("\\[color=(.+?)]","<font style='color:"+m3.group(1)+"'>");
 		}
 		
 		return text;
	}
	 
	/**
	 * 
	* @Title: UBBtoHtmlByAlign 
	* @Description: TODO(处理Align) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String  UBBtoHtmlByAlign(String text){
		//text = text.replaceAll("\\[align=(.+?)](.+?)\\[/align]","<div align='$1'>$2</div>");
		Pattern p = Pattern.compile("\\[/align]");
		Matcher m = p.matcher(text);
 		while(m.find()){
    		text = text.replaceFirst("\\[/align]","</div>");
 		}
 		
 		Pattern p3 = Pattern.compile("\\[align=(.+?)]");
		Matcher m3 = p3.matcher(text);
 		while(m3.find()){
       		text = text.replaceFirst("\\[align=(.+?)]","<div align='"+m3.group(1)+"'>");
 		}
 		
 		return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByTable 
	* @Description: TODO(处理table) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByTable(String text){
		// text = text.replaceAll("\\[table=(.+?)](.+?)\\[/table]","<table style='width:$1'>$2</table>");
		Pattern p = Pattern.compile("\\[/table]");
		Matcher m = p.matcher(text);
 		while(m.find()){
    		text = text.replaceFirst("\\[/table]","</table>");
 		}
 		
 		Pattern p3 = Pattern.compile("\\[table=(.+?)]");
		Matcher m3 = p3.matcher(text);
 		while(m3.find()){
       		text = text.replaceFirst("\\[table=(.+?)]","<table style='width:"+m3.group(1)+"'>");
 		}
 		
 		return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByFont 
	* @Description: TODO(处理Font) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByFont(String text){
		//处理[font=SimSun]业内传出首批民营银行的最终名单已经确定[/font]  [font=微软雅黑]sdds[/font]
 		//text = text.replaceAll("\\[font=(.+?)](.+?)\\[/font]","<font face='$1'>$2</font>");
		Pattern p = Pattern.compile("\\[/font]");
		Matcher m = p.matcher(text);
 		while(m.find()){
    	   text = text.replaceFirst("\\[/font]","</font>");
 		}
 		
 		Pattern p3 = Pattern.compile("\\[font=(.+?)]");
		Matcher m3 = p3.matcher(text);
 		while(m3.find()){
       		text = text.replaceFirst("\\[font=(.+?)]","<font face='"+m3.group(1)+"'>");
 		}
 		
 		return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByH1 
	* @Description: TODO(处理h1) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByH1(String text){
// 		text = text.replaceAll("\\[h1](.+?)\\[/h1]","<h1>$1</h1>");
		Pattern p = Pattern.compile("\\[/h1]");
		Matcher m = p.matcher(text);
 		while(m.find()){
    		text = text.replaceFirst("\\[/h1]","</h1>");
 		}
 		
 		Pattern p3 = Pattern.compile("\\[h1]");
		Matcher m3 = p3.matcher(text);
 		while(m3.find()){
       		text = text.replaceFirst("\\[h1]","<h1>");
 		}
  		return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByH2 
	* @Description: TODO(处理h2) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByH2(String text){
// 		text = text.replaceAll("\\[h2](.+?)\\[/h2]","<h2>$1</h2>");
		Pattern p = Pattern.compile("\\[/h2]");
		Matcher m = p.matcher(text);
 		while(m.find()){
    		text = text.replaceFirst("\\[/h2]","</h2>");
 		}
  		Pattern p3 = Pattern.compile("\\[h2]");
		Matcher m3 = p3.matcher(text);
 		while(m3.find()){
       		text = text.replaceFirst("\\[h2]","<h2>");
 		}
  		return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByH3 
	* @Description: TODO(处理h3) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByH3(String text){
  // 	text = text.replaceAll("\\[h3](.+?)\\[/h3]","<h3>$1</h3>");
 		Pattern p = Pattern.compile("\\[/h3]");
		Matcher m = p.matcher(text);
 		while(m.find()){
    		text = text.replaceFirst("\\[/h3]","</h3>");
 		}
 		
 		Pattern p3 = Pattern.compile("\\[h3]");
		Matcher m3 = p3.matcher(text);
 		while(m3.find()){
       		text = text.replaceFirst("\\[h3]","<h3>");
 		}
  		return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByH4
	* @Description: TODO(处理h4) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByH4(String text){
 // 	text = text.replaceAll("\\[h4](.+?)\\[/h4]","<h4>$1</h4>");
 		Pattern p = Pattern.compile("\\[/h4]");
		Matcher m = p.matcher(text);
 		while(m.find()){
    		 text = text.replaceFirst("\\[/h4]","</h4>");
 		}
 		
 		Pattern p3 = Pattern.compile("\\[h4]");
		Matcher m3 = p3.matcher(text);
 		while(m3.find()){
       		text = text.replaceFirst("\\[h4]","<h4>");
 		}
  		return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByH5 
	* @Description: TODO(处理h5) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByH5(String text){
 // 		text = text.replaceAll("\\[h5](.+?)\\[/h5]","<h5>$1</h5>");
 		Pattern p = Pattern.compile("\\[/h5]");
		Matcher m = p.matcher(text);
 		while(m.find()){
    		text = text.replaceFirst("\\[/h5]","</h5>");
 		}
 		
 		Pattern p3 = Pattern.compile("\\[h5]");
		Matcher m3 = p3.matcher(text);
 		while(m3.find()){
       		text = text.replaceFirst("\\[h5]","<h5>");
 		}
  		return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByH6 
	* @Description: TODO(处理h6) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByH6(String text){
 // 		text = text.replaceAll("\\[h6](.+?)\\[/h6]","<h6>$1</h6>");
		Pattern p = Pattern.compile("\\[/h6]");
		Matcher m = p.matcher(text);
 		while(m.find()){
    		text = text.replaceFirst("\\[/h6]","</h6>");
 		}
 		
 		Pattern p3 = Pattern.compile("\\[h6]");
		Matcher m3 = p3.matcher(text);
 		while(m3.find()){
       		text = text.replaceFirst("\\[h6]","<h6>");
 		}
  		return text;
	}
	 
	/**
	 * 
	* @Title: UBBtoHtmlByI 
	* @Description: TODO(处理I标签) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByI(String text){
//		text = text.replaceAll("\\[i=(.+?)](.+?)\\[/i]","<i class='pstatus'>$2</i>");//[i=s][/i]
		Pattern p = Pattern.compile("\\[/i]");
		Matcher m = p.matcher(text);
 		while(m.find()){
    		text = text.replaceFirst("\\[/i]","</i>");
 		}
 		
 		Pattern p2 = Pattern.compile("\\[i=(.+?)]");
		Matcher m2 = p2.matcher(text);
 		while(m2.find()){
       		text = text.replaceFirst("\\[i=(.+?)]","<i class='pstatus'>");
 		}
 		
 		Pattern p3 = Pattern.compile("\\[i]");
		Matcher m3 = p3.matcher(text);
 		while(m3.find()){
       		text = text.replaceFirst("\\[i]","<i>");
 		}
  		return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByUrl 
	* @Description: TODO(处理URl 标签) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByUrl(String text){
//		text = text.replaceAll("\\[url=(.+?)](.+?)\\[/url]","<a href='$1'>$2</a>");//[url]
// 		text = text.replaceAll("\\[url](.+?)\\[/url]","<a href='$1'>$1</a>");
		Pattern p3 = Pattern.compile("\\[url](.+?)\\[/url]");
		Matcher m3 = p3.matcher(text);
 		while(m3.find()){
       		text = text.replaceFirst("\\[url](.+?)\\[/url]","<a href='"+m3.group(1)+"'>"+m3.group(1)+"</a>");
 		}
 		
		Pattern p = Pattern.compile("\\[/url]");
		Matcher m = p.matcher(text);
 		while(m.find()){
    		text = text.replaceFirst("\\[/url]","</a>");
 		}
 		
 		Pattern p2 = Pattern.compile("\\[url=(.+?)]");
		Matcher m2 = p2.matcher(text);
 		while(m2.find()){
       		text = text.replaceFirst("\\[url=(.+?)]","<a href='"+m2.group(1)+"'>"+m2.group(1)+"");
 		}
 		 
  		return text;
	}
	
	
	 /**
	  * 
	 * @Title: UBBtoHtmlByB 
	 * @Description: TODO(处理B标签) 
	 * @param @param text
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	  */
	private String UBBtoHtmlByB(String text){
//		text = text.replaceAll("\\[b](.+?)\\[/b]","<strong>$1</strong>");//[b]	
 		Pattern p = Pattern.compile("\\[b]");
		Matcher m = p.matcher(text);
 		while(m.find()){
      		text = text.replaceFirst("\\[b]","<strong>");
 		}
 		
 		Pattern p1 = Pattern.compile("\\[/b]");
		Matcher m1 = p1.matcher(text);
 		while(m1.find()){
      		text = text.replaceFirst("\\[/b]","</strong>");
 		}
    	return text;
	}
	
	private String UBBtoHtmlByU(String text){
 		Pattern p = Pattern.compile("\\[u]");
		Matcher m = p.matcher(text);
 		while(m.find()){
      		text = text.replaceFirst("\\[u]","<u>");
 		}
 		
 		Pattern p1 = Pattern.compile("\\[/u]");
		Matcher m1 = p1.matcher(text);
 		while(m1.find()){
      		text = text.replaceFirst("\\[/u]","</u>");
 		}
    	return text;
 	}
	
	/**
	 * 
	* @Title: UBBtoHtmlBySize 
	* @Description: TODO(处理size 标签) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlBySize(String text){
//		text = text.replaceAll("\\[size=(.+?)](.+?)\\[/size]","<font size='$1'>$2</font>");//[b]
 		Pattern p = Pattern.compile("\\[size=(.+?)]");
		Matcher m = p.matcher(text);
 		while(m.find()){
 			if(m.group(1).contains("px")){
 				text = text.replaceFirst("\\[size=(.+?)]","<font style='font-size:"+m.group(1)+"'>");
 			}else if(m.group(1).contains("pt")){
  				text = text.replaceFirst("\\[size=(.+?)]","<font style='font-size:"+m.group(1)+"'>");
 			}else{
  				text = text.replaceFirst("\\[size=(.+?)]","<font size='"+m.group(1)+"'>");
 			}
 		}
 		
 		Pattern p1 = Pattern.compile("\\[/size]");
		Matcher m1 = p1.matcher(text);
 		while(m1.find()){
 			text = text.replaceFirst("\\[/size]","</font>");
 		}
    	return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByP 
	* @Description: TODO(处理p标签) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByP(String text){
//		text = text.replaceAll("\\[p=(.+?),(.+?),(.+?)](.+?)\\[/p]","<p style='line-height:$1px;text-indent:$2em;text-align:$3'>$4</p>");
		Pattern p1 = Pattern.compile("\\[/p]");
		Matcher m1 = p1.matcher(text);
 		while(m1.find()){
     		text = text.replaceFirst("\\[/p]","</p>");
 		}
		
 		Pattern p = Pattern.compile("\\[p=(.+?),(.+?),(.+?)]");
		Matcher m = p.matcher(text);
 		while(m.find()){
      		text = text.replaceFirst("\\[p=(.+?),(.+?),(.+?)]","<p style='line-height:"+m.group(1)+"px;text-indent:"+m.group(2)+"em;text-align:"+m.group(3)+"'>");
 		}
    	return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByFloat 
	* @Description: TODO(解析Float) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByFloat(String text){
//		[float=left][/float]
		Pattern p1 = Pattern.compile("\\[/float]");
		Matcher m1 = p1.matcher(text);
 		while(m1.find()){
     		text = text.replaceFirst("\\[/float]","</span>");
 		}
		
 		Pattern p = Pattern.compile("\\[float=(.+?)]");
		Matcher m = p.matcher(text);
 		while(m.find()){
      		text = text.replaceFirst("\\[float=(.+?)]","<span style='float:"+m.group(1)+";'>");
 		}
    	return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByBackGround 
	* @Description: TODO(解析background) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByBackGround(String text){
//		text = text.replaceAll("\\[backcolor=(.+?)](.+?)\\[/backcolor]","<font style='background-color:$1'>$2</font>");
		Pattern p1 = Pattern.compile("\\[/backcolor]");
		Matcher m1 = p1.matcher(text);
 		while(m1.find()){
     		text = text.replaceFirst("\\[/backcolor]","</font>");
 		}
		
 		Pattern p = Pattern.compile("\\[backcolor=(.+?)]");
		Matcher m = p.matcher(text);
 		while(m.find()){
      		text = text.replaceFirst("\\[backcolor=(.+?)]","<font style='background-color:"+m.group(1)+"'>");
 		}
    	return text;
	}
	
	
	
	/**
	 * 
	* @Title: UBBtoHtmlByList 
	* @Description: TODO(解析list) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String UBBtoHtmlByList(String text){
//		[list]\r\n[*]撒旦是\r\n[*]\r\n[/list]
		
		
 		Pattern p2 = Pattern.compile("\\[list=(.+?)]([\\s\\S]*)\\[/list]");
		Matcher m2 = p2.matcher(text);
		String liStr2 = "";
 		while(m2.find()){
    		Pattern p3 = Pattern.compile("\\[*]([\\s\\S]*)");
   			Matcher m3 = p3.matcher(m2.group(2));
   			while(m3.find()){
   				String lis = m3.group(1);
    			int inIndex = lis.indexOf("[*]");
    			
    			if(inIndex == -1 && lis != null){
    				liStr2 += "<li>"+lis+"</li>";
    			}
    			
    			while(inIndex != -1){
    				String str = lis.substring(0, inIndex);
       				lis = lis.substring(str.length()+"[*]".length());
      				liStr2 += "<li>"+str+"</li>";
      				//这里有可能会出现死循环 特别注意
    				System.out.println("========"+str);
    				System.out.println("===3====="+lis);
    				inIndex = lis.indexOf("[*]");
    				if(inIndex == -1 && lis != null){//最后一个li
    					liStr2 += "<li>"+lis+"</li>";
    				}
    			}
   			}
  			text = text.replaceFirst("\\[list=(.+?)]([\\s\\S]*)\\[/list]", "<ul type='"+m2.group(1)+"' class='litype_"+m2.group(1)+"' >"+liStr2+"</ul>");
  		}
		
		
		Pattern p = Pattern.compile("\\[list]([\\s\\S]*)\\[/list]");
		Matcher m = p.matcher(text);
		String liStr = "";
 		while(m.find()){
    		Pattern p1 = Pattern.compile("\\[*]([\\s\\S]*)");
   			Matcher m1 = p1.matcher(m.group(1));
   			while(m1.find()){
   				String lis = m1.group(1);
    			int inIndex = lis.indexOf("[*]");
    			
    			if(inIndex == -1 && lis != null){
    				liStr += "<li>"+lis+"</li>";
    			}
    			
    			while(inIndex != -1){
    				String str = lis.substring(0, inIndex);
       				lis = lis.substring(str.length()+"[*]".length());
      				liStr += "<li>"+str+"</li>";
      				//这里有可能会出现死循环 特别注意
    				System.out.println("========"+str);
    				System.out.println("===3====="+lis);
    				inIndex = lis.indexOf("[*]");
    				if(inIndex == -1 && lis != null){//最后一个li
    					liStr += "<li>"+lis+"</li>";
    				}
    			}
   			}
  			text = text.replaceFirst("\\[list]([\\s\\S]*)\\[/list]", "<ul>"+liStr+"</ul>");
  		}
 		
 		text = text.replaceAll("\\[list]", "");
 		text = text.replaceAll("\\[list=(.+?)]", "");
 		text = text.replaceAll("\\[/list]", "");
 		
 		
    	return text;
	}
	
	/**
	 * 
	* @Title: UBBtoHtmlByQuote 
	* @Description: TODO(主题回复老数据解析 ,请注意,这个是保存回复最后一步替换的，帖子内容请不要调用此方法。) 
	* @param @param content
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String UBBtoHtmlByQuote(String content){
		Pattern p = Pattern.compile("\\[quote]([\\s\\S]*)\\[/quote]");
		Matcher m = p.matcher(content);
  		while(m.find()){
  			content = content.replaceFirst("\\[quote]([\\s\\S]*)\\[/quote]", "");
 		}
		return content;
	}
	
	/**
	 * 
	* @Title: getPidByContent 
	* @Description: TODO(根据回复内容获取父回复id) 
	* @param @param content
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	* 
	* 返回空则不是二次回复
	* 
	 */
	public String getPidByContent(String content){
		String pid = "";
		Pattern p = Pattern.compile("\\[quote]([\\s\\S]*)\\[/quote]");
		Matcher m = p.matcher(content);
  		while(m.find()){
  			 String quoteStr = m.group(1);
  			 Pattern p1 = Pattern.compile("\\&pid=([\\s\\S]*)\\&ptid");
  			 Matcher m1 = p1.matcher(quoteStr);
  			 while(m1.find()){
  				System.out.println(m1.group(1));
  				pid = m1.group(1);
  				return pid;
  			}
 		}
  		return pid;
	}
	 
	private static  boolean isEmpty(Object str) {
		return str == null || "".equals(str) || String.valueOf(str).length() == 0
				|| String.valueOf(str).matches("\\s*");
	}
	
	
	public static String escapeExprSpecialWord(String StringVal){
		if(StringVal != ""){
			String[] fbsArr = {"?"};
			for(String key:fbsArr){
				if(StringVal.contains(key)){
					StringVal = StringVal.replace(key, "\\"+key);
				}
			}
		}
		return StringVal;
	}
	 
}
