USE shop_db;

DROP TABLE IF EXISTS products;

CREATE TABLE IF NOT EXISTS products
(id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
type VARCHAR NOT NULL,
model VARCHAR NOT NULL,
price DOUBLE NOT NULL,
amount INTEGER NOT NULL,
height DOUBLE NOT NULL,
power INTEGER NOT NULL,
-- TV
diagonal DOUBLE NULLABLE,
matrix_type DOUBLE,
operation_system VARCHAR,
-- Fridge
number_of_chambers INTEGER NULLABLE,
volume DOUBLE,
freshzone BOOLEAN,
-- Microwave
max_power DOUBLE,
auto_programs INTEGER,
grill BOOLEAN;

INSERT INTO products (type, model, price, amount, height, power, diagonal, matrix_type, operation_system,
number_of_chambers, volume, freshzone, max_power, auto_programs, grill) VALUES
('Fridge', 'Indesit ITR 5200 W', 28120, 3, 196, 379, null, null, null, 2, 325, false, null, null, null),
('TV', 'OLED LG OLED77C9P 77\" (2019)', 329995, 4, 1047, 175, 77, 'OLED', 'webOS', null, null, null, null, null, null),
('Microwave', 'LG MW-23R35GIH', 8720, 2, 27.2, 1000, null, null, null, null, 25, null, 1150, 0, false);

DROP TABLE IF EXISTS orders;

CREATE TABLE IF NOT EXISTS orders
(id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
name VARCHAR NOT NULL,
address VARCHAR NOT NULL,
summ DOUBLE);

INSERT INTO orders (name, address, summ) VALUES
('Vasya Pupkin', 'Lenina-23-41', 358115);

DROP TABLE IF EXISTS orders_products;

CREATE TABLE IF NOT EXISTS orders_products
(order_id INTEGER NOT NULL REFERENCES orders (id),
product_id INTEGER NOT NULL REFERENCES products (id),
amount INTEGER NOT NULL);

INSERT INTO orders_products (order_id, product_id, amount) VALUES
(1, 1, 1),
(1, 2, 1);

