-- test data for test profile


INSERT INTO accuracy_of_coordinates (code, language, description) VALUES
      ('A', 'en', 'Somewhere in a circle with radius 1 m'),
      ('B', 'en', 'Somewhere in a circle with radius 5 m'),
      ('C', 'en', 'Somewhere in a circle with radius 10 m'),
      ('D', 'en', 'Somewhere in a circle with radius 50 m');

INSERT INTO accuracy_of_date (code, language, description) VALUES
    ('A', 'en', 'Exact date'),
    ('B', 'en', 'Date within a week'),
    ('C', 'en', 'Date within a month'),
    ('D', 'en', 'Date within a year'),
    ('E', 'en', 'Date within a decade'),
    ('F', 'en', 'Date within a century');

INSERT INTO accuracy_of_pullus_age (code, language, description) VALUES
    ('P1', 'en', 'Age within 1 day'),
    ('P2', 'en', 'Age within 2 days'),
    ('P3', 'en', 'Age within 3 days'),
    ('P4', 'en', 'Age within 4 days'),
    ('P5', 'en', 'Age within 5 days'),
    ('P6', 'en', 'Age within 6 days'),
    ('P7', 'en', 'Age within 7 days');

INSERT INTO age (code, language, description) VALUES
    ('J', 'en', 'Juvenile'),
    ('A', 'en', 'Adult'),
    ('I', 'en', 'Immature'),
    ('N', 'en', 'Nestling'),
    ('F', 'en', 'Fledgling'),
    ('H', 'en', 'Hatchling'),
    ('S', 'en', 'Subadult');

INSERT INTO alula (code, language, description) VALUES
    ('A1', 'en', 'First primary feather'),
    ('A2', 'en', 'Second primary feather'),
    ('A3', 'en', 'Third primary feather'),
    ('A4', 'en', 'Fourth primary feather'),
    ('A5', 'en', 'Fifth primary feather'),
    ('A6', 'en', 'Sixth primary feather');

INSERT INTO user_role (name) VALUES -- ROLE_ gets concatenated
    ('USER'),
    ('ADMIN'),
    ('MODERATOR');

INSERT INTO users (firstname, lastname, username, password) VALUES
    ('John', 'Doe', 'user', '$2a$12$RbH0HjMtuaOSK./5Jf7uQ.yG/rUCvTlE7xAJOuzwaUQTteN94oJ.a'), --password
    ('Jane', 'Smith', 'jane_smith', '$2a$12$RbH0HjMtuaOSK./5Jf7uQ.yG/rUCvTlE7xAJOuzwaUQTteN94oJ.a'); --password

INSERT INTO user_authority (user_id, authority_id) VALUES
    (1, 1),
    (1, 2),
    (2, 1);

INSERT INTO bill_method (code, language, description) VALUES
    ('BM001', 'en', 'Standard Billing Method'),
    ('BM002', 'en', 'Electronic Billing Method'),
    ('BM003', 'en', 'Manual Billing Method'),
    ('BM004', 'en', 'Automated Billing Method'),
    ('BM005', 'en', 'Provisional Billing Method');

INSERT INTO BIRD(scientific_name, common_name, aerc, status, season, euring_bird_code)
VALUES ('Blackbird', 'Turdus merula', 'A', 'R', 'B,M,W', 11870),
       ('Great Tit', 'Parus major', 'A', 'R', 'B,M*,W*', 14640),
       ('Buzzard', 'Buteo buteo', 'A', 'R', 'B,M,W', 90260),
       ('Eurasian chaffinch', 'Fringilla coelebs', 'A', 'R', 'B,M,W', 16360),
       ('House sparrow', 'Passer domesticus', 'A', 'R', 'B', 15910),
       ('Kestrel', 'Falco tinnunculus', 'A', 'R', 'B,M,W', 3040);

INSERT INTO brood_patch (score, language, description) VALUES
    ('BP001', 'en', 'Fully developed brood patch'),
    ('BP002', 'en', 'Partially developed brood patch'),
    ('BP003', 'en', 'No brood patch development'),
    ('BP004', 'en', 'Brood patch in regression'),
    ('BP005', 'en', 'Brood patch in early development');

INSERT INTO brood_size (code, language, description) VALUES
    ('BS001', 'en', 'One young alive'),
    ('BS002', 'en', 'Two young alive'),
    ('BS003', 'en', 'Three young alive'),
    ('BS004', 'en', 'Four young alive'),
    ('BS005', 'en', 'Five young alive'),
    ('BS006', 'en', 'Unknown (from one female)'),
    ('BS007', 'en', 'Unknown (from more than one female)');

