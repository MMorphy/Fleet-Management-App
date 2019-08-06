package hr.petkovic.fleet.entities.office;

import java.util.LinkedHashSet;
import java.util.Set;

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "workingHours_id")
	private WorkingHours workingHours;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "office_id")
	private Set<Vehicle> vehiclePool = new LinkedHashSet<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "office_id")
	private Set<User> employees = new LinkedHashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public WorkingHours getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(WorkingHours workingHours) {
		this.workingHours = workingHours;
	}

	public Set<Vehicle> getVehiclePool() {
		return vehiclePool;
	}

	public void setVehiclePool(Set<Vehicle> vehiclePool) {
		this.vehiclePool = vehiclePool;
	}

	public Set<User> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<User> employees) {
		this.employees = employees;
	}

	public void addVehicle(Vehicle vehicle) {
		this.vehiclePool.add(vehicle);
	}

	public void removeVehicle(Vehicle vehicle) {
		this.vehiclePool.remove(vehicle);
	}

	@Override
	public String toString() {
		return "Office [id=" + id + ", name=" + name + ", address=" + address + ", workingHours=" + workingHours
				+ ", vehiclePool=" + vehiclePool + ", employees=" + employees + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((vehiclePool == null) ? 0 : vehiclePool.hashCode());
		result = prime * result + ((workingHours == null) ? 0 : workingHours.hashCode());
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
		Office other = (Office) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (vehiclePool == null) {
			if (other.vehiclePool != null)
				return false;
		} else if (!vehiclePool.equals(other.vehiclePool))
			return false;
		if (workingHours == null) {
			if (other.workingHours != null)
				return false;
		} else if (!workingHours.equals(other.workingHours))
			return false;
		return true;
	}
}
