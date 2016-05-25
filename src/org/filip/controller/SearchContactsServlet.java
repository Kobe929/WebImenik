package org.filip.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.filip.model.bo.ContactBoImpl;
import org.filip.model.dto.Contact;
import org.filip.model.dto.User;

/**
 * Servlet implementation class SearchContactsServlet
 */
@WebServlet("/search")
public class SearchContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContactBoImpl bo = new ContactBoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		User user = (User) request.getSession(false).getAttribute("user");
		int userId = user.getId();

		response.getWriter().print(name);

		List<Contact> contacts = bo.searchContacts(name, userId);

		request.getSession().setAttribute("user", user);
		request.setAttribute("contacts", contacts);
		request.getRequestDispatcher("listSearch.jsp").forward(request, response);
	}

}
