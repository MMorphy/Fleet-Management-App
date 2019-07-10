package hr.petkovic.fleet.entities;

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
	
}
