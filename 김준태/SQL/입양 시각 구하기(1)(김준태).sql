-- SELECT B.HH, COUNT(A.HOUR)
--     FROM (SELECT TO_CHAR(DATETIME, 'HH24') AS HOUR FROM ANIMAL_OUTS) A
--     JOIN (SELECT ROWNUM+8 AS HH FROM DUAL CONNECT BY LEVEL <=11) B
--     ON A.HOUR = B.HH
--     GROUP BY B.HH
--     ORDER BY B.HH

SELECT HOUR, COUNT(*)
    FROM (SELECT TO_CHAR(DATETIME, 'HH24') AS HOUR
          FROM ANIMAL_OUTS)
    WHERE HOUR BETWEEN 9 AND 19
    GROUP BY HOUR
    ORDER BY HOUR;
