package cn.car.manage.beans.orm.item.attribute;

/**
 * @Description:商品属性值信息类
 * @author
 * @date 2018年3月10日
 */
public class ItemAttributeValue {

	//商品属性值ID
	private int AttributeValueID;
	
	//属性ID
	private int attributeID;
	
	//商品ID
	private int itemID;
	
	//商品属性值
	private String attributeValue;
	
	private int attributeTypeID;

	

	public int getAttributeValueID() {
		return AttributeValueID;
	}

	public void setAttributeValueID(int attributeValueID) {
		AttributeValueID = attributeValueID;
	}

	public int getAttributeID() {
		return attributeID;
	}

	public void setAttributeID(int attributeID) {
		this.attributeID = attributeID;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	
	public int getAttributeTypeID() {
		return attributeTypeID;
	}

	public void setAttributeTypeID(int attributeTypeID) {
		this.attributeTypeID = attributeTypeID;
	}

	@Override
	public String toString() {
		return "ItemAttributeValue [AttributeValueID=" + AttributeValueID + ", attributeID=" + attributeID + ", itemID="
				+ itemID + ", attributeValue=" + attributeValue + ", attributeTypeID=" + attributeTypeID + "]";
	}

	
	
	
}
