package cn.car.manage.service.item.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.car.manage.beans.orm.customer.Customer;
import cn.car.manage.beans.orm.item.order.ItemOrder;
import cn.car.manage.beans.orm.item.order.LookCarOrder;
import cn.car.manage.mapper.customer.CustomerMapper;
import cn.car.manage.mapper.item.order.ItemOrderMapper;
import cn.car.manage.mapper.item.order.LookCarOrderMapper;
import cn.car.manage.util.helper.DataTable;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.ItemOrderCodeUtil;
/**
 * @Description:预约订单业务层
 * @author 
 * @date 2018年3月20日
 */
@Service
public class LookCarOrderService {

	@Autowired
	private LookCarOrderMapper lookCarOrderMapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private ItemOrderMapper itemOrderMapper;
	@Autowired
	private ItemOrderService itemOrderMapperService;
	private ItemOrderCodeUtil itemOrderCode=new ItemOrderCodeUtil();
	/**
	 * @Description:预约订单分页
	 * @author 
	 * @date 2018年3月20日
	 */

	public DataTableReturn<LookCarOrder> getLookCarOrderPage(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		
		DataTable dataTable = new DataTable(request);
		String customerName = dataTable.getParameters().getOrDefault("customerName", 0).toString();
		System.out.println(customerName);
		String phoneNum = dataTable.getParameters().getOrDefault("phoneNum", "").toString();
		String startTime=dataTable.getParameters().getOrDefault("startTime","").toString();
		String endTime=dataTable.getParameters().getOrDefault("endTime","").toString();
		String state=dataTable.getParameters().getOrDefault("state",0).toString();
		String itemClassificationID=dataTable.getParameters().getOrDefault("itemClassificationID","0").toString();
		customerName = customerName.isEmpty() ? null : customerName.trim();
		phoneNum = phoneNum.isEmpty() ? null : phoneNum.trim();
		startTime = startTime.isEmpty() ? null : startTime.trim();
		endTime = endTime.isEmpty() ? null : endTime.trim();
		state = state.isEmpty() ? null : state.trim();
		itemClassificationID = itemClassificationID.isEmpty() ? null : itemClassificationID.trim();
		PageHelper.startPage(dataTable.getStart(), dataTable.getLength(), dataTable.getSort());
		
		List<LookCarOrder> list = lookCarOrderMapper.getLookCarOrderPage(customerName, phoneNum, startTime, endTime, Integer.parseInt(itemClassificationID),Integer.parseInt(state));
	
		Page<LookCarOrder> page = (Page<LookCarOrder>) list;
		DataTableReturn<LookCarOrder> dtReturn = new DataTableReturn<LookCarOrder>(dataTable.getsEcho(), page.getTotal(),
				page.getTotal(), list);
		return dtReturn;
	}
	public DataTableReturn<LookCarOrder> getLookCarOrderByCustomerName(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		
		DataTable dataTable = new DataTable(request);
		String customerName = dataTable.getParameters().getOrDefault("customerName", 0).toString();
		
		customerName = customerName.isEmpty() ? null : customerName.trim();
		
		PageHelper.startPage(dataTable.getStart(), dataTable.getLength(), dataTable.getSort());
		
		List<LookCarOrder> list = lookCarOrderMapper.getLookCarOrderByCustomerName(customerName);
	
		Page<LookCarOrder> page = (Page<LookCarOrder>) list;
		DataTableReturn<LookCarOrder> dtReturn = new DataTableReturn<LookCarOrder>(dataTable.getsEcho(), page.getTotal(),
				page.getTotal(), list);
		return dtReturn;
	}
	/**
	 * @Description:新增预约订单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int addLookCarOrder(LookCarOrder lookCarOrder){
		if(lookCarOrder==null){
			return 0;
		}
		Customer customer=customerMapper.getCustomerInfoWithName(lookCarOrder.getCustomerName());
		lookCarOrder.setPhoneNum(customer.getUserPhone());
		lookCarOrder.setCustomerID(customer.getUserID());
	    return lookCarOrderMapper.addLookCarOrder(lookCarOrder);
		
	}
	
	/**
	 * @Description:删除预约订单
	 * @author 
	 * @date 2018年3月10日
	 */
	public int deleteLookCarOrder(List<Integer> lookCarID){
		if(lookCarID.size()==0||lookCarID==null){
			return 0;
		}
		return lookCarOrderMapper.deleteLookCarOrder(lookCarID);
		
	}
	

	/**
	 * @Description:改变预约订单状态
	 * @author 
	 * @date 2018年3月16日
	 */
	public int updateLookCarOrderState(int lookCarID,int state){
		if(lookCarID==0){
			return 0;
		}
		if(state==1){
			
			LookCarOrder lookCarOrder=lookCarOrderMapper.getItemLookCarOrderByLookCarID(lookCarID);
			ItemOrder itemOrder=new ItemOrder();
			itemOrder.setLookCarID(lookCarID);
			itemOrder.setCustomerName(lookCarOrder.getCustomerName());
			itemOrder.setItemID(lookCarOrder.getItemID());
			itemOrderMapperService.addItemOrder(itemOrder);
			
		}else{
			itemOrderMapperService.updateItemOrderStateByLookCarID(lookCarID, state);
		}
	
		return lookCarOrderMapper.updateLookCarOrderState(lookCarID, state);
		
	}
}
