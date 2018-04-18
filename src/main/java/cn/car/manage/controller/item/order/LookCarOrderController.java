package cn.car.manage.controller.item.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.car.manage.annotation.ParameterName;
import cn.car.manage.beans.orm.item.order.LookCarOrder;
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.service.item.order.LookCarOrderService;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.RequestUtil;
/**
 * @Description:分页查询预约订单
 * @author
 * @date 2018年3月18日
 */
@Controller
@RequestMapping("/lookCarOrder")
public class LookCarOrderController implements BaseController{

	@Autowired
	private LookCarOrderService lookCarOrdeervice;
	/**
	 * @Description:分页查询预约订单
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping("/getLookCarOrderPage")
	public ModelAndView getLookCarOrderPage(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		DataTableReturn<LookCarOrder> dataTableReturn = lookCarOrdeervice.getLookCarOrderPage(request);
		
		view = RequestUtil.requestForward(response, dataTableReturn.toJSON(), REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	@RequestMapping("/getLookCarOrderByCustomerName")
	public ModelAndView getLookCarOrderByCustomerName(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		DataTableReturn<LookCarOrder> dataTableReturn = lookCarOrdeervice.getLookCarOrderByCustomerName(request);
		
		view = RequestUtil.requestForward(response, dataTableReturn.toJSON(), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 * @Description:修改预约订单状态 
	 * @param request
	 * @param response
	 * @param guestBookID
	 * @param handleState
	 * @param forward
	 * @return
	 */
	@RequestMapping("/updateLookCarOrderState")
	public ModelAndView updateLookCarOrderState(HttpServletRequest request, HttpServletResponse response,
			@ParameterName(value="lookCarID") int lookCarID,@ParameterName(value="state") int state, @RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		view = RequestUtil.requestForward(response, lookCarOrdeervice.updateLookCarOrderState(lookCarID, state), REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	
	
	/**
	 * @Description:删除预约订单
	 * @param request
	 * @param response
	 * @param guestBookIDs
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/deleteLookCarOrder",params = { "lookCarID[]", "forward" })
	public ModelAndView deleteLookCarOrder(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("lookCarID[]") List<Integer> lookCarID,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response,lookCarOrdeervice.deleteLookCarOrder(lookCarID), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 * @Description:新增预约订单
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/addLookCarOrder", params={"lookCarOrder", "forward"})
	public ModelAndView addItemOutLibraryOrder(HttpServletResponse response, @ParameterName("lookCarOrder") LookCarOrder lookCarOrder,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response, lookCarOrdeervice.addLookCarOrder(lookCarOrder), REQUEST_RESULT_NAME, forward);
		return view;
		
	}
}
