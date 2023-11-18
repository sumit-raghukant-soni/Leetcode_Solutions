SELECT 
        # IFNULL(
                (
                    SELECT salary FROM employee GROUP BY salary ORDER BY salary DESC
                 LIMIT 1 OFFSET 1)
                # , NULL) 
AS SecondHighestSalary;