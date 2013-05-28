package br.com.kwikemart.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.kwikemart.entity.AbstractEntity;

public class GenericDAO<T extends AbstractEntity> {

	private final Class<T> aClass;
	protected Session session;

	@SuppressWarnings("unchecked")
	public GenericDAO(Session session) {
		this.session = session;
		Class<T> aClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		this.aClass = aClass;
	}

	public Collection<T> all() {
		Query query = session.createQuery("from " + aClass.getName());

		@SuppressWarnings("unchecked")
		Collection<T> list = query.list();

		return list;
	}

	@SuppressWarnings("unchecked")
	public T find(Long id) {
		return (T) session.load(aClass, id);
	}

	public void remove(T entity) {
		session.delete(session.get(aClass, entity.getId()));
	}

	public void deleteAll() {
		Query query = session.createQuery("delete from " + aClass.getName());
		query.executeUpdate();
	}

	public Long save(T entity) {
		return (Long) session.save(entity);
	}

	public void saveOrUpdate(T entity) {
		session.saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	public T update(T entity) {
		// Transaction transaction = session.getTransaction();
		// transaction.begin();
		T merge = (T) session.merge(entity);
		// transaction.commit();
		return merge;
	}

}
