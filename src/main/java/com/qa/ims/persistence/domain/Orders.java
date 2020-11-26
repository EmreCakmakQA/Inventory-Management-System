package com.qa.ims.persistence.domain;

import java.util.List;

public class Orders {
	
	// Attributes
	private Long order_id = (long) 0;
	private Long customer_id;
	private List<Item> items;
	
	
	// Constructors

	public Orders(Long order_id, Long customer_id, List<Item> items) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.items = items;
	}
	
	public Orders(Long customer_id) {
		super();
		this.order_id = 0L;
		this.customer_id = customer_id;
	}
	
	public Orders(List<Item> items) {
		super();
		this.order_id = 0L;
		this.customer_id = 0L;
		this.items = items;
		
	}

	public void addToItemsList(Item item) {
		items.add(item);
	}

	// Getters & Setters
	public Long getOrder_id() {
		return order_id;
	}


	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}


	public Long getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	
	

	@Override
	public String toString() {
		return "Order id: " + order_id + ", Customer id: " + customer_id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		return true;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	

}