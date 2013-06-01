package br.com.kwikemart.controller;

import static br.com.caelum.vraptor.view.Results.json;
import br.com.bronx.vraptor.restrictrex.annotation.LoggedIn;
import br.com.bronx.vraptor.restrictrex.annotation.Roles;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.kwikemart.dao.OrderedDAO;
import br.com.kwikemart.entity.Ordered;
import br.com.kwikemart.enums.OrderStatus;
import br.com.kwikemart.session.LoggedUser;

/**
 * @author Denis Santos
 */
@Resource
public class OrderedController {

	private Result result;
	private LoggedUser loggedUser;
	private OrderedDAO orderedDAO;

	public OrderedController(Result result, LoggedUser loggedUser, OrderedDAO orderedDAO) {
		this.result = result;
		this.loggedUser = loggedUser;
		this.orderedDAO = orderedDAO;
	}

	@Get
	@LoggedIn
	@Path("/meus-pedidos")
	public void userOrdered() {
		result.include("ordered", orderedDAO.getByUserId(loggedUser.getUser().getId()));
	}

	@Get
	@LoggedIn
	@Roles(roles = "ADMIN")
	@Path("/pedidos/admin")
	public void adminOrdered() {
		result.include("ordered", orderedDAO.getLatest());
	}
	
	@Get
	@LoggedIn
	@Roles(roles = "ADMIN")
	@Path("/pedidos/admin/status")
	public void adminOrdered(OrderStatus status) {
		result.include("ordered", orderedDAO.getByStatus(status));
	}

	@Post
	@LoggedIn
	@Roles(roles = "ADMIN")
	@Path("/pedidos/atualizar-status")
	public void statusUpdate(long id, OrderStatus status) {
		Ordered order = orderedDAO.getById(id);
		order.setStatus(status);
		orderedDAO.update(order);
		result.use(json()).from(true).serialize();
	}

}
