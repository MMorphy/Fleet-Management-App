package hr.petkovic.fleet.entities.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "engines")
public class Engine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Integer cilinders;

	@Column(nullable = false)
	private Float capacity;

	@Column(nullable = false)
	private Float maxPower;

	@Column(nullable = false)
	private Float maxTorque;

	@Column(nullable = false)
	private Float consumption;

}
