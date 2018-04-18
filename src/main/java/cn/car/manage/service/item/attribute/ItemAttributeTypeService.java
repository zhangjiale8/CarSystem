package cn.car.manage.service.item.attribute;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.car.manage.beans.orm.item.attribute.ItemAttributeType;
import cn.car.manage.mapper.item.attribute.ItemAttributeTypeMapper;

/**
 * @Description:商品类型属性业务层
 * @author 
 * @date 2018年3月10日
 */
@Service
public class ItemAttributeTypeService {

	@Autowired
	private ItemAttributeTypeMapper itemAttributeTypeMapper;
	
}
