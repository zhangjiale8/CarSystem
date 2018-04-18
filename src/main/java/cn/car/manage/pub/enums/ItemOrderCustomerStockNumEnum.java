package cn.car.manage.pub.enums;

public enum ItemOrderCustomerStockNumEnum {
	ITEMORDER("name","销售订单"),
	CUSTOMER("name","会员客户"),
	REPAIRORDER("name","维修订单"),
	STOCKNUM("name","库存数量"),
	LookCarOrder("name","预约客户"),
	HaveInHandOrder("name","客户交易中"),
	SuccessOrder("name","客户交易成功"),
	FailOrder("name","客户交易失败");
	private String name;
	private String value;
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
	private ItemOrderCustomerStockNumEnum(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	
	
}
