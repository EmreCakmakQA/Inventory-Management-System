package com.qa.ims.persistence.domain;

public class Item {
	
	// Attributes
	private Long id = (long) 0;
	private String itemName; 
	private Long itemPrice;
	private Long itemQuantity;
	
	
	// Constructors
	public Item(String name, Long itemPrice, Long quantity) {
		super();
		this.itemName = name;
		this.itemPrice = itemPrice;
		this.itemQuantity = quantity;
	}
	
	public Item(Long id, String name, Long price, Long quantity) {
		super();
		this.id = id;
		this.itemName = name;
		this.itemPrice = price;
		this.itemQuantity = quantity;
	}

	
	// Getters & Setters		
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String name) {
		this.itemName = name;
	}


	public Long getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(Long price) {
		this.itemPrice = price;
	}
	
	public Long getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Long quantity) {
		this.itemQuantity = quantity;
	}


	@Override
	public String toString() {
		return "Item ID: " + id + ", item name:" + itemName + ", item price: " + itemPrice + ", quantity of the item: " + itemQuantity;
	}


	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Item other = (Item) obj;
//		if (itemName == null) {
//			if (other.itemName != null)
//				return false;
//		} else if (!itemName.equals(other.itemName))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (itemPrice == null) {
//			if (other.itemPrice != null)
//				return false;
//		} else if (!itemPrice.equals(other.itemPrice))
//			return false;
//		if (itemQuantity == null) {
//			if (other.itemQuantity != null)
//				return false;
//		} else if (!itemQuantity.equals(other.itemQuantity))
//			return false;
//		return true;
//	}

	

}