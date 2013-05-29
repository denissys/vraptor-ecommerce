package br.com.kwikemart.dao;

import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.caelum.vraptor.ioc.Component;
import br.com.kwikemart.entity.Product;

/**
 * @author Denis Santos
 */
@Component
public class ProductDAO {

    private Session session;

	public ProductDAO(Session session) {
		this.session = session;
    }

	public Product getById(final Long id) {
		Criteria criteria = session.createCriteria(Product.class, "product");
		criteria.add(eq("product.id", id));
		return (Product) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Product> getByName(final String name) {
		Criteria criteria = session.createCriteria(Product.class, "product");
		criteria.add(eq("product.name", name));
		return criteria.list();
    }
    
	public Long save(Product product) {
		return (Long) session.save(product);
	}

	public void update(Product product) {
		session.merge(product);
	}

	/**
	 * Get product list order by latest
	 * 
	 * @return List<Product>
	 */
	@SuppressWarnings("unchecked")
	public List<Product> featured() {
		Criteria criteria = session.createCriteria(Product.class, "product")
				.addOrder(Order.desc("product.insertDate"));
		criteria.setMaxResults(8);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Product> paginatedList(int page, int quantityPerPage) {
		Criteria criteria = session.createCriteria(Product.class, "product")
				.addOrder(Order.asc("product.name"));

		criteria.setFirstResult(page);
		criteria.setMaxResults(quantityPerPage);

		return criteria.list();
	}

}
