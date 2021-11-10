-- INS = ANIMAL_INS
-- OUTS = ANIMAL_OUTS
SELECT INS.ANIMAL_ID, INS.ANIMAL_TYPE, INS.NAME
    FROM (SELECT ANIMAL_ID, ANIMAL_TYPE, NAME
            FROM ANIMAL_INS
            WHERE SEX_UPON_INTAKE LIKE 'Intact%') INS
    LEFT JOIN ANIMAL_OUTS OUTS
    ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
    WHERE OUTS.SEX_UPON_OUTCOME NOT LIKE 'Intact%'
    ORDER BY INS.ANIMAL_ID
------------------------------------------------------
SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
    FROM (SELECT ANIMAL_ID, ANIMAL_TYPE, NAME
            FROM ANIMAL_INS
            WHERE SEX_UPON_INTAKE LIKE ('Intact%')) A
    JOIN (SELECT ANIMAL_ID
            FROM ANIMAL_OUTS
            WHERE SEX_UPON_OUTCOME NOT LIKE ('Intact%')) B
    ON A.ANIMAL_ID = B.ANIMAL_ID;
