-- 코드를 입력하세요
SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS I, ANIMAL_OUTS O
WHERE I.ANIMAL_ID = O.ANIMAL_ID
ORDER BY (O.DATETIME - I.DATETIME) DESC
FETCH FIRST 2 ROWS ONLY
-- 이런 것도 있네요.

-- SELECT ANIMAL_ID, NAME
-- FROM (
--     SELECT O.ANIMAL_ID, O.NAME, O.DATETIME
--     FROM ANIMAL_INS I, ANIMAL_OUTS O
--     WHERE I.ANIMAL_ID = O.ANIMAL_ID
--     ORDER BY O.DATETIME-I.DATETIME DESC -- 보호기간이 가장 길었던 
-- ) 
-- WHERE ROWNUM <= 2;