# Write your MySQL query statement below

SELECT id FROM (SELECT id, recordDate, temperature, LAG(temperature, 1, NULL) OVER(order by recordDate) tmp, LAG(recordDate, 1, NULL) OVER(order by recordDate) dt FROM Weather) w WHERE temperature > tmp AND DATEDIFF(recordDate, dt) = 1;