package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private CustomerDAO customerDAO;
	private ItemDAO itemDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	@Override
	public Order create() {	
		List<Customer> customers = customerDAO.readAll();
		for (Customer customer : customers) {
			LOGGER.info(customer.toString());
		}
		LOGGER.info("Enter a customer ID: ");
		long customerID = utils.getLong();
		Order order = orderDAO.create(new Order(customerID));
		String response;
		do {
			List<Item> items = itemDAO.readAll();
			for(Item item:items) {
				LOGGER.info(item.toString());
			}
			LOGGER.info("Please enter the ID of the product");
			long itemID = utils.getLong();
			orderDAO.createLine(order.getId(), itemID);
			LOGGER.info("Would you like to add another item?");
			response = utils.getString();
		} while (response.toLowerCase().equals("yes"));
		order = orderDAO.readLatest();
		LOGGER.info("Order created");
		return order;
		
	}

	public Order update() {
		LOGGER.info("Enter an order ID: ");
		long id = utils.getLong();
		
		LOGGER.info("Enter a customer ID: ");
		long customerId = utils.getLong();
		
		Order order = orderDAO.update(new Order(id, customerId));
		
		LOGGER.info("Would you like to add to or delete items from this order?");
		String input = utils.getString();

		if (input.toLowerCase().equals("delete")) {
			LOGGER.info("Enter an item ID: ");
			Long itemId = utils.getLong();
			orderDAO.deleteLine(order.getId(), itemId);
			return order;
		} else if (input.toLowerCase().equals("add")) {
			LOGGER.info("Enter an item ID: ");
			Long itemId = utils.getLong();
			orderDAO.createItem(order.getId(), itemId);
			return order;
		} else {
			LOGGER.info("Invalid response, please enter add or delete");
		}
		return order;

	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		long id = utils.getLong();
		return orderDAO.delete(id);
	}

}