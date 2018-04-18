package cn.car.manage.mapper.item.series;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.ItemSeries;

@Repository
public interface ItemBrandSeriesMapper {

	public List<ItemSeries> getAllItemSeries();
	
	public List<ItemSeries> getItemSeriesByItemBrandID(@Param("itemBrandID") int itemBrandID);
	
	public int addItemBrandSeries(ItemSeries itemSeries);
	
	public ItemSeries getItemSeriesBySeriesName(@Param("itemSeriesName") String itemSeriesName);
}
