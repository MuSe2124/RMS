/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.co.carols_boutique_pos.report_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import za.co.carols_boutique_pos.models.Report;
import za.co.carols_boutique_pos.rest_clients.RestReport;



/**
 *
 * @author muaad
 */
@WebServlet(name = "ReportServlet", urlPatterns = {"/ReportServlet"})
public class ReportServlet extends HttpServlet {
    private Report rep;
private RestReport rr; 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rr = new RestReport();
        switch(request.getParameter("button")){
            case"acheivedtargetbutton":
                rep=rr.viewStoresThatAchievedTarget(request.getParameter("acheivedtargetmonth"));
                request.setAttribute("acheivedtargetreport",rep);
                request.getRequestDispatcher("AcheivedTarget.jsp").forward(request,response);
                break;
            case"LeastTopEmployeesbutton":
                rep=rr.viewLeastPerformingStores(request.getParameter("LeastTopEmployeesmonth"));
                request.setAttribute("LeastTopEmployeesReport",rep);
                request.getRequestDispatcher("LeastTopEmployees.jsp").forward(request,response);
                break;
            case"MonthlySalesbutton":
                rep=rr.viewMonthlySales(request.getParameter("MonthlySalesStoreID"), request.getParameter("MonthlySalesMonth"));
                request.setAttribute("MonthlySalesReport",rep);
                request.getRequestDispatcher("MonthlySales.jsp").forward(request,response);
                break;
            case"TopSellingEmployeesbutton":
                rep=rr.viewTopSellingEmployees(request.getParameter("TopSellingEmployeesStore"), request.getParameter("TopSellingEmployeesmonth"));
                request.setAttribute("TopSellingEmployeesReport",rep);
                request.getRequestDispatcher("TopSellingEmployees.jsp").forward(request,response);
                break;
            case"ViewDailySalesbutton":
                rep=rr.viewDailySalesReport(request.getParameter("ViewDailySalesStoreButton"));
                request.setAttribute("ViewDailySalesReport",rep);
                request.getRequestDispatcher("ViewDailySales.jsp").forward(request,response);
                break;    
            case"ProductReportbutton":
                rep=rr.viewProductReport(request.getParameter("ProductReportStoreID"), request.getParameter("ProductReportMonth"));
                request.setAttribute("ProductReportReport",rep);
                request.getRequestDispatcher("ProductReport.jsp").forward(request,response);
                break;    
            case"TopSellingProductsbutton":
                rep=rr.viewTopSellingProducts(request.getParameter("TopSellingProductsMonth"));
                request.setAttribute("TopSellingProductsReport",rep);
                request.getRequestDispatcher("TopSellingProducts.jsp").forward(request,response);
                break;
            case"CustomerReviewbutton":
                rep=rr.getCustomerReviews(request.getParameter("CustomerReviewMonth"),Integer.valueOf(request.getParameter("CustomerReviewAmount")));
                request.setAttribute("CustomerReviewReport",rep);
                request.getRequestDispatcher("CustomerReviewReport.jsp").forward(request,response);
                break;
                
                
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
