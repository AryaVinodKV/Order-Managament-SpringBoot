ALTER TABLE oms.order_items ADD CONSTRAINT FK_ORDERITEMS_ON_ORDER FOREIGN KEY (order_id) REFERENCES oms.orders (id);
ALTER TABLE oms.order_items ADD CONSTRAINT FK_ORDERITEMS_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES oms.products (id);