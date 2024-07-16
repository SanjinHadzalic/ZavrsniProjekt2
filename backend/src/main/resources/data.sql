-- test data for test profile

INSERT INTO BIRD(ID, scientific_name, common_name, aerc, status, season, euring_bird_code)
VALUES (1, 'Blackbird', 'Turdus merula', 'A', 'R', 'B,M,W', 11870),
       (2, 'Great Tit', 'Parus major', 'A', 'R', 'B,M*,W*', 14640),
       (3, 'Buzzard', 'Buteo buteo', 'A', 'R', 'B,M,W', 90260),
       (4, 'Eurasian chaffinch', 'Fringilla coelebs', 'A', 'R', 'B,M,W', 16360),
       (5, 'House sparrow', 'Passer domesticus', 'A', 'R', 'B', 15910),
       (6, 'Kestrel', 'Falco tinnunculus', 'A', 'R', 'B,M,W', 3040);

INSERT INTO PLACE (ID, NAME, LATITUDE, LONGITUDE, PLACE_CODE, PRECISION)
VALUES (1, 'Posebni ornitloški rezervat Palud', 45.0298213,13.6993519, 'HR04', '1'),
       (2, 'Park Prirode Učka', 45.2891591, 14.2482146, 'HR04','2');

INSERT INTO RINGING_SCHEME (ID, CODE, COUNTRY, CENTRE, EURING, CURRENT, DATE_UPDATED, NOTES)
VALUES  (1, 'ABT', 'Albania', 'Tirana', TRUE, TRUE, '2008-03-12', null),
        (2, 'AUW', 'Austria', 'Wien (Vienna)', TRUE, TRUE, '2015-10-02', null),
        (3, 'BGS', 'Bulgaria', 'Sofia', TRUE, TRUE, '2008-03-12', null),
        (4, 'BHS', 'Bosnia&Herzegovina', 'Sarajevo', TRUE, TRUE, '2020-03-17', 'New scheme 2020'),
        (5, 'BLB', 'Belgium', 'Bruxelles or Brussels', TRUE, TRUE, '2008-03-12', null);