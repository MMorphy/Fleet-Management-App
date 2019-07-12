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
}
