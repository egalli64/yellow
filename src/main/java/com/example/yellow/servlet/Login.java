package com.example.yellow.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.example.yellow.dao.User;
import com.example.yellow.dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/yellow")
	private DataSource ds;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try (UserDao dao = new UserDao(ds)) {
			Optional<User> opt = dao.get(username, password);
			if (opt.isEmpty()) {
				request.getRequestDispatcher("signIn.jsp").forward(request, response);
				return;
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user", opt.get());
				request.getRequestDispatcher("home.jsp").forward(request, response);
				return;
			}
		}

	}

}
