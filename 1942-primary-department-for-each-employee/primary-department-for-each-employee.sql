
SELECT employee_id, department_id FROM employee GROUP BY employee_id HAVING COUNT(*) = 1

UNION 

SELECT employee_id, department_id FROM employee WHERE primary_flag = 'Y';