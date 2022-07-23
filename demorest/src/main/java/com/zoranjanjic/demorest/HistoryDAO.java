package com.zoranjanjic.demorest;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HistoryDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(History.class)
			.buildSessionFactory();

	/* get query history from db with the matchin query parameter*/
	public List<History> getHistoryDB(String queryParam) {

		List<History> historyList = null;
		Session session = null;

		try {

			session = factory.getCurrentSession();

			session.beginTransaction();

			Query query = session.createQuery("FROM queryHistory WHERE queryParams LIKE :queryParam");

			query.setParameter("queryParam", "%" + queryParam + "%");

			historyList = query.getResultList();

		} catch (Exception e) {
			System.out.println("Error in getHistoryDB " + e.getLocalizedMessage());

		} finally {
			session.close();
		}

		return historyList;
	}
	
	
	
	/* save the query to the db */
	public void saveToHistoryDB(Date queryDate, String queryPath, Time queryTime, String queryParam) {

		Session session = null;

		try {

			History historyObj = new History(queryDate, queryPath, queryTime, queryParam);

			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(History.class)
					.buildSessionFactory();

			session = factory.getCurrentSession();

			session.beginTransaction();

			session.save(historyObj);

			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Error in getPersonsDB " + e.getLocalizedMessage());

		} finally {
			session.close();
		}

	}
}
