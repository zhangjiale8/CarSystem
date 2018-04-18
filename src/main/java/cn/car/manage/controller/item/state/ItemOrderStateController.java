package cn.car.manage.controller.item.state;
/**
 * @Description:商品各种状态控制层
 * @author 
 * @date 2018年3月10日
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.car.manage.beans.orm.item.state.ItemAndOrderState;
import cn.car.manage.service.item.state.ItemorderStateService;

@RequestMapping("/itemOrderState")
@Controller
public class ItemOrderStateController {
	@Autowired
	private ItemorderStateService itemorderStateService;
	
	/**
	 * @Description:查询所有出库单状态
	 * @param request
	 * @param response
	 * @param itemCode
	 * @return
	 */
	@RequestMapping("/outLibraryState")
	public @ResponseBody List<ItemAndOrderState> getOutLibraryStateByName(){
		return itemorderStateService.getAllStateByName("outLibaryReason");
		
	}
	
	/**
	 * @Description:查询所有订单状态
	 * @param request
	 * @param response
	 * @param itemCode
	 * @return
	 */
	@RequestMapping("/getAllItemOrderState")
	public @ResponseBody List<ItemAndOrderState> getAllItemOrderState(){
		return itemorderStateService.getAllStateByName("orderState");
		
	}
	/**
	 * @Description:查询所有付款方式状态
	 * @param request
	 * @param response
	 * @param itemCode
	 * @return
	 */
	@RequestMapping("/getItemOrderPayMethod")
	public @ResponseBody List<ItemAndOrderState> getItemOrderPayMethod(){
		return itemorderStateService.getAllStateByName("payMethod");
		
	}
	
	/**
	 * @Description:查询所有维修状态
	 * @param request
	 * @param response
	 * @param itemCode
	 * @return
	 */
	@RequestMapping("/getRepairOrderState")
	public @ResponseBody List<ItemAndOrderState> getRepairOrderState(){
		return itemorderStateService.getAllStateByName("repairOrderState");
		
	}
	
	/**
	 * @Description:查询所有商品热卖成度
	 * @param request
	 * @param response
	 * @param itemCode
	 * @return
	 */
	@RequestMapping("/gettAllItemHot")
	public @ResponseBody List<ItemAndOrderState> gettAllItemHot(){
		return itemorderStateService.getAllStateByName("hot");
		
	}
}
