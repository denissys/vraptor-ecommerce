package br.com.kwikemart.dao;

import static org.hibernate.criterion.Restrictions.eq;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.kwikemart.entity.Ordered;

@Component
public class OrderedDAO {

    private Session session;

	public OrderedDAO(Session session) {
		this.session = session;
    }
    
	public Ordered getByUserId(final Long userId) {
		Criteria criteria = session.createCriteria(Ordered.class);
		criteria.add(eq("user.id", userId));
		return (Ordered) criteria.uniqueResult();
    }
    
	public Long save(Ordered ordered) {
		return (Long) session.save(ordered);
	}

}
