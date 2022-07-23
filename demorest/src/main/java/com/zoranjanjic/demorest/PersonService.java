package com.zoranjanjic.demorest;

import java.util.List;

public class PersonService {

	PersonDAO DAO = new PersonDAO();
	
	/* Get person with the matching number */
	public List<Person> getPersons(String number) {
	List<Person> personList = DAO.getPersonsDB(number);
		return personList;
	}


}
