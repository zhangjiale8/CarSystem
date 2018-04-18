package cn.car.manage.util.helper;

import java.io.InputStreamReader;
import java.util.Properties;

public class HardCodeUtil {
	private static Properties pro = new Properties();
	private static String fileName = "hardcode.properties";
	static{
		InputStreamReader isReader;
		try {
			//isReader = new InputStreamReader(HardCodeUtil.class.getResourceAsStream(fileName), "UTF-8");
			isReader = new InputStreamReader(HardCodeUtil.class.getClassLoader().getResourceAsStream(fileName), "UTF-8");
			pro.load(isReader);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static String getValue(String key){
		if(null == key || "".equals(key.trim())){
			try {
				throw new Exception("key不能为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return pro.getProperty(key);
	}
	
	
	/*
	 * test
	 */
	public static void main(String[] args) {
		try {
			System.err.println(HardCodeUtil.getValue("assetType.Refrigerator"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
