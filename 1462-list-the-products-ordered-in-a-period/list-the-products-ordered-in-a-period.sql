
SELECT product_name, SUM(unit) AS unit FROM products p, (SELECT * FROM orders WHERE order_date BETWEEN '2020-02-01' AND  '2020-02-29') o 
        WHERE p.product_id = o.product_id
        GROUP BY o.product_id HAVING SUM(unit) >= 100;