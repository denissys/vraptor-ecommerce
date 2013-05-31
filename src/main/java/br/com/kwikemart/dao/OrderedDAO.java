package br.com.kwikemart.dao;

import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.caelum.vraptor.ioc.Component;
import br.com.kwikemart.entity.Ordered;
import br.com.kwikemart.enums.OrderStatus;

@Component
public class OrderedDAO {

    private Session session;

	public OrderedDAO(Session session) {
		this.session = session;
    }
    
	@SuppressWarnings("unchecked")
	public List<Ordered> getByUserId(final Long userId) {
		Criteria criteria = session.createCriteria(Ordered.class);
		criteria.add(eq("user.id", userId));
		criteria.addOrder(Order.asc("insertDate"));
		criteria.setMaxResults(30);
		return criteria.list();
    }

	@SuppressWarnings("unchecked")
	public List<Ordered> getByStatus(OrderStatus orderStatus) {
		Criteria criteria = session.createCriteria(Ordered.class);
		criteria.add(eq("status", orderStatus));
		criteria.addOrder(Order.asc("insertDate"));
		criteria.setMaxResults(30);
		return criteria.list();
	}
    
	public Long save(Ordered ordered) {
		return (Long) session.save(ordered);
	}

}
