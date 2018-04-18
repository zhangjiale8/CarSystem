package cn.car.manage.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Description: 权限注解,用于标识具体请求对应的权限 
 * @User: 
 * @Date: 2018年3月2 下午9:45:05
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Permission {

	
	String value();
	
	
}
