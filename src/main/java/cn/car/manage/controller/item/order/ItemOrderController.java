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
import cn.car.manage.beans.orm.item.order.ItemOrder;
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.service.item.order.ItemOrderService;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.RequestUtil;

/**
 * @Description:商品订单控制层
 * @author 
 * @date 2018年3月20日
 */
@Controller
@RequestMapping("/itemOrder")
public class ItemOrderController implements BaseController{

	@Autowired
	private ItemOrderService itemOrderService;
	
	/**
	 * @Description:分页查询订单
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping("/getItemOrderPage")
	public ModelAndView getItemOrderPage(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		DataTableReturn<ItemOrder> dataTableReturn = itemOrderService.getItemOrderPage(request);
		
		view = RequestUtil.requestForward(response, dataTableReturn.toJSON(), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 * @Description:根据用户名查询订单
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping("/getItemOrderByCustomerName")
	public ModelAndView getItemOrderByCustomerName(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		DataTableReturn<ItemOrder> dataTableReturn = itemOrderService.getItemOrderByCustomerName(request);
		
		view = RequestUtil.requestForward(response, dataTableReturn.toJSON(), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 *@Description:根据订单单ID查询订单(修改状态所用)
	 * @param request
	 * @param response
	 * @param itemOrderID
	 * @return 
	 */
	@RequestMapping(value="/getItemOrderStateByItemOrderID",params={"itemOrderID"})
	public String getItemOrderByOutLibraryIDUseState(HttpServletResponse response,HttpServletRequest request,int itemOrderID){
		ItemOrder itemOrder=itemOrderService.getItemOrderByItemOrderID(itemOrderID);
		
		request.setAttribute("itemOrder", itemOrder);
		return "forward:/toItemOrderState";
	}
	/**
	 * @Description:修改订单状态 
	 * @param request
	 * @param response
	 * @param guestBookID
	 * @param handleState
	 * @param forward
	 * @return
	 */
	@RequestMapping("/updateItemOrderState")
	public ModelAndView updateItemOrderState(HttpServletRequest request, HttpServletResponse response,
			@ParameterName(value="itemOrderID") int itemOrderID,@ParameterName(value="itemOrderState") int itemOrderState, @RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		view = RequestUtil.requestForward(response, itemOrderService.updateItemOrderState(itemOrderID, itemOrderState), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 *@Description:根据订单单ID查询订单(修改订单所用)
	 * @param request
	 * @param response
	 * @param itemOrderID
	 * @return 
	 */
	@RequestMapping(value="/getItemOrderByItemOrderID",params={"itemOrderID"})
	public String getItemOrderByOutLibraryID(HttpServletResponse response,HttpServletRequest request,int itemOrderID){
		ItemOrder itemOrder=itemOrderService.getItemOrderByItemOrderID(itemOrderID);
		
		request.setAttribute("itemOrder", itemOrder);
		return "forward:/toUpdateItemOrder";
	}
	
	/**
	 *@Description:修改订单(修改订单所用)
	 * @param request
	 * @param response
	 * @param itemOrder
	 * @return 
	 */
	@RequestMapping(value="/updateItemOrder", params={"itemOrder", "forward"})
	public ModelAndView updateItemOrder(HttpServletResponse response, @ParameterName("itemOrder") ItemOrder itemOrder,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response, itemOrderService.updateItemOrder(itemOrder), REQUEST_RESULT_NAME, forward);
		return view;
		
	}
	
	/**
	 * @Description:删除订单
	 * @param request
	 * @param response
	 * @param guestBookIDs
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/deleteItemOrder",params = { "itemOrderID[]", "forward" })
	public ModelAndView deleteItemOrder(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("itemOrderID[]") List<Integer> itemOrderID,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response,itemOrderService.deleteItemOrder(itemOrderID), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 * @Description:新增订单
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/addItemOrder", params={"itemOrder", "forward"})
	public ModelAndView addItemOutLibraryOrder(HttpServletResponse response, @ParameterName("itemOrder") ItemOrder itemOrder,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response, itemOrderService.addItemOrder(itemOrder), REQUEST_RESULT_NAME, forward);
		return view;
		
	}
}
