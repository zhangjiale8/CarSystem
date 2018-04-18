package cn.car.manage.mapper.item.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.order.LookCarOrder;
/**
 * @Description:预约订单数据层
 * @author 
 * @date 2018年3月16日
 */
@Repository
public interface LookCarOrderMapper {

	
	/**
	 * @Description:订单分页
	 * @author 
	 * @date 2018年3月20日
	 */
	public List<LookCarOrder> getLookCarOrderPage(@Param("customerName")String customerName,@Param("phoneNum")String phoneNum,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("itemClassificationID")int itemClassificationID,@Param("state")int state);
	public List<LookCarOrder> getLookCarOrderByCustomerName(@Param("customerName")String customerName);
	/**
	 * @Description:新增订单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int addLookCarOrder(LookCarOrder lookCarOrder);
	
	/**
	 * @Description:删除订单
	 * @author 
	 * @date 2018年3月10日
	 */
	public int deleteLookCarOrder(List<Integer> lookCarID);
	

	/**
	 * @Description:改变订单状态
	 * @author 
	 * @date 2018年3月16日
	 */
	public int updateLookCarOrderState(@Param("lookCarID")int lookCarID,@Param("state")int state);
	
	/**
	 * @Description:预约看车统计
	 * @author 
	 * @date 2018年3月16日
	 */
	public int lookCarOrderCount();
	
	public LookCarOrder getItemLookCarOrderByLookCarID(@Param("lookCarID")int lookCarID);
}
