package br.com.kwikemart.controller;

import static br.com.caelum.vraptor.view.Results.json;
import static br.com.kwikemart.enums.Role.DEFAULT;
import br.com.bronx.vraptor.restrictrex.annotation.LoggedIn;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.kwikemart.bo.JsonViewResponse;
import br.com.kwikemart.dao.UserDAO;
import br.com.kwikemart.entity.User;
import br.com.kwikemart.session.LoggedUser;
import br.com.kwikemart.utils.SendMail;

/**
 * @author Denis Santos
 */
@Resource
public class UserController {

	public static final String REGISTER_PATH = "/cadastro";
	public static final String MY_ACCOUNT_PATH = "/minha-conta";
	private Result result;
	private UserDAO userDAO;
	private LoggedUser loggedUser;

	public UserController(Result result, UserDAO userDAO,
			LoggedUser loggedUser, SendMail mail) {
		this.result = result;
		this.userDAO = userDAO;
		this.loggedUser = loggedUser;
	}

	/**
	 * Load user register page
	 */
	@Get
	@Path(REGISTER_PATH)
	public void register() { }

	/**
	 * User info is validated and stored on database. After stored on database,
	 * the user info is stored in Session and the user is redirected to Profile
	 * Area.
	 * 
	 * @param product
	 */
	@Post
	@Path("/cadastro/salvar")
	public void register(User user) {
		JsonViewResponse response = new JsonViewResponse(false, "Falha ao cadastrar, tente mais tarde.");

		boolean newRegister = userDAO.getByEmailOrCpf(user.getEmail(), user.getDocument()) == null;

		if (newRegister) {

			user.setRole(DEFAULT);
			final Long userId = userDAO.save(user);

			if (userId != null) {
				user.setId(userId);
				loggedUser.doLogin(user);
				response = new JsonViewResponse(true, MY_ACCOUNT_PATH, true);
			}
		} else {
			response = new JsonViewResponse(false,
					"E-mail e/ou CPF já está em uso, não é possível cadastrar.");
		}

		result.use(json()).from(response).serialize();
	}

	/**
	 * Load User Profile Area
	 */
	@Get
	@LoggedIn
	@Path(MY_ACCOUNT_PATH)
	public void profile() {

	}

}
