
SELECT p.product_id, p.new_price AS price 
FROM (SELECT * FROM products WHERE change_date <= '2019-08-16') p LEFT JOIN (SELECT * FROM products WHERE change_date <= '2019-08-16') p2 
ON p.product_id = p2.product_id AND p.change_date < p2.change_date WHERE p2.change_date IS NULL
GROUP BY product_id

UNION

SELECT product_id, 10 AS price FROM products WHERE product_id NOT IN (SELECT DISTINCT product_id FROM products WHERE change_date <= "2019-08-16")

ORDER BY product_id;