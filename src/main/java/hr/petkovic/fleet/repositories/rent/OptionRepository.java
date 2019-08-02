package hr.petkovic.fleet.repositories.rent;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.rent.Option;

public interface OptionRepository extends JpaRepository<Option, Long>{

	List<Option> findAll();

	Optional<Option> findById(Long id);

	void deleteById(Long id);

	Option save(Option option);

	Optional<Option> findByCarGroup_carGroupAndCode(String group, String code);

	List<Option> findByCarGroup_carGroup(String group);

	List<Option> findByReservation_id(Long id);
}
