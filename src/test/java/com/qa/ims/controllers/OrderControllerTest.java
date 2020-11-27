package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;

	
@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

		@Mock
		private OrderDAO orderDAO;
		
		@Mock
		private Utils utils;
		
		@InjectMocks
		private OrderController orderController;
		
		@Test
		public void testReadAll() {
			List<Order> orders = new ArrayList<>();
			orders.add(new Order(1l, 2l));
			orders.add(new Order(1l, 2l));
			when(orderDAO.readAll()).thenReturn(orders);
			
			assertEquals(orders, orderController.readAll());
			
			verify(orderDAO, times(1)).readAll();
		}
		
		@Test
		public void testCreate() {
			
			Long order_id = 2l;
			Long customer_id = 2l;
			
			Order created = new Order(order_id, customer_id);
			Order expected = new Order(order_id, customer_id);
			
			when(utils.getLong()).thenReturn(order_id);
			when(utils.getLong()).thenReturn(customer_id);
			when(orderDAO.create(created)).thenReturn(expected);
			
			assertEquals(expected, orderController.create());
			
			
			
			

		}
	}


