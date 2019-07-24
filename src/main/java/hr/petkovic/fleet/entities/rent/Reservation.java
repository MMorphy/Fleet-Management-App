package hr.petkovic.fleet.entities.rent;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import hr.petkovic.fleet.entities.office.Office;
import hr.petkovic.fleet.entities.office.User;
import hr.petkovic.fleet.entities.vehicle.CarGroup;

@Entity
@Table(name = "reservations")
public class Reservation {

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "group_id", nullable = false)
	private CarGroup carGroup;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reservation")
	private Set<Option> options;

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

	public CarGroup getCarGroup() {
		return carGroup;
	}

	public void setCarGroup(CarGroup carGroup) {
		this.carGroup = carGroup;
	}

	public Set<Option> getOptions() {
		return options;
	}

	public void setOptions(Set<Option> options) {
		this.options = options;
	}
}
