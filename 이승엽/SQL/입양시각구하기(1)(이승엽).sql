select to_char(dateTime,'hh24') as hour, count(*)  
from ANIMAL_OUTS 
    group by to_char(datetime,'hh24') 
    having to_char(dateTime,'hh24') >'08' and to_char(dateTime,'hh24') <'20' 
    order by hour;