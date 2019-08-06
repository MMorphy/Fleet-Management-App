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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aspectRatio == null) ? 0 : aspectRatio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((manufacturingYear == null) ? 0 : manufacturingYear.hashCode());
		result = prime * result + ((tireBrand == null) ? 0 : tireBrand.hashCode());
		result = prime * result + ((tireType == null) ? 0 : tireType.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
		result = prime * result + ((wheelDiameter == null) ? 0 : wheelDiameter.hashCode());
		result = prime * result + ((wheelType == null) ? 0 : wheelType.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
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
		Tire other = (Tire) obj;
		if (aspectRatio == null) {
			if (other.aspectRatio != null)
				return false;
		} else if (!aspectRatio.equals(other.aspectRatio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (manufacturingYear == null) {
			if (other.manufacturingYear != null)
				return false;
		} else if (!manufacturingYear.equals(other.manufacturingYear))
			return false;
		if (tireBrand == null) {
			if (other.tireBrand != null)
				return false;
		} else if (!tireBrand.equals(other.tireBrand))
			return false;
		if (tireType == null) {
			if (other.tireType != null)
				return false;
		} else if (!tireType.equals(other.tireType))
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		if (wheelDiameter == null) {
			if (other.wheelDiameter != null)
				return false;
		} else if (!wheelDiameter.equals(other.wheelDiameter))
			return false;
		if (wheelType == null) {
			if (other.wheelType != null)
				return false;
		} else if (!wheelType.equals(other.wheelType))
			return false;
		if (width == null) {
			if (other.width != null)
				return false;
		} else if (!width.equals(other.width))
			return false;
		return true;
	}
}
