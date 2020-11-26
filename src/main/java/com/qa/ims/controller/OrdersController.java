package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrdersController implements CrudController<Orders>{
	public static final Logger LOGGER = LogManager.getLogger();

	private OrdersDAO ordersDAO;
	private ItemDAO itemDAO;
	private CustomerDAO customerDAO;
	private Utils utils;

	public OrdersController(OrdersDAO ordersDAO, Utils utils) {
		super();
		this.ordersDAO = ordersDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Orders> readAll() {
		List<Orders> orders = ordersDAO.readAll();
		for (Orders order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Orders create() {
		List<Customer> customers = customerDAO.readAll();
		for(Customer customer: customers) {
			LOGGER.info(customer.toString());
		}
		LOGGER.info("Please enter the customer ID");
		Long customer_id = utils.getLong();
		Orders order = ordersDAO.create(new Orders(customer_id));
		String response;
		do {
			List<Item> items = itemDAO.readAll();
			for (Item item: items) {
				LOGGER.info(item.toString());
			}
			LOGGER.info("Enter the ID of the item you would like to add to your order");
			Long itemID = utils.getLong();
			ordersDAO.createItem(order.getOrder_id(), itemID);
			LOGGER.info("Would you like to add more items? yes/no");
			response = utils.getString();
		} while (response)
	
		
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Orders update() {
		Orders order;
		Orders itemOrder;
		Long orderID;
		Long customerID;
		boolean flag = true;
		while(flag) {
			LOGGER.info("Would you like to:\n(1) Update the order owner \n(2) Add an item to an order \n(3) Go back");
			String choice = utils.getString();
			switch(choice) {
			case "1":
				LOGGER.info("Please enter the Customer ID of the order you would like to update");
				customerID = utils.getLong();
				ordersDAO.update(new Orders(orderID, customerID));
				LOGGER.info("Item updated");
				break;
			case "2":
				itemDAO.readAll();
				LOGGER.info("Please enter the Order ID");
				Long orderID = utils.getLong();
				LOGGER.info("Please enter the Item ID");
				Long itemID = utils.getLong();
				ordersDAO.createLine(orderID, itemID);
			case "3":
				LOGGER.info("Going back \n\n\n");
				flag = false;
				order = ordersDAO.readOrder(id);
				return itemOrder;
				break;
			}
		}
		return null;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		boolean flag = true;
		while(flag) {
			LOGGER.info("Would you like to:\n(1) Remove an item from an order \n(3)Go back");
			String choice = utils.getString();
			switch(choice) {
			case "1":
				LOGGER.info("Please enter the ID of the order you would like to change");
				Long id = utils.getLong();
				LOGGER.info(ordersDAO.readLines(id));
				LOGGER.info("Please enter the ID of the item you would like to delete from your order");
				Long itemID = utils.getLong();
				return ordersDAO.removeItem(id, itemID);
				break;
			case "2":
				LOGGER.info("Please enter the ID of the order you would to delete");
				Long orderID = utils.getLong();
				return ordersDAO.delete(orderID);
				break;
			case "3":
				LOGGER.info("Going back \n\n\n");
				flag = false;
				break;
			}
			
		}
		return 0;
		
	}
}
