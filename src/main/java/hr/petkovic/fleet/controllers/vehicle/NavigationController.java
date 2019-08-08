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
import hr.petkovic.fleet.entities.vehicle.Navigation;
import hr.petkovic.fleet.impl.vehicle.NavigationModelServiceImpl;
import hr.petkovic.fleet.impl.vehicle.NavigationServiceImpl;

@Controller
@RequestMapping("/navigation")
public class NavigationController {

	private static Logger logger = LoggerFactory.getLogger(NavigationController.class);

	@Autowired
	private NavigationServiceImpl navigationService;
	@Autowired
	private NavigationModelServiceImpl modelService;

	public NavigationController(NavigationServiceImpl navigationService, NavigationModelServiceImpl modelService) {
		this.navigationService = navigationService;
		this.modelService = modelService;
	}

	// Home admin page
	@GetMapping({ "/administration/", "/administration/{id}" })
	public String getNavigationAdministration(@PathVariable(name = "id", required = false) Long id, Model model) {
		if (id != null) {
			model.addAttribute("navs", navigationService.findNavById(id));
		} else {
			model.addAttribute("navs", navigationService.findAllNavs());
		}
		return "navigation/navAdmin";
	}

	// Adding
	@GetMapping("/add")
	public String getNavigationAdding(Model model, Navigation addNav, HttpSession session) {
		if (session.getAttribute("addingNav") == null || addNav == null) {
			session.setAttribute("addingNav", new Navigation());
			model.addAttribute("addNav", new Navigation());
		} else {
			session.setAttribute("addingNav", addNav);
			model.addAttribute("addingNav", addNav);
		}
		session.setAttribute("action", "adding");
		model.addAttribute("models", modelService.findAllNavModels());
		return "navigation/navAdminAdd";
	}

	@PostMapping("/add/")
	public String addNavigation(Model model, Navigation addNav, String action, HttpSession session) {
		model.addAttribute("oldNav", session.getAttribute("addingNav"));
		if (action.equals("Submit")) {
			navigationService.saveNav(addNav);
		}
		session.removeAttribute("addingNav");
		session.removeAttribute("action");
		return "redirect:/navigation/administration/";
	}

	// Editing
	@GetMapping("/edit/{id}")
	public String getUpdateNav(@PathVariable("id") Long id, Model model, HttpSession session, Navigation editNav) {
		if (session.getAttribute("editedNav") == null || editNav == null || editNav.getModel() == null) {
			session.setAttribute("editedNav", navigationService.findNavById(id));
			model.addAttribute("editNav", navigationService.findNavById(id));
		} else {
			session.setAttribute("editedNav", editNav);
			model.addAttribute("editNav", editNav);
		}
		session.setAttribute("action", "editing");
		model.addAttribute("models", modelService.findAllNavModels());
		return "navigation/navAdminEdit";
	}

	@PostMapping("/edit/{id}")
	public String updateNav(@PathVariable("id") Long id, Model model, Navigation editNav, String action,
			HttpSession session) {
		if (action.equals("Submit")) {
			navigationService.updateNav(id, editNav);
		}
		session.removeAttribute("editedNav");
		session.removeAttribute("action");
		return "redirect:/navigation/administration/";
	}

	@PostMapping("/delete/{id}")
	public String deleteEngine(@PathVariable("id") Long id) {
		navigationService.deleteNavById(id);
		return "redirect:/navigation/administration/";
	}
}
