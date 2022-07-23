package com.zoranjanjic.demorest;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HistoryDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(History.class)
			.buildSessionFactory();

	public List<History> getHistoryDB(String personName) {

		List<History> historyList = null;
		Session session = null;

		try {

			session = factory.getCurrentSession();

			session.beginTransaction();

			Query query = session.createQuery("FROM queryHistory WHERE personName LIKE :personName");

			query.setParameter("personName", "%" + personName + "%");

			historyList = query.getResultList();

		} catch (Exception e) {
			System.out.println("Error in getHistoryDB " + e.getLocalizedMessage());

		} finally {
			session.close();
		}

		return historyList;
	}

	public void saveToHistoryDB(String personName, String personNumber, String queryDate, String queryPath,
			String queryTime, String queryParams) {
		
		
		
		Session session = null;

		
		try {


			History historyObj = new History(personName, personNumber, queryDate, queryPath, queryTime, queryParams);
			
			
			
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(History.class)
					.buildSessionFactory();

			session = factory.getCurrentSession();

			session.beginTransaction();

			session.save(historyObj);
			
			session.getTransaction().commit();
			
			System.out.println("SAVED "+historyObj);

		} catch (Exception e) {
			System.out.println("Error in getPersonsDB " + e.getLocalizedMessage());

		} finally {
			session.close();
		}

	}
}
