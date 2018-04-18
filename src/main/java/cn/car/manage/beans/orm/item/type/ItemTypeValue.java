package cn.car.manage.beans.orm.item.type;

/**
 * @Description:商品属性值信息类
 * @author
 * @date 2018年3月10日
 */
public class ItemTypeValue {

	private int itemTypeValueID;
	
	private String itemTypeValue;
	
	private int itemTypeID;

	public ItemTypeValue() {
		super();
	}

	public ItemTypeValue(int itemTypeValueID, String itemTypeValue, int itemTypeID) {
		super();
		this.itemTypeValueID = itemTypeValueID;
		this.itemTypeValue = itemTypeValue;
		this.itemTypeID = itemTypeID;
	}

	public int getItemTypeValueID() {
		return itemTypeValueID;
	}

	public void setItemTypeValueID(int itemTypeValueID) {
		this.itemTypeValueID = itemTypeValueID;
	}

	public String getItemTypeValue() {
		return itemTypeValue;
	}

	public void setItemTypeValue(String itemTypeValue) {
		this.itemTypeValue = itemTypeValue;
	}

	public int getItemTypeID() {
		return itemTypeID;
	}

	public void setItemTypeID(int itemTypeID) {
		this.itemTypeID = itemTypeID;
	}

	@Override
	public String toString() {
		return "ItemTypeValue [itemTypeValueID=" + itemTypeValueID + ", itemTypeValue=" + itemTypeValue
				+ ", itemTypeID=" + itemTypeID + "]";
	}
	
	
}
