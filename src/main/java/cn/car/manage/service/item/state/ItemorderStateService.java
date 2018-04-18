package cn.car.manage.service.item.state;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.car.manage.beans.orm.item.state.ItemAndOrderState;
import cn.car.manage.mapper.item.state.ItemOrderStateMapper;

/**
 * @Description:商品各种状态业务层
 * @author 
 * @date 2018年3月10日
 */
@Service
public class ItemorderStateService {
	@Autowired
	private ItemOrderStateMapper itemOrderStateMapperl;
	
	public List<ItemAndOrderState> getAllStateByName(String name){
		if(name==null){
			return null;
		}
		return itemOrderStateMapperl.getAllStateByName(name);
	}
}
