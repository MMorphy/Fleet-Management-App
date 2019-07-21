package hr.petkovic.fleet.repositories.rent;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.rent.RentalAgreement;

public interface RentalAgreementRepository extends JpaRepository<RentalAgreement, Long>{

	List<RentalAgreement> findAll();

	Optional<RentalAgreement> findById(Long id);

	void deleteById(Long id);

	RentalAgreement save(RentalAgreement ra);
}
