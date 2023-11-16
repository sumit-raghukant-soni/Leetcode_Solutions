
SELECT s.product_id, s.year AS first_year, quantity, price
    FROM sales s JOIN (SELECT MIN(year) year, product_id FROM sales GROUP BY product_id) tab
ON s.product_id = tab.product_id AND s.year = tab.year;