package hr.petkovic.fleet.controllers.rent;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.petkovic.fleet.impl.office.OfficeServiceImpl;
import hr.petkovic.fleet.impl.rent.OptionServiceImpl;
import hr.petkovic.fleet.impl.rent.ReservationServiceImpl;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationServiceImpl resService;
	@Autowired
	private OptionServiceImpl optionService;
	@Autowired
	private OfficeServiceImpl officeService;

	public ReservationController(ReservationServiceImpl resService, OptionServiceImpl optionService,
			OfficeServiceImpl officeService) {
		this.resService = resService;
		this.optionService = optionService;
		this.officeService = officeService;
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

}