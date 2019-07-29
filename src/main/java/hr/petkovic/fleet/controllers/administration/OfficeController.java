package hr.petkovic.fleet.controllers.administration;

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

import hr.petkovic.fleet.entities.office.EmployeeDTO;
import hr.petkovic.fleet.entities.office.Office;
import hr.petkovic.fleet.impl.office.OfficeServiceImpl;
import hr.petkovic.fleet.impl.office.WorkingHoursServiceImpl;

@Controller
@RequestMapping("/office")
public class OfficeController {

	private static Logger logger = LoggerFactory.getLogger(OfficeController.class);

	@Autowired
	private OfficeServiceImpl officeService;
	@Autowired
	private WorkingHoursServiceImpl whService;

	public OfficeController(OfficeServiceImpl officeService, WorkingHoursServiceImpl whService) {
		this.officeService = officeService;
		this.whService = whService;

	}

	// Home admin page
	@GetMapping("/administration")
	public String getOfficeAdministration(Model model) {
		model.addAttribute("offices", officeService.findAllOffices());
		return "officeAdmin";
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
		return "officeAdminAdd";
	}

	@PostMapping("/add/")
	public String addOffice(Model model, Office addOffice, String action, HttpSession session) {
		model.addAttribute("oldOffice", session.getAttribute("addingOffice"));
		if (action.equals("Pick")) {
			model.addAttribute("addOffice", addOffice);
			session.setAttribute("addingOffice", addOffice);
			model.addAttribute("hours", whService.findAllWorkingHours());
			return "workingHoursPicker";
		} else if (action.equals("Submit")) {
			officeService.saveOffice(addOffice);
			session.removeAttribute("addingOffice");
			session.removeAttribute("action");
			return "redirect:/office/administration";
		} else {
			session.removeAttribute("addingOffice");
			session.removeAttribute("action");
			return "redirect:/office/administration";
		}
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
		return "officeAdminEdit";
	}

	@PostMapping("/edit/{id}")
	public String updateOffice(@PathVariable("id") Long id, Model model, Office editOffice, String action,
			HttpSession session) {
		if (action.equals("Pick")) {
			session.setAttribute("editedOffice", editOffice);
			model.addAttribute("editOffice", editOffice);
			model.addAttribute("hours", whService.findAllWorkingHours());
			return "workingHoursPicker";
		} else if (action.equals("Submit")) {
			officeService.updateOffice(id, editOffice);
			session.removeAttribute("editedOffice");
			session.removeAttribute("action");
			return "redirect:/office/administration";
		} else {
			session.removeAttribute("editedOffice");
			session.removeAttribute("action");
			return "redirect:/office/administration";
		}
	}

	@PostMapping("/delete/{id}")
	public String deleteOffice(@PathVariable("id") Long id) {
		officeService.deleteOfficeById(id);
		return "redirect:/office/administration";
	}

	@GetMapping("/whpick/")
	public String getWorkingHoursPicker(Model model, Office officeInEdit) {
		logger.info(officeInEdit.getName());
		model.addAttribute("hours", whService.findAllWorkingHours());
		return "workingHoursPicker";
	}

	@GetMapping("/employees/{id}")
	public String getEmployees(@PathVariable("id") Long id, Model model) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployees(officeService.findOfficeById(id).getEmployees());
		dto.setOfficeId(id);
		model.addAttribute("dto", dto);
		return "employeePicker";
	}

}
