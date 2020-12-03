package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTestFail {

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
		Order order = new Order(1l,1l);
		assertNull(orderDAO.create(order));

	}

	@Test
	public void testReadAll() {
		final List <Order> item = new ArrayList<>();
		assertEquals(item, orderDAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
		final List<Order> order = new ArrayList<>();
		assertEquals(order, orderDAO.readAll());
	}

	@Test
	public void testReadOrder()
	{
		assertNull(orderDAO.readOrder(1L));

	}

	@Test
	public void testGetCustomerOrder()
	{
		assertNull(orderDAO.getCustomerOrder(1L));

	}
	
	@Test
	public void testCreateItem()
	{
		assertNull(orderDAO.createItem(1L,1L));

	}
	
	@Test
	public void testReadCustomer()
	{
		assertNull(orderDAO.readLatest());
	}
	
	@Test
	public void testReadLines()
	{
		assertNull(orderDAO.readLines(1L));
	}
	
	@Test
	public void testUpdate()
	{
		Order order = new Order(1l,1l);
		assertNull(orderDAO.update(order));
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
	public void testDeleteOrderLines()
	{
		assertEquals(0, orderDAO.deleteOrderLines(0));
	}

	@Test
	public void testDeleteItem()
	{

		assertEquals(0, orderDAO.deleteLine(1L,1L));
	}
	
	@Test
	public void testDeleteItemFromAll()
	{
		assertEquals(0, orderDAO.deleteItemFromAll(1L));
	}
	
}