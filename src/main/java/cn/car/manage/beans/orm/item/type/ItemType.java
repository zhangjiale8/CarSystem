package cn.car.manage.beans.orm.item.type;

public class ItemType {

	private int itemTypeID;
	
	private String itemTypeName;
	
	private int itemClassificationID;

	public ItemType() {
		super();
	}

	public ItemType(int itemTypeID, String itemTypeName, int itemClassificationID) {
		super();
		this.itemTypeID = itemTypeID;
		this.itemTypeName = itemTypeName;
		this.itemClassificationID = itemClassificationID;
	}

	public int getItemTypeID() {
		return itemTypeID;
	}

	public void setItemTypeID(int itemTypeID) {
		this.itemTypeID = itemTypeID;
	}

	public String getItemTypeName() {
		return itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}

	public int getItemClassificationID() {
		return itemClassificationID;
	}

	public void setItemClassificationID(int itemClassificationID) {
		this.itemClassificationID = itemClassificationID;
	}

	@Override
	public String toString() {
		return "ItemType [itemTypeID=" + itemTypeID + ", itemTypeName=" + itemTypeName + ", itemClassificationID="
				+ itemClassificationID + "]";
	}
	
	
}
