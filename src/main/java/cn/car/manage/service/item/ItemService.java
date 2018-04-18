package cn.car.manage.service.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.car.manage.beans.orm.item.Item;
import cn.car.manage.beans.orm.item.ItemAndBrand;
import cn.car.manage.beans.orm.item.enterLibrary.ItemEnterLibrary;
import cn.car.manage.beans.orm.item.stock.ItemStock;
import cn.car.manage.mapper.item.ItemMapper;
import cn.car.manage.mapper.item.enterLibrary.ItemEnterLibraryOrderMapper;
import cn.car.manage.mapper.item.photo.ItemPhotoMapper;
import cn.car.manage.mapper.item.stock.ItemStockMapper;
import cn.car.manage.service.item.attribute.ItemAttributeValueService;

import cn.car.manage.util.helper.OutLibraryOrderCodeUtil;
import cn.car.manage.util.helper.PageBeanUtil;
import cn.car.manage.util.helper.PagedResult;


/**
 * @Description:商品业务层
 * @author 李子辉
 * @date 2018年3月11日
 */
@Service
public class ItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private ItemAttributeValueService itemAttributeValueService;
	
	@Autowired 
	private ItemStockMapper itemStockMapper;
	
	@Autowired
	private ItemEnterLibraryOrderMapper itemEnterLibraryOrderMapper;
	
	@Autowired
	private ItemPhotoMapper itemPhotoMapper;
	
	
	private final OutLibraryOrderCodeUtil idg = OutLibraryOrderCodeUtil.INSTANCE;
	/**
	 * @Description:分页
	 * @author
	 * @date 2018年3月10日
	 * @param 
	 * @return
	 */
	public PagedResult<ItemAndBrand> getItemAll(Integer pageNo,Integer pageSize,String name,int itemClassificationID) {
		
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize); //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		return PageBeanUtil.toPagedResult(itemMapper.getItemAll(name,itemClassificationID));
		
		
	}
	
	public List<ItemAndBrand> getItemOther() {
		
		
		return itemMapper.getItemOther();
		
		
	}
	
	/**
	 * @Description:修改商品
	 * @author
	 * @date 2018年3月10日
	 * @param item
	 * @return
	 */
	public int updateItem(Item item){
		return 0;
		
	}
	
	
	/**
	 * @Description:查询商品
	 * @author
	 * @date 2018年3月10日
	 * @param itemcode
	 * @return item
	 */
	public Item getItemByItemID(int  itemID){
		if(itemID==0){
			return null;
		}
		return itemMapper.getItemByItemID(itemID);
		
	}
	public ItemAndBrand selectItemInfoByItemID(int itemID){
		ItemAndBrand itemAndBrand =itemMapper.selectItemInfoByItemID(itemID);
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,Object>> photoMap=itemPhotoMapper.getItemPhotoByItemID(itemID);
		map.put("photo", photoMap);
		Map<String,Object> attrValueMap=itemAttributeValueService.getItemAttributeValueByItemID(itemID);
		
		map.put("attr", attrValueMap);
		itemAndBrand.setMap(map);
		return itemAndBrand;
		
	}
	/**
	 * @Description:查询商品所有条形码
	 * @author
	 * @date 2018年3月10日
	 * @param itemcode
	 * @return item
	 */
	public List<Item> getAllItemCode(int itemClassificationID){
		
		return itemMapper.getAllItemCode( itemClassificationID);
		
	}
	/**
	 * @Description:删除商品
	 * @author
	 * @date 2018年3月10日
	 * @param itemID
	 * @return 
	 */
	public int deleteItem(List<Integer> itemIDs){
		return 0;
		
	}
	
	/**
	 * @Description:添加商品
	 * @author
	 * @date 2018年3月10日
	 * @param itemID
	 * @return 
	 */
	public Item addItem(Item item){
		
		if (item == null) {
			return null;
		}
		
		
		Item it=itemMapper.getItemByItemCode(item.getItemCode());
		if(it==null){
			itemMapper.addItem(item);
			ItemStock itemStock=new ItemStock();
			itemStock.setItemID(item.getItemID());
			itemStock.setItemEnterNum(item.getItemStockNum());
			itemStock.setItemStockNum(item.getItemStockNum());
			itemStock.setWareHouseID(item.getWareHouseID());
			itemStockMapper.addItemStock(itemStock);
		}else{
			itemStockMapper.updateItemStockNumByItemIDIsEnterLibrary(item.getItemID(), item.getItemStockNum());
		}
		ItemEnterLibrary itemEnterLibrary=new ItemEnterLibrary();
		itemEnterLibrary.setCreatePerson(item.getCreatePerson());
		itemEnterLibrary.setEnterLibraryNum(item.getItemStockNum());
		itemEnterLibrary.setEnterLibraryCode(idg.nextId());
		itemEnterLibrary.setItemID(item.getItemID());
		itemEnterLibrary.setWareHouseID(item.getWareHouseID());
		itemEnterLibraryOrderMapper.addEnterLibraryOrder(itemEnterLibrary);
		itemAttributeValueService.addItemAttributeValue(item.getItemAttribute(), (int)item.getItemID());
		
		
		return itemMapper.getItemByItemID(item.getItemID());
		
	}
}
