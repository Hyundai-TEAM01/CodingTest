/*
https://www.hackerrank.com/challenges/the-report/problem
참고
https://mirwebma.tistory.com/17
https://gent.tistory.com/311
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT CASE WHEN grade >= 8 THEN name
            ELSE 'NULL' END AS name, grade, marks
FROM Students, Grades
WHERE Students.marks >= Grades.Min_Mark
AND Students.marks <= Grades.Max_Mark
ORDER BY grade DESC, name;