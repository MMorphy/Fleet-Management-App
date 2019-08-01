package hr.petkovic.fleet.impl.rent;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.rent.Option;
import hr.petkovic.fleet.entities.rent.RentalAgreement;
import hr.petkovic.fleet.entities.rent.Reservation;
import hr.petkovic.fleet.entities.vehicle.CarGroup;
import hr.petkovic.fleet.repositories.rent.OptionRepository;
import hr.petkovic.fleet.service.rent.OptionService;

@Service
public class OptionServiceImpl implements OptionService {

	@Autowired
	private OptionRepository optionRepo;

	public OptionServiceImpl(OptionRepository optionRepo) {
		this.optionRepo = optionRepo;
	}

	@Override
	public List<Option> findAllOptions() {
		return this.optionRepo.findAll();
	}

	@Override
	public Option findOptionById(Long id) {
		try {
			return this.optionRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteOptionById(Long id) {
		this.optionRepo.deleteById(id);
	}

	@Override
	public Option saveOption(Option option) {
		return this.optionRepo.save(option);
	}

	@Override
	public Option updateOption(Long id, Option option) {
		Optional<Option> optOption = this.optionRepo.findById(id);
		if (optOption.isPresent()) {
			Option opt = optOption.get();
			opt.setCarGroup(option.getCarGroup());
			opt.setCode(option.getCode());
			opt.setName(option.getName());
			opt.setPrice(option.getPrice());
			opt.setRa(option.getRa());
			opt.setReservation(option.getReservation());
			return this.optionRepo.save(opt);
		} else {
			return this.optionRepo.save(option);
		}
	}

	@Override
	public List<Option> findAllOptionsForGroup(CarGroup group) {
		return this.optionRepo.findByCarGroup_carGroup(group.getGroup());
	}

	@Override
	public List<Option> findAllOptionsForRent(RentalAgreement ra) {
		return this.optionRepo.findByRa_id(ra.getId());
	}

	@Override
	public List<Option> findAllOptionsForReservation(Reservation res) {
		return this.optionRepo.findByReservation_id(res.getId());
	}

	@Override
	public Option findOptionByGroupAndCode(CarGroup group, String code) {
		try {
			return this.optionRepo.findByCarGroup_carGroupAndCode(group.getGroup(), code).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}
}
