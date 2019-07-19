package hr.petkovic.fleet.entities.vehicle;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import hr.petkovic.fleet.enums.TireBrands;
import hr.petkovic.fleet.enums.TireTypes;
import hr.petkovic.fleet.enums.WheelTypes;

@Entity
@Table(name="tires")
public class Tire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer width;

	private Integer aspectRation;

	private Integer wheelDiameter;

	private Integer manufacturingYear;

	@Enumerated(EnumType.STRING)
	private TireBrands tireBrand;

	@Enumerated(EnumType.STRING)
	private TireTypes tireType;

	@Enumerated(EnumType.STRING)
	private WheelTypes wheelType;

	@OneToOne(mappedBy = "tire")
	private Vehicle vehicle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getAspectRation() {
		return aspectRation;
	}

	public void setAspectRation(Integer aspectRation) {
		this.aspectRation = aspectRation;
	}

	public Integer getWheelDiameter() {
		return wheelDiameter;
	}

	public void setWheelDiameter(Integer wheelDiameter) {
		this.wheelDiameter = wheelDiameter;
	}

	public Integer getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(Integer manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public TireBrands getTireBrand() {
		return tireBrand;
	}

	public void setTireBrand(TireBrands tireBrand) {
		this.tireBrand = tireBrand;
	}

	public TireTypes getTireType() {
		return tireType;
	}

	public void setTireType(TireTypes tireType) {
		this.tireType = tireType;
	}

	public WheelTypes getWheelType() {
		return wheelType;
	}

	public void setWheelType(WheelTypes wheelType) {
		this.wheelType = wheelType;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
