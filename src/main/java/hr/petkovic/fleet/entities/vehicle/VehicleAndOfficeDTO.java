package hr.petkovic.fleet.entities.vehicle;

import hr.petkovic.fleet.entities.office.Office;

public class VehicleAndOfficeDTO {

	private Vehicle vehicle;

	private Office office;

	public VehicleAndOfficeDTO(Vehicle vehicle, Office office) {
		this.vehicle = vehicle;
		this.office = office;
	}

	public VehicleAndOfficeDTO() {
		this.vehicle = new Vehicle();
		this.office = new Office();
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((office == null) ? 0 : office.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
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
		VehicleAndOfficeDTO other = (VehicleAndOfficeDTO) obj;
		if (office == null) {
			if (other.office != null)
				return false;
		} else if (!office.equals(other.office))
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
	}
}
