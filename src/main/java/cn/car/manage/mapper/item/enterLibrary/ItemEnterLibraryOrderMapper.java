package cn.car.manage.mapper.item.enterLibrary;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.enterLibrary.ItemEnterLibrary;

/**
 * @Description:商品进库数据层
 * @author 
 * @date 2018年3月16日
 *
 */
@Repository
public interface ItemEnterLibraryOrderMapper {

	/**
	 * @Description:分页
	 * @author 
	 * @date 2018年3月16日
	 */
	public List<ItemEnterLibrary> getEnterLibraryOrderPage(@Param("enterLibraryCode")String enterLibraryCode,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("itemClassificationID")int itemClassificationID);

	/**
	 * @Description:新增进库单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int addEnterLibraryOrder(ItemEnterLibrary itemEnterLibrary);
	/**
	 * @Description:修改进库单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int updateItemEnterLibraryOrder(ItemEnterLibrary itemEnterLibrary);
	/**
	 * @Description:删除进库单
	 * @author 
	 * @date 2018年3月10日
	 */
	public int deleteEnterLibraryOrder(List<Integer> enterLibraryID);
	/**
	 * @Description:根据进库单ID查询
	 * @author 
	 * @date 2018年3月10日
	 */
	public ItemEnterLibrary getEnterLibrarOrderByEnterLibaryID(@Param("enterLibraryID")int enterLibraryID);
	
	
}
