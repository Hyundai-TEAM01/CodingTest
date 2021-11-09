--Select num.HH, count(time.hh) 
--From (select To_char(DATETIME,'HH24') HH From ANIMAL_OUTS) time, (Select level-1 HH from dual connect by level <25) num 
--where time.HH(+) = num.HH
--group by num.HH order by num.HH;

-- review
SELECT HOUR, COUNT(TIME) AS COUNT
FROM (SELECT TO_CHAR(DATETIME,'HH24') AS TIME FROM ANIMAL_OUTS) T1,
    (SELECT LEVEL-1 AS HOUR FROM DUAL CONNECT BY LEVEL <= 24) T2
WHERE HOUR = TIME(+) GROUP BY HOUR ORDER BY HOUR