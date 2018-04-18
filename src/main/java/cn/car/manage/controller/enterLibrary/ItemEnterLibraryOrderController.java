package cn.car.manage.controller.enterLibrary;

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
import cn.car.manage.beans.orm.item.enterLibrary.ItemEnterLibrary;
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.service.item.ItemService;
import cn.car.manage.service.item.enterLibrary.ItemEnterLibraryOrderService;
import cn.car.manage.util.helper.RequestUtil;

/**
 * @Description:配件出控制层
 * @author 
 * @date 2018年3月18日
 */
@Controller
@RequestMapping("itemEnterLibraryOrder")
public class ItemEnterLibraryOrderController implements BaseController{
	@Autowired
	private ItemEnterLibraryOrderService itemEnterLibraryOrderService;
	
	@Autowired
	private ItemService itemService;
	/**
	 * @Description:分页查询进库单
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping(value={"/itemEnterLibraryPage"},produces={"application/json;charset=UTF-8"})
	public @ResponseBody String getOutLibraryOderPage(HttpServletRequest request){
		
		return new Gson().toJson(itemEnterLibraryOrderService.getEnterLibraryOrderPage(request));
	}
	/**
	 * @Description:新增进库单
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/addItemEnterLibraryOrder", params={"itemEnterLibrary", "forward"})
	public ModelAndView addItemEnterLibraryOrder(HttpServletResponse response, @ParameterName("itemEnterLibrary") ItemEnterLibrary itemEnterLibrary,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response, itemEnterLibraryOrderService.addItemEnterLibrary(itemEnterLibrary), REQUEST_RESULT_NAME, forward);
		return view;
		
	}
	/**
	 *@Description:根据进库单ID查询进库单
	 * @param request
	 * @param response
	 * @param outLibraryID
	 * @return 
	 */
	@RequestMapping(value="/getItemEnterLibraryOrderByEnterLibraryID",params={"itemEnterLibraryID"})
	public String getItemEnterLibraryOrderByEnterLibraryID(HttpServletResponse response,HttpServletRequest request,int itemEnterLibraryID){
		ItemEnterLibrary itemEnterLibrary=itemEnterLibraryOrderService.getItemEnterLibraryOrderByEnterLibraryID(itemEnterLibraryID);
		
		request.setAttribute("itemEnterLibrary", itemEnterLibrary);
		return "forward:/toUpdateItemEnterLibraryOrder";
		
	}
	/**
	 * @Description:修改进库单
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/updateItemEnterLibraryOrder", params={"itemEnterLibrary", "forward"})
	public ModelAndView updateItemEnterLibraryOrder(HttpServletResponse response, @ParameterName("itemEnterLibrary") ItemEnterLibrary itemEnterLibrary,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response, itemEnterLibraryOrderService.updateItemEnterLibraryOrder(itemEnterLibrary), REQUEST_RESULT_NAME, forward);
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
	 * @Description:删除进库单
	 * @param request
	 * @param response
	 * @param guestBookIDs
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/deleteItemEnterLibraryOrder",params = { "enterLibraryID[]", "forward" })
	public ModelAndView deleteItemEnterLibraryOrder(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("enterLibraryID[]") List<Integer> enterLibraryID,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response,itemEnterLibraryOrderService.deleteItemEnterLibraryOrder(enterLibraryID), REQUEST_RESULT_NAME, forward);
		return view;
	}
	
}
