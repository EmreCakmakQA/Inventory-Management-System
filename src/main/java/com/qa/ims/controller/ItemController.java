package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemDAO;
	private OrderDAO orderDAO = new OrderDAO();
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}
	

	/**
	 * Creates an item by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter an item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter an item price");
		Long itemPrice = utils.getLong();
		LOGGER.info("Please enter a quantity of stock");
		Long quantity = utils.getLong();
		Item item = itemDAO.create(new Item(itemName, itemPrice, quantity));
		LOGGER.info("Item created");
		return item;
	}

	/**
	 * Updates an existing item by taking in user input
	 */
	@Override
	public Item update() {
		Long id = null;
		Item current = null;
		do {
			LOGGER.info("Please enter the id of the item you would like to update");
			id = utils.getLong();
			current = itemDAO.readItem(id);
		} while (current == null);
		LOGGER.info(current.toString());
		LOGGER.info("Please enter an item name");
		String itemName = utils.getString();
		LOGGER.info("Enter the item's price");
		Long itemPrice = utils.getLong();
		LOGGER.info("Enter the item's quantity of stock");
		Long itemQuantity = utils.getLong();
		Item item = itemDAO.update(new Item(id, itemName, itemPrice, itemQuantity));
		LOGGER.info("Item Updated");
		return item;
	}

	/**
	 * Deletes an existing item by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		orderDAO.deleteItemFromAll(id);
		return itemDAO.delete(id);
	}

}
