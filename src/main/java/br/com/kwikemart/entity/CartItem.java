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
public class CartItem extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 7121210771950592774L;

	@Getter @Setter
	@OneToOne
	private Product product;
	
	@Getter @Setter
	@Column(nullable = false)
	private Integer quantity;
	
	@Getter @Setter
	@Column(nullable = false)
	private Double price;
	
}
