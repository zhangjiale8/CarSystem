package cn.car.manage.beans.orm.item.attribute;
/**
 * @Description:商品属性类型
 * @author 李子辉
 * @date 2018年3月10日
 */
public class AttributeType {

	//属性类型ID
	private int attributeTypeID;
	
	//属性类型名称
	private String attributeTypeName;
	
	//属性类型展示名称
	private String attributeTypeShowName;

	public int getAttributeTypeID() {
		return attributeTypeID;
	}

	public void setAttributeTypeID(int attributeTypeID) {
		this.attributeTypeID = attributeTypeID;
	}

	public String getAttributeTypeName() {
		return attributeTypeName;
	}

	public void setAttributeTypeName(String attributeTypeName) {
		this.attributeTypeName = attributeTypeName;
	}

	public String getAttributeTypeShowName() {
		return attributeTypeShowName;
	}

	public void setAttributeTypeShowName(String attributeTypeShowName) {
		this.attributeTypeShowName = attributeTypeShowName;
	}

	@Override
	public String toString() {
		return "AttributeType [attributeTypeID=" + attributeTypeID + ", attributeTypeName=" + attributeTypeName
				+ ", attributeTypeShowName=" + attributeTypeShowName + "]";
	}
	
	
}
