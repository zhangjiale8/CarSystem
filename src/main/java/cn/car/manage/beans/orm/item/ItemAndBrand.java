package cn.car.manage.beans.orm.item;

import java.util.Map;

public class ItemAndBrand {

	//商品ID
		private long itemID;

		private String itemName;
		
		private String itemColor;
		
		private double itemPrice;
		private String photoResource;
		//商品系列ID
		private int itemSeriesID;
		private Map<String,Object> map;
		//商品系列名称
		private String itemSeriesName;
		
		//品牌ID
		private int itemBrandID;
		
		//品牌名称
		private String itemBrandName;

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

		public int getItemSeriesID() {
			return itemSeriesID;
		}

		public void setItemSeriesID(int itemSeriesID) {
			this.itemSeriesID = itemSeriesID;
		}

		public String getItemSeriesName() {
			return itemSeriesName;
		}

		public void setItemSeriesName(String itemSeriesName) {
			this.itemSeriesName = itemSeriesName;
		}

		public int getItemBrandID() {
			return itemBrandID;
		}

		public void setItemBrandID(int itemBrandID) {
			this.itemBrandID = itemBrandID;
		}

		public Map<String, Object> getMap() {
			return map;
		}

		public void setMap(Map<String, Object> map) {
			this.map = map;
		}

		public String getItemBrandName() {
			return itemBrandName;
		}

		public void setItemBrandName(String itemBrandName) {
			this.itemBrandName = itemBrandName;
		}

		
		public String getPhotoResource() {
			return photoResource;
		}

		public void setPhotoResource(String photoResource) {
			this.photoResource = photoResource;
		}

		@Override
		public String toString() {
			return "ItemAndBrand [itemID=" + itemID + ", itemName=" + itemName + ", itemColor=" + itemColor
					+ ", itemPrice=" + itemPrice + ", photoResource=" + photoResource + ", itemSeriesID=" + itemSeriesID
					+ ", map=" + map + ", itemSeriesName=" + itemSeriesName + ", itemBrandID=" + itemBrandID
					+ ", itemBrandName=" + itemBrandName + "]";
		}

		

}
