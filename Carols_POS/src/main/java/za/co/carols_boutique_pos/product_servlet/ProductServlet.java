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
                Payment cp = new CashPayment(Float.parseFloat(request.getParameter("Cash")));
                Payment crdP = new CardPayment(request.getParameter("cardNumber"), request.getParameter("cardType"));
                if (cp != null) {
                    sale.setPayment(cp);
                } else if (crdP != null) {
                    sale.setPayment(crdP);
                }
                request.setAttribute("cp", cp);
                request.setAttribute("crdP", crdP);
                request.getRequestDispatcher("createSale.jsp").forward(request, response);
                break;
            case "Cash":
                    Payment cashPayment = new CashPayment(Float.parseFloat(request.getParameter("cashPayment")));
                if (cashPayment != null) {
                    request.setAttribute("cashPayment", cashPayment);
                request.getRequestDispatcher("createSale.jsp").forward(request, response);
                }
                
                break;
            case "Card":
                Payment cardPayment = new CardPayment(request.getParameter("cardNumber"), request.getParameter("cardType"));
                boolean b = cardPayment.verifyCard(request.getParameter("cardNumber"));
                String cardResponse;
                if (b == false) {
                    cardResponse = "Incorrect card number";
                    request.setAttribute("cardResponse", cardResponse);
                    request.getRequestDispatcher("createSale.jsp").forward(request, response);
                }
                if (cardPayment != null) {
                    request.setAttribute("cardPayment", cardPayment);
                    request.getRequestDispatcher("createSale.jsp").forward(request, response);
                }
                break;
            case "Email":
                String email = request.getParameter("email");
                break;
            case "receiptID":
                Sale sale1 = new Sale();
                if (sale1 != null) {
                    sale1 = ss.getSale(request.getParameter("ReceiptID"));
                    request.setAttribute("sale", sale1);
                    request.getRequestDispatcher("Exchange.jsp").forward(request, response);
                }
                
                break;
            case "productID":
                sale1 =(Sale) request.getAttribute("sale");
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
            case "searchSale":
                
                Sale sale3 = new Sale();
                sale3 = ss.getSale(request.getParameter("returnReceiptID"));
                request.setAttribute("sale", sale3);
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
                break;
            case "ConfirmReturn":
                //Email
                request.getRequestDispatcher("Home.jsp").forward(request, response);
                break;

        }
    }

}
