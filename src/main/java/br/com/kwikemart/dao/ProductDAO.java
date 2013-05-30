package br.com.kwikemart.dao;

import static org.apache.commons.validator.GenericValidator.isBlankOrNull;
import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
		criteria.setCacheable(true);
		return (Product) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Product> getByName(final String name) {
		Criteria criteria = session.createCriteria(Product.class, "product");
		criteria.add(eq("product.name", name));
		criteria.setCacheable(true);
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
		criteria.setCacheable(true);
		return criteria.list();
	}

	public List<Product> paginatedList(int page, int quantityPerPage) {
		return paginatedList(page, quantityPerPage, null);
	}

	@SuppressWarnings("unchecked")
	public List<Product> paginatedList(int page, int quantityPerPage, String keyword) {

		// Verify CACHE HITS
		// SessionFactory sessionFactory = session.getSessionFactory();
		// sessionFactory.getStatistics().setStatisticsEnabled(true);

		Criteria criteria = session.createCriteria(Product.class, "product");
		if (!isBlankOrNull(keyword)) {
			criteria.add(Restrictions.like("product.name", "%" + keyword + "%"));
		}
		criteria.addOrder(Order.asc("product.name"));

		criteria.setFirstResult(page);
		criteria.setMaxResults(quantityPerPage);
		criteria.setCacheable(true);

		// Verify CACHE HITS
		// sessionFactory.getStatistics().logSummary();

		return criteria.list();
	}

}
