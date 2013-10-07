package br.berdugo.vpsa.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import br.berdugo.vpsa.dao.interfaces.IDAO;

@SuppressWarnings("unchecked")
public abstract class BaseDAO<T> implements IDAO<T> {

	private static final Logger logger = Logger.getLogger(BaseDAO.class);
	
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
			return (T)this.sessionFactory.getCurrentSession().get(getPersistentClass(), id);
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
	
	@Override
	public List<T> findByCriteria(DetachedCriteria criteria) {
		try {
			Criteria crit = criteria.getExecutableCriteria(this.sessionFactory.getCurrentSession());
			
			return (List<T>) crit.list();
		} catch (Exception exception) {
			logger.error(exception);
		}
		
		return null;
	}
	
	@Override
	public T findOneByCriteria(DetachedCriteria criteria) {
		try {
			Criteria crit = criteria.getExecutableCriteria(this.sessionFactory.getCurrentSession());
			
			return (T) crit.uniqueResult();
		} catch (Exception exception) {
			logger.error(exception);
		}
		
		return null;
	}
}