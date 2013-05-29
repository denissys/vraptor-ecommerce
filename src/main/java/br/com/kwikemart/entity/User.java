package br.com.kwikemart.entity;

import static br.com.kwikemart.enums.Role.DEFAULT;
import static javax.persistence.EnumType.STRING;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import br.com.kwikemart.enums.Role;

@Entity
@Table
public class User extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	@Column(nullable = false)
	private String firstName;

	@Getter @Setter
	@Column(nullable = false)
	private String lastName;

	@Getter @Setter
	@Column(nullable = false)
	private String email;

	@Getter @Setter
	private String document;

	@Getter @Setter
	@Column(length = 32, nullable = false)
	private String password;

	@Getter @Setter
	@Column(nullable = false)
	@Enumerated(STRING)
	private Role role = DEFAULT;

	public User getBasicInfo() {
		User user = new User();
		user.setFirstName(this.firstName);
		user.setLastName(this.lastName);
		user.setDocument(this.document);
		return user;
	}

}