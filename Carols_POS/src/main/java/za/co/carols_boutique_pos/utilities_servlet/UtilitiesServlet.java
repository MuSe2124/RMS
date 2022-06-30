/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.co.carols_boutique_pos.utilities_servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.carols_boutique_pos.models.KeepAside;
import za.co.carols_boutique_pos.rest_clients.RestUtilities;

@WebServlet(name = "KeepAsideServlet", urlPatterns = {"/KeepAsideServlet"})
public class UtilitiesServlet extends HttpServlet {

	private RestUtilities ru;

	public UtilitiesServlet() {
		ru = new RestUtilities();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Before switch");
		switch (request.getParameter("submit")) {
			case "createKeepAside":
				System.out.println("In switch");
				String productID = request.getParameter("productID");
				String storeID = request.getParameter("StoreID");
				Integer amount = Integer.parseInt(request.getParameter("amount"));
				String customerEmail = request.getParameter("CustomerEmail");
				Date date = new Date(System.currentTimeMillis());

				
				System.out.println(productID);
				System.out.println("After 1");
				System.out.println(storeID);
				System.out.println("After 2");
				System.out.println(amount);
				System.out.println("After 3");
				System.out.println(customerEmail);
				System.out.println("After 4");
				
				KeepAside keepAside = new KeepAside(storeID, date, customerEmail, productID, amount);
				String message = ru.createKeepAside(keepAside);
				System.out.println(message);
				System.out.println("Printing the damn message");
				if (ru == null) { 
					request.setAttribute("responseMessage", "Could not add keep aside");
					request.getRequestDispatcher("CreateKeepAside.jsp").forward(request, response);
				} else {
					request.setAttribute("responseMessage", message);
					request.getRequestDispatcher("Home.jsp").forward(request, response);
				}
				break;
		}
	}
}
