package cn.car.manage.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.car.manage.annotation.ParameterName;
import cn.car.manage.util.helper.AliJsonUtil;


/**
 *
 * @Description: 拦截 cn.car.manage.controller包下的所有类中带有RequestMapping注解的函数，
 * 				  将所有添加ParameterName注解的参数由JSON格式字符串转换为参数对应的对象
 * @User: 
 * @Date: 2018年3月4日 上午10:55:18
 */
@Component
@Aspect
@Order(1)
public class ParameterConvert{
	
	
	@Around(value=PointCuts.CONTROLLER)
	public Object paramterConvert(ProceedingJoinPoint point){
		
		Object result = null;
		
		Object[] args = point.getArgs();
		
		MethodSignature methodSignature = (MethodSignature)point.getSignature();
		Method method = methodSignature.getMethod();
		
		//如果当前函数的参数列表不为空
		if(method.isAnnotationPresent(RequestMapping.class) && args.length > 0){
			
			//获取当前函数的参数列表
			Parameter[] parameters = method.getParameters();
			
			//获取当前的request对象
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			
			//遍历当前函数的参数列表
			for(int i=0, len=parameters.length; i<len; i++){
				
				Parameter parameter = parameters[i];
				
				//如果当前参数没有添加ParameterName注解则检查下一个参数
				if(!parameter.isAnnotationPresent(ParameterName.class)){
					continue;
				}
				
				//获取当前参数的注解
				ParameterName parameterName = parameter.getAnnotation(ParameterName.class);
				if(parameterName == null){
					continue;
				}
				
					
				//获取当前参数对应request中的请求参数
				String name = parameterName.value();
				//获取当前参数注解中集合标识,用于标识当前有request中相应参数为集合类型
				boolean isList = parameterName.isList();
				
				//如果注解的参数
				if(name == null || name.trim().isEmpty()){
					continue;
				}
				
				//根据注解的value值获取request中的相应的值
				String value = request.getParameter(name.trim());
				if(value != null && !value.trim().isEmpty()){
					//如果当前参数是List集合
					if(isList){
						//通过反射获取List参数中泛型的真实类型
						Type parameterType = parameter.getParameterizedType();
						Class<?> cls = (Class<?>)((ParameterizedType)parameterType).getActualTypeArguments()[0];
						//将当前参数的值修改为转换之后的类型
						args[i] = AliJsonUtil.fromJsonArray(value, cls);
					}else{//如果是单个对象
						//将当前参数的值修改为转换之后的类型
						args[i] = AliJsonUtil.fromJson(value, parameter.getType());
					}
				}
			}
		}
		
		try {
			//使用修改后的参数
			result = point.proceed(args);
			return result;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
