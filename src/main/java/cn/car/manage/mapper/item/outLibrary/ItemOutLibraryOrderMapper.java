package cn.car.manage.mapper.item.outLibrary;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.outLibrary.ItemOutLibrary;

/**
 * @Description:零部件出库数据层
 * @author 
 * @date 2018年3月16日
 *
 */
@Repository
public interface ItemOutLibraryOrderMapper {

	/**
	 * @Description:分页
	 * @author 
	 * @date 2018年3月16日
	 */
	public List<ItemOutLibrary> getOutLibraryOrderPage(@Param("outLibraryCode")String outLibraryCode,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("itemClassificationID")int itemClassificationID);

	/**
	 * @Description:新增出库单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int addOutLibraryOrder(ItemOutLibrary itemOutLibrary);
	/**
	 * @Description:修改出库单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int updateItemOutLibraryOrder(ItemOutLibrary itemOutLibrary);
	/**
	 * @Description:删除出库单
	 * @author 
	 * @date 2018年3月10日
	 */
	public int deleteOutLibraryOrder(List<Integer> outLibraryID);
	/**
	 * @Description:根据出库单ID查询
	 * @author 
	 * @date 2018年3月10日
	 */
	public ItemOutLibrary getOutLibrarOrderByoutLibaryID(@Param("outLibraryID")int outLibraryID);
	
	/**
	 * @Description:撤销出库单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int revokeItemOutLibraryOrder(@Param("itemID") int itemID,@Param("oldOutLibraryNum") int oldOutLibraryNum);

	/**
	 * @Description:改变状态
	 * @author 
	 * @date 2018年3月16日
	 */
	public int updateOutLibraryOrderState(@Param("outLibraryID")int outLibraryID,@Param("outLibraryState")int outLibraryState);
}
