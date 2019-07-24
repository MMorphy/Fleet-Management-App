package hr.petkovic.fleet.entities.office;

public class WorkingHoursDTO {

	private String workdayST;

	private String workdayET;

	private String saturdayST;

	private String saturdayET;

	private String sundayST;

	private String sundayET;

	private String holidayST;

	private String holidayET;

	public String getWorkdayST() {
		return workdayST;
	}

	public void setWorkdayST(String workdayST) {
		this.workdayST = workdayST;
	}

	public String getWorkdayET() {
		return workdayET;
	}

	public void setWorkdayET(String workdayET) {
		this.workdayET = workdayET;
	}

	public String getSaturdayST() {
		return saturdayST;
	}

	public void setSaturdayST(String saturdayST) {
		this.saturdayST = saturdayST;
	}

	public String getSaturdayET() {
		return saturdayET;
	}

	public void setSaturdayET(String saturdayET) {
		this.saturdayET = saturdayET;
	}

	public String getSundayST() {
		return sundayST;
	}

	public void setSundayST(String sundayST) {
		this.sundayST = sundayST;
	}

	public String getSundayET() {
		return sundayET;
	}

	public void setSundayET(String sundayET) {
		this.sundayET = sundayET;
	}

	public String getHolidayST() {
		return holidayST;
	}

	public void setHolidayST(String holidayST) {
		this.holidayST = holidayST;
	}

	public String getHolidayET() {
		return holidayET;
	}

	public void setHolidayET(String holidayET) {
		this.holidayET = holidayET;
	}

	@Override
	public String toString() {
		return "WorkingHoursDTO [workdayST=" + workdayST + ", workdayET=" + workdayET + ", saturdayST=" + saturdayST
				+ ", saturdayET=" + saturdayET + ", sundayST=" + sundayST + ", sundayET=" + sundayET + ", holidayST="
				+ holidayST + ", holidayET=" + holidayET + "]";
	}

}
