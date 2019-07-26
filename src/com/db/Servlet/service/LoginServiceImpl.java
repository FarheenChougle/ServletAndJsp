//Service is the 2nd middle step that the servlet calls
package com.db.Servlet.service;

import com.db.ServletD.bean.LoginBean;
import com.db.ServletD.dao.LoginDAO;
import com.db.ServletD.dao.LoginDAOImpl;

public class LoginServiceImpl implements LoginService {
	LoginDAO loginDAO = new LoginDAOImpl();
	public boolean authenticate(LoginBean login) {
		// TODO Auto-generated method stub
		
		return loginDAO.authenticate(login);
	}

}
