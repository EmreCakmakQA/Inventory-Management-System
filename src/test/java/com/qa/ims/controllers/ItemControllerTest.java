package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;


@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	@Mock
	private ItemDAO itemDAO;
	
	@Mock
	private Utils utils;
	
	@InjectMocks
	private ItemController itemController;
	
	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1l, "spoon", 1l, 10l));
		items.add(new Item(2l, "cheese", 20l, 2l));
		when(itemDAO.readAll()).thenReturn(items);
		
		assertEquals(items, itemController.readAll());
		
		verify(itemDAO, times(1)).readAll();
	}
	
	@Test
	public void testCreate() {
		
		String name = "Jacket";
		Long price = 30l;
		Long quantity = 10l;
		Item created = new Item(name, price, quantity);
		Item expected = new Item(3l, name, price, quantity);
		
		when(utils.getString()).thenReturn(name);
		when(utils.getLong()).thenReturn(price);
		when(utils.getLong()).thenReturn(quantity);
		when(itemDAO.create(created)).thenReturn(expected);
		
		assertEquals(expected, itemController.create());
		
		
		
		

	}
}

	
	

