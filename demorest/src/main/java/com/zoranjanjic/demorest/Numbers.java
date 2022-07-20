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
public class Numbers {
	// Object to interact with our service layer
	PersonService service = new PersonService();

	/* Get all person with the matching phone number */
	@GET
	@Path("/autocomplete")
	@Produces(MediaType.APPLICATION_JSON)

	public List getPersons(@QueryParam("query") String number) {
		
		List<Person> numbersList = service.getPersons(number);
		return numbersList;

	}

	/* Add a new person to the database */

	@POST
	@Path("/autocomplete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void postPersons(Person person) {

		service.addPerson(person);
	}

	/* Update a person */
	@PUT
	@Path("/autocomplete/{personId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateNumbers(@PathParam("personId") int personId, Person updatedPerson) {

		service.updatePerson(updatedPerson);
//		
	}

	/* Get query history */

	@GET
	@Path("/autocomplete/history")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHistory(@QueryParam("name") int personName) {
		return "Numbers history with the name of: " + personName;
	}

	/* Delete a person */

	@DELETE
	@Path("/autocomplete/{personName}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteNumbers(@PathParam("personName") String personName) {

		service.deleteBrand(personName);
	}

}


