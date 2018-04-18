package cn.car.manage.controller.item.stock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.car.manage.annotation.ParameterName;
import cn.car.manage.beans.orm.item.stock.ItemStock;
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.service.item.stock.ItemStockService;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.RequestUtil;

/**
 * @Description:商品库存控制层
 * @author 李子辉
 * @date 2018年3月16
 */
@Controller
@RequestMapping("/itemStock")
public class ItemStockController implements BaseController{

	@Autowired
	private ItemStockService itemStockService;
	
	/**
	 * @Description:分页查询各个整车商品库存
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping("/getVehicleItemStock")
	public ModelAndView getVehicleItemStockByItemCodeOrItemNameOrWareHouseName(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		DataTableReturn<ItemStock> dataTableReturn = itemStockService.getVehicleItemStockByItemCodeOrItemNameOrWareHouseName(request);
		view = RequestUtil.requestForward(response, dataTableReturn.toJSON(), REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	/**
	 * @Description:分页查询各个整车商品库存
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping("/getFittingItemStock")
	public ModelAndView getFittingItemStockByItemCodeOrItemNameOrWareHouseName(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		DataTableReturn<ItemStock> dataTableReturn = itemStockService.getFittingItemStockByItemCodeOrItemNameOrWareHouseName(request);
		view = RequestUtil.requestForward(response, dataTableReturn.toJSON(), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 * @Description:根据ID查询商品库存
	 * @param request
	 * @param response
	 * @param itemID
	 * @return
	 */
	@RequestMapping(value="/getItemStockByItemID",params={"itemID", "forward"})
	public ModelAndView getItemStockByItemID(HttpServletRequest request, HttpServletResponse response,@ParameterName("itemID")int itemID,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		ItemStock itemStock=itemStockService.getItemByItemID(itemID);
		System.out.println(itemStock);
		view = RequestUtil.requestForward(response, itemStock, REQUEST_RESULT_NAME, forward);
		return view;
	}
}
