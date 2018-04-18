package cn.car.manage.util.helper;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;


public class ResponseUtil {
	
	public static final Logger logger = Logger.getLogger(ResponseUtil.class);

	/**
	 *
	 * @方法功能描述: 通过Response向客户端返回JSON格式字符串
	 * @param response
	 * @param object
	 * @创建者:
	 * @创建时间:2015年4月9日 下午3:14:56
	 * @最后修改用户:
	 * @最后修改时间:2015年4月9日 下午3:14:56<br/>
	 */
	public static void responseWriteJson(HttpServletResponse response, Object object) {
		if (null == response || object == null) {
			return;
		}
		
		responseWriteJson(response, AliJsonUtil.toJson(object));
	}

	/**
	 *
	 * @方法功能描述: 通过Response向客户端返回内容
	 * @param response
	 * @param str
	 * @创建者:
	 * @创建时间:2015年4月9日 下午3:11:23
	 * @最后修改用户:
	 * @最后修改时间:2015年4月9日 下午3:11:23<br/>
	 */
	public static void responseWriteJson(HttpServletResponse response, String str) {
		
		if (response == null || str == null) {
			return;
		}

		
		response.reset();
		response.setContentType("text/html;charset=UTF-8");

		try {
			OutputStream os = response.getOutputStream();
			if(os != null){
				os.write(str.getBytes("UTF-8"));
				os.flush();
			}
		} catch (IOException e) {
			Console.error("response写回数据发生异常, exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	/**
     * 返回失败
     * @param errorMsg 错误信息
     * @return 输出失败的JSON格式数据
     */
    public static String responseFail(String errorMsg){
    	JSONObject jsonObj = new JSONObject();
    	jsonObj.put(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, true);
    	jsonObj.put(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, errorMsg);
       
        return jsonObj.toString();
    }
	
	/**
	 * 
	 * @Description: 获取HttpServletResponse对象 
	 * @User: 
	 * @Date: 2016年3月20日 下午12:40:39
	 * @return
	 */
	public static HttpServletResponse getResponse(){
		if(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()) == null){
			return null;
		}
		
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
}
