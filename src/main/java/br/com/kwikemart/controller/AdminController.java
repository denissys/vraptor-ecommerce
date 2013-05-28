package br.com.kwikemart.controller;

import br.com.bronx.vraptor.restrictrex.annotation.LoggedIn;
import br.com.bronx.vraptor.restrictrex.annotation.Roles;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

/**
 * Restrict Area
 * 
 * @author Denis Santos
 */
@Resource
public class AdminController {

	/**
	 * Area to actions of admin user
	 */
	@Get
	@Path("/admin")
	@LoggedIn
	@Roles(roles = "ADMIN")
	public void admin() { }
	
	/**
	 * Manage JCS Cache
	 */
	@Get
	@LoggedIn
	@Roles(roles = "ADMIN")
    public void cache() { }

}
