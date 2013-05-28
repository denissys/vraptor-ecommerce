package br.com.kwikemart.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.kwikemart.dao.ProductDAO;

/**
 * @author Denis Santos
 */
@Resource
public class ShowcaseController {

	private Result result;
	private ProductDAO productDAO;

	public ShowcaseController(Result result, ProductDAO productDAO) {
		this.result = result;
		this.productDAO = productDAO;
	}

	/**
	 * Return top products
	 */
	@Get
	@Path("/produtos-em-destaque")
	public void featured() {
		result.include("products", productDAO.featured());
	}

}
