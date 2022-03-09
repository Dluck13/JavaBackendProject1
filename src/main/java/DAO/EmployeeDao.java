package DAO;

import java.nio.file.FileSystemException;
import java.sql.SQLException;
import java.util.List;

import POJO.Employee;

public interface EmployeeDao {
	
	// Read - fetch all books
		List<Employee> fetchAllEmployees()throws FileSystemException;
		// Create
		Employee addEmployee(Employee employee)throws FileSystemException;
		// Update
		Employee updateEmployee(Employee employee)throws FileSystemException;
		// Delete
		Employee deleteEmployee(int employeeID)throws FileSystemException;
		// Read - fetch a employee
		Employee fetchAEmployee(int employeeID)throws FileSystemException;
		
		
		
		
		
		
		//Exit
		default void exitApplication()throws FileSystemException{
			DBConnection.closeConnection();
		}
		
	}
	


