package Service;

import DAO.LoginDao;
import POJO.Employee;

public class LoginService {

	public static Employee login(Employee e) {
		// TODO Auto-generated method stub
		try {
			Employee loggedIn = LoginDao.login(e);
			
			
			return loggedIn;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return e;
		}
	}
	
}
