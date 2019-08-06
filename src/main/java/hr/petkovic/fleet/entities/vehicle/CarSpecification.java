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
@Table(name = "specifications")
public class CarSpecification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Integer doors;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "engine_id")
	private Engine engine;

	@Column(nullable = false)
	private Integer fuelTankCapacity;

	@Column(nullable = false)
	private Float topSpeed;

	@Column(nullable = false)
	private Integer numberOfSeats;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDoors() {
		return doors;
	}

	public void setDoors(Integer doors) {
		this.doors = doors;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Integer getFuelTankCapacity() {
		return fuelTankCapacity;
	}

	public void setFuelTankCapacity(Integer fuelTankCapacity) {
		this.fuelTankCapacity = fuelTankCapacity;
	}

	public Float getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(Float topSpeed) {
		this.topSpeed = topSpeed;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doors == null) ? 0 : doors.hashCode());
		result = prime * result + ((engine == null) ? 0 : engine.hashCode());
		result = prime * result + ((fuelTankCapacity == null) ? 0 : fuelTankCapacity.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numberOfSeats == null) ? 0 : numberOfSeats.hashCode());
		result = prime * result + ((topSpeed == null) ? 0 : topSpeed.hashCode());
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
		CarSpecification other = (CarSpecification) obj;
		if (doors == null) {
			if (other.doors != null)
				return false;
		} else if (!doors.equals(other.doors))
			return false;
		if (engine == null) {
			if (other.engine != null)
				return false;
		} else if (!engine.equals(other.engine))
			return false;
		if (fuelTankCapacity == null) {
			if (other.fuelTankCapacity != null)
				return false;
		} else if (!fuelTankCapacity.equals(other.fuelTankCapacity))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numberOfSeats == null) {
			if (other.numberOfSeats != null)
				return false;
		} else if (!numberOfSeats.equals(other.numberOfSeats))
			return false;
		if (topSpeed == null) {
			if (other.topSpeed != null)
				return false;
		} else if (!topSpeed.equals(other.topSpeed))
			return false;
		return true;
	}
}
