package cn.car.manage.service.item.enterLibrary;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.car.manage.beans.orm.item.Item;
import cn.car.manage.beans.orm.item.enterLibrary.ItemEnterLibrary;
import cn.car.manage.beans.orm.item.stock.ItemStock;
import cn.car.manage.mapper.item.ItemMapper;
import cn.car.manage.mapper.item.enterLibrary.ItemEnterLibraryOrderMapper;
import cn.car.manage.mapper.item.stock.ItemStockMapper;
import cn.car.manage.util.helper.DataTable;
import cn.car.manage.util.helper.DataTableReturn;

/**
 * @Description:商品进库库业务层
 * @author 
 * @date 2018年3月18日
 */
@Service
public class ItemEnterLibraryOrderService {

	@Autowired
	private ItemEnterLibraryOrderMapper itemEnterLibraryMapper;
	@Autowired
	private ItemStockMapper itemStockMapper;

	@Autowired
	private ItemMapper itemMapper;
	/**
	 * @Description:分页
	 * @author 
	 * @date 2018年3月18日
	 */
	public DataTableReturn<ItemEnterLibrary> getEnterLibraryOrderPage(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		DataTable dataTable = new DataTable(request);
		String enterLibraryCode = dataTable.getParameters().getOrDefault("enterLibraryCode", "").toString();
		String startTime=dataTable.getParameters().getOrDefault("startTime","").toString();
		String endTime=dataTable.getParameters().getOrDefault("endTime","").toString();
		String itemClassificationID=dataTable.getParameters().getOrDefault("itemClassificationID","0").toString();
		enterLibraryCode = enterLibraryCode.isEmpty() ? null : enterLibraryCode.trim();
		startTime = startTime.isEmpty() ? null : startTime.trim();
		endTime = endTime.isEmpty() ? null : endTime.trim();
		itemClassificationID = itemClassificationID.isEmpty() ? null : itemClassificationID.trim();
		PageHelper.startPage(dataTable.getStart(), dataTable.getLength(), dataTable.getSort());
		
		List<ItemEnterLibrary> list = itemEnterLibraryMapper.getEnterLibraryOrderPage(enterLibraryCode, startTime, endTime,Integer.parseInt(itemClassificationID));
		
		
		Page<ItemEnterLibrary> page = (Page<ItemEnterLibrary>) list;
		DataTableReturn<ItemEnterLibrary> dtReturn = new DataTableReturn<ItemEnterLibrary>(dataTable.getsEcho(), page.getTotal(),
				page.getTotal(), list);
		return dtReturn;
	}
	
	/**
	 * @Description:新增入库单
	 * @author 
	 * @date 2018年3月18日
	 */
	public int addItemEnterLibrary(ItemEnterLibrary itemEnterLibrary){
		if(itemEnterLibrary==null){
			return 0;
		}
		if(itemEnterLibrary.getItemCode()==null||itemEnterLibrary.getItemCode()==""){
			System.out.println("====");
			return 0;
		}
		Item item=itemMapper.getItemByItemCode(itemEnterLibrary.getItemCode());
		if(item==null){
			ItemStock itemStock=new ItemStock();
			itemStock.setItemEnterNum(itemEnterLibrary.getEnterLibraryNum());
			itemStock.setItemID(itemEnterLibrary.getItemID());
			itemStock.setWareHouseID(itemEnterLibrary.getWareHouseID());
			itemStock.setItemStockNum(itemEnterLibrary.getEnterLibraryNum());
			itemStockMapper.addItemStock(itemStock);
			
		}else{
			itemStockMapper.updateItemStockNumByItemIDIsEnterLibrary(itemEnterLibrary.getItemID(), itemEnterLibrary.getEnterLibraryNum());
		}
		
		return itemEnterLibraryMapper.addEnterLibraryOrder(itemEnterLibrary);
		
	}
	
	/**
	 * @Description:修改出库单
	 * @author 
	 * @date 2018年3月18日
	 */
	public int updateItemEnterLibraryOrder(ItemEnterLibrary itemEnterLibrary){
		if(itemEnterLibrary==null){
			return 0;
		}
		//修改出库单首先要把本出库单之前出库的商品数量修改过来（即先撤销出库，再新增出库）

		int result=itemStockMapper.revokeItemEnterLibraryOrder(itemEnterLibrary.getItemID(), itemEnterLibrary.getOldEnterLibraryNum());
		System.out.println(result);
		itemStockMapper.updateItemStockNumByItemIDIsEnterLibrary((long)itemEnterLibrary.getItemID(), itemEnterLibrary.getEnterLibraryNum());
		if(result==0){
			return 0;
		}else{
			return itemEnterLibraryMapper.updateItemEnterLibraryOrder(itemEnterLibrary);
		}
		
		
	}
	/**
	 * @Description:根据ID查询出库单
	 * @author 
	 * @date 2018年3月18日
	 */
	public ItemEnterLibrary getItemEnterLibraryOrderByEnterLibraryID(int enterLibraryID){
		if(enterLibraryID==0){
			return null;
		}
		return itemEnterLibraryMapper.getEnterLibrarOrderByEnterLibaryID(enterLibraryID);
		
	}
	/**
	 * @Description:根据ID删除出库单
	 * @author 
	 * @date 2018年3月18日
	 */
	public int deleteItemEnterLibraryOrder(List<Integer> enterLibraryID){
		if(enterLibraryID.size()==0){
			return 0;
		}
		return itemEnterLibraryMapper.deleteEnterLibraryOrder(enterLibraryID);
		
	}
	
}
