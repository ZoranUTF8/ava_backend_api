package com.zoranjanjic.demorest;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;

// class level uri
@Path("/phone-numbers")
public class Routes {
	// Object to interact with our service layer
	PersonService service = new PersonService();
	HistoryService historyService = new HistoryService();

	/* Get all person with the matching phone number */
	@GET
	@Path("/autocomplete")
	@Produces(MediaType.APPLICATION_JSON)

	public List getPersons(@QueryParam("query") String number) {

		List<Person> numbersList = service.getPersons(number);

		return numbersList;

	}

	/* Get all query with with the matchin number */

	@GET
	@Path("/autocomplete/history")
	@Produces(MediaType.APPLICATION_JSON)

	public List getHistory(@QueryParam("query") String query) {

		List<History> historyListByName = historyService.getHistoryByNumber(query);

		return historyListByName;

	}
}
