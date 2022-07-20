package com.zoranjanjic.demorest;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class PersonDAO {

	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Person.class)
			.buildSessionFactory();
	

	public List<Person> getPersonsDB(String number) {

		List<Person> personList = null;
		Session session = null;

		System.out.println("THE NUMBER IN DAO IS: " + number);

		try {

			session = factory.getCurrentSession();

			session.beginTransaction();

			Query query = session.createQuery("FROM persons WHERE phoneNumber LIKE :number").setMaxResults(10);

			query.setParameter("number", "%" + number + "%");
			

			personList = query.getResultList();
	

		} catch (Exception e) {
			System.out.println("Error in getPersonsDB " + e.getLocalizedMessage());
		} finally {
			session.close();
		}

		return personList;
	}

	public void updatePersonDB(Person updatedPerson) {
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		String personName = updatedPerson.getName();
		
		Person person = session.get(Person.class,personName);
		
		person = updatedPerson;
		
		session.getTransaction().commit();
		
		
	}

	public void deletePersonDB(String personName) {
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Person person = session.get(Person.class,personName);

		session.delete(person);
		
		session.getTransaction().commit();
		
	}

	public void addPersonDB(Person person) {
		
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		session.save(person);
		
		session.getTransaction().commit();
		
	}

}
