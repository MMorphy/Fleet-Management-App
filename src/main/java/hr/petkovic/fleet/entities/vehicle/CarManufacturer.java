package hr.petkovic.fleet.entities.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_manufacturers")
public class CarManufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String carManufacturer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarManufacturer() {
		return carManufacturer;
	}

	public void setCarManufacturer(String carManufacturer) {
		this.carManufacturer = carManufacturer;
	}

	@Override
	public String toString() {
		return "CarManufacturer [id=" + id + ", carManufacturer=" + carManufacturer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carManufacturer == null) ? 0 : carManufacturer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CarManufacturer other = (CarManufacturer) obj;
		if (carManufacturer == null) {
			if (other.carManufacturer != null)
				return false;
		} else if (!carManufacturer.equals(other.carManufacturer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
