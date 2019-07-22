package hr.petkovic.fleet.controllers.administration;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.petkovic.fleet.entities.office.User;
import hr.petkovic.fleet.impl.office.UsersServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UsersServiceImpl userService;

	public UserController(UsersServiceImpl userService) {
		this.userService = userService;
	}

	@GetMapping("/administration")
	public String getUserAdministration(Model model) {
		model.addAttribute("users", userService.findAllUsers());
		return "userAdmin";
	}

	@GetMapping("/add")
	public String getUserAdding(Model model) {
		model.addAttribute("user", new User());
		return "userAdminAdd";
	}

	@PostMapping("/add")
	public String addUser(User user) {
		LocalDateTime time = LocalDateTime.now();
		user.setCreateTS(time);
		user.setLastChangeTS(time);
		userService.saveUser(user);
		return "redirect:/user/administration";
	}

	@GetMapping("/edit/{id}")
	public String getUpdateUser(@PathVariable("id") String id, Model model) {
		model.addAttribute("user", userService.findUserById(Long.parseLong(id)));
		return "userAdminEdit";
	}

	@PostMapping("/edit/{id}")
	public String updateUser(@PathVariable("id") String id, User user) {
		userService.updateUser(Long.parseLong(id), user).toString();
		return "redirect:/user/administration";
	}
	@PostMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") String id) {
		userService.deleteUserById(Long.parseLong(id));
		return "redirect:/user/administration";
	}

}
