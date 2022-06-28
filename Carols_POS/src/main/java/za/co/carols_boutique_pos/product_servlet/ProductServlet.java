/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.co.carols_boutique_pos.product_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import za.co.carols_boutique_pos.models.Product;
import za.co.carols_boutique_pos.rest_clients.RestProduct;
import za.co.carols_boutique_pos.service.ProductS;


/**
 *
 * @author muaad
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {

	private RestProduct pr;
	
	public ProductServlet(){
		pr = new RestProduct();
	}
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch(request.getParameter("submit")){
            //edit
            case "getProduct":
                Product product = pr.getProduct(request.getParameter("prodID"), request.getParameter("size"));
                request.setAttribute("product", product);
                request.getRequestDispatcher("createSale.jsp").forward(request, response);
                break;
                
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		switch(request.getParameter("submit")){
			
			case "createProduct":
				Product p = new Product(request.getParameter("pName"),request.getParameter("pDescription"),Float.parseFloat(request.getParameter("pPrice")));
				
				break;
		}
    }

}
