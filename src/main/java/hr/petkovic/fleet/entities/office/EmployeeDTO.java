package hr.petkovic.fleet.entities.office;

import java.util.LinkedHashSet;
import java.util.Set;

public class EmployeeDTO {

	private Set<User> employees;

	private Long officeId;

	public void addEmployee(User user) {
		this.employees.add(user);
	}

	public EmployeeDTO(Set<User> employees) {
		this.employees = employees;
	}

	public EmployeeDTO() {
		this.employees = new LinkedHashSet<>();
	}

	public Set<User> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<User> employees) {
		this.employees = employees;
	}

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}
}
