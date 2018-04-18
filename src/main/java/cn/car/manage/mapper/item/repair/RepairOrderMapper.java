package cn.car.manage.mapper.item.repair;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.repair.RepairOrder;

/**
 * @Description:维修订单数据层
 * @author 
 * @date 2018年3月20日
 */
@Repository
public interface RepairOrderMapper {

	/**
	 * @Description:订单分页
	 * @author 
	 * @date 2018年3月20日
	 */
	public List<RepairOrder> getRepairOrderPage(@Param("repairOrderCode")String repairOrderCode,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("carCode")String carCode);

	/**
	 * @Description:新增订单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int addRepairOrder(RepairOrder repairOrder) ;
	/**
	 * @Description:修改订单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int updateRepairOrder(RepairOrder repairOrder);
	/**
	 * @Description:删除订单
	 * @author 
	 * @date 2018年3月10日
	 */
	public int deleteRepairOrder(List<Integer> repairOrderID);
	/**
	 * @Description:根据订单ID查询
	 * @author 
	 * @date 2018年3月10日
	 */
	public RepairOrder getRepairOrderByRepairOrderID(@Param("repairOrderID")int repairOrderID);
	

	/**
	 * @Description:改变订单状态
	 * @author 
	 * @date 2018年3月16日
	 */
	public int updateRepairOrderState(@Param("repairOrderID")int repairOrderID,@Param("repairOrderState")int repairOrderState);

	/**
	 * @Description:订单数量
	 * @author 
	 * @date 2018年3月16日
	 */
	public int getRepairOrderCount();
}
