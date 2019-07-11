package hr.petkovic.fleet.repositories;

import org.springframework.data.repository.CrudRepository;

import hr.petkovic.fleet.entities.vehicle.User;

public interface UsersRepository extends CrudRepository<User, Long> {

}
