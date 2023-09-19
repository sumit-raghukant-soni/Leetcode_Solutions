# Write your MySQL query statement below



SELECT machine_id, ROUND(SUM(IF(activity_type = "start", timestamp*-1, timestamp))/(COUNT(*)/2), 3) as processing_time FROM activity GROUP BY machine_id;