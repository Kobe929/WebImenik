package org.filip.model.bo;

import java.sql.SQLException;
import java.util.List;

import org.filip.model.dao.ContactDao;
import org.filip.model.dao.ContactDaoImpl;
import org.filip.model.dto.Contact;

public class ContactBoImpl implements ContactBo {

	ContactDao dao = new ContactDaoImpl();

	
	@Override
	public boolean createContact(Contact contact, int userId) {

		if (CheckerMethodsBo.isContactNotNull(contact) && CheckerMethodsBo.isValidId(userId) && CheckerMethodsBo.isValidContact(contact)) {

			try {

				if (dao.create(contact, userId)) {
					return true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return false;
	}

	@Override
	public Contact readContact(int id) {

		Contact contact = null;

		if (CheckerMethodsBo.isValidId(id)) {
			try {
				contact = dao.read(id);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return contact;
	}

	@Override
	public List<Contact> readAllContacts(int userId) {
		List<Contact> contacts = null;

		if (CheckerMethodsBo.isValidId(userId)) {

			try {

				contacts = dao.readAll(userId);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return contacts;
	}

	@Override
	public boolean updateContact(Contact contact) {

		if (CheckerMethodsBo.isContactNotNull(contact) && CheckerMethodsBo.isValidContact(contact)) {

			try {
				if (dao.update(contact)) {
					return true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteContact(Contact contact) {

		if (CheckerMethodsBo.isContactNotNull(contact)) {

			try {
				if (dao.delete(contact)) {
					return true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public List<Contact> searchContacts(String name, int userId) {

		List<Contact> contacts = null;

		try {

			contacts = dao.search(name, userId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contacts;
	}

}
