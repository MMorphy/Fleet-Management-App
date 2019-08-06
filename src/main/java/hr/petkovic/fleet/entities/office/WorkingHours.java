package hr.petkovic.fleet.entities.office;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "workinghours")
public class WorkingHours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DateTimeFormat(pattern = "HH:mm")
	private LocalDateTime workdayST;

	@DateTimeFormat(pattern = "HH:mm")
	private LocalDateTime workdayET;

	@DateTimeFormat(pattern = "HH:mm")
	private LocalDateTime saturdayST;

	@DateTimeFormat(pattern = "HH:mm")
	private LocalDateTime saturdayET;

	@DateTimeFormat(pattern = "HH:mm")
	private LocalDateTime sundayST;

	@DateTimeFormat(pattern = "HH:mm")
	private LocalDateTime sundayET;

	@DateTimeFormat(pattern = "HH:mm")
	private LocalDateTime holidayST;

	@DateTimeFormat(pattern = "HH:mm")
	private LocalDateTime holidayET;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getWorkdayST() {
		return workdayST;
	}

	public void setWorkdayST(LocalDateTime workdayST) {
		this.workdayST = workdayST;
	}

	public LocalDateTime getWorkdayET() {
		return workdayET;
	}

	public void setWorkdayET(LocalDateTime workdayET) {
		this.workdayET = workdayET;
	}

	public LocalDateTime getSaturdayST() {
		return saturdayST;
	}

	public void setSaturdayST(LocalDateTime saturdayST) {
		this.saturdayST = saturdayST;
	}

	public LocalDateTime getSaturdayET() {
		return saturdayET;
	}

	public void setSaturdayET(LocalDateTime saturdayET) {
		this.saturdayET = saturdayET;
	}

	public LocalDateTime getSundayST() {
		return sundayST;
	}

	public void setSundayST(LocalDateTime sundayST) {
		this.sundayST = sundayST;
	}

	public LocalDateTime getSundayET() {
		return sundayET;
	}

	public void setSundayET(LocalDateTime sundayET) {
		this.sundayET = sundayET;
	}

	public LocalDateTime getHolidayST() {
		return holidayST;
	}

	public void setHolidayST(LocalDateTime holidayST) {
		this.holidayST = holidayST;
	}

	public LocalDateTime getHolidayET() {
		return holidayET;
	}

	public void setHolidayET(LocalDateTime holidayET) {
		this.holidayET = holidayET;
	}


	@Override
	public String toString() {
		return "WorkingHours [id=" + id + ", workdayST=" + workdayST + ", workdayET=" + workdayET + ", saturdayST="
				+ saturdayST + ", saturdayET=" + saturdayET + ", sundayST=" + sundayST + ", sundayET=" + sundayET
				+ ", holidayST=" + holidayST + ", holidayET=" + holidayET + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((holidayET == null) ? 0 : holidayET.hashCode());
		result = prime * result + ((holidayST == null) ? 0 : holidayST.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((saturdayET == null) ? 0 : saturdayET.hashCode());
		result = prime * result + ((saturdayST == null) ? 0 : saturdayST.hashCode());
		result = prime * result + ((sundayET == null) ? 0 : sundayET.hashCode());
		result = prime * result + ((sundayST == null) ? 0 : sundayST.hashCode());
		result = prime * result + ((workdayET == null) ? 0 : workdayET.hashCode());
		result = prime * result + ((workdayST == null) ? 0 : workdayST.hashCode());
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
		WorkingHours other = (WorkingHours) obj;
		if (holidayET == null) {
			if (other.holidayET != null)
				return false;
		} else if (!holidayET.equals(other.holidayET))
			return false;
		if (holidayST == null) {
			if (other.holidayST != null)
				return false;
		} else if (!holidayST.equals(other.holidayST))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (saturdayET == null) {
			if (other.saturdayET != null)
				return false;
		} else if (!saturdayET.equals(other.saturdayET))
			return false;
		if (saturdayST == null) {
			if (other.saturdayST != null)
				return false;
		} else if (!saturdayST.equals(other.saturdayST))
			return false;
		if (sundayET == null) {
			if (other.sundayET != null)
				return false;
		} else if (!sundayET.equals(other.sundayET))
			return false;
		if (sundayST == null) {
			if (other.sundayST != null)
				return false;
		} else if (!sundayST.equals(other.sundayST))
			return false;
		if (workdayET == null) {
			if (other.workdayET != null)
				return false;
		} else if (!workdayET.equals(other.workdayET))
			return false;
		if (workdayST == null) {
			if (other.workdayST != null)
				return false;
		} else if (!workdayST.equals(other.workdayST))
			return false;
		return true;
	}

}
