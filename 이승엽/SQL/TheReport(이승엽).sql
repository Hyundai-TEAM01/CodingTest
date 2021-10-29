select case when grade <= 7 then NULL
            else s.name end cname
            ,grade, s.marks
from grades g, students s 
where g.min_mark <= s.marks and s.marks <= max_mark order by grade desc, s.name;