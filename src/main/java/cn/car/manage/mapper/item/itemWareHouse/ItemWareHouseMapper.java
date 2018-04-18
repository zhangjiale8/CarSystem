package cn.car.manage.mapper.item.itemWareHouse;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.wareHouse.ItemExistWareHouse;
import cn.car.manage.beans.orm.item.wareHouse.WareHouse;

/**
 * @Description:仓库包含商品的数据层
 * @author 李子辉
 * @date 2018年3月13日
 */
@Repository
public interface ItemWareHouseMapper {

	/**
	 * @Description:分页
	 * @param itemName
	 * @param itemCode
	 * @param wareHouseName
	 * @return
	 */
	public List<ItemExistWareHouse> getWareHouseItemByItemNameOrItemCoudOrWareHouseName(@Param("itemName")String itemName,@Param("itemCode") String itemCode,@Param("wareHouseID") int wareHouseID,@Param("itemClassificationID")int itemClassificationID);

	/**
	 * @Description:新增仓库
	 * @param itemName
	 * @param itemCode
	 * @param wareHouseName
	 * @return
	 */
	public int addWareHouse(WareHouse wareHouse);
	
	/**
	 * @Description:修改状态
	 * @param itemName
	 * @param itemCode
	 * @param wareHouseName
	 * @return
	 */
	public int updateItemStateByItemIdAndItemStateID(@Param("itemID")int itemID,@Param("itemStateID")int itemStateID);
	
	/**
	 * @Description:给商品更换仓库
	 * @param itemName
	 * @param itemCode
	 * @param wareHouseName
	 * @return
	 */
	public int updateItemWareHousePosition(@Param("itemID")int itemID,@Param("wareHouseID")int wareHouseID);
	
	/**
	 * @Description:移除仓库某商品
	 * @param itemName
	 * @param itemCode
	 * @param wareHouseName
	 * @return
	 */
	public int deleteWareHouseItem(List<Integer> itemID);
	
	/**
	 * @Description:查询全部仓库
	 *  
	 */
	public List<WareHouse> getAllWareHouse();
	
	public ItemExistWareHouse getItemExistWareHouseByItemID(int itemID);
	
	
}
