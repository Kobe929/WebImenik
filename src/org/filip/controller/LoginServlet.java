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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user;

		if (CheckerMethodsBo.isValidUsername(username) && CheckerMethodsBo.isValidPassword(password)) {

			UserBoImpl bo = new UserBoImpl();

			user = bo.readUser(username, password);

			if (user == null) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return; 
			}

			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			return; 

		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}