package com.zoranjanjic.demorest;

import java.util.List;

public class HistoryService {

	HistoryDAO DAO = new HistoryDAO();

	/* Get person with the matching number */
	public List<History> getHistoryByName(String personName) {
		List<History> historyList = DAO.getHistoryDB(personName);
		return historyList;
	}

	public void saveHistoryToDb(String personName, String personNumber, String queryDate, String queryPath,
			String queryTime, String queryParams) {
		
	
		
		DAO.saveToHistoryDB(personName, personNumber, queryDate, queryPath, queryTime, queryParams);
	}

}
