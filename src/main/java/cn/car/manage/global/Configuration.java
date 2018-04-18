package cn.car.manage.global;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * 
 * @Description: 系统全局配置 
 * @User: 
 * @Date: 2018年3月6日 上午11:36:25
 */
public class Configuration {
	
	private static final Cache<String, Object> CONFIGS = CacheBuilder.newBuilder().build();
	private static Properties PROPERTIES = new Properties();
	static{
		try {
			PROPERTIES.load(Configuration.class.getClassLoader().getResourceAsStream("configs.properties"));
			for(Entry<Object, Object> entry : PROPERTIES.entrySet()){
				if(entry.getKey() == null || entry.getValue() == null){
					continue;
				}
				CONFIGS.put(entry.getKey().toString(), entry.getValue());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			PROPERTIES.clear();
			PROPERTIES = null;
		}
	}

	
	/**
	 * 
	 * @Description: 保存配置, 如果key已存在则替换原有的值
	 * @User: 
	 * @Date: 2018年3月6日 下午10:45:35
	 * @param key
	 * @param value
	 */
	public static void put(String key, Object value){
		CONFIGS.put(key, value);
	}
	
	
	/**
	 * 
	 * @Description:  保存配置, 如果Key不存在则存入
	 * @User: 
	 * @Date: 2018年3月6日 下午10:27:53
	 * @param key
	 * @param value
	 */
	public static void putIfAbsent(String key, Object value){
		if(CONFIGS.getIfPresent(key) == null){
			CONFIGS.put(key, value);
		}
	}
	
	
	/**
	 * 
	 * @Description: 获取配置, 如果Key不存在则返回默认值
	 * @User: 
	 * @Date: 2018年3月6日 下午10:44:25
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static Object getOrDefault(String key, Object defaultValue){
		if(key == null || key.trim().isEmpty()){
			return defaultValue;
		}
		
		Object obj = CONFIGS.getIfPresent(key);
		return obj == null ? defaultValue : obj;
	}
	
	
	public static void main(String[] args) {
		System.err.println(Configuration.getOrDefault("VERSION", null));
	}
}
