package hr.petkovic.fleet.controllers.administration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.petkovic.fleet.entities.office.Role;
import hr.petkovic.fleet.entities.office.User;
import hr.petkovic.fleet.entities.office.UserDTO;
import hr.petkovic.fleet.impl.office.RoleServiceImpl;
import hr.petkovic.fleet.impl.office.UsersServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UsersServiceImpl userService;

	@Autowired
	private RoleServiceImpl roleService;

	public UserController(UsersServiceImpl userService, RoleServiceImpl roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

	@GetMapping("/administration")
	public String getUserAdministration(Model model) {
		List<User> users = userService.findAllUsers();
		List<UserDTO> userDTOs = new ArrayList<>();
		for (User user : users) {
			userDTOs.add(convertObjectToDTO(user));
		}
		model.addAttribute("users", userDTOs);
		return "userAdmin";
	}

	@GetMapping("/add")
	public String getUserAdding(Model model, UserDTO addUser, HttpSession session) {
		if (session.getAttribute("addingUser") == null || addUser == null) {
			session.setAttribute("addingUser", new UserDTO());
			model.addAttribute("addUser", new UserDTO());
		} else {
			session.setAttribute("addingUser", addUser);
			model.addAttribute("addUser", addUser);
		}
		session.setAttribute("action", "adding");
		return "userAdminAdd";
	}

	@PostMapping("/add")
	public String addUser(Model model, UserDTO addUser, String action, HttpSession session) {
		model.addAttribute("oldUser", session.getAttribute("addingUser"));
		if (action.equals("Submit")) {
			LocalDateTime time = LocalDateTime.now();
			addUser.setCreateTS(time);
			addUser.setLastChangeTS(time);
			userService.saveUser(convertDTOToObject(addUser));
			session.removeAttribute("addingUser");
			session.removeAttribute("action");
		} else {
			session.removeAttribute("addingUser");
			session.removeAttribute("action");
		}

		return "redirect:/user/administration";
	}

	@GetMapping("/edit/{id}")
	public String getUpdateUser(@PathVariable("id") Long id, Model model, HttpSession session, UserDTO editUser) {
		if (session.getAttribute("editedUser") == null || editUser == null || editUser.getUsername() == null) {
			session.setAttribute("editedUser", convertObjectToDTO(userService.findUserById(id)));
			model.addAttribute("editUser", convertObjectToDTO(userService.findUserById(id)));
		} else {
			session.setAttribute("editedUser", editUser);
			model.addAttribute("editUser", editUser);
		}
		session.setAttribute("action", "editing");
		return "userAdminEdit";
	}

	@PostMapping("/edit/{id}")
	public String updateUser(@PathVariable("id") Long id, Model model, HttpSession session, UserDTO user) {
		userService.updateUser(id, convertDTOToObject(user));
		return "redirect:/user/administration";
	}

	@PostMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
		return "redirect:/user/administration";
	}

	private User convertDTOToObject(UserDTO dto) {
		User user = new User();
		user.setCreateTS(dto.getCreateTS());
		user.setLastChangeTS(dto.getLastChangeTS());
		user.setEmail(dto.getEmail());
		user.setId(dto.getId());
		user.setPassword(dto.getPassword());
		user.setUsername(dto.getUsername());
		Role role = new Role();
		List<Role> roles = new ArrayList<>();
		if (dto.isAdmin()) {
			role = roleService.findRoleByName("ROLE_ADMIN");
			if (role != null) {
				roles.add(role);
			}
		}
		if (dto.isOper()) {
			role = roleService.findRoleByName("ROLE_OPER");
			if (role != null) {
				roles.add(role);
			}
		}
		if (dto.isUser()) {
			role = roleService.findRoleByName("ROLE_USER");
			if (role != null) {
				roles.add(role);
			}
		}
		user.setRoles(roles);
		return user;
	}

	private UserDTO convertObjectToDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setCreateTS(user.getCreateTS());
		dto.setEmail(user.getEmail());
		dto.setId(user.getId());
		dto.setLastChangeTS(user.getLastChangeTS());
		dto.setPassword(user.getPassword());
		dto.setUsername(user.getUsername());
		dto.setAdmin(false);
		dto.setOper(false);
		dto.setUser(false);
		for (Role role : user.getRoles()) {
			switch (role.getName()) {
			case "ROLE_ADMIN":
				dto.setAdmin(true);
				break;
			case "ROLE_OPER":
				dto.setOper(true);
				break;
			case "ROLE_USER":
				dto.setUser(true);
				break;
			}
		}
		return dto;
	}
}
