
SELECT IFNULL(MAX(num), null) AS num FROM (SELECT * FROM MyNumbers GROUP BY num HAVING COUNT(num) = 1) tab;