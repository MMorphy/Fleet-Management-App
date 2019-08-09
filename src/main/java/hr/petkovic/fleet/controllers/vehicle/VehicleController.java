package hr.petkovic.fleet.controllers.vehicle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

import hr.petkovic.fleet.entities.office.Office;
import hr.petkovic.fleet.entities.vehicle.CarDamage;
import hr.petkovic.fleet.entities.vehicle.Tire;
import hr.petkovic.fleet.entities.vehicle.Vehicle;
import hr.petkovic.fleet.entities.vehicle.VehicleAndOfficeDTO;
import hr.petkovic.fleet.impl.office.OfficeServiceImpl;
import hr.petkovic.fleet.impl.vehicle.CarDamageServiceImpl;
import hr.petkovic.fleet.impl.vehicle.CarGroupServiceImpl;
import hr.petkovic.fleet.impl.vehicle.CarManufacturerServiceImpl;
import hr.petkovic.fleet.impl.vehicle.CarModelServiceImpl;
import hr.petkovic.fleet.impl.vehicle.CarSpecificationServiceImpl;
import hr.petkovic.fleet.impl.vehicle.NavigationServiceImpl;
import hr.petkovic.fleet.impl.vehicle.TireServiceImpl;
import hr.petkovic.fleet.impl.vehicle.VehicleServiceImpl;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

	private static Logger logger = LoggerFactory.getLogger(VehicleController.class);

	@Autowired
	private VehicleServiceImpl vehicleService;
	@Autowired
	private TireServiceImpl tireService;
	@Autowired
	private CarManufacturerServiceImpl manufacturerService;
	@Autowired
	private CarModelServiceImpl modelService;
	@Autowired
	private CarGroupServiceImpl groupService;
	@Autowired
	private CarSpecificationServiceImpl specService;
	@Autowired
	private NavigationServiceImpl navService;
	@Autowired
	private CarDamageServiceImpl damageService;
	@Autowired
	private OfficeServiceImpl officeService;

	public VehicleController(VehicleServiceImpl vehicleService, TireServiceImpl tireService,
			CarManufacturerServiceImpl manufacturerService, CarModelServiceImpl modelService,
			CarGroupServiceImpl groupService, CarSpecificationServiceImpl specService, NavigationServiceImpl navService,
			CarDamageServiceImpl damageService, OfficeServiceImpl officeService) {
		this.vehicleService = vehicleService;
		this.tireService = tireService;
		this.manufacturerService = manufacturerService;
		this.modelService = modelService;
		this.groupService = groupService;
		this.specService = specService;
		this.navService = navService;
		this.damageService = damageService;
		this.officeService = officeService;
	}

	// Home admin page
	@GetMapping({ "/administration/", "/administration/{id}" })
	public String getVehicleAdministration(@PathVariable(name = "id", required = false) Long id, Model model) {
		if (id != null) {
			Vehicle vehicle = vehicleService.findVehicleById(id);
			Office office = officeService.findOfficeByVehicle(vehicle);
			model.addAttribute("vehicles", new VehicleAndOfficeDTO(vehicle, office));
		} else {
			List<Vehicle> vehicles = vehicleService.findAllVehicles();
			List<VehicleAndOfficeDTO> dtos = new ArrayList<>();
			for (Vehicle vehicle : vehicles) {
				dtos.add(new VehicleAndOfficeDTO(vehicle, officeService.findOfficeByVehicle(vehicle)));
			}
			model.addAttribute("vehicles", dtos);
		}
		return "vehicle/vehicleAdmin";
	}

	// Adding
	@GetMapping("/add")
	public String getVehicleAdding(Model model, VehicleAndOfficeDTO addVehicle, HttpSession session) {
		if (session.getAttribute("addingVehicle") == null || addVehicle == null) {
			session.setAttribute("addingVehicle", new VehicleAndOfficeDTO());
			model.addAttribute("addVehicle", new VehicleAndOfficeDTO());
		} else {
			session.setAttribute("addingVehicle", addVehicle);
			model.addAttribute("addVehicle", addVehicle);
		}
		session.setAttribute("action", "adding");
		model.addAttribute("manufacturers", manufacturerService.findAllManufacturers());
		model.addAttribute("models", modelService.findAllModels());
		model.addAttribute("groups", groupService.findAllGroups());
		model.addAttribute("tires", tireService.findUnusedTires());
		model.addAttribute("specs", specService.findAllSpecs());
		model.addAttribute("navs", navService.findAllNavs());
		model.addAttribute("offices", officeService.findAllOffices());
		return "vehicle/vehicleAdminAdd";
	}

	@PostMapping("/add/")
	public String addVehicle(Model model, VehicleAndOfficeDTO addVehicle, String action, HttpSession session) {
		model.addAttribute("oldVehicle", session.getAttribute("addingVehicle"));
		if (action.equals("Submit")) {
			if (addVehicle.getVehicle().getCurrentKM() == null) {
				addVehicle.getVehicle().setCurrentKM(0);
			}
			vehicleService.saveVehicle(addVehicle.getVehicle());
			Office office = addVehicle.getOffice();
			office.addVehicle(addVehicle.getVehicle());
			officeService.saveOffice(office);
		}
		session.removeAttribute("addingVehicle");
		session.removeAttribute("action");
		return "redirect:/vehicle/administration/";
	}

	// Editing
	@GetMapping("/edit/{id}")
	public String getUpdateVehicle(@PathVariable("id") Long id, Model model, HttpSession session, Vehicle editVehicle) {
		List<Tire> tires = tireService.findUnusedTires();
		if (session.getAttribute("editedTire") == null || editVehicle == null || editVehicle.getVIN() == null
				|| editVehicle.getVIN().isBlank()) {
			session.setAttribute("editedVehicle", vehicleService.findVehicleById(id));
			model.addAttribute("editVehicle", vehicleService.findVehicleById(id));
			tires.add(vehicleService.findVehicleById(id).getTire());
		} else {
			editVehicle.setId(id);
			session.setAttribute("editedVehicle", editVehicle);
			model.addAttribute("editVehicle", editVehicle);
			tires.add(editVehicle.getTire());
		}
		session.setAttribute("action", "editing");
		model.addAttribute("manufacturers", manufacturerService.findAllManufacturers());
		model.addAttribute("models", modelService.findAllModels());
		model.addAttribute("groups", groupService.findAllGroups());
		model.addAttribute("tires", tires);
		model.addAttribute("specs", specService.findAllSpecs());
		model.addAttribute("navs", navService.findAllNavs());
		return "vehicle/vehicleAdminEdit";
	}

	@PostMapping("/edit/{id}")
	public String updateTires(@PathVariable("id") Long id, Model model, Vehicle editVehicle, String action,
			HttpSession session) {
		if (action.equals("Submit")) {
			List<CarDamage> damages = damageService.findDamagesForVehicle(editVehicle.getId());
			editVehicle.setDamages(new HashSet<>(damages));
			vehicleService.updateVehicle(id, editVehicle);
		}
		session.removeAttribute("editedTire");
		session.removeAttribute("action");
		return "redirect:/vehicle/administration/";
	}

	// Delete
	@PostMapping("/delete/{id}")
	public String deleteTire(@PathVariable("id") Long id) {
		vehicleService.deleteVehicleById(id);
		return "redirect:/vehicle/administration/";
	}
}
