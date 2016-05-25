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
 * Servlet implementation class ListContactsServlet
 */
@WebServlet("/listContacts")
public class ListContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession(false).getAttribute("user");

		ContactBoImpl bo = new ContactBoImpl();

		List<Contact> contacts = bo.readAllContacts(user.getId());

		request.setAttribute("contacts", contacts);
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("listContacts.jsp").forward(request, response);

	}
}
