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
import za.co.carols_boutique_pos.models.Sale;
import za.co.carols_boutique_pos.models.Store;
import za.co.carols_boutique_pos.service.StoreS;

/**
 *
 * @author muaad
 */
public class RestStore implements StoreS {


	private Client client;
	private String uri;

	public RestStore(){
		client = ClientBuilder.newClient();
		uri = "http://localhost:8080/Carols_Boutique_API/pos/store/";
	}

@Override
    public Store loginStore(Store store) {
		String url = uri+"loginStore";
        WebTarget webTarget = client.target(url);
        Response response = null;

        try {
            response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(Stringify(store)));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestStore.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response.readEntity(Store.class);
    }

    @Override
    public String registerStore(Store store) {

		String url = uri+"registerStore";

        WebTarget webTarget = client.target(url);
        Response response = null;

        try {
            response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(Stringify(store)));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response.readEntity(String.class);
    }

    @Override
    public String addSale(Sale sale) {

		String url = uri+"register";

        WebTarget webTarget = client.target(url);
        Response response = null;

        try {
            response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(Stringify(sale)));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response.readEntity(String.class);
    }

    @Override
    public String deleteStore(String storeID) {

		String url = uri+"deleteEmployee";

        WebTarget webTarget = client.target(url);
        Response response = webTarget.request(MediaType.APPLICATION_JSON).get(Response.class);

        return response.readEntity(String.class);
    }

    private String Stringify(Object o) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(o);
    }

    @Override
    public Sale getSale(String saleID) {
        String url = uri + "getSale";

        WebTarget webTarget = client.target(url);

           Response response = webTarget.request(MediaType.APPLICATION_JSON).get(Response.class);

        return response.readEntity(Sale.class);
    }
}
