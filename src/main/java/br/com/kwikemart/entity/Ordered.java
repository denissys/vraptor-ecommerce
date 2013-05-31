package br.com.kwikemart.entity;

import static br.com.kwikemart.enums.OrderStatus.WAITING_FOR_RELEASE;
import static javax.persistence.EnumType.STRING;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import br.com.kwikemart.enums.OrderStatus;

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
	
	@Getter @Setter
	@Enumerated(STRING)
	@Column(nullable = false)
	private OrderStatus status = WAITING_FOR_RELEASE;

	public Ordered() {

	}

	public Ordered(User user, UserAddress userAddress, List<CartItem> items) {
		this.user = user;
		this.userAddress = userAddress;
		this.items = items;
	}

}
