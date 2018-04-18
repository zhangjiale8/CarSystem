package cn.car.manage.pub.interfaces;


/**
 * 
 * @Description: Controller层接口 
 * @User: 
 * @Date: 2016年3月21日 下午2:02:46
 */
public interface BaseController {
	
	/**
	 * request请求返回JSON格式结果时的Key名称
	 */
	public static final String REQUEST_RESULT_NAME = "result";
	
	
	/**
	 * 返回状态码的属性名称 
	 */
	public static final String STATUS_CODE_NAME = "statusCode";
	
	
	/**
	 * response返回结果为json格式
	 */
	public static final String RESPONSE_JSON = "json";
	
}
