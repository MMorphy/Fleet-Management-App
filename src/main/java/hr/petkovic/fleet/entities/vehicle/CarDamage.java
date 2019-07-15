package hr.petkovic.fleet.entities.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import hr.petkovic.fleet.entities.rent.RentalAgreement;
import hr.petkovic.fleet.enums.DamageSizes;
import hr.petkovic.fleet.enums.DamageTypes;

@Entity
@Table(name = "damages")
public class CarDamage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private DamageTypes type;

	@Enumerated(EnumType.STRING)
	private DamageSizes size;

	@Column(nullable = false)
	private Boolean repaired = false;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ra_id", nullable = false)
	private RentalAgreement ra;
}