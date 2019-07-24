package hr.petkovic.fleet.entities.office;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "workingHours")
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

}
