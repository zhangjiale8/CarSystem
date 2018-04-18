package cn.car.manage.session;

import javax.servlet.http.HttpSession;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * session超时管理 
 * @author 
 */
@Component
public class SessionTimeoutManager {
	
	private SessionManager<Object>  sessionManager;
	
	
	public void setSessionManager(SessionManager<Object> sessionManager){
		this.sessionManager = sessionManager;
	}
	
	
	/**
	 * 每分钟检测一次
	 */
	@Scheduled(cron="0 * * * * *")
	public void checkTimeout(){
		if(sessionManager == null){
			return;
		}
		
		HttpSession[] sessions = sessionManager.getSessions();
		if(sessions == null || sessions.length == 0){
			return;
		}
		
		long currentTime = System.currentTimeMillis();
		int timeout = 0;
		for(HttpSession session : sessions){
			timeout = (Integer)session.getAttribute(SessionManager.TIMEOUT) * 60;
			if(timeout <= 0){
				continue;
			}
			if(currentTime - session.getLastAccessedTime() >= timeout){
				sessionManager.removeSession(session.getAttribute(SessionManager.SESSION_ID));
			}
		}
	}
}
