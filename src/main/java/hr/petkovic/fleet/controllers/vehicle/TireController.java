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

import hr.petkovic.fleet.entities.vehicle.Tire;
import hr.petkovic.fleet.entities.vehicle.Vehicle;
import hr.petkovic.fleet.impl.vehicle.TireBrandServiceImpl;
import hr.petkovic.fleet.impl.vehicle.TireServiceImpl;
import hr.petkovic.fleet.impl.vehicle.TireTypeServiceImpl;
import hr.petkovic.fleet.impl.vehicle.VehicleServiceImpl;
import hr.petkovic.fleet.impl.vehicle.WheelTypeServiceImpl;

@Controller
@RequestMapping("/tires")
public class TireController {

	private static Logger logger = LoggerFactory.getLogger(TireController.class);

	@Autowired
	private TireServiceImpl tireService;
	@Autowired
	private TireTypeServiceImpl tireTypeService;
	@Autowired
	private TireBrandServiceImpl tireBrandService;
	@Autowired
	private WheelTypeServiceImpl wheelService;
	@Autowired
	private VehicleServiceImpl vehicleService;

	public TireController(TireServiceImpl tireService, TireTypeServiceImpl tireTypeService,
			TireBrandServiceImpl tireBrandService, WheelTypeServiceImpl wheelService,
			VehicleServiceImpl vehicleService) {
		this.tireService = tireService;
		this.tireTypeService = tireTypeService;
		this.tireBrandService = tireBrandService;
		this.wheelService = wheelService;
		this.vehicleService = vehicleService;
	}

	@GetMapping({ "/administration/", "/administration/{id}" })
	public String getTireAdministration(@PathVariable(name = "id", required = false) Long id, Model model) {
		if (id != null) {
			model.addAttribute("tires", tireService.findTireById(id));
		} else {
			model.addAttribute("tires", tireService.findAllTires());
		}
		return "tires/tiresAdmin";
	}

	// Adding
	@GetMapping("/add")
	public String getTiresAdding(Model model, Tire addTire, HttpSession session) {
		if (session.getAttribute("addingTire") == null || addTire == null) {
			session.setAttribute("addingTire", new Tire());
			model.addAttribute("addTire", new Tire());
		} else {
			session.setAttribute("addingTire", addTire);
			model.addAttribute("addTire", addTire);
		}
		model.addAttribute("tireTypes", tireTypeService.findAllTypes());
		model.addAttribute("tireBrands", tireBrandService.findAllBrands());
		model.addAttribute("wheelTypes", wheelService.findAllTypes());
		model.addAttribute("vehicles", vehicleService.findAllVehicles());
		session.setAttribute("action", "adding");
		return "tires/tiresAdminAdd";
	}

	@PostMapping("/add/")
	public String addTire(Model model, Tire addTire, String action, HttpSession session) {
		if (action.equalsIgnoreCase("Submit")) {
			tireService.saveTire(addTire);
			if (addTire.getVehicle() != null) {
				Vehicle vehicle = vehicleService.findVehicleById(addTire.getVehicle().getId());
				vehicle.setTire(addTire);
				vehicleService.updateVehicle(vehicle.getId(), vehicle);
			}
		}
		session.removeAttribute("addingTire");
		session.removeAttribute("action");
		return "redirect:/tires/administration/";

	}

	// Editing
	@GetMapping("/edit/{id}")
	public String getUpdateTires(@PathVariable("id") Long id, Model model, HttpSession session, Tire editTire) {
		if (session.getAttribute("editedTire") == null || editTire == null || editTire.getWidth() == null) {
			session.setAttribute("editedTire", tireService.findTireById(id));
			model.addAttribute("editTire", tireService.findTireById(id));
		} else {
			session.setAttribute("editedTire", editTire);
			model.addAttribute("editTire", editTire);
		}
		session.setAttribute("action", "editing");
		model.addAttribute("vehicles", vehicleService);
		model.addAttribute("tireTypes", tireTypeService.findAllTypes());
		model.addAttribute("tireBrands", tireBrandService.findAllBrands());
		model.addAttribute("wheelTypes", wheelService.findAllTypes());
		model.addAttribute("vehicles", vehicleService.findAllVehicles());
		return "tires/tiresAdminEdit";
	}

	@PostMapping("/edit/{id}")
	public String updateTires(@PathVariable("id") Long id, Model model, Tire editTire, String action,
			HttpSession session) {
		if (action.equals("Submit")) {
			tireService.updateTire(id, editTire);
			if (editTire.getVehicle() != null) {
				Vehicle vehicle = vehicleService.findVehicleById(editTire.getVehicle().getId());
				vehicle.setTire(editTire);
				vehicleService.updateVehicle(vehicle.getId(), vehicle);
			}
		}
		session.removeAttribute("editedTire");
		session.removeAttribute("action");
		return "redirect:/tires/administration/";
	}

	// Delete
	@PostMapping("/delete/{id}")
	public String deleteTire(@PathVariable("id") Long id) {
		tireService.deleteTireById(id);
		return "redirect:/tires/administration/";
	}
}
