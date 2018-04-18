package cn.car.manage.pub.enums;


/**
 * 
 * @Description: http错误状态码对应的错误页面
 * @User: 
 * @Date: 2016年3月20日 下午9:23:58
 */
public interface HttpStatus {
	
	/**
	 * 401: (未授权)请求要求身份验证。
	 */
	public static final String CODE_401 = "/401";
	
	/**
	 * 403: 服务器拒绝请求。
	 */
	public static final String CODE_403 = "/403";
	
	/**
	 * 404: 服务器找不到请求。
	 */
	public static final String CODE_404 = "/404";
	
	/**
	 * 408: (请求超时)服务器等候请求时发生超时。
	 */
	public static final String CODE_408 = "/408";
	
	/**
	 * 服务器遇到错误，无法完成请求。
	 */
	public static final String CODE_500 = "/500";
	
	/**
	 * 服务器目前无法使用。
	 */
	public static final String CODE_503 = "/503";
	
}
