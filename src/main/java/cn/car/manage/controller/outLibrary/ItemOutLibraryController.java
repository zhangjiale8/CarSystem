package cn.car.manage.controller.outLibrary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.car.manage.annotation.ParameterName;
import cn.car.manage.beans.orm.item.Item;
import cn.car.manage.beans.orm.item.stock.ItemStock;
import cn.car.manage.beans.orm.item.wareHouse.ItemExistWareHouse;
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.service.item.stock.ItemStockService;
import cn.car.manage.service.item.wareHouse.ItemWareHouseService;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.RequestUtil;

/**
 * @Description:配件出控制层
 * @author 
 * @date 2018年3月18日
 */
@Controller
@RequestMapping("itemOutLibrary")
public class ItemOutLibraryController implements BaseController{

	@Autowired
	private ItemWareHouseService itemWareHouseService;
	@Autowired
	private ItemStockService itemStockService;
	/**
	 * @Description:分页查询
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping("/getAllItemOutLibrary")
	public ModelAndView getWareHouseItemByItemNameOrItemCoudOrWareHouseName(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		DataTableReturn<ItemExistWareHouse> dataTableReturn = itemWareHouseService.getWareHouseItemByItemNameOrItemCoudOrWareHouseName(request);
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
	@RequestMapping(value="/getItemOutLibraryByItemID",params="itemID")
	public String getItemExistWareHouseByItemID(HttpServletRequest request, HttpServletResponse response,int itemID) {
		ItemStock itemStock=itemStockService.getItemByItemID(itemID);
		request.setAttribute("itemExistWareHouse", itemStock);
		return "forward:/addItemOutLibraryOrder";
	}
	
	
}
