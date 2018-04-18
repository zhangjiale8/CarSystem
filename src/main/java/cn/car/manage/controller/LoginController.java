package cn.car.manage.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.car.manage.beans.orm.system.User;
import cn.car.manage.beans.orm.system.UserRole;
import cn.car.manage.pub.enums.LoginResultEnums;
import cn.car.manage.service.system.UserRoleService;
import cn.car.manage.service.system.UserService;



/**
 * @Description:登录控制层
 * @author 
 * @date 2018年3月10日
 */
@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	/**
	 * @Description:登录
	 * @author
	 * @date 2018年3月10日
	 * @param httpServletResponse
	 * @param username
	 * @param password
	 * @return 
	 */
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST, params = { "userName", "userPassWord" }, produces = { "application/json;charset=UTF-8" })
	public ModelAndView verification(HttpServletResponse response, HttpServletRequest request, String userName, String userPassWord) {
		ModelAndView view = new ModelAndView();
		if (userName == null || userName.trim().isEmpty() || userPassWord == null || userPassWord.trim().isEmpty()) {
			view.setViewName("redirect:/login");
			view.getModelMap().put("loginInfo", "用户名或密码不正确");
			return view;
		}
		userName = userName.trim();
		userPassWord = userPassWord.trim();
		
		HttpSession session = request.getSession();
		int loginState = 0;
		User user = this.userService.getUserInfoWithName(userName);
		UserRole userRole=this.userRoleService.getUserRoleByUserID(user.getUserID());
		
		if (user == null||userRole==null) {
			loginState = LoginResultEnums.NOUSER.getValue();
			request.getSession().setAttribute("loginState", loginState);
			view.setViewName("redirect:/login");
			view.getModelMap().put("loginInfo", "用户不存在");
			return view;
		}else if(user.getState()!=2){
			if (userName.equals(user.getUserName().trim()) && userPassWord.equalsIgnoreCase(user.getUserPassWord().trim())) {
				
				session.setAttribute("userName", userName);
				session.setAttribute("roleID", userRole.getRoleID());
				loginState = LoginResultEnums.SUCCESS.getValue();
				request.getSession().setAttribute("loginState", loginState);
				if(userRole.getRoleID()==2){
					view.setViewName("redirect:/index");
				}else{
					view.setViewName("redirect:/backStage");
				}
				
				return view;
			
			
			} else {
				loginState = LoginResultEnums.NOUSER.getValue();
				request.getSession().setAttribute("loginState", loginState);
				view.setViewName("redirect:/login");
				view.getModelMap().put("loginInfo", "登录失败");
				return view;
			}
		}else{
			loginState = LoginResultEnums.NOUSER.getValue();
			request.getSession().setAttribute("loginState", loginState);
			view.setViewName("redirect:/login");
			view.getModelMap().put("loginInfo", "用户被禁用");
			return view;
		}
		
		
	}
	
	
	/**
	 * @Description:注销登录
	 * @author 
	 * @date 2018年3月10日
	 * @param request
	 * @return
	 */
	@RequestMapping("/cancel")
	public ModelAndView cancel(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("redirect:/login");
		request.getSession().invalidate();
		return view;
	}
}
