# Write your MySQL query statement below

SELECT name, bonus FROM (SELECT name, bonus FROM employee e LEFT JOIN bonus b ON e.empid = b.empid) d WHERE d.bonus < 1000 || d.bonus IS NULL;