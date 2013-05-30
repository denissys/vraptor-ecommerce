package br.com.kwikemart.controller;

import static br.com.caelum.vraptor.view.Results.json;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.kwikemart.bo.JsonViewResponse;
import br.com.kwikemart.dao.UserDAO;
import br.com.kwikemart.entity.User;
import br.com.kwikemart.enums.DecisionRoute;
import br.com.kwikemart.session.LoggedUser;

/**
 * Login Actions
 * 
 * @author Denis Santos
 */
@Resource
public class LoginController {

	private Result result;
	private UserDAO userDAO;
	private LoggedUser loggedUser;

	public LoginController(Result result, UserDAO userDAO, LoggedUser loggedUser) {
		this.result = result;
		this.userDAO = userDAO;
		this.loggedUser = loggedUser;
	}

	/**
	 * Load auth page
	 */
	@Get
	@Path("/entrar")
	public void enter() { }

	/**
	 * Execute rules of validation and permissions. If access is OK, the user
	 * info is stored on Session.
	 * 
	 * @param user
	 */
	@Post
	@Path("/auth")
	public void auth(User user, DecisionRoute decisionRoute) {
		
		JsonViewResponse response = new JsonViewResponse(true, "Logado com sucesso");

		user.encryptsPassword();
		user = userDAO.getByEmailAndPassword(user.getEmail(), user.getPassword());
		if (user.isPersisted()) {
			loggedUser.doLogin(user);
			response = new JsonViewResponse(true, decisionRoute.getPath(), true);

		} else {
			response = new JsonViewResponse(false, "Email e/ou senha inválidos.");
		}

		result.use(json()).from(response).serialize();
	}

	/**
	 * Clear user info of Session, and redirect to the Home.
	 */
	@Get
	@Path("/logoff")
	public void logoff() {
		loggedUser.doLogoff();
		result.redirectTo(IndexController.class).index();
	}

}