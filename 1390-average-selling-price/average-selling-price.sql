# Write your MySQL query statement below

SELECT p.product_id, IFNULL(ROUND(SUM(units * price)/ SUM(units), 2), 0) as average_price
    FROM unitssold us 
        RIGHT JOIN prices p ON purchase_date BETWEEN start_date AND end_date 
                AND us.product_id = p.product_id GROUP BY p.product_id;