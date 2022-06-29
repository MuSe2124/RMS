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
            //edit
            case "Scan":
                Product product = new Product();
                String[] size = request.getParameter("prodID").split("");
                for (int i = 0; i < size.length; i++) {
                    product = pr.getProduct(size[0] + " " + size[1], size[2]);
                }
                if (product != null) {
                    request.setAttribute("product", product);
                    request.getRequestDispatcher("createSale.jsp").forward(request, response);
                    List<LineItem> lineItems = new ArrayList<>();

                    for (LineItem lineItem : lineItems) {
                        lineItem = new LineItem(product, Integer.parseInt(request.getParameter("amount")), product.getSize());
                        lineItems.add(lineItem);
                        request.setAttribute("lineItems", lineItems);
                        request.getRequestDispatcher("createSale.jsp").forward(request, response);
                    }
                }
                break;
            case "Cash":
                CashPayment cp = new CashPayment(Float.parseFloat(request.getParameter("cashPayment")));
                Boolean b = cp.verify(Float.parseFloat(request.getParameter("total")));
                request.setAttribute("cp", cp);
                request.getRequestDispatcher("createSale.jsp").forward(request, response);
                Float total = Float.parseFloat(request.getParameter("total"));
                Float change = cp.getPayment() - total;
                request.setAttribute("change", change);
                request.getRequestDispatcher("createSale.jsp").forward(request, response);
                break;
            case "Card":
                CardPayment cdp = new CardPayment(request.getParameter("cardNumber"), request.getParameter("cardType"));
                request.setAttribute("cdp", cdp);
                request.getRequestDispatcher("createSale.jsp").forward(request, response);
                break;
            case "Checkout":
                Sale sale = (Sale) request.getAttribute("sale");
                if (sale != null) {
                    String responseMessage = ss.addSale(sale);
                    request.setAttribute("responseMessage", responseMessage);
                    request.getRequestDispatcher("createSale.jsp").forward(request, response);
                }
                break;
            case "receiptID":
                Sale s = ss.getSale(request.getParameter("ReceiptID"));

                if (s != null) {
                    request.setAttribute("s", s);
                    request.getRequestDispatcher("Exchange.jsp").forward(request, response);
                } else {
                    String noSale = "Sale not found";
                    request.setAttribute("noSale", noSale);
                    request.getRequestDispatcher("Exchange.jsp").forward(request, response);
                }
                break;
            case "addwithproductID":
                Product product1 = new Product();
                String[] prodArr = request.getParameter("prodID").split("");
                for (int i = 0; i < prodArr.length; i++) {
                    product1 = pr.getProduct(prodArr[0] + " " + prodArr[1], prodArr[2]);
                    if (product1 != null) {
                        request.setAttribute("product1", product1);
                        request.getRequestDispatcher("Exchange.jsp").forward(request, response);
                    } else {
                        String noProduct = "Product not found";
                        request.setAttribute("noProduct", noProduct);
                        request.getRequestDispatcher("Exchange.jsp").forward(request, response);
                    }
                }
                break;
            case "exchangedItem":
                Product product2 = new Product();
                String[] prodArr2 = request.getParameter("prodID").split("");
                for (int i = 0; i < prodArr2.length; i++) {
                    product2 = pr.getProduct(prodArr2[0] + " " + prodArr2[1], prodArr2[2]);
                    if (product2 != null) {
                        request.setAttribute("product2", product2);
                        request.getRequestDispatcher("Exchange.jsp").forward(request, response);
                    } else {
                        String noProduct = "Product not found";
                        request.setAttribute("noProduct", noProduct);
                        request.getRequestDispatcher("Exchange.jsp").forward(request, response);
                    }
                }
            case "ConfirmExchange":
                //fix this
                //"pr.deleteProduct(responseMessage, responseMessage)
                break;
            case "searchSale":
                Sale sale1 = ss.getSale(request.getParameter("ReceiptID"));
                if (sale1 != null) {
                    
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

                break;

        }
    }

}
