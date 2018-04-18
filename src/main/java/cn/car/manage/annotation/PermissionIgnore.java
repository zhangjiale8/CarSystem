package cn.car.manage.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * @Description: 权限忽略注解, 可用于 类和函数上, 
 * 				如果用于类声明则表示该类下所有请求都忽略权限验证, 如果用于函数上则表明该函数对应的请求忽略权限验证
 * 				类声明优先于函数
 * @User: 
 * @Date: 2018年3月11日 上午10:20:07
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface PermissionIgnore {

}
