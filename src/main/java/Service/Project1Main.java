package Service;

import java.util.List;

import POJO.Employee;
import POJO.Reimbursement;
import io.javalin.Javalin;


public class Project1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Javalin myServer = Javalin.create((config) -> config.enableCorsForAllOrigins()).start(4040);
		System.out.println("port 4040");
		myServer.get("/hi", ctx -> ctx.result("Hello"));
		
		
		myServer.get("/RequestsPending", (ctx)-> {
			ctx.json(FinanceManagerService.getPendingReimbursements());	
		});
		
		myServer.get("/RequestsResolved", (ctx)-> {
			ctx.json(FinanceManagerService.getCompletedReimbursements());	
			
		});
		myServer.get("/RequestsAll", (ctx)-> {
			ctx.json(FinanceManagerService.getAllReimbursements());	
			
		});
		myServer.get("/RequestsEmployee/{bid}", (ctx)-> {
			String employeeID = ctx.pathParam("bid");
			ctx.json(FinanceManagerService.getEmployeeReimbursements(Integer.parseInt(employeeID)));
			
		});
		
		myServer.get("/AllEmployees", (ctx)-> {
			ctx.json(FinanceManagerService.getAllEmployees());
			
		});
		
		// what is the practical difference between post/put my post both inserts and updates a table.
		myServer.post("/UpdateRequest", (ctx)->{
			Reimbursement rUpdate = ctx.bodyAsClass(Reimbursement.class);
			ctx.json(FinanceManagerService.updateReimbursement(rUpdate));
		});
		
		myServer.get("/Login", (ctx)->{
			Employee e = ctx.bodyAsClass(Employee.class);
			ctx.json(LoginService.login(e));
		});
		
		
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		
		// all employees
		myServer.get("/employeess", (ctx)->{
			List<Employee> allEmployees = employeeService.fetchAllEmployees();
			ctx.json(allEmployees);
		});
		
		//fetch employee
		myServer.get("/employeess/{employee_id}", (ctx)->{
			//retrieve the path param value,specify path param key
			String empId = ctx.pathParam("empid");
			//tell service layer to fetch book
			Employee fetchedEmployee = employeeService.fetchAEmployee(Integer.parseInt(empId));
			//return book
			ctx.json(fetchedEmployee);
		});
		//delete an employee
		myServer.delete("/employeess/{employee_id}", (ctx)->{
			//retrieve the path param value,specify path param key
			String empId = ctx.pathParam("empid");
			//tell service layer to delete
			Employee deletedEmp = employeeService.deleteEmployee(Integer.parseInt(empId));
			//return book
			ctx.json(deletedEmp);});
		
		//add a employee
		myServer.post("/employeess", (ctx)->{
			//converts json to pojo
		Employee newEmp = ctx.bodyAsClass(Employee.class);
		Employee returnedEmp = employeeService.addEmployee(newEmp);
		ctx.json(returnedEmp);
		});
		
		//update a 
		
		myServer.put("/emps", (ctx)->{
			
		Employee newUpdate = ctx.bodyAsClass(Employee.class);
		Employee returnedUpdate = employeeService.updateEmployee(newUpdate);
		ctx.json(returnedUpdate);
		});
		
		
		
	}

}
