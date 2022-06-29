/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.carols_boutique_pos.service;

import za.co.carols_boutique.models.Employee;

/**
 *
 * @author muaad
 */
public interface EmployeeS {
    
    Employee login(Employee employee);
    
    String register(Employee employee);
    
    String promoteToManager(String employeeID);
    
    String updateEmployee(Employee employee);
    
    String deleteEmployee(String employeeID);
}
