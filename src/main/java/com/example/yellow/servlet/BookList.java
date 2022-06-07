package com.example.yellow.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.example.yellow.dao.BookDao;

@WebServlet("/book/list")
public class BookList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/yellow")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (BookDao dao = new BookDao(ds)) {
			request.setAttribute("books", dao.getAll());
			request.getRequestDispatcher("/books.jsp").forward(request, response);
		}
	}

}
