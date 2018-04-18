package cn.car.manage.beans.orm.item.wareHouse;

/**
 * @Description:商品与仓库的关系类
 * @author 李子辉
 *
 */
public class ItemExistWareHouse {

		//商品ID
		private long itemID;
		
		private String itemName;
		
		private String itemColor;
		
		private double itemPrice;
		
		private int itemStockNum;
		
		private String itemCode;
		
		private int wareHouseID;
		
		private String wareHouseName;
		
		private String wareHouseKeeper;
		
		private int itemState;
		
		private String itemModel;

		public long getItemID() {
			return itemID;
		}

		public void setItemID(long itemID) {
			this.itemID = itemID;
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


		public int getItemStockNum() {
			return itemStockNum;
		}

		public void setItemStockNum(int itemStockNum) {
			this.itemStockNum = itemStockNum;
		}

		public String getItemCode() {
			return itemCode;
		}

		public void setItemCode(String itemCode) {
			this.itemCode = itemCode;
		}

		public String getWareHouseName() {
			return wareHouseName;
		}

		public void setWareHouseName(String wareHouseName) {
			this.wareHouseName = wareHouseName;
		}

		public String getWareHouseKeeper() {
			return wareHouseKeeper;
		}

		public void setWareHouseKeeper(String wareHouseKeeper) {
			this.wareHouseKeeper = wareHouseKeeper;
		}

		
		public int getItemState() {
			return itemState;
		}

		public void setItemState(int itemState) {
			this.itemState = itemState;
		}

		
		public String getItemModel() {
			return itemModel;
		}

		public void setItemModel(String itemModel) {
			this.itemModel = itemModel;
		}

		
		public int getWareHouseID() {
			return wareHouseID;
		}

		public void setWareHouseID(int wareHouseID) {
			this.wareHouseID = wareHouseID;
		}

		@Override
		public String toString() {
			return "ItemExistWareHouse [itemID=" + itemID + ", itemName=" + itemName + ", itemColor=" + itemColor
					+ ", itemPrice=" + itemPrice + ", itemStockNum=" + itemStockNum + ", itemCode=" + itemCode
					+ ", wareHouseID=" + wareHouseID + ", wareHouseName=" + wareHouseName + ", wareHouseKeeper="
					+ wareHouseKeeper + ", itemState=" + itemState + ", itemModel=" + itemModel + "]";
		}

		

		

		
}
