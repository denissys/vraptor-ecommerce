package br.com.kwikemart.controller;

import static br.com.caelum.vraptor.view.Results.json;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.kwikemart.bo.CartItem;
import br.com.kwikemart.dao.ProductDAO;
import br.com.kwikemart.entity.Product;
import br.com.kwikemart.session.Cart;

/**
 * @author Denis Santos
 */
@Resource
public class CartController {

	private Result result;
	private Cart cart;
	private ProductDAO productDAO;

	public CartController(Result result, Cart cart, ProductDAO productDAO) {
		this.result = result;
		this.cart = cart;
		this.productDAO = productDAO;
	}

	/**
	 * Load My Cart page with the items
	 */
	@Get
	@Path("/meu-carrinho")
	public void myCart() {
		result.include("items", cart.getList());
	}

	/**
	 * Adds an item to the cart
	 * 
	 * @param item
	 */
	@Post
	@Path("/meu-carrinho/adicionar")
	public void add(CartItem item) {

		Product product = productDAO.getById(item.getProduct().getId());
		item.setProduct(product);
		cart.addNewItem(item);
		result.use(json()).from(true).serialize();
	}

	/**
	 * Removes an item from cart
	 * 
	 * @param item
	 */
	@Post
	@Path("/meu-carrinho/remover")
	public void remove(Long productId) {
		cart.removeItem(productId);
		result.use(json()).from(true).serialize();
	}

	@Get
	@Path("/meu-carrinho/comprar")
	public void checkout() {
		result.include("items", cart.getList());
	}

}
