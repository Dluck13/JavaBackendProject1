package POJO;

// exists do to role separation in the DB, allows users to have multiple roles, though only 1-2 used
public class Role {
	int roleID = 0;
	String role = "";
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
