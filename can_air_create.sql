CREATE SCHEMA can_air;

START TRANSACTION;

DROP TABLES IF EXISTS destination, person, flight_type, users, flight, reservation CASCADE;

CREATE TABLE destination
(
	DestinationId int not null auto_increment,
    DestinationName varchar (30) not null,
    
    CONSTRAINT PK_destination PRIMARY KEY (DestinationId)
);



CREATE TABLE person
(
	PersonId int not null auto_increment,
    FirstName varchar(30) not null,
    LastName varchar(30) not null,
    Phone int,
    Email varchar(30),
    DOB date,
    
    CONSTRAINT PK_person PRIMARY KEY (PersonId)
);

CREATE TABLE users
(
	UserId int not null auto_increment,
    PersonId int not null UNIQUE,
    Username varchar(30) not null UNIQUE,
    Password varchar(30) not null,
	
    CONSTRAINT PK_users PRIMARY KEY (UserId),
    CONSTRAINT FK_users_person_PersonId FOREIGN KEY (PersonId) REFERENCES person(PersonId)
);


CREATE TABLE flight_type
(
	FlightTypeId int not null auto_increment,
    FlightTypeName varchar(20) not null,
    
    CONSTRAINT PK_flight_type PRIMARY KEY (FlightTypeId)
);


CREATE TABLE flight
(
	FlightId int not null auto_increment,
    StartId int not null,
    EndId int not null,
    Date date not null,
    Time time not null,
    FlightTypeId int not null,
    FlightPrice int not null,
    FlightCapacity int not null,
    
    CONSTRAINT PK_flight PRIMARY KEY (FlightId),
    CONSTRAINT FK_flight_destination_StartId FOREIGN KEY (StartId) REFERENCES destination(DestinationId),
    CONSTRAINT FK_flight_destination_EndId FOREIGN KEY (EndId) REFERENCES destination(DestinationId),
    CONSTRAINT FK_flight_flight_type_FlightTypeId FOREIGN KEY (FlightTypeId) REFERENCES flight_type(FlightTypeId)
);

CREATE TABLE reservation
(
	ReservationId int not null auto_increment,
    FlightId int not null,
    UserId int not null,
    FlightTypeId int not null,
    
    CONSTRAINT PK_reservation PRIMARY KEY (ReservationId),
    CONSTRAINT FK_reservation_flight_FlightId FOREIGN KEY (FlightId) REFERENCES flight(FlightId),
    CONSTRAINT FK_reservation_user_UserId FOREIGN KEY (UserId) REFERENCES users(UserId),
    CONSTRAINT FK_reservation_flight_type_FlightTypeId FOREIGN KEY (FlightTypeId) REFERENCES flight_type(FlightTypeId)
);



COMMIT;
-- ROLLBACK;
