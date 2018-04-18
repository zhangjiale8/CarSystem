package cn.car.manage.beans.orm.customer.address;

import java.util.List;

import cn.car.manage.beans.orm.system.User;

/**
 * @Description:客户地址信息类
 * @author 
 * @date 2018年3月10
 */
public class CustomerAddress {

	//地址ID
	private int addressID;
	
	//收件人
	private String consignee;
	
	//手机号
	private String phoneNum;
	
	//邮编
	private String zipCord;
	
	//省份名称
	private String provinceName;
	
	//城市名称
	private String cityName;
	
	//街道
	private String streetName;
	
	//详细地址
	private String address;
	
	//客户ID
	private int customerID;
	
	//客户表
	private List<User> customerList;

	public CustomerAddress() {
		super();
	}

	public CustomerAddress(int addressID, String consignee, String phoneNum, String zipCord, String provinceName,
			String cityName, String streetName, String address, int customerID, List<User> customerList) {
		super();
		this.addressID = addressID;
		this.consignee = consignee;
		this.phoneNum = phoneNum;
		this.zipCord = zipCord;
		this.provinceName = provinceName;
		this.cityName = cityName;
		this.streetName = streetName;
		this.address = address;
		this.customerID = customerID;
		this.customerList = customerList;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getZipCord() {
		return zipCord;
	}

	public void setZipCord(String zipCord) {
		this.zipCord = zipCord;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public List<User> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<User> customerList) {
		this.customerList = customerList;
	}

	@Override
	public String toString() {
		return "CustomerAddress [addressID=" + addressID + ", consignee=" + consignee + ", phoneNum=" + phoneNum
				+ ", zipCord=" + zipCord + ", provinceName=" + provinceName + ", cityName=" + cityName + ", streetName="
				+ streetName + ", address=" + address + ", customerID=" + customerID + ", customerList=" + customerList
				+ "]";
	}
	
	
}
