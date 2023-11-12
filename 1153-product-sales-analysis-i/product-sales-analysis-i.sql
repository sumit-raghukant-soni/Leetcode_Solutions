# Write your MySQL query statement below


SELECT product_name, year, price FROM Sales LEFT JOIN Product ON Product.product_id = Sales.product_id;