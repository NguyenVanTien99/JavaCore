CREATE DATABASE As_1001;

USE As_1001;

CREATE TABLE Customer (
	customer_id int PRIMARY KEY,
	customer_name varchar(255)
)

CREATE TABLE Employee  (
	employee_id int PRIMARY KEY,
	customer_name varchar(255),
	salary float(53),
	supervisor_id varchar(255)
)

CREATE TABLE Product   (
	product_id int PRIMARY KEY,
	product_name varchar(255),
	list_price float(53)
)

CREATE TABLE Orders    (
	order_id int PRIMARY KEY,
	order_date date,
	customer_id int,
	employee_id int,
	total float(53)

	CONSTRAINT FK_OrdersCustomer FOREIGN KEY (customer_id)
	REFERENCES Customer(customer_id),

	CONSTRAINT FK_OrdersEmployee FOREIGN KEY (employee_id)
	REFERENCES Employee(employee_id)
)

CREATE TABLE LineItem (
	order_id int,
	product_id int,
	quantity int,
	price float(53)

	PRIMARY KEY (order_id, product_id)

	CONSTRAINT FK_LineItemProduct FOREIGN KEY (product_id)
	REFERENCES Product(product_id),
	 
    CONSTRAINT FK_LineItemOrder FOREIGN KEY (order_id)
	REFERENCES Orders(order_id)
)
//-------------------------
SELECT * FROM Orders Where customer_id = 2

SELECT * FROM LineItem where order_id = 1

SELECT SUM(quantity * price) as total_price FROM LineItem where order_id = 1
GROUP BY order_id
----------------------------------------------
GO
CREATE PROCEDURE PROCEDURE_CustomerInsert(
	@customer_id int,
	@customer_name varchar(255),
	@status VARCHAR(10) OUTPUT
	
)
AS
BEGIN
	INSERT INTO Customer
	VALUES (@customer_id,@customer_name)

	IF(@@ROWCOUNT > 0 )
	BEGIN
	SET @status = 'success';
	END
	ELSE
	BEGIN
	SET @status = 'fail';
	END

END
GO
----------------------------------------------
GO
CREATE PROCEDURE PROCEDURE_CustomerUpdate(
	@customer_id int,
	@customer_name varchar(255),
	@status1 VARCHAR(10) OUTPUT
)
AS
BEGIN
	UPDATE Customer
	SET
		customer_name = @customer_name
	WHERE customer_id = @customer_id

	IF(@@ROWCOUNT > 0 )
	BEGIN
	SET @status1 = 'success';
	END
	ELSE
	BEGIN
	SET @status1 = 'fail';
	END
END
GO
----------------------------------------------
GO
CREATE PROCEDURE PROCEDURE_CustomerDelete(
	@customer_id int,
	@status2 VARCHAR(10) OUTPUT
)
AS
BEGIN
	IF EXISTS (SELECT * FROM LineItem WHERE order_id IN (SELECT order_id FROM Orders WHERE customer_id = @customer_id))
	DELETE FROM LineItem WHERE order_id IN (SELECT order_id FROM Orders WHERE customer_id = @customer_id)
	IF EXISTS (SELECT * FROM Orders WHERE customer_id = @customer_id)
	DELETE FROM Orders WHERE customer_id = @customer_id
	DELETE FROM Customer WHERE customer_id = @customer_id

	IF(@@ROWCOUNT > 0 )
	BEGIN
	SET @status2 = 'success';
	END
	ELSE
	BEGIN
	SET @status2 = 'fail';
	END
END
GO
----------------------------------------------

EXEC PROCEDURE_CustomerUpdate 17,"Trung2",null

SELECT c.customer_id,c.customer_name FROM Customer c WHERE c.customer_id IN (SELECT customer_id FROM Orders) 

	UPDATE Customer
	SET
		customer_name = 'tttt'
	WHERE customer_id = 17

----------------------------------------------
IF EXISTS (SELECT * FROM LineItem WHERE order_id IN (SELECT order_id FROM Orders WHERE customer_id = 1))
DELETE FROM LineItem WHERE order_id IN (SELECT order_id FROM Orders WHERE customer_id = 1)
IF EXISTS (SELECT * FROM Orders WHERE customer_id = 1)
DELETE FROM Orders WHERE customer_id = 1
DELETE FROM Customer WHERE customer_id = 1
SELECT @@ROWCOUNT

INSERT INTO Orders
VALUES (?,?,?,?,?)