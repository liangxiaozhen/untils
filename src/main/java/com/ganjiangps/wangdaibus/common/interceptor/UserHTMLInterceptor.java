package com.ganjiangps.wangdaibus.common.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.LiteDeviceResolver;
import org.springframework.web.servlet.HandlerInterceptor;

import com.alibaba.fastjson.JSON;
import com.ganjiangps.wangdaibus.common.constant.Redis_Constat;
import com.ganjiangps.wangdaibus.common.jwt.WangdaibusJwtTokenUtil;
import com.ganjiangps.wangdaibus.common.response.ProcessBack;
import com.ganjiangps.wangdaibus.common.util.CookieUtil;
import com.ganjiangps.wangdaibus.common.util.RedisComponentUtil;
import com.ganjiangps.wangdaibus.common.util.StringUtil;
import com.ganjiangps.wangdaibus.model.PreCommonMember;
import com.ganjiangps.wangdaibus.model.PreUcenterMembers;

/**
 * 
* @ClassName: UserApiInterceptor 
* @Description: TODO(Api 拦截器实现) 
* @author cjm
* @date 2018年4月19日 下午6:33:19 
*
 */
public class UserHTMLInterceptor implements HandlerInterceptor{
	
	protected static Logger LOGGER = LoggerFactory.getLogger(UserHTMLInterceptor.class);
 	
	@Value("${jwt.header}")
	private String header;
	
	@Resource
	private WangdaibusJwtTokenUtil wangdaibusJwtTokenUtil;
	
	@Resource
	private RedisComponentUtil redisComponentUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean checkLogin = false;
 		String requestType = request.getHeader("X-Requested-With");
 		String requestToken = request.getHeader(this.header);
		if(StringUtil.isEmpty(requestToken)){
			//如果header为空从params 获取
			requestToken = request.getParameter(this.header);
 		}
		
		if(StringUtil.isEmpty(requestToken)){
			//如果header为空，params为空 从cookie获取
 			requestToken = CookieUtil.getCookieByName(CookieUtil.WDBTOKENCOOKIENAME, request, response);
 		}

		PreCommonMember commonMember = null;
		PreUcenterMembers members = null;
		try{
			if(StringUtil.isEmpty(requestToken)){//token 为空
	 			LOGGER.info("token 为空");
	 			checkLogin = true;
	  		}
 	 		
			if(!checkLogin){//token 不为空
 				LiteDeviceResolver deviceResolver = new LiteDeviceResolver();
				Device device = deviceResolver.resolveDevice(request);
				
 				boolean fal = wangdaibusJwtTokenUtil.doValidateToken(requestToken, device);
 				if(fal){//验证通过
 					String uid = wangdaibusJwtTokenUtil.getBaseIdFromToken(requestToken);
					if(!redisComponentUtil.getRedisTemplate().hasKey(Redis_Constat.USERHTML+uid)){
						LOGGER.info("用户 redis 缓存获取不到");
 					}else{
  						//延长缓存时间
 						commonMember = (PreCommonMember) redisComponentUtil.getRedisByKey(Redis_Constat.USERHTML+uid);
 						members = (PreUcenterMembers) redisComponentUtil.getRedisByKey(Redis_Constat.USERCENTERHTML+uid);
 						redisComponentUtil.setRedisKeyAndValue(Redis_Constat.USERHTML+uid, commonMember);
 						redisComponentUtil.setRedisKeyAndValue(Redis_Constat.USERCENTERHTML+uid, members);
 						
 						//把刷新后的token 返回
 						String refreshToken = wangdaibusJwtTokenUtil.refreshToken(requestToken);
 						response.setHeader("refreshToken", refreshToken);
 						
 						//写进cookie
  						CookieUtil.addCookie(CookieUtil.WDBTOKENCOOKIENAME, refreshToken,365*24*60*60, request, response, true);
 					}
 				}else{//验证不通过,干掉cookie 值，阻止一直抛时间过期异常
 					CookieUtil.removeCookie(CookieUtil.WDBTOKENCOOKIENAME, request, response, true);
 				}
 			}
	 		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(commonMember != null && members != null){
 			return true;
		}else{
			response.setContentType("application/json;charset=UTF-8");
 			ProcessBack processBack = new ProcessBack();
			processBack.setCode(ProcessBack.USERNOTLOGIN);
			processBack.setMessage("用户登录失效");
			response.getWriter().print(JSON.toJSONString(processBack));
			//检查是否是ajax请求
			/*if(StringUtil.isNotEmpty(requestType) && requestType.equalsIgnoreCase("XMLHttpRequest")){
				response.getWriter().print("logout");
 			}else{
				response.sendRedirect(request.getContextPath()+"/html5/10login.html");
			}*/
 			return false;
		}
	}
    
 }
