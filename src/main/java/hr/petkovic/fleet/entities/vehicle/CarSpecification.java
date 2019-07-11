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

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "specifications")
public class CarSpecification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="nagivation_id")
	private Navigation navigation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "engine_id")
	private Engine engine;

	@Column(nullable = false)
	@ColumnDefault(value = "100")
	private Float fuelLevel;

	@Column(nullable = false)
	private Integer fuelTankCapacity;

	@Column(nullable = false)
	private Float topSpeed;

	@Column(nullable = false)
	private Integer numberOfSeats;
}
