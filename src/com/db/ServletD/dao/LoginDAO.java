//3rd part will connect with db
package com.db.ServletD.dao;

import com.db.ServletD.bean.LoginBean;

public interface LoginDAO {
public boolean authenticate(LoginBean login);
}
