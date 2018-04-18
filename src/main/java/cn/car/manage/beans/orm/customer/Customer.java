package cn.car.manage.beans.orm.customer;

import cn.car.manage.beans.orm.customer.address.CustomerAddress;
import cn.car.manage.beans.orm.system.UserRole;

/**
 * @Description:管理员信息
 * @author 
 * @date 2018年3月10日
 */
public class Customer {

	//id
	private Integer userID;
	
	//管理员名称
	private String userName;
	
	private String userShowName;
	//密码
	private String userPassWord;
	
	//手机
	private String userPhone;
	
	//加入时间
	private String userJoinDate;
	
	private int state;
	
	
	private UserRole userRole;
	
	private CustomerAddress address;
	

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassWord() {
		return userPassWord;
	}

	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserJoinDate() {
		return userJoinDate;
	}

	public void setUserJoinDate(String userJoinDate) {
		this.userJoinDate = userJoinDate;
	}

	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	

	public String getUserShowName() {
		return userShowName;
	}

	public void setUserShowName(String userShowName) {
		this.userShowName = userShowName;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	
	public CustomerAddress getAddress() {
		return address;
	}

	public void setAddress(CustomerAddress address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [userID=" + userID + ", userName=" + userName + ", userShowName=" + userShowName
				+ ", userPassWord=" + userPassWord + ", userPhone=" + userPhone + ", userJoinDate=" + userJoinDate
				+ ", state=" + state + ", userRole=" + userRole + ", address=" + address + "]";
	}

	

	

	

	
	

	
	
}
