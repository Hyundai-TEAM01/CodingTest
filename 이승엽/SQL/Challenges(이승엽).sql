 select h.hacker_id, h.name, cnt 
 from (select hacker_id, count(challenge_id) cnt 
 		from challenges group by hacker_id) tb, hackers h
 where h.hacker_id = tb.hacker_id 
 	and cnt not in ( select distinct(t1.cnt) 
 						from (select hacker_id, count(challenge_id) cnt from challenges group by hacker_id) t1,
 								(select hacker_id, count(challenge_id) cnt from challenges group by hacker_id) t2 
						where t1.hacker_id != t2.hacker_id and t1.cnt = t2.cnt 
								and t1.cnt < (select max(count(challenge_id)) m_cnt from challenges group by hacker_id)) 
order by cnt desc, hacker_id;