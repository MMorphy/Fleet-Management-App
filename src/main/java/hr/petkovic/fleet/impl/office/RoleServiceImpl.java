package hr.petkovic.fleet.impl.office;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.petkovic.fleet.entities.office.Role;
import hr.petkovic.fleet.repositories.office.RoleRepository;
import hr.petkovic.fleet.service.office.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepo;

	public RoleServiceImpl(RoleRepository roleRepo) {
		this.roleRepo = roleRepo;
	}

	@Override
	public List<Role> findAllRoles() {
		return this.roleRepo.findAll();
	}

	@Override
	public List<Role> findAllRolesForUser(String username) {
		return this.roleRepo.findByUsers_Username(username);
	}

	@Override
	public Role findRoleById(Long id) {
		try {
			return this.roleRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	@Override
	public void deleteRoleById(Long id) {
		this.roleRepo.deleteById(id);
	}

	@Override
	public Role saveRole(Role role) {
		return this.roleRepo.save(role);
	}

	@Override
	public Role updateRole(Long id, Role role) {
		Optional<Role> optRole = this.roleRepo.findById(id);
		if (optRole.isPresent()) {
			Role rol = optRole.get();
			rol.setName(role.getName());
			rol.setUsers(role.getUsers());
			return this.roleRepo.save(rol);
		} else {
			return this.roleRepo.save(role);
		}
	}

	@Override
	public Role findRoleByName(String name) {
		try {
			return this.roleRepo.findByName(name).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

}
