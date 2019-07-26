package hr.petkovic.fleet.entities.vehicle;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tires")
public class Tire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer width;

	private Integer aspectRatio;

	private Integer wheelDiameter;

	private Integer manufacturingYear;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tire_brand_id", nullable = false)
	private TireBrand tireBrand;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tire_type_id", nullable = false)
	private TireType tireType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "wheel_type_id", nullable = false)
	private WheelType wheelType;

	@OneToOne(mappedBy = "tire", fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
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

	public Integer getAspectRatio() {
		return aspectRatio;
	}

	public void setAspectRatio(Integer aspectRatio) {
		this.aspectRatio = aspectRatio;
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

	public TireBrand getTireBrand() {
		return tireBrand;
	}

	public void setTireBrand(TireBrand tireBrand) {
		this.tireBrand = tireBrand;
	}

	public TireType getTireType() {
		return tireType;
	}

	public void setTireType(TireType tireType) {
		this.tireType = tireType;
	}

	public WheelType getWheelType() {
		return wheelType;
	}

	public void setWheelType(WheelType wheelType) {
		this.wheelType = wheelType;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
