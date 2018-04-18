package cn.car.manage.beans.orm.item.order;

import cn.car.manage.beans.orm.customer.Customer;
import cn.car.manage.beans.orm.item.Item;

public class LookCarOrder {

	private int lookCarID;
	
	private long ItemID;
	
	private int customerID;
	
	private int state;
	
	private int itemNum;
	
	private String lookCarDate;
	
	private String phoneNum;

	private String createDate;
	
	private Item item;
	
	private Customer customer;
	
	private String stateName;
	
	private String customerName;

	public LookCarOrder() {
		super();
	}

	public int getLookCarID() {
		return lookCarID;
	}

	public void setLookCarID(int lookCarID) {
		this.lookCarID = lookCarID;
	}

	

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getItemID() {
		return ItemID;
	}

	public void setItemID(long itemID) {
		ItemID = itemID;
	}

	public String getLookCarDate() {
		return lookCarDate;
	}

	
	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	public void setLookCarDate(String lookCarDate) {
		this.lookCarDate = lookCarDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "LookCarOrder [lookCarID=" + lookCarID + ", ItemID=" + ItemID + ", customerID=" + customerID + ", state="
				+ state + ", lookCarDate=" + lookCarDate + ", phoneNum=" + phoneNum + ", createDate=" + createDate
				+ ", item=" + item + ", customer=" + customer + ", stateName=" + stateName + "]";
	}

	

	

	
	
	
}
