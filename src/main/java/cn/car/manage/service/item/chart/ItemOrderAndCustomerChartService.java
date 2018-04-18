package cn.car.manage.service.item.chart;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import cn.car.manage.mapper.customer.CustomerMapper;
import cn.car.manage.mapper.item.order.ItemOrderMapper;
import cn.car.manage.mapper.item.order.LookCarOrderMapper;
import cn.car.manage.mapper.item.repair.RepairOrderMapper;
import cn.car.manage.mapper.item.stock.ItemStockMapper;
import cn.car.manage.pub.enums.ItemOrderCustomerStockNumEnum;


/**
 * @Description:数据统计业务层
 * @author 
 * @date 2018年3月27
 */
@Service
public class ItemOrderAndCustomerChartService {

	@Autowired
	private ItemOrderMapper itemOrderMapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private RepairOrderMapper repairOrderMapper;
	@Autowired
	private ItemStockMapper itemStockMapper;
	@Autowired
	private LookCarOrderMapper lookCarOrderMapper;
	/**
	 * @Description:统计客户,销售订单  维修订单  库存
	 * @author 
	 * @date 2018年3月27
	 */
	public List<Map<String,Object>> getItemOrderAndCustomerAndStockNumAndRepairOrder(){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		int itemOrderCount=itemOrderMapper.getItemOrderCount();
		int itemRepairCount=repairOrderMapper.getRepairOrderCount();
		int customerCount=customerMapper.getCustomerCount();
		int itemStockCount=itemStockMapper.getTotalStockNum();
		Map<String,Object> map =new HashMap<String,Object>();
		Map<String,Object> map1 =new HashMap<String,Object>();
		Map<String,Object> map2 =new HashMap<String,Object>();
		Map<String,Object> map3 =new HashMap<String,Object>();
		map.put(ItemOrderCustomerStockNumEnum.CUSTOMER.getName(),ItemOrderCustomerStockNumEnum.CUSTOMER.getValue());
		map.put(ItemOrderCustomerStockNumEnum.CUSTOMER.getValue(), customerCount);
		list.add(map);
		
		map1.put(ItemOrderCustomerStockNumEnum.ITEMORDER.getName(),ItemOrderCustomerStockNumEnum.ITEMORDER.getValue());
		map1.put(ItemOrderCustomerStockNumEnum.ITEMORDER.getValue(), itemOrderCount);
		list.add(map1);
		
		map2.put(ItemOrderCustomerStockNumEnum.REPAIRORDER.getName(),ItemOrderCustomerStockNumEnum.REPAIRORDER.getValue());
		map2.put(ItemOrderCustomerStockNumEnum.REPAIRORDER.getValue(), itemRepairCount);
		list.add(map2);
		
		map3.put(ItemOrderCustomerStockNumEnum.STOCKNUM.getName(),ItemOrderCustomerStockNumEnum.STOCKNUM.getValue());
		map3.put(ItemOrderCustomerStockNumEnum.STOCKNUM.getValue(), itemStockCount);
		list.add(map3);
		
		return list;
		
	}
	
	/**
	 * @Description:统计各仓库出库进库库存
	 * @author 
	 * @date 2018年3月27
	 */
	public List<Map<String,Object>> getItemEnterAndOutAndStock(){
		
		
		return itemStockMapper.getItemEnterAndOutAndStock();
			
	}
	/**
	 * @Description:统计订单状态的用户
	 * @author 
	 * @date 2018年3月27
	 */

	public List<Map<String,Object>> getItemOrderStateAndCustomerCount(){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Map<String,Object> map =new HashMap<String,Object>();
		Map<String,Object> successMap =new HashMap<String,Object>();
		Map<String,Object> failMap =new HashMap<String,Object>();
		Map<String,Object> haveInhHandMap =new HashMap<String,Object>();
		
		int lookCarOrderCount=lookCarOrderMapper.lookCarOrderCount();
		
		map.put(ItemOrderCustomerStockNumEnum.LookCarOrder.getName(), ItemOrderCustomerStockNumEnum.LookCarOrder.getValue());
		map.put(ItemOrderCustomerStockNumEnum.LookCarOrder.getValue(), lookCarOrderCount);
		list.add(map);
		List<Map<String,Object>> havnInhandList=itemOrderMapper.getHaveInHandOrderCount();
		for (Map<String, Object> haveHandMap : havnInhandList) {
			
			haveInhHandMap.put(ItemOrderCustomerStockNumEnum.HaveInHandOrder.getName(), ItemOrderCustomerStockNumEnum.HaveInHandOrder.getValue());
			haveInhHandMap.put(ItemOrderCustomerStockNumEnum.HaveInHandOrder.getValue(), haveHandMap.get("haveInHandOrderCount"));
			
			list.add(haveInhHandMap);
		}
		List<Map<String,Object>> successList=itemOrderMapper.getSuccessOrderCount();
		for (Map<String, Object> succesMap : successList) {
			
			successMap.put(ItemOrderCustomerStockNumEnum.SuccessOrder.getName(), ItemOrderCustomerStockNumEnum.SuccessOrder.getValue());
			successMap.put(ItemOrderCustomerStockNumEnum.SuccessOrder.getValue(), succesMap.get("successOrderCount"));
			
			list.add(successMap);
		}
		List<Map<String,Object>> failList=itemOrderMapper.getFailOrderCount();
		for (Map<String, Object> faiMap : failList) {
			
			failMap.put(ItemOrderCustomerStockNumEnum.FailOrder.getName(), ItemOrderCustomerStockNumEnum.FailOrder.getValue());
			failMap.put(ItemOrderCustomerStockNumEnum.FailOrder.getValue(), faiMap.get("failOrderCount"));
			list.add(failMap);
		}
		
		return list;
		
	}

}
