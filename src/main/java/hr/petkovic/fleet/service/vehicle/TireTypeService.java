package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.TireType;

public interface TireTypeService {

	public abstract List<TireType> findAllTypes();

	public abstract TireType findTypeById(Long id);

	public abstract void deleteTypeById(Long id);

	public abstract TireType saveType(TireType type);

	public abstract TireType updateType(Long id, TireType type);
}
