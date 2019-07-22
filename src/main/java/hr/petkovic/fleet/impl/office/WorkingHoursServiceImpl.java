package hr.petkovic.fleet.impl.office;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.office.WorkingHours;
import hr.petkovic.fleet.repositories.office.WorkingHoursRepository;
import hr.petkovic.fleet.service.office.WorkingHoursService;

@Service
public class WorkingHoursServiceImpl implements WorkingHoursService {

	@Autowired
	private WorkingHoursRepository whRepo;

	public WorkingHoursServiceImpl(WorkingHoursRepository whRepo) {
		this.whRepo = whRepo;
	}
	@Override
	public List<WorkingHours> findAllWorkingHours() {
		return this.whRepo.findAll();
	}

	@Override
	public WorkingHours findWorkingHoursById(Long id) {
		try {
			return this.whRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteWorkingHoursById(Long id) {
		this.whRepo.deleteById(id);
	}

	@Override
	public WorkingHours saveWorkingHours(WorkingHours workingHours) {
		return this.whRepo.saveAndFlush(workingHours);
	}

	@Override
	public WorkingHours updateWorkingHours(Long id, WorkingHours workingHours) {
		Optional<WorkingHours> whOpt = whRepo.findById(id);
		if(whOpt.isPresent())
		{
			WorkingHours wh = whOpt.get();
			wh.setFridayET(workingHours.getFridayET());
			wh.setFridayST(workingHours.getFridayST());
			wh.setHolidayET(workingHours.getHolidayET());
			wh.setHolidayST(workingHours.getHolidayST());
			wh.setMondayET(workingHours.getMondayET());
			wh.setMondayST(workingHours.getMondayST());
			wh.setSaturdayET(workingHours.getSaturdayET());
			wh.setSaturdayST(workingHours.getSaturdayST());
			wh.setSundayET(workingHours.getSundayET());
			wh.setSundayST(workingHours.getSundayST());
			wh.setThursdayET(workingHours.getThursdayET());
			wh.setThursdayST(workingHours.getThursdayST());
			wh.setTuesdayET(workingHours.getTuesdayET());
			wh.setTuesdayST(workingHours.getTuesdayST());
			wh.setWednesdayET(workingHours.getWednesdayET());
			wh.setWednesdayST(workingHours.getWednesdayST());
			this.whRepo.save(wh);
			return wh;
		}
		else
		{
			this.whRepo.save(workingHours);
			return workingHours;
		}
	}

}
