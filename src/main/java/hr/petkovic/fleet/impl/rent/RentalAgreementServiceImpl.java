package hr.petkovic.fleet.impl.rent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.office.Office;
import hr.petkovic.fleet.entities.office.User;
import hr.petkovic.fleet.entities.rent.RentalAgreement;
import hr.petkovic.fleet.repositories.rent.RentalAgreementRepository;
import hr.petkovic.fleet.service.rent.RentalAgreementService;

@Service
public class RentalAgreementServiceImpl implements RentalAgreementService {

	@Autowired
	private RentalAgreementRepository RARepo;

	public RentalAgreementServiceImpl(RentalAgreementRepository RARepo) {
		this.RARepo = RARepo;
	}

	@Override
	public List<RentalAgreement> findAllRA() {
		return this.RARepo.findAll();
	}

	@Override
	public RentalAgreement findRAById(Long id) {
		try {
			return this.RARepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteRAById(Long id) {
		this.RARepo.deleteById(id);
	}

	@Override
	public RentalAgreement saveRA(RentalAgreement ra) {
		return this.RARepo.save(ra);
	}

	@Override
	public RentalAgreement updateRA(Long id, RentalAgreement ra) {
		Optional<RentalAgreement> optRA = this.RARepo.findById(id);
		if (optRA.isPresent()) {
			RentalAgreement agreement = optRA.get();
			agreement.setCarGroup(ra.getCarGroup());
			agreement.setCheckInOffice(ra.getCheckInOffice());
			agreement.setCheckInTime(ra.getCheckInTime());
			agreement.setCheckOutOffice(ra.getCheckOutOffice());
			agreement.setCheckOutTime(ra.getCheckOutTime());
			agreement.setDamages(ra.getDamages());
			agreement.setOptions(ra.getOptions());
			agreement.setRentedVehicle(ra.getRentedVehicle());
			agreement.setUser(ra.getUser());
			return this.RARepo.save(agreement);
		} else {
			return this.RARepo.save(ra);
		}
	}

	@Override
	public List<RentalAgreement> findAllRAsForUser(User user) {
		if (user != null && user.getUsername() != null && !user.getUsername().isBlank()) {
			return this.RARepo.findByUser_username(user.getUsername());
		} else
			return null;
	}

	@Override
	public List<RentalAgreement> findAllRAsForCheckinOffice(Office office) {
		if (office != null && office.getName() != null && !office.getName().isBlank()) {
			return this.RARepo.findByCheckInOffice_name(office.getName());
		} else
			return null;
	}

	@Override
	public List<RentalAgreement> findAllRAsForCheckoutOffice(Office office) {
		if (office != null && office.getName() != null && !office.getName().isBlank()) {
			return this.RARepo.findByCheckOutOffice_name(office.getName());
		} else
			return null;
	}

	@Override
	public List<RentalAgreement> findAllRAsForCheckOutOfficeAndTime(Office checkOutOffice, LocalDateTime checkoutTime) {
		if (checkOutOffice != null && checkOutOffice.getName() != null && !checkOutOffice.getName().isBlank()
				&& (checkoutTime != null)) {
			return this.RARepo.findByCheckOutDateAndCheckOutOffice(checkoutTime, checkOutOffice.getName());
		} else
			return null;
	}

	@Override
	public List<RentalAgreement> findAllRAsForCheckInOfficeAndTime(Office checkInOffice, LocalDateTime checkInTime) {
		if (checkInOffice != null && checkInOffice.getName() != null && !checkInOffice.getName().isBlank()
				&& checkInTime != null) {
			return this.RARepo.findByCheckInDateAndCheckInOffice(checkInTime, checkInOffice.getName());
		} else
			return null;
	}

	@Override
	public List<RentalAgreement> findAllRAsForCheckInOfficeWithDamages(Office office) {
		if (office != null && office.getName() != null && !office.getName().isBlank()) {
			return this.RARepo.findByCheckInOffice_nameAndDamages_idNotNull(office.getName());
		} else
			return null;
	}
}
