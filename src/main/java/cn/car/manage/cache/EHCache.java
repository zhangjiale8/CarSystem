package cn.car.manage.cache;


/**
 * 
 * @Description: EHCache缓存框架 
 * @User: 
 * @Date: 2016年6月28日 上午10:13:19
 */
public class EHCache implements Cache{
	
	/**
	 * 永久缓存区
	 */
	public static final String PER_CACHE_INSTANCE = "PerCache";
	
	/**
	 * 临时缓存区
	 */
	public static final String TEMP_CACHE_INSTANCE = "TempCache";

	@Override
	public boolean exists(Object instance) {
		if(instance == null){
			return false;
		}
		
		if(instance.toString().trim().equalsIgnoreCase(PER_CACHE_INSTANCE) || instance.toString().trim().equalsIgnoreCase(TEMP_CACHE_INSTANCE)){
			return true;
		}
		
		return false;
	}

	@Override
	public boolean newInstance(Object instance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean put(Object instance, String key, Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean putIfAbsent(Object instance, String key, Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean get(Object instance, String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getOrDefault(Object instance, String key, Object defaultValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeInstance(Object instance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object instance, String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getOrLoad(Object instance, String key, CacheLoader loader) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
