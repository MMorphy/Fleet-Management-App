package hr.petkovic.fleet.repositories.office;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.petkovic.fleet.entities.office.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	List<Role> findAll();

	List<Role> findByUsers_Username(String username);

	Optional<Role> findById(Long id);

	Optional<Role> findByName(String name);

	void deleteById(Long id);

	Role save (Role role);
}
