package cn.car.manage.controller.chart;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.car.manage.service.item.chart.ItemOrderAndCustomerChartService;

/**
 * @Description:数据统计控制层
 * @author 
 * @date 2018年3月27
 */
@Controller
@RequestMapping("chart")
public class ItemOrderAndCustomerChartController {

	@Autowired
	private ItemOrderAndCustomerChartService itemOrderAndCustomerChartService;
	
	
	@RequestMapping(value={"/getItemOrderAndCustomerAndStockNumAndRepairOrder"},
			produces={"application/json;charset=UTF-8"})
	public @ResponseBody List<Map<String,Object>> getItemOrderAndCustomerAndStockNumAndRepairOrder(){
		return itemOrderAndCustomerChartService.getItemOrderAndCustomerAndStockNumAndRepairOrder();
		
	}
	
	@RequestMapping(value={"/getItemEnterAndOutAndStock"},
			produces={"application/json;charset=UTF-8"})
	public @ResponseBody List<Map<String,Object>> getItemEnterAndOutAndStock(){
		return itemOrderAndCustomerChartService.getItemEnterAndOutAndStock();
		
	}
	
	@RequestMapping(value={"/getItemOrderStateAndCustomerCount"},
	produces={"application/json;charset=UTF-8"})
	public @ResponseBody List<Map<String,Object>> getItemOrderStateAndCustomerCount(){
		return itemOrderAndCustomerChartService.getItemOrderStateAndCustomerCount();
		
	}
}
