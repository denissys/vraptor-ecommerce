package br.com.kwikemart.controller;

import br.com.bronx.vraptor.restrictrex.annotation.LoginPage;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.kwikemart.properties.FileProperties;

@Resource
public class IndexController {

	private Result result;

	public IndexController(Result result) {
		this.result = result;
	}

	/**
	 * Load home
	 */
	@Path("/")
	@LoginPage
	public void index() {
		result.include("contextpath", new FileProperties(FileProperties.Type.SYSTEM).getString("contextpath"));
	}

}