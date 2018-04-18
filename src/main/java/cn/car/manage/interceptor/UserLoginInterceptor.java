package cn.car.manage.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @ClassName: UserLoginInterceptor
 * @Description: 用户登录拦截器
 * @author 
 * @date 2018年3月8日 下午4:34:52
 */
@Component
@Aspect
public class UserLoginInterceptor {

	@Around(value = "execution(* cn.car.manage.controller.PageController.*(..)) "
			+ "&& !execution(* cn.car.manage.controller.PageController.index(..)) "
			+ "&& !execution(* cn.car.manage.controller.PageController.itemList(..)) "
			+ "&& !execution(* cn.car.manage.controller.PageController.itemListFitting(..)) "
			+ "&& !execution(* cn.car.manage.controller.PageController.login(..)) "
			+ "&& !execution(* cn.car.manage.controller.PageController.register(..)) "
			+ "&& !execution(* cn.car.manage.controller.PageController.getUserInfoPass(..)) "
			)
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = null;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		String userName = (String) request.getSession().getAttribute("userName");
		
		if (null == userName ) {

			String header = request.getHeader("X-Requested-With");

			if ("XMLHttpRequest".equalsIgnoreCase(header)) {
				response.sendError(405);
			} else {
				response.sendRedirect(request.getContextPath() + "/login");
			}
			
		} else {
			obj = pjp.proceed();

		}
		return obj;
	}

}
