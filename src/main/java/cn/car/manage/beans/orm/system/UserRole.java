package cn.car.manage.beans.orm.system;
/**
 * @Description:用户角色信息
 * @author 
 * @date 2018年3月10日
 */
public class UserRole {

	private Integer userID;
	
	private Integer roleID;
	
	private String userName;
	
	private String userShowName;
	
	private String userPhone;
	
	private int userJoinDate;
	
	private String roleName;
	
	private Integer state;
	
	private User user;
	
	private Role role;

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserShowName() {
		return userShowName;
	}

	public void setUserShowName(String userShowName) {
		this.userShowName = userShowName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getUserJoinDate() {
		return userJoinDate;
	}

	public void setUserJoinDate(int userJoinDate) {
		this.userJoinDate = userJoinDate;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}



	@Override
	public String toString() {
		return "UserRole [userID=" + userID + ", roleID=" + roleID + ", userName=" + userName + ", userShowName="
				+ userShowName + ", userPhone=" + userPhone + ", userJoinDate=" + userJoinDate + ", roleName="
				+ roleName + ", state=" + state + ", user=" + user + ", role=" + role + "]";
	}

	

	
	
	
}
