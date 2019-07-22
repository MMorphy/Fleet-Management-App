package hr.petkovic.fleet.service.office;

import java.util.List;

import hr.petkovic.fleet.entities.office.Office;

public interface OfficeService {

	public abstract List<Office> findAllOffices();

	public abstract Office findOfficeById(Long id);

	public abstract void deleteOfficeById(Long id);

	public abstract Office saveOffice(Office office);

	public abstract Office updateOffice(Long id, Office office);
}
