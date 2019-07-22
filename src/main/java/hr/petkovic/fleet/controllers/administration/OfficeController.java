package hr.petkovic.fleet.controllers.administration;

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
import hr.petkovic.fleet.impl.office.OfficeServiceImpl;
import hr.petkovic.fleet.impl.office.UsersServiceImpl;
import hr.petkovic.fleet.impl.office.WorkingHoursServiceImpl;
import hr.petkovic.fleet.impl.vehicle.VehicleServiceImpl;
import hr.petkovic.fleet.repositories.office.OfficeRepository;

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

	@GetMapping("/administration")
	public String getOfficeAdministration(Model model) {
		model.addAttribute("offices", officeService.findAllOffices());
		return "officeAdmin";
	}

	@GetMapping("/add")
	public String getOfficeAdding(Model model) {
		model.addAttribute("office", new Office());
		return "officeAdminAdd";
	}

	@PostMapping("/add")
	public String addOffice(Office office) {
		officeService.saveOffice(office);
		return "redirect:/office/administration";
	}

	@GetMapping("/edit/{id}")
	public String getUpdateOffice(@PathVariable("id") String id, Model model) {
		model.addAttribute("office", officeService.findOfficeById(Long.parseLong(id)));
		return "officeAdminEdit";
	}

	@PostMapping("/edit/{id}")
	public String updateOffice(@PathVariable("id") String id, Office office) {
		officeService.updateOffice(Long.parseLong(id), office);
		return "redirect:/office/administration";
	}

	@PostMapping("/delete/{id}")
	public String deleteOffice(@PathVariable("id") String id) {
		officeService.deleteOfficeById(Long.parseLong(id));
		return "redirect:/office/administration";
	}
}
