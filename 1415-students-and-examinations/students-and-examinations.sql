SELECT std.student_id, std.student_name, std.subject_name
, IFNULL(cnt, 0) as attended_exams 

FROM 

(SELECT std.student_id, std.student_name, sub.subject_name FROM students as std CROSS JOIN subjects as sub) std

LEFT JOIN 

(SELECT student_id, subject_name, COUNT(subject_name) as cnt FROM examinations GROUP BY student_id, subject_name) as e
ON std.student_id = e.student_id AND std.subject_name = e.subject_name 

ORDER BY std.student_id, std.subject_name;