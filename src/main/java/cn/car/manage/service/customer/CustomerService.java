package cn.car.manage.service.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.car.manage.beans.orm.customer.Customer;
import cn.car.manage.beans.orm.system.UserRole;
import cn.car.manage.exception.EVMException;
import cn.car.manage.mapper.customer.CustomerMapper;
import cn.car.manage.mapper.system.UserRoleMapper;
import cn.car.manage.util.helper.DataTable;
import cn.car.manage.util.helper.DataTableReturn;


/**
 * @Description:客户业务层
 * @author 
 * @date 2018年3月10日
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	/**
	 * @Description:分页查询
	 * @author
	 * @date 2018年3月10日
	 * 
	 */
	public DataTableReturn<Customer> getCustomerByCustomerName(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		DataTable dataTable = new DataTable(request);
		String customerName = dataTable.getParameters().getOrDefault("customerName", "").toString();
		
		customerName = customerName.isEmpty() ? null : customerName.trim();
		PageHelper.startPage(dataTable.getStart(), dataTable.getLength(), dataTable.getSort());
		List<Customer> list = customerMapper.getCustomerByCustomerName(customerName);
		
		
		Page<Customer> page = (Page<Customer>) list;
		DataTableReturn<Customer> dtReturn = new DataTableReturn<Customer>(dataTable.getsEcho(), page.getTotal(),
				page.getTotal(), list);
		return dtReturn;
	}
	
	/**
	 * @Description:新增用户
	 * @author
	 * @date 2018年3月10日
	 * @param user
	 */
	public int addCustomer(HttpServletRequest request, Customer customer){
		if (null == request || null == customer) {
			return 0;
		}
		customerMapper.addCustomer(customer);
		UserRole userRole= new UserRole();
		userRole.setRoleID(2);
		userRole.setUserID(customer.getUserID());
		int result =userRoleMapper.addUserRole(userRole);
		return result;
		
	}
	
	/**
	 * @Description:查询客户(id)
	 * @author
	 * @date 2018年3月10日
	 * @param 
	 */
	public Customer getCustomerByCustomerID(int customerID){
		
		if(customerID==0){
			return null;
		}
		return customerMapper.getCustomerByCustomerID(customerID);
	}
	
	/**
	 * @Description:查询客户(userName)
	 * @author
	 * @date 2018年3月10日
	 * @param 
	 */
	public Customer getCustomerInfoWithName(String customerName) {
		if ("".equals(customerName.trim()) || null == customerName) {
			return null;
		}
		
		
		return customerMapper.getCustomerInfoWithName(customerName);
	}
	/**
	 * @Description:修改客户
	 * @author
	 * @date 2018年3月10日
	 * @param user
	 * @return
	 */
	public int updateCustomer(Customer customer){
		if(customer==null){
			return 0;
		}
		int result =customerMapper.updateCustomer(customer);
		return result;
	}
	/**
	 * @Description:修改密码
	 * @author
	 * @date 2018年3月10日
	 * @param user
	 * @return
	 */
	public int updatePassWord(Customer customer){
		if(customer==null){
			return 0;
		}
		
		int result =customerMapper.updatePassWord(customer);
		return result;
	}
	/**
	 * @Description:修改客户
	 * @author
	 * @date 2018年3月10日
	 * @param user
	 * @return
	 */
	public int updateState(int customerID,int state){
		if(customerID==0|| state==0){
			return 0;
		}
		int result =customerMapper.updateState(customerID,state);
		return result;
	}
	/**
	 * @Description:删除客户
	 * @author
	 * @date 2018年3月10日
	 * @param userIDs
	 * @return
	 */
	public int deleteCustomer(List<Integer> customerIDs){
		if (customerIDs == null || customerIDs.isEmpty()) {
			throw new EVMException();
		}
		int result = customerMapper.deleteCustomer(customerIDs);
		return result;
	}
	
}
