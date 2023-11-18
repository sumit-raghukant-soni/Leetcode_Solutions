
SELECT requester_id AS id, COUNT(requester_id) AS num FROM 
        (SELECT accepter_id AS requester_id, requester_id AS accepter_id FROM requestaccepted
        UNION
        SELECT requester_id, accepter_id FROM requestaccepted) tab GROUP BY requester_id ORDER BY num DESC LIMIT 1;