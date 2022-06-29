package za.co.carols_boutique_pos.models;

import java.io.Serializable;

public class IBT implements Serializable {

	private String id;
	private LineItem lineItem;
	private Customer customer;

	public IBT(String id, LineItem lineItem, Customer customer) {
		this.id = id;
		this.lineItem = lineItem;
		this.customer = customer;
	}

	public LineItem getLineItem() {
		return lineItem;
	}

	public void setLineItem(LineItem lineItem) {
		this.lineItem = lineItem;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
