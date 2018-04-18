package cn.car.manage.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * @Description: 业务处理层处理结果状态码注解
 * 				用于标识该功能处理发生异常时的异常说明, 一般用在功能入口函数上, 在功能处理发生未知异常时的统一返回异常信息说明
 * @User: 
 * @Date: 2018年3月5日 上午10:25:36
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface StatusCodeDefault {

	/**
	 * 
	 * @Description: 状态码ID 
	 * @User: CPC
	 * @Date: 2016年3月21日 上午10:29:18
	 * @return
	 */
	int code();
}
