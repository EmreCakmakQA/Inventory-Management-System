package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
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
		items.add(new Item(1l, "cheese", 20l, 2l));
		when(itemDAO.readAll()).thenReturn(items);
		
		assertEquals(items, itemController.readAll());
		
		
	}
}
