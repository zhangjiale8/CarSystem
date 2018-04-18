package cn.car.manage.mapper.item.attribute;

import java.util.List;


import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.attribute.ItemAttributeType;

/**
 * @Description:商品类型属性数据层
 * @author 
 * @date 2018年3月10日
 */
@Repository
public interface ItemAttributeTypeMapper {

	/**
	 * @Description:商品类型属性查询
	 * @author 
	 * @date 2018年3月10日
	 */
	public List<ItemAttributeType> selectItemAttribute();
}
