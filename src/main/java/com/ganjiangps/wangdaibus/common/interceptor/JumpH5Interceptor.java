package com.ganjiangps.wangdaibus.common.interceptor;
 
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.LiteDeviceResolver;
import org.springframework.web.servlet.HandlerInterceptor;
 
/**
 *
* @ClassName: JumpH5Interceptor
* @Description: TODO(跳转h5拦截器实现)
* @author cjm
* @date 2018年4月19日 下午6:33:19
*
 */
public class JumpH5Interceptor implements HandlerInterceptor{
	
	protected static Logger LOGGER = LoggerFactory.getLogger(JumpH5Interceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUrl = request.getScheme() //当前链接使用的协议
				+"://" + request.getServerName()//服务器地址
				+ ":" + request.getServerPort() //端口号
				+ request.getContextPath() //应用名称，如果应用名称为
				+ request.getServletPath() //请求的相对url
				+ "?" + request.getQueryString(); //请求参数
		LOGGER.info("请求路径："+requestUrl);//来源
		//http://www.wangdaibus.com:80/busTeaHouse/detail?tid=159421&pageNum=1
		if(requestUrl.indexOf("www.wangdaibus.com") == -1){//判断是否是官网路径
			return true;
		}

		//判断是否是图片资源 图片资源放行
		if(requestUrl.indexOf("www.wangdaibus.com/data/attachment") != -1 
				|| requestUrl.indexOf("www.wangdaibus.com/uc_server") != -1
				|| requestUrl.indexOf("www.wangdaibus.com/source") != -1
				|| requestUrl.indexOf("www.wangdaibus.com/portal") != -1
				|| requestUrl.indexOf("www.wangdaibus.com/static") != -1){ 
		  String[] SUPPORT_IMAGE_TYPE = { "JPG", "JPEG", "PNG", "GIF", "BMP", "WBMP" };
		  List<String> SUPPORT_IMAGE_LIST = Arrays.asList(SUPPORT_IMAGE_TYPE);
		  if(SUPPORT_IMAGE_LIST.contains(requestUrl)){
 			  return true;
		  }
		}
 		
		LiteDeviceResolver deviceResolver = new LiteDeviceResolver();
		Device device = deviceResolver.resolveDevice(request);
		if (device != null && device.getDevicePlatform() != null) {
			LOGGER.info("请求来源设备："+device.getDevicePlatform().name());//来源
 			if(device.getDevicePlatform().name().equals("IOS") 
 					|| device.getDevicePlatform().name().equals("ANDROID")){
 				//跳转h5域名
 				response.sendRedirect("http://h5.wangdaibus.com");
 				return false;
			}
		}
		
 		return true;
 	}

 }
