package hr.petkovic.fleet.service.office;

import java.util.List;

import hr.petkovic.fleet.entities.office.User;

public interface UsersService {

	public abstract List<User> findAllUsers();

	public abstract User findUserById(Long id);

	public abstract void deleteUserById(Long id);

	public abstract User saveUser(User user);

	public abstract User updateUser(Long id, User user);
}
