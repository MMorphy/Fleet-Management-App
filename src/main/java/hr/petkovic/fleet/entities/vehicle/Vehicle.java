package hr.petkovic.fleet.entities.vehicle;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 17)
	private String VIN;

	private String registrationNumber;

	@Column(nullable = false)
	private Integer manufactoringYear;

	@ColumnDefault(value = "0")
	private Integer currentKM;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manufacturer_id")
	private CarManufacturer manufacturer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "model_id")
	private CarModel model;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "group_id", nullable = false)
	private CarGroup carGroup;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fuel_type_id", nullable = false)
	private FuelType fuelType;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tire_id", referencedColumnName = "id")
	private Tire tire;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "spec_id")
	private CarSpecification specification;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicle_id")
	private Set<CarDamage> damages;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nagivation_id")
	private Navigation navigation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vIN) {
		VIN = vIN;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Integer getManufactoringYear() {
		return manufactoringYear;
	}

	public void setManufactoringYear(Integer manufactoringYear) {
		this.manufactoringYear = manufactoringYear;
	}

	public Integer getCurrentKM() {
		return currentKM;
	}

	public CarManufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(CarManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public CarModel getModel() {
		return model;
	}

	public void setModel(CarModel model) {
		this.model = model;
	}

	public void setCurrentKM(Integer currentKM) {
		this.currentKM = currentKM;
	}

	public CarGroup getCarGroup() {
		return carGroup;
	}

	public void setCarGroup(CarGroup carGroup) {
		this.carGroup = carGroup;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		this.tire = tire;
	}

	public CarSpecification getSpecification() {
		return specification;
	}

	public void setSpecification(CarSpecification specification) {
		this.specification = specification;
	}

	public Set<CarDamage> getDamages() {
		return damages;
	}

	public void setDamages(Set<CarDamage> damages) {
		this.damages = damages;
	}

	public Navigation getNavigation() {
		return navigation;
	}

	public void setNavigation(Navigation navigation) {
		this.navigation = navigation;
	}
}
