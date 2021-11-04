/*
https://www.hackerrank.com/challenges/asian-population/problem
*/
SELECT SUM(CITY.POPULATION)
FROM CITY, COUNTRY
WHERE CITY.CountryCode = COUNTRY.Code
AND COUNTRY.CONTINENT = 'Asia';