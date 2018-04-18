package cn.car.manage.beans.orm.item.classification;

/**
 * @Description:商品类型表
 * @author 
 * @date 2018年3月11日
 */
public class ItemClassification {

	//类型ID
	private int itemClassificationID;
	
	//商品类型名称
	private String itemClassificationName;

	public ItemClassification(int itemClassificationID, String itemClassificationName) {
		super();
		this.itemClassificationID = itemClassificationID;
		this.itemClassificationName = itemClassificationName;
	}

	public ItemClassification() {
		super();
	}

	public int getItemClassificationID() {
		return itemClassificationID;
	}

	public void setItemClassificationID(int itemClassificationID) {
		this.itemClassificationID = itemClassificationID;
	}

	public String getItemClassificationName() {
		return itemClassificationName;
	}

	public void setItemClassificationName(String itemClassificationName) {
		this.itemClassificationName = itemClassificationName;
	}

	@Override
	public String toString() {
		return "ItemClassification [itemClassificationID=" + itemClassificationID + ", itemClassificationName="
				+ itemClassificationName + "]";
	}
	
	
}
