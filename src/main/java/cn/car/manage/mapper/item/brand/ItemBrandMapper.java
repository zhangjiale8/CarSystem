package cn.car.manage.mapper.item.brand;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.ItemSeries;
import cn.car.manage.beans.orm.item.brand.ItemBrand;

/**
 * @Description:品牌数据库操作
 * @author 
 * @date 2018年3月10日
 */
@Repository
public interface ItemBrandMapper {

	/**
	 * @Description: 根据品牌名称查询
	 * @author 
	 * @date 2018年3月10日
	 */
	public List<ItemSeries> getItemBrandByBrandName(@Param("itemBrandName")String itemBrandName);
	
	/**
	 * @Description: 新增品牌
	 * @author 
	 * @date 2018年3月10日
	 */
	public int addItemBrand(ItemBrand itemBrand);
	
	/**
	 * @Description: 修改品牌名称
	 * @author 
	 * @date 2018年3月10日
	 */
	public int updateItemBrand(ItemBrand itemBrand);
	
	/**
	 * @Description: 根据品牌ID查询
	 * @author 
	 * @date 2018年3月10日
	 */	
	public ItemSeries getItemBrandNameByBrandID(@Param("itemBrandID") int itemBrandID);
	
	/**
	 * @Description: 根据品牌ID删除
	 * @author 
	 * @date 2018年3月10日
	 */	
	public int deleteItemBrand(@Param("itemBrandIDs") List<Integer> itemBrandIDs);
	
	/**
	 * @Description:查询所有品牌
	 * @author
	 * @date 2018年3月10日
	 * 
	 */
	public List<ItemBrand> getAllBrandName();
	
	/**
	 * @Description:查询所有品牌分类(按字母)
	 * @author
	 * @date 2018年3月10日
	 * 
	 */
	public List<Map<String,Object>> getAllBrandLetter();
	
	public ItemBrand getBrandByBrandName(@Param("itemBrandName") String itemBrandName);
 }
