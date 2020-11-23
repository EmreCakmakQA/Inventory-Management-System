package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class IMS {

	public static final Logger LOGGER = LogManager.getLogger();

	private final CustomerController customers;
	private final Utils utils;

	public IMS() {
		this.utils = new Utils();
		final ItemDAO custDAO = new ItemDAO();
		this.customers = new CustomerController(custDAO, utils);
	}

	public void imsSystem() {
		LOGGER.info("What is your username");
		String username = utils.getString();
		LOGGER.info("What is your password");
		String password = utils.getString();

		DBUtils.connect(username, password);
		Domain domain = null;
		do {
			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			domain = Domain.getDomain(utils);
			boolean changeDomain = false;
			do {

				CrudController<?> active = null;
				switch (domain) {
				case CUSTOMER:
					active = this.customers;
					break;
				case ITEM:
					active = null;
					break;
				case ORDER:
					active = null;
					break;
				case STOP:
					return;
				default:
					break;
				}

				LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");

				Action.printActions();
				Action action = Action.getAction(utils);

				if (action == Action.RETURN) {
					changeDomain = true;
				} else {
					doAction(active, action);
				}
			} while (!changeDomain);
		} while (domain != Domain.STOP);
	}

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}

}