package cn.car.manage.service.item.outLibrary;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.car.manage.beans.orm.item.outLibrary.ItemOutLibrary;
import cn.car.manage.mapper.item.outLibrary.ItemOutLibraryOrderMapper;
import cn.car.manage.mapper.item.stock.ItemStockMapper;
import cn.car.manage.util.helper.DataTable;
import cn.car.manage.util.helper.DataTableReturn;

/**
 * @Description:配件出库业务层
 * @author 
 * @date 2018年3月18日
 */
@Service
public class ItemOutLibraryOrderService {

	@Autowired
	private ItemOutLibraryOrderMapper itemOutLibraryMapper;
	@Autowired
	private ItemStockMapper itemStockMapper;
	/**
	 * @Description:分页
	 * @author 
	 * @date 2018年3月18日
	 */
	public DataTableReturn<ItemOutLibrary> getOutLibraryOrderPage(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		DataTable dataTable = new DataTable(request);
		String outLibraryCode = dataTable.getParameters().getOrDefault("outLibraryCode", "").toString();
		String startTime=dataTable.getParameters().getOrDefault("startTime","").toString();
		String endTime=dataTable.getParameters().getOrDefault("endTime","").toString();
		String itemClassificationID=dataTable.getParameters().getOrDefault("itemClassificationID","0").toString();
		outLibraryCode = outLibraryCode.isEmpty() ? null : outLibraryCode.trim();
		startTime = startTime.isEmpty() ? null : startTime.trim();
		endTime = endTime.isEmpty() ? null : endTime.trim();
		itemClassificationID = itemClassificationID.isEmpty() ? null : itemClassificationID.trim();
		PageHelper.startPage(dataTable.getStart(), dataTable.getLength(), dataTable.getSort());
		
		List<ItemOutLibrary> list = itemOutLibraryMapper.getOutLibraryOrderPage(outLibraryCode, startTime, endTime,Integer.parseInt(itemClassificationID));
		
		
		Page<ItemOutLibrary> page = (Page<ItemOutLibrary>) list;
		DataTableReturn<ItemOutLibrary> dtReturn = new DataTableReturn<ItemOutLibrary>(dataTable.getsEcho(), page.getTotal(),
				page.getTotal(), list);
		return dtReturn;
	}
	
	/**
	 * @Description:新增出库单
	 * @author 
	 * @date 2018年3月18日
	 */
	public int addItemOutLibrary(ItemOutLibrary itemOutLibrary){
		if(itemOutLibrary==null){
			return 0;
		}
		itemStockMapper.updateItemStockNumByItemIDIsOutLibrary(itemOutLibrary.getItemID(), itemOutLibrary.getOutLibraryNum());
		return itemOutLibraryMapper.addOutLibraryOrder(itemOutLibrary);
		
	}
	
	/**
	 * @Description:修改出库单
	 * @author 
	 * @date 2018年3月18日
	 */
	public int updateItemOutLibraryOrder(ItemOutLibrary itemOutLibrary){
		if(itemOutLibrary==null){
			return 0;
		}
		//修改出库单首先要把本出库单之前出库的商品数量修改过来（即先撤销出库，再新增出库）
		int result=itemStockMapper.revokeItemOutLibraryOrder(itemOutLibrary.getOldItemID(), itemOutLibrary.getOldOutLibraryNum());
		itemStockMapper.updateItemStockNumByItemIDIsOutLibrary(itemOutLibrary.getItemID(), itemOutLibrary.getOutLibraryNum());
		if(result==0){
			return 0;
		}else{
			return itemOutLibraryMapper.updateItemOutLibraryOrder(itemOutLibrary);
		}
		
		
	}
	/**
	 * @Description:根据ID查询出库单
	 * @author 
	 * @date 2018年3月18日
	 */
	public ItemOutLibrary getItemOutLibraryOrderByOutLibraryID(int outLibraryID){
		if(outLibraryID==0){
			return null;
		}
		return itemOutLibraryMapper.getOutLibrarOrderByoutLibaryID(outLibraryID);
		
	}
	/**
	 * @Description:根据ID删除出库单
	 * @author 
	 * @date 2018年3月18日
	 */
	public int deleteItemOutLibraryOrder(List<Integer> outLibraryID){
		if(outLibraryID.size()==0){
			return 0;
		}
		return itemOutLibraryMapper.deleteOutLibraryOrder(outLibraryID);
		
	}
	/**
	 * @Description:改变状态
	 * @author 
	 * @date 2018年3月18日
	 */
	public int updateOutLibraryOrderState(int outLibraryID,int outLibraryState){
		if(outLibraryID==0||outLibraryState==0){
			return 0;
		}
		return itemOutLibraryMapper.updateOutLibraryOrderState(outLibraryID, outLibraryState);
		
	}
}
