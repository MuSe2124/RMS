/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.co.carols_boutique_pos.utilities_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.carols_boutique_pos.models.KeepAside;
import za.co.carols_boutique_pos.models.LineItem;
import za.co.carols_boutique_pos.models.Product;
import za.co.carols_boutique_pos.rest_clients.RestUtilities;

@WebServlet(name = "KeepAsideServlet", urlPatterns = {"/KeepAsideServlet"})
public class UtilitiesServlet extends HttpServlet {

	private RestUtilities ru;

	public UtilitiesServlet() {
		ru = new RestUtilities();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getParameter("submit")) {
			case "createKeepAside":
				String productID = request.getParameter("productID");
				String storeID = request.getParameter("StoreID");
				Integer amount = Integer.parseInt(request.getParameter("amount"));
				String customerEmail = request.getParameter("CustomerEmail");
				Date date = new Date(System.currentTimeMillis());

				KeepAside keepAside = new KeepAside(storeID, date, customerEmail, new LineItem(new Product(productID), amount));
				String message = ru.createKeepAside(keepAside);

				if (ru == null) {
					request.setAttribute("responseMessage", "could not add keep aside");
					request.getRequestDispatcher("CreateKeepAside.jsp");
				} else {
					request.setAttribute("responseMessage", ru);
					request.getRequestDispatcher("Home.jsp");
				}
				break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
