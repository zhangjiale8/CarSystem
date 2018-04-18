package cn.car.manage.controller.item.attribute;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.car.manage.service.item.attribute.ItemAttributeValueService;

/**
 * @Description:商品属性控制层
 * @author 
 * @date 2018年3月10日
 */
@Controller
@RequestMapping("/itemAttribute")
public class ItemAttributeValueController {

	@Autowired
	private ItemAttributeValueService itemAttributeValueService;
	
	@RequestMapping(value="itemAttributeByItemTypeID",params={"itemTypeID"})
	public @ResponseBody Map<String,Object> selectAllassetTypeName(int itemTypeID){
		
		return itemAttributeValueService.itemAttributeByItemTypeID(itemTypeID);
		
	}
}
