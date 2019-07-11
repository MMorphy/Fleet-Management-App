package hr.petkovic.fleet.entities.vehicle;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import hr.petkovic.fleet.enums.CarGroups;
import hr.petkovic.fleet.enums.FuelTypes;

@Entity
@Table(name = "vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 17)
	private String VIN;

	private String registrationNumber;

	private Integer manufactoringYear;

	@ColumnDefault(value = "0")
	private Integer currentKM;

	@Column(nullable = false)
	private String manufacturer;

	@Column(nullable = false)
	private String model;

	@Column(nullable = false)
	private Integer doors;

	@Enumerated(EnumType.STRING)
	private CarGroups carGroup;

	@Enumerated(EnumType.STRING)
	private FuelTypes fuelType;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="tire_id", referencedColumnName = "id")
	private Tire tire;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id")
	private CarSpecification specification;
}
