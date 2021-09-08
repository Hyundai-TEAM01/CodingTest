Select num.HH, count(time.hh) 
From (select To_char(DATETIME,'HH24') HH From ANIMAL_OUTS) time, (Select level-1 HH from dual connect by level <25) num 
where time.HH(+) = num.HH
group by num.HH order by num.HH;