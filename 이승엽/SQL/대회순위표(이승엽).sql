select t.hacker_id,name, sum(m_score) 
from(select hacker_id, challenge_id, max(score) m_score from submissions group by hacker_id, challenge_id order by hacker_id) t , hackers
where t.hacker_id = hackers.hacker_id group by t.hacker_id, name having sum(m_score) > 0 order by sum(m_score) desc, t.hacker_id;

