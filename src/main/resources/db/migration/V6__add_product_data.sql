--INSERT INTO oms.category (id, name, parent_category)
--    VALUES
--        (1, 'FMCG',NULL),
--        (2, 'SOFT DRINK', 1),
--        (3, 'CARBONATED DRINK',2);
--
--INSERT INTO oms.customers(name,phone,email,street,city,state,profile_pic_url)
--    VALUES
--        ('Raju','1234567899','raju@abc.com','PQ','TVM','TU',''),
--        ('John','1234567889','johnabc.com','TQ','Kochi','TK','');

INSERT INTO oms.products(name,description,unit_price,category_id)
    VALUES
        ('Pepsi','Pepsi',60, 1),
        ('Maggi','Maggi',25, 1),
        ('Pepsi', 'Pepsi', 50, 3),
        ('Slice', 'Slice', 53, 2);
