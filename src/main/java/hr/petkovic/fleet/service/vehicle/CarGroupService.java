package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.CarGroup;

public interface CarGroupService {

	public abstract List<CarGroup> findAllGroups();

	public abstract CarGroup findGroupById(Long id);

	public abstract CarGroup findGroupByName(String groupName);

	public abstract void deleteCarGroupById(Long id);

	public abstract CarGroup saveGroup(CarGroup group);

	public abstract CarGroup updateGroup(Long id, CarGroup group);
}
