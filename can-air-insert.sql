-- -------------------------------
-- TEST DATA INSERT SCRIPT 
-- -------------------------------

START TRANSACTION;

INSERT INTO destination (destinationname) 
VALUES
('MSP'),
('LAX');


INSERT INTO flight (startid, endid, departuredate, departuredeparturetime, departurearrivaltime, returndate, returndeparturetime, returnarrivaltime, isroundtrip, flightprice, flightcapacity) 
VALUES
( 1, 2, '2022-11-30', '07:30', '11:30', null, null, null, false, 7000.00, 50),  
( 1, 2, '2022-12-01', '09:30', '13:30', null, null, null, false, 7000.00, 50), 
( 2, 1, '2022-12-02', '10:30', '14:30', null, null, null, false, 7000.00, 50), 
( 2, 1, '2022-12-03', '06:00', '10:30', null, null, null, false, 8000.00, 50), 
( 1, 2, '2022-12-04', '15:00', '19:30', null, null, null, false, 6000.00, 50), 
( 1, 2, '2022-12-05', '00:00', '04:30', null, null, null, false, 1000.00, 1),
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-02', '8:00', '12:00', true, 7000.00, 50), 
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-03', '8:00', '12:00', true, 7000.00, 50), 
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-04', '8:00', '12:00', true, 7000.00, 50), 
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-05', '8:00', '12:00', true, 7000.00, 50), 
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-06', '8:00', '12:00', true, 7000.00, 50),
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-07', '8:00', '12:00', true, 7000.00, 50),
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-02', '14:00', '18:00', true, 6000.00, 50),
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-04', '14:00', '18:00', true, 6000.00, 50),
( 1, 2, '2022-12-01', '09:30', '13:30', '2022-12-06', '14:00', '18:00', true, 6000.00, 50)

;

-- USER AND PERSON
INSERT INTO PERSON (firstname, lastname, phone, email, dob) 
VALUES 
('Atul', 'Mishra', '248-222-2222', 'amishra@gmail.com', '1989-03-09'),
('Cameron', 'Berg', '555-555-5555', 'cjberg@gmail.com', '1966-06-06'),
('Natalie', 'Riquelme', '333-333-3333', 'nreq@gmail.com', '1977-07-07');

INSERT INTO USERS (personid, username, password)
VALUES
(1, 'amishra', 'hello'),
(2, 'cberg', 'lmao'),
(3, 'nrique', 'hola');


-- RESERVATION FOR USER
INSERT INTO RESERVATION (flightid, userid)
VALUES
(1,1),
(1,2),
(1,3),
(2,1),
(2,2),
(2,3);

INSERT INTO reservation (flightid, userid) VALUE (1,1);




COMMIT;
-- ROLLBACK;