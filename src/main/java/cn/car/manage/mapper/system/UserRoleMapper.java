package cn.car.manage.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.car.manage.beans.orm.system.UserRole;

/**
 * @Description:角色数据层
 * @author 
 * @date 2018年3月10日
 */
public interface UserRoleMapper {

	/**
	 * @Description:根据userID查询用户角色
	 * @author 
	 * @date 2018年3月10日
	 */
	public UserRole getUserRoleByUserID(@Param("userID") int userID);
	
	/**
	 * @Description:绑定用户角色
	 * @author 
	 * @date 2018年3月10日
	 */
	public int addUserRole(UserRole userRole);
	
	/**
	 * 
	 * @Description: 模糊查分页
	 * @author
	 * @Date: 2018年3月10日
	 * @param userName
	 * @return
	 */
	public List<UserRole> getUserByUserName(@Param("userName") String userName);
	
}
