SELECT ANIMAL_ID,NAME
            ,CASE when SEX_UPON_INTAKE like '%Neutered%' then 'O' 
            when SEX_UPON_INTAKE like'%Spayed%' then 'O'
            else 'X' 
            end AS �߼�ȭ
From ANIMAL_INS Order by ANIMAL_ID;