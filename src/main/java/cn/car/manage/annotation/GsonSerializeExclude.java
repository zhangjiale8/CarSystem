package cn.car.manage.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Description: Gson序列化对象时排除属性注解, class定义中带有@GsonSerializeExclude注解的属性在使用GsonUtil工具类进行序列化时不会被序列化
 * @User: 
 * @Date: 2018年3月5日 下午2:39:08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface GsonSerializeExclude {
	String value() default "";
}
