package hr.petkovic.fleet.controllers.administration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.petkovic.fleet.repositories.UsersRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	private UsersRepository userRepo;

	public UserController(UsersRepository userRepo) 
	{
		this.userRepo = userRepo;
	}
}
