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
}
