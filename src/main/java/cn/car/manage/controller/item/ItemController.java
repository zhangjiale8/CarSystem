package cn.car.manage.controller.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import cn.car.manage.annotation.ParameterName;
import cn.car.manage.beans.orm.item.Item;
import cn.car.manage.beans.orm.item.ItemAndBrand;
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.service.item.ItemService;
import cn.car.manage.util.helper.PagedResult;
import cn.car.manage.util.helper.RequestUtil;

/**
 * @Description:商品业务层
 * @author 
 * @date 2018年3月11日
 */
@Controller
@RequestMapping("item")
public class ItemController implements BaseController{

	@Autowired
	private ItemService itemService;
	
	/**
	 * @Description:分页
	 * @author
	 * @date 2018年3月10日
	 * @param 
	 * @return
	 */
	@RequestMapping("/getItemAll")
    public ModelAndView getItemAll(HttpServletRequest request, HttpServletResponse response,
			@ParameterName(value="pageNumber") int pageNumber,@ParameterName(value="pageSize") int pageSize, 
			@ParameterName(value="itenName") String name,@ParameterName(value="itemClassificationID") int itemClassificationID,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		
    		ModelAndView view = null;
			PagedResult<ItemAndBrand> pageResult = itemService.getItemAll(pageNumber, pageSize, name,itemClassificationID);
			
			view = RequestUtil.requestForward(response, pageResult, REQUEST_RESULT_NAME, forward);
			return view;
    } 
	@RequestMapping("/getItemOther")
    public @ResponseBody List<ItemAndBrand> getItemOther() {
		
			return itemService.getItemOther();
    } 

	/**
	 * 
	 * @Description: 新增商品
	 * @User: 
	 * @Date: 2018年3月27日 上午10:12:24
	 * @param response
	 * @param item
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/addItem", method=RequestMethod.POST, params={"item", "forward"})
	public ModelAndView addItem(HttpServletResponse response, @ParameterName("item") Item item, String forward){
		ModelAndView view = null;
		Item newItem = this.itemService.addItem(item);
		
		view = RequestUtil.requestForward(response, newItem,REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	
	/**
	 * @Description:查询商品
	 * @author
	 * @date 2018年3月10日
	 * @param itemID
	 * @return item
	 */
	@RequestMapping("itemInfo")
	public ModelAndView getItemInfoByItemID(HttpServletResponse response, @ParameterName("itemID") int itemID, String forward){
	
		ModelAndView view = null;
		ItemAndBrand itemAndBrand = this.itemService.selectItemInfoByItemID(itemID);
		
		view = RequestUtil.requestForward(response, itemAndBrand,REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	
}
