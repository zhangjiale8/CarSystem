package cn.car.manage.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.car.manage.annotation.ParameterName;
import cn.car.manage.beans.orm.item.ItemSeries;
import cn.car.manage.service.item.ItemSeriesService;

/**
 * @Description:商品品牌系列
 * @author 李子辉
 * @date 2018年3月10日
 */
@Controller
@RequestMapping("itemSeries")
public class ItemSeriesController {

	@Autowired
	private ItemSeriesService itemSeriesService;
	
	@RequestMapping("/getAllItemSeries")
	public @ResponseBody List<ItemSeries> getAllItemSeries(){
		
		return itemSeriesService.getAllItemSeries();
		
	}
	@RequestMapping("/getItemSeriesByItemBrandID")
	public @ResponseBody List<ItemSeries> getItemSeriesByItemBrandID(@ParameterName("itemBrandID")int itemBrandID){
		
		return itemSeriesService.getItemSeriesByItemBrandID(itemBrandID);
		
	}
}
