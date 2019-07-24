package hr.petkovic.fleet.impl.office;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.office.User;
import hr.petkovic.fleet.repositories.office.UsersRepository;
import hr.petkovic.fleet.service.office.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository userRepo;

	public UsersServiceImpl(UsersRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public List<User> findAllUsers() {
		return this.userRepo.findAll();
	}

	@Override
	public User findUserById(Long id) {
		try {
			return this.userRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteUserById(Long id) {
		this.userRepo.deleteById(id);
	}

	@Override
	public User saveUser(User user) {
		return this.userRepo.saveAndFlush(user);
	}

	@Override
	public User updateUser(Long id, User user) {
		Optional<User> usr = this.userRepo.findById(id);
		if (usr.isPresent()) {
			User us = usr.get();
			us.setEmail(user.getEmail());
			us.setRoles(user.getRoles());
			//// TODO stavi bcrypt
			us.setPassword(user.getPassword());
			us.setUsername(user.getUsername());
			this.userRepo.save(us);
			return us;
		} else {
			this.userRepo.save(user);
			return user;
		}
	}
}
