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

import hr.petkovic.fleet.entities.vehicle.Engine;
import hr.petkovic.fleet.impl.vehicle.EngineServiceImpl;
import hr.petkovic.fleet.impl.vehicle.FuelTypeServiceImpl;

@Controller
@RequestMapping("/engine")
public class EngineController {

	private static Logger logger = LoggerFactory.getLogger(EngineController.class);

	@Autowired
	private EngineServiceImpl engineService;
	@Autowired
	private FuelTypeServiceImpl fuelService;

	public EngineController(EngineServiceImpl engineService, FuelTypeServiceImpl fuelService) {
		this.engineService = engineService;
		this.fuelService = fuelService;
	}

	// Home admin page
	@GetMapping({ "/administration/", "/administration/{id}" })
	public String getEngineAdministration(@PathVariable(name = "id", required = false) Long id, Model model) {
		if (id != null) {
			model.addAttribute("engines", engineService.findEnginebyId(id));
		} else {
			model.addAttribute("engines", engineService.findAllEngines());
		}
		return "engineAdmin";
	}

	// Adding
	@GetMapping("/add")
	public String getEngineAdding(Model model, Engine addEngine, HttpSession session) {
		if (session.getAttribute("addingEngine") == null || addEngine == null) {
			session.setAttribute("addingEngine", new Engine());
			model.addAttribute("addEngine", new Engine());
		} else {
			session.setAttribute("addingEngine", addEngine);
			model.addAttribute("addEngine", addEngine);
		}
		session.setAttribute("action", "adding");
		model.addAttribute("fuelTypes", fuelService.findAllFuelTypes());
		return "engineAdminAdd";
	}

	@PostMapping("/add/")
	public String addEngine(Model model, Engine addEngine, String action, HttpSession session) {
		model.addAttribute("oldEngine", session.getAttribute("addingEngine"));
		if (action.equals("Submit")) {
			engineService.saveEngine(addEngine);
			session.removeAttribute("addingEngine");
			session.removeAttribute("action");
			return "redirect:/engine/administration/";
		} else {
			session.removeAttribute("addingEngine");
			session.removeAttribute("action");
			return "redirect:/engine/administration/";
		}
	}

	// Editing
	@GetMapping("/edit/{id}")
	public String getUpdateOffice(@PathVariable("id") Long id, Model model, HttpSession session, Engine editEngine) {
		if (session.getAttribute("editedEngine") == null || editEngine == null || editEngine.getMaxPower() == null) {
			session.setAttribute("editedEngine", engineService.findEnginebyId(id));
			model.addAttribute("editEngine", engineService.findEnginebyId(id));
		} else {
			session.setAttribute("editedEngine", editEngine);
			model.addAttribute("editEngine", editEngine);
		}
		session.setAttribute("action", "editing");
		model.addAttribute("fuelTypes", fuelService.findAllFuelTypes());
		return "engineAdminEdit";
	}

	@PostMapping("/edit/{id}")
	public String updateEngine(@PathVariable("id") Long id, Model model, Engine editEngine, String action,
			HttpSession session) {
		if (action.equals("Submit")) {
			engineService.updateEngine(id, editEngine);
		}
		session.removeAttribute("editedOffice");
		session.removeAttribute("action");
		return "redirect:/engine/administration/";
	}

	// Delete
	@PostMapping("/delete/{id}")
	public String deleteEngine(@PathVariable("id") Long id) {
		engineService.deleteEngineById(id);
		return "redirect:/engine/administration/";
	}
}
