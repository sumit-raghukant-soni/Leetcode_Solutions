
SELECT person_name FROM 
(SELECT *, SUM(weight) OVER(ORDER BY turn) AS CF FROM queue) 
tab WHERE CF <= 1000 ORDER BY turn DESC LIMIT 1;