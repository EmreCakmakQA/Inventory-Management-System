package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

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
	public void testCreate() {
		final Item created = new Item("Bacon", 3L, 50l);
		assertEquals(created, itemDAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item("PS5", 1L, 20l));
		expected.add(new Item("Laptop", 2L, 10l));
		assertEquals(expected, itemDAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Item("Laptop", 2L, 10l), itemDAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Item("PS5", ID, 20l), itemDAO.readItem(ID));
	}

	@Test
	public void testUpdate() {
		final Item updated = new Item("Iphone", 10L, 350l);
		assertEquals(updated, itemDAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, itemDAO.delete(2));
	}
	
}