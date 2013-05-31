package br.com.kwikemart.controller;

import static br.com.kwikemart.enums.OrderStatus.WAITING_FOR_RELEASE;
import br.com.bronx.vraptor.restrictrex.annotation.LoggedIn;
import br.com.bronx.vraptor.restrictrex.annotation.Roles;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.kwikemart.dao.OrderedDAO;
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
	@Path("/produtos/admin")
	public void adminOrdered() {
		result.include("ordered", orderedDAO.getByStatus(WAITING_FOR_RELEASE));
	}
	
}
