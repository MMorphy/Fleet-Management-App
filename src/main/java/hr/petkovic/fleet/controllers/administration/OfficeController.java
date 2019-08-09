package hr.petkovic.fleet.controllers.administration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

import hr.petkovic.fleet.entities.office.Office;
import hr.petkovic.fleet.entities.office.Role;
import hr.petkovic.fleet.entities.office.User;
import hr.petkovic.fleet.entities.office.UserDTO;
import hr.petkovic.fleet.entities.vehicle.Vehicle;
import hr.petkovic.fleet.entities.vehicle.VehicleAndOfficeDTO;
import hr.petkovic.fleet.impl.office.OfficeServiceImpl;
import hr.petkovic.fleet.impl.office.RoleServiceImpl;
import hr.petkovic.fleet.impl.office.UsersServiceImpl;
import hr.petkovic.fleet.impl.office.WorkingHoursServiceImpl;
import hr.petkovic.fleet.impl.vehicle.VehicleServiceImpl;

@Controller
@RequestMapping("/office")
public class OfficeController {

	private static Logger logger = LoggerFactory.getLogger(OfficeController.class);

	@Autowired
	private OfficeServiceImpl officeService;
	@Autowired
	private WorkingHoursServiceImpl whService;
	@Autowired
	private RoleServiceImpl roleService;
	@Autowired
	private VehicleServiceImpl vehicleService;

	public OfficeController(OfficeServiceImpl officeService, WorkingHoursServiceImpl whService,
			RoleServiceImpl roleService, VehicleServiceImpl vehicleService) {
		this.officeService = officeService;
		this.whService = whService;
		this.roleService = roleService;
		this.vehicleService = vehicleService;
	}

	// Home admin page
	@GetMapping({ "/administration/", "/administration/{id}" })
	public String getOfficeAdministration(@PathVariable(name = "id", required = false) Long id, Model model) {
		if (id != null) {
			model.addAttribute("offices", officeService.findOfficeById(id));
		} else {
			model.addAttribute("offices", officeService.findAllOffices());
		}
		return "office/officeAdmin";
	}

	// Adding
	@GetMapping("/add")
	public String getOfficeAdding(Model model, Office addOffice, HttpSession session) {
		if (session.getAttribute("addingOffice") == null || addOffice == null) {
			session.setAttribute("addingOffice", new Office());
			model.addAttribute("addOffice", new Office());
		} else {
			session.setAttribute("addingOffice", addOffice);
			model.addAttribute("addOffice", addOffice);
		}
		session.setAttribute("action", "adding");
		return "office/officeAdminAdd";
	}

	@PostMapping("/add/")
	public String addOffice(Model model, Office addOffice, String action, HttpSession session) {
		model.addAttribute("oldOffice", session.getAttribute("addingOffice"));
		if (action.equals("Pick")) {
			model.addAttribute("addOffice", addOffice);
			session.setAttribute("addingOffice", addOffice);
			model.addAttribute("hours", whService.findAllWorkingHours());
			return "office/workingHoursPicker";
		} else if (action.equals("Submit")) {
			officeService.saveOffice(addOffice);
		}
		session.removeAttribute("addingOffice");
		session.removeAttribute("action");
		return "redirect:/office/administration/";

	}

	// Editing
	@GetMapping("/edit/{id}")
	public String getUpdateOffice(@PathVariable("id") Long id, Model model, HttpSession session, Office editOffice) {
		if (session.getAttribute("editedOffice") == null || editOffice == null || editOffice.getName() == null) {
			session.setAttribute("editedOffice", officeService.findOfficeById(id));
			model.addAttribute("editOffice", officeService.findOfficeById(id));
		} else {
			session.setAttribute("editedOffice", editOffice);
			model.addAttribute("editOffice", editOffice);
		}
		session.setAttribute("action", "editing");
		return "office/officeAdminEdit";
	}

	@PostMapping("/edit/{id}")
	public String updateOffice(@PathVariable("id") Long id, Model model, Office editOffice, String action,
			HttpSession session) {
		if (action.equals("Pick")) {
			session.setAttribute("editedOffice", editOffice);
			model.addAttribute("editOffice", editOffice);
			model.addAttribute("hours", whService.findAllWorkingHours());
			return "office/workingHoursPicker";
		} else if (action.equals("Submit")) {
			officeService.updateOffice(id, editOffice);
		}
		session.removeAttribute("editedOffice");
		session.removeAttribute("action");
		return "redirect:/office/administration/";
	}

