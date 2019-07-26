package hr.petkovic.fleet.service.rent;

import java.time.LocalDateTime;
import java.util.List;

import hr.petkovic.fleet.entities.office.Office;
import hr.petkovic.fleet.entities.office.User;
import hr.petkovic.fleet.entities.rent.Reservation;

public interface ReservationService {

	public abstract List<Reservation> findAllRes();

	public abstract Reservation findResById(Long id);

	public abstract void deleteResById(Long id);

	public abstract Reservation saveRes(Reservation res);

	public abstract Reservation updateRes(Long id, Reservation res);

	public abstract List<Reservation> findAllResForUser(User user);

	public abstract List<Reservation> findAllResForCheckInOffice(Office checkInOffice);

	public abstract List<Reservation> findAllResForCheckOutOffice(Office checkOutOffice);

	public abstract List<Reservation> findAllResForCheckOutOfficeAndTime(Office checkOutOffice, LocalDateTime checkOutTime);

	public abstract List<Reservation> findAllResForCheckInOfficeAndTime(Office checkInOffice, LocalDateTime checkInTime);
}
