package cn.car.manage.mapper.item.order;

import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.order.OrderDetailed;


@Repository
public interface OrderDetailedMapper {

	public int addOrderDetailed(OrderDetailed orderDetailed);
}
