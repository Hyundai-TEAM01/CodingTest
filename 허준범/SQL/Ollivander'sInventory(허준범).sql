/*
https://bbeomgeun.tistory.com/66
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT W.id, WP.age, W.coins_needed, W.power
FROM Wands W, Wands_Property WP, (
    SELECT code, min(coins_needed) as coins_needed, power FROM
    Wands 
    GROUP BY (code, power)
) M
WHERE W.code = WP.code
AND W.code = M.code
AND WP.code = M.code
AND W.coins_needed = M.coins_needed
AND WP.is_evil = 0
ORDER BY W.power DESC, WP.age DESC;