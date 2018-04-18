package cn.car.manage.cache;

public interface Cache { 
	
	
	/**
	 * 
	 * @Description: 判断实例缓存对象是否存在
	 * @User: 
	 * @Date: 2016年6月28日 上午9:51:05
	 * @param instance
	 * @return
	 */
	public abstract boolean exists(Object instance);
	
	
	/**
	 * 
	 * @Description: 新建一个缓存实例
	 * @User: 
	 * @Date: 2016年6月28日 上午9:52:02
	 * @param instance
	 * @return
	 */
	public boolean newInstance(Object instance);
	
	
	/**
	 * 
	 * @Description: 向指定缓存实例中添加缓存内容 
	 * @User: 
	 * @Date: 2016年6月28日 上午9:53:42
	 * @param instance
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean put(Object instance, String key, Object value);
	
	
	/**
	 * 
	 * @Description: 如果缓存实例中不存在指定Key则向该缓存实例中添加缓存数据
	 * @User: 
	 * @Date: 2016年6月28日 上午9:54:28
	 * @param instance
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean putIfAbsent(Object instance, String key, Object value);
	
	/**
	 * 
	 * @Description: 获取缓存数据 
	 * @User: 
	 * @Date: 2016年6月28日 上午10:03:13
	 * @param instance
	 * @param key
	 * @return
	 */
	public boolean get(Object instance, String key);
	
	
	/**
	 * 
	 * @Description: 获取缓存数据, 如果Key不存在则返回默认值
	 * @User: 
	 * @Date: 2016年6月28日 上午10:03:45
	 * @param instance
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public boolean getOrDefault(Object instance, String key, Object defaultValue);
	
	
	/**
	 * 
	 * @Description: 如果实例中Key不存在则Load 
	 * @User: 
	 * @Date: 2016年6月28日 上午11:17:33
	 * @param instance
	 * @param key
	 * @return
	 */
	public boolean getOrLoad(Object instance, String key, CacheLoader loader);
	
	
	/**
	 * 
	 * @Description: 删除缓存实例 
	 * @User: 
	 * @Date: 2016年6月28日 上午10:01:31
	 * @param instance
	 * @return
	 */
	public boolean removeInstance(Object instance);
	
	
	/**
	 * 
	 * @Description: 删除指定实例中的缓存数据 
	 * @User: 
	 * @Date: 2016年6月28日 上午10:02:02
	 * @param instance
	 * @param key
	 * @return
	 */
	public boolean delete(Object instance, String key);
}
