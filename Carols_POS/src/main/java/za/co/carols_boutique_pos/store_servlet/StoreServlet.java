/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.co.carols_boutique_pos.store_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import za.co.carols_boutique_pos.models.Category;
import za.co.carols_boutique_pos.models.IBT;
import za.co.carols_boutique_pos.models.KeepAside;
import za.co.carols_boutique_pos.models.Store;
import za.co.carols_boutique_pos.models.Store_Product;
import za.co.carols_boutique_pos.rest_clients.RestProduct;
import za.co.carols_boutique_pos.rest_clients.RestStore;
import za.co.carols_boutique_pos.rest_clients.UtilitiesRest;

/**
 *
 * @author muaad
 */
@WebServlet(name = "StoreServlet", urlPatterns = {"/StoreServlet"})
public class StoreServlet extends HttpServlet {

	private RestStore rs;
	private RestProduct product;
	private UtilitiesRest ru;

	public StoreServlet() {
		rs = new RestStore();
		product = new RestProduct();
		ru = new UtilitiesRest();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ru = new UtilitiesRest();
		switch (request.getParameter("submit")) {
			case "login":
				Store store = new Store(request.getParameter("Id"), request.getParameter("fname"));
				Store loggedInStore = rs.loginStore(store);
				if (loggedInStore != null) {
					List<Category> categories = product.getCategories();
					HttpSession session = request.getSession();
					session.setAttribute("store", loggedInStore);
					session.setAttribute("categories", categories);
					request.getRequestDispatcher("LoginEmployee_1.jsp").forward(request, response);
				} else {
					request.setAttribute("loginResponseMessage", "Could not log in");
					request.getRequestDispatcher("LoginStore_1.jsp").forward(request, response);
				}
				break;
			case "register":

				Store s = new Store("id", request.getParameter("name"), request.getParameter("location"), request.getParameter("password"), Float.parseFloat(request.getParameter("ftarget")));
				String registerResponseMessage = rs.registerStore(s);
				if (registerResponseMessage != null) {
					request.setAttribute("responseMessage", registerResponseMessage);
					request.getRequestDispatcher("Home.jsp").forward(request, response);
				} else {
					request.setAttribute("registerResponseMessage", registerResponseMessage);
					request.getRequestDispatcher("RegisterStore.jsp").forward(request, response);
				}
				break;

			case "keepAside":
				String productID = request.getParameter("productID");
				String storeID = request.getParameter("StoreID");
				Integer amount = Integer.parseInt(request.getParameter("amount"));
				String customerEmail = request.getParameter("CustomerEmail");

				KeepAside keepAside = new KeepAside(storeID, customerEmail, productID, amount);
				String message = ru.createKeepAside(keepAside);
				if (message == null) {
					request.setAttribute("responseMessage", "Could not add keep aside");
					request.getRequestDispatcher("CreateKeepAside.jsp").forward(request, response);
				} else {
					request.setAttribute("responseMessage", message);
					request.getRequestDispatcher("Home.jsp").forward(request, response);
				}
				break;
			case "ibts":
				Integer quantity = Integer.parseInt(request.getParameter("amount"));

				IBT ibt = new IBT(request.getParameter("ProductID"), quantity, request.getParameter("PhoneNumber"), request.getParameter("size"), request.getParameter("storeID"));
				String res = ru.createIBT(ibt);
				if (res == null) {
					request.setAttribute("responseMessage", "Could not add int");
					request.getRequestDispatcher("RequestIBTStart.jsp").forward(request, response);
				} else {
					request.setAttribute("responseMessage", res);
					request.getRequestDispatcher("Home.jsp").forward(request, response);
				}
				break;
			case "store_products":
				String productCode = request.getParameter("ProductID");
				ArrayList<Store_Product> products = (ArrayList<Store_Product>) ru.getProdStores(productCode);
				request.setAttribute("storeProducts", products);
				request.getRequestDispatcher("RequestIBTStart.jsp").forward(request, response);
				break;
		}
	}
}