INSERT INTO carpal_covert (code, language, description) VALUES
    ('CC001', 'en', 'Full carpal covert'),
    ('CC002', 'en', 'Partial carpal covert'),
    ('CC003', 'en', 'No carpal covert'),
    ('CC004', 'en', 'Carpal covert not visible'),
    ('CC005', 'en', 'Carpal covert damaged'),
    ('CC006', 'en', 'Unknown carpal covert status');

INSERT INTO catching_lures (code, language, description) VALUES
    ('CL001', 'en', 'Lure type A'),
    ('CL002', 'en', 'Lure type B'),
    ('CL003', 'en', 'Lure type C'),
    ('CL004', 'en', 'Lure type D'),
    ('CL005', 'en', 'Lure type E'),
    ('CL006', 'en', 'Unknown lure type');

INSERT INTO catching_methods (code, language, description) VALUES
    ('CM001', 'en', 'Method A'),
    ('CM002', 'en', 'Method B'),
    ('CM003', 'en', 'Method C'),
    ('CM004', 'en', 'Method D'),
    ('CM005', 'en', 'Method E'),
    ('CM006', 'en', 'Unknown method type');

INSERT INTO circumstances_presumed (code, language, description) VALUES
    ('CP001', 'en', 'Presumed circumstances A'),
    ('CP002', 'en', 'Presumed circumstances B'),
    ('CP003', 'en', 'Presumed circumstances C'),
    ('CP004', 'en', 'Presumed circumstances D'),
    ('CP005', 'en', 'Uncertain circumstances');

INSERT INTO condition (code, language, description) VALUES
    ('C001', 'en', 'Healthy condition'),
    ('C002', 'en', 'Sick condition'),
    ('C003', 'en', 'Injured condition'),
    ('C004', 'en', 'Unfit condition'),
    ('C005', 'en', 'Unknown condition');

INSERT INTO euring_code_identifier (code, language, description)
VALUES
    ('E001', 'en', 'European ring code'),
    ('E002', 'en', 'Non-European ring code'),
    ('E003', 'en', 'Standard ring code'),
    ('E004', 'en', 'Special ring code'),
    ('E005', 'en', 'Experimental ring code');

INSERT INTO fat_score (score, language, description) VALUES
    ('FS01', 'en', 'Low fat score according to BTO standards'),
    ('FS02', 'en', 'Medium fat score according to ESF standards'),
    ('FS03', 'en', 'High fat score according to Operation Baltic standards'),
    ('FS04', 'en', 'Very high fat score indicating exceptional condition'),
    ('FS05', 'en', 'Unknown fat score due to insufficient data');

INSERT INTO manipulated (code, language, description) VALUES
    ('R', 'en', 'Ringing has caused injury to the bird'),
    ('P', 'en', 'Bird was already in poor condition when caught'),
    ('M', 'en', 'Normal moult, accidental loss of rectrices is not counted'),
    ('X', 'en', 'Unknown condition, requires further assessment'),
    ('I', 'en', 'Injured due to manipulation during handling');

INSERT INTO metal_ring_information (code, language, description) VALUES
    ('R', 'en', 'Metal ring is present, no additional ring should be added'),
    ('N', 'en', 'No metal ring present'),
    ('W', 'en', 'Metal ring is worn and may need replacement'),
    ('E', 'en', 'Existing ring needs to be replaced due to wear'),
    ('U', 'en', 'Unknown status of the metal ring');

INSERT INTO moult (code, language, description) VALUES
    ('P', 'en', 'Primary moult'),
    ('S', 'en', 'Secondary moult'),
    ('F', 'en', 'Facial moult'),
    ('C', 'en', 'Complete moult'),
    ('N', 'en', 'No moult observed');

INSERT INTO moved_before_the_encounter (code, language, description) VALUES
    ('M1', 'en', 'Moved to another location before capture'),
    ('M2', 'en', 'Moved to a different habitat'),
    ('M3', 'en', 'Last seen at a location far from capture'),
    ('M4', 'en', 'Migration suspected before encounter'),
    ('M5', 'en', 'Movement during breeding season');

INSERT INTO other_marks_information (code, language, description) VALUES
    ('ZZ', 'en', 'No marks other than metal ring'),
    ('AM', 'en', 'A marker indicating a band on the leg'),
    ('TM', 'en', 'Temporary mark used for identification'),
    ('PM', 'en', 'Permanent mark indicating breeding status'),
    ('SM', 'en', 'Special mark for research purposes');

