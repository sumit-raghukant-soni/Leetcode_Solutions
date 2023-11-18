
SELECT (CASE WHEN MOD((SELECT COUNT(*) FROM seat),2) = 1 AND (SELECT MAX(id) FROM seat) = id THEN id ELSE id+1 END) AS id, student FROM seat WHERE MOD(id,2) = 1

UNION

SELECT id-1 AS id, student FROM seat WHERE MOD(id,2) = 0

ORDER BY id ASC;