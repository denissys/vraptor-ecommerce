package br.com.kwikemart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class UserAddress extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	@OneToOne
	private User user;
	
	@Getter @Setter
	@Column(nullable = false)
	private String street;
	
	@Getter @Setter
	private String number;
	
	@Getter @Setter
	private String complement;
	
}
