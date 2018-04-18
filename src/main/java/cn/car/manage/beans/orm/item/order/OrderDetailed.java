package cn.car.manage.beans.orm.item.order;

/**
 * @Description:订单明细
 * @author 李子辉
 * @date 2018年3月10日
 */
public class OrderDetailed {

	//明细ID
	private int orderDetailed;
	
	//订单ID
	private int itemOrderID;
	
	//商品ID
	private long itemID;
	
	//商品数量
	private int itemNum;

	public OrderDetailed() {
		super();
	}

	public OrderDetailed( int itemOrderID, long itemID, int itemNum) {
		super();
		
		this.itemOrderID = itemOrderID;
		this.itemID = itemID;
		this.itemNum = itemNum;
	}

	public int getOrderDetailed() {
		return orderDetailed;
	}

	public void setOrderDetailed(int orderDetailed) {
		this.orderDetailed = orderDetailed;
	}

	public int getItemOrderID() {
		return itemOrderID;
	}

	public void setItemOrderID(int itemOrderID) {
		this.itemOrderID = itemOrderID;
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	@Override
	public String toString() {
		return "OrderDetailed [orderDetailed=" + orderDetailed + ", itemOrderID=" + itemOrderID + ", itemID=" + itemID
				+ ", itemNum=" + itemNum + "]";
	}
	
	
}
