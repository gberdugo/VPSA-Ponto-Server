package br.berdugo.vpsa.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.berdugo.vpsa.dao.interfaces.IDAO;

@SuppressWarnings("unchecked")
public abstract class BaseDAO<T> extends HibernateDaoSupport implements IDAO<T> {

	private static final Log logger = LogFactory.getLog(BaseDAO.class);
	
	private Class<T> persistenceClass;

	public BaseDAO() {
		this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public Class<T> getPersistenceClass() {
		return persistenceClass;
	}

	@Override
	public T save(T entity) {
		try {
			final Session session = getSession();
		
			session.saveOrUpdate(entity);
		} catch (Exception exception) {
			logger.error(exception);
		}
		
		return entity;
	}

	@Override
	public List<T> listAll() {
		try {
			final Session session = getSession();
		
			return (List<T>)session.createCriteria(getPersistenceClass()).list();
		} catch (Exception exception) {
			logger.error(exception);
		}
		
		return null;
	}

	@Override
	public T findById(Long id) {
		try {
			final Session session = getSession();
			
			return (T) session.load(persistenceClass, id);
		} catch (Exception exception) {
			logger.error(exception);
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		try {
			final Session session = getSession();
			
			session.delete(findById(id));
		} catch (Exception exception) {
			logger.error(exception);
		}
	}
}
