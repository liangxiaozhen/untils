package com.ganjiangps.wangdaibus.common.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.LiteDeviceResolver;
import org.springframework.web.servlet.HandlerInterceptor;

import com.alibaba.fastjson.JSON;
import com.ganjiangps.wangdaibus.common.constant.Redis_Constat;
import com.ganjiangps.wangdaibus.common.jwt.WangdaibusJwtTokenUtil;
import com.ganjiangps.wangdaibus.common.response.AjaxResult;
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
public class UserApiInterceptor implements HandlerInterceptor{
  
	@Value("${jwt.header}")
	private String header;
	
	@Resource
	private WangdaibusJwtTokenUtil wangdaibusJwtTokenUtil;
	
	@Resource
	private RedisComponentUtil redisComponentUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String requestToken = request.getHeader(this.header);
		//token 为空
		if(StringUtil.isEmpty(requestToken)){
 			StringUtil.sendJsonData(response, JSON.toJSONString(AjaxResult.createAjaxResult().logoutAjaxResult("token 不能为空")));
			return false;
		}
		  
		LiteDeviceResolver deviceResolver = new LiteDeviceResolver();
		Device device = deviceResolver.resolveDevice(request);
		
  		boolean fal = wangdaibusJwtTokenUtil.doValidateToken(requestToken, device);
 		
 		//验证不通过
 		if(!fal){
 			StringUtil.sendJsonData(response, JSON.toJSONString(AjaxResult.createAjaxResult().logoutAjaxResult()));
			return false;
 		}
 		
 		String uid = wangdaibusJwtTokenUtil.getBaseIdFromToken(requestToken);
   		if(!redisComponentUtil.getRedisTemplate().hasKey(Redis_Constat.USER+uid)){
 			StringUtil.sendJsonData(response, JSON.toJSONString(AjaxResult.createAjaxResult().logoutAjaxResult()));
			return false;
 		}
   		
   		//延长缓存时间
   		PreCommonMember commonMember = (PreCommonMember) redisComponentUtil.getRedisByKey(Redis_Constat.USER+uid);
   		PreUcenterMembers members = (PreUcenterMembers) redisComponentUtil.getRedisByKey(Redis_Constat.USERCENTER+uid);
   		redisComponentUtil.setRedisKeyAndValue(Redis_Constat.USER+uid, commonMember);
   		redisComponentUtil.setRedisKeyAndValue(Redis_Constat.USERCENTER+uid, members);
  		
   		//把刷新后的token 返回
 		String refreshToken = wangdaibusJwtTokenUtil.refreshToken(requestToken);
 		response.setHeader("refreshToken", refreshToken);
 		return true;
	}
    
 }
