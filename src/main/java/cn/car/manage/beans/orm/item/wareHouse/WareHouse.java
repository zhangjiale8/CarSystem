package cn.car.manage.beans.orm.item.wareHouse;
/**
 * @Description:仓库类
 * @author 李子辉
 * @date 2018年3月13日
 */
public class WareHouse {

	private int wareHouseID;
	
	private String wareHouseNum;
	
	private String wareHouseName;

	public int getWareHouseID() {
		return wareHouseID;
	}

	public void setWareHouseID(int wareHouseID) {
		this.wareHouseID = wareHouseID;
	}

	public String getWareHouseNum() {
		return wareHouseNum;
	}

	public void setWareHouseNum(String wareHouseNum) {
		this.wareHouseNum = wareHouseNum;
	}

	public String getWareHouseName() {
		return wareHouseName;
	}

	public void setWareHouseName(String wareHouseName) {
		this.wareHouseName = wareHouseName;
	}

	@Override
	public String toString() {
		return "WareHouse [wareHouseID=" + wareHouseID + ", wareHouseNum=" + wareHouseNum + ", wareHouseName="
				+ wareHouseName + "]";
	}
	
	
}
