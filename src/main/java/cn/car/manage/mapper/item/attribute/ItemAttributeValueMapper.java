package cn.car.manage.mapper.item.attribute;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.attribute.ItemAttributeValue;

/**
 * @Description:商品属性数据层
 * @author 
 * @date 2018年3月10日
 */
@Repository
public interface ItemAttributeValueMapper {

	/**
	 * @Description:查询商品属性
	 * @param itemTypeID
	 * @return
	 */
	public List<Map<String,Object>> selectItemAttribute(@Param("itemTypeID") int itemTypeID);
	
	
	/**
	 * @Description:新增商品属性值
	 * @param itemAttributeValue
	 * @return
	 */
	public int addItemAttributeValue(List<ItemAttributeValue> itemAttributeValue);
	
	/**
	 * @Description:查询商品属性
	 * @param itemTypeID
	 * @return
	 */
	public List<Map<String,Object>> getItemAttributeValueByItemID(@Param("itemID")int itemID);
}
