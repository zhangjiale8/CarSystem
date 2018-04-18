package cn.car.manage.beans.orm.item.state;

public class ItemAndOrderState {

	private int id;
	
	private String name;
	
	private String value;
	
	private int nameID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getNameID() {
		return nameID;
	}

	public void setNameID(int nameID) {
		this.nameID = nameID;
	}

	@Override
	public String toString() {
		return "ItemAndOrderState [id=" + id + ", name=" + name + ", value=" + value + ", nameID=" + nameID + "]";
	}
	
}
