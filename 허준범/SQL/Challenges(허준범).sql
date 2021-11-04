/*
https://www.hackerrank.com/challenges/challenges/problem
https://ysyblog.tistory.com/202
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT h.hacker_id, h.name, COUNT(*)
FROM Hackers h, Challenges c
WHERE h.hacker_id = c.hacker_id
GROUP BY (h.hacker_id, h.name)
HAVING COUNT(*) = (
    SELECT MAX(COUNT(*)) 
    FROM Challenges
    GROUP BY hacker_id
)
OR COUNT(*) IN (
    SELECT cnt 
    FROM (
        SELECT COUNT(*) cnt 
        FROM Challenges
        GROUP BY hacker_id
    )
    GROUP BY cnt
    HAVING COUNT(cnt) = 1
)
ORDER BY COUNT(*) DESC, h.hacker_id;