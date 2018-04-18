package cn.car.manage.mapper.item.state;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.state.ItemAndOrderState;

/**
 * @Description:商品各种状态数据层
 * @author 
 * @date 2018年3月10日
 */
@Repository
public interface ItemOrderStateMapper {

	public List<ItemAndOrderState> getAllStateByName(@Param("name")String name);
}
