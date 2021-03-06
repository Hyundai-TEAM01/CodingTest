SELECT A.HACKER_ID, A.NAME, B.SCORE
    FROM HACKERS A
    JOIN (
        SELECT HACKER_ID, SUM(SCORE) AS SCORE
            FROM (
                SELECT HACKER_ID, MAX(SCORE) AS SCORE
                    FROM SUBMISSIONS
                    GROUP BY HACKER_ID, CHALLENGE_ID
            )
            GROUP BY HACKER_ID
            HAVING SUM(SCORE) > 0
    ) B
    ON A.HACKER_ID = B.HACKER_ID
    ORDER BY B.SCORE DESC, A.HACKER_ID;
