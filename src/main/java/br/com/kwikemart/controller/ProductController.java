package br.com.kwikemart.controller;

import static br.com.caelum.vraptor.view.Results.json;
import static br.com.kwikemart.utils.Pagination.getPage;

import java.io.IOException;
import java.util.List;

import br.com.bronx.vraptor.restrictrex.annotation.LoggedIn;
import br.com.bronx.vraptor.restrictrex.annotation.Roles;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.kwikemart.bo.JsonViewResponse;
import br.com.kwikemart.dao.ProductDAO;
import br.com.kwikemart.entity.Product;
import br.com.kwikemart.session.ImageUpload;
import br.com.kwikemart.utils.UploadedFileUtil;

/**
 * @author Denis Santos
 */
@Resource
public class ProductController {

	private static final int QUANTITY_PER_PAGE = 4;
	private static final int FIRST_PAGE = 0;
	private Result result;
	private ImageUpload imageUpload;
	private UploadedFileUtil uploadedFileUtil;
	private ProductDAO productDAO;

	public ProductController(Result result, ImageUpload imageUpload,
			UploadedFileUtil uploadedFileUtil, ProductDAO productDAO) {
		this.result = result;
		this.imageUpload = imageUpload;
		this.uploadedFileUtil = uploadedFileUtil;
		this.productDAO = productDAO;
	}

	@Get
	@Path("/produtos/{id}")
	public void detail(long id) {
		result.include("product", productDAO.getById(id));
	}

	/**
	 * Load page for manage product actions
	 */
	@Get
	@LoggedIn
	@Roles(roles = "ADMIN")
	@Path("/produtos/admin")
	public void admin() { }

	/**
	 * Load page for register a new product
	 */
	@Get
	@LoggedIn
	@Roles(roles = "ADMIN")
	@Path("/produtos/novo")
	public void register() { }

	/**
	 * Here the product is saved in database and the image is saved on disk
	 * 
	 * @param product
	 */
	@Post
	@LoggedIn
	@Roles(roles = "ADMIN")
	@Path("/produtos/salvar")
	public void register(Product product) {

		JsonViewResponse response = null;
		
		if (product.isPersisted()) {
			productDAO.update(product);
			response = new JsonViewResponse(true, "Produto atualizado com sucesso.");
		} else {
			product.setId(productDAO.save(product));
			response = new JsonViewResponse(true, "Produto cadastrado com sucesso.");
		}

		try {
			if(imageUpload.hasUploaded()){
				product.setImageFilename(uploadedFileUtil.storeFile(imageUpload.getImage(), product.getId().toString()));
				productDAO.update(product);
			}
		} catch (IOException e) {
			// TODO: Implementar regra de falha ao gravar imagem
			response = new JsonViewResponse( false, "Falha ao cadastrar o produto, verifique os campos obrigatórios e se a imagem está no formato válido.");
		}

		result.use(json()).from(response).serialize();
	}

	/**
	 * This method receive one File and save in Session  
	 * 
	 * @param product
	 * @param Filedata <-- Filedata this is default name on Uploadify JS plugin
	 * @throws IOException
	 */
	@Post
	@LoggedIn
	@Roles(roles = "ADMIN")
	@Path("/produtos/novo/upload-imagem")
	public void saveImage(Product product, UploadedFile Filedata) throws IOException {

		imageUpload.save(Filedata);
		result.use(json()).from(true).serialize();
	}

	@Get
	@LoggedIn
	@Roles(roles = "ADMIN")
	@Path("/produtos/listagem-admin")
	public void listProductsAdmin() {
		result.include("products", productDAO.paginatedList(FIRST_PAGE, QUANTITY_PER_PAGE));
	}

	@Post
	@LoggedIn
	@Roles(roles = "ADMIN")
	@Path("/produtos/listagem-admin")
	public void listProductsAdmin(final int page, final int quantityPerPage) {
		List<Product> products = productDAO.paginatedList(getPage(page, quantityPerPage), quantityPerPage);
		result.use(json()).from(products).recursive().serialize();
	}
	
	@Get
	@LoggedIn
	@Roles(roles = "ADMIN")
	@Path("/produtos/editar/{id}")
	public void edit(final long id) {
		result.include("product", productDAO.getById(id));
	}

}
