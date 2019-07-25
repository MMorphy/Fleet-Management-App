package hr.petkovic.fleet.controllers.vehicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.petkovic.fleet.impl.vehicle.VehicleServiceImpl;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

	private static Logger logger = LoggerFactory.getLogger(VehicleController.class);

	@Autowired
	private VehicleServiceImpl vehicleService;

	public VehicleController(VehicleServiceImpl vehicleService) {
		this.vehicleService = vehicleService;
	}

	@GetMapping("/administration")
	public String getVehicleAdministration(Model model) {
		model.addAttribute("vehicles", vehicleService.findAllVehicles());
		return "vehicleAdmin";
	}

}
