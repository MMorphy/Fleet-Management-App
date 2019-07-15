package hr.petkovic.fleet.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.vehicle.User;

public interface UsersRepository extends JpaRepository<User, Long> {

	List<User> findAll();

	Optional<User> findById(Long id);

	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);

	void deleteById(Long id);

	User save(User user);

	
}
