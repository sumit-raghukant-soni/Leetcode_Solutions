
SELECT d.name AS department, e.name AS employee, e.salary 
    FROM employee e, department d WHERE d.id = e.departmentid 
        AND 
    (departmentid, salary) 
        IN 
    (SELECT departmentid, salary FROM (SELECT *, row_number() OVER (partition by departmentid ORDER BY salary DESC) as seq FROM employee GROUP BY departmentid, salary) tab WHERE seq <= 3);