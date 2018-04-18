package cn.car.manage.beans.orm.item.attribute;

import java.util.List;

/**
 * @Description:商品属性信息变
 * @author 
 * @date 2018年3月10日
 */
public class ItemAttribute {

	//商品属性ID
	private int attributeID;
	
	//商品属性名称
	private String attributeName;
	
	//属性输入框类型ID
	private int attrInputTypeID;
	
	private List<AttributeInputType> attrInputTypeList;

	public ItemAttribute() {
		super();
	}

	public ItemAttribute(int attributeID, String attributeName, int attrInputTypeID,
			List<AttributeInputType> attrInputTypeList) {
		super();
		this.attributeID = attributeID;
		this.attributeName = attributeName;
		this.attrInputTypeID = attrInputTypeID;
		this.attrInputTypeList = attrInputTypeList;
	}

	public int getAttributeID() {
		return attributeID;
	}

	public void setAttributeID(int attributeID) {
		this.attributeID = attributeID;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public int getAttrInputTypeID() {
		return attrInputTypeID;
	}

	public void setAttrInputTypeID(int attrInputTypeID) {
		this.attrInputTypeID = attrInputTypeID;
	}

	public List<AttributeInputType> getAttrInputTypeList() {
		return attrInputTypeList;
	}

	public void setAttrInputTypeList(List<AttributeInputType> attrInputTypeList) {
		this.attrInputTypeList = attrInputTypeList;
	}

	@Override
	public String toString() {
		return "ItemAttribute [attributeID=" + attributeID + ", attributeName=" + attributeName + ", attrInputTypeID="
				+ attrInputTypeID + ", attrInputTypeList=" + attrInputTypeList + "]";
	}
	
	
}
