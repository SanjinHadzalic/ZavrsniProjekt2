-- test data for test profile

INSERT INTO BIRD(scientific_name, common_name, aerc, status, season, euring_bird_code)
VALUES ('Blackbird', 'Turdus merula', 'A', 'R', 'B,M,W', 11870),
       ('Great Tit', 'Parus major', 'A', 'R', 'B,M*,W*', 14640),
       ('Buzzard', 'Buteo buteo', 'A', 'R', 'B,M,W', 90260),
       ('Eurasian chaffinch', 'Fringilla coelebs', 'A', 'R', 'B,M,W', 16360),
       ('House sparrow', 'Passer domesticus', 'A', 'R', 'B', 15910),
       ('Kestrel', 'Falco tinnunculus', 'A', 'R', 'B,M,W', 3040);

INSERT INTO PLACE (NAME, LATITUDE, LONGITUDE, PLACE_CODE, PRECISION)
VALUES ('Posebni ornitloški rezervat Palud', 45.0298213,13.6993519, 'HR04', '1'),
       ('Park Prirode Učka', 45.2891591, 14.2482146, 'HR04','2');

INSERT INTO RINGING_SCHEME (CODE, COUNTRY, CENTRE, EURING, CURRENT, DATE_UPDATED, NOTES)
VALUES  ('ABT', 'Albania', 'Tirana', TRUE, TRUE, '2008-03-12', null),
        ('AUW', 'Austria', 'Wien (Vienna)', TRUE, TRUE, '2015-10-02', null),
        ('BGS', 'Bulgaria', 'Sofia', TRUE, TRUE, '2008-03-12', null),
        ('BHS', 'Bosnia&Herzegovina', 'Sarajevo', TRUE, TRUE, '2020-03-17', 'New scheme 2020'),
        ('BLB', 'Belgium', 'Bruxelles or Brussels', TRUE, TRUE, '2008-03-12', null);