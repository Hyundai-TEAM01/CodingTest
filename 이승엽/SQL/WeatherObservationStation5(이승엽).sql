select c,l 
from(select min(city) c, length(city) l from station group by length(city) order by length(city))t
where rownum = 1 or l = (select max(length(city)) from station);
