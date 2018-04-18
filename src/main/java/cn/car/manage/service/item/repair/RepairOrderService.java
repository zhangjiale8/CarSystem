package cn.car.manage.service.item.repair;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.car.manage.beans.orm.item.repair.RepairOrder;
import cn.car.manage.mapper.item.repair.RepairOrderMapper;
import cn.car.manage.util.helper.DataTable;
import cn.car.manage.util.helper.DataTableReturn;
/**
 * @Description:维修订单业务层
 * @author 
 * @date 2018年3月20日
 */
@Service
public class RepairOrderService {

	@Autowired
	private RepairOrderMapper repairOrderMapper;
	/**
	 * @Description:订单分页
	 * @author 
	 * @date 2018年3月20日
	 */
	public DataTableReturn<RepairOrder> getRepairOrderPage(HttpServletRequest request){
		if (request == null) {
			return null;
		}
		DataTable dataTable = new DataTable(request);
		String repairOrderCode = dataTable.getParameters().getOrDefault("repairOrderCode", "").toString();
		String startTime=dataTable.getParameters().getOrDefault("startTime","").toString();
		String endTime=dataTable.getParameters().getOrDefault("endTime","").toString();
		String carCode=dataTable.getParameters().getOrDefault("carCode","").toString();
		repairOrderCode = repairOrderCode.isEmpty() ? null : repairOrderCode.trim();
		startTime = startTime.isEmpty() ? null : startTime.trim();
		endTime = endTime.isEmpty() ? null : endTime.trim();
		carCode = carCode.isEmpty() ? null : carCode.trim();
		PageHelper.startPage(dataTable.getStart(), dataTable.getLength(), dataTable.getSort());
		
		List<RepairOrder> list = repairOrderMapper.getRepairOrderPage(repairOrderCode, startTime, endTime, carCode);
	
		Page<RepairOrder> page = (Page<RepairOrder>) list;
		DataTableReturn<RepairOrder> dtReturn = new DataTableReturn<RepairOrder>(dataTable.getsEcho(), page.getTotal(),
				page.getTotal(), list);
		return dtReturn;
		
	}

	/**
	 * @Description:新增订单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int addRepairOrder(RepairOrder repairOrder) {
		
		if(repairOrder==null){
			return 0;
		}
		return repairOrderMapper.addRepairOrder(repairOrder);
		
	}
	/**
	 * @Description:修改订单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int updateRepairOrder(RepairOrder repairOrder){
		
		if(repairOrder==null){
			return 0;
		}
		return repairOrderMapper.updateRepairOrder(repairOrder);
		
	}
	/**
	 * @Description:删除订单
	 * @author 
	 * @date 2018年3月10日
	 */
	public int deleteRepairOrder(List<Integer> repairOrderID){
		
		if(repairOrderID.size()==0||repairOrderID==null){
			return 0;
		}
		
		return repairOrderMapper.deleteRepairOrder(repairOrderID);
		
	}
	/**
	 * @Description:根据订单ID查询
	 * @author 
	 * @date 2018年3月10日
	 */
	public RepairOrder getRepairOrderByRepairOrderID(@Param("repairOrderID")int repairOrderID){
		
		if(repairOrderID==0){
			return null;
		}
		return repairOrderMapper.getRepairOrderByRepairOrderID(repairOrderID);
		
	}
	

	/**
	 * @Description:改变订单状态
	 * @author 
	 * @date 2018年3月16日
	 */
	public int updateRepairOrderState(@Param("repairOrderID")int repairOrderID,@Param("repairOrderState")int repairOrderState){
		
		if(repairOrderID==0||repairOrderState==0){
			return 0;
		}
		return repairOrderMapper.updateRepairOrderState(repairOrderID, repairOrderState);
		
	}
}
