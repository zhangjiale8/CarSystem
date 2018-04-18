package cn.car.manage.controller.item.wareHouse;

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
import cn.car.manage.beans.orm.item.wareHouse.ItemExistWareHouse;
import cn.car.manage.beans.orm.item.wareHouse.WareHouse;
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.service.item.wareHouse.ItemWareHouseService;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.RequestUtil;
/**
 * @Description:仓库商品控制层
 * @author 李子辉
 * @date 2018年3月13日
 *
 */
@Controller
@RequestMapping("/wareHouse")
public class ItemWareHouseController implements BaseController{
	
	@Autowired
	private ItemWareHouseService itemWareHouseService;
	
	/**
	 * @Description:分页查询留言
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping("/getItemByItemCodeAndItenNameAndWareHouse")
	public ModelAndView getWareHouseItemByItemNameOrItemCoudOrWareHouseName(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		DataTableReturn<ItemExistWareHouse> dataTableReturn = itemWareHouseService.getWareHouseItemByItemNameOrItemCoudOrWareHouseName(request);
		view = RequestUtil.requestForward(response, dataTableReturn.toJSON(), REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	/**
	 * @Description:查询所有仓库
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping("/selectAllwareHouse")
	public @ResponseBody List<WareHouse> getAllWareHouse(){
		return itemWareHouseService.getAllWareHouse();
		
	}
	
	/**
	 * @Description:移除仓库某商品
	 * @param itemName
	 * @param itemCode
	 * @param wareHouseName
	 * @return
	 */
	@RequestMapping(value="/deleteWareHouseItem",params = { "itemID[]", "forward" })
	public ModelAndView deleteWareHouseItem(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("itemID[]") List<Integer> itemID,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response,itemWareHouseService.deleteWareHouseItem(itemID), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 * @Description:给商品更换仓库
	 * @param itemName
	 * @param itemCode
	 * @param wareHouseName
	 * @return
	 */
	@RequestMapping(value="/updateItemWareHousePosition")
	public ModelAndView updateItemWareHousePosition(HttpServletRequest request, HttpServletResponse response,
			@ParameterName(value="wareHouseID") int wareHouseID,@ParameterName(value="itemID") int itemID, @RequestParam(value = "forward", defaultValue = "JSON") String forward){
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response,itemWareHouseService.updateItemWareHousePosition(itemID, wareHouseID), REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	/**
	 * @Description:修改状态
	 * @param itemName
	 * @param itemCode
	 * @param wareHouseName
	 * @return
	 */
	@RequestMapping("/updateItemStateByItemIdAndItemStateID")
	public ModelAndView updateItemStateByItemIdAndItemStateID(HttpServletRequest request, HttpServletResponse response,
			@ParameterName(value="itemStateID") int itemStateID,@ParameterName(value="itemID") int itemID, @RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response,itemWareHouseService.updateItemStateByItemIdAndItemStateID(itemID, itemStateID), REQUEST_RESULT_NAME, forward);
		return view;
		
	}
	/**
	 * @Description:根据ID查询仓库商品位置
	 * @param request
	 * @param response
	 * @param guestBookID
	 * @return
	 */
	@RequestMapping(value="/getItemPositionByItemID",params="itemID")
	public String getItemExistWareHouseByItemID(HttpServletRequest request, HttpServletResponse response,int itemID) {
		request.setAttribute("itemID", itemID);
		return "forward:/toUpdateitemWareHousePosition";
	}
	
}
