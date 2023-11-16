
# SELECT ROUND(AVG(tab.rate), 2) as fraction FROM (SELECT 
#     # player_id, MIN(event_date) as mnt
#     # , DATE_ADD(MIN(event_date), INTERVAL 1 DAY) , 
#     IF(DATEDIFF((SELECT MIN(b.event_date) as smnt FROM activity b WHERE b.event_date > a.event_date AND b.player_id = a.player_id), a.event_date) = 1, 1, 0) as rate
# FROM activity a GROUP BY player_id) tab;

SELECT ROUND(AVG(tab.rate), 2) AS fraction FROM (SELECT a.player_id, MIN(a.event_date), MIN(b.event_date), IF(DATEDIFF(MIN(b.event_date), MIN(a.event_date)) = 1, 1, 0) AS rate FROM activity a LEFT JOIN activity b 
   ON a.player_id = b.player_id 
   AND a.event_date < b.event_date
   GROUP BY a.player_id) tab;