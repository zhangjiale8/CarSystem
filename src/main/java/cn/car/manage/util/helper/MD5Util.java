package cn.car.manage.util.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class MD5Util {

	
	/**
	 *
	 * @方法功能描述: 使用MD5方式加密指定字符串
	 * @param str
	 * @return the md5
	 * @创建者:陈鹏超 
	 * @创建时间:2015年4月9日 下午2:59:49
	 * @最后修改用户:陈鹏超 
	 * @最后修改时间:2015年4月9日 下午2:59:49<br/>
	 */
	public static String getMd5(String str){
		
		try {
			StringBuffer stb = new StringBuffer();
			
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			
			md5.update(str.getBytes());
			
			byte[] byteArr = md5.digest();
			
			for (byte b : byteArr) {
				
				if(( b & 0xff ) < 0x10){
					
					stb.append("0");
					
				}
				
				stb.append(Long.toString( b & 0xff, 16));
				
				
			}
			return stb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
			
			return null;
		}
	}
	
}
