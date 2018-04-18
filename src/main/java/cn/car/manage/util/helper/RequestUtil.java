package cn.car.manage.util.helper;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import cn.car.manage.cache.CachePool;
import cn.car.manage.pub.statuscode.StatusCode;
import cn.car.manage.pub.statuscode.StatusCodeRegistry;


/**
 * 
 */
public class RequestUtil {

	/** 请求保存状态码的属性名称 */
	public static final String STATUS_CODE = "statusCode";
	
	/**
	 * @Description: 根据数据转发类型生成ModelAndView
	 * @param response HttpServletResponse对象
	 * @param object 数据对象
	 * @param attributeName 数据对象保存的名称
	 * @param forward 转发类型
	 * @return the model and view
	 * @User: 
	 * @Date: 2015年7月16日 下午6:22:24
	 */
	public static ModelAndView requestForward(HttpServletResponse response, Object object, String attributeName, String forward){
		
		ModelAndView view = null;
		
		if(forward != null && "JSON".equalsIgnoreCase(forward.trim())){
			if(object instanceof String){
				ResponseUtil.responseWriteJson(response, object.toString());
			}else{
				ResponseUtil.responseWriteJson(response, object);
			}
			
			return view;
		}
		
		view = new ModelAndView(forward);
		if(object != null){
			view.getModel().put(attributeName, object);
		}
		
		return view;
	}
	
	
	/**
	 * 
	 * @Description: 返回状态信息 
	 * @User: 
	 * @Date: 2016年3月20日 上午9:09:18
	 * @param response
	 * @param code
	 * @param forward
	 * @return
	 */
	public static ModelAndView requestForward(HttpServletResponse response, int code, String forward){
		ModelAndView view = null;
		StatusCode statusCode = (StatusCode)CachePool.getOrDefault("statusCode", code, null);
		if(statusCode == null){
			throw new RuntimeException("未找到相应的状态信息");
		}
		
		if(forward != null && "JSON".equalsIgnoreCase(forward.trim())){
			ResponseUtil.responseWriteJson(response, statusCode.getMessage());
			return view;
		}
		
		view = new ModelAndView();
		view.getModel().put("statusCode", statusCode);
		return view;
	}
	
	
	/**
	 * Parameters convert to map.
	 *
	 * @param request the request
	 * @return the hash map
	 * @方法功能描述: 提取request中的参数名称以及值生成HashMap<String,Object>
	 * @创建者: 
	 * @创建时间:2015年4月9日 下午3:16:41
	 * @最后修改用户: 
	 * @最后修改时间:2015年4月9日 下午3:16:41<br/>
	 */
	public static HashMap<String,Object> parametersConvertToMap(HttpServletRequest request){
		
		HashMap<String,Object> map=new HashMap<String,Object>();
		
		Enumeration<String> enu= request.getParameterNames();
		
		while(enu.hasMoreElements()){
			
			Object key=enu.nextElement();
			
			Object value=request.getParameter(key.toString());
			map.put(key.toString(), value);
			
		}
		
		return map;
		
	}
	
	
	/**
	 * Parameters convert to map.
	 *
	 * @param request the request
	 * @param srcCharset the src charset
	 * @param dstCharset the dst charset
	 * @return the hash map
	 * @方法功能描述: 提取request中的参数名称以及值生成HashMap<String,Object>，如果参数为字符串，则可以转为指定字符集
	 * @创建者:
	 * @创建时间:2015年4月9日 下午3:15:14
	 * @最后修改用户: 
	 * @最后修改时间:2015年4月9日 下午3:15:14<br/>
	 */
	public static HashMap<String,Object> parametersConvertToMap(HttpServletRequest request,String srcCharset,String dstCharset){
		
		HashMap<String,Object> map=new HashMap<String,Object>();
		
		Enumeration<String> enu=request.getParameterNames();
		
		while(enu.hasMoreElements()){
			
			Object key=enu.nextElement();
			
			Object value=request.getParameter(key.toString());
			
			if(value instanceof String){
				
				try {
					
					value=new String(value.toString().getBytes(srcCharset),dstCharset);
					
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
			}
			
			map.put(key.toString().toUpperCase(), value);
			
		}
		
		return map;
		
	}
	
	
	/**
	 * 
	 * @Description: 获取HttpServletRequest 
	 * @User: 
	 * @Date: 2016年3月20日 上午10:30:51
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		if(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()) == null){
			return null;
		}
		
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	
	/**
	 * 
	 * @Description: 获取用户session 
	 * @User: 
	 * @Date: 2016年3月15日 上午11:56:27
	 * @return
	 */
	public static HttpSession getSession(){
		return getRequest().getSession();
	}
	
	
	/**
	 * 
	 * @Description: 获取项目根路径 
	 * @User: 
	 * @Date: 2016年3月15日 上午11:57:06
	 * @return
	 */
	public static String getRootPath(){
		return getSession().getServletContext().getRealPath("/");
	}
	
	
	/**
	 * 
	 * @Description: 判断当前请求是否为ajax请求 
	 * @User: 
	 * @Date: 2016年4月7日 下午5:44:36
	 * @return
	 */
	public static boolean isAjax(){
		HttpServletRequest request = getRequest();
		return request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest") ? true : false;
	}
	
	
	/**
	 * 
	 * @Description: 设置当前请求的状态码 
	 * @User: 
	 * @Date: 2016年4月8日 上午11:46:43
	 * @param code
	 */
	public static void setStatusCode(int code, boolean forceCover){
		StatusCode statusCode = StatusCodeRegistry.get(code);
		HttpServletRequest request = getRequest();
		if(request != null && statusCode != null){
			if(request.getAttribute(STATUS_CODE) == null || forceCover){
				request.setAttribute(STATUS_CODE, statusCode);
			}
		}
	}
	
	/**
	 * 
	 * @Description: 设置当前请求的状态码
	 * @User: 
	 * @Date: 2016年4月8日 上午11:47:30
	 * @param statusCode
	 */
	public static void setStatusCode(StatusCode statusCode, boolean forceCover){
		HttpServletRequest request = getRequest();
		if(request != null || statusCode != null){
			if(request.getAttribute(STATUS_CODE) == null || forceCover){
				request.setAttribute(STATUS_CODE, statusCode);
			}
		}
	}
	
	
	/**
	 * 
	 * @Description: 获取当前请求中的状态码 
	 * @User: 
	 * @Date: 2016年4月8日 上午11:50:01
	 * @return
	 */
	public static StatusCode getStatusCode(){
		HttpServletRequest request = getRequest();
		if(request == null){
			return null;
		}
		
		return (StatusCode)request.getAttribute(STATUS_CODE);
	} 
	
	
	/**
	 * 
	 * @Description: 移除当前请求中的状态码 
	 * @User: 
	 * @Date: 2016年4月8日 上午11:50:42
	 */
	public static void removeStatusCode(){
		HttpServletRequest request = getRequest();
		if(request != null){
			request.removeAttribute(STATUS_CODE);
		}
	}
	
	public static String isLocalhost(String ip){
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
}
