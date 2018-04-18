package cn.car.manage.pub.statuscode;

import java.util.Hashtable;

import cn.car.manage.util.helper.Console;


/**
 * 
 * @Description: 状态注册中心 
 * @User: 
 * @Date: 2016年4月7日 下午6:03:31
 */
public class StatusCodeRegistry {

	/** 状态集合 */
	private static final Hashtable<Integer, StatusCode> CODES = new Hashtable<Integer, StatusCode>();
	
	
	/**
	 * 
	 * @Description: 注册状态 
	 * @User: CPC
	 * @Date: 2016年4月7日 下午4:25:51
	 * @param code
	 */
	public static void registry(StatusCode code){
		if(code != null && code.getCode() > 0){
			CODES.put(code.getCode(), code);
		}
	}
	
	
	/**
	 * 
	 * @Description: 
	 * @User: 
	 * @Date: 2016年4月7日 下午4:37:41
	 * @param code
	 * @return
	 */
	public static StatusCode get(StatusCode code){
		if(code == null || code.getCode() <= 0){
			return null;
		}
		
		return CODES.getOrDefault(code.getCode(), null);
	}
	
	
	/**
	 * 
	 * @Description: 
	 * @User: 
	 * @Date: 2016年4月7日 下午4:37:38
	 * @param code
	 * @return
	 */
	public static StatusCode get(int code){
		if(code <= 0){
			return null;
		}
		
		return CODES.getOrDefault(code, null);
	}
	
	
	public static void print(){
		Console.error(CODES);
	}
}
