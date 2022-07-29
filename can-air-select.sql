-- select * from users where username='amishra' and password = 'hello';

select * from flight;

select * from users;

select * from person;

select * from destination;

select * from reservation;

-- select f.FlightId from flight as f left join reservation as r on f.FlightId = r.flightid join users as u on u.userid = r.UserId join person as p on u.PersonId = p.PersonId
-- where p.FirstName = 'Atul'