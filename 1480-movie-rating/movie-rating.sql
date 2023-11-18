
(SELECT name AS results FROM movierating mr, users u WHERE mr.user_id = u.user_id GROUP BY mr.user_id ORDER BY COUNT(DISTINCT movie_id) DESC, name ASC LIMIT 1)

UNION ALL

(SELECT title FROM movierating mr, movies m 
        WHERE created_at LIKE ('2020-02%') AND mr.movie_id = m.movie_id 
        GROUP BY mr.movie_id 
        ORDER BY AVG(rating) DESC, title ASC
        LIMIT 1)

# AS results;