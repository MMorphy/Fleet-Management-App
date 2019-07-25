package hr.petkovic.fleet.entities.rent;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import hr.petkovic.fleet.entities.vehicle.CarGroup;


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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "group_id", nullable = false)
	private CarGroup carGroup;

	@Column(nullable = false)
	private Float price = 0F;

	@Column(nullable = false)
	private Integer amount = 1;

	@ManyToMany(mappedBy = "options")
	private Collection<Reservation> reservation;

	@ManyToMany(mappedBy = "options")
	private Collection<RentalAgreement> ra;

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

	public CarGroup getCarGroup() {
		return carGroup;
	}

	public void setCarGroup(CarGroup carGroup) {
		this.carGroup = carGroup;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Collection<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(Collection<Reservation> reservation) {
		this.reservation = reservation;
	}

	public Collection<RentalAgreement> getRa() {
		return ra;
	}

	public void setRa(Collection<RentalAgreement> ra) {
		this.ra = ra;
	}

	@Override
	public String toString() {
		return "Option [id=" + id + ", code=" + code + ", name=" + name + ", carGroup=" + carGroup + ", price=" + price
				+ ", reservation=" + reservation + ", ra=" + ra + "]";
	}


}
