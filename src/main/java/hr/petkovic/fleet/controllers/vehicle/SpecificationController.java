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

import hr.petkovic.fleet.entities.office.Office;
import hr.petkovic.fleet.entities.vehicle.CarSpecification;
import hr.petkovic.fleet.impl.vehicle.CarSpecificationServiceImpl;
import hr.petkovic.fleet.impl.vehicle.EngineServiceImpl;

@Controller
@RequestMapping("/specification")
public class SpecificationController {

	private static Logger logger = LoggerFactory.getLogger(SpecificationController.class);

	@Autowired
	private CarSpecificationServiceImpl specService;
	@Autowired
	private EngineServiceImpl engineService;

	public SpecificationController(CarSpecificationServiceImpl specService, EngineServiceImpl engineService) {
		this.specService = specService;
		this.engineService = engineService;
	}

	// Home admin page
	@GetMapping("/administration")
	public String getOfficeAdministration(Model model) {
		model.addAttribute("specs", specService.findAllSpecs());
		return "specAdmin";
	}

	// Adding
	@GetMapping("/add")
	public String getSpecAdding(Model model, CarSpecification addSpec, HttpSession session) {
		if (session.getAttribute("addingSpec") == null || addSpec == null) {
			session.setAttribute("addingSpec", new CarSpecification());
			model.addAttribute("addSpec", new CarSpecification());
		} else {
			session.setAttribute("addingSpec", addSpec);
			model.addAttribute("addSpec", addSpec);
		}
		session.setAttribute("action", "adding");
		model.addAttribute("engines", engineService.findAllEngines());
		return "specAdminAdd";
	}

	@PostMapping("/add/")
	public String addSpec(Model model, CarSpecification addSpec, String action, HttpSession session) {
		model.addAttribute("oldSpec", session.getAttribute("addingSpec"));
		if (action.equals("Submit")) {
			specService.saveSpec(addSpec);
			session.removeAttribute("addingSpec");
			session.removeAttribute("action");
			return "redirect:/specification/administration";
		} else {
			session.removeAttribute("addingOffice");
			session.removeAttribute("action");
			return "redirect:/specification/administration";
		}
	}

	// Editing
	@GetMapping("/edit/{id}")
	public String getUpdateSpec(@PathVariable("id") Long id, Model model, HttpSession session,
			CarSpecification editSpec) {
		if (session.getAttribute("editedSpec") == null || editSpec == null || editSpec.getNumberOfSeats() == null) {
			session.setAttribute("editedSpec", specService.findSpecById(id));
			model.addAttribute("editSpec", specService.findSpecById(id));
		} else {
			session.setAttribute("editedSpec", editSpec);
			model.addAttribute("editSpec", editSpec);
		}
		model.addAttribute("engines", engineService.findAllEngines());
		session.setAttribute("action", "editing");
		return "specAdminEdit";
	}

	@PostMapping("/edit/{id}")
	public String updateOffice(@PathVariable("id") Long id, Model model, CarSpecification editSpec, String action,
			HttpSession session) {
		if (action.equals("Submit")) {
			specService.updateSpec(id, editSpec);
		}
		session.removeAttribute("editedSpec");
		session.removeAttribute("action");
		return "redirect:/specification/administration";
	}

	// Delete
	@PostMapping("/delete/{id}")
	public String deleteSpec(@PathVariable("id") Long id) {
		specService.deleteSpecById(id);
		return "redirect:/specification/administration";
	}
}
