package hr.petkovic.fleet.entities.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "engines")
public class Engine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Float capacity;

	@Column(nullable = false)
	private Float maxPower;

	@Column(nullable = false)
	private Float consumption;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fuel_type_id", nullable = false)
	private FuelType fuelType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getCapacity() {
		return capacity;
	}

	public void setCapacity(Float capacity) {
		this.capacity = capacity;
	}

	public Float getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(Float maxPower) {
		this.maxPower = maxPower;
	}

	public Float getConsumption() {
		return consumption;
	}

	public void setConsumption(Float consumption) {
		this.consumption = consumption;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

}
