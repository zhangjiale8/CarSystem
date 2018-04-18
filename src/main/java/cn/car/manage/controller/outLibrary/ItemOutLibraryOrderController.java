package cn.car.manage.controller.outLibrary;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import cn.car.manage.annotation.ParameterName;
import cn.car.manage.beans.orm.item.Item;
import cn.car.manage.beans.orm.item.outLibrary.ItemOutLibrary;
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.service.item.ItemService;
import cn.car.manage.service.item.outLibrary.ItemOutLibraryOrderService;
import cn.car.manage.util.helper.RequestUtil;

/**
 * @Description:配件出控制层
 * @author 
 * @date 2018年3月18日
 */
@Controller
@RequestMapping("itemOutLibraryOrder")
public class ItemOutLibraryOrderController implements BaseController{
	@Autowired
	private ItemOutLibraryOrderService itemOutLibraryOrderService;
	
	@Autowired
	private ItemService itemService;
	/**
	 * @Description:分页查询出库单
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping(value={"/itemOutLibraryPage"},produces={"application/json;charset=UTF-8"})
	public @ResponseBody String getOutLibraryOderPage(HttpServletRequest request){
		return new Gson().toJson(itemOutLibraryOrderService.getOutLibraryOrderPage(request));
	}
	/**
	 * @Description:新增出库单
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/addItemOutLibraryOrder", params={"itemOutLibrary", "forward"})
	public ModelAndView addItemOutLibraryOrder(HttpServletResponse response, @ParameterName("itemOutLibrary") ItemOutLibrary itemOutLibrary,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response, itemOutLibraryOrderService.addItemOutLibrary(itemOutLibrary), REQUEST_RESULT_NAME, forward);
		return view;
		
	}
	/**
	 *@Description:根据出库单ID查询出库单
	 * @param request
	 * @param response
	 * @param outLibraryID
	 * @return 
	 */
	@RequestMapping(value="/getItemOutLibraryOrderByOutLibraryID",params={"itemOutLibraryID"})
	public String getItemOutLibraryOrderByOutLibraryID(HttpServletResponse response,HttpServletRequest request,int itemOutLibraryID){
		ItemOutLibrary itemOutLibrary=itemOutLibraryOrderService.getItemOutLibraryOrderByOutLibraryID(itemOutLibraryID);
		
		request.setAttribute("itemOutLibrary", itemOutLibrary);
		return "forward:/toUpdateItemOutLibraryOrder";
		
	}
	/**
	 * @Description:修改出库单
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/updateItemOutLibraryOrder", params={"itemOutLibrary", "forward"})
	public ModelAndView updateItemOutLibraryOrder(HttpServletResponse response, @ParameterName("itemOutLibrary") ItemOutLibrary itemOutLibrary,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response, itemOutLibraryOrderService.updateItemOutLibraryOrder(itemOutLibrary), REQUEST_RESULT_NAME, forward);
		return view;
		
	}
	/**
	 * @Description:通过商品ItemCode查询商品
	 * @param request
	 * @param response
	 * @param itemCode
	 * @return
	 */
	@RequestMapping(value="/getItemByItemID", params={"itemID", "forward"})
	public ModelAndView getItemByItemCode(HttpServletResponse response, @ParameterName("itemID") int itemID,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
		ModelAndView view = null;
		Item item=itemService.getItemByItemID(itemID);
		
		view = RequestUtil.requestForward(response, item, REQUEST_RESULT_NAME, forward);
		return view;
		
	}
	/**
	 * @Description:修改出库单状态 
	 * @param request
	 * @param response
	 * @param guestBookID
	 * @param handleState
	 * @param forward
	 * @return
	 */
	@RequestMapping("/updateOutLibraryOrderState")
	public ModelAndView updateOutLibraryOrderState(HttpServletRequest request, HttpServletResponse response,
			@ParameterName(value="outLibraryID") int outLibraryID,@ParameterName(value="outLibraryState") int outLibraryState, @RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		view = RequestUtil.requestForward(response, itemOutLibraryOrderService.updateOutLibraryOrderState(outLibraryID, outLibraryState), REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	/**
	 * @Description:删除出库单
	 * @param request
	 * @param response
	 * @param guestBookIDs
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/deleteItemOutLibraryOrder",params = { "outLibraryID[]", "forward" })
	public ModelAndView deleteItemOutLibraryOrder(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("outLibraryID[]") List<Integer> outLibraryID,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response,itemOutLibraryOrderService.deleteItemOutLibraryOrder(outLibraryID), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 * @Description:查询所有商品编码
	 * @param request
	 * @param response
	 * @param itemCode
	 * @return
	 */
	@RequestMapping(value="/getAllItemCode")
	public @ResponseBody List<Item> getAllItemCode(HttpServletRequest request, HttpServletResponse response,int itemClassificationID,@RequestParam(value="forward",defaultValue="JSON")String forward){
		
		
		return itemService.getAllItemCode(itemClassificationID);
		
	}
}
