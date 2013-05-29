package br.com.kwikemart.dao;

import static org.hibernate.criterion.Restrictions.eq;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.kwikemart.entity.UserAddress;

@Component
public class UserAddressDAO {

    private Session session;

	public UserAddressDAO(Session session) {
		this.session = session;
    }
    
	public UserAddress getByUserId(final Long userId) {
		Criteria criteria = session.createCriteria(UserAddress.class);
		criteria.add(eq("user.id", userId));
		return (UserAddress) criteria.uniqueResult();
    }
    
	public void saveOrUpdate(UserAddress userAddress) {
		session.saveOrUpdate(userAddress);
	}

}
