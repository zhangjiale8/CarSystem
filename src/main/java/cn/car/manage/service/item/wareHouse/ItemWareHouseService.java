package cn.car.manage.service.item.wareHouse;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.car.manage.beans.orm.item.wareHouse.ItemExistWareHouse;
import cn.car.manage.beans.orm.item.wareHouse.WareHouse;
import cn.car.manage.mapper.item.itemWareHouse.ItemWareHouseMapper;
import cn.car.manage.util.helper.DataTable;
import cn.car.manage.util.helper.DataTableReturn;

/**
 * @Description:仓库商品业务层
 * @author 
 * @date 2018年3月10日
 */
@Service
public class ItemWareHouseService {

	@Autowired
	private ItemWareHouseMapper itemWareHouseMapper;
	/**
	 * @Description:分页
	 *  @author 
	 * @date 2018年3月10日
	 */
	public DataTableReturn<ItemExistWareHouse> getWareHouseItemByItemNameOrItemCoudOrWareHouseName(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		DataTable dataTable = new DataTable(request);
		String itemName = dataTable.getParameters().getOrDefault("itemName", "").toString();
		String itemCode = dataTable.getParameters().getOrDefault("itemCode", "").toString();
		String wareHouseID=dataTable.getParameters().getOrDefault("wareHouseID","-1").toString();
		String itemClassificationID=dataTable.getParameters().getOrDefault("itemClassificationID","0").toString();
		itemName = itemName.isEmpty() ? null : itemName.trim();
		itemCode = itemCode.isEmpty() ? null : itemCode.trim();
		
		wareHouseID = wareHouseID.isEmpty() ? null : wareHouseID.trim();
		PageHelper.startPage(dataTable.getStart(), dataTable.getLength(), dataTable.getSort());
		
		List<ItemExistWareHouse> list = itemWareHouseMapper.getWareHouseItemByItemNameOrItemCoudOrWareHouseName(itemName, itemCode, Integer.parseInt(wareHouseID),Integer.parseInt(itemClassificationID));
		
		Page<ItemExistWareHouse> page = (Page<ItemExistWareHouse>) list;
		
		DataTableReturn<ItemExistWareHouse> dtReturn = new DataTableReturn<ItemExistWareHouse>(dataTable.getsEcho(), page.getTotal(),
				page.getTotal(), list);
		
		return dtReturn;
	}
	/**
	 * @Description:查询所有仓库
	 * @author 
	 * @date 2018年3月10日
	 * @return
	 */
	public List<WareHouse> getAllWareHouse(){
		
		return itemWareHouseMapper.getAllWareHouse();
		
	}
	/**
	 * @Description:移除仓库某商品
	 * @param itemName
	 * @param itemCode
	 * @param wareHouseName
	 * @return
	 */
	public int deleteWareHouseItem(List<Integer> itemID){
		if(itemID.size()==0){
			return 0;
		}
		return itemWareHouseMapper.deleteWareHouseItem(itemID);
		
	}
	/**
	 * @Description:给商品更换仓库
	 * @param itemName
	 * @param itemCode
	 * @param wareHouseName
	 * @return
	 */
	public int updateItemWareHousePosition(int itemID,int wareHouseID){
		if(itemID==0||wareHouseID==0){
			return 0;
		}
		return itemWareHouseMapper.updateItemWareHousePosition(itemID, wareHouseID);
		
	}
	/**
	 * @Description:修改状态
	 * @param itemName
	 * @param itemCode
	 * @param wareHouseName
	 * @return
	 */
	public int updateItemStateByItemIdAndItemStateID(int itemID,int itemStateID){
		if(itemID==0||itemStateID==0){
			return 0;
		}
		return itemWareHouseMapper.updateItemStateByItemIdAndItemStateID(itemID, itemStateID);
		
	}
	/**
	 * @Description:新增仓库
	 * @param itemName
	 * @param itemCode
	 * @param wareHouseName
	 * @return
	 */
	public int addWareHouse(WareHouse wareHouse){
		if(wareHouse==null){
			return 0;
		}
		return itemWareHouseMapper.addWareHouse(wareHouse);
		
	}
	/**
	 * @Description:查询
	 * @param itemName
	 * @param itemCode
	 * @param wareHouseName
	 * @return
	 */
	public ItemExistWareHouse getItemExistWareHouseByItemID(int itemID){
		if(itemID==0){
			return null;
		}
		return itemWareHouseMapper.getItemExistWareHouseByItemID(itemID);
		
	}
}
