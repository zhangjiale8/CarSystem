package cn.car.manage.util.helper;


/**
 * 
 * @Description: 类型转换工具类 
 * @User: 
 * @Date: 2015年11月12日 下午3:35:52
 */
public class TypeConvert {
	
	
	/**
	 * 
	 * @Description: 将字符串转换为整型,如果转换失败则返回指定的默认值
	 * @User: 
	 * @Date: 2015年11月12日 下午4:34:13
	 * @param str
	 * @param defaultValue
	 * @return
	 */
	public static int parseIntOrDefault(String str, int defaultValue){
		
		if(str == null || str.trim().isEmpty()){
			return defaultValue;
		}
		
		if(str.contains(",")){
			str = str.replace(",", "");
		}
		
		if(str.indexOf(".") != -1){
			str = str.substring(0, str.indexOf("."));
		}
		
		try{
			return Integer.parseInt(str.trim());
		}catch(Exception e){
			return defaultValue;
		}
	}
	
	
	/**
	 * 
	 * @Description: 将对象转换为整型,如果转换失败则返回默认值
	 * @User: 
	 * @Date: 2015年11月12日 下午5:38:27
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static int parseIntOrDefault(Object obj, int defaultValue){
		if(obj == null){
			return defaultValue;
		}
		
		try{
			return parseIntOrDefault(obj.toString(), defaultValue);
		}catch(Exception e){
			return defaultValue;
		}
	}
	
	
	
	/**
	 * 
	 * @Description: 将字符串转换为浮点型,如果转换失败则返回默认值
	 * @User: 
	 * @Date: 2015年11月13日 上午9:31:19
	 * @param str
	 * @param defaultValue
	 * @return
	 */
	public static float parseFloatOrDefault(String str, float defaultValue){
		
		if(str == null || str.trim().isEmpty()){
			return defaultValue;
		}
		
		if(str.contains(",")){
			str = str.replace(",", "");
		}
		
		try{
			return Float.parseFloat(str.trim());
		}catch(Exception e){
			return defaultValue;
		}
	}
	
	
	/**
	 * 
	 * @Description: 将对象转换为浮点型,如果转换失败则返回默认值 
	 * @User: 
	 * @Date: 2015年11月13日 上午9:32:13
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static float parseFloatOrDefault(Object obj, float defaultValue){
		if(obj == null){
			return defaultValue;
		}
		
		try{
			return parseFloatOrDefault(obj.toString(), defaultValue);
		}catch(Exception e){
			return defaultValue;
		}
	}
	
	
	/**
	 * 
	 * @Description: 将字符串转换为双精度浮点型,如果转换失败则返回默认值
	 * @User: 
	 * @Date: 2015年11月13日 上午9:33:27
	 * @param str
	 * @param defaultValue
	 * @return
	 */
	public static double parseDoubleOrDefault(String str, double defaultValue){
		
		if(str == null || str.trim().isEmpty()){
			return defaultValue;
		}
		
		if(str.contains(",")){
			str = str.replace(",", "");
		}
		
		try{
			return Double.parseDouble(str.trim());
		}catch(Exception e){
			return defaultValue;
		}
	}
	
	
	/**
	 * 
	 * @Description: 将对象转换为双精度浮点型,如果转换失败则返回默认值 
	 * @User: 
	 * @Date: 2015年11月13日 上午9:32:13
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static double parseFloatOrDefault(Object obj, double defaultValue){
		if(obj == null){
			return defaultValue;
		}
		
		try{
			return parseFloatOrDefault(obj.toString(), defaultValue);
		}catch(Exception e){
			return defaultValue;
		}
	}
	
	
	/**
	 * 
	 * @Description: 
	 * @User: 
	 * @Date: 2015年12月2日 下午3:44:10
	 * @param str
	 * @param defaultValue
	 * @return
	 */
	public static long parseLongOrDefault(String str, long defaultValue){
		
		if(str == null || str.trim().isEmpty()){
			return defaultValue;
		}
		
		try{
			return Long.parseLong(str);
		}catch(Exception e){
			return defaultValue;
		}
	}
	
	
	public static long parseLongOrDefault(Object obj, long defaultValue){
		
		if(obj == null){
			return defaultValue;
		}
		
		try{
			return parseLongOrDefault(obj.toString(), defaultValue);
		}catch(Exception e){
			return defaultValue;
		}
	}
}
