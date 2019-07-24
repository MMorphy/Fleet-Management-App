package hr.petkovic.fleet.service.office;

import java.util.List;

import hr.petkovic.fleet.entities.office.Role;

public interface RoleService {

	public abstract List<Role> findAllRoles();

	public abstract List<Role> findAllRolesForUser(String username);

	public abstract Role findRoleById(Long id);

	public abstract void deleteRoleById(Long id);

	public abstract Role saveRole(Role role);

	public abstract Role updateRole(Long id, Role role);
}
