package cn.car.manage.controller.item.repair;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.car.manage.annotation.ParameterName;
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.service.item.repair.RepairOrderService;
import cn.car.manage.beans.orm.item.repair.RepairOrder;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.RequestUtil;
/**
 * @Description:维修订单控制层
 * @author 
 * @date 2018年3月20日
 */
@Controller
@RequestMapping("/repairOrder")
public class ItemRepairController implements BaseController {

	@Autowired
	private RepairOrderService repairOrderService;
	/**
	 * @Description:分页查询订单
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping("/getRepairOrderPage")
	public ModelAndView getRepairOrderPage(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		DataTableReturn<RepairOrder> dataTableReturn = repairOrderService.getRepairOrderPage(request);
		
		view = RequestUtil.requestForward(response, dataTableReturn.toJSON(), REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	/**
	 *@Description:根据订单单ID查询订单(修改状态所用)
	 * @param request
	 * @param response
	 * @param RepairOrderID
	 * @return 
	 */
	@RequestMapping(value="/getRepairOrderStateByRepairOrderID",params={"repairOrderID"})
	public String getRepairOrderByOutLibraryIDUseState(HttpServletResponse response,HttpServletRequest request,int repairOrderID){
		RepairOrder repairOrder=repairOrderService.getRepairOrderByRepairOrderID(repairOrderID);
		
		request.setAttribute("repairOrder", repairOrder);
		return "forward:/toRepairOrderState";
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
	@RequestMapping("/updateRepairOrderState")
	public ModelAndView updateRepairOrderState(HttpServletRequest request, HttpServletResponse response,
			@ParameterName(value="repairOrderID") int repairOrderID,@ParameterName(value="repairOrderState") int repairOrderState, @RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		view = RequestUtil.requestForward(response, repairOrderService.updateRepairOrderState(repairOrderID, repairOrderState), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 *@Description:根据订单单ID查询订单(修改订单所用)
	 * @param request
	 * @param response
	 * @param RepairOrderID
	 * @return 
	 */
	@RequestMapping(value="/getRepairOrderByRepairOrderID",params={"repairOrderID"})
	public String getRepairOrderByOutLibraryID(HttpServletResponse response,HttpServletRequest request,int repairOrderID){
		RepairOrder repairOrder=repairOrderService.getRepairOrderByRepairOrderID(repairOrderID);
		
		request.setAttribute("repairOrder", repairOrder);
		return "forward:/toUpdateRepairOrder";
	}
	
	/**
	 *@Description:修改订单(修改订单所用)
	 * @param request
	 * @param response
	 * @param RepairOrder
	 * @return 
	 */
	@RequestMapping(value="/updateRepairOrder", params={"repairOrder", "forward"})
	public ModelAndView updateRepairOrder(HttpServletResponse response, @ParameterName("repairOrder") RepairOrder repairOrder,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response, repairOrderService.updateRepairOrder(repairOrder), REQUEST_RESULT_NAME, forward);
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
	@RequestMapping(value="/deleteRepairOrder",params = { "repairOrderID[]", "forward" })
	public ModelAndView deleteRepairOrder(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("repairOrderID[]") List<Integer> repairOrderID,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response,repairOrderService.deleteRepairOrder(repairOrderID), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 * @Description:新增订单
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/addRepairOrder", params={"repairOrder", "forward"})
	public ModelAndView addItemOutLibraryOrder(HttpServletResponse response, @ParameterName("repairOrder") RepairOrder repairOrder,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response, repairOrderService.addRepairOrder(repairOrder), REQUEST_RESULT_NAME, forward);
		return view;
		
	}
		
}
