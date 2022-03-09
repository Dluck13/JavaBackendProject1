package DAO;

import java.io.FileNotFoundException;
import java.nio.file.ClosedFileSystemException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import POJO.Employee;

public class EmployeeJdbcDao implements EmployeeDao {
	
	public static final Logger LOG = LogManager.getLogger(EmployeeJdbcDao.class);

	@Override
	public List<Employee> fetchAllEmployees() throws ClosedFileSystemException, FileNotFoundException {
		LOG.info("Entered fetchAllEmployees() in DAO");
		// create an array list to hold all the employees info fetched from the DB
		List<Employee> allEmployees = new ArrayList<Employee>();
		Connection conn = DBConnection.getConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM employees";
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the result set 
			while(rs.next()) {
				//copy each record into a employeePojo object 
				Employee employeePojo = new Employee(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getString(5), 
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9)
						);
				// add the employeePojo object to the collection
				allEmployees.add(employeePojo);
			}
		} catch (SQLException e) {
			throw new ClosedFileSystemException();
		}
		if(allEmployees.isEmpty()) {
			throw new ClosedFileSystemException();
		}
		
		LOG.info("Exited fetchAllEmployees() in DAO");
		// return the collection
		return allEmployees;
	}

	@Override
	public Employee addEmployee(Employee employee) throws ClosedFileSystemException {
		LOG.info("Entered addEmployee() in DAO");
		Connection conn = DBConnection.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO employees(first_name, last_name, email, phone, user_name, user_password) VALUES('"+employee.getFirstName()+"','"+employee.getLastName()+"','"+employee.getEmail()+"','"+employee.getPhone()+"','"+employee.getUserName()+"','"+employee.getPassword()+"') RETURNING employee_id";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				employee.setEmployeeID(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			throw new ClosedFileSystemException();
		}
		LOG.info("Exited addEmployee() in DAO");
		return employee;
			
			
	}

	@Override
	public Employee updateEmployee(Employee employee) throws ClosedFileSystemException {
		LOG.info("Entered updateEmployee() in DAO");
		Connection conn = DBConnection.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "UPDATE employees SET email='"+employee.getEmail()+"' WHERE employee_id="+employee.getEmployeeID();
			int rows = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ClosedFileSystemException();
		}
		LOG.info("Exited updateBook() in DAO");
		return employee;
	}

	@Override
	public Employee deleteEmployee(int employeeID) throws ClosedFileSystemException {
		LOG.info("Entered deleteEmployee() in DAO");
		Employee employeePojo = null;
		Connection conn = DBConnection.getConnection();
		try {
			Statement stmt = conn.createStatement();
			employeePojo = fetchAEmployee(employeeID);
			String query = "DELETE FROM employees WHERE employee_id="+employeeID;
			int rows = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ClosedFileSystemException();
		}
		LOG.info("Exited deleteEmployee() in DAO");
		return employeePojo;
	}

	@Override
	public Employee fetchAEmployee(int employeeID) throws ClosedFileSystemException {
		LOG.info("Entered fetchABook() in DAO");
		Employee employeePojo = null;
		Connection conn = DBConnection.getConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM employees WHERE employee_id="+employeeID;
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				employeePojo = new Employee(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getString(5), 
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9)
						);
			}
		} catch (SQLException e) {
			throw new ClosedFileSystemException();
		}
		LOG.info("Exited fetchAEmployee() in DAO");
		return employeePojo;
	}

}
