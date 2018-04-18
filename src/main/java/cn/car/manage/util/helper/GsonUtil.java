package cn.car.manage.util.helper;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import cn.car.manage.annotation.GsonSerializeExclude;
import cn.car.manage.annotation.GsonUnSerializeExclude;

/**
 * 
 * @Description: Gson工具类, 提供对像的序列化和反序列化 
 * @User: 
 * @Date: 2016年2月25日 下午2:44:45
 */
public class GsonUtil {
	
	/**
	 * 属性为日期类型序列化后的输出格式
	 */
	private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 序列化时排除属性策略
	 */
	public static final GsonSerializeStrategy serializeStrategy = new GsonSerializeStrategy();
	
	/**
	 * 反序列化时排序属性策略
	 */
	public static final GsonUnSerializeStrategy unSerializeStrategy = new GsonUnSerializeStrategy();
	
	
	/**
	 * 
	 * @Description: 获取GsonBuilder对象 
	 * @User: CPC
	 * @Date: 2016年2月25日 下午3:05:56
	 * @return
	 */
	public static GsonBuilder builder(){
		return new GsonBuilder().setDateFormat(dateFormat);
	}
	
	
	/**
	 * 
	 * @Description: 获取Gson对象 
	 * @User: 
	 * @Date: 2016年2月25日 下午3:06:48
	 * @return
	 */
	public static Gson gson(){
		return new GsonBuilder().setDateFormat(dateFormat).create();
	}
	
	
	/**
	 * 
	 * @Description: 将对象序列化为JSON格式字符串(默认不序列化值为null的属性)
	 * @User: 
	 * @Date: 2016年2月25日 下午2:51:50
	 * @param object
	 * @return
	 */
	public static <T> String toJson(T object){
		return toJson(object, false);
	}
	
	
	/**
	 * 
	 * @Description: 将对象序列化为JSON格式字符串
	 * @User: 
	 * @Date: 2016年3月2日 上午11:57:59
	 * @param object
	 * @param serializeNulls
	 * @return
	 */
	public static <T> String toJson(T object, boolean serializeNulls){
		if(object == null){
			return "{}";
		}
		
		GsonBuilder builder = new GsonBuilder().setDateFormat(dateFormat).setExclusionStrategies(serializeStrategy);
		if(serializeNulls){
			builder.serializeNulls();
		}
		Gson gson = builder.create();
		return gson.toJson(object);
	}
	
	
	/**
	 * 
	 * @Description: 将JSON格式字符串反序列化为对象
	 * @User: 
	 * @Date: 2016年2月25日 下午2:58:35
	 * @param json
	 * @param cls
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> cls){
		if(json == null || json.trim().isEmpty()){
			return null;
		}
		GsonBuilder builder = new GsonBuilder().setDateFormat(dateFormat).setExclusionStrategies(unSerializeStrategy);
		Gson gson = builder.create();
		return gson.fromJson(json.trim(), cls);
	}
	
	
	/**
	 * 
	 * @Description: 将json格式字符串转为对象集合 
	 * @User: 
	 * @Date: 2016年2月29日 下午3:40:08
	 * @param json
	 * @param cls
	 * @return
	 */
	public static <T> List<T> fromJsonToList(String json, Class<? extends T> cls){
		if(json == null || json.trim().isEmpty()){
			return null;
		}
		GsonBuilder builder = new GsonBuilder().setDateFormat(dateFormat).setExclusionStrategies(unSerializeStrategy);
		Gson gson = builder.create();
		List<T> list = gson.fromJson(json.trim(), new TypeToken<List<T>>(){}.getType());
		List<T> lists = new ArrayList<T>();
		for(T t : list){
			String str = gson.toJson(t);
			lists.add(gson.fromJson(str, cls));
		}
		
		return lists;
	}
}


/**
 * 
 * @Description: Gson对象序列化属性排除策略
 * @User: 
 * @Date: 2016年2月25日 下午2:50:37
 */
class GsonSerializeStrategy implements ExclusionStrategy{

	@Override
	public boolean shouldSkipField(FieldAttributes field) {
		return field.getAnnotation(GsonSerializeExclude.class) != null;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}
}


/**
 * 
 * @Description: Gson字符串反序列化属性排序策略
 * @User: 
 * @Date: 2016年2月25日 下午2:53:24
 */
class GsonUnSerializeStrategy implements ExclusionStrategy{

	@Override
	public boolean shouldSkipField(FieldAttributes field) {
		return field.getAnnotation(GsonUnSerializeExclude.class) != null;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}
	
}