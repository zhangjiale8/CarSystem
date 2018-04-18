package cn.car.manage.beans.orm.item.attribute;

/**
 * @Description:属性输入框类型信息类
 * @author 
 * @date 2018年3月10日
 */
public class AttributeInputType {

	//属性输入框ID
	private int attrInputTypeID;
	
	//属性输入框名称
	private String attrInputTypeName;
	
	//属性输入框展示名称
	private String attrInputTypeShowName;

	public AttributeInputType() {
		super();
	}

	public AttributeInputType(int attrInputTypeID, String attrInputTypeName, String attrInputTypeShowName) {
		super();
		this.attrInputTypeID = attrInputTypeID;
		this.attrInputTypeName = attrInputTypeName;
		this.attrInputTypeShowName = attrInputTypeShowName;
	}

	public int getAttrInputTypeID() {
		return attrInputTypeID;
	}

	public void setAttrInputTypeID(int attrInputTypeID) {
		this.attrInputTypeID = attrInputTypeID;
	}

	public String getAttrInputTypeName() {
		return attrInputTypeName;
	}

	public void setAttrInputTypeName(String attrInputTypeName) {
		this.attrInputTypeName = attrInputTypeName;
	}

	public String getAttrInputTypeShowName() {
		return attrInputTypeShowName;
	}

	public void setAttrInputTypeShowName(String attrInputTypeShowName) {
		this.attrInputTypeShowName = attrInputTypeShowName;
	}

	@Override
	public String toString() {
		return "AttributeInputType [attrInputTypeID=" + attrInputTypeID + ", attrInputTypeName=" + attrInputTypeName
				+ ", attrInputTypeShowName=" + attrInputTypeShowName + "]";
	}
	
	
}
