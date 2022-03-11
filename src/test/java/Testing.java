import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.*;
import org.mockito.mock.*;
import org.mockito.stubbing.OngoingStubbing;

import DAO.LoginDao;
import POJO.Role;

import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.*;


@ExtendWith(MockitoExtension.class)
public class Testing {

	// only tests 1 method, others require input or interaction with the DB
	

	
	@Test
	public void TestLoginReturn()
	{
		try(MockedStatic<LoginDao> MockLogin = Mockito.mockStatic(LoginDao.class))
		{
			Role testRole = new Role();
			testRole.setRoleID(1);
			testRole.setRole("reimbursment approval");
			ArrayList<Role> testRoles = new ArrayList<Role>();
			testRoles.add(testRole);
			
			MockLogin.when(()-> {LoginDao.getRoles(4);}).thenReturn(testRoles);
			try {
				assertEquals(testRoles,LoginDao.getRoles(4));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
