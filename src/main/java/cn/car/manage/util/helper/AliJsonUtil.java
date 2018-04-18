package cn.car.manage.util.helper;

import java.util.List;

import com.alibaba.fastjson.JSON;


/**
 * 
 * @Description: 阿里FastJson工具, 要求被解析的JavaBean必须有无参构造方法, 属性必须有get和set方法
 * @User: 
 * @Date: 2016年3月20日 上午1:24:54
 */
public class AliJsonUtil implements JsonUtil{

	
	/**
	 * 
	 * @Description: 将JavaBean转为JSON格式字符串 
	 * @User: 
	 * @Date: 2016年3月20日 上午1:23:06
	 * @param object
	 * @return
	 */
	public static <T> String toJson(T object) {
		return GsonUtil.toJson(object);
	}
	
	/**
	 * 
	 * @Description: 将JSON字符串转换为JavaBean 
	 * @User: 
	 * @Date: 2016年3月20日 上午1:23:16
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T fromJson(String json, Class<? extends T> clazz){
		return JSON.parseObject(json, clazz);
	}
	
	/**
	 * 
	 * @Description: 将JSON格式字符串转换为List<JavaBean> 
	 * @User: 
	 * @Date: 2016年3月20日 上午1:23:42
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> fromJsonArray(String json, Class<T> clazz) {
		return JSON.parseArray(json, clazz);
	}
	
	

}
