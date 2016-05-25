package org.filip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.filip.model.dto.User;

public class UserDaoImpl implements UserDao {

	// connect
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public boolean create(User user) throws SQLException {

		// create an SELECT SQL query
		String query = "INSERT INTO user(username, password) VALUES (?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			// enter data
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.executeUpdate();
		}

		return true;
	}

	@Override
	public User read(String username) throws SQLException {

		User user = null;

		// create an SELECT SQL query
		String query = "SELECT * FROM user WHERE username = ?";

		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			// enter values
			statement.setString(1, username);
			rs = statement.executeQuery();

			// put cursor on next
			if (rs.next()) {

				// enter values
				user = new User();

				user.setId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

			}

		}

		rs.close();

		return user;
	}

	@Override
	public boolean userExists(String username) throws SQLException {

		// create an SELECT SQL query
		String query = "SELECT * FROM user WHERE username = ?";

		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			// enter values
			statement.setString(1, username);
			rs = statement.executeQuery();

			// put cursor on next
			if (rs.next()) {
				return true;
			}

			return false;
		}

	}
}
