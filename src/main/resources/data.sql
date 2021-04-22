INSERT INTO BANKS (name) VALUES ('SABADELL'),
  ('CAIXA'),
  ('ING');
  
INSERT INTO CUSTOMERS (first_name, last_name, bank_id) VALUES ('Pepino', 'Verde', 1),
  ('Tomate', 'Rojo', 2),
  ('Patata', 'Blanka', 3);
 
INSERT INTO ACCOUNTS (account_number, balance, name, customer_id) VALUES('3CC3X2', 5000.00, 'clear pay account', 1), 
 ('2gu58d6', 1000.00, 'clear pay account -2', 2),
 ('C3X2gu58', 50.00, 'clear pay account -3', 3),
  ('95C3X2g', 10.00, 'clear pay account -4', 2);  
 
  
 INSERT INTO TRANSFERS (account_id, type) VALUES (1, 'INTRA'),
 (2, 'INTRA'),
 (3, 'INTRA'),
  (1, 'INTER'),
  (4, 'INTER');  
