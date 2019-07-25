package hr.petkovic.fleet.entities.office;

import java.time.LocalDateTime;

public class UserDTO {

	private Long id;

	private String username;

	private String password;

	private LocalDateTime createTS;

	private LocalDateTime lastChangeTS;

	private String email;

	private boolean user;

	private boolean oper;

	private boolean admin;

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

	public boolean isUser() {
		return user;
	}

	public void setUser(boolean user) {
		this.user = user;
	}

	public boolean isOper() {
		return oper;
	}

	public void setOper(boolean oper) {
		this.oper = oper;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + ", createTS=" + createTS
				+ ", lastChangeTS=" + lastChangeTS + ", email=" + email + ", user=" + user + ", oper=" + oper
				+ ", admin=" + admin + "]";
	}

}
