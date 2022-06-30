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
                if (sale2 != null) {
                    request.getSession().setAttribute("sale", sale2);
                    request.getRequestDispatcher("createSale.jsp").forward(request, response);  
                }
                
                break;
            case "Enter":
                Sale sale = (Sale) request.getSession().getAttribute("sale");
                
                List<LineItem> lis = new ArrayList<>();
                Date date = new Date(System.currentTimeMillis());
                sale.setDate(date);
                request.getSession().setAttribute("sale", sale);
                String productID = request.getParameter("prodID");
                String[] arr = productID.split(" ");
                Product prod = pr.getProduct(arr[0], arr[1]);

                if (prod != null) {
                    Boolean found = false;
                    if (found) {
                        for (int i = 0; i < sale.getLineItems().size(); i++) {
                            if (sale.getLineItems().get(i).getProduct().getId().equals(productID)) {
                                LineItem lI = sale.getLineItems().get(i);
                                int currentAmount = lI.getAmount();
                                currentAmount++;
                                lI.setAmount(currentAmount);
                                found = true;
                            }
                            if (found) {
                                sale.getLineItems().add(new LineItem(sale.getLineItems().get(i).getProduct(), sale.getLineItems().get(i).getAmount(), sale.getLineItems().get(i).getSize()));
                            }
                        }
                    }
                }
                CashPayment cp = new CashPayment(Float.parseFloat(request.getParameter("Cash")));
                CardPayment crdP = new CardPayment(request.getParameter("cardNumber"), request.getParameter("cardType"));
                if (cp != null) {
                    sale.setPayment(cp);
                } else if (crdP != null) {
                    sale.setPayment(crdP);
                }
                request.getRequestDispatcher("createSale.jsp").forward(request, response);
                break;
            case "receiptID":
                Sale sale1 = ss.getSale(request.getParameter("ReceiptID"));
                if (sale1 != null) {
                    String[] arr1 = request.getParameter("returnProductID").split(" ");
                    Product returnProd = null;
                    for (int i = 0; i < sale1.getLineItems().size(); i++) {
                        if (sale1.getLineItems().get(i).getProduct().getId().equals(arr1[1] + arr1[2])) {
                            returnProd = sale1.getLineItems().get(i).getProduct();
                        }
                    }
                    String[] arr2 = request.getParameter("exchangeProductID").split(" ");
                    Product exchangeProd = pr.getProduct(arr2[0], arr2[1]);

                    LineItem preLineItem = new LineItem(returnProd, Integer.parseInt(request.getParameter("returnAmount")), arr1[1]);
                    LineItem postLineItem = new LineItem(exchangeProd, Integer.parseInt(request.getParameter("exchangeAmount")), arr2[1]);
                    Exchange exchange = new Exchange(sale1, preLineItem, postLineItem);
                    request.setAttribute("exchange", exchange);
                    request.getRequestDispatcher("Exchange.jsp").forward(request, response);

                }
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
                sale = null;
                session.setAttribute("sale", null);
                request.setAttribute(responseMessage, responseMessage);
                request.getRequestDispatcher("Home.jsp").forward(request, response);
                break;
            case "ConfirmExchange":
                String[] arr = request.getParameter("exchangeProductID").split(" ");
                Product product = pr.getProduct(arr[0], arr[1]);
                pr.removeProductFromInventory(new Stock(product.getId(), product.getName(), Integer.parseInt(request.getParameter("exchangeAmount"))));
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

        }
    }

}
