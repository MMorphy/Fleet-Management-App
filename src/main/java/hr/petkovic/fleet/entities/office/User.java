package hr.petkovic.fleet.entities.office;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	private String username;

	@Column(nullable=false)
	private String password;

	@ColumnDefault(value="NOW()")
	private LocalDateTime createTS;
	
	@ColumnDefault(value="NOW()")
	private LocalDateTime lastChangeTS;
	
	@Column(nullable=false)
	private String email;

	@ColumnDefault(value="false")
	private boolean admin;

	@ColumnDefault(value="false")
	private boolean employee;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreateTS() {
		return createTS;
	}

	public void setCreateTS(LocalDateTime createTS) {
		this.createTS = createTS;
	}

	public LocalDateTime getLastChangeTS() {
		return lastChangeTS;
	}

	public void setLastChangeTS(LocalDateTime lastChangeTS) {
		this.lastChangeTS = lastChangeTS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isEmployee() {
		return employee;
	}

	public void setEmployee(boolean employee) {
		this.employee = employee;
	}
}
