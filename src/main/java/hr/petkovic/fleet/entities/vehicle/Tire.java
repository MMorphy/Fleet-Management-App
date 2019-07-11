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
}
