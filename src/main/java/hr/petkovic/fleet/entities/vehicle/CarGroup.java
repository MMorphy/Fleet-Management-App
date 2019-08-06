package hr.petkovic.fleet.entities.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cargroups")
public class CarGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String carGroup;

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carGroup == null) ? 0 : carGroup.hashCode());
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
		CarGroup other = (CarGroup) obj;
		if (carGroup == null) {
			if (other.carGroup != null)
				return false;
		} else if (!carGroup.equals(other.carGroup))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarGroup() {
		return carGroup;
	}

	public void setCarGroup(String carGroup) {
		this.carGroup = carGroup;
	}

	@Override
	public String toString() {
		return "CarGroup [id=" + id + ", carGroup=" + carGroup + "]";
	}
}
