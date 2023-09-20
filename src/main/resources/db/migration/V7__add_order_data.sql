INSERT INTO oms.orders (customer_id, total_quantity, total_price)
    VALUES
        (1, 4, 50),
        (2, 4, 40);

INSERT INTO oms.order_items (product_id, quantity, price, row_total, order_id)
    VALUES
        (1, 2, 40, 30, 1),
        (2, 2, 40, 30, 2);