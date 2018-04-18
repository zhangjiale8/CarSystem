package cn.car.manage.beans.orm.item.outLibrary;

import java.io.Serializable;

import cn.car.manage.beans.orm.item.Item;
import cn.car.manage.beans.orm.item.wareHouse.WareHouse;

/**
 * @Description:商品出库实体类
 * @author 
 * @date 2018年3月10日
 */
public class ItemOutLibrary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//出库id
	private int outLibraryID;
	//仓库id
	private int wareHouseID;
	//商品id
	private long itemID;
	//商品ID用于撤销出库单
	private long oldItemID;
	//出库数量
	private int outLibraryNum;
	//出库单号
	private String outLibraryCode;
	//出库时间
	private String outLibraryDate;
	//开始时间
	private String startTime;
	//结束时间
	private String endTime;
	//出库原因
	private String outLibraryReason;
	//库存数量
	private int itemStockNum;
	//创建人
	private String createPerson;
	//出库状态
	private int outLibraryState;
	//商品类
	private Item item;
	//修改出库单前的出库数量
	private int oldOutLibraryNum;
	//
	private String itemCode;
	//仓库类
	private WareHouse wareHouse;
	public int getOutLibraryID() {
		return outLibraryID;
	}
	public void setOutLibraryID(int outLibraryID) {
		this.outLibraryID = outLibraryID;
	}
	public int getWareHouseID() {
		return wareHouseID;
	}
	public void setWareHouseID(int wareHouseID) {
		this.wareHouseID = wareHouseID;
	}
	public long getItemID() {
		return itemID;
	}
	public void setItemID(long itemID) {
		this.itemID = itemID;
	}
	
	public long getOldItemID() {
		return oldItemID;
	}
	public void setOldItemID(long oldItemID) {
		this.oldItemID = oldItemID;
	}
	public int getOutLibraryNum() {
		return outLibraryNum;
	}
	public void setOutLibraryNum(int outLibraryNum) {
		this.outLibraryNum = outLibraryNum;
	}
	public String getOutLibraryCode() {
		return outLibraryCode;
	}
	public void setOutLibraryCode(String outLibraryCode) {
		this.outLibraryCode = outLibraryCode;
	}
	public String getOutLibraryDate() {
		return outLibraryDate;
	}
	public void setOutLibraryDate(String outLibraryDate) {
		this.outLibraryDate = outLibraryDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getOutLibraryReason() {
		return outLibraryReason;
	}
	public void setOutLibraryReason(String outLibraryReason) {
		this.outLibraryReason = outLibraryReason;
	}
	public int getItemStockNum() {
		return itemStockNum;
	}
	public void setItemStockNum(int itemStockNum) {
		this.itemStockNum = itemStockNum;
	}
	public String getCreatePerson() {
		return createPerson;
	}
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}
	public Item getItem() {
		return item;
	}
	
	public int getOutLibraryState() {
		return outLibraryState;
	}
	public void setOutLibraryState(int outLibraryState) {
		this.outLibraryState = outLibraryState;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	public int getOldOutLibraryNum() {
		return oldOutLibraryNum;
	}
	public void setOldOutLibraryNum(int oldOutLibraryNum) {
		this.oldOutLibraryNum = oldOutLibraryNum;
	}
	@Override
	public String toString() {
		return "ItemOutLibrary [outLibraryID=" + outLibraryID + ", wareHouseID=" + wareHouseID + ", itemID=" + itemID
				+ ", oldItemID=" + oldItemID + ", outLibraryNum=" + outLibraryNum + ", outLibraryCode=" + outLibraryCode
				+ ", outLibraryDate=" + outLibraryDate + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", outLibraryReason=" + outLibraryReason + ", itemStockNum=" + itemStockNum + ", createPerson="
				+ createPerson + ", outLibraryState=" + outLibraryState + ", item=" + item + ", oldOutLibraryNum="
				+ oldOutLibraryNum + ", itemCode=" + itemCode + ", wareHouse=" + wareHouse + "]";
	}
	

}
