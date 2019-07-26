package hr.petkovic.fleet.controllers.vehicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.petkovic.fleet.impl.vehicle.TireServiceImpl;

@Controller
@RequestMapping("/tires")
public class TireController {

	private static Logger logger = LoggerFactory.getLogger(TireController.class);

	@Autowired
	private TireServiceImpl tireService;

	public TireController(TireServiceImpl tireService) {
		this.tireService = tireService;
	}

	@GetMapping("/administration")
	public String getTireAdministration(Model model) {
		model.addAttribute("tires", tireService.findAllTires());
		return "tiresAdmin";
	}
}
