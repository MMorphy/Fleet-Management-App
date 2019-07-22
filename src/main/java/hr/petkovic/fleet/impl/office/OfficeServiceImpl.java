package hr.petkovic.fleet.impl.office;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.office.Office;
import hr.petkovic.fleet.repositories.office.OfficeRepository;
import hr.petkovic.fleet.service.office.OfficeService;

@Service
public class OfficeServiceImpl implements OfficeService {

	@Autowired
	private OfficeRepository officeRepo;

	public OfficeServiceImpl(OfficeRepository officeRepo) {
		this.officeRepo = officeRepo;
	}

	@Override
	public List<Office> findAllOffices() {
		return this.officeRepo.findAll();
	}

	@Override
	public Office findOfficeById(Long id) {
		try {
			return this.officeRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteOfficeById(Long id) {
		this.officeRepo.deleteById(id);
	}

	@Override
	public Office saveOffice(Office office) {
		return this.officeRepo.saveAndFlush(office);
	}

	@Override
	public Office updateOffice(Long id, Office office) {
		Optional<Office> optOff = this.officeRepo.findById(id);
		if (optOff.isPresent()) {
			Office off = optOff.get();
			off.setAddress(office.getAddress());
			off.setEmployees(office.getEmployees());
			off.setName(office.getName());
			off.setVehiclePool(office.getVehiclePool());
			off.setWorkingHours(office.getWorkingHours());
			return this.officeRepo.save(off);
		} else {
			return this.officeRepo.save(office);
		}
	}

}
