SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
    FROM ANIMAL_INS
    WHERE NAME = ANY('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
    ORDER BY ANIMAL_ID;
