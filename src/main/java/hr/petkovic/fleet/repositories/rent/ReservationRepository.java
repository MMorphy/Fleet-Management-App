package hr.petkovic.fleet.repositories.rent;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.rent.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	List<Reservation> findAll();

	Optional<Reservation> findById(Long id);

	void deleteById(Long id);

	Reservation save(Reservation res);
}
