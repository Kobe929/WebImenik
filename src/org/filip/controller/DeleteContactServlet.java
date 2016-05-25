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
 * Servlet implementation class DeleteContactServlet
 */
@WebServlet("/delete")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ContactBoImpl bo = new ContactBoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Contact contact = bo.readContact(id);

		request.setAttribute("contact", contact);
		request.getRequestDispatcher("deletecontact.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Contact contact = bo.readContact(id);

		if (bo.deleteContact(contact)) {
			request.getRequestDispatcher("contactdeleted.jsp").forward(request, response);
		}

	}

}
