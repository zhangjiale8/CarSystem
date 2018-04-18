package cn.car.manage.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.car.manage.beans.orm.item.ItemSeries;
import cn.car.manage.mapper.item.series.ItemBrandSeriesMapper;

/**
 * @Description:商品品牌系列
 * @author 李子辉
 * @date 2018年3月10日
 */
@Service
public class ItemSeriesService {

	@Autowired
	private ItemBrandSeriesMapper itemBrandSeriesMapper;
	/**
	 * @Description:商品品牌系列所有
	 * @author 李子辉
	 * @date 2018年3月10日
	 */
	public List<ItemSeries> getAllItemSeries(){
		return itemBrandSeriesMapper.getAllItemSeries();
		
	}
	/**
	 * @Description:商品品牌系列根据品牌ID
	 * @author 李子辉
	 * @date 2018年3月10日
	 */
	public List<ItemSeries> getItemSeriesByItemBrandID(int itemBrandID){
		return itemBrandSeriesMapper.getItemSeriesByItemBrandID(itemBrandID);
		
	}
}
