package br.com.kwikemart.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table
public class Ordered extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@Getter
	@OneToOne(cascade = CascadeType.ALL)
	private UserAddress userAddress;

	@Getter
	@OneToMany(cascade = CascadeType.ALL)
	private List<CartItem> items;

	public Ordered(User user, UserAddress userAddress, List<CartItem> items) {
		this.user = user;
		this.userAddress = userAddress;
		this.items = items;
	}

}
