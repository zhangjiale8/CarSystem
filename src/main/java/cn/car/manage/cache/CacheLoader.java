package cn.car.manage.cache;

/**
 * 
 * @Description: 缓存加载器 
 * @User: 
 * @Date: 2016年6月28日 上午11:19:35
 */
public interface CacheLoader {

	public Object load(Cache cache, Object instance, String key);
}
