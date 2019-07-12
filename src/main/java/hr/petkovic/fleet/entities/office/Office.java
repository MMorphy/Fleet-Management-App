package hr.petkovic.fleet.entities.office;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import hr.petkovic.fleet.entities.vehicle.User;
import hr.petkovic.fleet.entities.vehicle.Vehicle;

@Entity
@Table(name = "offices")
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String address;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workingHours_id")
	private WorkingHours workingHours;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "office_id")
	private List<Vehicle> vehiclePool = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<User> employees = new ArrayList<>();
}
