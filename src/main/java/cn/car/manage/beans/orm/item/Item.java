package cn.car.manage.beans.orm.item;


import java.util.List;

import cn.car.manage.beans.orm.item.attribute.ItemAttributeValue;
import cn.car.manage.beans.orm.item.classification.ItemClassification;

/**
 * @Description:商品信息类
 * @author 
 * @date 2018年3月11
 */
public class Item {
	
	//商品ID
	private long itemID;
	
	//商品类型（汽车或零部件）ID
	private int itemClassificationID;
	
	//商品热度
	private int itemHot;//1:  2:   3:   4:
	
	private String itemName;
	
	private String itemColor;
	
	private double itemPrice;
	
	private int itemStockNum;
	
	private int itemSeriesID;
	
	private String itemCode;
	//商品上架时间
	private String itemShelfTime;

	private int wareHouseID;
	
	private String createPerson;
	
	//商品下架时间
	private String itemDownTime;
	
	private String itemModel;
	
	private String itemClassificationName;
	//商品类型表
	private ItemClassification itemClass;

	private String itemBrandName;
	
	private String itemSeriesName;

	private List<ItemAttributeValue> itemAttribute;
	public Item() {
		super();
	}

	

	public int getItemSeriesID() {
		return itemSeriesID;
	}



	public void setItemSeriesID(int itemSeriesID) {
		this.itemSeriesID = itemSeriesID;
	}



	public String getItemBrandName() {
		return itemBrandName;
	}



	public void setItemBrandName(String itemBrandName) {
		this.itemBrandName = itemBrandName;
	}



	public String getItemSeriesName() {
		return itemSeriesName;
	}



	public void setItemSeriesName(String itemSeriesName) {
		this.itemSeriesName = itemSeriesName;
	}



	public String getItemClassificationName() {
		return itemClassificationName;
	}



	public void setItemClassificationName(String itemClassificationName) {
		this.itemClassificationName = itemClassificationName;
	}



	public String getCreatePerson() {
		return createPerson;
	}



	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}



	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public int getItemClassificationID() {
		return itemClassificationID;
	}

	public void setItemClassificationID(int itemClassificationID) {
		this.itemClassificationID = itemClassificationID;
	}

	

	public String getItemShelfTime() {
		return itemShelfTime;
	}



	public void setItemShelfTime(String itemShelfTime) {
		this.itemShelfTime = itemShelfTime;
	}



	public String getItemDownTime() {
		return itemDownTime;
	}



	public void setItemDownTime(String itemDownTime) {
		this.itemDownTime = itemDownTime;
	}



	public ItemClassification getItemClass() {
		return itemClass;
	}

	public void setItemClass(ItemClassification itemClass) {
		this.itemClass = itemClass;
	}

	public int getItemHot() {
		return itemHot;
	}

	public void setItemHot(int itemHot) {
		this.itemHot = itemHot;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemColor() {
		return itemColor;
	}

	public void setItemColor(String itemColor) {
		this.itemColor = itemColor;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}



	public int getWareHouseID() {
		return wareHouseID;
	}



	public void setWareHouseID(int wareHouseID) {
		this.wareHouseID = wareHouseID;
	}



	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemModel() {
		return itemModel;
	}

	public void setItemModel(String itemModel) {
		this.itemModel = itemModel;
	}

	public int getItemStockNum() {
		return itemStockNum;
	}

	public void setItemStockNum(int itemStockNum) {
		this.itemStockNum = itemStockNum;
	}


	

	public List<ItemAttributeValue> getItemAttribute() {
		return itemAttribute;
	}



	public void setItemAttribute(List<ItemAttributeValue> itemAttribute) {
		this.itemAttribute = itemAttribute;
	}



	public Item(int itemClassificationID, int itemHot, String itemName, String itemColor, double itemPrice,
			int itemStockNum, String itemCode, int wareHouseID, String itemModel) {
		super();
		this.itemClassificationID = itemClassificationID;
		this.itemHot = itemHot;
		this.itemName = itemName;
		this.itemColor = itemColor;
		this.itemPrice = itemPrice;
		this.itemStockNum = itemStockNum;
		this.itemCode = itemCode;
		
		this.wareHouseID = wareHouseID;
		this.itemModel = itemModel;
	}



	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemClassificationID=" + itemClassificationID + ", itemHot=" + itemHot
				+ ", itemName=" + itemName + ", itemColor=" + itemColor + ", itemPrice=" + itemPrice + ", itemStockNum="
				+ itemStockNum + ", itemCode=" + itemCode + ", itemShelfTime=" + itemShelfTime + ", wareHouseID="
				+ wareHouseID + ", createPerson=" + createPerson + ", itemDownTime=" + itemDownTime + ", itemModel="
				+ itemModel + ", itemClassificationName=" + itemClassificationName + ", itemClass=" + itemClass
				+ ", itemBrandName=" + itemBrandName + ", itemSeriesName=" + itemSeriesName + ", itemAttribute="
				+ itemAttribute + "]";
	}




	
}
