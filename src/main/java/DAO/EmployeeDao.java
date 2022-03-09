package DAO;

import java.sql.SQLException;
import java.util.List;

import POJO.Employee;

public interface EmployeeDao {
	
	// Read - fetch all books
		List<Employee> fetchAllEmployees()throws SQLException, ClassNotFoundException;
		// Create
		Employee addEmployee(Employee employee)throws SQLException;
		// Update
		Employee updateEmployee(Employee employee)throws SQLException;
		// Delete
		Employee deleteEmployee(int employeeID)throws SQLException;
		// Read - fetch a employee
		Employee fetchAEmployee(int employeeID)throws SQLException;
		
		
		
		
		
		
		//Exit
		default void exitApplication()throws SQLException{
			DBConnection.closeConnection();
		}
		
	}
	


