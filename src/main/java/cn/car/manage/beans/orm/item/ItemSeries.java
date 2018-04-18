package cn.car.manage.beans.orm.item;

import cn.car.manage.beans.orm.item.brand.ItemBrand;

/**
 * @Description:产品系列
 * @author 李子辉
 * @date 2018年3月10日
 */
public class ItemSeries {

	//商品系列ID
	private int itemSeriesID;
	
	//商品品牌ID
	private int itemBrandID;
	
	//商品系列名称
	private String itemSeriesName;
	
	private ItemBrand itemBrand;

	public ItemSeries() {
		super();
	}

	
	public ItemSeries(int itemBrandID, String itemSeriesName) {
		super();
		this.itemBrandID = itemBrandID;
		this.itemSeriesName = itemSeriesName;
	}


	public int getItemSeriesID() {
		return itemSeriesID;
	}

	public void setItemSeriesID(int itemSeriesID) {
		this.itemSeriesID = itemSeriesID;
	}

	public int getItemBrandID() {
		return itemBrandID;
	}

	public void setItemBrandID(int itemBrandID) {
		this.itemBrandID = itemBrandID;
	}

	public String getItemSeriesName() {
		return itemSeriesName;
	}

	public void setItemSeriesName(String itemSeriesName) {
		this.itemSeriesName = itemSeriesName;
	}

	
	public ItemBrand getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(ItemBrand itemBrand) {
		this.itemBrand = itemBrand;
	}

	@Override
	public String toString() {
		return "ItemSeries [itemSeriesID=" + itemSeriesID + ", itemBrandID=" + itemBrandID + ", itemSeriesName="
				+ itemSeriesName + ", itemBrand=" + itemBrand + "]";
	}

	
	
	
	
}
