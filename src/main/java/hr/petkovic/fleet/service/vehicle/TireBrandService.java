package hr.petkovic.fleet.service.vehicle;

import java.util.List;

import hr.petkovic.fleet.entities.vehicle.TireBrand;

public interface TireBrandService {

	public abstract List<TireBrand> findAllBrands();

	public abstract TireBrand findBrandById(Long id);

	public abstract void deleteBrandById(Long id);

	public abstract TireBrand saveBrand(TireBrand brand);

	public abstract TireBrand updateBrand(Long id, TireBrand brand);
}
