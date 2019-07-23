package hr.petkovic.fleet.entities.office;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="workingHours")
public class WorkingHours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Time mondayST;

	private Time mondayET;
	
	private Time tuesdayST;

	private Time tuesdayET;
	
	private Time wednesdayST;

	private Time wednesdayET;
	
	private Time thursdayST;

	private Time thursdayET;
	
	private Time fridayST;

	private Time fridayET;
	
	private Time saturdayST;

	private Time saturdayET;
	
	private Time sundayST;

	private Time sundayET;
	
	private Time holidayST;

	private Time holidayET;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Time getMondayST() {
		return mondayST;
	}

	public void setMondayST(Time mondayST) {
		this.mondayST = mondayST;
	}

	public Time getMondayET() {
		return mondayET;
	}

	public void setMondayET(Time mondayET) {
		this.mondayET = mondayET;
	}

	public Time getTuesdayST() {
		return tuesdayST;
	}

	public void setTuesdayST(Time tuesdayST) {
		this.tuesdayST = tuesdayST;
	}

	public Time getTuesdayET() {
		return tuesdayET;
	}

	public void setTuesdayET(Time tuesdayET) {
		this.tuesdayET = tuesdayET;
	}

	public Time getWednesdayST() {
		return wednesdayST;
	}

	public void setWednesdayST(Time wednesdayST) {
		this.wednesdayST = wednesdayST;
	}

	public Time getWednesdayET() {
		return wednesdayET;
	}

	public void setWednesdayET(Time wednesdayET) {
		this.wednesdayET = wednesdayET;
	}

	public Time getThursdayST() {
		return thursdayST;
	}

	public void setThursdayST(Time thursdayST) {
		this.thursdayST = thursdayST;
	}

	public Time getThursdayET() {
		return thursdayET;
	}

	public void setThursdayET(Time thursdayET) {
		this.thursdayET = thursdayET;
	}

	public Time getFridayST() {
		return fridayST;
	}

	public void setFridayST(Time fridayST) {
		this.fridayST = fridayST;
	}

	public Time getFridayET() {
		return fridayET;
	}

	public void setFridayET(Time fridayET) {
		this.fridayET = fridayET;
	}

	public Time getSaturdayST() {
		return saturdayST;
	}

	public void setSaturdayST(Time saturdayST) {
		this.saturdayST = saturdayST;
	}

	public Time getSaturdayET() {
		return saturdayET;
	}

	public void setSaturdayET(Time saturdayET) {
		this.saturdayET = saturdayET;
	}

	public Time getSundayST() {
		return sundayST;
	}

	public void setSundayST(Time sundayST) {
		this.sundayST = sundayST;
	}

	public Time getSundayET() {
		return sundayET;
	}

	public void setSundayET(Time sundayET) {
		this.sundayET = sundayET;
	}

	public Time getHolidayST() {
		return holidayST;
	}

	public void setHolidayST(Time holidayST) {
		this.holidayST = holidayST;
	}

	public Time getHolidayET() {
		return holidayET;
	}

	public void setHolidayET(Time holidayET) {
		this.holidayET = holidayET;
	}

	@Override
	public String toString() {
		return "WorkingHours [id=" + id + ", mondayST=" + mondayST + ", mondayET=" + mondayET + ", tuesdayST="
				+ tuesdayST + ", tuesdayET=" + tuesdayET + ", wednesdayST=" + wednesdayST + ", wednesdayET="
				+ wednesdayET + ", thursdayST=" + thursdayST + ", thursdayET=" + thursdayET + ", fridayST=" + fridayST
				+ ", fridayET=" + fridayET + ", saturdayST=" + saturdayST + ", saturdayET=" + saturdayET + ", sundayST="
				+ sundayST + ", sundayET=" + sundayET + ", holidayST=" + holidayST + ", holidayET=" + holidayET + "]";
	}
}
