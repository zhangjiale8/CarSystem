package cn.car.manage.service.item.stock;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.car.manage.beans.orm.item.stock.ItemStock;
import cn.car.manage.mapper.item.stock.ItemStockMapper;
import cn.car.manage.util.helper.DataTable;
import cn.car.manage.util.helper.DataTableReturn;

/**
 * @Description:商品库存业务层
 * @author 
 * @date 2018年3月16
 */
@Service
public class ItemStockService {

	@Autowired
	private ItemStockMapper itemStockMapper;
	
	
	/**
	 * @Description:整车商品分页
	 * @author 
	 * @date 2018年3月16
	 */
	public DataTableReturn<ItemStock> getVehicleItemStockByItemCodeOrItemNameOrWareHouseName(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		DataTable dataTable = new DataTable(request);
		String itemName = dataTable.getParameters().getOrDefault("itemName", "").toString();
		String itemCode = dataTable.getParameters().getOrDefault("itemCode", "").toString();
		String wareHouseID=dataTable.getParameters().getOrDefault("wareHouseID","-1").toString();
		itemName = itemName.isEmpty() ? null : itemName.trim();
		itemCode = itemCode.isEmpty() ? null : itemCode.trim();
		
		wareHouseID = wareHouseID.isEmpty() ? null : wareHouseID.trim();
		PageHelper.startPage(dataTable.getStart(), dataTable.getLength(), dataTable.getSort());
		
		List<ItemStock> list = itemStockMapper.getVehicleItemStockByItemCodeOrItemNameOrWareHouseName(itemName, itemCode, Integer.parseInt(wareHouseID));
		
		Page<ItemStock> page = (Page<ItemStock>) list;
		
		DataTableReturn<ItemStock> dtReturn = new DataTableReturn<ItemStock>(dataTable.getsEcho(), page.getTotal(),
				page.getTotal(), list);
		
		return dtReturn;
	}
	/**
	 * @Description:零部件商品分页
	 * @author 
	 * @date 2018年3月16
	 */
	public DataTableReturn<ItemStock> getFittingItemStockByItemCodeOrItemNameOrWareHouseName(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		DataTable dataTable = new DataTable(request);
		String itemName = dataTable.getParameters().getOrDefault("itemName", "").toString();
		String itemCode = dataTable.getParameters().getOrDefault("itemCode", "").toString();
		String wareHouseID=dataTable.getParameters().getOrDefault("wareHouseID","-1").toString();
		itemName = itemName.isEmpty() ? null : itemName.trim();
		itemCode = itemCode.isEmpty() ? null : itemCode.trim();
		
		wareHouseID = wareHouseID.isEmpty() ? null : wareHouseID.trim();
		PageHelper.startPage(dataTable.getStart(), dataTable.getLength(), dataTable.getSort());
		
		List<ItemStock> list = itemStockMapper.getFittingItemStockByItemCodeOrItemNameOrWareHouseName(itemName, itemCode, Integer.parseInt(wareHouseID));
		
		Page<ItemStock> page = (Page<ItemStock>) list;
		
		DataTableReturn<ItemStock> dtReturn = new DataTableReturn<ItemStock>(dataTable.getsEcho(), page.getTotal(),
				page.getTotal(), list);
		
		return dtReturn;
	}
	/**
	 * @Description:根据ID查询
	 * @author 
	 * @date 2018年3月16
	 */
	public ItemStock getItemByItemID(int itemID){
		
		if(itemID==0){
			return null;
		}
		
		return itemStockMapper.getItemByItemID(itemID);
		
	}
	
	
	
}
