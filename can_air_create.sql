START TRANSACTION;


CREATE TABLE destination
(
	DestinationId int not null auto_increment,
    DestinationName varchar (30) not null,
    
    CONSTRAINT PK_destination PRIMARY KEY (DestinationId)
);

CREATE TABLE users
(
	UserId int not null auto_increment,
    Username varchar(30) not null,
    Password varchar(30) not null,
	
    CONSTRAINT PK_users PRIMARY KEY (UserId)
);

CREATE TABLE person
(
	PersonId int not null auto_increment,
    UserId int not null,
    FirstName varchar(30) not null,
    LastName varchar(30) not null,
    Phone int,
    DOB date,
    
    CONSTRAINT PK_person PRIMARY KEY (PersonId),
    CONSTRAINT FK_person_user_UserId FOREIGN KEY (UserId) REFERENCES users(UserId)
);

CREATE TABLE flight
(
	FlightId int not null auto_increment,
    StartId int not null,
    EndId int not null,
    Date date not null,
    Time time not null,
    
    CONSTRAINT PK_flight PRIMARY KEY (FlightId),
    CONSTRAINT FK_flight_destination_StartId FOREIGN KEY (StartId) REFERENCES destination(DestinationId),
    CONSTRAINT FK_flight_destination_EndId FOREIGN KEY (EndId) REFERENCES destination(DestinationId)
);

CREATE TABLE reservation
(
	ReservationId int not null auto_increment,
    FlightId int not null,
    UserId int not null,
    
    CONSTRAINT PK_reservation PRIMARY KEY (ReservationId),
    CONSTRAINT FK_reservation_flight_FlightId FOREIGN KEY (FlightId) REFERENCES flight(FlightId),
    CONSTRAINT FK_reservation_user_UserId FOREIGN KEY (UserId) REFERENCES users(UserId)
);



COMMIT;
-- ROLLBACK;
