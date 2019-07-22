package hr.petkovic.fleet.service.office;

import java.util.List;

import hr.petkovic.fleet.entities.office.WorkingHours;

public interface WorkingHoursService {

	public abstract List<WorkingHours> findAllWorkingHours();

	public abstract WorkingHours findWorkingHoursById(Long id);

	public abstract void deleteWorkingHoursById(Long id);

	public abstract WorkingHours saveWorkingHours(WorkingHours workingHours);

	public abstract WorkingHours updateWorkingHours(Long id, WorkingHours workingHours);
}
