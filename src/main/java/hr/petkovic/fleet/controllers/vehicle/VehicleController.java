package hr.petkovic.fleet.controllers.vehicle;

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

import hr.petkovic.fleet.entities.vehicle.Vehicle;
import hr.petkovic.fleet.impl.vehicle.CarDamageServiceImpl;
import hr.petkovic.fleet.impl.vehicle.CarGroupServiceImpl;
import hr.petkovic.fleet.impl.vehicle.CarManufacturerServiceImpl;
import hr.petkovic.fleet.impl.vehicle.CarModelServiceImpl;
import hr.petkovic.fleet.impl.vehicle.CarSpecificationServiceImpl;
import hr.petkovic.fleet.impl.vehicle.NavigationServiceImpl;
import hr.petkovic.fleet.impl.vehicle.TireServiceImpl;
import hr.petkovic.fleet.impl.vehicle.VehicleServiceImpl;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

	private static Logger logger = LoggerFactory.getLogger(VehicleController.class);

	@Autowired
	private VehicleServiceImpl vehicleService;
	@Autowired
	private TireServiceImpl tireService;
	@Autowired
	private CarManufacturerServiceImpl manufacturerService;
	@Autowired
	private CarModelServiceImpl modelService;
	@Autowired
	private CarGroupServiceImpl groupService;
	@Autowired
	private CarSpecificationServiceImpl specService;
	@Autowired
	private NavigationServiceImpl navService;
	@Autowired
	private CarDamageServiceImpl damageService;

	public VehicleController(VehicleServiceImpl vehicleService, TireServiceImpl tireService, CarManufacturerServiceImpl manufacturerService, CarModelServiceImpl modelService, CarGroupServiceImpl groupService, CarSpecificationServiceImpl specService, NavigationServiceImpl navService, CarDamageServiceImpl damageService) {
		this.vehicleService = vehicleService;
		this.tireService = tireService;
		this.manufacturerService = manufacturerService;
		this.modelService = modelService;
		this.groupService = groupService;
		this.specService = specService;
		this.navService = navService;
		this.damageService = damageService;
	}

	// Home admin page
	@GetMapping({ "/administration/", "/administration/{id}" })
	public String getVehicleAdministration(@PathVariable(name = "id", required = false) Long id, Model model) {
		if (id != null) {
			model.addAttribute("vehicles", vehicleService.findVehicleById(id));
		} else {
			model.addAttribute("vehicles", vehicleService.findAllVehicles());
		}
		return "vehicleAdmin";
	}

	// Adding
	@GetMapping("/add")
	public String getVehicleAdding(Model model, Vehicle addVehicle, HttpSession session) {
		if (session.getAttribute("addingVehicle") == null || addVehicle == null) {
			session.setAttribute("addingVehicle", new Vehicle());
			model.addAttribute("addVehicle", new Vehicle());
		} else {
			session.setAttribute("addingVehicle", addVehicle);
			model.addAttribute("addVehicle", addVehicle);
		}
		session.setAttribute("action", "adding");
		model.addAttribute("manufacturers", manufacturerService.findAllManufacturers());
		model.addAttribute("models", modelService.findAllModels());
		model.addAttribute("groups", groupService.findAllGroups());
		model.addAttribute("tires", tireService.findUnusedTires());
		model.addAttribute("specs", specService.findAllSpecs());
		return "vehicleAdminAdd";
	}

	@PostMapping("/add/")
	public String addVehicle(Model model, Vehicle addVehicle, String action, HttpSession session) {
		model.addAttribute("oldVehicle", session.getAttribute("addingVehicle"));
		if (action.equals("Submit")) {
			if(addVehicle.getCurrentKM()==null)
			{
				addVehicle.setCurrentKM(0);
			}
			vehicleService.saveVehicle(addVehicle);
		}
		session.removeAttribute("addingVehicle");
		session.removeAttribute("action");
		return "redirect:/vehicle/administration/";

	}
}
