/*
https://www.hackerrank.com/challenges/full-score/problem
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT H.hacker_id, H.name
FROM Hackers H, Challenges C, Difficulty D, Submissions S
WHERE H.hacker_id = S.hacker_id
AND C.challenge_id = S.challenge_id
AND C.difficulty_level = D.difficulty_level
AND S.score = D.score
GROUP BY (H.hacker_id, H.name)
HAVING COUNT(H.hacker_id) > 1
ORDER BY COUNT(c.challenge_id) DESC, H.hacker_id;