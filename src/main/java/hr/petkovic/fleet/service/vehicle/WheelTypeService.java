package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.WheelType;

public interface WheelTypeService {

	public abstract List<WheelType> findAllTypes();

	public abstract WheelType findTypeById(Long id);

	public abstract void deleteTypeById(Long id);

	public abstract WheelType saveType(WheelType type);

	public abstract WheelType updateType(Long id, WheelType type);
}
