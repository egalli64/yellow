package com.example.yellow.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SignIn
 */
@WebServlet("/signIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			String firstname = request.getParameter("firstname");
			if (firstname == null || firstname.isBlank()) {
				firstname = "Unknow";
			}
			String lastname = request.getParameter("lastname");
			if (lastname == null || lastname.isBlank()) {
				lastname = "Unknow";
			}
			String email = request.getParameter("email");
			if (email == null || email.isBlank()) {
				email = "Unknow";
			}
			String password = request.getParameter("password");
			if (password == null || password.isBlank()) {
				password = "Unknow";
			}
			String username = request.getParameter("username");
			if (username == null || username.isBlank()) {
				username = "Unknow";
			}
			
	}

}
