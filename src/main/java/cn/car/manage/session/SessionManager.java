package cn.car.manage.session;

import javax.servlet.http.HttpSession;

public abstract class  SessionManager<T> {
	
	protected static final String TIMEOUT = "TIMEOUT";
	public static final String SESSION_ID = "USER_ID";
	
	/**
	 * 根据标识获取session对象
	 * @param object 
	 * @return
	 */
	public abstract HttpSession getSession(T sessionID);
	
	/**
	 * 获取当前用户session
	 * @return
	 */
	public abstract HttpSession getSession();
	
	/**
	 * 获取session列表
	 * @return
	 */
	public abstract HttpSession[] getSessions();
	
	/**
	 * 保存session并设置超时时间
	 * @param key
	 * @param session
	 * @param timeout(单位: 分钟) 0: 永不超时
	 * @return
	 */
	public abstract boolean addSession(T sessionID, HttpSession session, int timeout);
	
	/**
	 * 销毁session
	 * @param key
	 * @return
	 */
	public abstract boolean removeSession(T sessionID);
	
	/**
	 * 添加属性
	 * @param key
	 * @param object
	 */
	public void setAttribute(String key, Object object){
		if(key == null || key.trim().isEmpty()){
			throw new IllegalArgumentException("the key of attribute can not by null or empty");
		}
		
		HttpSession session = getSession();
		if(session == null){
			throw new IllegalStateException("session is not exists");
		}
		
		session.setAttribute(key.trim(), object);
	}
	
	/**
	 * 获取属性值
	 * @param key
	 * @return
	 */
	public Object getAttribute(String key){
		if(key == null || key.trim().isEmpty()){
			return null;
		}
		
		HttpSession session = getSession();
		if(session == null){
			return null;
		}
		
		return session.getAttribute(key.trim());
	}
	
	/**
	 * 移除属性
	 * @param key
	 */
	public void removeAttribute(String key){
		if(key == null || key.trim().isEmpty()){
			throw new IllegalArgumentException("the key of attribute can not by null and  empty");
		}
		
		HttpSession session = getSession();
		if(session == null){
			throw new IllegalStateException("session is not exists");
		}
		
		session.removeAttribute(key.trim());
	}
}
