
SELECT e.reports_to AS employee_id
, b.name
, COUNT(e.reports_to) AS reports_count, ROUND(AVG(e.age), 0) AS average_age
FROM employees e, employees b 
WHERE e.reports_to IS NOT NULL AND b.employee_id = e.reports_to
GROUP BY e.reports_to ORDER BY e.reports_to;