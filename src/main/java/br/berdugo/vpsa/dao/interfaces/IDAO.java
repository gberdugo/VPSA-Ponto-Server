package br.berdugo.vpsa.dao.interfaces;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface IDAO<T> {
	
	public Class<T> getPersistentClass();
	
	public T save(T entity);
	
	public List<T> listAll();
	
	public T findById(Long id);
	
	public void delete(Long id);
	
	public List<T> findByCriteria(DetachedCriteria criteria);
}
