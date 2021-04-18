create schema if not exists belong;

DROP TABLE IF EXISTS belong.customer;
DROP TABLE IF EXISTS belong.customer_phone;

CREATE TABLE belong.customer (
  customer_id bigint AUTO_INCREMENT NOT NULL PRIMARY KEY,
  customer_name varchar(255) NOT NULL,
  address varchar(255) NOT NULL,
  suburb varchar(255) NOT NULL,
  postcode varchar(20) NOT NULL,
  state varchar (50) NOT NULL,
  email varchar(100) NOT NULL
);

INSERT INTO belong.customer (customer_name, address, suburb, postcode, state, email) VALUES('customer1', 'address1', 'Melbourne', '3000', 'Victoria', 'customer1@gmail.com');
INSERT INTO belong.customer (customer_name, address, suburb, postcode, state, email) VALUES('customer2', 'address2', 'Newport', '3025', 'Victoria', 'customer2@gmail.com');
INSERT INTO belong.customer (customer_name, address, suburb, postcode, state, email) VALUES('customer3', 'address3', 'Tarneit', '3029', 'Victoria', 'customer3@gmail.com');
INSERT INTO belong.customer (customer_name, address, suburb, postcode, state, email) VALUES('customer4', 'address4', 'Point Cook', '3027', 'Victoria', 'customer4@gmail.com');
INSERT INTO belong.customer (customer_name, address, suburb, postcode, state, email) VALUES('customer5', 'address5', 'Melbourne', '3000', 'Victoria', 'customer5@gmail.com');



CREATE TABLE belong.customer_phone (
  customer_phone_id bigint AUTO_INCREMENT NOT NULL PRIMARY KEY,
  customer_id bigint NOT NULL,
  phone_number varchar(255) NOT NULL,
  active Boolean NOT NULL,
  foreign key (customer_id) references  belong.customer(customer_id)
);


INSERT INTO belong.customer_phone (customer_id, phone_number, active) values (Select customer_id from belong.customer where customer_name = 'customer1', '124567890', true);
INSERT INTO belong.customer_phone (customer_id, phone_number, active) values (Select customer_id from belong.customer where customer_name = 'customer1', '234567823', true);
INSERT INTO belong.customer_phone (customer_id, phone_number, active) values (Select customer_id from belong.customer where customer_name = 'customer1', '456789003', false);
INSERT INTO belong.customer_phone (customer_id, phone_number, active) values (Select customer_id from belong.customer where customer_name = 'customer2', '567890122', true);
INSERT INTO belong.customer_phone (customer_id, phone_number, active) values (Select customer_id from belong.customer where customer_name = 'customer2', '123213321', false);
INSERT INTO belong.customer_phone (customer_id, phone_number, active) values (Select customer_id from belong.customer where customer_name = 'customer2', '567567556', false);
INSERT INTO belong.customer_phone (customer_id, phone_number, active) values (Select customer_id from belong.customer where customer_name = 'customer3', '135432323', true);
INSERT INTO belong.customer_phone (customer_id, phone_number, active) values (Select customer_id from belong.customer where customer_name = 'customer3', '797895673', false);
INSERT INTO belong.customer_phone (customer_id, phone_number, active) values (Select customer_id from belong.customer where customer_name = 'customer3', '4565465443', true);
INSERT INTO belong.customer_phone (customer_id, phone_number, active) values (Select customer_id from belong.customer where customer_name = 'customer4', '232234234', false);
INSERT INTO belong.customer_phone (customer_id, phone_number, active) values (Select customer_id from belong.customer where customer_name = 'customer4', '09786543243', true);
INSERT INTO belong.customer_phone (customer_id, phone_number, active) values (Select customer_id from belong.customer where customer_name = 'customer4', '890567345', false);
INSERT INTO belong.customer_phone (customer_id, phone_number, active) values (Select customer_id from belong.customer where customer_name = 'customer5', '456892323', true);

--INSERT INTO belong.customer_transaction (customer_number, customer_name, value_date, currency, debit_amount, credit_amount, transaction_type, tran_narrative) values ('123456', 'SGSavings 726', CURRENT_DATE, 'SGD', 12.45, NULL, 'CREDIT', 'TestCheck');
--INSERT INTO belong.customer_transaction (customer_number, customer_name, value_date, currency, debit_amount, credit_amount, transaction_type, tran_narrative) values ('123456', 'SGSavings 726', CURRENT_DATE, 'SGD', 12.45, NULL, 'CREDIT', 'TestCheck');
--INSERT INTO belong.customer_transaction (customer_number, customer_name, value_date, currency, debit_amount, credit_amount, transaction_type, tran_narrative) values ('123456', 'SGSavings 726', CURRENT_DATE, 'SGD', 12.45, NULL, 'CREDIT', 'TestCheck');
--INSERT INTO belong.customer_transaction (customer_number, customer_name, value_date, currency, debit_amount, credit_amount, transaction_type, tran_narrative) values ('123456', 'SGSavings 726', CURRENT_DATE, 'SGD', 12.45, NULL, 'CREDIT', 'TestCheck');

COMMIT;