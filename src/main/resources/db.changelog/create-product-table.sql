ALTER TABLE deliveries ADD COLUMN store_id INT NOT NULL;
ALTER TABLE deliveries ADD COLUMN created_at TIMESTAMP DEFAULT now();
ALTER TABLE deliveries ADD COLUMN updated_at TIMESTAMP DEFAULT now();

ALTER TABLE IF EXISTS deliveries
    ADD CONSTRAINT fk_deliveries_stores FOREIGN KEY (store_id) REFERENCES stores;

INSERT INTO store_types (type_name, created_at) VALUES ('supermarket', now());
INSERT INTO brands (name, country_id, created_at) VALUES ('Sav', 1, now());
INSERT INTO categories (name, created_at) VALUES ('milk', now());
-- INSERT INTO products (name, description, brand_id, category_id, created_at) VALUES ('milk', "good", 2, 2, now());
-- INSERT INTO stores (name, type_id, created_at) VALUES ('EVR', 2, now());


