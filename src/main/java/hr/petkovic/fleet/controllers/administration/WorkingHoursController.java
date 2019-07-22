package hr.petkovic.fleet.controllers.administration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.petkovic.fleet.impl.office.WorkingHoursServiceImpl;

@Controller
@RequestMapping("/hours")
public class WorkingHoursController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private WorkingHoursServiceImpl whService;

	public WorkingHoursController(WorkingHoursServiceImpl whService)
	{
		this.whService = whService;
	}
}
