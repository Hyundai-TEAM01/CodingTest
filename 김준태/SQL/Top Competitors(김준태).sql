SELECT A.HACKER_ID, B.NAME
    FROM (
        SELECT SUB.HACKER_ID AS HACKER_ID, COUNT(*) AS CHALNUM
            FROM SUBMISSIONS SUB
            JOIN CHALLENGES CHAL
            ON SUB.CHALLENGE_ID = CHAL.CHALLENGE_ID
            JOIN DIFFICULTY DIFF
            ON CHAL.DIFFICULTY_LEVEL = DIFF.DIFFICULTY_LEVEL
            WHERE SUB.SCORE = DIFF.SCORE
            GROUP BY SUB.HACKER_ID
            HAVING COUNT(*) > 1
    ) A
    JOIN HACKERS B
    ON A.HACKER_ID = B.HACKER_ID
    ORDER BY A.CHALNUM DESC, A.HACKER_ID;
