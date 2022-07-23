package com.zoranjanjic.demorest;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class HistoryService {

	HistoryDAO DAO = new HistoryDAO();

	/* Get person history list with the matching number */
	public List<History> getHistoryByNumber(String queryParam) {
		
		List<History> historyList = DAO.getHistoryDB(queryParam);
		
		return historyList;
	}

	/* Add the query to the db*/
	public void saveHistoryToDb(Date queryDate, String queryPath, Time queryTime, String queryParam) {

		DAO.saveToHistoryDB(queryDate, queryPath, queryTime, queryParam);
	}

}
