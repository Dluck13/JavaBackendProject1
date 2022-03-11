package Service;

import java.util.List;

import DAO.DBConnection;
import POJO.Employee;
import exception.EmployeeNotFoundException;
import exception.SystemException;

public interface EmployeeService {
	// Read - fetch all books
			List<Employee> fetchAllEmployees()throws SystemException, EmployeeNotFoundException;
			// Create
			Employee addEmployee(Employee employee)throws SystemException;
			// Update
			Employee updateEmployee(Employee employee)throws SystemException;
			// Delete
			Employee deleteEmployee(int employeeID)throws SystemException;
			// Read - fetch a employee
			Employee fetchAEmployee(int employeeID)throws SystemException;
			
			
			
			
			
			
			//Exit
			default void exitApplication()throws SystemException{
				DBConnection.closeConnection();
			}

}
