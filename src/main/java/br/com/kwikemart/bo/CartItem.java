package br.com.kwikemart.bo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import br.com.kwikemart.entity.Product;

public class CartItem implements Serializable {

	private static final long serialVersionUID = 7121210771950592774L;

	@Getter @Setter
	private Product product;
	
	@Getter @Setter
	private Integer quantity;
	
}
