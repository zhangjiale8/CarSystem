package cn.car.manage.exception;

import cn.car.manage.pub.statuscode.StatusCode;
import cn.car.manage.util.helper.RequestUtil;

/**
 * 
 * @Description: 系统业务逻辑处理失败抛出的异常 
 * @User: 
 * @Date: 2016年3月11日 下午1:02:11
 */
public class EVMException extends RuntimeException{

	/**  */
	private static final long serialVersionUID = 1L;

	public EVMException() {
		super();
	}

	public EVMException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EVMException(String message, Throwable cause) {
		super(message, cause);
	}

	public EVMException(String message) {
		super(message);
	}

	public EVMException(Throwable cause) {
		super(cause);
	}
	
	
	/**
	 * 使用状态码初始化异常信息
	 * @param statusCode
	 */
	public EVMException(int code){
		this(code, false);
	}
	
	
	/**
	 * 强制覆盖已有状态信息
	 * @param code 
	 * @param forceCover
	 */
	public EVMException(int code, boolean forceCover){
		RequestUtil.setStatusCode(code, forceCover);
	}
	
	/**
	 * 使用状态对象初始化异常信息
	 * @param statusCode
	 */
	public EVMException(StatusCode statusCode){
		this(statusCode, false);
	}
	
	
	/**
	 * 强制覆盖已有状态信息
	 * @param statusCode 
	 * @param forceCover
	 */
	public EVMException(StatusCode statusCode, boolean forceCover){
		RequestUtil.setStatusCode(statusCode, forceCover);
	}
	
}
