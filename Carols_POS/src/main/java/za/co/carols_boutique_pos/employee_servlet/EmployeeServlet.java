/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.co.carols_boutique_pos.employee_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import za.co.carols_boutique_pos.models.Employee;
import za.co.carols_boutique_pos.rest_clients.RestEmployee;



/**
 *
 * @author muaad
 */
@WebServlet(name = "EmployeeServlet", urlPatterns = {"/EmployeeServlet"})
public class EmployeeServlet extends HttpServlet {
    private RestEmployee re;
    
    public EmployeeServlet(){
        re = new RestEmployee();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        switch (request.getParameter("submit")) {
            case "login":
                Employee emp = new Employee(request.getParameter("employeeID"), request.getParameter("password"), request.getParameter("storeID"));
                Employee signedInEmployee = re.login(emp);
                if (emp != null) {
                    HttpSession session = request.getSession();//blank=returns session, doesnt exist itll create one for you//true=if session exists, still creates new session//false= not new session, gets existing session
                    session.setAttribute("employee", signedInEmployee);
                    request.getRequestDispatcher("Index.jsp").forward(request, response);
                } else {
                    request.setAttribute("loginResponseMessage", "Could not log in");
                    
                    request.getRequestDispatcher("LoginEmployee.jsp").forward(request, response);
                }
                break;
            case "register":
                Employee e = new Employee(request.getParameter("name"), request.getParameter("password"), request.getParameter("storeID"));
                String registerResponseMessage = re.register(e);  
                if (e != null) {
                    request.setAttribute("employee", e);
                    request.getRequestDispatcher("LoginEmployee.jsp").forward(request, response);
                } else {
                    request.setAttribute("registerResponseMessage", registerResponseMessage);
                    request.getRequestDispatcher("RegisterEmployee.jsp").forward(request, response);
                }
                break;
            case "promoteToManager":
                Employee e1 = new Employee(request.getParameter("employeeID"), request.getParameter("password"), request.getParameter("storeID"));
                String promoteResponse = re.promoteToManager(e1.getId());
                if (e1 != null) {
                    request.setAttribute("employee", e1);
                    request.getRequestDispatcher("Index.jsp").forward(request, response);
                }else{
                    request.setAttribute("promoteResponse", promoteResponse);
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
                break;
            case "updateEmployee":
                Employee e2 = new Employee(request.getParameter("employeeID"), request.getParameter("name"), request.getParameter("surname"), request.getParameter("password"), request.getParameter("storeID"));
                String updateResponse = re.updateEmployee(e2);
                if (e2 != null) {
                    request.setAttribute("employee", e2);
                    request.getRequestDispatcher("Index.jsp").forward(request, response);
                }else{
                    request.setAttribute("updateResponse", updateResponse);
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
                break;
            case "deleteEmployee":
                Employee e3 = new Employee(request.getParameter("employeeID"), request.getParameter("password"), request.getParameter("storeID"));
                String deleteEmployee = re.deleteEmployee(e3.getId());
                if (e3 != null) {
                    request.setAttribute("employee", e3);
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }else{
                    request.setAttribute("deleteEmployee", deleteEmployee);
                    request.getRequestDispatcher("Index.jsp").forward(request, response);
                }
                break;
    }
    }
    
}
