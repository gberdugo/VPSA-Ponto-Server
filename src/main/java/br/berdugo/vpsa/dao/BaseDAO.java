package br.berdugo.vpsa.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.berdugo.vpsa.dao.interfaces.IDAO;

@SuppressWarnings("unchecked")
public abstract class BaseDAO<T> implements IDAO<T> {

	private static final Log logger = LogFactory.getLog(BaseDAO.class);
	
	private Class<T> persistentClass;
	
	@Autowired
	private SessionFactory sessionFactory;

	public BaseDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@Override
	public T save(T entity) {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(entity);
		} catch (Exception exception) {
			logger.error(exception);
		}
		
		return entity;
	}

	@Override
	public List<T> listAll() {
		try {
			return (List<T>)this.sessionFactory.getCurrentSession().createCriteria(getPersistentClass()).list();
		} catch (Exception exception) {
			logger.error(exception);
		}
		
		return null;
	}

	@Override
	public T findById(Long id) {
		try {
			return (T)this.sessionFactory.getCurrentSession().load(getPersistentClass(), id);
		} catch (Exception exception) {
			logger.error(exception);
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		try {
			this.sessionFactory.getCurrentSession().delete(findById(id));
		} catch (Exception exception) {
			logger.error(exception);
		}
	}
}
