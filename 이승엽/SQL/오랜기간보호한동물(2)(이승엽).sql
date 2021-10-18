select t1.animal_id,t1.name 
From (SELECT ins.animal_id, ins.name 
		from ANIMAL_INS ins, animal_outs outs 
		where ins.animal_id = outs.animal_id order by (outs.datetime - ins.datetime) desc) t1 
where rownum <= 2;