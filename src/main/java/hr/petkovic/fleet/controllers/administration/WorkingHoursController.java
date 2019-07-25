package hr.petkovic.fleet.controllers.administration;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.petkovic.fleet.entities.office.WorkingHours;
import hr.petkovic.fleet.entities.office.WorkingHoursDTO;
import hr.petkovic.fleet.impl.office.WorkingHoursServiceImpl;

@Controller
@RequestMapping("/workingHours")
public class WorkingHoursController {

	private static Logger logger = LoggerFactory.getLogger(WorkingHoursController.class);

	@Autowired
	private WorkingHoursServiceImpl whService;

	public WorkingHoursController(WorkingHoursServiceImpl whService) {
		this.whService = whService;
	}

	@GetMapping({ "/administration/", "/administration/{id}" })
	public String getWorkingHours(@PathVariable(name = "id", required = false) Optional<Long> id, Model model) {
		if (id.isPresent()) {
			model.addAttribute("hours", whService.findWorkingHoursById(id.get()));
		} else {
			model.addAttribute("hours", whService.findAllWorkingHours());
		}
		return "workingHoursAdmin";
	}

	// Adding
	@GetMapping("/add")
	public String getWorkingHoursAdding(Model model) {
		model.addAttribute("whours", new WorkingHoursDTO());
		return "workingHoursAdminAdd";
	}

	@PostMapping("/add")
	public String addWorkingHours(@DateTimeFormat(pattern = "HH:mm") WorkingHoursDTO whours) {
		whService.saveWorkingHours(convertDTOToWorkingHours(whours));
		return "redirect:/workingHours/administration/";
	}

	// Editing
	@GetMapping("/edit/{id}")
	public String getWorkingHoursEdit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("whours", whService.findWorkingHoursById(id));
		return "workingHoursAdminEdit";
	}

	@PostMapping("/edit/{id}")
	public String editWorkingHours(@PathVariable("id") Long id,
			@DateTimeFormat(pattern = "HH:mm") WorkingHoursDTO whours) {
		whService.updateWorkingHours(id, convertDTOToWorkingHours(whours));
		return "redirect:/workingHours/administration/";
	}

	@PostMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		whService.deleteWorkingHoursById(id);
		return "redirect:/workingHours/administration";
	}

	private WorkingHours convertDTOToWorkingHours(WorkingHoursDTO whDTO) {
		DateFormat dateFormat = new SimpleDateFormat("hh:mm");
		WorkingHours wh = new WorkingHours();
		Date d;
		try {
			d = dateFormat.parse(whDTO.getHolidayET());
			wh.setHolidayET(new Timestamp(d.getTime()).toLocalDateTime());
			d = dateFormat.parse(whDTO.getHolidayST());
			wh.setHolidayST(new Timestamp(d.getTime()).toLocalDateTime());
			d = dateFormat.parse(whDTO.getSaturdayET());
			wh.setSaturdayET(new Timestamp(d.getTime()).toLocalDateTime());
			d = dateFormat.parse(whDTO.getSaturdayST());
			wh.setSaturdayST(new Timestamp(d.getTime()).toLocalDateTime());
			d = dateFormat.parse(whDTO.getSundayET());
			wh.setSundayET(new Timestamp(d.getTime()).toLocalDateTime());
			d = dateFormat.parse(whDTO.getSundayST());
			wh.setSundayST(new Timestamp(d.getTime()).toLocalDateTime());
			d = dateFormat.parse(whDTO.getWorkdayST());
			wh.setWorkdayST(new Timestamp(d.getTime()).toLocalDateTime());
			d = dateFormat.parse(whDTO.getWorkdayET());
			wh.setWorkdayET(new Timestamp(d.getTime()).toLocalDateTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return wh;
	}
}
