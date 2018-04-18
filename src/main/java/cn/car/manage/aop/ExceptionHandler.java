package cn.car.manage.aop;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;

import cn.car.manage.annotation.StatusCodeDefault;
import cn.car.manage.exception.EVMException;
import cn.car.manage.pub.enums.HttpStatus;
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.pub.statuscode.HttpStatusCode;
import cn.car.manage.pub.statuscode.StatusCode;
import cn.car.manage.util.helper.RequestUtil;
import cn.car.manage.util.helper.ResponseUtil;


/**
 * 
 * @Description: 异常统一处理 
 * @User: 
 * @Date: 2018年3月2日 下午4:26:28
 */
public class ExceptionHandler implements BaseController{
	
	
	/**
	 * 
	 * @Description:  
	 * @User: 
	 * @Date: 2018年3月2日 下午1:54:23
	 * @param point
	 * @return
	 */
	@Around(value=PointCuts.SERVICE)
	public Object around(ProceedingJoinPoint point){
		
		
		/**
		 * 1、请求开始,拦截Service层入口函数
		 * 2、如果入口函数指定了默认状态码,则将默认状态码保存在当前Request对象中
		 * 3、当请求处理过程中抛出异常时, 如果指定了新的状态码则覆盖之前状态码
		 * 4、在异常处理中获取当前请求中的状态码, 如果状态码为null则据根请求类型(普通请求和Ajax请求)返回500错误,使前端跳转到500错误页面, 如果状态码不为null则根据请求类型返回状态信息
		 */
		
		Object result = null;
		
		MethodSignature methodSignature = (MethodSignature)point.getSignature();
		Method method = methodSignature.getMethod();
		
		//如果当前函数定义了默认状态码则实始化当前请求的状态码为默认状态码
		if(method.isAnnotationPresent(StatusCodeDefault.class)){
			StatusCodeDefault statusCode = method.getAnnotation(StatusCodeDefault.class);
			int code = statusCode.code();
			RequestUtil.setStatusCode(code, false);
		}
		
		try {
			result = point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			
			HttpServletRequest request = RequestUtil.getRequest();
			HttpServletResponse response = ResponseUtil.getResponse();
			if(request != null && response != null){
				String responseType = request.getParameter("forward");
				responseType = responseType == null || responseType.trim().isEmpty() ? RESPONSE_JSON : responseType.trim();
				
				
				boolean isAjax = RequestUtil.isAjax();
				
				//业务异常
				if(e instanceof EVMException || e instanceof RuntimeException){
					StatusCode statusCode = RequestUtil.getStatusCode();
					
					try {
						if(statusCode == null){
							if(isAjax){
								response.sendError(HttpStatusCode.HTTP_500.getCode());
							}else{
								request.getRequestDispatcher(HttpStatus.CODE_500).forward(request, response);
							}
						}else{
							if(isAjax){
								RequestUtil.requestForward(response, statusCode, "statusCode", responseType);
							}else{
								request.getRequestDispatcher(responseType).forward(request, response);
							}
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (ServletException e1) {
						e1.printStackTrace();
					}
				}else{// 如果是非EVMException异常则直接返回500状态码
					try {
						response.sendError(HttpStatusCode.HTTP_500.getCode());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		return result;
	}

}
