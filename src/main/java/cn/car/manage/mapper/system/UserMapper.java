package cn.car.manage.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.system.User;

/**
 * @Description:用户数据库操作
 * @author 
 * @date 2018年3月10日
 */
@Repository
public interface UserMapper {

	/**
	 * 
	 * @Description: 新增用户
	 * @author
	 * @Date: 2018年3月10日
	 * @param user
	 * @return
	 */
	public int add(User user);
	
	/**
	 * 
	 * @Description: 删除用户
	 * @author
	 * @Date: 2018年3月10日
	 * @param userIDs
	 * @return
	 */
	public int delete(List<Integer> userIDs);
	
	/**
	 * 
	 * @Description: 修改用户
	 * @author
	 * @Date: 2018年3月10日
	 * @param user
	 * @return
	 */
	public int update(User user);
	
	/**
	 * 
	 * @Description: 修改用户状态
	 * @author
	 * @Date: 2018年3月10日
	 * @param user
	 * @return
	 */
	public int updateState(@Param("userID") int userID,@Param("state") int state);
	
	
	/**
	 * 
	 * @Description: 查找用户
	 * @author
	 * @Date: 2018年3月10日
	 * @param userID
	 * @return
	 */
	public User getByUserID(@Param("userID") int userID);
	
	/**
	 * 
	 * @Description: 查用户的角色
	 * @author
	 * @Date: 2018年3月10日
	 * @param userID
	 * @return
	 */
	public List<Integer> getUserRoleByUserId(@Param("userID") int userID);
	
	/**
	 * 
	 * @Description: 查用户
	 * @author
	 * @Date: 2018年3月10日
	 * @param userName
	 * @return
	 */
	
	public User getUserInfoWithName(@Param("userName")String userName);
	
	
}
