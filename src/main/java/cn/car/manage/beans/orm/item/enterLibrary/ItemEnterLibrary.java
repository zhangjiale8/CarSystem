package cn.car.manage.beans.orm.item.enterLibrary;

import java.io.Serializable;

import cn.car.manage.beans.orm.item.Item;
import cn.car.manage.beans.orm.item.wareHouse.WareHouse;

/**
 * @Description:商品出库实体类
 * @author 
 * @date 2018年3月10日
 */
public class ItemEnterLibrary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//出库id
	private int enterLibraryID;
	//仓库id
	private int wareHouseID;
	//商品id
	private long itemID;
	//商品ID用于撤销出库单
	private long oldItemID;
	//出库数量
	private int enterLibraryNum;
	//出库单号
	private String enterLibraryCode;
	//出库时间
	private String enterLibraryDate;
	//开始时间
	private String startTime;
	//结束时间
	private String endTime;
	//出库原因
	private String enterLibraryReason;
	//库存数量
	private int itemStockNum;
	//创建人
	private String createPerson;
	
	//商品类
	private Item item;
	//修改出库单前的出库数量
	private int oldEnterLibraryNum;
	//
	private String itemCode;
	//仓库类
	private WareHouse wareHouse;
	public int getEnterLibraryID() {
		return enterLibraryID;
	}
	public void setEnterLibraryID(int enterLibraryID) {
		this.enterLibraryID = enterLibraryID;
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
	public int getEnterLibraryNum() {
		return enterLibraryNum;
	}
	public void setEnterLibraryNum(int enterLibraryNum) {
		this.enterLibraryNum = enterLibraryNum;
	}
	public String getEnterLibraryCode() {
		return enterLibraryCode;
	}
	public void setEnterLibraryCode(String enterLibraryCode) {
		this.enterLibraryCode = enterLibraryCode;
	}
	public String getEnterLibraryDate() {
		return enterLibraryDate;
	}
	public void setEnterLibraryDate(String enterLibraryDate) {
		this.enterLibraryDate = enterLibraryDate;
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
	public String getEnterLibraryReason() {
		return enterLibraryReason;
	}
	public void setEnterLibraryReason(String enterLibraryReason) {
		this.enterLibraryReason = enterLibraryReason;
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
	public void setItem(Item item) {
		this.item = item;
	}
	
	public int getOldEnterLibraryNum() {
		return oldEnterLibraryNum;
	}
	public void setOldEnterLibraryNum(int oldEnterLibraryNum) {
		this.oldEnterLibraryNum = oldEnterLibraryNum;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public WareHouse getWareHouse() {
		return wareHouse;
	}
	public void setWareHouse(WareHouse wareHouse) {
		this.wareHouse = wareHouse;
	}
	@Override
	public String toString() {
		return "ItemEnterLibrary [enterLibraryID=" + enterLibraryID + ", wareHouseID=" + wareHouseID + ", itemID="
				+ itemID + ", oldItemID=" + oldItemID + ", enterLibraryNum=" + enterLibraryNum + ", enterLibraryCode="
				+ enterLibraryCode + ", enterLibraryDate=" + enterLibraryDate + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", enterLibraryReason=" + enterLibraryReason + ", itemStockNum="
				+ itemStockNum + ", createPerson=" + createPerson + ", item=" + item + ", oldEnterLibraryNum="
				+ oldEnterLibraryNum + ", itemCode=" + itemCode + ", wareHouse=" + wareHouse + "]";
	}
	
}
