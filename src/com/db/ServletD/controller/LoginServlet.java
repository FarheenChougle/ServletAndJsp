// Contoller are servlets that communicate with user (1)
package com.db.ServletD.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.Servlet.service.LoginService;
import com.db.Servlet.service.LoginServiceImpl;
import com.db.ServletD.bean.LoginBean;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(userName);
		System.out.println(password);
		RequestDispatcher dispatcher = null;
		LoginService loginService = new LoginServiceImpl();
		LoginBean login = new LoginBean(userName, password);
		if(loginService.authenticate(login))
		{
			//response.sendRedirect("adminHome.html");
			dispatcher = request.getRequestDispatcher("adminHome.html");
			dispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect("form.html");
		}
			
	}

}
