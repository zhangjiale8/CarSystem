package cn.car.manage.beans.orm.item;
/**
 * @Description:商品颜色
 * @author 李子辉
 * @date 2018年3月10日
 */
public class ItemColor {

	//颜色ID
	private int ItemColorID;
	
	//颜色名称
	private String itemColorName;

	public ItemColor() {
		super();
	}

	public ItemColor(int itemColorID, String itemColorName) {
		super();
		ItemColorID = itemColorID;
		this.itemColorName = itemColorName;
	}

	public int getItemColorID() {
		return ItemColorID;
	}

	public void setItemColorID(int itemColorID) {
		ItemColorID = itemColorID;
	}

	public String getItemColorName() {
		return itemColorName;
	}

	public void setItemColorName(String itemColorName) {
		this.itemColorName = itemColorName;
	}

	@Override
	public String toString() {
		return "ItemColor [ItemColorID=" + ItemColorID + ", itemColorName=" + itemColorName + "]";
	}
	
	
}
