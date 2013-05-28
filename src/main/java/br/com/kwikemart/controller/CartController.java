package br.com.kwikemart.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.kwikemart.bo.CartItem;
import br.com.kwikemart.dao.ProductDAO;
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

		CartItem item1 = new CartItem();
		item1.setProduct(productDAO.getById(27L));
		item1.setQuantity(2);

		CartItem item2 = new CartItem();
		item2.setProduct(productDAO.getById(30L));
		item2.setQuantity(3);

		cart.addNewItem(item1);
		cart.addNewItem(item2);

		List<CartItem> items = new ArrayList<CartItem>(cart.getItems().values());

		result.include("items", items);
	}

	/**
	 * Adds an item to the cart
	 * 
	 * @param item
	 */
	@Post
	@Path("/meu-carrinho/adicionar")
	public void add(CartItem item) {
		item.setProduct(productDAO.getById(item.getProduct().getId()));
		cart.addNewItem(item);
	}

	/**
	 * Removes an item from cart
	 * 
	 * @param item
	 */
	@Delete
	@Path("/meu-carrinho/remover")
	public void remove(Long productId) {
		cart.removeItem(productId);
	}
}