	@PostMapping("/delete/{id}")
	public String deleteOffice(@PathVariable("id") Long id) {
		officeService.deleteOfficeById(id);
		return "redirect:/office/administration/";
	}

	@GetMapping("/whpick/")
	public String getWorkingHoursPicker(Model model, Office officeInEdit) {
		logger.info(officeInEdit.getName());
		model.addAttribute("hours", whService.findAllWorkingHours());
		return "office/workingHoursPicker";
	}

	@GetMapping("/vehicles/{id}")
	public String getOfficeVehicles(@PathVariable(name = "id", required = true) Long id, Model model) {
		model.addAttribute("officeID", id);
		Set<Vehicle> vehicles = officeService.findOfficeById(id).getVehiclePool();
		List<Vehicle> miniVehicles = new ArrayList<>();
		List<Vehicle> economyVehicles = new ArrayList<>();
		List<Vehicle> compactVehicles = new ArrayList<>();
		List<Vehicle> intermediateVehicles = new ArrayList<>();
		List<Vehicle> familyVehicles = new ArrayList<>();
		List<Vehicle> premiumVehicles = new ArrayList<>();
		for (Vehicle vehicle : vehicles) {
			switch (vehicle.getCarGroup().getCarGroup()) {
			case "Mini":
				miniVehicles.add(vehicle);
				break;
			case "Economy":
				economyVehicles.add(vehicle);
				break;
			case "Compact":
				compactVehicles.add(vehicle);
				break;
			case "Intermediate":
				intermediateVehicles.add(vehicle);
				break;
			case "Family":
				familyVehicles.add(vehicle);
				break;
			case "Premium":
				premiumVehicles.add(vehicle);
				break;
			}
		}
		model.addAttribute("mVehicles", miniVehicles);
		model.addAttribute("eVehicles", economyVehicles);
		model.addAttribute("cVehicles", compactVehicles);
		model.addAttribute("iVehicles", intermediateVehicles);
		model.addAttribute("fVehicles", familyVehicles);
		model.addAttribute("pVehicles", premiumVehicles);
		return "office/officeVehicles";
	}

	@GetMapping("/requestVehicle/{group}/{officeID}")
	public String getRequestVehicle(@PathVariable(name = "group") String carGroup,
			@PathVariable(name = "officeID", required = true) Long officeID, Model model) {
		List<Vehicle> vehicles = vehicleService.findAllUnrentedVehiclesByCarGroup(carGroup);
		vehicles.removeAll(officeService.findOfficeById(officeID).getVehiclePool());
		logger.info(vehicles.toString());
		List<VehicleAndOfficeDTO> dtos = new ArrayList<>();
		Office office = null;
		for (Vehicle vehicle : vehicles) {
			office = officeService.findOfficeByVehicle(vehicle);
			dtos.add(new VehicleAndOfficeDTO(vehicle, office));
		}
		model.addAttribute("vehicles", dtos);
		model.addAttribute("officeID", officeID);
		model.addAttribute("carGroup", carGroup);
		return "office/transferAdmin";
	}

	@PostMapping("/requestVehicle/{group}/{officeID}/{vehicleID}")
	public String getTransferVehicle(@PathVariable(name = "group") String carGroup,
			@PathVariable(name = "officeID", required = true) Long officeID,
			@PathVariable(name = "vehicleID", required = true) Long vehicleID, Model model) {
		List<Vehicle> vehicles = vehicleService.findAllUnrentedVehiclesByCarGroup(carGroup);
		vehicles.removeAll(officeService.findOfficeById(officeID).getVehiclePool());
		List<VehicleAndOfficeDTO> dtos = new ArrayList<>();
		Office office = null;
		for (Vehicle vehicle : vehicles) {
			office = officeService.findOfficeByVehicle(vehicle);
			dtos.add(new VehicleAndOfficeDTO(vehicle, office));
		}
		office = officeService.findOfficeById(officeID);
		Vehicle vehicle = vehicleService.findVehicleById(vehicleID);
		office.addVehicle(vehicle);
		officeService.updateOffice(officeID, office);
		model.addAttribute("vehicles", dtos);
		model.addAttribute("officeID", officeID);
		model.addAttribute("carGroup", carGroup);
		return "redirect:/office/vehicles/{officeID}";
	}

	public User convertDTOToUser(UserDTO dto) {
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

	public UserDTO convertUserToDTO(User user) {
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
