package za.co.carols_boutique_pos.rest_clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.carols_boutique_pos.models.IBT;
import za.co.carols_boutique_pos.models.KeepAside;
import za.co.carols_boutique_pos.models.Store_Product;

public class RestUtilities {

	private Client client;
	private String uri;

	public RestUtilities() {
		client = ClientBuilder.newClient();
		uri = "http://localhost:8080/Carols_Boutique_API/pos/utilities/";
	}

	public String createKeepAside(KeepAside keepAside) {
		String url = uri + "createKeepAside";

		WebTarget webTarget = client.target(url);
		Response response = null;

		try {
			response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(Stringify(keepAside)));
		} catch (JsonProcessingException ex) {
			Logger.getLogger(RestEmployee.class.getName()).log(Level.SEVERE, null, ex);
		}
		return response.readEntity(String.class);
	}

	public String createIBT(IBT ibt) {
		String url = uri + "createIBT";

		WebTarget webTarget = client.target(url);
		Response response = null;

		try {
			response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(Stringify(ibt)));
		} catch (JsonProcessingException ex) {
			Logger.getLogger(RestEmployee.class.getName()).log(Level.SEVERE, null, ex);
		}
		return response.readEntity(String.class);
	}

	public List<Store_Product> getProdStores(String prodID) {
		String url = uri + "getProdStores";

		WebTarget webTarget = client.target(url);
		Response response = null;
		response = webTarget.request(MediaType.APPLICATION_JSON).get(Response.class);
		List<Store_Product> prodStores = new ArrayList<>();
		try {
			prodStores = Arrays.asList(new ObjectMapper().readValue(response.readEntity(String.class), Store_Product[].class));
		} catch (JsonProcessingException ex) {
			Logger.getLogger(RestUtilities.class.getName()).log(Level.SEVERE, null, ex);
		}
		return prodStores;
	}

	private String Stringify(Object o) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(o);
	}
}
