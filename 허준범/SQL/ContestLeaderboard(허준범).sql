/*
https://www.hackerrank.com/challenges/contest-leaderboard/problem
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT hacker_id, name, SUM(score)
FROM (
    SELECT S.hacker_id AS hacker_id, H.name AS name, MAX(S.score) AS score
    FROM Submissions S, Hackers H
    WHERE S.hacker_id = H.hacker_id
    GROUP BY (S.hacker_id, H.name, S.challenge_id)
)
GROUP BY (hacker_id, name)
HAVING SUM(score) != 0
ORDER BY SUM(score) DESC, hacker_id;
 