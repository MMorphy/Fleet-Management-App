package hr.petkovic.fleet.repositories.rent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.petkovic.fleet.entities.rent.RentalAgreement;

public interface RentalAgreementRepository extends JpaRepository<RentalAgreement, Long>{

	List<RentalAgreement> findAll();

	Optional<RentalAgreement> findById(Long id);

	void deleteById(Long id);

	RentalAgreement save(RentalAgreement ra);

	List<RentalAgreement> findByUser_username(String username);

	List<RentalAgreement> findByCheckOutOffice_name(String officeName);

	List<RentalAgreement> findByCheckInOffice_name(String officeName);

	@Query("SELECT ra FROM RentalAgreement ra WHERE DATE(ra.checkInTime)=?1 AND ra.checkInOffice.name=?2")
	List<RentalAgreement> findByCheckInDateAndCheckInOffice(LocalDateTime checkInTime, String checkInOfficeName);

	@Query("SELECT ra FROM RentalAgreement ra WHERE DATE(ra.checkOutTime)=?1 AND ra.checkOutOffice.name=?2")
	List<RentalAgreement> findByCheckOutDateAndCheckOutOffice(LocalDateTime checkOutTime, String checkOutOfficeName);

	List<RentalAgreement> findByCheckInOffice_nameAndDamages_idNotNull(String checkInOfficeName);

}
