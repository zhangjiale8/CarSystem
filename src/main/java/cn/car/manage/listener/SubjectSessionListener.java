package cn.car.manage.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.car.manage.util.helper.RequestUtil;

@WebListener
public class SubjectSessionListener implements HttpSessionListener,ServletRequestListener,ServletContextListener {
	//@Autowired
	//private UserLogService userlogService = new UserLogService(); 
	
	@SuppressWarnings("unused")
	private String remoteip;
	@SuppressWarnings("unused")
	private HttpSession session;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		session = se.getSession();

		
	}

	@Override
	public void requestInitialized(ServletRequestEvent re) {
		// TODO Auto-generated method stub
		ServletRequest request= re.getServletRequest();
		remoteip = RequestUtil.isLocalhost(request.getRemoteAddr());
		//System.err.println("remoteip:"+remoteip);
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent re) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent application) {
		// TODO Auto-generated method stub
		//session.setMaxInactiveInterval(0);
	}

	

}
