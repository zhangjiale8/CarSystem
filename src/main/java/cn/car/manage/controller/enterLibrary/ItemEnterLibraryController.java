package cn.car.manage.controller.enterLibrary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cn.car.manage.beans.orm.item.wareHouse.ItemExistWareHouse;
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.service.item.wareHouse.ItemWareHouseService;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.RequestUtil;

/**
 * @Description:配件出控制层
 * @author 
 * @date 2018年3月18日
 */
@Controller
@RequestMapping("itemEnterLibrary")
public class ItemEnterLibraryController implements BaseController{

	@Autowired
	private ItemWareHouseService itemWareHouseService;

	/**
	 * @Description:分页查询
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping("/getAllItemEnterLibrary")
	public ModelAndView getWareHouseItemByItemNameOrItemCoudOrWareHouseName(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		DataTableReturn<ItemExistWareHouse> dataTableReturn = itemWareHouseService.getWareHouseItemByItemNameOrItemCoudOrWareHouseName(request);
		view = RequestUtil.requestForward(response, dataTableReturn.toJSON(), REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	
	
}
