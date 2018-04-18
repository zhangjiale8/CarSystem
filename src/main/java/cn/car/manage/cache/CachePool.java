package cn.car.manage.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * 
 * @Description: 缓存池
 * @User: 
 * @Date: 2016年3月9日 下午2:05:34
 */
public class CachePool {
	
	private static final ConcurrentHashMap<String, Cache<Object, Object>> CACHES = new ConcurrentHashMap<String, Cache<Object, Object>>();
	
	
	ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	
	
	/**
	 * 
	 * @Description: 初始化缓存池 
	 * @User: 
	 * @Date: 2016年3月9日 下午2:16:49
	 * @param primaryKey
	 * @param keyType
	 * @param valueType
	 * @return
	 */
	public static boolean init(String primaryKey){
		if(primaryKey == null || primaryKey.trim().isEmpty()){
			return false;
		}
		
		Cache<Object, Object> cache = CacheBuilder.newBuilder().build();
		CACHES.putIfAbsent(primaryKey.trim().toUpperCase(), cache);
		return true;
	}
	
	
	/**
	 * 
	 * @Description: 获取缓存 
	 * @User: 
	 * @Date: 2016年3月9日 下午2:23:08
	 * @param primaryKey
	 * @return
	 */
	public static Cache<Object, Object> getCache(String primaryKey){
		if(primaryKey == null || primaryKey.trim().isEmpty()){
			return null;
		}
		
		return CACHES.getOrDefault(primaryKey.trim().toUpperCase(), null);
	}
	
	
	/**
	 * 
	 * @Description: 存放缓存数据 
	 * @User: 
	 * @Date: 2016年3月9日 下午2:21:24
	 * @param primaryKey
	 * @param key
	 * @param value
	 */
	public static void put(String primaryKey, Object key, Object value){
		if(!CACHES.containsKey(primaryKey.trim().toUpperCase())){
			throw new RuntimeException(primaryKey + " is not exist, please init cache with " + primaryKey);
		}
		
		if(key == null || value == null){
			throw new RuntimeException(key + " and " + value + " can not be null");
		}
		
		CACHES.get(primaryKey.trim().toUpperCase()).put(key, value);
	}
	
	
	/**
	 * 
	 * @Description: 存入缓存数据 
	 * @User: 
	 * @Date: 2016年3月9日 下午2:38:26
	 * @param primaryKey
	 * @param map
	 */
	public static void putAll(String primaryKey, Map<Object, Object> map){
		if(!CACHES.containsKey(primaryKey.trim().toUpperCase())){
			throw new RuntimeException(primaryKey + " is not exist, please init cache with " + primaryKey + " first");
		}
		
		if(map == null){
			throw new RuntimeException("cache can not put null");
		}
		
		CACHES.get(primaryKey.trim().toUpperCase()).putAll(map);
	}
	
	
	/**
	 * 
	 * @Description: 获缓存值
	 * @User: 
	 * @Date: 2016年3月9日 下午2:25:39
	 * @param primaryKey
	 * @param key
	 * @return
	 */
	public static Object get(String primaryKey, Object key){
		if(!CACHES.containsKey(primaryKey.trim().toUpperCase())){
			throw new RuntimeException(primaryKey + " is not exist, please init cache with " + primaryKey);
		}
		
		return CACHES.get(primaryKey.trim().toUpperCase()).getIfPresent(key);
	}
	
	
	/**
	 * 
	 * @Descriptin: 获取缓存值,如果不存在则返回默认值 
	 * @User: 
	 * @Date: 2016年3月10日 上午10:10:16
	 * @param primaryKey
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static Object getOrDefault(String primaryKey, Object key, Object defaultValue){
		if(!CACHES.containsKey(primaryKey.trim().toUpperCase())){
			return defaultValue;
		}
		
		Object obj = CACHES.get(primaryKey.trim().toUpperCase()).getIfPresent(key);
		return obj == null ? defaultValue : obj;
	}
	
	
	/**
	 * 
	 * @Description: 清空缓存
	 * @User: 
	 * @Date: 2016年3月9日 下午2:27:32
	 * @param primaryKey
	 */
	public static void clean(String primaryKey){
		if(primaryKey != null && !primaryKey.trim().isEmpty() && CACHES.containsKey(primaryKey.trim().toUpperCase())){
			CACHES.get(primaryKey.trim().toUpperCase()).cleanUp();
		}
	}
	
	
	/**
	 * 
	 * @Description: 移除缓存 
	 * @User: 
	 * @Date: 2016年3月9日 下午2:28:29
	 * @param primaryKey
	 */
	public static void remove(String primaryKey){
		if(primaryKey != null && !primaryKey.trim().isEmpty() && CACHES.containsKey(primaryKey.trim().toUpperCase())){
			CACHES.get(primaryKey.trim().toUpperCase()).cleanUp();
			CACHES.remove(primaryKey.trim().toUpperCase());
		}
	}
}
