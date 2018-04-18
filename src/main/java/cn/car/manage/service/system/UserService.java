package cn.car.manage.service.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.car.manage.beans.orm.system.User;
import cn.car.manage.beans.orm.system.UserRole;
import cn.car.manage.exception.EVMException;
import cn.car.manage.mapper.system.UserMapper;
import cn.car.manage.mapper.system.UserRoleMapper;
import cn.car.manage.util.helper.DataTable;
import cn.car.manage.util.helper.DataTableReturn;


/**
 * @Description:用户业务层
 * @author 
 * @date 2018年3月10日
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	/**
	 * @Description:分页查询
	 * @author
	 * @date 2018年3月10日
	 * 
	 */
	public DataTableReturn<UserRole> getUserByUserName(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		DataTable dataTable = new DataTable(request);
		String userName = dataTable.getParameters().getOrDefault("userName", "").toString();
		userName = userName.isEmpty() ? null : userName.trim();
		PageHelper.startPage(dataTable.getStart(), dataTable.getLength(), dataTable.getSort());
		List<UserRole> list = userRoleMapper.getUserByUserName(userName);
		Page<UserRole> page = (Page<UserRole>) list;
		DataTableReturn<UserRole> dtReturn = new DataTableReturn<UserRole>(dataTable.getsEcho(), page.getTotal(),
				page.getTotal(), list);
		return dtReturn;
	}
	
	/**
	 * @Description:新增用户
	 * @author
	 * @date 2018年3月10日
	 * @param user
	 */
	public int add(HttpServletRequest request, User user){
		if (null == request || null == user) {
			return 0;
		}
		userMapper.add(user);
		UserRole userRole= new UserRole();
		userRole.setRoleID(1);
		userRole.setUserID(user.getUserID());
		int result =userRoleMapper.addUserRole(userRole);
		return result;
		
	}
	
	/**
	 * @Description:查询用户(id)
	 * @author
	 * @date 2018年3月10日
	 * @param 
	 */
	public User getByUserID(int userID){
		
		if(userID==0){
			return null;
		}
		return userMapper.getByUserID(userID);
	}
	
	/**
	 * @Description:查询用户(userName)
	 * @author
	 * @date 2018年3月10日
	 * @param 
	 */
	public User getUserInfoWithName(String userName) {
		if ("".equals(userName.trim()) || null == userName) {
			return null;
		}
		
		
		return userMapper.getUserInfoWithName(userName);
	}
	/**
	 * @Description:修改用户
	 * @author
	 * @date 2018年3月10日
	 * @param user
	 * @return
	 */
	public int update(User user){
		if(user==null){
			return 0;
		}
		int result =userMapper.update(user);
		return result;
	}
	/**
	 * @Description:修改用户状态
	 * @author
	 * @date 2018年3月10日
	 * @param user
	 * @return
	 */
	public int updateState(int userID,int state){
		if(userID==0||state==0){
			return 0;
		}
		int result =userMapper.updateState(userID,state);
		return result;
	}
	/**
	 * @Description:删除用户
	 * @author
	 * @date 2018年3月10日
	 * @param userIDs
	 * @return
	 */
	public int delete(List<Integer> userIDs){
		if (userIDs == null || userIDs.isEmpty()) {
			throw new EVMException();
		}
		int result = userMapper.delete(userIDs);
		return result;
	}
	/**
	 * @Description:查询用户角色
	 * @author
	 * @date 2018年3月10日
	 * @param 
	 */
	public List<Integer> getUserRoleByUserId(int userID) {
		if (userID == 0) {
			return null;
		}
		return userMapper.getUserRoleByUserId(userID);
	}
}
