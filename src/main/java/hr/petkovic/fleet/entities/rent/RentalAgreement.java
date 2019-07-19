package hr.petkovic.fleet.entities.rent;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import hr.petkovic.fleet.entities.office.Office;
import hr.petkovic.fleet.entities.vehicle.CarDamage;
import hr.petkovic.fleet.entities.vehicle.User;
import hr.petkovic.fleet.entities.vehicle.Vehicle;
import hr.petkovic.fleet.enums.CarGroups;

@Entity
@Table(name = "rental_agreement")
public class RentalAgreement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime checkOutTime;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "checkOut_office_id")
	private Office checkOutOffice;

	@Column(nullable = false)
	private LocalDateTime checkInTime;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "checkIn_office_id")
	private Office checkInOffice;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@Enumerated(EnumType.STRING)
	private CarGroups carGroup;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="vehicle_id", referencedColumnName = "id")
	private Vehicle rentedVehicle;

	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "ra")
	private Set<Option> options;

	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "ra")
	private Set<CarDamage> damages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public Office getCheckOutOffice() {
		return checkOutOffice;
	}

	public void setCheckOutOffice(Office checkOutOffice) {
		this.checkOutOffice = checkOutOffice;
	}

	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public Office getCheckInOffice() {
		return checkInOffice;
	}

	public void setCheckInOffice(Office checkInOffice) {
		this.checkInOffice = checkInOffice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CarGroups getCarGroup() {
		return carGroup;
	}

	public void setCarGroup(CarGroups carGroup) {
		this.carGroup = carGroup;
	}

	public Vehicle getRentedVehicle() {
		return rentedVehicle;
	}

	public void setRentedVehicle(Vehicle rentedVehicle) {
		this.rentedVehicle = rentedVehicle;
	}

	public Set<Option> getOptions() {
		return options;
	}

	public void setOptions(Set<Option> options) {
		this.options = options;
	}

	public Set<CarDamage> getDamages() {
		return damages;
	}

	public void setDamages(Set<CarDamage> damages) {
		this.damages = damages;
	}
}
