package cn.car.manage.controller.item.brand;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.car.manage.annotation.ParameterName;
import cn.car.manage.beans.orm.item.ItemSeries;
import cn.car.manage.beans.orm.item.brand.ItemBrand;
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.service.item.brand.ItemBrandService;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.RequestUtil;

/**
 * @Description 品牌相关控制层
 * @author 
 * @date 2018年3月11日
 */
@Controller
@RequestMapping("/brand")
public class ItemBrandController implements BaseController{

	@Autowired
	private ItemBrandService itemBrandService;
	/**
	 * @Description 分页查询
	 * @author
	 * @date
	 * @param request
	 * @param response
	 * @param itemBrandName
	 * @param forward
	 * @return
	 */
	@RequestMapping("/getItemBrandByBrandName")
	public ModelAndView getItemBrandByBrandName(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		DataTableReturn<ItemSeries> dataTableReturn = itemBrandService.getItemBrandByBrandName(request);
		view = RequestUtil.requestForward(response, dataTableReturn.toJSON(), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 * @Description 新增品牌
	 * @author
	 * @date
	 * @param request
	 * @param response
	 * @param itemBrand
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/addItemBrand")
	public ModelAndView addItemBrand(HttpServletRequest request, HttpServletResponse response, @ParameterName("itemBrand") ItemBrand itemBrand,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
		
		ModelAndView view = null;
		view = RequestUtil.requestForward(response, itemBrandService.addItemBrand(request, itemBrand), REQUEST_RESULT_NAME, forward);
		return view;
		
	}
	/**
	 * @Description 根据品牌ID查询
	 * @author
	 * @date
	 * @param request
	 * @param response
	 * @param itemBrandID
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/getItemBrandNameByBrandID", params={"itemBrandID"})
	public String getItemBrandNameByBrandID(HttpServletRequest request, HttpServletResponse response, int itemBrandID
			){
		
		ItemSeries itemSeries=itemBrandService.getItemBrandNameByBrandID(itemBrandID);
		
		request.setAttribute("itemSeries", itemSeries);
		return "forward:/toBrandEdit";
		
	}
	/**
	 * @Description 更新品牌
	 * @author
	 * @date
	 * @param request
	 * @param response
	 * @param itemBrand
	 * @param forward
	 * @return
	 */
	@RequestMapping("/updateItemBrand")
	public ModelAndView updateItemBrand(HttpServletRequest request, HttpServletResponse response,
			@ParameterName("itemBrand") ItemBrand itemBrand, @RequestParam(value = "forward", defaultValue = "JSON") String forward){
		
		ModelAndView view = null;
		view=RequestUtil.requestForward(response, itemBrandService.updateItemBrand(itemBrand),REQUEST_RESULT_NAME, forward);
		return view;
		
	}
	/**
	 * @Description 删除品牌
	 * @author
	 * @date
	 * @param request
	 * @param response
	 * @param itemBrandIDs
	 * @param forward
	 * @return
	 */
	@RequestMapping(value = "/deleteItemBrand", params = { "itemBrandIDs[]", "forward" })
	public ModelAndView deleteItemBrand(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("itemBrandIDs[]") List<Integer> itemBrandIDs,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		view = RequestUtil.requestForward(response, itemBrandService.deleteItemBrand(itemBrandIDs), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 * @Description:查询所有品牌 名称
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping("/getAllBrandName")
	public @ResponseBody List<ItemBrand> getAllBrandName(){
		
		return itemBrandService.getAllBrandName();
		
	}
	/**
	 * @Description:查询所有品牌 下的系列
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping("/getAllBrandLetter")
	public @ResponseBody List<Map<String,Object>> getAllBrandLetter(){
		
		return itemBrandService.getAllBrandLetter();
		
	}
}
