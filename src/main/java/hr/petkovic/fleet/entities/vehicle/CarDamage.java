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
@Table(name = "damages")
public class CarDamage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String location;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "damage_type_id", nullable = false)
	private CarDamageType type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "damage_size_id", nullable = false)
	private CarDamageSize size;

	@Column(nullable = false)
	private Boolean repaired = false;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicle vehicle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public CarDamageType getType() {
		return type;
	}

	public void setType(CarDamageType type) {
		this.type = type;
	}

	public CarDamageSize getSize() {
		return size;
	}

	public void setSize(CarDamageSize size) {
		this.size = size;
	}

	public Boolean getRepaired() {
		return repaired;
	}

	public void setRepaired(Boolean repaired) {
		this.repaired = repaired;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
