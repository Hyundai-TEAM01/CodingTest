-- 코드를 입력하세요
-- SELECT LEVEL-1 FROM DUAL CONNECT BY LEVEL < 25;
SELECT a.HOUR, NVL(b.COUNT, 0)
FROM (
    SELECT LEVEL-1 AS "HOUR" 
    FROM dual 
    CONNECT BY LEVEL < 25
) a, (
    SELECT TO_CHAR(datetime, 'HH24') AS "HOUR", COUNT(*) AS "COUNT"
    FROM animal_outs
    GROUP BY TO_CHAR(datetime, 'HH24')
) b
WHERE a.HOUR = b.HOUR(+)
ORDER BY a.HOUR;