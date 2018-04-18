package cn.car.manage.mapper.item.order;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.order.ItemOrder;

/**
 * @Description:商品订单数据层
 * @author 
 * @date 2018年3月20日
 */
@Repository
public interface ItemOrderMapper {

	/**
	 * @Description:订单分页
	 * @author 
	 * @date 2018年3月20日
	 */
	public List<ItemOrder> getItemOrderPage(@Param("itemOrderCode")String itemOrderCode,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("itemClassificationID")int itemClassificationID);

	public List<ItemOrder> getItemOrderByCustomerName(@Param("customerName")String customerName);
	/**
	 * @Description:新增订单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int addItemOrder(ItemOrder itemOrder);
	/**
	 * @Description:修改订单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int updateItemOrder(ItemOrder itemOrder);
	/**
	 * @Description:删除订单
	 * @author 
	 * @date 2018年3月10日
	 */
	public int deleteItemOrder(List<Integer> itemOrderID);
	/**
	 * @Description:根据订单ID查询
	 * @author 
	 * @date 2018年3月10日
	 */
	public ItemOrder getItemOrderByItemOrderID(@Param("itemOrderID")int itemOrderID);
	

	/**
	 * @Description:改变订单状态
	 * @author 
	 * @date 2018年3月16日
	 */
	public int updateItemOrderState(@Param("itemOrderID")int itemOrderID,@Param("itemOrderState")int itemOrderState);
	public int updateItemOrderStateByLookCarID(@Param("lookCarID")int lookCarID,@Param("itemOrderState")int itemOrderState);

	/**
	 * @Description:订单数量
	 * @author 
	 * @date 2018年3月16日
	 */
	public int getItemOrderCount();
	
	/**
	 * @Description:订单进行数量
	 * @author 
	 * @date 2018年3月16日
	 */
	public List<Map<String,Object>> getHaveInHandOrderCount();
	/**
	 * @Description:订单成功数量
	 * @author 
	 * @date 2018年3月16日
	 */
	public List<Map<String,Object>> getSuccessOrderCount();
	/**
	 * @Description:订单失败数量
	 * @author 
	 * @date 2018年3月16日
	 */
	public List<Map<String,Object>> getFailOrderCount();
	
	/**
	 * @Description:最近七天的订单失败统计
	 * @author 
	 * @date 2018年3月16日
	 */
	public List<Map<String,Object>> getCustomerSavenDaySuccess();
	
	/**
	 * @Description:最近七天的订单失败统计
	 * @author 
	 * @date 2018年3月16日
	 */
	public List<Map<String,Object>> getCustomerSavenDayHaveInHand();
	
	/**
	 * @Description:最近七天的订单失败统计
	 * @author 
	 * @date 2018年3月16日
	 */
	public List<Map<String,Object>> getCustomerSavenDayFail();
	
	/**
	 * @Description:查询订单是否存在
	 * @author 
	 * @date 2018年3月16日
	 */
	
	public ItemOrder getItemOrderByLookCarID(@Param("lookCarID")int lookCarID);
}
