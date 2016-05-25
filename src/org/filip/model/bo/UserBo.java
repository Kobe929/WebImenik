package org.filip.model.bo;

import org.filip.model.dto.User;

public interface UserBo {

	public boolean createUser(User user);
	
	public User readUser(String username, String password);
}
