/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique_pos.rest_clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.carols_boutique.models.Review;
import za.co.carols_boutique_pos.models.Customer;
import za.co.carols_boutique_pos.models.Report;
import za.co.carols_boutique_pos.service.ReportS;

/**
 *
 * @author muaad
 */
public class RestReport implements ReportS{

	private Client client;
	private String url;

	public RestReport(){
		client = ClientBuilder.newClient();
		url = "http://localhost:8080/Carols_Boutique_API/pos/report/";
	}
	
    @Override
    public Report viewTopAchievingStores(String month) {
		String url = "url"+"viewTopAchievingStores/"+month;

        WebTarget webTarget = client.target(url);
        Response response = null;

		response = webTarget.request(MediaType.APPLICATION_JSON).get(Response.class);
		
        return response.readEntity(Report.class);    
	}

    @Override
    public Report getCustomerReviews(String month, Integer amount) {
		String url = "url"+"getCustomerReviews/"+month+"/"+amount;

        WebTarget webTarget = client.target(url);
        Response response = null;

		response = webTarget.request(MediaType.APPLICATION_JSON).get(Response.class);
		
        return response.readEntity(Report.class);   
	}

    @Override
    public Report viewMonthlySales(String storeID, String month) {
		String url = "url"+"viewMonthlySales/"+storeID+"/"+month;

        WebTarget webTarget = client.target(url);
        Response response = null;

		response = webTarget.request(MediaType.APPLICATION_JSON).get(Response.class);
		
        return response.readEntity(Report.class);   
	}

    @Override
    public Report viewTopSellingEmployees(String storeID, String month) {
		String url = "url"+"viewTopSellingEmployees/"+storeID+"/"+month;

        WebTarget webTarget = client.target(url);
        Response response = null;

		response = webTarget.request(MediaType.APPLICATION_JSON).get(Response.class);
		
        return response.readEntity(Report.class);   
	}

    @Override
    public Report viewStoresThatAchievedTarget(String month) {
		String url = "url"+"viewStoresThatAchievedTarget/"+month;

        WebTarget webTarget = client.target(url);
        Response response = null;

		response = webTarget.request(MediaType.APPLICATION_JSON).get(Response.class);
		
        return response.readEntity(Report.class);   
	}

    @Override
    public Report viewTopSellingProducts(String month) {
		String url = "url"+"viewTopSellingProducts/"+month;

        WebTarget webTarget = client.target(url);
        Response response = null;

		response = webTarget.request(MediaType.APPLICATION_JSON).get(Response.class);
		
        return response.readEntity(Report.class); 
	}

    @Override
    public Report viewLeastPerformingStores(String month) {
		String url = "url"+"viewLeastPerformingStores/"+month;

        WebTarget webTarget = client.target(url);
        Response response = null;

		response = webTarget.request(MediaType.APPLICATION_JSON).get(Response.class);
		
        return response.readEntity(Report.class); 
	}

    @Override
    public Report viewProductReport(String productID, String month) {
		String url = "url"+"viewProductReport/"+productID+"/"+month;

        WebTarget webTarget = client.target(url);
        Response response = null;

		response = webTarget.request(MediaType.APPLICATION_JSON).get(Response.class);
		
        return response.readEntity(Report.class); 
	}

    @Override
    public Report viewDailySalesReport(String storeID) {
		String url = "url"+"viewDailySalesReport/"+storeID;

        WebTarget webTarget = client.target(url);
        Response response = null;

		response = webTarget.request(MediaType.APPLICATION_JSON).get(Response.class);
		
        return response.readEntity(Report.class); 
	}

    @Override
    public String addReview(Review review) {
		String url = "url"+"addReview";

        WebTarget webTarget = client.target(url);
        Response response = null;

		try {
			response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(Stringify(review)));
		} catch (JsonProcessingException ex) {
			Logger.getLogger(RestReport.class.getName()).log(Level.SEVERE, null, ex);
		}
		
        return response.readEntity(String.class); 
	}

    @Override
    public String addCustomer(Customer customer) {
		String url = "url"+"addCustomer";

        WebTarget webTarget = client.target(url);
        Response response = null;

		try {
			response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(Stringify(customer)));
		} catch (JsonProcessingException ex) {
			Logger.getLogger(RestReport.class.getName()).log(Level.SEVERE, null, ex);
		}
		
        return response.readEntity(String.class); 
	}
    
	private String Stringify(Object o) throws JsonProcessingException{   
        return new ObjectMapper().writeValueAsString(o);
    }
}
