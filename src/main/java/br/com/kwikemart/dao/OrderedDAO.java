package br.com.kwikemart.dao;

import static br.com.kwikemart.enums.OrderStatus.IN_PROGRESS;
import static br.com.kwikemart.enums.OrderStatus.WAITING_FOR_RELEASE;
import static org.hibernate.criterion.Restrictions.eq;
import static org.hibernate.criterion.Restrictions.in;

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
    
	public Ordered getById(final Long id) {
		return (Ordered) session.createCriteria(Ordered.class).add(eq("id", id)).uniqueResult();
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
		criteria.setMaxResults(100);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Ordered> getLatest() {
		Criteria criteria = session.createCriteria(Ordered.class);
		criteria.add(in("status", new OrderStatus[] { IN_PROGRESS, WAITING_FOR_RELEASE }));
		criteria.addOrder(Order.asc("insertDate"));
		return criteria.list();
	}
    
	public Long save(Ordered ordered) {
		return (Long) session.save(ordered);
	}

	public void update(Ordered order) {
		session.merge(order);
	}

}
