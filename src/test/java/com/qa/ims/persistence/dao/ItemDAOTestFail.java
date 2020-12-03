package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTestFail {

	
	private final ItemDAO itemDAO = new ItemDAO();
	
	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate()
	{
		Item item = new Item("PS5",1l, 20l);
		assertNull(itemDAO.create(item));
	}
	
	@Test
	public void testReadAll()
	{
		List<Item> item = new ArrayList<>();
		
		assertEquals(item,itemDAO.readAll());
	}
	
	@Test
	public void testReadLatest()
	{		
		assertNull(itemDAO.readLatest());
	}
	
	@Test
	public void testReadItem()
	{		
		assertNull(itemDAO.readItem(4L));
	}
	
	@Test
	public void testUpdate()
	{		
		Item item = new Item("Bacon", 1L, 2L);
		assertNull(itemDAO.update(item));
	}
	
	@Test
	public void testDelete()
	{		
		assertEquals(0,itemDAO.delete(1l));
	}
}