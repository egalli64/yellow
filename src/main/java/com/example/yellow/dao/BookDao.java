package com.example.yellow.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookDao implements AutoCloseable {
	private static final Logger log = LogManager.getLogger(BookDao.class);
	private static final String GET_ALL = "SELECT book_id, title, author, genre FROM book";
	private static final String INSERT = "insert into book(title, author, genre) values (?, ?, ?)";
	
	// da controllare
	private static final String GET_BY_TITLE = """
			SELECT book_id, title, author, genre
			FROM book
			where title = ? """;
	
	private static final String GET_BY_AUTHOR = """
			SELECT book_id, title, author, genre
			FROM book
			where author = ? """;
	
	private static final String GET_BY_AUTHOR_TITLE = """
			SELECT book_id, title, author, genre
			FROM book
			where author = ? AND title = ?""";
	
	private static final String GET_BY_GENRE = """
			SELECT book_id, title, author, genre
			FROM book
			where genre = ? """;
	
	private Connection conn;

	public BookDao(DataSource ds) {
		log.trace("called");

		try {
			this.conn = ds.getConnection();
		} catch (SQLException se) {
			throw new IllegalStateException("Database issue " + se.getMessage());
		}
	}

	public List<Book> getAll() {
		log.trace("called");
		List<Book> results = new ArrayList<>();

		try (Statement stmt = conn.createStatement(); //
				ResultSet rs = stmt.executeQuery(GET_ALL)) {
			while (rs.next()) {
				Book cur = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				results.add(cur);
			}
		} catch (SQLException se) {
			log.error("Can't get books: " + se.getMessage());
			throw new IllegalStateException("Database issue " + se.getMessage());
		}

		return results;
	}
	
	

	public boolean insert(Book book) {
		try (PreparedStatement ps = conn.prepareStatement(INSERT)) {
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getGenre());
			if (ps.executeUpdate() == 1) {
				return true;
			} 
			else {
				return false;
			}
		} catch (SQLException se) {
			log.error("Can't save book " + book.getTitle(), se);
			return false;
		}
	}
	
	public Optional<Book> getAuthor(String author) {
		log.trace("called");

		try (PreparedStatement stmt = conn.prepareStatement(GET_BY_AUTHOR)) {
			stmt.setString(1, author);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					Book cur = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					return Optional.of(cur);
				} else {
					return Optional.empty();
				}
			}
		} catch (SQLException se) {
			log.error("Can't get books: " + se.getMessage());
			throw new IllegalStateException("Database issue " + se.getMessage());
		}
	}

	public Optional<Book> getTitle(String title) {
		log.trace("called");

		try (PreparedStatement stmt = conn.prepareStatement(GET_BY_TITLE)) {
			stmt.setString(1, title);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					Book cur = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					return Optional.of(cur);
				} else {
					return Optional.empty();
				}
			}
		} catch (SQLException se) {
			log.error("Can't get books: " + se.getMessage());
			throw new IllegalStateException("Database issue " + se.getMessage());
		}
	}
	
	public Optional<Book> get(String author, String title) {
		log.trace("called");

		try (PreparedStatement stmt = conn.prepareStatement(GET_BY_AUTHOR_TITLE)) {
			stmt.setString(1, author);
			stmt.setString(2, title);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					Book cur = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					return Optional.of(cur);
				} else {
					return Optional.empty();
				}
			}
		} catch (SQLException se) {
			log.error("Can't get books: " + se.getMessage());
			throw new IllegalStateException("Database issue " + se.getMessage());
		}
	}
	
	public Optional<Book> getGenre(String genre) {
		log.trace("called");

		try (PreparedStatement stmt = conn.prepareStatement(GET_BY_GENRE)) {
			stmt.setString(1, genre);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					Book cur = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					return Optional.of(cur);
				} else {
					return Optional.empty();
				}
			}
		} catch (SQLException se) {
			log.error("Can't get genre: " + se.getMessage());
			throw new IllegalStateException("Database issue " + se.getMessage());
		}
	}

	@Override
	public void close() throws IOException {
		try {
			conn.close();
		} catch (SQLException se) {
			throw new IllegalStateException("Database issue " + se.getMessage());
		}
	}
}
