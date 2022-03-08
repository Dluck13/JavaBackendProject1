package POJO;

import java.math.BigDecimal;

public class Reimbursement {
	int reimbursementID = 0;
	int statusID = 0;
	int employeeID = 0;
	String employee = "";
	String status = "";
	String expenseType = "";
	String merchant = "";

	BigDecimal amount = BigDecimal.ZERO;
	String details = "";
	String currentComment = "";
	String dateOfTransaction = "";
	String dateSubmitted = "";
	String dateUpdated = "";
	
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
	public String getExpenseType () {
		return expenseType;
	}
	public void setExpenseType (String type) {
		this.expenseType = type;
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
	public String getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(String date_submitted) {
		this.dateSubmitted = date_submitted;
	}
	public String getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(String date_updated) {
		this.dateUpdated = date_updated;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	
}
