package cn.car.manage.mapper.item.photo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.photo.ItemPhoto;

/**
 * @Description:图片数据层
 * @author 
 * @date 2018年3月20日
 */
@Repository
public interface ItemPhotoMapper {

	public int addItemPhoto(ItemPhoto itemPhoto);
	
	public List<Map<String,Object>>	getItemPhotoByItemID(@Param("itemID") int itemID);	
	
}
