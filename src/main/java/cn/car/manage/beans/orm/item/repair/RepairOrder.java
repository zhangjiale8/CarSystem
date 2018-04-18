package cn.car.manage.beans.orm.item.repair;

/**
 * @Description:商品维修信息表
 * @author
 * @date 2018年3月10日
 */
public class RepairOrder {

	//维修ID
	private int repairOrderID;
	
	//商品型号
	private String itemModelNum;
	
	//客户名称
	private String customerName;
	
	//维修类型
	private String repairOrderType;
	
	//维修日期
	private String repairOrderDate;
	
	//商品编码（唯一）
	private String carCode;
	
	//维修位置
	private String repairPosition;
	
	//维修费用
	private double repairCost;
	
	//维修状态
	private int repairOrderState;
	
	private String phone;
	
	private String repairStateName;
	
	private String repairOrderCode;

	public int getRepairOrderID() {
		return repairOrderID;
	}

	public void setRepairOrderID(int repairOrderID) {
		this.repairOrderID = repairOrderID;
	}

	public String getItemModelNum() {
		return itemModelNum;
	}

	public void setItemModelNum(String itemModelNum) {
		this.itemModelNum = itemModelNum;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getRepairOrderType() {
		return repairOrderType;
	}

	public void setRepairOrderType(String repairOrderType) {
		this.repairOrderType = repairOrderType;
	}

	public String getRepairOrderDate() {
		return repairOrderDate;
	}

	public void setRepairOrderDate(String repairOrderDate) {
		this.repairOrderDate = repairOrderDate;
	}

	public String getCarCode() {
		return carCode;
	}

	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}

	public String getRepairPosition() {
		return repairPosition;
	}

	public void setRepairPosition(String repairPosition) {
		this.repairPosition = repairPosition;
	}

	public double getRepairCost() {
		return repairCost;
	}

	public void setRepairCost(double repairCost) {
		this.repairCost = repairCost;
	}

	public int getRepairOrderState() {
		return repairOrderState;
	}

	public void setRepairOrderState(int repairOrderState) {
		this.repairOrderState = repairOrderState;
	}

	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String getRepairOrderCode() {
		return repairOrderCode;
	}

	public void setRepairOrderCode(String repairOrderCode) {
		this.repairOrderCode = repairOrderCode;
	}

	
	public String getRepairStateName() {
		return repairStateName;
	}

	public void setRepairStateName(String repairStateName) {
		this.repairStateName = repairStateName;
	}

	@Override
	public String toString() {
		return "RepairOrder [repairOrderID=" + repairOrderID + ", itemModelNum=" + itemModelNum + ", customerName="
				+ customerName + ", repairOrderType=" + repairOrderType + ", repairOrderDate=" + repairOrderDate
				+ ", carCode=" + carCode + ", repairPosition=" + repairPosition + ", repairCost=" + repairCost
				+ ", repairOrderState=" + repairOrderState + ", phone=" + phone + ", repairStateName=" + repairStateName
				+ ", repairOrderCode=" + repairOrderCode + "]";
	}

	

	
	
}
