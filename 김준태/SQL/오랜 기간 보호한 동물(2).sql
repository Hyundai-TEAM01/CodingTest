SELECT ANIMAL_ID, NAME
    FROM (
        SELECT A.ANIMAL_ID, A.NAME, (B.DATETIME - A.DATETIME) AS DATETIME
        FROM ANIMAL_INS A
        JOIN ANIMAL_OUTS B
        ON A.ANIMAL_ID = B.ANIMAL_ID
        ORDER BY DATETIME DESC    
    )
    WHERE ROWNUM < 3
