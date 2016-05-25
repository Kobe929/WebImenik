package org.filip.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.filip.model.dto.Contact;

public interface ContactDao {

	public boolean create(Contact contact, int userId) throws SQLException;

	public Contact read(int id) throws SQLException;

	public List<Contact> readAll(int userId) throws SQLException;

	public boolean update(Contact contact) throws SQLException;

	public boolean delete(Contact contact) throws SQLException;
	
	public List<Contact> search (String name, int userId) throws SQLException;
}
