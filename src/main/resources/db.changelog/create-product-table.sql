ALTER TABLE deliveries ADD COLUMN store_id INT NOT NULL;
ALTER TABLE deliveries ADD COLUMN created_at TIMESTAMP DEFAULT now();
ALTER TABLE deliveries ADD COLUMN updated_at TIMESTAMP DEFAULT now();

ALTER TABLE IF EXISTS deliveries
    ADD CONSTRAINT fk_deliveries_stores FOREIGN KEY (store_id) REFERENCES stores;