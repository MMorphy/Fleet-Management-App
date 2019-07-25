package hr.petkovic.fleet.entities.office;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDTO {

	private List<User> employees;

	private Long officeId;

	public void addEmployee(User user) {
		this.employees.add(user);
	}

	public EmployeeDTO(List<User> employees) {
		this.employees = employees;
	}

	public EmployeeDTO() {
		this.employees = new ArrayList<>();
	}

	public List<User> getEmployees() {
		return employees;
	}

	public void setEmployees(List<User> employees) {
		this.employees = employees;
	}

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}
}
