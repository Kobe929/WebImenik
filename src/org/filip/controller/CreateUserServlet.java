package org.filip.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.filip.model.bo.CheckerMethodsBo;
import org.filip.model.bo.UserBoImpl;
import org.filip.model.dto.User;

@WebServlet("/register")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (CheckerMethodsBo.isValidUsername(username) && CheckerMethodsBo.isValidPassword(password)) {

			
			User user = new User(username, password);

			UserBoImpl bo = new UserBoImpl();

			if (bo.createUser(user)) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return; 
				
			} else {
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return; 
			}

		} else {
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}
}