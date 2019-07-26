package hr.petkovic.fleet.repositories.rent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.petkovic.fleet.entities.rent.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	List<Reservation> findAll();

	Optional<Reservation> findById(Long id);

	void deleteById(Long id);

	Reservation save(Reservation res);

	List<Reservation> findByUser_username(String username);

	List<Reservation> findByCheckOutOffice_name(String checkOutOfficeName);

	List<Reservation> findByCheckInOffice_name(String checkInOfficeName);

	@Query("SELECT res FROM Reservation res WHERE DATE(res.checkOutTime)=?1 AND res.checkOutOffice.name=?2")
	List<Reservation> findByCheckOutDateAndCheckOutOffice_name(LocalDateTime checkOutTime, String checkOutOfficeName);

	@Query("SELECT res FROM Reservation res WHERE DATE(res.checkInTime)=?1 AND res.checkInOffice.name=?2")
	List<Reservation> findByCheckInDateAndCheckInOffice_name(LocalDateTime checkInTime, String checkInOfficeName);
}
