package com.db.ServletD.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.ServletD.bean.LoginBean;
import com.db.ServletD.util.dbUtil;
public class LoginDAOImpl implements LoginDAO {
	public boolean authenticate(LoginBean login){
		String query = "select * from login_table where username=? and password=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = dbUtil.getConnection();
		try
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, login.getUserName());
			preparedStatement.setString(2, login.getPassword());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return true;
			}
		}
		catch(SQLException e)
		{
			e.getStackTrace();
		}
		finally{
			dbUtil.closeConnection(connection);
		}
		return false;
	}
}