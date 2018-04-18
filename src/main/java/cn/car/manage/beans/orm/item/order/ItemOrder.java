package cn.car.manage.beans.orm.item.order;

import java.io.Serializable;

import cn.car.manage.beans.orm.customer.Customer;
import cn.car.manage.beans.orm.item.Item;

/**
 * @Description:商品订单
 * @author 
 * @date 2018年3月10日
 */
public class ItemOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//订单ID
	private int itemOrderID;
	
	//商品ID
	private long itemID;
	
	//客户ID
	private int customerID;
	
	private String itemOrderCode;
	
	//订单状态  1：:未付款  2：已付款  3：未发货  4：已发货  5：已完成   6：退货处理  7：订单关闭
	private String orderState;
	
	//付款方式  1:在线付款   2:货到付款
	private int payMethod;
	
	//总价
	private double totalPrice;
	
	//创建时间
	private String createDate;
	
	//付款时间
	private String payDate;
	
	//发货时间
	private String deliveryDate;
	
	//完成时间
	private String completeDate;
	
	//关闭时间
	private String closeDate;

	private String phone;
	//地址
	private String address;
	//商品数量
	private int itemNum;
	
	private Item item;
	
	private Customer customer;
	
	private String customerName;
	
	private OrderDetailed orderDetailed;
	
	private int lookCarID;

	public int getLookCarID() {
		return lookCarID;
	}

	public void setLookCarID(int lookCarID) {
		this.lookCarID = lookCarID;
	}

	public ItemOrder() {
		super();
	}

	public int getItemOrderID() {
		return itemOrderID;
	}

	public void setItemOrderID(int itemOrderID) {
		this.itemOrderID = itemOrderID;
	}

	public String getItemOrderCode() {
		return itemOrderCode;
	}

	public void setItemOrderCode(String itemOrderCode) {
		this.itemOrderCode = itemOrderCode;
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	
	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public int getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(int payMethod) {
		this.payMethod = payMethod;
	}


	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}

	public String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
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

	public OrderDetailed getOrderDetailed() {
		return orderDetailed;
	}

	
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setOrderDetailed(OrderDetailed orderDetailed) {
		this.orderDetailed = orderDetailed;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ItemOrder [itemOrderID=" + itemOrderID + ", itemID=" + itemID + ", customerID=" + customerID
				+ ", itemOrderCode=" + itemOrderCode + ", orderState=" + orderState + ", payMethod=" + payMethod
				+ ", totalPrice=" + totalPrice + ", createDate=" + createDate + ", payDate=" + payDate
				+ ", deliveryDate=" + deliveryDate + ", completeDate=" + completeDate + ", closeDate=" + closeDate
			    + ", phone=" + phone + ", address=" + address + ", itemNum=" + itemNum
				+ ", item=" + item + ", customer=" + customer + ", customerName=" + customerName + ", orderDetailed="
				+ orderDetailed + "]";
	}

	
}
