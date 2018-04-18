package cn.car.manage.util.helper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CollectionUtils {

	
	/**
	 * 
	 * @Description: 将字符串按分隔符拆分, 将拆分后的每个元素转为int类型 
	 * @User:
	 * @Date: 2016年2月28日 下午12:47:50
	 * @param str
	 * @param separator
	 * @return
	 */
	public static List<Integer> splitToList(String str, String separator){
		if(str ==  null){
			return null;
		}
		
		separator = separator == null ? " " : separator;
		String[] els = str.trim().split(separator);
		
		List<Integer> values = new ArrayList<Integer>();
		for(String el : els){
			if(el != null && !el.trim().isEmpty()){
				values.add(Integer.parseInt(el.trim()));
			}
		}
		
		return values;
	}
	
	
	/**
	 * 
	 * @Description: 将List转换为HashMap, 以指定的属性值为Key, 对象为Value 
	 * @User: 
	 * @Date: 2016年3月3日 下午5:20:18
	 * @param fieldName
	 * @param list
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> HashMap<K, V> convertToMap(String fieldName, List<V> list) {
		HashMap<K, V> map = new HashMap<K, V>();
		if(list == null || list.isEmpty() || fieldName == null || fieldName.trim().isEmpty()){
			return map;
		}
		
		try{
			Field field = null;
			K fieldValue = null;
			for(V v : list){
				field = v.getClass().getDeclaredField(fieldName);
				if(!field.isAccessible()){
					field.setAccessible(true);
				}
				fieldValue = (K)field.get(v);
				if(fieldValue == null){
					continue;
				}
				
				map.put(fieldValue, v);
			}
			
			return map;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
