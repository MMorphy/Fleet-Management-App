package hr.petkovic.fleet.entities.vehicle;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import hr.petkovic.fleet.enums.NavigationModels;

@Entity
@Table(name = "navigations")
public class Navigation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private NavigationModels model;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NavigationModels getModel() {
		return model;
	}

	public void setModel(NavigationModels model) {
		this.model = model;
	}
}
