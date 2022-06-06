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

public class UserDao implements AutoCloseable {
	private static final Logger log = LogManager.getLogger(UserDao.class);
	private static final String GET_ALL = "SELECT user_id, first_name, last_name, email, password, username FROM user";
	private static final String INSERT = "insert into user(first_name, last_name, email, password, username) values (?, ?, ?, ?, ?)";
	private static final String GET_BY_USER = """
			SELECT user_id, first_name, last_name, email, password, username
			FROM user
			where username = ? AND password = ?
			""";
	private Connection conn;

	public UserDao(DataSource ds) {
		log.trace("called");

		try {
			this.conn = ds.getConnection();
		} catch (SQLException se) {
			throw new IllegalStateException("Database issue " + se.getMessage());
		}
	}

	public List<User> getAll() {
		log.trace("called");
		List<User> results = new ArrayList<>();

		try (Statement stmt = conn.createStatement(); //
				ResultSet rs = stmt.executeQuery(GET_ALL)) {
			while (rs.next()) {
				User cur = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
				results.add(cur);
			}
		} catch (SQLException se) {
			log.error("Can't get users: " + se.getMessage());
			throw new IllegalStateException("Database issue " + se.getMessage());
		}

		return results;
	}

	public boolean insert(User user) {
		try (PreparedStatement ps = conn.prepareStatement(INSERT)) {
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getUsername());
			if (ps.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException se) {
			log.error("Can't save coder " + user.getId(), se);
			return false;
		}
	}

	public Optional<User> get(String username, String password) {
		log.trace("called");

		try (Statement stmt = conn.createStatement(); //
				ResultSet rs = stmt.executeQuery(GET_BY_USER)) {
			if (rs.next()) {
				User cur = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
				return Optional.of(cur);
			} else {
				return Optional.empty();
			}
		} catch (SQLException se) {
			log.error("Can't get users: " + se.getMessage());
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
