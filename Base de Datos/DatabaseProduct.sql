CREATE DATABASE IF NOT EXISTS store;
USE store;

CREATE TABLE product (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    price DECIMAL(10,2) NOT NULL
);
INSERT INTO store.product (nombre, descripcion, price)
VALUES
    ('Laptop', 'Laptop para desarrollo', 850.00),
    ('Teclado', 'Teclado mecánico', 70.99);

SELECT * FROM store.product;