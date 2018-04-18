package cn.car.manage.controller.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.car.manage.annotation.ParameterName;
import cn.car.manage.beans.orm.customer.Customer;
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.pub.statuscode.StatusCode;
import cn.car.manage.service.customer.CustomerService;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.RequestUtil;


/**
 * @Description:客户控制层层
 * @author 
 * @date 2018年3月10日
 */
@Controller
@RequestMapping("customer")
public class CustomerController implements BaseController{

	@Autowired
	private CustomerService customerService;
	
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
	@RequestMapping(value="/addCustomer")
	public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response, @ParameterName("customer") Customer customer,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
		ModelAndView view = null;
		view = RequestUtil.requestForward(response, customerService.addCustomer(request, customer), REQUEST_RESULT_NAME, forward);
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
	@RequestMapping("/getCustomerByCustomerName")
	public ModelAndView getCustomerByCustomerName(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		DataTableReturn<Customer> dataTableReturn = customerService.getCustomerByCustomerName(request);
		view = RequestUtil.requestForward(response, dataTableReturn.toJSON(), REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	/**
	 * @Description 查用户名是否存在
	 * @author
	 * @date
	 * @param request
	 * @param response
	 * @param userName
	 * @param forward
	 * @return
	 */
	
	@RequestMapping(value = "/getCustomerNameByCustomerName", params = { "customerName" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody StatusCode deleteByID(HttpServletRequest request,HttpServletResponse response,String customerName) {
		Customer customer=customerService.getCustomerInfoWithName(customerName);
		
		StatusCode statusCode=new StatusCode();
		if(customer==null){
			statusCode.setStatus(0);
		}else{
			statusCode.setStatus(1);
		}
		
		return statusCode;
	}
	/**
	 * @Description 查用户信息
	 * @author
	 * @date
	 * @param request
	 * @param response
	 * @param userName
	 * @param forward
	 * @return
	 */
	@RequestMapping("/getCustomerInfoByCustomerName")
	public ModelAndView getCustomerInfoByCustomerName(HttpServletRequest request, HttpServletResponse response,
			@ParameterName(value="customerName") String customerName,@RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		int result=0;
		Customer customer=customerService.getCustomerInfoWithName(customerName);
		if(customer==null){
			result=0;
		}else{
			result=1;
		}
		view = RequestUtil.requestForward(response, String.valueOf(result), REQUEST_RESULT_NAME, forward);
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
	@RequestMapping(value="/getCustomerByCustomerID",params="customerID")
	public String getUserByUserID(HttpServletRequest request, HttpServletResponse response, int customerID) {
		Customer customer=customerService.getCustomerByCustomerID(customerID);
		request.setAttribute("customer", customer);
		return "forward:/toUpdateCustomer";
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
	public ModelAndView updateState(HttpServletRequest request, HttpServletResponse response,
			@ParameterName(value="customerID") int customerID,@ParameterName(value="state") int state, @RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		
		RequestUtil.requestForward(response, customerService.updateState(customerID,state), REQUEST_RESULT_NAME, forward);
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
	@RequestMapping("/updateCustomer")
	public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response,
			@ParameterName("customer") Customer customer, @RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		RequestUtil.requestForward(response, customerService.updateCustomer(customer), REQUEST_RESULT_NAME, forward);
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
	@RequestMapping("/updatePassWord")
	public ModelAndView updatePassWord(HttpServletRequest request, HttpServletResponse response,
			@ParameterName("customer") Customer customer, @RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		RequestUtil.requestForward(response, customerService.updatePassWord(customer), REQUEST_RESULT_NAME, forward);
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
	@RequestMapping(value="/deleteCustomer",params = { "customerIDs[]", "forward" })
	public ModelAndView deleteUserByUserID(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("customerIDs[]") List<Integer> customerIDs,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		
		RequestUtil.requestForward(response, customerService.deleteCustomer(customerIDs), REQUEST_RESULT_NAME, forward);
		return view;
	}
}
