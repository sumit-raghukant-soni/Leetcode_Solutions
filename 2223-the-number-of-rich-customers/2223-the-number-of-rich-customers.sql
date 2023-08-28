# Write your MySQL query statement below

SELECT COUNT(*) as rich_count FROM (SELECT customer_id as rich_count FROM store GROUP BY customer_id HAVING MAX(amount) > 500) as t;