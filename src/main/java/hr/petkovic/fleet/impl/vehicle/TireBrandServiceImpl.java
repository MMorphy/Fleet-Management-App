package hr.petkovic.fleet.impl.vehicle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.vehicle.TireBrand;
import hr.petkovic.fleet.repositories.vehicle.TireBrandRepository;
import hr.petkovic.fleet.service.vehicle.TireBrandService;

@Service
public class TireBrandServiceImpl implements TireBrandService {

	@Autowired
	private TireBrandRepository brandRepo;

	public TireBrandServiceImpl(TireBrandRepository brandRepo) {
		this.brandRepo = brandRepo;
	}

	@Override
	public List<TireBrand> findAllBrands() {
		return this.brandRepo.findAll();
	}

	@Override
	public TireBrand findBrandById(Long id) {
		try {
			return this.brandRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteBrandById(Long id) {
		this.brandRepo.deleteById(id);
	}

	@Override
	public TireBrand saveBrand(TireBrand brand) {
		return this.brandRepo.save(brand);
	}

	@Override
	public TireBrand updateBrand(Long id, TireBrand brand) {
		Optional<TireBrand> optBrand = this.brandRepo.findById(id);
		if (optBrand.isPresent()) {
			TireBrand brnd = optBrand.get();
			brnd.setBrand(brand.getBrand());
			return this.brandRepo.save(brnd);
		} else {
			return this.brandRepo.save(brand);
		}
	}

}
