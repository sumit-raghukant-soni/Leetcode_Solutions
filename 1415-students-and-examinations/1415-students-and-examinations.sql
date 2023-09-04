# Write your MySQL query statement below

SELECT s.student_id, s.student_name, k.subject_name, (SELECT COUNT(*) FROM examinations WHERE student_id = s.student_id AND subject_name = k.subject_name) as attended_exams
FROM students s CROSS JOIN subjects k
ORDER BY student_id, subject_name;