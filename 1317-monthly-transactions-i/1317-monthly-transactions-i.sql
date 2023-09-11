# Write your MySQL query statement below


SELECT 
  DATE_FORMAT(trans_date, "%Y-%m") as month, 
  country, 
  COUNT(*) as trans_count, 
  IFNULL(COUNT(IF(state = "approved", 1, NULL)), 0) as approved_count,
  SUM(amount) as trans_total_amount,
  IFNULL(SUM(IF(state = "approved", amount, NULL)), 0) as approved_total_amount
FROM transactions GROUP BY DATE_FORMAT(trans_date, "%Y-%m"), country;