INSERT INTO pectoral_muslce_score (code, language, description)
VALUES
    ('A', 'en', 'Excellent pectoral muscle condition'),
    ('B', 'en', 'Good pectoral muscle condition'),
    ('C', 'en', 'Fair pectoral muscle condition'),
    ('D', 'en', 'Poor pectoral muscle condition'),
    ('E', 'en', 'Very poor pectoral muscle condition');

INSERT INTO PLACE (NAME, COUNTRY, REGION_CODE, LATITUDE, LONGITUDE, precision_id, NOTES)
VALUES ('Posebni ornitloški rezervat Palud', 'HR', 'HR04', 45.0298213, 13.6993519, 1, 'test place 1'),
       ('Park Prirode Učka', 'HR', 'HR04', 45.2891591, 14.2482146, 2, 'test place 2');

INSERT INTO plumage_code (code, language, description) VALUES
    ('P1', 'en', 'Adult male plumage'),
    ('P2', 'en', 'Adult female plumage'),
    ('P3', 'en', 'Juvenile plumage'),
    ('P4', 'en', 'Breeding plumage'),
    ('P5', 'en', 'Non-breeding plumage'),
    ('P6', 'en', 'Molt plumage'),
    ('P7', 'en', 'Transition plumage');

INSERT INTO primary_identification_method (code, language, description) VALUES
    ('M', 'en', 'Metal ring'),
    ('T', 'en', 'Transponder'),
    ('B', 'en', 'Biometric'),
    ('L', 'en', 'Leg band'),
    ('C', 'en', 'Color band'),
    ('P', 'en', 'Patagial tag');

INSERT INTO primary_moult (code, language, description)
VALUES
    ('F', 'en', 'Feather molt'),
    ('P', 'en', 'Partial molt'),
    ('C', 'en', 'Complete molt'),
    ('S', 'en', 'Secondary molt'),
    ('A', 'en', 'Alternate molt');

INSERT INTO ring_code (code, user_id)
VALUES
    ('R001', 1),
    ('R002', 1),
    ('R003', 2),
    ('R004', 2);

INSERT INTO sex (code, language, description) VALUES
  ('M', 'en', 'Male'),
  ('F', 'en', 'Female'),
  ('U', 'en', 'Unknown');

INSERT INTO sexing_method (code, language, description) VALUES
    ('M', 'en', 'Method for identifying male birds'),
    ('F', 'en', 'Method for identifying female birds'),
    ('U', 'en', 'Method for unknown sex'),
    ('V', 'en', 'Visual identification method'),
    ('D', 'en', 'DNA testing method');

INSERT INTO state_of_wing_point (code, language, description) VALUES
  ('1', 'en', 'Normal wing point condition'),
  ('2', 'en', 'Damaged wing point'),
  ('3', 'en', 'Abnormal wing point'),
  ('4', 'en', 'Repaired wing point'),
  ('5', 'en', 'Not applicable');

INSERT INTO RINGING_SCHEME (CODE, COUNTRY, CENTRE, EURING, CURRENT, DATE_UPDATED, NOTES)
VALUES  ('ABT', 'Albania', 'Tirana', TRUE, TRUE, '2008-03-12', null),
        ('AUW', 'Austria', 'Wien (Vienna)', TRUE, TRUE, '2015-10-02', null),
        ('BGS', 'Bulgaria', 'Sofia', TRUE, TRUE, '2008-03-12', null),
        ('BHS', 'Bosnia&Herzegovina', 'Sarajevo', TRUE, TRUE, '2020-03-17', 'New scheme 2020'),
        ('BLB', 'Belgium', 'Bruxelles or Brussels', TRUE, TRUE, '2008-03-12', null);

INSERT INTO status (code, language, description) VALUES
     ('R', 'en', 'Roosting'),
     ('W', 'en', 'Wintering'),
     ('N', 'en', 'Nesting'),
     ('M', 'en', 'Moulting'),
     ('U', 'en', 'Unknown/Not Recorded'),
     ('-', 'en', 'Pullus');

INSERT INTO tarsus_method (code, language, description) VALUES
    ('M1', 'en', 'Method 1: Standard Tarsus Measurement'),
    ('M2', 'en', 'Method 2: Alternative Tarsus Measurement'),
    ('M3', 'en', 'Method 3: Tarsus Measurement with Special Tools');

INSERT INTO verification_of_the_metal_ring (code, language, description) VALUES
     ('0', 'en', 'Ring not verified by the scheme'),
     ('1', 'en', 'Ring verified by photograph'),
     ('2', 'en', 'Ring verified by physical inspection');

INSERT INTO ringed_bird (ringing_scheme_id, primary_identification_method_id, ring_code_id, species_id, date, time,
                         remarks) VALUES (1, 1, 1, 1, '2024-01-01', '12:00', 'Initial ringed bird record');
