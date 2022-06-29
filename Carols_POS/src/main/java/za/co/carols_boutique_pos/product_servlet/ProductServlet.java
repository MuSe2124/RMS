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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import za.co.carols_boutique_pos.models.CardPayment;
import za.co.carols_boutique_pos.models.CashPayment;
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
            //edit
            case "Scan":
                Product product = new Product();
                String[] size = request.getParameter("prodID").split("");
                for (int i = 0; i < size.length; i++) {
                    product = (Product) pr.getProduct(size[0] + " " + size[1], size[2]);
                }
                if (product != null) {
                request.setAttribute("product", product);
                List<LineItem> lineItems = new ArrayList<>();

                for (LineItem lineItem : lineItems) {
                    lineItem = new LineItem(product, Integer.parseInt(request.getParameter("amount")), product.getSize());
                    lineItems.add(lineItem);
                    request.setAttribute("lineItems", lineItems);
                }
                }
                break;
            case "Cash":
                CashPayment cp = new CashPayment(Float.parseFloat(request.getParameter("cashPayment")));
                Boolean b = cp.verify(Float.parseFloat(request.getParameter("total")));
                request.setAttribute("cp", cp);
                Float total = Float.parseFloat(request.getParameter("total"));
                Float change = cp.getPayment() - total;
                request.setAttribute("change", change);
                break;
            case "Card":
                CardPayment cdp = new CardPayment(request.getParameter("cardNumber"), request.getParameter("cardType"));
                request.setAttribute("cdp", cdp);
                break;
            case "Checkout":
                Sale sale = (Sale)request.getAttribute("sale");
                String responseMessage = ss.addSale(sale);
                request.setAttribute("responseMessage", responseMessage);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        switch (request.getParameter("submit")) {

            case "createProduct":
                Product p = new Product(request.getParameter("pName"), request.getParameter("pDescription"), Float.parseFloat(request.getParameter("pPrice")));

                break;

        }
    }

}
