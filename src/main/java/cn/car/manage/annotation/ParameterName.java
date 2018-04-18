package cn.car.manage.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * @Description: Controller请求参数由JSON对象转换为对应类型对象注解 
 * @User: 
 * @Date: 2018年3月7日 上午11:39:44
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ParameterName {

	/**
	 * @Description: 当前参数在request中的名称
	 * @User: 
	 * @Date: 2018年3月3日 下午7:16:52
	 * @return the string
	 */
	String value();
	
	
	/**
	 * @Description: 标识当前参数是否为集合
	 * @return true
	 * @User: 
	 * @Date: 2018年3月3日 下午7:16:25
	 */
	boolean isList() default false;
	
	
	
	
}
