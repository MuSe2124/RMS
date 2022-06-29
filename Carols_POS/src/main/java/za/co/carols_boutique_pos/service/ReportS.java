/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.carols_boutique_pos.service;

import za.co.carols_boutique.models.Review;
import za.co.carols_boutique_pos.models.Customer;
import za.co.carols_boutique_pos.models.Report;

/**
 *
 * @author muaad
 */
public interface ReportS {
    Report viewTopAchievingStores(String month);
    Report getCustomerReviews(String month, Integer amount);
    Report viewMonthlySales(String storeID, String month);
    Report viewTopSellingEmployees(String storeID, String month);
    Report viewStoresThatAchievedTarget(String month);
    Report viewTopSellingProducts(String month);
    Report viewLeastPerformingStores(String month);
    Report viewProductReport(String productID, String month);
    Report viewDailySalesReport(String storeID);
    
    String addReview(Review review);  
    String addCustomer(Customer customer);
}
