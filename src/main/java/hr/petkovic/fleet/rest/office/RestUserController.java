package hr.petkovic.fleet.rest.office;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hr.petkovic.fleet.entities.office.User;
import hr.petkovic.fleet.repositories.office.UsersRepository;

@RestController
//@CrossOrigin
@RequestMapping(path = "/api/user", produces = "application/json")
public class RestUserController {

	private static Logger logger = LoggerFactory.getLogger(RestUserController.class);

	@Autowired
	private final UsersRepository userRepo;

	public RestUserController(UsersRepository userRepo)
	{
		this.userRepo = userRepo;
	}

	@GetMapping
	public Iterable<User> findAll()
	{
		return userRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findOne(@PathVariable Long id)
	{
		Optional<User> user = userRepo.findById(id);
		if (user.isEmpty())
		{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		}
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes="application/json")
	@Transactional
	public User save(@RequestBody User user)
	{
		logger.debug("User" + user.toString());
		return userRepo.saveAndFlush(user);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, User user)
	{
		Optional<User> usr = userRepo.findById(id);
		if (usr.isPresent())
		{
			User us = usr.get();
			us.setAdmin(user.isAdmin());
			us.setEmail(user.getEmail());
			us.setEmployee(user.isEmployee());
			////TODO stavi bcrypt
			us.setPassword(user.getPassword());
			us.setUsername(user.getUsername());
			userRepo.save(us);
			return new ResponseEntity<User>(us, HttpStatus.OK);
		}
		else
		{
			userRepo.save(user);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
	}
}
