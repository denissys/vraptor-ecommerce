package br.com.kwikemart.dao;

import static org.hibernate.criterion.Restrictions.disjunction;
import static org.hibernate.criterion.Restrictions.eq;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.kwikemart.entity.User;

@Component
public class UserDAO {

    private Session session;

	public UserDAO(Session session) {
		this.session = session;
    }

	public User getById(Long id) {
		Criteria criteria = session.createCriteria(User.class, "user");
		criteria.add(eq("user.id", id));
		return (User) criteria.uniqueResult();
	}

	public Long save(User entity) {
		return (Long) session.save(entity);
	}

	public User update(User entity) {
		User merge = (User) session.merge(entity);
		return merge;
	}

	public User getByEmailOrCpf(final String email, final String cpf) {
		Criteria criteria = session.createCriteria(User.class, "user");
		criteria.add(disjunction()
		        		.add(eq("user.email", email))
		        		.add(eq("user.document", cpf)));
		User user = (User) criteria.uniqueResult();
		return user;
	}

	public User getByEmailAndPassword(final String email, final String password) {
		Criteria criteria = session.createCriteria(User.class, "user");
		criteria.add(eq("user.email", email));
		criteria.add(eq("user.password", password));
		criteria.setMaxResults(1);
		User user = (User) criteria.uniqueResult();

		return user != null ? user : new User();
	}

}
