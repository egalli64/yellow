package com.example.yellow.servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.example.yellow.dao.Book;
import com.example.yellow.dao.BookDao;

@WebServlet("/insert/book")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/yellow")
	private DataSource ds;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String genre = request.getParameter("genre");

		try (BookDao dao = new BookDao(ds)) {
			List<Book> books = dao.searchByTitle(title);
			request.setAttribute("books", books);
			request.getRequestDispatcher("/books.jsp").forward(request, response);

		}
	}
}
