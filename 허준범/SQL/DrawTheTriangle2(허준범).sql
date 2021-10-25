/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SET SERVEROUTPUT ON;
DECLARE
I NUMBER;
J NUMBER;
BEGIN
FOR I IN 1..20 LOOP
    FOR J IN 1..I LOOP
        DBMS_OUTPUT.PUT('* ');
    END LOOP;
    DBMS_OUTPUT.NEW_LINE;
END LOOP;
END;
/