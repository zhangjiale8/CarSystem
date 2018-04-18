package cn.car.manage.mapper.item.stock;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.stock.ItemStock;

/**
 * @Description:商品库存
 * @author 李子辉
 * @date 2018年3月16
 */
@Repository
public interface ItemStockMapper {

	/**
	 * @Description:根据商品名称或者商品编号或者商品位置查询分页(整车)
	 * @author
	 * @date 2018年3月16
	 */
	public List<ItemStock> getVehicleItemStockByItemCodeOrItemNameOrWareHouseName(@Param("itemName") String itemName,@Param("itemCode")String itemCode,@Param("wareHouseID")int wareHouseID);

	/**
	 * @Description:根据商品名称或者商品编号或者商品位置查询分页（零部件）
	 * @author
	 * @date 2018年3月16
	 */
	public List<ItemStock> getFittingItemStockByItemCodeOrItemNameOrWareHouseName(@Param("itemName") String itemName,@Param("itemCode")String itemCode,@Param("wareHouseID")int wareHouseID);

	/**
	 * @Description:根据商品ID查询商品
	 * @author
	 * @date 2018年3月16
	 */
	public ItemStock getItemByItemID(@Param("itemID")int itemID);
	/**
	 * @Description:根据商品ID商品数量修改库存(商品出库)
	 * @author
	 * @date 2018年3月16
	 */
	public int updateItemStockNumByItemIDIsOutLibrary(@Param("itemID")long itemID,@Param("itemNum")int itemNum);
	
	/**
	 * @Description:根据商品ID商品数量修改库存（商品进库）
	 * @author
	 * @date 2018年3月16
	 */
	public int updateItemStockNumByItemIDIsEnterLibrary(@Param("itemID")long itemID,@Param("itemNum")int itemNum);
	
	/**
	 * @Description:新增商品库存
	 * @author
	 * @date 2018年3月16
	 */
	public int addItemStock(ItemStock itemStock);
	/**
	 * @Description:撤销出库单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int revokeItemOutLibraryOrder(@Param("oldItemID") long oldItemID,@Param("oldOutLibraryNum") int oldOutLibraryNum);
	
	
	/**
	 * @Description:撤销入库单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int revokeItemEnterLibraryOrder(@Param("itemID") long itemID,@Param("oldEnterLibraryNum") int oldEnterLibraryNum);

	/**
	 * @Description:库存数量
	 * @author 
	 * @date 2018年3月16日
	 */
	public int getTotalStockNum();
	
	public List<Map<String,Object>> getItemEnterAndOutAndStock();
}
