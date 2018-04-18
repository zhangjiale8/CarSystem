package cn.car.manage.beans.orm.system;

/**
 * 
 * @Description:   角色
 * @User: l_c
 * @Date: 2016年12月6日
 */
public class Role {
	private int roleId;
	private String roleName;
	private String roleIdentity;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleIdentity() {
		return roleIdentity;
	}
	public void setRoleIdentity(String roleIdentity) {
		this.roleIdentity = roleIdentity;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleIdentity=" + roleIdentity + "]";
	}

	
}
