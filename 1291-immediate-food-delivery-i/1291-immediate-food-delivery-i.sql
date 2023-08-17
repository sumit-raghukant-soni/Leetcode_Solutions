# Write your MySQL query statement below

SELECT 
    round(COUNT(*)/(SELECT COUNT(*) FROM delivery) * 100, 2) as immediate_percentage FROM (SELECT delivery_id FROM Delivery WHERE order_date = customer_pref_delivery_date) d;