package DAO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import POJO.Employee;
import POJO.Role;

public class LoginDao {
	
	private final static Logger log = LogManager.getLogger(LoginDao.class);
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static Employee login(Employee e) throws SQLException {
		// TODO Auto-generated method stub
		
		log.info("in getAllEmployees Dao Layer");
		Employee employee = new Employee();	
	
		String query = "call employee_login(?,?,?,?,?,?,?,?,?);";
		PreparedStatement st =  DBConnection.getConnection().prepareCall(query);
		st.setString(1, e.getUserName());
		st.setString(2, e.getPassword());
		st.setString(3, "");
		st.setString(4, "");
		st.setString(5, "");
		st.setString(6, "");
		st.setString(7, "");
		st.setString(8, "");
		st.setInt(9, 0);
		ResultSet results = null;

		results = st.executeQuery();
		if(results.next())
		{
			
			employee.setFirstName(results.getString(1));
			employee.setLastName(results.getString(2));
			employee.setFullName(results.getString(3));
			employee.setJobTitle(results.getString(4));
			employee.setEmail(results.getString(5));
			employee.setPhone(results.getString(6));
			employee.setEmployeeID(results.getInt(7));
			employee.setRoles(getRoles(employee.getEmployeeID()));
		}

		return employee;
	}
	
	
	// this can be put in a shared class, but class assignment....
	public static ArrayList<Role> getRoles(int employeeID) throws SQLException
	{
		
		log.info("in getRoles Dao Layer");
		
		ResultSet results = null;
		

		ArrayList<Role> roles = new ArrayList<Role>();	
		
		// the actual main query
		String query = "select permission_id,permission_type from v_employee_permissions where employee_id= "+ employeeID+";";
		CallableStatement st =  DBConnection.getConnection().prepareCall(query);
		
		results = st.executeQuery();
		if(results != null)
		{
			while(results.next())
			{
				Role r = new Role();
				r.setRoleID(results.getInt(1));
				r.setRole(results.getString(2));
				roles.add(r);
			}
		}
		return roles;

	}
	
}
