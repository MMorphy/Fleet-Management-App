package hr.petkovic.fleet.entities.rent;

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

import hr.petkovic.fleet.enums.CarGroups;

@Entity
@Table(name = "options")
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String code;

	@Column(nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	private CarGroups carGroup;

	@Column(nullable = false)
	private Float price = 0F;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reservation_id", nullable = false)
	private Reservation reservation;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ra_id", nullable = false)
	private RentalAgreement ra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CarGroups getCarGroup() {
		return carGroup;
	}

	public void setCarGroup(CarGroups carGroup) {
		this.carGroup = carGroup;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public RentalAgreement getRa() {
		return ra;
	}

	public void setRa(RentalAgreement ra) {
		this.ra = ra;
	}

}
