package cn.car.manage.util.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @Description: 数值工具类 
 * @User: 
 * @Date: 2016年3月9日 上午11:12:01
 */
public class NumberUtil {
	
	private static final String SEPARATOR = ",";
	private static final Pattern NON_NUMBER_PATTERN = Pattern.compile("[^0-9]");
	private static final char DECIMAL = '.';
	
	/**
	 * 
	 * @Description: 将字符串转换为整型，如果转换失败则返回默认值 
	 * @User: 
	 * @Date: 2016年3月9日 上午11:14:05
	 * @param str
	 * @param defaultValue
	 * @return
	 */
	public static Integer parseIntOrDefault(String str, Integer defaultValue){
		if(str == null || str.trim().isEmpty()){
			return defaultValue;
		}
		
		str = removeSpecialCharacter(str, false);
		if(str == null || str.trim().isEmpty()){
			return defaultValue;
		}
		
		try{
			return Integer.parseInt(str.trim());
		}catch(Exception e){
			e.printStackTrace();
			return defaultValue;
		}
	}
	
	
	/**
	 * 
	 * @Description: 将对象转换为整型,如果转换失败则返回默认值 
	 * @User: 
	 * @Date: 2016年4月5日 上午11:41:53
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static Integer parseIntOrDefault(Object obj, Integer defaultValue){
		if(obj == null){
			return defaultValue;
		}
		
		return parseIntOrDefault(obj.toString(), defaultValue);
	}
	
	
	/**
	 * 
	 * @Description: 将字符串转换为长整型, 如果转换失败则返回认值 
	 * @User: 
	 * @Date: 2016年3月9日 上午11:18:23
	 * @param str
	 * @param defaultValue
	 * @return
	 */
	public static Long parseLongOrDefault(String str, Long defaultValue){
		if(str == null || str.trim().isEmpty()){
			return defaultValue;
		}
		
		str = removeSpecialCharacter(str, false);
		if(str == null || str.trim().isEmpty()){
			return defaultValue;
		}
		
		try{
			return Long.parseLong(str.trim());
		}catch(Exception e){
			e.printStackTrace();
			return defaultValue;
		}
	}
	
	
	/**
	 * 
	 * @Description: 将对象转换为长整型, 如果转换失败则返回认值
	 * @User: 
	 * @Date: 2016年4月5日 上午11:43:25
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static Long parseLongOrDefault(Object obj, Long defaultValue){
		if(obj == null){
			return defaultValue;
		}
		
		return parseLongOrDefault(obj.toString(), defaultValue);
	}
	
	
	/**
	 * 
	 * @Description: 将字符串转为单精度浮点型, 如果转换失败则返回默认值
	 * @User: 
	 * @Date: 2016年3月9日 上午11:15:40
	 * @param str
	 * @param defaultValue
	 * @return
	 */
	public static Float parseFloatOrDefault(String str, Float defaultValue){
		if(str == null || str.trim().isEmpty()){
			return defaultValue;
		}
		
		/*str = removeSpecialCharacter(str, true);
		if(str == null || str.trim().isEmpty()){
			return defaultValue;
		}*/
		
		try{
			return Float.parseFloat(str.trim());
		}catch(Exception e){
			e.printStackTrace();
			return defaultValue;
		}
	}
	
	
	/**
	 * 
	 * @Description: 将对象转为单精度浮点型, 如果转换失败则返回默认值
	 * @User: 
	 * @Date: 2016年4月5日 上午11:44:38
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static Float parseFloatOrDefault(Object obj, Float defaultValue){
		if(obj == null){
			return defaultValue;
		}
		
		return parseFloatOrDefault(obj.toString(), defaultValue);
	}
	
	
	/**
	 * 
	 * @Description: 将字符串转换为双精度浮点型, 如果转换失败则返回默认值
	 * @User: 
	 * @Date: 2016年3月9日 上午11:17:01
	 * @param str
	 * @param defaultValue
	 * @return
	 */
	public static Double parseDoubleOrDefault(String str, Double defaultValue){
		if(str == null || str.trim().isEmpty()){
			return defaultValue;
		}
		
		/*str = removeSpecialCharacter(str, true);
		if(str == null || str.trim().isEmpty()){
			return defaultValue;
		}*/
		
		try{
			return Double.parseDouble(str.trim());
		}catch(Exception e){
			e.printStackTrace();
			return defaultValue;
		}
	}
	
	
	/**
	 * 
	 * @Description: 将对象转换为双精度浮点型, 如果转换失败则返回默认值
	 * @User: 
	 * @Date: 2016年4月5日 上午11:45:54
	 * @param str
	 * @param defaultValue
	 * @return
	 */
	public static Double parseDoubleOrDefault(Object obj, Double defaultValue){
		if(obj == null){
			return defaultValue;
		}
		
		return parseDoubleOrDefault(obj.toString(), defaultValue);
	}
	
	
	/**
	 * 去除字符串中的特殊字符
	 * @param str 被处理的字符串
	 * @param retainDecimal 是否保留小数位
	 * @return
	 */
	private static String removeSpecialCharacter(String str, boolean retainDecimal){
		if(str == null || str.trim().isEmpty()){
			return str;
		}
		
		//去掉所有的千位分隔符
		str = str.trim().replaceAll(SEPARATOR, "");
		
		//如果数值是以.开头
		if(str.charAt(0) == DECIMAL){
			str = "0" + str;
		}
		
		//如果包含两个小数点
		if(str.indexOf(DECIMAL) != str.lastIndexOf(DECIMAL)){
			return null;
		}
		
		Matcher matcher = NON_NUMBER_PATTERN.matcher(str);
		int startIndex = 0;
		int endIndex = str.length();
		while(matcher.find()){
			int index = matcher.start();
			//如果开头
			if(index == 0){
				startIndex = index + 1;
				continue; 
			}else if(!retainDecimal && str.charAt(index) == DECIMAL){
				endIndex = index;
				break;
			}else if(retainDecimal && str.charAt(index) == DECIMAL){
				continue;
			}else{
				endIndex = index;
				break;
			}
		}
		str = str.substring(startIndex, endIndex);
		return str;
	}
}
