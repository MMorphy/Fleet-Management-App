package hr.petkovic.fleet.service.rent;

import java.util.List;

import hr.petkovic.fleet.entities.rent.Option;
import hr.petkovic.fleet.entities.rent.Reservation;
import hr.petkovic.fleet.entities.vehicle.CarGroup;

public interface OptionService {

	public abstract List<Option> findAllOptions();

	public abstract Option findOptionById(Long id);

	public abstract void deleteOptionById(Long id);

	public abstract Option saveOption(Option option);

	public abstract Option updateOption(Long id, Option option);

	public abstract Option findOptionByGroupAndCode(CarGroup group, String code);

	public abstract List<Option> findAllOptionsForGroup(CarGroup group);

	public abstract List<Option> findAllOptionsForReservation(Reservation res);
}
