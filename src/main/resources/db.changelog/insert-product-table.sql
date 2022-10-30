INSERT INTO store_types (type_name, created_at) VALUES ('supermarket', now());
INSERT INTO brands (name, country_id, created_at) VALUES ('Sav', 1, now());
INSERT INTO categories (name, created_at) VALUES ('milk', now());
INSERT INTO products (name, description, brand_id, category_id, created_at) VALUES
                                                                                ('milk', 'good', 2, 2, now()),
                                                                                ('cake', '500 g.', 1, 1, now()),
                                                                                ('yogurt', '250 g.', 2, 2, now());
INSERT INTO stores (name, type_id, created_at) VALUES ('EVR', 2, now());
INSERT INTO deliveries (product_id, delivery_date, product_count, price, provider_id, store_id, created_at)
VALUES
    (2, '2022-11-03', 50, 3.65, 1, 2, now()),
    (3, '2022-11-03', 15, 8.65, 1, 2, now()),
    (4, '2022-11-03', 15, 4, 1, 1, now());