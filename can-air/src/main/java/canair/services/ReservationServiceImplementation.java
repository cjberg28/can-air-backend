package canair.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import canair.models.Reservation;
import canair.repositories.ReservationRepository;

@Service
@Transactional
public class ReservationServiceImplementation implements ReservationService {
	
	@Autowired
	private ReservationRepository repository;

	@Override
	public List<Reservation> getReservationsByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation createReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return false;
	}

}
