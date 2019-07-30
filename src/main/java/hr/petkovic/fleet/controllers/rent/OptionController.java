package hr.petkovic.fleet.controllers.rent;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.petkovic.fleet.entities.rent.Option;
import hr.petkovic.fleet.impl.rent.OptionServiceImpl;
import hr.petkovic.fleet.impl.vehicle.CarGroupServiceImpl;

@Controller
@RequestMapping("/option")
public class OptionController {

	@Autowired
	private OptionServiceImpl optionService;
	@Autowired
	private CarGroupServiceImpl groupService;

	public OptionController(OptionServiceImpl optionService, CarGroupServiceImpl groupService) {
		this.optionService = optionService;
		this.groupService = groupService;
	}

	// Home admin page
	@GetMapping({ "/administration/", "/administration/{id}" })
	public String getOptionAdministration(@PathVariable(name = "id", required = false) Long id, Model model) {
		if (id != null) {
			model.addAttribute("options", optionService.findAllOptionsForGroup(groupService.findGroupById(id)));
		} else {
			model.addAttribute("options", optionService.findAllOptions());
		}
		return "optionAdmin";
	}

	// Adding
	@GetMapping("/add")
	public String getOptionAdding(Model model, Option addOption, HttpSession session) {
		if (session.getAttribute("addingOption") == null || addOption == null) {
			session.setAttribute("addingOption", new Option());
			model.addAttribute("addOption", new Option());
		} else {
			session.setAttribute("addingOption", addOption);
			model.addAttribute("addOption", addOption);
		}
		session.setAttribute("action", "adding");
		model.addAttribute("carGroups", groupService.findAllGroups());
		return "optionAdminAdd";
	}

	@PostMapping("/add/")
	public String addEngine(Model model, Option addOption, String action, HttpSession session) {
		model.addAttribute("oldOption", session.getAttribute("addingOption"));
		if (action.equals("Submit")) {
			optionService.saveOption(addOption);
		}
		session.removeAttribute("addingOption");
		session.removeAttribute("action");
		return "redirect:/option/administration/";
	}

	// Editing
	@GetMapping("/edit/{id}")
	public String getUpdateOffice(@PathVariable("id") Long id, Model model, HttpSession session, Option editOption) {
		if (session.getAttribute("editedOption") == null || editOption == null || editOption.getCode() == null) {
			session.setAttribute("editedOption", optionService.findOptionById(id));
			model.addAttribute("editOption", optionService.findOptionById(id));
		} else {
			session.setAttribute("editedOption", editOption);
			model.addAttribute("editOption", editOption);
		}
		session.setAttribute("action", "editing");
		model.addAttribute("carGroups", groupService.findAllGroups());
		return "optionAdminEdit";
	}

	@PostMapping("/edit/{id}")
	public String updateEngine(@PathVariable("id") Long id, Model model, Option editOption, String action,
			HttpSession session) {
		if (action.equals("Submit")) {
			optionService.updateOption(id, editOption);
		}
		session.removeAttribute("editedOption");
		session.removeAttribute("action");
		return "redirect:/option/administration/";
	}

	// Delete
	@PostMapping("/delete/{id}")
	public String deleteOption(@PathVariable("id") Long id) {
		optionService.deleteOptionById(id);
		return "redirect:/option/administration/";
	}
}
