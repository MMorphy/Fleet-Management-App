package hr.petkovic.fleet.controllers.vehicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.petkovic.fleet.impl.vehicle.CarDamageServiceImpl;
import hr.petkovic.fleet.impl.vehicle.CarDamageSizeServiceImpl;
import hr.petkovic.fleet.impl.vehicle.CarDamageTypeServiceImpl;

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

	public DamageController(CarDamageServiceImpl damageService, CarDamageSizeServiceImpl damageSizeService, CarDamageTypeServiceImpl damageTypeService) {
		this.damageService = damageService;
		this.damageSizeService = damageSizeService;
		this.damageTypeService = damageTypeService;
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

	@GetMapping("/administration/vehicle/{id}")
	public String getDamageAdministrationForVehicle(@PathVariable(name="id", required=true) Long id, Model model) {
		model.addAttribute("damages", damageService.findDamagesForVehicle(id));
		return "damageAdmin";
	}
}
