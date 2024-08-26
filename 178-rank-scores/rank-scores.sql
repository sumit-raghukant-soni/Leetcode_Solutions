/* Write your T-SQL query statement below */

SELECT s1.score, s2.rank FROM scores s1 JOIN (select score, ROW_NUMBER() Over (ORDER BY score DESC) AS rank FROM Scores GROUP BY score) s2 ON s1.score = s2.score ORDER BY s1.score DESC;