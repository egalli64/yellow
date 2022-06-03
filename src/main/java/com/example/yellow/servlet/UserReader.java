package com.example.yellow.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.example.yellow.dao.UserDao;

/**
 * Servlet implementation class Users
 */
@WebServlet("/users")
public class UserReader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/yellow")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (UserDao dao = new UserDao(ds)) {
			request.setAttribute("users", dao.getAll());
			request.getRequestDispatcher("/test/users2.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
