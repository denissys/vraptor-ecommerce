package br.com.kwikemart.controller;

import static br.com.caelum.vraptor.view.Results.json;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.kwikemart.bo.JsonViewResponse;
import br.com.kwikemart.dao.OrderedDAO;
import br.com.kwikemart.dao.ProductDAO;
import br.com.kwikemart.entity.CartItem;
import br.com.kwikemart.entity.Ordered;
import br.com.kwikemart.entity.Product;
import br.com.kwikemart.entity.UserAddress;
import br.com.kwikemart.session.Cart;
import br.com.kwikemart.session.LoggedUser;

/**
 * @author Denis Santos
 */
@Resource
public class CartController {

	public static final String CHECKOUT_PATH = "/meu-carrinho/comprar";
	private Result result;
	private LoggedUser loggedUser;
	private Cart cart;
	private ProductDAO productDAO;
	private OrderedDAO orderedDAO;

	public CartController(Result result, LoggedUser loggedUser, Cart cart,
			ProductDAO productDAO, OrderedDAO orderedDAO) {
		this.result = result;
		this.loggedUser = loggedUser;
		this.cart = cart;
		this.productDAO = productDAO;
		this.orderedDAO = orderedDAO;
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
		item.setPrice(product.getPrice());
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

	/**
	 * Last event of purchase, here the user terminates the buy.
	 */
	@Get
	@Path(CHECKOUT_PATH)
	public void checkout() {
		result.include("items", cart.getList());
	}

	@Post
	@Path("/meu-carrinho/pedido")
	public void ordered(UserAddress address) {

		address.setUser(loggedUser.getUser());

		Ordered ordered = new Ordered(loggedUser.getUser(), address, cart.getList());
		final Long orderedNumber = orderedDAO.save(ordered);

		cart.finish();
		
		result.use(json()).from(new JsonViewResponse(true, orderedNumber.toString())).serialize();
	}

	@Post
	@Path("/meu-carrinho/limpar")
	public void clearCart() {
		cart.finish();
		result.use(json()).from(true);
	}
}
