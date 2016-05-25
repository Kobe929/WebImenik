package org.filip.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.filip.model.bo.ContactBoImpl;
import org.filip.model.dto.Contact;
import org.filip.model.dto.User;

@WebServlet("/addContact")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ContactBoImpl bo = new ContactBoImpl();

		
		User user = (User) request.getSession(false).getAttribute("user");

		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		Contact contact = new Contact();

		
		contact.setName(name);
		contact.setLastname(lastname);
		contact.setEmail(email);
		contact.setPhone(phone);

		if (bo.createContact(contact, user.getId())) {
			request.getSession().setAttribute("user", user);
			request.setAttribute("name", name);
			request.getRequestDispatcher("contactadded.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("contactnotadded.jsp").forward(request, response);
		}

	}

}
