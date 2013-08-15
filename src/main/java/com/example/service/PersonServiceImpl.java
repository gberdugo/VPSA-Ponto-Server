package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.impl.CriteriaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

    @Transactional
    public void addPerson(Person person) {
        hibernateTemplate.save(person);
    }

    @Transactional
    public List<Person> listPeople() {
        return (List<Person>) hibernateTemplate.find("from " + Person.class.getName());
    }

    @Transactional
    public void removePerson(Integer id) {
        Person person = hibernateTemplate.get(Person.class, id);
        if (null != person) {
            hibernateTemplate.delete(person);
        }
    }   
}