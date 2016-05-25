package org.filip.model.bo;

import java.sql.SQLException;

import org.filip.model.dao.UserDaoImpl;
import org.filip.model.dto.Contact;
import org.filip.model.dto.User;

// Methods that check if content meets requirements
public class CheckerMethodsBo {

	private static UserDaoImpl dao = new UserDaoImpl();

	//Self explainatory
	public static boolean isUserNotNull(User user) {
		if (user == null) {
			return false;
		}
		return true;
	}

	//Check if password is longer than 5 chars and is not whitespaces
	public static boolean isValidPassword(String password) {
		if ((password.length() < 6) || (password.trim() == "")) {
			return false;
		}
		return true;
	}

	//Check if username is longer than 1 char and is not whitespaces
	public static boolean isValidUsername(String username) {
		if ((username.length() < 2) || (username.trim() == "")) {
			return false;
		}
		return true;
	}

	//Check if user is valid
	public static boolean isValidUser(User user) {
		if (isUserNotNull(user) && isValidPassword(user.getPassword()) && isValidUsername(user.getUsername())) {
			try {
				if (!dao.userExists(user.getUsername())) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
	}

	//Self explainatory
	public static boolean isContactNotNull(Contact contact) {
		if (contact == null) {
			return false;
		}
		return true;
	}

	//Check if contact invalid
	public static boolean isValidContact(Contact contact) {

		if ((contact.getName().trim() != "") && (contact.getLastname().trim() != "")
				&& (contact.getEmail().trim() != "") && (contact.getPhone().trim() != "")) {
			
			return true;
		}

		return false;
	}

	//Check if id is valid
	public static boolean isValidId(int userId) {

		if (userId > 0) {
			return true;
		}

		return false;
	}
}