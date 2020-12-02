INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Emre', 'Cakmak');

INSERT INTO `ims`.`item` (`itemName`, `itemPrice`,`itemQuantity`) VALUES ('spoon', 1, 10);
INSERT INTO `ims`.`item` (`itemName`, `itemPrice`,`itemQuantity`) VALUES ('cheese', 20, 2);

INSERT INTO `ims`.`orders` (`order_id`, `customer_id`) VALUES ('1');
INSERT INTO `ims`.`orders_items` (`fk_order_id`, `fk_item_id`) VALUES ('1','1');



