package cn.car.manage.beans.orm.item.brand;



/**
 * @Description:商品品牌
 * @author 李子辉
 * @date 2018年3月10日
 */
public class ItemBrand {

	//品牌ID
	private int itemBrandID;
	
	private int itemSeriesID;
	//品牌名称
	private String itemBrandName;
	
	private String itemBrandCity;
	
	
	private String createTime;
	
	//字母ID
	private int spellID;

	private String itemSeriesName;
	
	

	public int getItemBrandID() {
	return itemBrandID;
	}

	public void setItemBrandID(int itemBrandID) {
		this.itemBrandID = itemBrandID;
	}

	
	public int getItemSeriesID() {
		return itemSeriesID;
	}

	public void setItemSeriesID(int itemSeriesID) {
		this.itemSeriesID = itemSeriesID;
	}

	public String getItemBrandName() {
		return itemBrandName;
	}

	public void setItemBrandName(String itemBrandName) {
		this.itemBrandName = itemBrandName;
	}

	public int getSpellID() {
		return spellID;
	}

	public void setSpellID(int spellID) {
		this.spellID = spellID;
	}

	
	public String getItemBrandCity() {
		return itemBrandCity;
	}

	public void setItemBrandCity(String itemBrandCity) {
		this.itemBrandCity = itemBrandCity;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	
	public String getItemSeriesName() {
		return itemSeriesName;
	}

	public void setItemSeriesName(String itemSeriesName) {
		this.itemSeriesName = itemSeriesName;
	}

	@Override
	public String toString() {
		return "ItemBrand [itemBrandID=" + itemBrandID + ", itemSeriesID=" + itemSeriesID + ", itemBrandName="
				+ itemBrandName + ", itemBrandCity=" + itemBrandCity + ", createTime=" + createTime + ", spellID="
				+ spellID + ", itemSeriesName=" + itemSeriesName + "]";
	}

	

	
	

	

	
	
	
	
}
