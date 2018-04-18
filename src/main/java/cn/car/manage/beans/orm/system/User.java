package cn.car.manage.beans.orm.system;



/**
 * @Description:管理员信息
 * @author 
 * @date 2018年3月10日
 */
public class User {

	

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
	
	private Integer roleID;
	
	private int state;
	
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

	
	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	

	public String getUserShowName() {
		return userShowName;
	}

	public void setUserShowName(String userShowName) {
		this.userShowName = userShowName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", userShowName=" + userShowName
				+ ", userPassWord=" + userPassWord + ", userPhone=" + userPhone + ", userJoinDate=" + userJoinDate
				+ ", roleID=" + roleID + ", state=" + state + "]";
	}

	
}
