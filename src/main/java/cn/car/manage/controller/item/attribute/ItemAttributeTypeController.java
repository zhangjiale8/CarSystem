package cn.car.manage.controller.item.attribute;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.car.manage.beans.orm.item.attribute.ItemAttributeType;
import cn.car.manage.service.item.attribute.ItemAttributeTypeService;

/**
 * @Description:商品类型属性控制层
 * @author 
 * @date 2018年3月10日
 */
@Controller
@RequestMapping("/itemTypeAttribute")
public class ItemAttributeTypeController {

	@Autowired
	private ItemAttributeTypeService itemAttributeTypeService;
	

}
