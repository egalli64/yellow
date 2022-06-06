package com.example.yellow.servlet;

import java.io.IOException;

import javax.annotation.Resource;
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
 * Servlet implementation class SignIn
 */
@WebServlet("/signIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/yellow")
	private DataSource ds;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String username = request.getParameter("username");

		User user = new User(firstname, lastname, email, password, username);
		try (UserDao dao = new UserDao(ds)) {
			Boolean flag = dao.insert(user);
			if (flag == false) {
				request.getRequestDispatcher("signIn.jsp").forward(request, response);
				return;
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user", dao.insert(user));
				request.getRequestDispatcher("myprofile.jsp").forward(request, response);
				return;
			}
		}
		/*
		 * String url;
		 * 
		 * if (firstname == null || firstname.isBlank() || lastname == null ||
		 * lastname.isBlank() || email == null || email.isBlank() || password == null ||
		 * password.isBlank() || username == null || username.isBlank()) { url =
		 * "index.jsp"; } else { User user = new User(firstname, lastname, email,
		 * password, username); HttpSession session = request.getSession();
		 * session.setAttribute("user", user); url = "home.jsp"; } RequestDispatcher rd
		 * = request.getRequestDispatcher(url); rd.forward(request, response);
		 */
	}

}
