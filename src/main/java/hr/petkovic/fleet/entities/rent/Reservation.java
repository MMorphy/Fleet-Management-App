package hr.petkovic.fleet.entities.rent;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import hr.petkovic.fleet.entities.office.Office;
import hr.petkovic.fleet.entities.office.User;
import hr.petkovic.fleet.entities.vehicle.CarGroup;

@Entity
@Table(name = "reservations")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime checkOutTime;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "checkOut_office_id")
	private Office checkOutOffice;

	@Column(nullable = false)
	private LocalDateTime checkInTime;

	@ManyToOne(fetch = FetchType.EAGER,  cascade = CascadeType.REFRESH)
	@JoinColumn(name = "checkIn_office_id")
	private Office checkInOffice;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "group_id", nullable = false)
	private CarGroup carGroup;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "res_options", joinColumns = @JoinColumn(name = "res_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "option_id", referencedColumnName = "id"))
	private Set<Option> options;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public Office getCheckOutOffice() {
		return checkOutOffice;
	}

	public void setCheckOutOffice(Office checkOutOffice) {
		this.checkOutOffice = checkOutOffice;
	}

	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public Office getCheckInOffice() {
		return checkInOffice;
	}

	public void setCheckInOffice(Office checkInOffice) {
		this.checkInOffice = checkInOffice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CarGroup getCarGroup() {
		return carGroup;
	}

	public void setCarGroup(CarGroup carGroup) {
		this.carGroup = carGroup;
	}

	public Set<Option> getOptions() {
		return options;
	}

	public void setOptions(Set<Option> options) {
		this.options = options;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carGroup == null) ? 0 : carGroup.hashCode());
		result = prime * result + ((checkInOffice == null) ? 0 : checkInOffice.hashCode());
		result = prime * result + ((checkInTime == null) ? 0 : checkInTime.hashCode());
		result = prime * result + ((checkOutOffice == null) ? 0 : checkOutOffice.hashCode());
		result = prime * result + ((checkOutTime == null) ? 0 : checkOutTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Reservation other = (Reservation) obj;
		if (carGroup == null) {
			if (other.carGroup != null)
				return false;
		} else if (!carGroup.equals(other.carGroup))
			return false;
		if (checkInOffice == null) {
			if (other.checkInOffice != null)
				return false;
		} else if (!checkInOffice.equals(other.checkInOffice))
			return false;
		if (checkInTime == null) {
			if (other.checkInTime != null)
				return false;
		} else if (!checkInTime.equals(other.checkInTime))
			return false;
		if (checkOutOffice == null) {
			if (other.checkOutOffice != null)
				return false;
		} else if (!checkOutOffice.equals(other.checkOutOffice))
			return false;
		if (checkOutTime == null) {
			if (other.checkOutTime != null)
				return false;
		} else if (!checkOutTime.equals(other.checkOutTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
