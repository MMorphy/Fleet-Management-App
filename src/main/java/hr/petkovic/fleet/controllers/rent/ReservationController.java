package hr.petkovic.fleet.controllers.rent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.petkovic.fleet.entities.rent.Option;
import hr.petkovic.fleet.entities.rent.Reservation;
import hr.petkovic.fleet.entities.rent.ReservationDTO;
import hr.petkovic.fleet.entities.vehicle.CarGroup;
import hr.petkovic.fleet.impl.office.OfficeServiceImpl;
import hr.petkovic.fleet.impl.rent.OptionServiceImpl;
import hr.petkovic.fleet.impl.rent.ReservationServiceImpl;
import hr.petkovic.fleet.impl.vehicle.CarGroupServiceImpl;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationServiceImpl resService;
	@Autowired
	private OptionServiceImpl optionService;
	@Autowired
	private OfficeServiceImpl officeService;
	@Autowired
	private CarGroupServiceImpl groupService;

	public ReservationController(ReservationServiceImpl resService, OptionServiceImpl optionService,
			OfficeServiceImpl officeService, CarGroupServiceImpl groupService) {
		this.resService = resService;
		this.optionService = optionService;
		this.officeService = officeService;
		this.groupService = groupService;
	}

	// Home admin page
	@GetMapping({ "/administration/", "/administration/{id}" })
	public String getReservationAdministration(@PathVariable(name = "id", required = false) Long id, Model model) {
		if (id != null) {
			model.addAttribute("reservations", resService.findResById(id));
		} else {
			model.addAttribute("reservations", resService.findAllRes());
		}
		return "resAdmin";
	}

	// Adding
	@GetMapping("/add")
	public String getOptionAdding(Model model, ReservationDTO addRes, HttpSession session) {
		if (session.getAttribute("addingReservation") == null || addRes == null) {
			session.setAttribute("addingReservation", new ReservationDTO());
			model.addAttribute("addRes", new ReservationDTO());
		} else {
			session.setAttribute("addingReservation", addRes);
			model.addAttribute("addRes", addRes);
		}
		session.setAttribute("action", "adding");
		model.addAttribute("carGroups", groupService.findAllGroups());
		model.addAttribute("offices", officeService.findAllOffices());
		return "resAdminAdd";
	}

	@PostMapping("/add/")
	public String addEngine(Model model, ReservationDTO addRes, String action, HttpSession session) {
		model.addAttribute("oldRes", session.getAttribute("addingReservation"));
		if (action.equals("Submit")) {
			resService.saveRes(convertDTOToObject(addRes));
		}
		session.removeAttribute("addingReservation");
		session.removeAttribute("action");
		return "redirect:/reservation/administration/";
	}

	// Delete
	@PostMapping("/delete/{id}")
	public String deleteReservation(@PathVariable("id") Long id) {
		resService.deleteResById(id);
		return "redirect:/reservation/administration/";
	}

	// Office reservations
	@GetMapping({ "/administration/checkin/{officeId}/", "/administration/{officeId}/{date}" })
	public String getReservationAdministrationForOffice(@PathVariable(name = "officeId", required = true) Long officeId,
			@PathVariable(name = "date", required = false) String date, Model model) {
		if (date != null && !date.isBlank()) {
			model.addAttribute("reservations", resService.findAllResForCheckInOfficeAndTime(
					officeService.findOfficeById(officeId), LocalDateTime.parse(date)));
		} else {
			model.addAttribute("reservations",
					resService.findAllResForCheckInOffice(officeService.findOfficeById(officeId)));
		}
		return "resAdmin";
	}

	// Util
	private Reservation convertDTOToObject(ReservationDTO obj) {
		Reservation res = new Reservation();
		CarGroup group = obj.getCarGroup();
		res.setId(obj.getId());
		res.setCarGroup(group);
		res.setCheckInOffice(obj.getCheckInOffice());
		res.setCheckInTime(LocalDateTime.parse(obj.getCheckInTime()));
		res.setCheckOutOffice(obj.getCheckOutOffice());
		res.setCheckOutTime(LocalDateTime.parse(obj.getCheckOutTime()));
		res.setUser(obj.getUser());
		List<Option> options = new ArrayList<>();
		Option option;
		if (obj.isGF()) {
			option = optionService.findOptionByGroupAndCode(group, "GF");
			if (option != null) {
				options.add(option);
			}
		}
		if (obj.isIT()) {
			option = optionService.findOptionByGroupAndCode(group, "IT");
			if (option != null) {
				options.add(option);
			}
		}
		if (obj.isNV()) {
			option = optionService.findOptionByGroupAndCode(group, "NV");
			if (option != null) {
				options.add(option);
			}
		}
		if (obj.isOW()) {
			option = optionService.findOptionByGroupAndCode(group, "OW");
			if (option != null) {
				options.add(option);
			}
		}
		if (obj.isPAP()) {
			option = optionService.findOptionByGroupAndCode(group, "PAP");
			if (option != null) {
				options.add(option);
			}
		}
		if (obj.isPF()) {
			option = optionService.findOptionByGroupAndCode(group, "PF");
			if (option != null) {
				options.add(option);
			}
		}
		if (obj.isTG()) {
			option = optionService.findOptionByGroupAndCode(group, "TG");
			if (option != null) {
				options.add(option);
			}
		}
		if (obj.isTI()) {
			option = optionService.findOptionByGroupAndCode(group, "TI");
			if (option != null) {
				options.add(option);
			}
		}
		if (obj.isTP()) {
			option = optionService.findOptionByGroupAndCode(group, "TP");
			if (option != null) {
				options.add(option);
			}
		}
		res.setOptions(options);
		return res;
	}
}