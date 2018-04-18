package cn.car.manage.beans.orm.item.stock;

import cn.car.manage.beans.orm.item.Item;
import cn.car.manage.beans.orm.item.wareHouse.WareHouse;

/**
 * @Description:商品库存信息表
 * @author 李子辉
 * @date 2018年3月10日
 */
public class ItemStock {

	//库存ID
	private int itemStockID;
	
	//库存数量
	private int itemStockNum;
	
	//商品ID
	private long itemID;
	
	//仓库iD
	private int wareHouseID;
	
	//进库数量
	private int itemEnterNum;
	
	//出库数量
	private int itemOutNum;
	
	private Item item;
	
	private WareHouse wareHouse;

	public ItemStock() {
		super();
	}

	

	public int getItemStockID() {
		return itemStockID;
	}

	public void setItemStockID(int itemStockID) {
		this.itemStockID = itemStockID;
	}

	



	public int getItemStockNum() {
		return itemStockNum;
	}



	public void setItemStockNum(int itemStockNum) {
		this.itemStockNum = itemStockNum;
	}



	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public int getWareHouseID() {
		return wareHouseID;
	}

	public void setWareHouseID(int wareHouseID) {
		this.wareHouseID = wareHouseID;
	}



	public int getItemEnterNum() {
		return itemEnterNum;
	}



	public void setItemEnterNum(int itemEnterNum) {
		this.itemEnterNum = itemEnterNum;
	}



	public int getItemOutNum() {
		return itemOutNum;
	}



	public void setItemOutNum(int itemOutNum) {
		this.itemOutNum = itemOutNum;
	}



	public Item getItem() {
		return item;
	}



	public void setItem(Item item) {
		this.item = item;
	}



	public WareHouse getWareHouse() {
		return wareHouse;
	}



	public void setWareHouse(WareHouse wareHouse) {
		this.wareHouse = wareHouse;
	}



	@Override
	public String toString() {
		return "ItemStock [itemStockID=" + itemStockID + ", itemStockNum=" + itemStockNum + ", itemID=" + itemID
				+ ", wareHouseID=" + wareHouseID + ", itemEnterNum=" + itemEnterNum + ", itemOutNum=" + itemOutNum
				+ ", item=" + item + ", wareHouse=" + wareHouse + "]";
	}

	
	
}
