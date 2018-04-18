package cn.car.manage.aop;



/**
 * 
 * @Description: AOP切点列表 
 * @User: 
 * @Date: 2018年3月3日 上午10:50:24
 */
public interface PointCuts {

	
	/**
	 * Controller切点表达式
	 */
	public static final String CONTROLLER = "execution(* cn.car.manage.controller..*.*(..))";
	
	
	/**
	 * Service切点表达式
	 */
	public static final String SERVICE = "execution(* cn.car.manage.service..*.*(..))";
	
	
}
