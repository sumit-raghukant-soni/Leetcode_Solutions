
SELECT *, (IF(x+y <= z OR y+z <= x OR z+x <= y, "No", "Yes")) AS triangle FROM triangle;