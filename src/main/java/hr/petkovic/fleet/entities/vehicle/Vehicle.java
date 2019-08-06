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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manufacturer_id")
	private CarManufacturer manufacturer;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "model_id")
	private CarModel model;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "group_id", nullable = false)
	private CarGroup carGroup;

	@ColumnDefault(value = "0")
	private Integer fuelLevel;

	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "tire_id", referencedColumnName = "id")
	private Tire tire;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "spec_id")
	private CarSpecification specification;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "vehicle_id")
	private Set<CarDamage> damages;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nagivation_id")
	private Navigation navigation;

	@Column(nullable = false)
	private boolean rented = false;

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

	public Integer getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(Integer fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((VIN == null) ? 0 : VIN.hashCode());
		result = prime * result + ((carGroup == null) ? 0 : carGroup.hashCode());
		result = prime * result + ((currentKM == null) ? 0 : currentKM.hashCode());
		result = prime * result + ((damages == null) ? 0 : damages.hashCode());
		result = prime * result + ((fuelLevel == null) ? 0 : fuelLevel.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((manufactoringYear == null) ? 0 : manufactoringYear.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((navigation == null) ? 0 : navigation.hashCode());
		result = prime * result + ((registrationNumber == null) ? 0 : registrationNumber.hashCode());
		result = prime * result + (rented ? 1231 : 1237);
		result = prime * result + ((specification == null) ? 0 : specification.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (VIN == null) {
			if (other.VIN != null)
				return false;
		} else if (!VIN.equals(other.VIN))
			return false;
		if (carGroup == null) {
			if (other.carGroup != null)
				return false;
		} else if (!carGroup.equals(other.carGroup))
			return false;
		if (currentKM == null) {
			if (other.currentKM != null)
				return false;
		} else if (!currentKM.equals(other.currentKM))
			return false;
		if (damages == null) {
			if (other.damages != null)
				return false;
		} else if (!damages.equals(other.damages))
			return false;
		if (fuelLevel == null) {
			if (other.fuelLevel != null)
				return false;
		} else if (!fuelLevel.equals(other.fuelLevel))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (manufactoringYear == null) {
			if (other.manufactoringYear != null)
				return false;
		} else if (!manufactoringYear.equals(other.manufactoringYear))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (navigation == null) {
			if (other.navigation != null)
				return false;
		} else if (!navigation.equals(other.navigation))
			return false;
		if (registrationNumber == null) {
			if (other.registrationNumber != null)
				return false;
		} else if (!registrationNumber.equals(other.registrationNumber))
			return false;
		if (rented != other.rented)
			return false;
		if (specification == null) {
			if (other.specification != null)
				return false;
		} else if (!specification.equals(other.specification))
			return false;
		return true;
	}
}
