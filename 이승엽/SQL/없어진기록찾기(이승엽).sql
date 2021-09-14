Select ANIMAL_ID, NAME FROM ANIMAL_OUTS WHERE ANIMAL_ID not in (Select ANIMAL_ID FROM ANIMAL_INS
                                                               ) ORDER by ANIMAL_ID;