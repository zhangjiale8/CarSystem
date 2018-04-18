package cn.car.manage.beans.orm.item.attribute;

/**
 * @Description:商品类型属性
 * @author 李子辉
 * @date 2018年3月10日
 */
public class ItemAttributeType {

	//属性类型ID
	private int itemTypeAttributeID;
	
	//商品类型ID
	private int itemClassificationID;
	
	//属性ID
	private int attributeID;
	
	//属性类型ID
	private int attributeTypeID;
	
	//下标
	private int index;
	
	private ItemAttribute itemAttribute;
	
	private AttributeType attributeType;
	
	private AttributeInputType attributeInputType;

	public int getItemTypeAttributeID() {
		return itemTypeAttributeID;
	}

	public void setItemTypeAttributeID(int itemTypeAttributeID) {
		this.itemTypeAttributeID = itemTypeAttributeID;
	}

	public int getItemClassificationID() {
		return itemClassificationID;
	}

	public void setItemClassificationID(int itemClassificationID) {
		this.itemClassificationID = itemClassificationID;
	}

	public int getAttributeID() {
		return attributeID;
	}

	public void setAttributeID(int attributeID) {
		this.attributeID = attributeID;
	}

	public int getAttributeTypeID() {
		return attributeTypeID;
	}

	public void setAttributeTypeID(int attributeTypeID) {
		this.attributeTypeID = attributeTypeID;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
	public ItemAttribute getItemAttribute() {
		return itemAttribute;
	}

	public void setItemAttribute(ItemAttribute itemAttribute) {
		this.itemAttribute = itemAttribute;
	}

	public AttributeType getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}

	public AttributeInputType getAttributeInputType() {
		return attributeInputType;
	}

	public void setAttributeInputType(AttributeInputType attributeInputType) {
		this.attributeInputType = attributeInputType;
	}

	@Override
	public String toString() {
		return "ItemAttributeType [itemTypeAttributeID=" + itemTypeAttributeID + ", itemClassificationID="
				+ itemClassificationID + ", attributeID=" + attributeID + ", attributeTypeID=" + attributeTypeID
				+ ", index=" + index + "]";
	}
	
	
	
}
