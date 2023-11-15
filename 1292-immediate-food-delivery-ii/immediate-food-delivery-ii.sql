# Write your MySQL query statement below

SELECT ROUND(AVG(q) * 100, 2) AS immediate_percentage FROM (SELECT MIN(order_date) = MIN(customer_pref_delivery_date) AS q FROM delivery
 GROUP BY customer_id 
 ORDER BY order_date) d;