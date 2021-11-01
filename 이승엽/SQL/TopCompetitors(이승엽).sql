select h.h_id, hc.name
from(select sb.hacker_id h_id, count(sb.hacker_id) cnt 
		from(select challenge_id, score sc 
				from difficulty d, challenges c 
				where c.difficulty_level = d.difficulty_level group by challenge_id, score) s, submissions sb 
		where s.sc = sb.score and s.challenge_id = sb.challenge_id group by sb.hacker_id having count(sb.hacker_id) > 1) h, hackers hc 
where h.h_id = hc.hacker_id order by h.cnt desc, h.h_id;