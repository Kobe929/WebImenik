package org.filip.model.dao;

import java.sql.SQLException;

import org.filip.model.dto.User;

public interface UserDao {

	public boolean create(User user) throws SQLException;

	public User read(String username) throws SQLException;

	public boolean userExists(String username) throws SQLException;
}