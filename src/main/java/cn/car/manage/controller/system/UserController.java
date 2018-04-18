package cn.car.manage.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.car.manage.annotation.ParameterName;
import cn.car.manage.beans.orm.system.User;
import cn.car.manage.beans.orm.system.UserRole;
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.service.system.UserService;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.RequestUtil;



/**
 * @Description 管理员相关控制层
 * @author 
 * @date 2018年3月11日
 */
@Controller
@RequestMapping(value = "/user")
public class UserController implements BaseController{

	@Autowired
	private UserService userService;
	
	/**
	 * @Description 新增管理员
	 * @author
	 * @date
	 * @param request
	 * @param response
	 * @param user
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response, @ParameterName("user") User user,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
		ModelAndView view = null;
		user.setRoleID(1);;
		view = RequestUtil.requestForward(response, userService.add(request, user), REQUEST_RESULT_NAME, forward);
		return view;
		
	}
	/**
	 * @Description 分页查询
	 * @author
	 * @date
	 * @param request
	 * @param response
	 * @param userName
	 * @param forward
	 * @return
	 */
	@RequestMapping("/getUserByUserName")
	public ModelAndView getUserByUserNamePage(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		DataTableReturn<UserRole> dataTableReturn = userService.getUserByUserName(request);
		view = RequestUtil.requestForward(response, dataTableReturn.toJSON(), REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	/**
	 * @Description: 根据用户ID查找
	 * @User: 
	 * @Date: 2018年3月11日
	 * @param request
	 * @param response
	 * @param user
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/getUserByUserID",params="userID")
	public String getUserByUserID(HttpServletRequest request, HttpServletResponse response, int userID) {
		User user=userService.getByUserID(userID);
		request.setAttribute("user", user);
		return "forward:/toUpdate";
	}
	
	/**
	 * @Description: 根据用户ID查找
	 * @User: 
	 * @Date: 2018年3月11日
	 * @param request
	 * @param response
	 * @param user
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/getUserInfo",params="userName")
	public String getUserByUserName(HttpServletRequest request, HttpServletResponse response, String userName) {
		User user=userService.getUserInfoWithName(userName);
		request.setAttribute("user", user);
		return "forward:/adminInfo";
	}
	/**
	 * @Description: 根据用户ID查找
	 * @User: 
	 * @Date: 2018年3月11日
	 * @param request
	 * @param response
	 * @param user
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/getUserInfoEdit",params="userName")
	public String getUserByUserNameEdit(HttpServletRequest request, HttpServletResponse response, String userName) {
		User user=userService.getUserInfoWithName(userName);
		request.setAttribute("user", user);
		return "forward:/adminInfoEdit";
	}
	/**
	 * @Description: 修改用户状态
	 * @User: 
	 * @Date: 2018年3月11日
	 * @param request
	 * @param response
	 * @param user
	 * @param forward
	 * @return
	 */
	@RequestMapping("/updateState")
	public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response,
			@ParameterName(value="userID") int userID,@ParameterName(value="state") int state, @RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		
		RequestUtil.requestForward(response, userService.updateState(userID,state), REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	/**
	 * @Description: 修改
	 * @User: 
	 * @Date: 2018年3月11日
	 * @param request
	 * @param response
	 * @param user
	 * @param forward
	 * @return
	 */
	@RequestMapping("/updateUser")
	public ModelAndView updateState(HttpServletRequest request, HttpServletResponse response,
			@ParameterName("user") User user, @RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		RequestUtil.requestForward(response, userService.update(user), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 * @Description: 根据用户ID删除
	 * @User: 
	 * @Date: 2018年3月11日
	 * @param request
	 * @param response
	 * @param userID
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/deleteUser",params = { "userIDs[]", "forward" })
	public ModelAndView deleteUserByUserID(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("userIDs[]") List<Integer> userIDs,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		
		RequestUtil.requestForward(response, userService.delete(userIDs), REQUEST_RESULT_NAME, forward);
		return view;
	}
}
