ALTER TABLE deliveries
    ADD COLUMN store_id INT NOT NULL;
ALTER TABLE deliveries
    ADD COLUMN created_at TIMESTAMP DEFAULT now();
ALTER TABLE deliveries
    ADD COLUMN updated_at TIMESTAMP DEFAULT now();

ALTER TABLE IF EXISTS deliveries
    ADD CONSTRAINT fk_deliveries_stores FOREIGN KEY (store_id) REFERENCES stores;

CREATE TABLE shopping_carts
(
    id             SERIAL PRIMARY KEY,
    buyers_name    VARCHAR(100) NOT NULL,
    store_id       INT          NOT NULL,
    product_id     INT          NOT NULL,
    products_count INT          NOT NULL,
    created_at     TIMESTAMP DEFAULT now(),
    updated_at     TIMESTAMP DEFAULT now()
);
ALTER TABLE IF EXISTS shopping_carts
    ADD CONSTRAINT fk_shopping_carts_stores FOREIGN KEY (store_id) REFERENCES stores;

CREATE TABLE products_shopping_carts
(
    product_id       INT NOT NULL,
    shopping_cart_id INT NOT NULL,
    PRIMARY KEY (product_id, shopping_cart_id),
    FOREIGN KEY (product_id)
        REFERENCES products (id),
    FOREIGN KEY (shopping_cart_id)
        REFERENCES shopping_carts (id)
);
