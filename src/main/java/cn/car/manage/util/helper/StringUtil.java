package cn.car.manage.util.helper;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @Description: 字符串相关工具类 
 * @User: 
 * @Date: 2015年11月13日 上午10:54:31
 */
public class StringUtil {

	
	/**
	 * @param str the str
	 * @param srcCharset the src charset
	 * @param dstCharset the dst charset
	 * @return the string
	 * @方法功能描述:将字符串进行转码 
	 * @创建者:
	 * @创建时间:2015年4月9日 下午2:59:06
	 * @最后修改用户:
	 * @最后修改时间:2015年4月9日 下午2:59:06<br/>
	 */
	public String charset(String str, String srcCharset, String dstCharset){
		
		if(str==null){
			
			return null;
			
		}
		
		if(srcCharset==null||srcCharset.trim().isEmpty()){
			
			srcCharset="ISO-8859-1";
			
		}
		
		if(dstCharset==null||dstCharset.trim().isEmpty()){
			
			dstCharset="UTF-8";
			
		}
		
		try {
			
			str=new String(str.getBytes(srcCharset), dstCharset);
			
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
		return str;
		
	}
	
	
	/**
	 * Upper case first.
	 *
	 * @param str the str
	 * @return the string
	 * @方法功能描述: 将字符串的开头字母变为大写
	 * @创建者:
	 * @创建时间:2015年7月8日 下午2:32:11
	 * @最后修改用户: 
	 * @最后修改时间:2015年7月8日 下午2:32:11
	 */
	public static String upperCaseFirst(String str){
		
		return str.substring(0, 1).toUpperCase().concat(str.substring(1));
		
	}
	
	
	/**
	 * Removes the end charts.
	 *
	 * @param string the string
	 * @param trim the trim
	 * @return the string
	 * @方法功能描述: 移除字符串的最后一个字符
	 * @创建者:
	 * @创建时间:2015年4月9日 下午2:58:20
	 * @最后修改用户:
	 * @最后修改时间:2015年4月9日 下午2:58:20<br/>
	 */
	public static String removeEndCharts(String string, boolean trim){
		
		if(string == null){
			
			return null;
			
		}
		
		if(trim){
			
			string = string.trim();
			
		}
		
		if(!string.isEmpty()){
			
			string = string.substring(0, string.length()-1);
			
		}
		
		return string;
		
	}
	
	/**
	 * Removes the end charts.
	 *
	 * @param srcString the src string
	 * @param removeString the remove string
	 * @param trim the trim
	 * @return the string
	 * @方法功能描述: 移除字符串结尾的指定字符串,如果字符串结尾不是指定的字符串，则不移除
	 * @创建者:
	 * @创建时间:2015年4月9日 下午2:57:07
	 * @最后修改用户: 
	 * @最后修改时间:2015年4月9日 下午2:57:07<br/>
	 */
	public static String removeEndCharts(String srcString, String removeString, boolean trim){
		
		if(srcString==null){
			
			return null;
		}
		
		if(trim){
			
			srcString=srcString.trim();
			
		}
		
		if(srcString.endsWith(removeString)){
			
			srcString=srcString.substring(0,srcString.length()-removeString.length());
			
		}
		
		return srcString;
	}
	

	
	/**
	 * To integer list.
	 *
	 * @param str the str
	 * @param separator the separator
	 * 
	 * @方法功能描述: 将字符串按指定分隔符转换为整型集合
	 * @创建者:
	 * @创建时间:2015年4月9日 下午2:56:44
	 * @最后修改用户:
	 * @最后修改时间:2015年4月9日 下午2:56:44<br/>
	 */
	public static List<Integer> toIntegerList(String str,String separator){
		
		List<Integer> list = new ArrayList<Integer>();
		
		if(null != str && !"".equals(str.trim())){
			
			String[] strArray = str.split(separator);
			
			try{
				for(int i = 0, len=strArray.length; i<len; i++){
					
					if(!"".equals(strArray[i].trim())){
						
						list.add(Integer.parseInt(strArray[i]));
						
					}
				}
			}catch(NumberFormatException e){
				e.printStackTrace();
				return null;
			}
		}
		
		return list;
		
	}
	
	/**
	 * String to list.
	 *
	 * @param string the string
	 * @param separator the separator
	 * 
	 * @方法功能描述: 将字符串按指定子串分隔返回List集合
	 * @创建者:
	 * @创建时间:2015年4月11日 下午1:19:21
	 * @最后修改用户:
	 * @最后修改时间:2015年4月11日 下午1:19:21<br/>
	 */
	public static List<String> stringToList(String string,String separator){
		
		if(null == string || string.length() == 0 || null == separator){
			return null;
		}
		
		String[] stringArray = string.split(separator);
		
		return Arrays.asList(stringArray);
		
	}
	
	
	/**
	 * Parses the int.
	 *
	 * @param value the value
	 * @return the int
	 * @Description: 将对象转换为整数，如果转换失败则返回默认值0
	 * @User: 
	 * @Date: 2015年10月14日 上午10:27:42
	 */
	public static int parseInt(Object value){
		return parseInt(value, 0);
	}
	
	/**
	 * Parses the int.
	 *
	 * @param value the value
	 * @return the int
	 * @Description: 将对象转换为整数，如果转换失败则返回默认值0
	 * @User: 
	 * @Date: 2015年10月14日 上午10:28:26
	 */
	public static int parseInt(String value){
		return parseInt(value, 0);
	}
	
	/**
	 * Parses the int.
	 *
	 * @param value the value
	 * @param defaultValue 转换失败返回的默认值
	 * @return the int
	 * @Description: 将对象转换为整数,如果转换失败则返回自定义默认值
	 * @User: 
	 * @Date: 2015年10月14日 上午10:28:38
	 */
	public static int parseInt(Object value, int defaultValue){
		
		if(value == null || value.toString().trim().isEmpty()){
			return defaultValue;
		}
		
		try{
			return Integer.parseInt(value.toString().trim());
		}catch(NumberFormatException e){
			e.printStackTrace();
			return defaultValue;
		}
	}
}
