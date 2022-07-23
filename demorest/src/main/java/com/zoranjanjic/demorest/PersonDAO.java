package com.zoranjanjic.demorest;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class PersonDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class)
			.buildSessionFactory();

	public List<Person> getPersonsDB(String number) {

		List<Person> personList = null;
		Session session = null;

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

}
