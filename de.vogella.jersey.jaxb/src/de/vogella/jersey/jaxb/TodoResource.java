package de.vogella.jersey.jaxb;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Path;

import de.vogella.jersey.jaxb.model.Todo;

@Path("/todo")
public class TodoResource {
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Todo getXML(){
		Todo todo = new Todo();
		todo.setSummary("This is my first todo");
		todo.setDescription("This is my first todo description");
		return todo;
	}
	
	@GET
	@Produces({ MediaType.TEXT_XML})
	public Todo getHTML(){
		Todo todo = new Todo();
		todo.setSummary("This is my first todo");
		todo.setDescription("This is my first todo description");
		return todo;
	}

}
