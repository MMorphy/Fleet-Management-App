package hr.petkovic.fleet.entities.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carGroups")
public class CarGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String carGroup;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroup() {
		return carGroup;
	}

	public void setGroup(String carGroup) {
		this.carGroup = carGroup;
	}

	@Override
	public String toString() {
		return "CarGroup [id=" + id + ", carGroup=" + carGroup + "]";
	}
}
