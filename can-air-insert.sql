-- -------------------------------
-- TEST DATA INSERT SCRIPT 
-- -------------------------------

START TRANSACTION;

INSERT INTO destination (destinationid, destinationname) 
VALUES
(1, 'MSP - Minneapolis/St. Paul'),
(2, 'LAX - Los Angeles'),
(3, 'DTW - Detroit'),
(4, 'YYZ - Toronto'),
(5, 'PHL - Philadelphia'),
(6, 'ORD - Chicago'),
(7, 'LHR - London')
;


INSERT INTO flight (startid, endid, departuredate, departuredeparturetime, departurearrivaltime, returndate, returndeparturetime, returnarrivaltime, isroundtrip, flightprice, flightcapacity) 
VALUES
( 1, 2, '2022-11-30', '07:30', '11:30', null, null, null, false, 7000.00, 50),  
( 1, 2, '2022-12-01', '09:30', '13:30', null, null, null, false, 7000.00, 50), 
( 2, 1, '2022-12-02', '10:30', '14:30', null, null, null, false, 7000.00, 50), 
( 2, 1, '2022-12-03', '06:00', '10:30', null, null, null, false, 8000.00, 50), 

( 3, 5, '2022-09-03', '06:00', '7:30', null, null, null, false, 80.00, 50), 
( 3, 5, '2022-09-14', '08:00', '9:30', null, null, null, false, 80.00, 50), 
( 3, 5, '2022-10-10', '04:00', '5:30', null, null, null, false, 80.00, 50), 
( 3, 5, '2022-11-21', '13:00', '14:45', null, null, null, false, 75.00, 50), 
( 3, 5, '2022-12-23', '07:00', '8:40', null, null, null, false, 95.00, 50), 
( 6, 2, '2022-09-27', '06:00', '10:30', null, null, null, false, 140.00, 50), 
( 6, 2, '2022-10-19', '06:00', '10:40', null, null, null, false, 150.00, 50), 
( 6, 2, '2022-11-24', '08:00', '12:30', null, null, null, false, 145.00, 50), 
( 6, 2, '2022-12-23', '07:00', '11:30', null, null, null, false, 180.00, 50), 
( 2, 5, '2022-12-03', '06:00', '11:30', null, null, null, false, 180.00, 50), 
( 2, 5, '2022-12-15', '08:00', '13:30', null, null, null, false, 180.00, 50), 
( 2, 5, '2022-12-23', '06:00', '11:30', null, null, null, false, 199.00, 50),
( 7, 4, '2022-08-05', '5:00', '13:30', null, null, null, false, 199.00, 50),
( 7, 4, '2022-09-11', '6:30', '14:45', null, null, null, false, 199.00, 50),
( 7, 4, '2022-10-29', '4:00', '12:30', null, null, null, false, 199.00, 50),
( 7, 6, '2022-11-25', '8:00', '16:25', null, null, null, false, 199.00, 50),
( 7, 6, '2022-12-20', '5:30', '14:00', null, null, null, false, 199.00, 50),
( 1, 2, '2022-12-04', '15:00', '19:30', null, null, null, false, 200.00, 50), 
( 1, 2, '2022-12-05', '00:00', '04:30', null, null, null, false, 200.00, 1),

( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-02', '8:00', '12:00', true, 7000.00, 50), 
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-03', '8:00', '12:00', true, 7000.00, 50), 
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-04', '8:00', '12:00', true, 7000.00, 50), 
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-05', '8:00', '12:00', true, 7000.00, 50), 
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-06', '8:00', '12:00', true, 7000.00, 50),
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-07', '8:00', '12:00', true, 7000.00, 50),
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-02', '14:00', '18:00', true, 6000.00, 50),
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-04', '14:00', '18:00', true, 6000.00, 50),
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-06', '14:00', '18:00', true, 6000.00, 50),
( 4, 6, '2022-08-15', '8:00', '10:30', '2022-08-17', '6:00', '9:00', true, 250.00, 50),
( 4, 6, '2022-08-15', '10:15', '12:30', '2022-08-17', '17:00', '20:00', true, 225.00, 50),
( 4, 6, '2022-08-15', '12:00', '14:15', '2022-08-18', '7:00', '9:15', true, 210.00, 50),
( 6, 5, '2022-08-18', '6:00', '8:00', '2022-08-22', '13:00', '15:00', true, 200.00, 50),
( 6, 5, '2022-08-18', '7:30', '9:30', '2022-08-22', '13:30', '15:45', true, 250.00, 50),
( 6, 5, '2022-08-19', '8:00', '10:30', '2022-08-23', '6:30', '8:30', true, 210.00, 50),
( 2, 7, '2022-08-24', '8:00', '18:30', '2022-08-31', '6:00', '16:25', true, 900.00, 50),
( 2, 7, '2022-08-24', '5:00', '15:00', '2022-08-31', '4:00', '14:25', true, 900.00, 50),
( 2, 6, '2022-08-26', '8:30', '12:35', '2022-08-29', '6:15', '10:25', true, 180.00, 50),
( 2, 6, '2022-08-26', '10:30', '14:35', '2022-08-30', '5:00', '9:25', true, 175.00, 50),
( 3, 5, '2022-09-01', '11:30', '13:00', '2022-09-04', '10:15', '12:00', true, 150.00, 50),
( 3, 5, '2022-09-01', '15:00', '16:45', '2022-09-04', '10:00', '12:00', true, 145.00, 50),
( 3, 5, '2022-09-05', '8:00', '10:00', '2022-09-10', '10:45', '1:00', true, 140.00, 50),
( 5, 1, '2022-09-20', '9:30', '11:15', '2022-09-22', '10:15', '12:45', true, 150.00, 50),
( 5, 1, '2022-10-05', '9:00', '11:40', '2022-10-12', '10:00', '12:30', true, 174.00, 50),
( 5, 1, '2022-10-18', '7:00', '9:40', '2022-10-20', '13:00', '15:40', true, 195.00, 50),
( 5, 1, '2022-11-22', '9:30', '6:00', '2022-11-30', '8:45', '11:00', true, 210.00, 50),
( 1, 7, '2022-11-14', '4:00', '12:00', '2022-11-18', '6:15', '14:30', true, 1500.00, 50),
( 1, 7, '2022-12-21', '4:00', '12:00', '2023-01-03', '5:00', '13:00', true, 1600.00, 50),
( 1, 7, '2022-10-29', '4:00', '12:40', '2022-11-02', '6:00', '14:00', true, 1550.00, 50)
;

-- USER AND PERSON
INSERT INTO person (firstname, lastname, phone, email, dob) 
VALUES 
('Atul', 'Mishra', '248-222-2222', 'amishra@gmail.com', '1989-03-09'),
('Cameron', 'Berg', '555-555-5555', 'cjberg@gmail.com', '1966-06-06'),
('Natalie', 'Riquelmy', '333-333-3333', 'nreq@gmail.com', '1977-07-07');

INSERT INTO users (personid, username, password)
VALUES
(1, 'amishra', 'hello'),
(2, 'cberg', 'lmao'),
(3, 'nrique', 'hola');

-- RESERVATION FOR USER
INSERT INTO reservation (flightid, userid, reservationfirstname, reservationlastname, reservationphone, reservationemail, reservationdob)
VALUES

(26,1,'Mal', 'Cowen', '343-969-5302', 'mcowene@wikimedia.org', '1991-06-11'),
(26,2,'Nicole', 'Wyldish', '322-617-3975', 'nwyldishf@foxnews.com', '1968-06-22'),
(26,3,'Kimmie', 'Helling', '477-747-0307', 'khellingg@hostgator.com', '1971-09-15'),
(27,1,'Katharyn', 'Leon', '548-933-3912', 'kleonh@gizmodo.com', '1967-07-13'),
(28,2,'Ammamaria', 'Stouther', '969-589-4787', 'astoutheri@phpbb.com', '1972-06-21'),
(29,3,'Dorotea', 'Hardstaff', '778-714-0258', 'dhardstaffj@squidoo.com', '1969-10-15'),
(30,1,'Benito', 'Reith', '473-564-9182', 'breithk@tiny.cc', '1991-11-02'),
(30,2,'Sollie', 'Beedie', '436-633-5273', 'sbeediel@flickr.com', '1976-11-30'),
(30,3,'El', 'Giacobelli', '993-185-2141', 'egiacobellim@apple.com', '2002-07-18'),
(31,1,'Francisca', 'McQuie', '411-810-7522', 'fmcquien@cdbaby.com', '1986-02-16'),

(15,1,'Federico', 'Grinaway', '210-557-0290', 'fgrinaway0@toplist.cz', '1992-06-25'),
(16,2,'Spence', 'Landsberg', '743-810-2424', 'slandsberg1@mit.edu', '1987-02-18'),
(16,3,'Jelene', 'Riggeard', '515-450-1039', 'jriggeard2@friendfeed.com', '1988-07-02'),
(17,1,'Anissa', 'Gyford', '588-511-9605', 'agyford3@163.com', '1966-11-19'),
(18,2,'Janine', 'Warret', '851-756-0721', 'jwarret4@w3.org', '1996-07-03'),
(19,3,'Skyler', 'Sabey', '668-884-6199', 'ssabey5@mashable.com', '1988-03-01'),
(20,1,'Jobina', 'Parker', '291-529-1829', 'jparker6@xinhuanet.com', '1985-04-12'),
(20,2,'Tressa', 'Guiraud', '598-524-8636', 'tguiraud7@twitter.com', '1985-08-06'),
(21,3,'Linnet', 'Donaho', '686-265-4059', 'ldonaho8@ehow.com', '1983-09-24'),
(22,1,'Clair', 'Aitken', '176-695-2454', 'caitken9@globo.com', '1966-07-25'),
(22,2,'Devondra', 'Tompkinson', '128-589-6063', 'dtompkinsona@clickbank.net', '1994-10-02'),
(23,3,'Roxine', 'Queripel', '158-712-1312', 'rqueripelb@icq.com', '1966-11-06'),
(25,1,'Udall', 'Dannehl', '643-985-8504', 'udannehlc@japanpost.jp', '1967-10-17'),
(25,2,'Frayda', 'Kareman', '354-982-9026', 'fkaremand@printfriendly.com', '1974-05-11'),

(24,3,'Jermaine','Cole','6578459090','jcole@yahoo.com','1985-01-28'),

(1,1,'Sean','Carter','888-888-8888','scarter@gmail.com','1932-03-27'),
(1,1,'Atul','Mishra','248-222-2222','friedfishra@aol.com','1989-03-09'),
(1,3,'Natalie','Riquelmy','484-992-1234','nreq@gmail.com','1977-07-07'),
(2,1,'Dwayne','Johnson','111-111-1111','therock@gmail.com','1972-05-02'),
(2,2,'Cameron','Berg','555-555-5555','cjberg28@yahoo.com','2000-01-28'),
(2,3,'Robert','De Niro','444-444-4444','rdn@gmail.com','1943-08-17');





COMMIT;
-- ROLLBACK;