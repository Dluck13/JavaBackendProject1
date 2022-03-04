package DAO;

import org.postgresql.util.*;

import DAO.DBConnection;
import POJO.Employee;
import POJO.Reimbursement;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

import org.apache.logging.log4j.*;
public class FinanceManagerDao {
	private final static Logger log = LogManager.getLogger(FinanceManagerDao.class);
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static LinkedList<Reimbursement> getPendingReimbursements() throws Exception
	{
		log.info("in getPendingReimbursements Dao Layer");
		LinkedList<Reimbursement> riems = new LinkedList<Reimbursement>();	
	
		String query = "select * from all_reimbursements where db_status_id < 4;";
		CallableStatement st =  DBConnection.getConnection().prepareCall(query);
		ResultSet results = null;

		results = st.executeQuery();
		if(results != null)
		{
			while(results.next())
			{
				Reimbursement r = new Reimbursement();
				r.setAmount(results.getBigDecimal(7));
				r.setReimbursementID(results.getInt(1));
				r.setStatus(results.getString(5));
				r.setEmployee(results.getString(4));
				r.setCurrentComment(results.getString(9));
				r.setDetails(results.getString(8));
				r.setDate_submitted(results.getString(10));
				r.setDateOfTransaction(results.getString(11));
				r.setDate_updated(results.getString(12));
				r.setType(results.getString(6));
				r.setEmployeeID(results.getInt(3));
				riems.add(r);
			}
		}

		return riems;
	
	
	}

	public static LinkedList<Reimbursement> getCompletedReimbursements() throws SQLException {
		log.info("in getPendingReinbursements Dao Layer");
		LinkedList<Reimbursement> riems = new LinkedList<Reimbursement>();	
	
		String query = "select * from all_reimbursements where db_status_id > 3;";
		CallableStatement st =  DBConnection.getConnection().prepareCall(query);
		ResultSet results = null;

		results = st.executeQuery();
		if(results != null)
		{
			while(results.next())
			{
				Reimbursement r = new Reimbursement();
				r.setAmount(results.getBigDecimal(7));
				r.setReimbursementID(results.getInt(1));
				r.setStatus(results.getString(5));
				r.setEmployee(results.getString(4));
				r.setCurrentComment(results.getString(9));
				r.setDetails(results.getString(8));
				r.setDate_submitted(results.getString(11));
				r.setDateOfTransaction(results.getString(10));
				r.setDate_updated(results.getString(12));
				r.setType(results.getString(6));
				r.setEmployeeID(results.getInt(3));
				riems.add(r);
			}
		}

		return riems;
	}

	public static LinkedList<Reimbursement> getAllReimbursements() throws SQLException {
		log.info("in getPendingReinbursements Dao Layer");
		LinkedList<Reimbursement> riems = new LinkedList<Reimbursement>();	
	
		String query = "select * from all_reimbursements;";
		CallableStatement st =  DBConnection.getConnection().prepareCall(query);
		ResultSet results = null;

		results = st.executeQuery();
		if(results != null)
		{
			while(results.next())
			{
				Reimbursement r = new Reimbursement();
				r.setAmount(results.getBigDecimal(7));
				r.setReimbursementID(results.getInt(1));
				r.setStatus(results.getString(5));
				r.setEmployee(results.getString(4));
				r.setCurrentComment(results.getString(9));
				r.setDetails(results.getString(8));
				r.setDate_submitted(results.getString(11));
				r.setDateOfTransaction(results.getString(10));
				r.setDate_updated(results.getString(12));
				r.setType(results.getString(6));
				r.setEmployeeID(results.getInt(3));
				riems.add(r);
			}
		}

		return riems;
	}

	public static LinkedList<Reimbursement> getEmployeeReimbursements(int employee) throws SQLException {
		log.info("in getPendingReinbursements Dao Layer");
		LinkedList<Reimbursement> riems = new LinkedList<Reimbursement>();	
	
		String query = "select * from all_reimbursements where db_employee_id = " + employee + ";";
		CallableStatement st =  DBConnection.getConnection().prepareCall(query);
		ResultSet results = null;

		results = st.executeQuery();
		if(results != null)
		{
			while(results.next())
			{
				Reimbursement r = new Reimbursement();
				r.setAmount(results.getBigDecimal(7));
				r.setReimbursementID(results.getInt(1));
				r.setStatus(results.getString(5));
				r.setEmployee(results.getString(4));
				r.setCurrentComment(results.getString(9));
				r.setDetails(results.getString(8));
				r.setDate_submitted(results.getString(11));
				r.setDateOfTransaction(results.getString(10));
				r.setDate_updated(results.getString(12));
				r.setType(results.getString(6));
				r.setEmployeeID(results.getInt(3));
				riems.add(r);
			}
		}

		return riems;
	}

	public static LinkedList<Employee> getAllEmployees() throws SQLException {
		log.info("in getPendingReinbursements Dao Layer");
		LinkedList<Employee> employees = new LinkedList<Employee>();	
	
		String query = "select * from v_employees;";
		CallableStatement st =  DBConnection.getConnection().prepareCall(query);
		ResultSet results = null;

		results = st.executeQuery();
		if(results != null)
		{
			while(results.next())
			{
				Employee e = new Employee();
				e.setEmployeeID(results.getInt(1));
				e.setFullName(results.getString(2));
				e.setEmail(results.getString(3));
				e.setPhone(results.getString(4));
				e.setJobTitle(results.getString(5));

				employees.add(e);
			}
		}

		return employees;
	}

/*	public static Reimbursement updateReimbursement(Reimbursement rUpdate) {
		log.info("in getPendingReinbursements Dao Layer");
		Reimbursement r = rUpdate;	
	
		String query = "select * from v_employees;";
		CallableStatement st =  DBConnection.getConnection().prepareCall(query);
		ResultSet results = null;

		results = st.executeQuery();
		if(results != null)
		{
			while(results.next())
			{
				Employee e = new Employee();
				e.setEmployeeID(results.getInt(1));
				e.setFullName(results.getString(2));
				e.setEmail(results.getString(3));
				e.setPhone(results.getString(4));
				e.setJobTitle(results.getString(5));

				employees.add(e);
			}
		}

		return employees;
	}*/
}
