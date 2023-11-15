# Write your MySQL query statement below

SELECT e.name FROM employee e JOIN employee e2 
    ON 
        e.id = e2.managerid
        GROUP BY e.id HAVING COUNT(e.id) >= 5;