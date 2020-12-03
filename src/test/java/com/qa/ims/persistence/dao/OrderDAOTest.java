package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO orderDAO = new OrderDAO();

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final List <Item> item = new ArrayList<>();
		final Order created = new Order(2l, 1l, item, 0L);
		assertEquals(created, orderDAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		final List <Item> item = new ArrayList<>();
		Item items = new Item("PS5", 1L, 20L);
		item.add(items);
		expected.add(new Order(1L, 1L, item, 20L));
		assertEquals(expected, orderDAO.readAll());
	}

	@Test
	public void testReadOrder()
	{
		final long ID = 1L;
		final List <Item> item = new ArrayList<>();
		Item items = new Item("PS5", 1L, 20L);
		item.add(items);
		assertEquals(new Order(1L, 1L, item, 20L), orderDAO.readOrder(ID));
	}

	@Test
	public void testGetCustomerOrder()
	{
		List<Order> expected = new ArrayList<>();
		final long ID = 1L;
		final List <Item> item = new ArrayList<>();
		Item items = new Item("PS5", 1L, 20L);
		item.add(items);
		expected.add(new Order(1L, 1L, item, 20L));
		assertEquals(expected, orderDAO.getCustomerOrder(ID));
	}
	
	@Test
	public void testCreateItem()
	{
		final long ID = 1L;
		final List <Item> item = new ArrayList<>();
		Item items = new Item("PS5", 1L, 20L);
		item.add(items);
		item.add(items);
		assertEquals(new Order(1L, 1L, item, 20L), orderDAO.createItem(ID,1L));
	}
	
	@Test
	public void testReadCustomer()
	{
		final long ID = 1L;
		final List <Item> item = new ArrayList<>();
		Item items = new Item("PS5", 1L, 20L);
		item.add(items);
		assertEquals(new Order(1L, 1L, item, 20L), orderDAO.readOrder(ID));
	}
	
	@Test
	public void testUpdate()
	{
		final List <Item> item = new ArrayList<>();
		Item items = new Item("PS5", 1L, 20L);
		item.add(items);
		Order expected = new Order(1L, 2L, item, 20L);
		assertEquals(expected, orderDAO.update(expected));
	}
	
	@Test
	public void testDelete()
	{
		assertEquals(0, orderDAO.delete(1L));
	}
	
	@Test
	public void testDeleteCustomer()
	{
		assertEquals(0, orderDAO.deleteCustomer(1L));
	}
	
	@Test
	public void testDeleteOrderlines()
	{

		assertEquals(1, orderDAO.deleteOrderLines(1L));
	}

	@Test
	public void testDeleteLine()
	{

		assertEquals(1, orderDAO.deleteLine(1L,1L));
	}
	
	@Test
	public void testDeleteItemFromAll()
	{
		assertEquals(1, orderDAO.deleteItemFromAll(1L));
	}
}