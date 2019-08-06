package hr.petkovic.fleet.controllers.rent;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
import hr.petkovic.fleet.impl.office.UsersServiceImpl;
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
	@Autowired
	private UsersServiceImpl userService;

	Logger logger = LoggerFactory.getLogger(ReservationController.class);

	public ReservationController(ReservationServiceImpl resService, OptionServiceImpl optionService,
			OfficeServiceImpl officeService, CarGroupServiceImpl groupService, UsersServiceImpl userService) {
		this.resService = resService;
		this.optionService = optionService;
		this.officeService = officeService;
		this.groupService = groupService;
		this.userService = userService;
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
	public String getReservationAdding(Model model, ReservationDTO addRes, HttpSession session) {
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
	public String addReservation(Model model, ReservationDTO addRes, String action, HttpSession session) {
		model.addAttribute("oldRes", session.getAttribute("addingReservation"));
		if (action.equals("Submit")) {
			addRes.setUser(userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
			resService.saveRes(convertDTOToObject(addRes));
		}
		session.removeAttribute("addingReservation");
		session.removeAttribute("action");
		return "redirect:/reservation/administration/";
	}

	// Editing
	@GetMapping("/edit/{id}")
	public String getUpdateReservation(@PathVariable("id") Long id, Model model, HttpSession session, ReservationDTO editRes) {
		if (session.getAttribute("editedReservation") == null || editRes== null || editRes.getCarGroup() == null) {
			session.setAttribute("editedReservation", convertObjectToDTO(resService.findResById(id)));
			model.addAttribute("editRes", convertObjectToDTO(resService.findResById(id)));
		} else {
			session.setAttribute("editedOption", editRes);
			model.addAttribute("editOption", editRes);
		}
		session.setAttribute("action", "editing");
		model.addAttribute("carGroups", groupService.findAllGroups());
		model.addAttribute("offices", officeService.findAllOffices());
		return "resAdminEdit";
	}

	@PostMapping("/edit/{id}")
	public String updateEngine(@PathVariable("id") Long id, Model model, ReservationDTO editRes, String action,
			HttpSession session) {
		if (action.equals("Submit")) {
			editRes.setUser(userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
			resService.updateRes(id, convertDTOToObject(editRes));
		}
		session.removeAttribute("editedReservation");
		session.removeAttribute("user");
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
	private ReservationDTO convertObjectToDTO(Reservation res) {
		ReservationDTO dto = new ReservationDTO();
		dto.setCarGroup(res.getCarGroup());
		dto.setId(res.getId());
		dto.setCheckInOffice(res.getCheckInOffice());
		dto.setCheckInTime(res.getCheckInTime().toString());
		dto.setCheckOutOffice(res.getCheckOutOffice());
		dto.setCheckOutTime(res.getCheckOutTime().toString());
		dto.setUser(res.getUser());
		Set<Option> options = (Set<Option>) res.getOptions();
		for (Option option : options) {
			switch (option.getCode()) {
			case "GF":
				dto.setGF(true);
				break;
			case "IT":
				dto.setIT(true);
				break;
			case "NV":
				dto.setNV(true);
				break;
			case "OW":
				dto.setOW(true);
				break;
			case "PAP":
				dto.setPAP(true);
				break;
			case "PF":
				dto.setPF(true);
				break;
			case "TG":
				dto.setTG(true);
				break;
			case "TI":
				dto.setTI(true);
				break;
			case "TP":
				dto.setTP(true);
				break;
			}
		}
		return dto;
	}
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
		Set<Option> options = new LinkedHashSet<Option>();
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
		option = optionService.findOptionByGroupAndCode(group, "T");
		options.add(option);
		res.setOptions(options);
		return res;
	}

	private long calculateDays(LocalDateTime start, LocalDateTime stop) {
		LocalDateTime tempDateTime = LocalDateTime.from( start );
		long years = tempDateTime.until(stop, ChronoUnit.YEARS);
		long months = tempDateTime.until(stop, ChronoUnit.MONTHS);
		long days = tempDateTime.until(stop, ChronoUnit.DAYS);
		long hours = tempDateTime.until(stop, ChronoUnit.HOURS);
		if (hours > 1) {
			days +=1;
		}
		return years * 365 + months * 30 + days;
	}
}