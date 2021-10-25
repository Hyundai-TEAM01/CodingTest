SELECT RPAD('* ', x*2, '* ')
    FROM (
        SELECT LEVEL AS x
        FROM DUAL CONNECT BY LEVEL <= 20
        ORDER BY LEVEL
    );
