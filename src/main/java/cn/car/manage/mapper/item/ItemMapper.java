package cn.car.manage.mapper.item;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.Item;
import cn.car.manage.beans.orm.item.ItemAndBrand;

/**
 * @Description:商品数据层
 * @author 
 * @date 2018年3月10日
 */
@Repository
public interface ItemMapper {
	
	
	/**
	 * 
	 * @Description: 查询商品
	 * @author
	 * @Date: 2018年3月10日
	 * @param itemID
	 * @return
	 */
	public Item getItemByItemID(@Param("itemID") long itemID);
	/**
	 * 
	 * @Description: 新增商品
	 * @author
	 * @Date: 2018年3月20日
	 * @param itemID
	 * @return
	 */
	public int addItem(Item item);
	/**
	 * 
	 * @Description: 查询商品
	 * @author
	 * @Date: 2018年3月10日
	 * @param itemID
	 * @return
	 */
	public Item getItemByItemCode(@Param("itemCode") String itemCode);
	/**
	 * 
	 * @Description: 查询所有商品条形码
	 * @author
	 * @Date: 2018年3月10日
	 * @param 
	 * @return
	 */
	public List<Item> getAllItemCode(@Param("itemClassificationID")int itemClassificationID);
	
	public List<ItemAndBrand> getItemOther();
	/**
	 * 
	 * @Description: 分页
	 * @author
	 * @Date: 2018年3月10日
	 * @param item
	 * @return
	 */
	public List<ItemAndBrand> getItemAll(@Param("name") String name, @Param("itemClassificationID") int itemClassificationID);

	public ItemAndBrand selectItemInfoByItemID(@Param("itemID")int itemID);

}
