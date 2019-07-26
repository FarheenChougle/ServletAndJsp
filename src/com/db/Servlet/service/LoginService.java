package com.db.Servlet.service;

import com.db.ServletD.bean.LoginBean;

public interface LoginService {
	public boolean authenticate(LoginBean login);
}
