/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.co.carols_boutique_pos.product_servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import za.co.carols_boutique.models.Employee;
import za.co.carols_boutique.models.Stock;
import za.co.carols_boutique_pos.models.ProdCat;
import za.co.carols_boutique_pos.models.CardPayment;
import za.co.carols_boutique_pos.models.CashPayment;
import za.co.carols_boutique_pos.models.Exchange;
import za.co.carols_boutique_pos.models.LineItem;
import za.co.carols_boutique_pos.models.Payment;
import za.co.carols_boutique_pos.models.Product;
import za.co.carols_boutique_pos.models.Sale;
import za.co.carols_boutique_pos.models.Store;
import za.co.carols_boutique_pos.rest_clients.RestProduct;
import za.co.carols_boutique_pos.rest_clients.RestStore;
import za.co.carols_boutique_pos.service.ProductS;
import za.co.carols_boutique_pos.service.StoreS;

/**
 *
 * @author muaad
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {

	private ProductS pr;
	private StoreS ss;

	public ProductServlet() {
		pr = new RestProduct();
		ss = new RestStore();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		switch (request.getParameter("submit")) {
			case "newSale":

				Sale sale2 = new Sale();
				DateTimeFormatter ds = DateTimeFormatter.ISO_LOCAL_DATE;

				LocalDate date = LocalDate.parse(ds.format(now()));

				sale2.setDate(date);
					session.setAttribute("sale", sale2);
					request.getRequestDispatcher("createSale.jsp").forward(request, response);
				

				break;
			case "Enter":
				Sale sale = (Sale) session.getAttribute("sale");

				
				if (sale.getLineItems() == null && sale.getLineItems().isEmpty()) {
					
					sale.setLineItems(new ArrayList<>());
				}
				
				
				System.out.println("\n\n\n\n\n\n\n\n"+sale.getLineItems().size()+"\n\n\n\n\n\n\n\n\n");
				
				
				String productID = request.getParameter("prodID");
				String[] arr = productID.split(" ");
				Product prod = pr.getProduct(arr[0], arr[1]);
				System.out.println(prod.toString());

				Boolean found = false;

				for (LineItem item:sale.getLineItems()) {
					if (item.getProduct().getId().equals(arr[0])) {
						
						System.out.println("\n\n\n\n\n\n\n\nSSSSSSSSSSSSSSS222222SSSSSSSSSSSSSSSS\n\n\n\n\n\n\n\n\n");
						found=true;
						int currentAmount = item.getAmount();
						currentAmount++;
						item.setAmount(currentAmount);
						System.out.println("\n\n\n\n\n\n\n\nSSSSSSSSSSSSSSS333333SSSSSSSSSSSSSSSS\n\n\n\n\n\n\n\n\n");
					}
					}
				
					if (!found) {
						
						System.out.println("\n\n\n\n\n\n\n\nSSSSSSSSSSSSSSSSS4444444SSSSSSSSSSSSSS\n\n\n\n\n\n\n\n\n");
						
						sale.getLineItems().add(new LineItem(prod, 1, prod.getSize()));
					}
				

				System.out.println("\n\n\n\n\n\n\n\nSSSSSSSSSSSSSS55555555SSSSSSSSSSSSSSSSS\n\n\n\n\n\n\n\n\n");

				request.getRequestDispatcher("createSale.jsp").forward(request, response);
				break;
			case "Cash":
				Sale sale4 = (Sale) session.getAttribute("sale");
				Payment cashPayment = new CashPayment(Float.parseFloat(request.getParameter("cashPayment")));
				if (cashPayment != null) {
					request.setAttribute("cashPayment", cashPayment);

				}
				if (cashPayment != null) {
					sale4.setPayment(cashPayment);
				}
				System.out.println("\n\n\n\n\n\n\n\nSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS\n\n\n\n\n\n\n\n\n");

				request.getRequestDispatcher("createSale.jsp").forward(request, response);
				break;
			case "Card":
				Sale sale5 = (Sale) session.getAttribute("sale");
				Payment cardPayment = new CardPayment(request.getParameter("cardNumber"), request.getParameter("cardType"));
                                sale5.setPayment(cardPayment);
				boolean b = cardPayment.verifyCard(request.getParameter("cardNumber"));
				String cardResponse;
				if (b == false) {
					cardResponse = "Incorrect card number";
					request.setAttribute("cardResponse", cardResponse);
					System.out.println("\n\n\n\n\n\n\n\nSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS\n\n\n\n\n\n\n\n\n");

					request.getRequestDispatcher("createSale.jsp").forward(request, response);
				}else{
                                    cardResponse = "Card number accepted";
					request.setAttribute("cardResponse", cardResponse);
					System.out.println("\n\n\n\n\n\n\n\nSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS\n\n\n\n\n\n\n\n\n");

					request.getRequestDispatcher("createSale.jsp").forward(request, response);
                                }
				if (cardPayment != null) {
					request.setAttribute("cardPayment", cardPayment);
					System.out.println("\n\n\n\n\n\n\n\nSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS\n\n\n\n\n\n\n\n\n");

					request.getRequestDispatcher("createSale.jsp").forward(request, response);
				}
				break;
			case "Email":
				String email = request.getParameter("email");
				break;
			case "receiptID":
				Sale sale1 = new Sale();
					sale1 = ss.getSale(request.getParameter("ReceiptID"));
					session.setAttribute("sale", sale1);
					System.out.println("\n\n\n\n\n\n\n\nSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS\n\n\n\n\n\n\n\n\n");

					request.getRequestDispatcher("Exchange.jsp").forward(request, response);
				break;
			case "productID":
				sale1 = (Sale)session.getAttribute("sale");
				if (sale1 != null) {
					String[] arr1 = request.getParameter("returnProductID").split(" ");
					Product returnProd = new Product();
					for(LineItem item : sale1.getLineItems()){
						if (item.getProduct().getId().equals(arr1[0])) {
							returnProd = item.getProduct();
						}
					}
					String[] arr2 = request.getParameter("exchangeProductID").split(" ");
					Product exchangeProd = pr.getProduct(arr2[0], arr2[1]);

					LineItem preLineItem = new LineItem(returnProd, Integer.parseInt(request.getParameter("returnAmount")), arr1[1]);
					LineItem postLineItem = new LineItem(exchangeProd, Integer.parseInt(request.getParameter("exchangeAmount")), arr2[1]);
					Exchange exchange = new Exchange();
                                        exchange.setPostLineItem(postLineItem);
                                        exchange.setPreLineItem(preLineItem);
                                        exchange.setSale(sale1);
					request.setAttribute("exchange", exchange);
					request.getRequestDispatcher("Exchange.jsp").forward(request, response);
				}
				break;
			case "searchSale":

				Sale sale3 = new Sale();
				sale3 = ss.getSale(request.getParameter("returnReceiptID"));
                                
				session.setAttribute("sale", sale3);
				request.getRequestDispatcher("Return.jsp").forward(request, response);
				break;
			case "searchProduct":
				String[] arr4 = request.getParameter("returnProductID").split(" ");
				Product prod5 = pr.getProduct(arr4[0], arr4[1]);
				request.setAttribute("prod", prod5);
				request.getRequestDispatcher("Return.jsp").forward(request, response);
				break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		switch (request.getParameter("submit")) {

			case "createProduct":
				Product p = new Product(request.getParameter("pName"), request.getParameter("pDescription"), Float.parseFloat(request.getParameter("pPrice")));
				ProdCat prodCat = new ProdCat(p, request.getParameter("category"));
				String added = pr.addNewProduct(prodCat);
				if (added != null) {
					request.setAttribute("responseMessage", added);
					request.getRequestDispatcher("Home.jsp").forward(request, response);
				} else {
					request.setAttribute("responseMessage", "could not add product");
					request.getRequestDispatcher("Home.jsp").forward(request, response);
				}
				break;

			case "Checkout":
				Sale sale = (Sale) session.getAttribute("sale");
				String responseMessage = ss.addSale(sale);
				sale.setLineItems(new ArrayList<>());
				request.setAttribute("responseMessage", responseMessage);
				request.getRequestDispatcher("Home.jsp").forward(request, response);
				break;
			case "ConfirmExchange":
				String[] arr = request.getParameter("exchangeProductID").split(" ");
				Product product = pr.getProduct(arr[0], arr[1]);
				pr.removeProductFromInventory(new Stock(product.getId(), product.getName(), Integer.parseInt(request.getParameter("exchangeAmount"))));
                                request.getRequestDispatcher("Home.jsp").forward(request, response);
				break;

			case "addToStock":

				Store store = (Store) session.getAttribute("store");
				Employee employee = (Employee) session.getAttribute("employee");

				System.out.println(store.getId());
				System.out.println(employee.getId());
				System.out.println(request.getParameter("prodID"));
				System.out.println(Integer.parseInt(request.getParameter("amount")));
				System.out.println(request.getParameter("size"));

				Stock stock = new Stock(store.getId(), request.getParameter("prodID"), employee.getId(), Integer.parseInt(request.getParameter("amount")), request.getParameter("size"));
				String stockAdded = pr.addProductToInventory(stock);
				if (stockAdded != null) {
					request.setAttribute("responseMessage", stockAdded);
					request.getRequestDispatcher("Home.jsp").forward(request, response);
				}
				break;
			case "ConfirmReturn":
				//Email
				request.getRequestDispatcher("Home.jsp").forward(request, response);
				break;

		}
	}

}
