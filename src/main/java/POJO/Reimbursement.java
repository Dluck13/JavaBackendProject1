package POJO;

import java.math.BigDecimal;

public class Reimbursement {
	int reimbursementID = 0;
	int statusID = 0;
	int employeeID = 0;
	String employee = "";
	String status = "";
	String type = "";
	BigDecimal amount = BigDecimal.ZERO;
	String details = "";
	String currentComment = "";
	String dateOfTransaction = "";
	String date_submitted = "";
	String date_updated = "";
	
	public int getReimbursementID() {
		return reimbursementID;
	}
	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getCurrentComment() {
		return currentComment;
	}
	public void setCurrentComment(String currentComment) {
		this.currentComment = currentComment;
	}
	public String getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(String dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public String getDate_submitted() {
		return date_submitted;
	}
	public void setDate_submitted(String date_submitted) {
		this.date_submitted = date_submitted;
	}
	public String getDate_updated() {
		return date_updated;
	}
	public void setDate_updated(String date_updated) {
		this.date_updated = date_updated;
	}
	
}
