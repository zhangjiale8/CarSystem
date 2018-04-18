package cn.car.manage.global;


/**
 * 
 * @Description: 系统常用配置 
 * @User: CPC
 * @Date: 2016年3月9日 上午11:56:22
 */
public class CommonConfigs extends Configuration{
	
	
	
	
	/**
	 * 
	 * @Description: 权限验证标识 
	 * @User: 
	 * @Date: 2018年3月1日 上午9:21:01
	 * @return
	 */
	public static final boolean identifierOpen(){
		Object obj = Configuration.getOrDefault("ROOT_ASSET_TYPE_ID", "true");
		return Boolean.parseBoolean(obj.toString());
	}
	
	
}
