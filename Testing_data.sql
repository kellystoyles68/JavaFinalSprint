
INSERT INTO Users (username, password, email, role) VALUES
('buyer1', '$2a$10$7QS.W4NkjxHdWw.EkIsC6OCXQyeh8gYd2FbVSe9a0d0U4EQu4qEYq', 'buyer1@example.com', 'buyer'),
('seller1', '$2a$10$7QS.W4NkjxHdWw.EkIsC6OCXQyeh8gYd2FbVSe9a0d0U4EQu4qEYq', 'seller1@example.com', 'seller'),
('admin1', '$2a$10$7QS.W4NkjxHdWw.EkIsC6OCXQyeh8gYd2FbVSe9a0d0U4EQu4qEYq', 'admin1@example.com', 'admin');

INSERT INTO Products (name, price, quantity, seller_id) VALUES
('Product1', 10.00, 100, 2),
('Product2', 20.00, 200, 2);

