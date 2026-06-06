USE store;
CREATE TABLE IF NOT EXISTS user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    resource_id VARCHAR(50) NOT NULL DEFAULT (UUID()),
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL
);

INSERT INTO store.user (name, age)
VALUES
    ('Juan Soto', 20),
    ('Gabriela Porras', 28),
    ('Joel López', 18),
    ('Maria Pérez', 30);

SELECT * FROM store.user