package cn.car.manage.beans.orm.item.shoppingCart;

/**
 * @Description:购物车
 * @author 李子辉
 * @date 2018年3月10日
 */
public class ShoppingCart {

	//购物车ID
	private int shopCartID;
	
	//商品ID
	private long itemID;
	
	//客户ID
	private int customerID;
	
	//商品数量
	private int itemNum;
	
	//创建日期
	private int createDate;

	public ShoppingCart() {
		super();
	}

	public ShoppingCart(int shopCartID, long itemID, int customerID, int itemNum, int createDate) {
		super();
		this.shopCartID = shopCartID;
		this.itemID = itemID;
		this.customerID = customerID;
		this.itemNum = itemNum;
		this.createDate = createDate;
	}

	public int getShopCartID() {
		return shopCartID;
	}

	public void setShopCartID(int shopCartID) {
		this.shopCartID = shopCartID;
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

	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	public int getCreateDate() {
		return createDate;
	}

	public void setCreateDate(int createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "ShoppingCart [shopCartID=" + shopCartID + ", itemID=" + itemID + ", customerID=" + customerID
				+ ", itemNum=" + itemNum + ", createDate=" + createDate + "]";
	}
	
	
}
