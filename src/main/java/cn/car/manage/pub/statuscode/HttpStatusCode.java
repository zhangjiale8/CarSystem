package cn.car.manage.pub.statuscode;

import cn.car.manage.pub.enums.CodeStatus;

/**
 * 
 * @Description: 标准http请求状态码 
 * @User: 
 * @Date: 2016年3月21日 上午9:50:25
 */
public interface HttpStatusCode {
	
	
	/**
	 * 200, 请求已成功
	 */
	public static final StatusCode HTTP_200 = new StatusCode(200, " 请求已成功", CodeStatus.SUCCSSS.getValue(), "");
	
	
	/**
	 * 401, 当前请求需要用户验证
	 */
	public static final StatusCode HTTP_401 = new StatusCode(401, "当前请求需要用户验证", CodeStatus.FAILURE.getValue(), "");
	
	
	/**
	 * 403, 服务器已经理解请求，但是拒绝执行
	 */
	public static final StatusCode HTTP_403 = new StatusCode(403, "服务器已经理解请求，但是拒绝执行", CodeStatus.FAILURE.getValue(), "");
	
	
	/**
	 * 404, 请求失败，请求所希望得到的资源未被在服务器上发现
	 */
	public static final StatusCode HTTP_404 = new StatusCode(404, "请求失败，请求所希望得到的资源未被在服务器上发现", CodeStatus.FAILURE.getValue(), "");
	
	
	/**
	 * 408, 请求超时
	 */
	public static final StatusCode HTTP_408 = new StatusCode(408, "请求超时", CodeStatus.FAILURE.getValue(), "");
	
	
	/**
	 * 500, 服务器遇到了一个未曾预料的状况，导致了它无法完成对请求的处理
	 */
	public static final StatusCode HTTP_500 = new StatusCode(500, "服务器遇到了一个未曾预料的状况，导致了它无法完成对请求的处理", CodeStatus.FAILURE.getValue(), "");
	
	
	/**
	 * 503, 由于临时的服务器维护或者过载，服务器当前无法处理请求
	 */
	public static final StatusCode HTTP_503 = new StatusCode(503, "由于临时的服务器维护或者过载，服务器当前无法处理请求", CodeStatus.FAILURE.getValue(), "");
}
