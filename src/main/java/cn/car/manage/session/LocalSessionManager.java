package cn.car.manage.session;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import cn.car.manage.util.helper.RequestUtil;

/**
 * 本地session管理器, 以用户ID作为唯一标识
 * @author 
 */
@Service("sessionManager")
public class LocalSessionManager extends SessionManager<Integer>{
	
	private static final Hashtable<Integer, HttpSession> SESSIONS = new Hashtable<Integer, HttpSession>();

	@Override
	public HttpSession getSession(Integer sessionID) {
		if(sessionID == null || sessionID <= 0){
			return null;
		}
		
		return SESSIONS.get(sessionID);
	}
	
	@Override
	public HttpSession getSession() {
		HttpSession session = RequestUtil.getSession();
		if(session == null){
			return null;
		}
		
		Integer sessionID = (Integer)session.getAttribute(SESSION_ID);
		
		return getSession(sessionID);
	}

	@Override
	public boolean addSession(Integer sessionID, HttpSession session, int timeout) {
		if(sessionID == null || sessionID <= 0 || session == null){
			return false;
		}
		
		timeout = timeout < 0 ? 0 : timeout;
		session.setAttribute(SessionManager.SESSION_ID, sessionID);
		session.setAttribute(TIMEOUT, timeout);
		
		SESSIONS.put(sessionID, session);
		
		return true;
	}

	@Override
	public boolean removeSession(Integer sessionID) {
		HttpSession session = getSession(sessionID);
		if(session == null){
			return true;
		}
		
		session.invalidate();
		SESSIONS.remove(sessionID);
		
		return true;
	}

	@Override
	public HttpSession[] getSessions() {
		return (HttpSession[])SESSIONS.values().toArray();
	}

}
