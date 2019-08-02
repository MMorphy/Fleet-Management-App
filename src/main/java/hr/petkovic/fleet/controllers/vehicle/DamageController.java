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

import hr.petkovic.fleet.entities.rent.Option;
import hr.petkovic.fleet.entities.vehicle.CarDamage;
import hr.petkovic.fleet.impl.vehicle.CarDamageServiceImpl;
import hr.petkovic.fleet.impl.vehicle.CarDamageSizeServiceImpl;
import hr.petkovic.fleet.impl.vehicle.CarDamageTypeServiceImpl;
import hr.petkovic.fleet.impl.vehicle.VehicleServiceImpl;

@Controller
@RequestMapping("/damage")
public class DamageController {

	private static Logger logger = LoggerFactory.getLogger(DamageController.class);

	@Autowired
	private CarDamageServiceImpl damageService;
	@Autowired
	private CarDamageSizeServiceImpl damageSizeService;
	@Autowired
	private CarDamageTypeServiceImpl damageTypeService;
	@Autowired
	private VehicleServiceImpl vehicleService;

	public DamageController(CarDamageServiceImpl damageService, CarDamageSizeServiceImpl damageSizeService,
			CarDamageTypeServiceImpl damageTypeService, VehicleServiceImpl vehicleService) {
		this.damageService = damageService;
		this.damageSizeService = damageSizeService;
		this.damageTypeService = damageTypeService;
		this.vehicleService = vehicleService;
	}

	// Home admin page
	@GetMapping({ "/administration/", "/administration/{id}" })
	public String getDamageAdministration(@PathVariable(name = "id", required = false) Long id, Model model) {
		if (id != null) {
			model.addAttribute("damages", damageService.findDamageById(id));
		} else {
			model.addAttribute("damages", damageService.findAllDamages());
		}
		return "damageAdmin";
	}

	// Damages for vehicle
	@GetMapping("/administration/vehicle/{id}")
	public String getDamageAdministrationForVehicle(@PathVariable(name = "id", required = true) Long id, Model model) {
		model.addAttribute("damages", damageService.findDamagesForVehicle(id));
		return "damageAdmin";
	}

	// Adding
	@GetMapping("/add")
	public String getDamageAdding(Model model, CarDamage addDamage, HttpSession session) {
		if (session.getAttribute("addingDamage") == null || addDamage == null) {
			session.setAttribute("addingDamage", new CarDamage());
			model.addAttribute("addDamage", new CarDamage());
		} else {
			session.setAttribute("addingDamage", addDamage);
			model.addAttribute("addDamage", addDamage);
		}
		session.setAttribute("action", "adding");
		model.addAttribute("vehicles", vehicleService.findAllVehicles());
		model.addAttribute("types", damageTypeService.findAllDamageTypes());
		model.addAttribute("sizes", damageSizeService.findAllDamageSizes());
		return "damageAdminAdd";
	}

	@PostMapping("/add/")
	public String addEngine(Model model, CarDamage addDamage, String action, HttpSession session) {
		model.addAttribute("oldDamage", session.getAttribute("addingDamage"));
		if (action.equals("Submit")) {
			damageService.saveDamage(addDamage);
		}
		session.removeAttribute("addingDamage");
		session.removeAttribute("action");
		return "redirect:/damage/administration/";
	}

	// Editing
	@GetMapping("/edit/{id}")
	public String getUpdateOffice(@PathVariable("id") Long id, Model model, HttpSession session, CarDamage editDamage) {
		if (session.getAttribute("editedDamage") == null || editDamage == null || editDamage.getVehicle() == null) {
			session.setAttribute("editedDamage", damageService.findDamageById(id));
			model.addAttribute("editDamage", damageService.findDamageById(id));
		} else {
			session.setAttribute("editedDamage", editDamage);
			model.addAttribute("editDamage", editDamage);
		}
		session.setAttribute("action", "editing");
		model.addAttribute("vehicles", vehicleService.findAllVehicles());
		model.addAttribute("types", damageTypeService.findAllDamageTypes());
		model.addAttribute("sizes", damageSizeService.findAllDamageSizes());
		return "damageAdminEdit";
	}

	@PostMapping("/edit/{id}")
	public String updateEngine(@PathVariable("id") Long id, Model model, CarDamage editDamage, String action,
			HttpSession session) {
		if (action.equals("Submit")) {
			damageService.updateDamage(id, editDamage);
		}
		session.removeAttribute("editedDamage");
		session.removeAttribute("action");
		return "redirect:/damage/administration/";
	}


	// Delete
	@PostMapping("/delete/{id}")
	public String deleteOption(@PathVariable("id") Long id) {
		damageService.deleteDamageById(id);
		return "redirect:/damage/administration/";
	}
	
	// Fixing damages
	@GetMapping("/fix/{id}")
	public String fixDamage(@PathVariable(name = "id", required = true) Long id) {
		CarDamage damage = damageService.findDamageById(id);
		damage.setRepaired(true);
		damageService.updateDamage(id, damage);
		return "redirect:/damage/administration/";
	}
}
