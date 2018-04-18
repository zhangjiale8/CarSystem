package cn.car.manage.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.car.manage.beans.orm.system.UserRole;
import cn.car.manage.mapper.system.UserRoleMapper;

/**
 * @Description:用户角色业务层
 * @author 
 * @date 2018年3月10日
 */
@Service
public class UserRoleService {

	@Autowired
	private UserRoleMapper userRoleMapper;
	/**
	 * @Description 查询用户角色 根据userID
	 * @author 
	 * @date 2018年3月10日
	 */
	public UserRole getUserRoleByUserID(int userID){
		if(userID==0){
			return null;
		}
		return userRoleMapper.getUserRoleByUserID(userID);
		
	}
}
