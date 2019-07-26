package hr.petkovic.fleet.service.rent;

import java.time.LocalDateTime;
import java.util.List;

import hr.petkovic.fleet.entities.office.Office;
import hr.petkovic.fleet.entities.office.User;
import hr.petkovic.fleet.entities.rent.RentalAgreement;

public interface RentalAgreementService {

	public abstract List<RentalAgreement> findAllRA();

	public abstract RentalAgreement findRAById(Long id);

	public abstract void deleteRAById(Long id);

	public abstract RentalAgreement saveRA(RentalAgreement ra);

	public abstract RentalAgreement updateRA(Long id, RentalAgreement ra);

	public abstract List<RentalAgreement> findAllRAsForUser(User user);

	public abstract List<RentalAgreement> findAllRAsForCheckinOffice(Office office);

	public abstract List<RentalAgreement> findAllRAsForCheckoutOffice(Office office);


	public abstract List<RentalAgreement> findAllRAsForCheckOutOfficeAndTime(Office checkOutOffice, LocalDateTime checkout);

	public abstract List<RentalAgreement> findAllRAsForCheckInOfficeAndTime(Office checkInOffice, LocalDateTime checkin);

	public abstract List<RentalAgreement> findAllRAsForCheckInOfficeWithDamages(Office office);
}
