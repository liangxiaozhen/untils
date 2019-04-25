package com.ganjiangps.wangdaibus.common.util;

import java.util.HashMap;

/**
 * 
 * @author Administrator
 * @classname: com.ptpl.core.interceptor
 * @author : gengfl
 * @Description :用于用户登入时保存sessionId , 作为后期对同一帐号是否多地登入作工具
 * @date 2017/4/12
 */
public class MyMapSessionId {

	private static MyMapSessionId m;
	private HashMap<Long,String> mymap;

	private MyMapSessionId() {
		mymap = new HashMap<Long,String>();
	}

	public static synchronized MyMapSessionId getInstance() {
		if (m == null) {
			m = new MyMapSessionId();
		}
		return m;
	}

	public synchronized void AddSession(Long id, String sessionID) {
		mymap.put(id, sessionID);
	}

	public String getSessionId(Long id) {
		String SessionId = (String) mymap.get(id);
		return SessionId;

	}
	public synchronized void DeleteSessionId(Long id){
		mymap.remove(id);
	}

}
