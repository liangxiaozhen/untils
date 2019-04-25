package com.ganjiangps.wangdaibus.common.jwt;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Component;

import com.ganjiangps.wangdaibus.common.util.StringUtil;
import com.ganjiangps.wangdaibus.model.PreCommonMember;
/**
 * 
* @ClassName: WangdaibusJwtTokenUtil 
* @Description: TODO(网贷巴士 jwtToken ) 
* @author cjm
* @date 2018年4月20日 上午11:14:55 
*
 */
@Component
public class WangdaibusJwtTokenUtil extends JwtTokenUtil{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String generateToken(PreCommonMember preCommonMember,Device device){
		Map<String, Object> claims = new HashMap<>();
		claims.put(AUDIENCE_BASEID, preCommonMember.getUid().toString());//用户ID
 		if(device != null ){//校验来源
 			return doGenerateToken(claims, preCommonMember.getUsername(), device);
		}
		
		return doGenerateToken(claims, preCommonMember.getUsername(), null);
	}
	
	public Boolean validateToken(String token,PreCommonMember preCommonMember,Device device){
		if(device != null ){//校验来源
 			return doValidateToken(token, preCommonMember.getUid().toString(), preCommonMember.getUsername(),device);
		}
		
 		return doValidateToken(token, preCommonMember.getUid().toString(), preCommonMember.getUsername(),null);
	}
	
	public String getUserBaseId(HttpServletRequest request,HttpServletResponse response){
		String uid = "";
		String token = getToken(request,response);
		if(StringUtil.isEmpty(token)){
			return uid;
		}
		uid = getBaseIdFromToken(token);
 		return uid;
	}
 }
