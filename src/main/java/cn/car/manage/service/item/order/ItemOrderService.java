package cn.car.manage.service.item.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.car.manage.beans.orm.customer.Customer;
import cn.car.manage.beans.orm.item.Item;
import cn.car.manage.beans.orm.item.order.ItemOrder;
import cn.car.manage.beans.orm.item.order.OrderDetailed;
import cn.car.manage.mapper.customer.CustomerMapper;
import cn.car.manage.mapper.item.ItemMapper;
import cn.car.manage.mapper.item.order.ItemOrderMapper;
import cn.car.manage.mapper.item.order.OrderDetailedMapper;
import cn.car.manage.util.helper.BigDecimalUtil;
import cn.car.manage.util.helper.DataTable;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.ItemOrderCodeUtil;

/**
 * @Description:商品订单业务层
 * @author 
 * @date 2018年3月20日
 */
@Service
public class ItemOrderService {
	@Autowired
	private ItemOrderMapper itemOrderMapper;
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private CustomerMapper customerMapper;
	private ItemOrderCodeUtil itemOrderCode=new ItemOrderCodeUtil();
	@Autowired
	private OrderDetailedMapper orderDetailedMapper;
	/**
	 * @Description:订单分页
	 * @author getItemOrderByCustomerName
	 * @date 2018年3月20日
	 */

	public DataTableReturn<ItemOrder> getItemOrderPage(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		DataTable dataTable = new DataTable(request);
		String itemOrderCode = dataTable.getParameters().getOrDefault("itemOrderCode", "").toString();
		String startTime=dataTable.getParameters().getOrDefault("startTime","").toString();
		String endTime=dataTable.getParameters().getOrDefault("endTime","").toString();
		String itemClassificationID=dataTable.getParameters().getOrDefault("itemClassificationID","0").toString();
		itemOrderCode = itemOrderCode.isEmpty() ? null : itemOrderCode.trim();
		startTime = startTime.isEmpty() ? null : startTime.trim();
		endTime = endTime.isEmpty() ? null : endTime.trim();
		itemClassificationID = itemClassificationID.isEmpty() ? null : itemClassificationID.trim();
		PageHelper.startPage(dataTable.getStart(), dataTable.getLength(), dataTable.getSort());
		
		List<ItemOrder> list = itemOrderMapper.getItemOrderPage(itemOrderCode, startTime, endTime, Integer.parseInt(itemClassificationID));
	
		Page<ItemOrder> page = (Page<ItemOrder>) list;
		DataTableReturn<ItemOrder> dtReturn = new DataTableReturn<ItemOrder>(dataTable.getsEcho(), page.getTotal(),
				page.getTotal(), list);
		return dtReturn;
	}
	
	/**
	 * @Description:订单分页
	 * @author getItemOrderByCustomerName
	 * @date 2018年3月20日
	 */

	public DataTableReturn<ItemOrder> getItemOrderByCustomerName(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		DataTable dataTable = new DataTable(request);
		String customerName = dataTable.getParameters().getOrDefault("customerName", "").toString();
		
		customerName = customerName.isEmpty() ? null : customerName.trim();
		;
		PageHelper.startPage(dataTable.getStart(), dataTable.getLength(), dataTable.getSort());
		
		List<ItemOrder> list = itemOrderMapper.getItemOrderByCustomerName(customerName);
	
		Page<ItemOrder> page = (Page<ItemOrder>) list;
		DataTableReturn<ItemOrder> dtReturn = new DataTableReturn<ItemOrder>(dataTable.getsEcho(), page.getTotal(),
				page.getTotal(), list);
		return dtReturn;
	}
	/**
	 * @Description:新增订单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int addItemOrder(ItemOrder itemOrder){
		if(itemOrder==null){
			return 0;
		}
		
		Customer customers=customerMapper.getCustomerInfoWithName(itemOrder.getCustomerName());
		if(customers==null){
			Customer customer=new Customer();
			customer.setUserName(itemOrder.getCustomerName());
			customer.setUserPhone(itemOrder.getPhone());
			customerMapper.addCustomer(customer);
		    itemOrder.setCustomerID(customer.getUserID());
		}else{
			itemOrder.setCustomerName(customers.getUserName());
			itemOrder.setPhone(customers.getUserPhone());
			itemOrder.setCustomerID(customers.getUserID());
			itemOrder.setItemNum(1);
			itemOrder.setItemOrderCode(String.valueOf(itemOrderCode.nextId()));
		}
		
		Item item=itemMapper.getItemByItemID(itemOrder.getItemID());
	    double totalPrice= BigDecimalUtil.multiply(item.getItemPrice(), (double)itemOrder.getItemNum());
	    itemOrder.setTotalPrice(totalPrice);
	    int result=itemOrderMapper.addItemOrder(itemOrder);
	    
	    orderDetailedMapper.addOrderDetailed(new OrderDetailed(itemOrder.getItemOrderID(),itemOrder.getItemID(),itemOrder.getItemNum()));
	    
	    return result;
		
	}
	/**
	 * @Description:修改订单
	 * @author 
	 * @date 2018年3月16日
	 */
	public int updateItemOrder(ItemOrder itemOrder){
		if(itemOrder==null){
			return 0;
		}
		return itemOrderMapper.updateItemOrder(itemOrder);
		
	}
	/**
	 * @Description:删除订单
	 * @author 
	 * @date 2018年3月10日
	 */
	public int deleteItemOrder(List<Integer> itemOrderID){
		if(itemOrderID.size()==0||itemOrderID==null){
			return 0;
		}
		return itemOrderMapper.deleteItemOrder(itemOrderID);
		
	}
	/**
	 * @Description:根据订单ID查询
	 * @author 
	 * @date 2018年3月10日
	 */
	public ItemOrder getItemOrderByItemOrderID(int itemOrderID){
		if(itemOrderID==0){
			return null;
		}
		return itemOrderMapper.getItemOrderByItemOrderID(itemOrderID);
		
	}
	

	/**
	 * @Description:改变订单状态
	 * @author 
	 * @date 2018年3月16日
	 */
	public int updateItemOrderState(int itemOrderID,int itemOrderState){
		if(itemOrderID==0||itemOrderState==0){
			return 0;
		}
		return itemOrderMapper.updateItemOrderState(itemOrderID, itemOrderState);
		
	}
	public int updateItemOrderStateByLookCarID(int lookCarID,int itemOrderState){
		if(lookCarID==0||itemOrderState==0){
			return 0;
		}
		ItemOrder order=itemOrderMapper.getItemOrderByLookCarID(lookCarID);
		if(order==null){
			
			return 0;
		}
		return itemOrderMapper.updateItemOrderStateByLookCarID(lookCarID, itemOrderState);
		
	}
}
