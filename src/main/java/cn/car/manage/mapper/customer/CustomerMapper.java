package cn.car.manage.mapper.customer;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.customer.Customer;

/**
 * @Description:客户数据库操作
 * @author 
 * @date 2018年3月10日
 */
@Repository
public interface CustomerMapper {

	/**
	 * 
	 * @Description: 新增客户
	 * @author
	 * @Date: 2018年3月10日
	 * @param customer
	 * @return
	 */
	public int addCustomer(Customer customer);
	
	/**
	 * 
	 * @Description: 删除客户
	 * @author
	 * @Date: 2018年3月10日
	 * @param customerIDs
	 * @return
	 */
	public int deleteCustomer(List<Integer> customerIDs);
	
	/**
	 * 
	 * @Description: 修改客户
	 * @author
	 * @Date: 2018年3月10日
	 * @param user
	 * @return
	 */
	public int updateCustomer(Customer customer);
	
	/**
	 * 
	 * @Description: 修改密码
	 * @author
	 * @Date: 2018年3月10日
	 * @param user
	 * @return
	 */
	public int updatePassWord(Customer customer);
	
	/**
	 * 
	 * @Description: 修改客户状态
	 * @author
	 * @Date: 2018年3月10日
	 * @param customerID，state
	 * @return
	 */
	public int updateState(@Param("customerID") int customerID,@Param("state") int state);
	
	/**
	 * 
	 * @Description: 查找客户
	 * @author
	 * @Date: 2018年3月10日
	 * @param userID
	 * @return
	 */
	public Customer getCustomerByCustomerID(@Param("customerID") int customerID);
	
	/**
	 * 
	 * @Description: 查客户的角色
	 * @author
	 * @Date: 2018年3月10日
	 * @param userID
	 * @return
	 */
	public List<Integer> getCustomerRoleByCustomerID(@Param("customerID") int customerID);
	
	/**
	 * 
	 * @Description: 查客户
	 * @author
	 * @Date: 2018年3月10日
	 * @param userName
	 * @return
	 */
	
	public Customer getCustomerInfoWithName(@Param("customerName")String customerName);
	
	/**
	 * 
	 * @Description: 模糊查分页
	 * @author
	 * @Date: 2018年3月10日
	 * @param customer
	 * @return
	 */
	public List<Customer> getCustomerByCustomerName(@Param("customerName") String customerName);
	
	/**
	 * 
	 * @Description: 用户数量
	 * @author
	 * @Date: 2018年3月10日
	 * @param customer
	 * @return
	 */
	public int getCustomerCount();
}
