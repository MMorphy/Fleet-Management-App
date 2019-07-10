package hr.petkovic.fleet.repositories;

import org.springframework.data.repository.CrudRepository;

import hr.petkovic.fleet.entities.User;

public interface UsersRepository extends CrudRepository<User, Long> {

}
