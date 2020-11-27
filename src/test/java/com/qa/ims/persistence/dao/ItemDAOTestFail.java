package com.qa.ims.persistence.dao;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTestFail {
	
	private ItemDAO itemDAO = new ItemDAO();
	
	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "fail");
	}
	
	@Before
	public void setup() {
			DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql"); //
		}
	
	@Test
	public void testCreate() {
		final Item created = new Item("spoon", 1L, 10L);
		
		assertEquals(created, itemDAO.create(created));
	}
	
	
	@Test
	public void testReadLatest() {
		assertEquals(new Item("spoon", 1L, 10L), itemDAO.readLatest());
	}
	
	@Test
	public void testReadAll() {
		assertEquals(new ArrayList<>(), itemDAO.readAll());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Item(ID, "Face Mask", 10l, 10l), itemDAO.readItem(ID));
	}
	
	@Test
	public void testUpdate() {
		final Item updated = new Item("Pizza", 1L, 3L);
		assertEquals(updated, itemDAO.update(updated));

	}
	
	@Test
	public void testDelete() {
		assertEquals(1, itemDAO.delete(1));
	}
	
	
	
	
	
	
}