package org.filip.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.filip.model.bo.ContactBoImpl;
import org.filip.model.dto.Contact;

/**
 * Servlet implementation class EditContactServlet
 */
@WebServlet("/edit")
public class EditContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ContactBoImpl bo = new ContactBoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		int id = Integer.parseInt(request.getParameter("id"));
		Contact contact = bo.readContact(id);

		request.setAttribute("contact", contact);
		request.getRequestDispatcher("editcontact.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		Contact contact = new Contact();
		contact.setContactId(id);
		contact.setName(name);
		contact.setLastname(lastname);
		contact.setEmail(email);
		contact.setPhone(phone);

		if (bo.updateContact(contact)) {
			request.getRequestDispatcher("contactEdited.jsp").forward(request, response);
		}
		/*else {
			request.getRequestDispatcher("contactnotedited.jsp").forward(request, response);

		}
		*/

	}
}
