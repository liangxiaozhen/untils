package com.ganjiangps.wangdaibus.common.interceptor;

import com.ganjiangps.wangdaibus.common.constant.Session_Constant;
import com.ganjiangps.wangdaibus.common.util.MyMapSessionId;
import com.ganjiangps.wangdaibus.common.util.StringUtil;
import com.ganjiangps.wangdaibus.model.PreCommonMember;
import com.ganjiangps.wangdaibus.model.PreUcenterMembers;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
* @ClassName: UserPcInterceptor
* @Description: TODO(拦截器实现)
* @author cjm
* @date 2018年4月19日 下午6:33:19
*
 */
public class User406Interceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestType = request.getHeader("X-Requested-With");
 		PreCommonMember  preCommonMember = (PreCommonMember) request.getSession().getAttribute(Session_Constant.USERACCOUNTINFO406);
		PreUcenterMembers  preUcenterMembers = (PreUcenterMembers) request.getSession().getAttribute(Session_Constant.USERSECURITYINFO406);
		String requestUrl = request.getScheme() //当前链接使用的协议
				+"://" + request.getServerName()//服务器地址
				+ ":" + request.getServerPort() //端口号
				+ request.getContextPath() //应用名称，如果应用名称为
				+ request.getServletPath() //请求的相对url
				+ "?" + request.getQueryString(); //请求参数
		if(requestUrl != null
				&& StringUtil.isNotEmpty(requestUrl)
				&& requestUrl.contains("/user/platformClaim/goClaim")){
			request.getSession().setAttribute("requestUrl",requestUrl);
		}else {
			request.getSession().removeAttribute("requestUrl");
		}
		
		if(preCommonMember != null && preUcenterMembers != null){
			HttpSession session = request.getSession();
			String id = session.getId();
			Long uid = preCommonMember.getUid();
			MyMapSessionId m = MyMapSessionId.getInstance();
			String sessionId = m.getSessionId(uid);//获取保存的sessionId
			if (sessionId!=null && sessionId.equals(id)){
				return true;
			}else {
				session.invalidate();
				String str="yideng";
				request.getRequestDispatcher(request.getContextPath()+"/?ab="+str).forward(request,response);
			}
			return false;
		}else{
			//检查是否是ajax请求
			if(StringUtil.isNotEmpty(requestType) && requestType.equalsIgnoreCase("XMLHttpRequest")){
  				response.getWriter().print("logout");
 			}else{
				response.sendRedirect(request.getContextPath()+"/?loginName=logout");
			}
 			return false;
		}
 	}

 }
