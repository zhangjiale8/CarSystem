package cn.car.manage.mapper.item;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description:英文字母数据层
 * @author 李子辉
 *
 */
@Repository
public interface SpelLetterMapper {

	public Integer spelLetterIdByLetterName(@Param("letterName") String letterName);
}
