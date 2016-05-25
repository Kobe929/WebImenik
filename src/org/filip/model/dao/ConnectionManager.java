package org.filip.model.dao;

import java.sql.*;

public class ConnectionManager {

	
	private static ConnectionManager instance = null;

	// DB credentials
	private final String USERNAME = "root";
	private final String PASSWORD = "root";
	private final String CONN_STRING = "jdbc:mysql://localhost/WebImenik";
	private final String DRIVER = "com.mysql.jdbc.Driver";

	// connection
	private Connection connection = null;

	
	private ConnectionManager() {

	}

	// check connection instance
	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	//Open connection
	private boolean openConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}

	//Get connection status
	public Connection getConnection() {
		if (connection == null) {
			if (openConnection()) {
				System.out.println("Connected");
				return connection;
			} else {
				return null;
			}
		}
		return connection;
	}

	//Close connection
	public void close() {
		System.out.println("Disconnected");
		try {
			connection.close();
			connection = null;
		} catch (Exception e) {
		}
	}
}
