package cn.car.manage.beans.orm.item.photo;

import java.util.List;

import cn.car.manage.beans.orm.item.Item;

/**
 * @Description:商品图片管理
 * @author 
 * @date 2018年3月11
 */
public class ItemPhoto {

	//图片ID
	private int photoID;
	
	//图片路径
	private String photoResource;
	
	//商品ID
	private long ItemID;
	
	//图片用途
	private int photoUse;
	
	private String resourceIdentity;
	
	//商品表
	private List<Item> itemList;

	public ItemPhoto() {
		super();
	}

	

	public int getPhotoID() {
		return photoID;
	}

	public void setPhotoID(int photoID) {
		this.photoID = photoID;
	}

	public String getPhotoResource() {
		return photoResource;
	}

	public void setPhotoResource(String photoResource) {
		this.photoResource = photoResource;
	}

	public long getItemID() {
		return ItemID;
	}

	public void setItemID(long itemID) {
		ItemID = itemID;
	}

	public int getPhotoUse() {
		return photoUse;
	}

	public void setPhotoUse(int photoUse) {
		this.photoUse = photoUse;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	
	public String getResourceIdentity() {
		return resourceIdentity;
	}

	public void setResourceIdentity(String resourceIdentity) {
		this.resourceIdentity = resourceIdentity;
	}

	@Override
	public String toString() {
		return "ItemPhoto [photoID=" + photoID + ", photoResource=" + photoResource + ", ItemID=" + ItemID
				+ ", photoUse=" + photoUse + ", resourceIdentity=" + resourceIdentity + ", itemList=" + itemList + "]";
	}

	
	
}
