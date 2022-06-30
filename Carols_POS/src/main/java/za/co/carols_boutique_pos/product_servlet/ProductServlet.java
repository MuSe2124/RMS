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
import za.co.carols_boutique.models.Stock;
import za.co.carols_boutique_pos.models.ProdCat;
import za.co.carols_boutique_pos.models.CardPayment;
import za.co.carols_boutique_pos.models.CashPayment;
import za.co.carols_boutique_pos.models.Exchange;
import za.co.carols_boutique_pos.models.LineItem;
import za.co.carols_boutique_pos.models.Product;
import za.co.carols_boutique_pos.models.Sale;
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
        switch (request.getParameter("submit")) {
            case "newSale":
                HttpSession session = request.getSession();
                Sale sale = new Sale();
                String productID = request.getParameter("prodID");
                
                String[]arr = productID.split(" ");
                Product prod = pr.getProduct(arr[0], arr[1]);
                if (prod != null) {
                    
                        Integer amount = 1;
                        LineItem li = new LineItem(prod, amount, arr[1]);
                        sale.getLineItems().add(li);
                        for (int i = 0; i < sale.getLineItems().size(); i++) {
                        if (sale.getLineItems().get(i).getProduct().getId().equals(sale.getLineItems().get(i + 1).getId())) {
                            li.setAmount(amount++);
                        }else{
                            sale.getLineItems().add(new LineItem(prod, amount, arr[1]));
                        }
                    } 
                }
                Date date = new Date(System.currentTimeMillis());
                sale.setDate(date);
                
                CashPayment cp = new CashPayment(Float.parseFloat(request.getParameter("Cash")));
                CardPayment crdP = new CardPayment(request.getParameter("cardNumber"), request.getParameter("cardType"));
                if (cp != null) {
                    sale.setPayment(cp);
                }else if(crdP != null){
                    sale.setPayment(crdP);
                }
                session.setAttribute("sale", sale);
                
                break;
            case "receiptID":
                Sale sale1 = ss.getSale(request.getParameter("ReceiptID"));
                if (sale1 != null) {
                    String[] arr1 = request.getParameter("returnProductID").split(" ");
                    Product returnProd = null;
                    for (int i = 0; i < sale1.getLineItems().size(); i++) {
                        if (sale1.getLineItems().get(i).getProduct().getId().equals(arr1[1]+arr1[2])) {
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

        switch (request.getParameter("submit")) {

            case "createProduct":
                Product p = new Product(request.getParameter("pName"), request.getParameter("pDescription"), Float.parseFloat(request.getParameter("pPrice")));
                ProdCat prodCat = new ProdCat(p,request.getParameter("category"));
				String added = pr.addNewProduct(prodCat);
				if(added != null && added.equals("New product added successfully.")){
					request.setAttribute("responseMessage", added);
                    request.getRequestDispatcher("CreateProduct.jsp").forward(request, response); 
				}
                break;
            case "Checkout":
                HttpSession session = request.getSession();
                Sale sale = (Sale)session.getAttribute("sale");
                String responseMessage = ss.addSale(sale);
                sale = null;
                session.setAttribute("sale", null);
                request.setAttribute(responseMessage, responseMessage);
                request.getRequestDispatcher("Home.jsp").forward(request, response);
                break;
            case "ConfirmExchange":
                String[]arr = request.getParameter("exchangeProductID").split(" ");
                Product product = pr.getProduct(arr[0], arr[1]);
                pr.removeProductFromInventory(new Stock(product.getId(), product.getName(), Integer.parseInt(request.getParameter("exchangeAmount"))));
                break;
        }
    }

}
