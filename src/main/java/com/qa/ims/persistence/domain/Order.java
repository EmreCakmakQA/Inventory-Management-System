package com.qa.ims.persistence.domain;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Order {


	private long id = 0;
	private long customer_id = 0;
	private List<Item> items = new ArrayList<Item>();
	

	// constructors
	public Order(long id, long customer_id) {
		super();
		this.id = id;
		this.customer_id = customer_id;
	}

	public Order(long customer_id) {
		super();
		this.customer_id = customer_id;
	}

	public Order(long id, List<Item> items) {
		super();
		this.id = id;
		this.items = items;
	}

	public Order(long id, long customer_id, List<Item> items) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.items = items;
	}

	// generate getters & setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customer_id;
	}

	public void setCustomerId(long customer_id) {
		this.customer_id = customer_id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	//
	public static Order convert(ResultSet rs) throws SQLException {
		if (rs.next()) {
			long id = rs.getLong("order_id");
			long customerId = rs.getLong("customer_id");
			Array items = rs.getArray("item_id");
			return new Order(id, customerId, (List<Item>) items);
		}
		

		return null;

	}

	@Override
	public String toString() {
		return "Order id: " + id + ", customer id: " + customer_id;
	}

}