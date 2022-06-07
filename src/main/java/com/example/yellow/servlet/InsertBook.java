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

import com.example.yellow.dao.Book;
import com.example.yellow.dao.BookDao;

@WebServlet("/insert/book")
public class InsertBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/yellow")
	private DataSource ds;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String genre = request.getParameter("genre");

		Book book = new Book(title,author,genre);
		try (BookDao dao = new BookDao(ds)) {
			Boolean flag = dao.insert(book);
			if (flag == false) {
				request.getRequestDispatcher("signIn.jsp").forward(request, response);
				return;
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("book", dao.insert(book));
				request.getRequestDispatcher("myprofile.jsp").forward(request, response);
				return;
			}
		}
	}
}
		


