ALTER TABLE Products DROP CONSTRAINT products_seller_id_fkey;

ALTER TABLE Products
ADD CONSTRAINT products_seller_id_fkey
FOREIGN KEY (seller_id)
REFERENCES Users (id)
ON DELETE CASCADE;