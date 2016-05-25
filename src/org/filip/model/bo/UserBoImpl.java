package org.filip.model.bo;

import java.sql.SQLException;

import org.filip.model.dao.UserDao;
import org.filip.model.dao.UserDaoImpl;
import org.filip.model.dto.User;

public class UserBoImpl implements UserBo {

	UserDao dao = new UserDaoImpl();

	@Override
	public boolean createUser(User user) {

		if (CheckerMethodsBo.isValidUser(user)) {

			try {

				if (dao.create(user)) {
					return true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 

		return false;
	}

	@Override
	public User readUser(String username, String password) {

		User user = null;

		if (CheckerMethodsBo.isValidPassword(password) && CheckerMethodsBo.isValidUsername(username)) {
			try {

				user = dao.read(username);

				if (!user.getPassword().equals(password)) {
					user = null;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return user;
	}

}
