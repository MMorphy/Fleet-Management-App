package hr.petkovic.fleet.impl.rent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.office.Office;
import hr.petkovic.fleet.entities.office.User;
import hr.petkovic.fleet.entities.rent.Reservation;
import hr.petkovic.fleet.repositories.rent.ReservationRepository;
import hr.petkovic.fleet.service.rent.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository resRepo;

	public ReservationServiceImpl(ReservationRepository resRepo) {
		this.resRepo = resRepo;
	}

	@Override
	public List<Reservation> findAllRes() {
		return this.resRepo.findAll();
	}

	@Override
	public Reservation findResById(Long id) {
		try {
			return this.resRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteResById(Long id) {
		this.resRepo.deleteById(id);
	}

	@Override
	public Reservation saveRes(Reservation res) {
		return this.resRepo.save(res);
	}

	@Override
	public Reservation updateRes(Long id, Reservation res) {
		Optional<Reservation> optRes = this.resRepo.findById(id);
		if (optRes.isPresent()) {
			Reservation reser = optRes.get();
			reser.setCarGroup(res.getCarGroup());
			reser.setCheckInOffice(res.getCheckInOffice());
			reser.setCheckInTime(res.getCheckInTime());
			reser.setCheckOutOffice(res.getCheckOutOffice());
			reser.setCheckOutTime(res.getCheckOutTime());
			reser.setOptions(res.getOptions());
			reser.setUser(res.getUser());
			return this.resRepo.save(reser);
		} else {
			return this.resRepo.save(res);
		}
	}

	@Override
	public List<Reservation> findAllResForUser(User user) {
		if (user != null && user.getUsername() != null && !user.getUsername().isBlank()) {
			return this.resRepo.findByUser_username(user.getUsername());
		} else
			return null;
	}

	@Override
	public List<Reservation> findAllResForCheckInOffice(Office checkInOffice) {
		if (checkInOffice != null && checkInOffice.getName() != null && !checkInOffice.getName().isBlank()) {
			return this.resRepo.findByCheckInOffice_name(checkInOffice.getName());
		} else
			return null;
	}

	@Override
	public List<Reservation> findAllResForCheckOutOffice(Office checkOutOffice) {
		if (checkOutOffice != null && checkOutOffice.getName() != null && !checkOutOffice.getName().isBlank()) {
			return this.resRepo.findByCheckOutOffice_name(checkOutOffice.getName());
		} else
			return null;
	}

	@Override
	public List<Reservation> findAllResForCheckOutOfficeAndTime(Office checkOutOffice, LocalDateTime checkOutTime) {
		if (checkOutOffice != null && checkOutOffice.getName() != null && !checkOutOffice.getName().isBlank()
				&& checkOutTime != null) {
			return this.resRepo.findByCheckOutDateAndCheckOutOffice_name(checkOutTime, checkOutOffice.getName());
		} else
			return null;
	}

	@Override
	public List<Reservation> findAllResForCheckInOfficeAndTime(Office checkInOffice, LocalDateTime checkInTime) {
		if (checkInOffice != null && checkInOffice.getName() != null && !checkInOffice.getName().isBlank()
				&& checkInTime != null) {
			return this.resRepo.findByCheckOutDateAndCheckOutOffice_name(checkInTime, checkInOffice.getName());
		} else
			return null;
	}
}
