package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.Tire;
import hr.petkovic.fleet.repositories.vehicle.TireRepository;
import hr.petkovic.fleet.service.vehicle.TireService;

@Service
public class TireServiceImpl implements TireService {

	@Autowired
	private TireRepository tireRepo;

	public TireServiceImpl(TireRepository tireRepo) {
		this.tireRepo = tireRepo;
	}

	@Override
	public List<Tire> findAllTires() {
		return this.tireRepo.findAll();
	}

	@Override
	public Tire findTireById(Long id) {
		try {
			return this.tireRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteTireById(Long id) {
		this.tireRepo.deleteById(id);
	}

	@Override
	public Tire saveTire(Tire tire) {
		return this.tireRepo.save(tire);
	}

	@Override
	public Tire updateTire(Long id, Tire tire) {
		Optional<Tire> optTire = this.tireRepo.findById(id);
		if (optTire.isPresent()) {
			Tire tir = optTire.get();
			tir.setAspectRatio(tire.getAspectRatio());
			tir.setManufacturingYear(tire.getManufacturingYear());
			tir.setTireBrand(tire.getTireBrand());
			tir.setTireType(tire.getTireType());
			tir.setVehicle(tire.getVehicle());
			tir.setWheelDiameter(tire.getWheelDiameter());
			tir.setWheelType(tire.getWheelType());
			tir.setWidth(tire.getWidth());
			return this.saveTire(tir);
		} else {
			return this.saveTire(tire);
		}
	}

}
